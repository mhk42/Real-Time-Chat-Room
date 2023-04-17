package HNS.server;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import HNS.common.Constants;

public class Room implements AutoCloseable {
    // server is a singleton now so we don't need this
    // protected static Server server;// used to refer to accessible server
    // functions
    private String name;
    private List<ServerThread> clients = new ArrayList<ServerThread>();
    private boolean isRunning = false;
    // Commands
    private final static String COMMAND_TRIGGER = "/";
    private final static String CREATE_ROOM = "createroom";
    private final static String JOIN_ROOM = "joinroom";
    private final static String DISCONNECT = "disconnect";
    private final static String LOGOUT = "logout";
    private final static String LOGOFF = "logoff";
    //private final static String FLIP = "flip";
    //private final static String ROLL = "roll";
    private static Logger logger = Logger.getLogger(Room.class.getName());

    public Room(String name) {
        this.name = name;
        isRunning = true;
    }

    public String getName() {
        return name;
    }

    public boolean isRunning() {
        return isRunning;
    }

    protected synchronized void addClient(ServerThread client) {
        if (!isRunning) {
            return;
        }
        client.setCurrentRoom(this);
        if (clients.indexOf(client) > -1) {
            logger.warning("Attempting to add client that already exists in room");
        } else {
            clients.add(client);
            client.sendResetUserList();
            syncCurrentUsers(client);
            sendConnectionStatus(client, true);
        }
    }

    protected synchronized void removeClient(ServerThread client) {
        if (!isRunning) {
            return;
        }
        // attempt to remove client from room
        try {
            clients.remove(client);
        } catch (Exception e) {
            logger.severe(String.format("Error removing client from room %s", e.getMessage()));
            e.printStackTrace();
        }
        // if there are still clients tell them this person left
        if (clients.size() > 0) {
            sendConnectionStatus(client, false);
        }
        checkClients();
    }

    private void syncCurrentUsers(ServerThread client) {
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread existingClient = iter.next();
            if (existingClient.getClientId() == client.getClientId()) {
                continue;// don't sync ourselves
            }
            boolean messageSent = client.sendExistingClient(existingClient.getClientId(),
                    existingClient.getClientName());
            if (!messageSent) {
                handleDisconnect(iter, existingClient);
                break;// since it's only 1 client receiving all the data, break if any 1 send fails
            }
        }
    }

    /***
     * Checks the number of clients.
     * If zero, begins the cleanup process to dispose of the room
     */
    private void checkClients() {
        // Cleanup if room is empty and not lobby
        if (!name.equalsIgnoreCase(Constants.LOBBY) && (clients == null || clients.size() == 0)) {
            close();
        }
    }

    /***
     * Helper function to process messages to trigger different functionality.
     * 
     * @param message The original message being sent
     * @param client  The sender of the message (since they'll be the ones
     *                triggering the actions)
     */
    @Deprecated // not used in my project as of this lesson, keeping it here in case things
                // change
    private boolean processCommands(String message, ServerThread client) {
        boolean wasCommand = false;
        try {
            if (message.startsWith(COMMAND_TRIGGER)) {
                String[] comm = message.split(COMMAND_TRIGGER);
                String part1 = comm[1];
                String[] comm2 = part1.split(" ");
                String command = comm2[0];
                String roomName;
                wasCommand = true;
                switch (command) {
                    case CREATE_ROOM:
                        roomName = comm2[1];
                        Room.createRoom(roomName, client);
                        break;
                    case JOIN_ROOM:
                        roomName = comm2[1];
                        Room.joinRoom(roomName, client);
                        break;
                    case DISCONNECT:
                    case LOGOUT:
                    case LOGOFF:
                        Room.disconnectClient(client, this);
                        break;

                    //mhk42 3/30/2023, included a new case for the flip command which calls the flipCommmand method.
                    //case FLIP:
                     //   Room.flipCommand(client);
                      //  break;

                    //mhk42 3/30/2023, new case for ROLL command, here it checks whether or not the command contains
                    // the letter d, then calls the methods respectively
                   /*  case ROLL:
                        String rollValue;
                        if (comm2[1].contains("d")) 
                        {
                            rollValue = comm2[1];
                            specialRollCommand(client, rollValue);
                            break;
                            
                        } 
                        else 
                        {
                            rollValue = comm2[1];
                            defaultRollCommand(client, rollValue);
                            break;
                        }*/
                        
                    default:
                        wasCommand = false;
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wasCommand;
    }

    // Command helper methods
    protected static void getRooms(String query, ServerThread client) {
        String[] rooms = Server.INSTANCE.getRooms(query).toArray(new String[0]);
        client.sendRoomsList(rooms,
                (rooms != null && rooms.length == 0) ? "No rooms found containing your query string" : null);
    }

    protected static void createRoom(String roomName, ServerThread client) {
        if (Server.INSTANCE.createNewRoom(roomName)) {
            Room.joinRoom(roomName, client);
        } else {
            client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("Room %s already exists", roomName));
        }
    }

    /**
     * Will cause the client to leave the current room and be moved to the new room
     * if applicable
     * 
     * @param roomName
     * @param client
     */
    protected static void joinRoom(String roomName, ServerThread client) {
        if (!Server.INSTANCE.joinRoom(roomName, client)) {
            client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("Room %s doesn't exist", roomName));
        }
    }

    protected static void disconnectClient(ServerThread client, Room room) {
        client.disconnect();
        room.removeClient(client);
    }

    //mhk42 4/12/2023 Using math.random, it generetes a number between 0 and 1, 0 for heads, 1 for tails
    // the result is then put into the finalResult string and returns it.
    protected static String flipCommand(String val)
    {
        int flip = (int)Math.random() * 2;
        String result;
        if(flip == 0)
        {
            result = "heads";

        }
        else
        {
            result ="tails";
        }
        String finalResult = " flipped a coin and got " + result;
        
        return finalResult;
    }


    //mhk42 4/12/2023, the "/roll" is removed from the message
    //then two cases are created for the two formats, the value is put into result, and then into the finalResult
    protected static String finalRollCommand(String message) 
    {
        String rollValue = message.substring(6).trim();
        int result = 0;
        String finalResult;
    
        if (rollValue.contains("d")) 
        {
            String[] split = rollValue.split("d");
            int mininum = Integer.parseInt(split[0]);
            int maximumNumber = Integer.parseInt(split[1]);
            for (int i = 0; i < mininum; i++) {
                result += (int)(Math.random() * maximumNumber) + 1;
            }
        } 
        else
        {
            int maximumNumber = Integer.parseInt(rollValue);
            result = (int) (Math.random() * maximumNumber) + 1;
        }
    
        finalResult = " rolled and got " + result;
        return finalResult;
    }



    //mhk42 3/30/2023, since the rollValue is a string, it will convert it to an int then use math.random
    // to generate the number the user asked for, then the Server displays who rolled and what number they got.
   /* protected static void defaultRollCommand(ServerThread client, String rollValue)
    {
        int result = 0;
        String finalResult;

        int maximumNumber = Integer.parseInt(rollValue);

        result = (int) (Math.random() * maximumNumber) + 1;

        finalResult = client.getClientName() + " rolled and got " + result;

        client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format(finalResult));
    } */

    
    //mhk42 3/30/2023, the specialrollcommand is when it includes the letter "d",
    // the letter d is split, and the first and last ints are used to determine the roll value
    // The server then prints, who rolled it and what number they got
  /*  protected static void specialRollCommand(ServerThread client, String rollValue)
    {
        int result = 0;
        String finalResult;
        
        String[] split = rollValue.split("d");

        int mininum = Integer.parseInt(split[0]);

        int maximumNumber = Integer.parseInt(split[1]);

        for (int i = 0; i < mininum; i++) {
            result += (int)(Math.random() * maximumNumber) + 1;
        }

        finalResult = client.getClientName() + " rolled and got " + result;

        client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format(finalResult));
    }*/


    //mhk42 3/31/2023, depending on the special tags, the replaceAll will change 
    //the text between the tags to the corresponding HTML tags that represent the desired style
   /*  public static String changeStyle(String message) {
        
        message = message.replaceAll("&b(.*?)&b", "<b>$1</b>");
        
        message = message.replaceAll("&I(.*?)&I", "<i>$1</i>");
       
        message = message.replaceAll("&u(.*?)&u", "<u>$1</u>");
        
        message = message.replaceAll("&R(.*?)&R", "<font color='red'>$1</font>");
        
        message = message.replaceAll("&B(.*?)&B", "<font color='blue'>$1</font>");
        
        message = message.replaceAll("&G(.*?)&G", "<font color='green'>$1</font>");
    
        return message;
    }*/
    
    

    // end command helper methods

    /***
     * Takes a sender and a message and broadcasts the message to all clients in
     * this room. Client is mostly passed for command purposes but we can also use
     * it to extract other client info.
     * 
     * @param sender  The client sending the message
     * @param message The message to broadcast inside the room
     */


     //mhk42 4/12/23, sendMessage is modified to detect if the code starts with either
     //"flip" or "roll" and calls the methods associated with them.
     protected synchronized void sendMessage(ServerThread sender, String message) {
        if (!isRunning) {
            return;
        }
        logger.info(String.format("Sending message to %s clients", clients.size()));
        if (sender != null && processCommands(message, sender)) {
            // it was a command, don't broadcast
            return;
        }
        long from = sender == null ? Constants.DEFAULT_CLIENT_ID : sender.getClientId();
        Iterator<ServerThread> iter = clients.iterator();
        String changedText = message;
        


        //mhk42, 4/13/23 checks if the message with "@" symbol. If it does, it takes the reciever's name and message 
        //and then sends the message only to the mentioned user user.
        if (message.startsWith("@")) {

            int i = message.indexOf(" ");
            String receiver = message.substring(1, i);
            String secretMessage = message.substring(i + 1);
                for (int j = 0; j < clients.size(); j++) {
                ServerThread client = clients.get(j);
                if (client.getClientName().equals(receiver)) {
                    boolean sent = client.sendMessage(from, secretMessage);
                    if (!sent) 
                    {
                         handleDisconnect(iter, client);
                    }
                    break;
                    }
                }
        
                if (sender != null) {
                    sender.sendMessage(from, secretMessage);
                }
                return; 
        }

        //mhk42 4/16/2023, A user can mute or unmute another user.
        //Users' messages who have been muted by a specific user will not be shown to the specifc user ONLY.
        //All of the other clients can see the messages.
        else if (message.startsWith("/mute")) {
            int i = message.indexOf(" ");
            String mutedUser = message.substring(i + 1);
            for (int j = 0; j < clients.size(); j++) {
                ServerThread client = clients.get(j);
                if (client.getClientName().equals(sender.getClientName())) {
                    client.addMute(mutedUser);
                    for (int k = 0; k < clients.size(); k++) {
                         ServerThread mutedClient = clients.get(k);
                        if (mutedClient.getClientName().equals(mutedUser)) {
                            mutedClient.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("%s muted you", sender.getClientName()));
                            break;
                        }
                    }
                    return;
                    }
                }
        }
        else if (message.startsWith("/unmute"))
         {
            int i = message.indexOf(" ");
            String unmutedUser = message.substring(i + 1);
            for (int j = 0; j < clients.size(); j++) {
                ServerThread client = clients.get(j);
                if (client.getClientName().equals(sender.getClientName())) {
                    client.removeMute(unmutedUser);
                    for (int k = 0; k < clients.size(); k++) {
                        ServerThread unmutedClient = clients.get(k);
                        if (unmutedClient.getClientName().equals(unmutedUser)) {
                            unmutedClient.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("%s unmuted you", sender.getClientName()));
                            break;
                        }
                    }
                    return;
                    }
                }
        }

        else if(message.startsWith("/flip")) 
        {
            changedText = message;
            message = flipCommand(changedText);
        } else if(message.startsWith("/roll")) 
        {
            changedText = message;
            message = finalRollCommand(changedText);
        }
        while (iter.hasNext()) {
            ServerThread client = iter.next();
            if (sender != null && client.isMuted(sender.getClientName())) {
                continue;
            }
            boolean messageSent = client.sendMessage(from, message);
            if (!messageSent) {
                handleDisconnect(iter, client);
            }
        }

    }

    protected synchronized void sendConnectionStatus(ServerThread sender, boolean isConnected) {
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread receivingClient = iter.next();
            boolean messageSent = receivingClient.sendConnectionStatus(
                    sender.getClientId(),
                    sender.getClientName(),
                    isConnected);
            if (!messageSent) {
                handleDisconnect(iter, receivingClient);
            }
        }
    }

    private void handleDisconnect(Iterator<ServerThread> iter, ServerThread client) {
        iter.remove();
        logger.info(String.format("Removed client %s", client.getClientName()));
        sendMessage(null, client.getClientName() + " disconnected");
        checkClients();
    }

    public void close() {
        Server.INSTANCE.removeRoom(this);
        isRunning = false;
        clients.clear();
    }
}
