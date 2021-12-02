import model.Stats
import spock.lang.Specification
import spock.lang.Unroll

class ListHelperTest extends Specification {

    @Unroll
    def "should process"() {
        when:
            def result = ListHelper.process(values)
        then:
            result.equals(expectedResult)
        where:
            values                  | expectedResult
            [6, 9, 15, -2, 92, 11]  | new Stats(-2, 92, 6, 21.833333, true)
            [6, 9, 15, -2, 19, 11]  | new Stats(-2, 19, 6, 9.666666, false)
            [6, 9, 15, -2, 19]      | new Stats(-2, 19, 5, 9.4, false)
    }
}
