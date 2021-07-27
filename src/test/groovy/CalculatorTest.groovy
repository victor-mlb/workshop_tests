import spock.lang.Specification
import spock.lang.Unroll

class CalculatorTest extends Specification {

    def "should sum"() {
        given:
            int valueA = 1
            int valueB = 2
            int expectedResult = 3
        when:
            int result = Calculator.sum(valueA, valueB)
        then:
            result == expectedResult
    }

    @Unroll
    def "should divide"() {
        when:
            float result = Calculator.divide(value, dividend)
        then:
            expectedResult == result
        where:
            value | dividend | expectedResult
            1.0f  |  1.0f    | 1.0f
            1.0f  |  0f    | 0f
    }

    @Unroll
    def "should do absolute sum "() {
        when:
            Integer result = Calculator.absoluteSum(valueA , valueB)
        then:
            expectedResult == result

        where:
            valueA | valueB | expectedResult
             null  |  null  | null
             null  |   1    | null
               1   |  null  | null
               1   |   1    |  2

    }
}
