import spock.lang.Specification
import spock.lang.Unroll

class RemoveDuplicatedTest extends Specification {

    @Unroll
    def "should remove Duplicated"() {
        when:
        List<Integer> result = RemoveDuplicated.removeDuplicate(value)
        then:
        result == expectedResult
        where:
        value                |  expectedResult
       [ 2,6,3,1]            |   [ 2,6,3,1]
       [20,60,30,10, 10,-80] |   [20,60,30,10,-80]
       []                    |   []
       [1,1,2,2,3,3]         |   [1,2,3]
    }

}
