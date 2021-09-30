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

    def "should absolute sum"() {
        expect:
            Calculator.absoluteSum(a, b) == c;
        where:
            a     | b     || c
            null  | null  || null
            null  | 1     || null
            1     | null  || null
            1     | -1    || 2
    }
}
