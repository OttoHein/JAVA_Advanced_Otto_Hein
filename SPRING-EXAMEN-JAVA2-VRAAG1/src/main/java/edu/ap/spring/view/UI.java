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
	
	@Autowired
	Search search;
	
	private JFrame jFrame;
	private JPanel controlPanel;
    private JButton btnQuotesToDatabase, btnRetrieveQuotes, btnSearch;
    private JTextField txtOutput, txtResult;
    
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
		
		btnSearch = new JButton();
		btnSearch.setText("Search for this");
		btnSearch.setTransferHandler(new TransferHandler("text"));
		btnSearch.addActionListener(search::whenButtonClicked);
		
		txtOutput = new JTextField();
		txtOutput.setText("No output yet");
		
		txtResult = new JTextField();

		controlPanel.add(btnQuotesToDatabase);
		controlPanel.add(btnRetrieveQuotes);
		controlPanel.add(txtResult);
		controlPanel.add(btnSearch);
		
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

	public JTextField getTxtResult() {
		return txtResult;
	}

	public void setTxtResult(JTextField txtResult) {
		this.txtResult = txtResult;
	}
    
    
    
}
