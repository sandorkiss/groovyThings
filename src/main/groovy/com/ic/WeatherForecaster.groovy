package com.ic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate

class WeatherForecaster {

    static final String URI = 'http://api.openweathermap.org'
    static final String PATH_TEMPLATE = "/data/2.5/forecast?zip={postalCode},{countryCode}&APPID=cb9aa57835d590b7bf598c67793a4d29"

    def getForecast(String postalCode, String countryCode = 'us') {
        assert postalCode : "postal code is required"

        RestTemplate restTemplate = new RestTemplate()
        def response = restTemplate.getForEntity("$URI$PATH_TEMPLATE", Object, postalCode, countryCode)
        println 'a'
    }
}
