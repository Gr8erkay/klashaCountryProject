package com.gr8erkay.klashacountryproject.model.responseDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CityResponse {
    private boolean error;
    private String msg;
    private Data data;

    @Getter
    @Setter
    public static class Data {
        private String city;
        private String country;
        private List<PopulationCount> populationCounts;


        @Getter
        @Setter
        public static class PopulationCount {
            private String year;
            private String value;
            private String sex;
            private String reliability;

            // Getters and setters

            @Override
            public String toString() {
                return "PopulationCount{" +
                        "year='" + year + '\'' +
                        ", value='" + value + '\'' +
                        ", sex='" + sex + '\'' +
                        ", reliability='" + reliability + '\'' +
                        '}';
            }
        }
    }

    @Override
    public String toString() {
        return "CityResponse{" +
                "error=" + error +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}

