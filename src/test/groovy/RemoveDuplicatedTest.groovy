import model.Stats
import spock.lang.Specification
import spock.lang.Unroll

class RemoveDuplicatedTest extends Specification {

    @Unroll
    def "should remove duplicated"() {
        when:
            def result = RemoveDuplicated.removeDuplicate(values)
        then:
            result == expectedResult
        where:
            values          | expectedResult
            null            | []
            []              | []
            [1, 2]          | [1, 2]
            [1,1,2,2,3,3]   | [1,2,3]

    }
}
