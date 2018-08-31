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
public class Search {

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
        
        
    }
}
