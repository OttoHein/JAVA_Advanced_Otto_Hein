package edu.ap.spring.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;

@Component
public class UI {
	
	@Autowired
	EventHandler eventHandler;
	
	private JFrame jFrame;
	private JPanel controlPanel;
    private JButton btnQuotesToDatabase;
    
    public UI() {}
    
    public void setupUI() {
    	jFrame = new JFrame("Spring JFrame");
    	jFrame.setLayout(new FlowLayout());
	    	
	    controlPanel = new JPanel();
	    controlPanel.setLayout(new GridLayout(3, 2));

		btnQuotesToDatabase = new JButton();
		btnQuotesToDatabase.setText("Add quotes to database");
		btnQuotesToDatabase.setTransferHandler(new TransferHandler("text"));
		btnQuotesToDatabase.addActionListener(eventHandler::whenButtonClicked);

		controlPanel.add(btnQuotesToDatabase);

		jFrame.add(controlPanel);
		        
		jFrame.setSize(1000, 1000);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);
    }

    public JFrame getjFrame() {
        return this.jFrame;
    }
    
    public JButton getButton() {
        return btnQuotesToDatabase;
    }
    
}
