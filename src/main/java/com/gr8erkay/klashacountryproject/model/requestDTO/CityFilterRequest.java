package com.gr8erkay.klashacountryproject.model.requestDTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class CityFilterRequest {

    private int limit;
    private String order;
    private String orderBy;
    private String country;
    private String city;

    public CityFilterRequest(String cityName) {
        this.city = cityName;
    }

    @Override
    public String toString() {
        return "CityFilterRequest{" +
                "limit=" + limit +
                ", order='" + order + '\'' +
                ", orderBy='" + orderBy + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
