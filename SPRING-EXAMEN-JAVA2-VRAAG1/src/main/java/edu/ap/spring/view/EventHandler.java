package edu.ap.spring.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ap.spring.jpa.Quote;
import edu.ap.spring.jpa.QuoteRepository;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
public class EventHandler {

    private UI ui;
    private QuoteRepository repository;
    
    @Autowired
    public void setRepository(QuoteRepository repository) {
    		this.repository = repository;
    }
    
    @Autowired
    public void setUI(UI ui) {
    		this.ui = ui;
    }

    public void whenButtonClicked(ActionEvent actionEvent) {
    	
        // The name of the file to open.
        String fileName = "oscar_wilde.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	Quote quote = new Quote();
            	quote.setText(line);
                repository.save(quote);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }

        System.out.println("Quotes saved in repository");
        System.out.println("Find all : ") ;
        repository.findAll().forEach(System.out::println);
        
        
    }
}
