package com.gr8erkay.klashacountryproject.service;

import com.gr8erkay.klashacountryproject.entity.City;
import com.gr8erkay.klashacountryproject.model.responseDTO.CityResponse;
import com.gr8erkay.klashacountryproject.model.responseDTO.CountryResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CountryService {

    String convertAndFormatCurrency(String country, double amount, String targetCurrency);

    ResponseEntity<CityResponse> getCityInfo(String cityName);

    List<City> getMostPopulatedCities(int N);
    CountryResponse getCountryInfo(String country);

    CountryResponse getCitiesAndStatesByCountry(String country);


}
