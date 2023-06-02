package swe443.project.HistoryService;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import org.slf4j.Logger;

@SpringBootApplication
public class HistoryServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(HistoryServiceApplication.class, args);
	}

}


/* EXTRA CODE FOR MY NOTES
 @GetMapping("/history/giveBT")
    public RestBuyTransaction greeting() {
        ArrayList<Integer> bookList = new ArrayList<>();
        bookList.add(45);
        return new RestBuyTransaction("DATE",50.45, bookList,counter.incrementAndGet()); //counter.incrementAndGet(), new Random().nextInt());
    }

    //get up-to-date model of transactions
    @GetMapping("/history/update")
    public String updateBT(Model model){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> remoteBT;
        int id = 35;
        Map<String, Object> params = new HashMap<>(2);
            params.put("var1value", "SomeString");
        try {
				remoteBT = restTemplate.getForEntity("http://localhost:8080/update?user="+id, String.class);
		}catch (Exception e){
		remoteBT =new ResponseEntity<>(HttpStatus.BAD_REQUEST);// "NONE";//new ArrayList<>();
		//remoteBT.add(new RestBuyTransaction("_",0,new ArrayList<>(),0));
		}

		return remoteBT.getBody();
		}
 */