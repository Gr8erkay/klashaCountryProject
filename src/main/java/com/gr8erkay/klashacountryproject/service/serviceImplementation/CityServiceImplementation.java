package com.gr8erkay.klashacountryproject.service.serviceImplementation;

import com.gr8erkay.klashacountryproject.entity.City;
import com.gr8erkay.klashacountryproject.model.requestDTO.CityFilterRequest;
import com.gr8erkay.klashacountryproject.model.responseDTO.CityResponse;
import com.gr8erkay.klashacountryproject.model.responseDTO.CountryResponse;
import com.gr8erkay.klashacountryproject.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class CityServiceImplementation implements CountryService {

    private RestTemplate restTemplate;

    @Override
    public String convertAndFormatCurrency(String country, double amount, String targetCurrency) {
        return null;
    }

    public ResponseEntity<CityResponse> getCityInfo(String cityName) {
        // Prepare the request body
        CityFilterRequest request = new CityFilterRequest(cityName);

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create the request entity
        HttpEntity<CityFilterRequest> requestEntity = new HttpEntity<>(request, headers);

        // Make the POST request
        ResponseEntity<CityResponse> responseEntity = restTemplate.exchange(
                "https://countriesnow.space/api/v0.1/countries/population/cities",
                HttpMethod.POST,
                requestEntity,
                CityResponse.class
        );

        return responseEntity;
    }

//        // Extract the City information from the response
//        if (responseEntity.getStatusCode() == HttpStatus.OK && responseEntity.getBody() != null) {
//            CityResponse cityResponse = responseEntity.getBody();
//            CityResponse.Data.PopulationCount populationCount = cityResponse.getData().getPopulationCounts().get(0);
//
//            City city = new City();
//           city.setCity(cityResponse.getData().getCity());
//            city.setCountry(cityResponse.getData().getCountry());
//            city.setPopulation(Integer.parseInt(populationCount.getValue()));
//
//            return city;
//        } else {
//            // Handle error response
//            throw new RuntimeException("Failed to retrieve city information");
//        }
//        return responseEntity;
//    }

    @Override
    public List<City> getMostPopulatedCities(int N) {
        return null;
    }

    @Override
    public CountryResponse getCountryInfo(String country) {
        return null;
    }

    @Override
    public CountryResponse getCitiesAndStatesByCountry(String country) {
        return null;
    }
}

