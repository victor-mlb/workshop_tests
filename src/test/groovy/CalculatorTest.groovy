import spock.lang.Specification
import spock.lang.Unroll

class CalculatorTest extends Specification {

    def "should sum"() {
        given:
            int valueA = 1
            int valueB = 2
        when:
            int result = Calculator.sum(valueA, valueB)
        then:
            result == (valueA + valueB)
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

    @Unroll
    def "should absolute sum"() {
        when:
        Integer result = Calculator.absoluteSum(valueA, valueB)
        then:
        result == expectedResult
        where:
        valueA | valueB | expectedResult
        1    | 1    | 2
        -1   | -5   | 6
        null | 1    | null
        1    | null | null
        null | null | null
    }
}
