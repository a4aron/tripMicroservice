package com.altimetric.tripMicroservice.service;

import com.altimetric.tripMicroservice.model.Car;
import com.altimetric.tripMicroservice.model.Inputs;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Iterator;

@Service
public class CarServiceImpl implements CarService{

    @Value("${car.search.url}")
    private String CAR_SEARCH_API_URL;

    @Value("${api.key}")
    private String API_KEY;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

    public Car cheapestCars(Inputs param) {
        Car car = new Car();
        String completeUrl = String.format(CAR_SEARCH_API_URL, API_KEY,param.getDestination(),
                param.getStartDate().toString(), param.getEndDate().toString());
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(completeUrl, String.class);
        String responseJson = responseEntity.getBody();
        try {
            JsonNode root = objectMapper.readTree(responseJson).get("results");
            JsonNode cheapestNode =  root.get(0);
            JsonNode cheapestCar = cheapestNode.path("cars").get(0);
            Iterator<JsonNode> nodeIterator = root.iterator();

            car.setAmount(cheapestCar.path("estimated_total").get("amount").asDouble());
            car.setType(cheapestCar.path("vehicle_info").get("type").asText());
            car.setCity(cheapestNode.path("address").get("city").asText());
            car.setCompany(cheapestNode.path("provider").get("company_name").asText());
            car.setUrl(cheapestCar.path("images").path(0).get("url").asText());
            System.out.println(cheapestNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return car;
    }

//    public List<CarProvider> findCars(Search search) throws IOException {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<String>(headers);
//        String searchUrl = String.format(CAR_SEARCH_RUL, API_KEY, search.getDestinationCity(), search.getStartDate(),
//                search.getEndDate());
//        String body = restTemplate.exchange(searchUrl, HttpMethod.GET, entity, String.class).getBody();
//        JSONObject jsonObj = new JSONObject(body);
//        ObjectMapper mapper = new ObjectMapper();
//        CarProvider[] carProviders = mapper.readValue(jsonObj.get("results").toString(), CarProvider[].class);
//        return Arrays.asList(carProviders);
//    }
//
//    public AvailableCar findCheapest(List<CarProvider> carProviders) {
//        List<AvailableCar> cheapestAvailableCars = carProviders.stream()
//                .map(carProvider -> carProvider.getAvailableCars().stream()
//                        .min((a, b) -> Double.compare(a.getRates().get(0).getPrice().getAmount(),b.getRates().get(0).getPrice().getAmount())).get())
//                .collect(Collectors.toList());
//        AvailableCar cheapeastCar = cheapestAvailableCars
//                .stream()
//                .min((a, b) -> Double.compare(a.getRates().get(0).getPrice().getAmount(),b.getRates().get(0).getPrice().getAmount())).get();
//        return cheapeastCar;
//    }

}
