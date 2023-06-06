package com.app.Restaurant.serviceimpl;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    private final RestTemplate restTemplate;

    public ApiService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    //31.6260606,-7.9929946;31.6260446,-7.9909057
    public String getJsonDataFromApi(double []position) {
        String accessToken = "pk.eyJ1Ijoic21pbG94aGFtIiwiYSI6ImNsZmZzbjdjazFoaTEzeHBndDg3Y3d6bGQifQ.BAdn0LbT-UzDp9PAWQ71vA";
        String apiUrl = "https://api.mapbox.com/directions/v5/mapbox/driving/"+position[0]+","+position[1]+";"+position[2]+","+position[3]+"?access_token="+accessToken+"&overview=full&steps=true&alternatives=true&geometries=geojson"; // replace with your API URL
        String jsonResponse = restTemplate.getForObject(apiUrl, String.class);
        System.out.println(apiUrl);
        return jsonResponse;
    }
}