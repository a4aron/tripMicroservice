package com.altimetric.tripMicroservice.service;

import com.altimetric.tripMicroservice.model.Airport;
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
public class AirServiceImpl implements AirService{
    @Value("${flight.search.url}")
    private String FLIGHT_SEARCH_API_URL;

    @Value("${api.key}")
    private String API_KEY;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public Airport cheapestFlights(Inputs param) {
        Airport airport = new Airport();
        String completeUrl = String.format(FLIGHT_SEARCH_API_URL, API_KEY, param.getOrigin(), param.getDestination(),
                param.getStartDate().toString(), param.getEndDate().toString());

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(completeUrl, String.class);
        String responseJson = responseEntity.getBody();
        try {
            JsonNode root = objectMapper.readTree(responseJson).get("results");
            JsonNode cheapestNode = root.get(0);
            Iterator<JsonNode> nodeIterator = root.iterator();

            while (nodeIterator.hasNext()) {
                JsonNode tempNode = nodeIterator.next();
                Double cheapest = cheapestNode.path("fare").get("total_price").asDouble();
                Double temp = tempNode.path("fare").get("total_price").asDouble();
                if (temp < cheapest)
                    cheapestNode = tempNode;
            }
            airport.setAirportOrigin(param.getOrigin());
            airport.setAirportDestination(param.getDestination());
            airport.setPrice(cheapestNode.path("fare").get("total_price").asDouble());
            airport.setOutDuration(cheapestNode.path("itineraries").path(0).path("outbound").get("duration").asText());
            airport.setReturnDuration(cheapestNode.path("itineraries").path(0).path("inbound").get("duration").asText());
            airport.setOutFlightNumber(cheapestNode.path("itineraries").path(0).path("outbound").path("flights").path(0).get("flight_number").asLong());
            airport.setReturnFlightNumber(cheapestNode.path("itineraries").path(0).path("inbound").path("flights").path(0).get("flight_number").asLong());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return airport;
    }
}
