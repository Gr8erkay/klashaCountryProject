package com.gr8erkay.klashacountryproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class City {
    private String city;
    private String country;

    private Integer population;
    private List<PopulationCount> populationCounts;


}
