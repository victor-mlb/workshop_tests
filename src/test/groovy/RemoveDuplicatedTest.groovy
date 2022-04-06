import spock.lang.Specification
import spock.lang.Unroll

class RemoveDuplicatedTest extends Specification{

    @Unroll
    def "should removeDuplicate"() {
        given:
            RemoveDuplicated removeDuplicated = new RemoveDuplicated()
        when:
            List<Integer> result = removeDuplicated.removeDuplicate(list)
        then:
            result == expectedResult
        where:
            list          | expectedResult
            null          | []
            []            | []
            [1,2]         | [1,2]
            [1,1,2,2,3,3] | [1,2,3]
    }
}
