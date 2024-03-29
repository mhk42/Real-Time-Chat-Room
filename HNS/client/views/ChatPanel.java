package HNS.client.views;

import java.awt.Adjustable;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import HNS.client.Card;
import HNS.client.Client;
import HNS.client.ClientUtils;
import HNS.client.ICardControls;


public class ChatPanel extends JPanel {
    private static Logger logger = Logger.getLogger(ChatPanel.class.getName());
    private JPanel chatArea = null;
    private JPanel wrapper = null;
    private UserListPanel userListPanel;
    private Dimension lastSize = new Dimension();


    List<String> messageHistory = new ArrayList<>();

    public ChatPanel(ICardControls controls) {
        super(new BorderLayout(10, 10));
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS));
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        
        // wraps a viewport to provide scroll capabilities
        JScrollPane scroll = new JScrollPane(content);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        // no need to add content specifically because scroll wraps it
        wrapper.add(scroll);
        this.add(wrapper, BorderLayout.CENTER);
        
        JPanel input = new JPanel();
        input.setLayout(new BoxLayout(input, BoxLayout.X_AXIS));
        JTextField textValue = new JTextField();
        input.add(textValue);
        JButton button = new JButton("Send");
        input.add(button);
        JButton downloadButton = new JButton("Download");

        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new JFileChooser to allow the user to select a file to save the chat history in HTML
                JFileChooser selectFile = new JFileChooser();
                int select = selectFile.showSaveDialog(null);
                if (select == JFileChooser.APPROVE_OPTION) {
                    // If the user selected a file, create a new file with the .html extension and write the chat history to it
                    File fileToSave = selectFile.getSelectedFile();
                    fileToSave = new File(fileToSave.getAbsolutePath() + ".html");
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
                        for (String saveMessage : messageHistory) {
                            // Write each message in HTML format
                            writer.write("<p>" + saveMessage + "</p>");
                            writer.write(System.lineSeparator()); // add this line to write a newline after each message
                        }

                    } catch (IOException ex) {
                        ex.getMessage();
                    }
                }
            }
        });
        
        input.add(downloadButton);
        
    
        
        ////mhk42 4/12/23, When the user presses the enter key while typing in textValue. 
        //it will automatically click on the send button.

        textValue.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    button.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });
        button.addActionListener((event) -> {
            try {
                String text = textValue.getText().trim();
                if (text.length() > 0) {
                    Client.INSTANCE.sendMessage(text);
                    textValue.setText("");// clear the original text

                    // debugging
                    logger.log(Level.INFO, "Content: " + content.getSize());
                    logger.log(Level.INFO, "Parent: " + this.getSize());

                }
            } catch (NullPointerException e) {
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        chatArea = content;
        this.wrapper = wrapper;
        input.add(button);
        userListPanel = new UserListPanel(controls);
        this.add(userListPanel, BorderLayout.EAST);
        this.add(input, BorderLayout.SOUTH);
        this.setName(Card.CHAT.name());
        controls.addPanel(Card.CHAT.name(), this);
        chatArea.addContainerListener(new ContainerListener() {

            @Override
            public void componentAdded(ContainerEvent e) {
                if (chatArea.isVisible()) {
                    chatArea.revalidate();
                    chatArea.repaint();
                    /**
                     * Note: with the setValue(maxValue) it seemed to have a gap.
                     * The gap would cut off the last message.
                     * The updated logic below from https://stackoverflow.com/a/34086741
                     * solves this.
                     */
                    JScrollBar vertical = ((JScrollPane) chatArea.getParent().getParent()).getVerticalScrollBar();
                    AdjustmentListener scroller = new AdjustmentListener() {
                        @Override
                        public void adjustmentValueChanged(AdjustmentEvent e) {
                            Adjustable adjustable = e.getAdjustable();
                            adjustable.setValue(vertical.getMaximum());
                            // We have to remove the listener, otherwise the
                            // user would be unable to scroll afterwards
                            vertical.removeAdjustmentListener(this);
                        }

                    };
                    vertical.addAdjustmentListener(scroller);

                }
            }

            @Override
            public void componentRemoved(ContainerEvent e) {
                if (chatArea.isVisible()) {
                    chatArea.revalidate();
                    chatArea.repaint();
                }
            }

        });
        wrapper.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {

                super.componentShown(e);
                logger.log(Level.INFO, "Component shown");

                doResize();
            }

            @Override
            public void componentResized(ComponentEvent e) {
                // System.out.println("Resized to " + e.getComponent().getSize());
                // rough concepts for handling resize
                // set the dimensions based on the frame size
                doResize();
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                // System.out.println("Moved to " + e.getComponent().getLocation());
            }
        });
    }

    private void doResize() {
        if (!this.isVisible()) {
            return;
        }
        Dimension frameSize = wrapper.getSize();
        int deltaX = Math.abs(frameSize.width - lastSize.width);
        int deltaY = Math.abs(frameSize.height - lastSize.height);
        if (deltaX >= 5 || deltaY >= 5) {
            lastSize = frameSize;

            logger.info("Wrapper size: " + frameSize);
            int w = Math.max((int) Math.ceil(frameSize.getWidth() * .3f), 30);

            userListPanel.setMinimumSize(new Dimension(w, (int) frameSize.getHeight()));
            userListPanel.setPreferredSize(userListPanel.getMinimumSize());
            userListPanel.revalidate();
            userListPanel.repaint();
            w = Math.max((int) Math.ceil(frameSize.getWidth() * .7f), 100);
            // preferred size was preventing it from growing with its children
            // chatArea.setPreferredSize(new Dimension(w, (int) Short.MAX_VALUE));
            chatArea.setMinimumSize(new Dimension(w, (int) frameSize.getHeight()));
            userListPanel.resizeUserListItems();
            resizeMessages();
            // scroll down on new message
            JScrollBar vertical = ((JScrollPane) chatArea.getParent().getParent()).getVerticalScrollBar();
            vertical.setValue(vertical.getMaximum());
        }
    }

    private void resizeMessages() {
        for (Component p : chatArea.getComponents()) {
            if (p.isVisible()) {
                p.setPreferredSize(
                        new Dimension(wrapper.getWidth(), ClientUtils.calcHeightForText(this,
                                ((JEditorPane) p).getText(), wrapper.getWidth())));
                p.setMaximumSize(p.getPreferredSize());
            }
        }
        chatArea.revalidate();
        chatArea.repaint();
    }

    public void addUserListItem(long clientId, String clientName) {
        userListPanel.addUserListItem(clientId, clientName);
    }

    public void removeUserListItem(long clientId) {
        userListPanel.removeUserListItem(clientId);
    }

    public void clearUserList() {
        userListPanel.clearUserList();
    }

    public void addText(String text) {
        JPanel content = chatArea;
        // add message
        JEditorPane textContainer = new JEditorPane();
        textContainer.setContentType("text/html");


       



        //mhk42, 4/12/23, the text is put into a method and checks if the text contains
        //specific text, and if its true, then it makes the text bold.
        //the changeStyle method is for if the user makes the text bold, italic, underline, and a different color
        //and does not interfere with the roll and flip command.

        //if statement checks if its true or false;
        if (RollOrFlip(text)) 
        {
            //if true, then it makes the text bold a
            textContainer.setText("<b>" + text + "</b>");
        } 
        else
        {
            //if false, then plain text is printed
            textContainer.setText(changeStyle(text));
        }

        
        messageHistory.add(changeStyle(text));


    
        // sizes the panel to attempt to take up the width of the container
        // and expand in height based on word wrapping
        textContainer.setLayout(null);
        textContainer.setPreferredSize(
                new Dimension(content.getWidth(), ClientUtils.calcHeightForText(this, text, content.getWidth())));
        textContainer.setMaximumSize(textContainer.getPreferredSize());
        textContainer.setEditable(false);
        ClientUtils.clearBackground(textContainer);
        // add to container and tell the layout to revalidate
        content.add(textContainer);
        // scroll down on new message
        JScrollBar vertical = ((JScrollPane) chatArea.getParent().getParent()).getVerticalScrollBar();
        vertical.setValue(vertical.getMaximum());
    }
    




    //mhk42, 4/12/2023, checks if the message contains the specifc text for the
    //roll and flip command and returns either true or false
    private boolean RollOrFlip(String message)
    {
        return message.contains("rolled and got") || message.contains("flipped a coin and got");
    }




    public String changeStyle(String message) {
        
        message = message.replaceAll("&b(.*?)&b", "<b>$1</b>");
        
        message = message.replaceAll("&I(.*?)&I", "<i>$1</i>");
       
        message = message.replaceAll("&u(.*?)&u", "<u>$1</u>");
        
        message = message.replaceAll("&R(.*?)&R", "<font color='red'>$1</font>");
        
        message = message.replaceAll("&B(.*?)&B", "<font color='blue'>$1</font>");
        
        message = message.replaceAll("&G(.*?)&G", "<font color='green'>$1</font>");
    
        return message;
    }
    

}