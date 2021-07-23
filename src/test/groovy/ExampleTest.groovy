import spock.lang.Specification
import spock.lang.Unroll

class ExampleTest extends Specification {

    def "should sum"() {
        given:
            int valueA = 1
            int valueB = 2
        when:
            int result = Example.sum(valueA, valueB)
        then:
            result == (valueA + valueB)
    }

    @Unroll
    def "should divide"() {
        when:
            float result = Example.divide(valueA, valueB)
        then:
            result == expectedResult
        where:
            valueA | valueB | expectedResult
            1.0f    | 1.0f    | 1f
            1.0f    | 0f      | 0f
    }
}
