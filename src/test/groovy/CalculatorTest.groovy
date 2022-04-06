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
            1.0f   | 1.0f   | 1f
            1.0f   | 0f     | 0f
    }

    @Unroll
    def "should absoluteSum #a #b #expectedResult"() {
        when:
            Integer result = Calculator.absoluteSum(a, b)
        then:
            result == expectedResult
        where:
            a     | b    | expectedResult
            -2    |  3   | 5
             1    | -1   | 2
            -2    | -2   | 4
             1    | null | null
             null | 1    | null
             1    | 1    | 2
    }
}
