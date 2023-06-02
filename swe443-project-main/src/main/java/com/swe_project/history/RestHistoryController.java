package com.swe_project.history;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

import java.util.List;



@RestController
public class RestHistoryController {

   /* @GetMapping("/checkout/GetBuyTransactions")
    public List<RestBuyTransaction> giveHistory(@RequestParam(name = "ownerID") String ownerID) {
        return updateBT(ownerID);
    }*/


    //get up-to-date model of transactions
    @GetMapping("/checkout/GetBuyTransactions")
    public List<RestBuyTransaction> updateBT(@RequestParam(name = "ownerID") String ownerID/*Model model*/){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<RestBuyTransaction>> remoteBT;
        try {
            remoteBT = restTemplate.exchange("http://localhost:8080/checkout/update?user="+ownerID, HttpMethod.GET, null, new ParameterizedTypeReference<List<RestBuyTransaction>>(){});
        }catch (Exception e){
            System.out.println(e);
            remoteBT = new ResponseEntity(new ArrayList<>(),HttpStatus.BAD_REQUEST);// "NONE";//new ArrayList<>();
        }
        if(remoteBT != null && remoteBT.hasBody()){
            List<RestBuyTransaction> myList = remoteBT.getBody();
            System.out.println(myList);
        }

        return remoteBT.getBody();//string of current repo
    }

}
