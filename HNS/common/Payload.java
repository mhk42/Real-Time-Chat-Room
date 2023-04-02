package HNS.common;


import java.io.Serializable;


public class Payload implements Serializable {
    // read https://www.baeldung.com/java-serial-version-uid
    private static final long serialVersionUID = 1L;



    //mhk42 4/1/2023, used to store the type of payload associated with a particular message
    // the getter and setter methods are used to set and receive the payloadtype.
    private PayloadType payloadType;

    public PayloadType getPayloadType() {
        return payloadType;
    }


    public void setPayloadType(PayloadType payloadType) {
        this.payloadType = payloadType;
    }


  



    //mhk42 4/1/2023, used to store the name of the client who is sending a message
    // the getter and setter methods are used to set and receive the client's name.
    private String clientName;

    public String getClientName() {
        return clientName;
    }


    public void setClientName(String clientName) {
        this.clientName = clientName;
    }



    //mhk42 4/1/2023, used to store the unique identifier of the client who is sending a message
    // the getter and setter methods are used to set and receive the client's ID.
    private long clientId;

    public long getClientId() {
        return clientId;
    }


    public void setClientId(long clientId) {
        this.clientId = clientId;
    }


 


    //mhk42 4/1/2023, used to store the content of a message
    //the getter and setter methods are used to set and receive the client's message.
    private String message; 
    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }




    //mhk42 4/1/2023, used to display the payload object, that includes the message and the client that sent it.
    @Override
    public String toString() {
        return String.format("Payload { message: \"%s\", sender: \"%s\"}", message, clientName);
    }
}
