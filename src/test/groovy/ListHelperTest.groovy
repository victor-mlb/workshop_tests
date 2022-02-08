import api.ListApi
import org.mockito.Mockito
import spock.lang.Specification

class ListHelperTest extends Specification {

    def "should return the min value"(){
        given:
            List<Long> listNumber = [6, 9, 15, -2, 92, 11]
            ListApi listApi = Mockito.mock(ListApi)
            Mockito.when(listApi.fetchList()).thenReturn(listNumber)

            ListHelper listHelper = new ListHelper(listApi)
        when:
            Integer result = listHelper.min()
        then:
            result == -2
    }

    def "should return the max value"(){
        given:
            List<Long> listNumber = [6, 9, 15, -2, 92, 11]
            ListApi listApi = Mockito.mock(ListApi)
            Mockito.when(listApi.fetchList()).thenReturn(listNumber)

            ListHelper listHelper = new ListHelper(listApi)
        when:
            Integer result = listHelper.max()
        then:
            result == 92
    }



    def "should return exception for a empty list"(){
        given:
            ListApi listApi = Mockito.mock(ListApi)
            Mockito.when(listApi.fetchList()).thenReturn(Collections.emptyList())

            ListHelper listHelper = new ListHelper(listApi)
        when:
            listHelper.min()
        then:
            def ex = thrown(RuntimeException)
            ex.message == "List is not should be empty"

    }

    def "should return the number of elements in the sequence"(){
        given:
            List<Long> listNumber = [6, 9, 15, -2, 92, 11]
            ListApi listApi = Mockito.mock(ListApi)
            Mockito.when(listApi.fetchList()).thenReturn(listNumber)

            ListHelper listHelper = new ListHelper(listApi)
        when:
            Integer result = listHelper.numberOfElements()
        then:
        result == 6
    }

    def "should return average number"(){
        given:
            List<Long> listNumber = [6, 9, 15, -2, 92, 11]
            ListApi listApi = Mockito.mock(ListApi)
            Mockito.when(listApi.fetchList()).thenReturn(listNumber)

            ListHelper listHelper = new ListHelper(listApi)
        when:
            double result = listHelper.average()
        then:
            result == 21.833333333333332
    }

    def "should be validated the numbers of list"(){
        given:
            ListApi listApi = Mockito.mock(ListApi)
            Mockito.when(listApi.fetchList()).thenReturn(listNumber)

            ListHelper listHelper = new ListHelper(listApi)
        when:
            boolean result = listHelper.validationList()
        then:
            result == resultExpected
        where:
            listNumber              | resultExpected
            [1,2,3,4]               | false
            [6, 9, 15, -2, 92, 11]  | true
            [1,1,1,1,1,1]           | false
            [20,1]                  | false
    }

}