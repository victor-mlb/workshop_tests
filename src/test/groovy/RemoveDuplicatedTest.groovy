import api.ListApi
import org.mockito.Mockito
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class RemoveDuplicatedTest extends Specification {

    @Shared
    private List<Integer> listWithRepet = [1, 10, 10, 4, 4, 20, 27, 5,  5, 12]
    @Shared
    private List<Integer> listDistinct  = [1, 10, 4, 20, 27, 5, 12]


    @Unroll
    def "should remove duplicates" (){
        given:
            RemoveDuplicated mockRemoveDuplicated = new RemoveDuplicated()

        when:
            def result = mockRemoveDuplicated.removeDuplicate(inputList)

        then:
            expectedResult == result

        where:
            inputList       || expectedResult
            listWithRepet   || listDistinct
            listDistinct    || listDistinct
    }

    @Unroll
    def "should remove duplicates with empty list"() {
        given:
            RemoveDuplicated mockRemoveDuplicated = new RemoveDuplicated()

        when:
            def result = mockRemoveDuplicated.removeDuplicate(inputList)

        then:
            expectedResult == result

        where:
            inputList       || expectedResult
            []              || []
            null            || []
    }
}
