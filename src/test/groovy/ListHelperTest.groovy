import api.EmailApi
import org.mockito.Mockito
import spock.lang.Specification
import spock.lang.Unroll

class ListHelperTest extends Specification{

    def "should checkMinimum"() {
        given:
            ListHelper listHelper = new ListHelper()
        when:
            Integer result = listHelper.checkMinimum()
        then:
            result == exprectedResult
        where:
            exprectedResult | _
            -2              | _
    }

    def "should checkMaximum"() {
        given:
            ListHelper listHelper = new ListHelper()
        when:
            Integer result = listHelper.checkMaximum()
        then:
            result == exprectedResult
        where:
            exprectedResult | _
            92              | _
    }

    def "should elementNumberList"() {
        given:
            ListHelper listHelper = new ListHelper()
        when:
            Integer result = listHelper.elementNumberList()
        then:
            result == exprectedResult
        where:
            exprectedResult | _
            6               | _
    }

    def "should averageList"() {
        given:
            ListHelper listHelper = new ListHelper()
        when:
            Integer result = listHelper.averageList()
        then:
            result == exprectedResult
        where:
            exprectedResult | _
            22              | _
    }

    @Unroll
    def "should validationNumber"() {
        given:
            ListHelper listHelper = new ListHelper()
        when:
             boolean result = listHelper.validationNumber()
        then:
            result == exprectedResult
        where:
             exprectedResult | _
             true            | _
    }

}
