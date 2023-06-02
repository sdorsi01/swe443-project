Using My MicroService:

```
@GetMapping("/myMapping")//replace with your own call name you will need to do: yourURL+"?ownerID="+ID to call service
public String getHistory(@RequestParam(name = "ownerID") String ownerID, Model model) {
RestTemplate restTemplate = new RestTemplate();
ResponseEntity history;
int id = Integer.parseInt(ownerID);
try {
//replace PORT with port of my microservice
history = restTemplate.exchange("http://localhost:PORT/giveHistoryFromUser?ownerID="+id, HttpMethod.GET, null, new ParameterizedTypeReference<List<BuyTransaction>>(){});

        } catch (Exception e) {
            history = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
//history.getBody() is the list of transactions
model.addAttribute("historyList",history.getBody());
System.out.println(history.getBody());
return "history";//html of current user's history
}
```

html to print:
```
<p th:each="bt : ${historyList}" th:text="${bt}"/>
```