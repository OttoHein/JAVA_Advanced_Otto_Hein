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
	
	@Autowired
	RetrieveQuotes retrieveQuotes;
	
	private JFrame jFrame;
	private JPanel controlPanel;
    private JButton btnQuotesToDatabase, btnRetrieveQuotes;
    private JTextField txtOutput;
    
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
		
		btnRetrieveQuotes = new JButton();
		btnRetrieveQuotes.setText("Show me the saved quotes");
		btnRetrieveQuotes.setTransferHandler(new TransferHandler("text"));
		btnRetrieveQuotes.addActionListener(retrieveQuotes::whenButtonClicked);
		
		txtOutput = new JTextField();
		txtOutput.setText("No output yet");

		controlPanel.add(btnQuotesToDatabase);
		controlPanel.add(btnRetrieveQuotes);
		
		jFrame.add(txtOutput);
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

	public JTextField getLblOutput() {
		return txtOutput;
	}

	public void setLblOutput(JTextField txtOutput) {
		this.txtOutput = txtOutput;
	}
    
    
    
}
