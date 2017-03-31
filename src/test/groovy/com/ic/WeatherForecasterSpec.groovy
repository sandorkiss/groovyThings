package com.ic

import org.junit.Ignore
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class WeatherForecasterSpec extends Specification {

    @Shared
    WeatherForecaster weatherForecaster

    def setup() {
        weatherForecaster = new WeatherForecaster()
    }

    def "test getForecast - happy path #scenario"() {
        when:
        weatherForecaster.getForecast(postalCode)

        then:
        noExceptionThrown()

        where:
        scenario                | postalCode | countryCode
        'valid postal code'     | '55123'    | 'us'
    }

    @Ignore
    def "test getForecast #scenario"() {
        when:
        weatherForecaster.getForecast(postalCode, countryCode)

        then:
        def e = thrown(exception)
        e.message.contains(message)

        where:
        scenario              | postalCode | countryCode || exception      | message
        'missing postal code' | null       | 'us'        || AssertionError | 'postal code is required'
    }
}
