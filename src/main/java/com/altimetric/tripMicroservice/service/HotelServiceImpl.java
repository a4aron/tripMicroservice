package com.altimetric.tripMicroservice.service;

import com.altimetric.tripMicroservice.model.Hotel;
import com.altimetric.tripMicroservice.model.Inputs;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Iterator;

@Service
public class HotelServiceImpl implements HotelService {
    @Value("${hotel.search.url}")
    private String HOTEL_SEARCH_API_URL;

    @Value("${api.key}")
    private String API_KEY;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public Hotel cheapestHotel(Inputs param){
        Hotel hotel = new Hotel();
        String completeUrl = String.format(HOTEL_SEARCH_API_URL,
                API_KEY,
                param.getDestination(),
                param.getStartDate().toString(),
                param.getEndDate().toString());

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(completeUrl, String.class);
        String responseJson = responseEntity.getBody();
        try {
            JsonNode root = objectMapper.readTree(responseJson).get("results");
            JsonNode cheapestNode =  root.get(0);
            Iterator<JsonNode> nodeIterator = root.iterator();

            while (nodeIterator.hasNext()) {
                JsonNode tempNode = nodeIterator.next();
                Double cheapest = cheapestNode.path("total_price").get("amount").asDouble();
                Double temp = tempNode.path("total_price").get("amount").asDouble();
                if (temp < cheapest)
                    cheapestNode = tempNode;
            }
            StringBuffer amenities = new StringBuffer();
            hotel.setCity(cheapestNode.path("address").get("city").asText());
            hotel.setLine(cheapestNode.path("address").get("line1").asText());
            hotel.setName(cheapestNode.path("property_name").asText());
            hotel.setPrice(cheapestNode.path("total_price").get("amount").asDouble());
            cheapestNode.path("amenities").forEach(x->amenities.append(x.get("amenity").asText() + " "));
            hotel.setAmenities(amenities.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return hotel;
    }

}
