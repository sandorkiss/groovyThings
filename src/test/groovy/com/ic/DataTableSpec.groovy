package com.ic

import spock.lang.Shared
import spock.lang.Specification

class DataTableSpec extends Specification {

    @Shared
    DataTable dataTable

    def setup() {
        dataTable = new DataTable()
    }

    def "use data pipes"() {
        expect:
        dataTable.addValues(x, y) == sum

        where:
        x | y || sum
        1 | 2 || 3
        5 | 0 || 5
    }
}