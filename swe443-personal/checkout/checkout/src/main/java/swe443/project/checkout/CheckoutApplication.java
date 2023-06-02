package swe443.project.checkout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CheckoutApplication {
	private static final Logger log = LoggerFactory.getLogger(CheckoutApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(CheckoutApplication.class, args);
	}
	@Autowired
	HistoryService srvc;
	@Bean
	public CommandLineRunner demo(HistoryRepository repository) {
		return (args) -> {

			//check new service works before by adding a record to see if it comes up
			//ShoppingCart cart = new ShoppingCart();
			BuyTransaction t1 = new BuyTransaction();
			//long lid = 12;
			//t1.setID(lid);
			//g1.setContent("Happy");
			//srvc.saveTransaction(t1);

			// save a few customers
			/*lid = 1;
			repository.save(new Greeting(lid, "Bauer"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Greeting greeting : repository.findAll()) {
				log.info(greeting.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Optional<Greeting> greeting = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(greeting.toString());
			log.info("");*/


		};
	}
}