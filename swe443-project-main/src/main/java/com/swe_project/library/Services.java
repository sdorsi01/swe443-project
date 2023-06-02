package com.swe_project.library;

import org.springframework.web.client.RestTemplate;

public class Services {
    // Update the member's balance
    public void updateBalance(int memberID, int amount) {
        // Unimplemented
    }

    public double requestValue(String isbn, int conditions) {
        // Unimplemented REST API call to get the value of the book from the Internet
        return 1.0;
        /*
        String url = "https://www.googleapis.com/books/v1/volumes?q=isbn:" + isbn;
        try { 
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            System.out.println(e);
        }
        */
    }
}
