package HNS.client.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import HNS.client.ClientUtils;
import HNS.client.ICardControls;
import HNS.server.ServerThread;

public class UserListPanel extends JPanel {
    JPanel userListArea;
    JPanel wrapper;
    private static Logger logger = Logger.getLogger(UserListPanel.class.getName());


    

    public UserListPanel(ICardControls controls) {
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
        // scroll.setBorder(BorderFactory.createEmptyBorder());
        // no need to add content specifically because scroll wraps it

        userListArea = content;
        this.wrapper = wrapper;
        wrapper.add(scroll);
        this.add(wrapper, BorderLayout.CENTER);

        

        userListArea.addContainerListener(new ContainerListener() {

            @Override
            public void componentAdded(ContainerEvent e) {
                if (userListArea.isVisible()) {
                    userListArea.revalidate();
                    userListArea.repaint();
                }
            }

            @Override
            public void componentRemoved(ContainerEvent e) {
                if (userListArea.isVisible()) {
                    userListArea.revalidate();
                    userListArea.repaint();
                }
            }

        });
    }

    protected void resizeUserListItems() {
        for (Component p : userListArea.getComponents()) {
            if (p.isVisible()) {
                p.setPreferredSize(
                        new Dimension(wrapper.getWidth(), ClientUtils.calcHeightForText(this,
                                ((JEditorPane) p).getText(), wrapper.getWidth())));
                p.setMaximumSize(p.getPreferredSize());
            }
        }
        userListArea.revalidate();
        userListArea.repaint();
    }

    ServerThread serverThread = new ServerThread();

    List<String> myList = serverThread.getMyList();


    










    protected void addUserListItem(long clientId, String clientName) {
        
        logger.log(Level.INFO, "Adding user to list: " + clientName);
        JPanel content = userListArea;
        logger.log(Level.INFO, "Userlist: " + content.getSize());
        JEditorPane textContainer = new JEditorPane("text/plain", clientName);
        textContainer.setName(clientId + "" + clientName);
        // sizes the panel to attempt to take up the width of the container
        // and expand in height based on word wrapping
        textContainer.setLayout(null);
        textContainer.setPreferredSize(
                new Dimension(content.getWidth(), ClientUtils.calcHeightForText(this, clientName, content.getWidth())));
        textContainer.setMaximumSize(textContainer.getPreferredSize());
        textContainer.setEditable(false);
        // remove background and border (comment these out to see what it looks like
        // otherwise)
        
        setMuted(clientName);
        ClientUtils.clearBackground(textContainer);
        // add to container
        content.add(textContainer);
    }

    public void setMuted(String clientName) {
        Component[] cs = userListArea.getComponents();
        for (Component c : cs) {
                for (String str : myList) {
                    if (str.equals(c)) {
                        this.setBackground(Color.GRAY);
                    }
                }
            
        }
    }

    public void setLastUser(String clientName) {
        Component[] cs = userListArea.getComponents();
        for (Component c : cs) {

    }
    }


    protected void removeUserListItem(long clientId) {
        logger.log(Level.INFO, "removing user list item for id " + clientId);
        Component[] cs = userListArea.getComponents();
        for (Component c : cs) {
            if (c.getName().equals(clientId + "")) {
                userListArea.remove(c);
                break;
            }
        }
    }

    protected void clearUserList() {
        Component[] cs = userListArea.getComponents();
        for (Component c : cs) {
            userListArea.remove(c);
        }
    }
}
