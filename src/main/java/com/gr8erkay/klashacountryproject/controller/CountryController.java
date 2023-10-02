package com.gr8erkay.klashacountryproject.controller;

import com.gr8erkay.klashacountryproject.entity.City;
import com.gr8erkay.klashacountryproject.entity.CityTest;
import com.gr8erkay.klashacountryproject.model.requestDTO.CityFilterRequest;
import com.gr8erkay.klashacountryproject.model.requestDTO.CountryRequest;
import com.gr8erkay.klashacountryproject.model.responseDTO.CityResponse;
import com.gr8erkay.klashacountryproject.model.responseDTO.CountryResponse;
import com.gr8erkay.klashacountryproject.service.CountryService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/v1/city")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private RestTemplate restTemplate;


    @PostMapping("/most-populated")
    public List<City> getMostPopulatedCities(@RequestParam int N) {
        return countryService.getMostPopulatedCities(N);
    }


    @PostMapping("/country-info")
    public CountryResponse getCountryInfo(@RequestBody CountryRequest request) {
        return countryService.getCountryInfo(request.getCountry());
    }

//    @PostMapping("/cities")
//    public ResponseEntity<CityResponse> getCities(@RequestBody CityFilterRequest request) {
//        return countryService.getCityInfo( request.getCity(), request.getCountry());
//    }

    @PostMapping("/cities")
    public ResponseEntity<CityResponse> getCityInfo(@RequestBody CityFilterRequest cityRequest) {
        ResponseEntity<CityResponse> responseEntity = countryService.getCityInfo(cityRequest.getCity());


        return responseEntity;

    }
//    public Response getCityInfo(String cityName) {
//
//        // Set headers
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        // Create the request entity
//        HttpEntity<CityFilterRequest> requestEntity = new HttpEntity<>(request, headers);
//
//        // Make the POST request
//        ResponseEntity<CityResponse> responseEntity = restTemplate.exchange(
//                "https://countriesnow.space/api/v0.1/countries/population/cities",
//                HttpMethod.POST,
//                requestEntity,
//                CityResponse.class
//        );
//
//        return responseEntity;
//    }
    @PostMapping(value = "/get-city", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String post(@RequestBody CityTest city)
    {
        return restTemplate.postForObject(
                "https://countriesnow.space/api/v0.1/countries/population/cities", city,
                String.class );
    }
    //https://countriesnow.space/api/v0.1/countries/population/cities

    @GetMapping("/get-cities")
    public ResponseEntity<String> get()
    {
        return restTemplate.getForEntity(
                "https://countriesnow.space/api/v0.1/countries/population/cities",
                String.class );
    }

    @PostMapping("/cities-and-states")
    public CountryResponse getCitiesAndStates(@RequestBody CityFilterRequest request) {
        return countryService.getCitiesAndStatesByCountry(request.getCountry());
    }


    @GetMapping("/country-currency-converter")
    public CountryResponse getCountryCurrencyConverter(@RequestParam String country, Double amount, String currency) {
        return countryService.getCountryInfo(country);
    }
}
