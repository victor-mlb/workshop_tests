package workshop

import spock.lang.Specification
import spock.lang.Unroll

class CalculatorTest extends Specification {

    def "should sum"() {
        when:
            int result = Calculator.sum(valueA, valueB)
        then:
            result == expectedResult
        where:
            valueA  | valueB | expectedResult
            1       | 1      | 2
            1       | 0      | 1
            -1      | 2      | 1
            -1      | -1     | -2
    }

    def "should sum absolute"() {
        when:
            Integer result = Calculator.absoluteSum(valueA, valueB)
        then:
            result == expectedResult
        where:
            valueA  | valueB | expectedResult
            1       | 1      | 2
            1       | 0      | 1
            -2      | -2     | 4
            2       | -2     | 4
            -2      | 2      | 4
            null    | 1      | null
            1    | null      | null
    }

    @Unroll
    def "should divide"() {
        when:
            float result = Calculator.divide(valueA, valueB)
        then:
            result == expectedResult
        where:
            valueA | valueB | expectedResult
            1.0f    | 1.0f    | 1f
            1.0f    | 0f      | 0f
    }
}
