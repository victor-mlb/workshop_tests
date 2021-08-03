import spock.lang.Specification
import spock.lang.Unroll

class ListHelperTest extends Specification {

    @Unroll
    def "should checkMinimum"() {
        given:
            ListHelper listHelper = new ListHelper()
        when:
            Integer result = listHelper.checkMinimum(list)
        then:
            result == exprectedResult
        where:
            exprectedResult | list
            -2              | [6, 9, 15, -2, 92, 11]
            0               | null
    }

    @Unroll
    def "should checkMaximum"() {
        given:
            ListHelper listHelper = new ListHelper()
        when:
            Integer result = listHelper.checkMaximum(list)
        then:
            result == exprectedResult
        where:
            exprectedResult | list
            92              | [6, 9, 15, -2, 92, 11]
            0               | null
    }

    @Unroll
    def "should elementNumberList"() {
        given:
            ListHelper listHelper = new ListHelper()
        when:
            Integer result = listHelper.elementNumberList(list)
        then:
            result == exprectedResult
        where:
            exprectedResult | list
            6               | [6, 9, 15, -2, 92, 11]
            0               | null
    }

    @Unroll
    def "should averageList"() {
        given:
            ListHelper listHelper = new ListHelper()
        when:
            Double result = listHelper.averageList(list)
        then:
            Math.abs(result - expectedResult) < 0.001
        where:
            expectedResult | list
            21.833d        | [6, 9, 15, -2, 92, 11]
            0d             | null
    }

    @Unroll
    def "should validationNumber"() {
        given:
            ListHelper listHelper = new ListHelper()
        when:
             boolean result = listHelper.validationNumber(list)
        then:
            result == exprectedResult
        where:
            exprectedResult | list
            true            | [6, 9, 15, -2, 92, 11]
            false           | [6, 9, 15, -2, 92, 11, 12]
            false           | [1, 2, 3, 400]
            false           | [1, 2, 3, 4, 5, 6]
            false           | null
    }
}
