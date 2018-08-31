package edu.ap.spring.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;

@Component
public class UI {
	
	private JFrame jFrame;
	//private JLabel label1, label2;
	private JTextField userName;
	private JPasswordField userPass;
	private JPanel controlPanel;
    private JButton btnAddUser;
    
    public UI() {}
    
    public void setupUI() {
	    	jFrame = new JFrame("Spring JFrame");
	    	jFrame.setLayout(new FlowLayout());
	    	
	    	controlPanel = new JPanel();
	    controlPanel.setLayout(new GridLayout(3, 2));

		/*label1 = new JLabel("User Name : ");
		userName = new JTextField(15);
		userName.setDragEnabled(true);
		
		label2 = new JLabel("Password : ");
		userPass = new JPasswordField(15);*/

		btnAddUser = new JButton();
		btnAddUser.setText("Add quotes to database");
		btnAddUser.setTransferHandler(new TransferHandler("text"));
		//btnAddUser.addActionListener(eventHandler::whenButtonClicked);

		//controlPanel.add(label1);
		controlPanel.add(userName);
		//controlPanel.add(label2);
		controlPanel.add(userPass);
		controlPanel.add(btnAddUser);

		jFrame.add(controlPanel);
		        
		jFrame.setSize(400, 400);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);
    }

    public JFrame getjFrame() {
        return this.jFrame;
    }
    
    public JTextField getUserName() {
    		return this.userName;
    }
    
    public JPasswordField getPassword() {
		return this.userPass;
    }

    public JButton getButton() {
        return btnAddUser;
    }
    
}
