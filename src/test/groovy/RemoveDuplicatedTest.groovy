import api.ListApi
import org.mockito.Mockito
import spock.lang.Specification
import spock.lang.Unroll

class RemoveDuplicatedTest extends Specification {

    @Unroll
    def "should remove duplicate values"() {
        given:

            ListApi mockedListApi = Mockito.mock(ListApi)
            Mockito.when(mockedListApi.findAll()).thenReturn(mockedList)
            RemoveDuplicated removeDuplicated = new RemoveDuplicated(mockedListApi)
        when:
            List<Integer> result = removeDuplicated.removeDuplicateValue();
        then:
            result == expectedResult
        where:
            mockedList   |   expectedResult
              [1, 2]     |    [1, 2]
           [1,1,2,2,3,3] |    [1,2,3]
               null      |    []
                []       |    []
    }


}
