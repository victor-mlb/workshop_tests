import api.ListApi
import org.mockito.Mockito
import spock.lang.Specification

class ListHelperTest extends Specification {

    def "should return the minimum value"() {
        given:
            List<Integer> listTest = [1, 2, 3, 4, 5]
            ListApi mockedListApi = Mockito.mock(ListApi)
            Mockito.when(mockedListApi.findAll()).thenReturn(listTest)
            ListHelper listHelper = new ListHelper(mockedListApi)
        when:
            Integer result = listHelper.minValue();
        then:
           result == 1;
    }

    def "should return the maximum value"() {
        given:
            List<Integer> listTest = [1, 2, 3, 4, 5]
            ListApi mockedListApi = Mockito.mock(ListApi)
            Mockito.when(mockedListApi.findAll()).thenReturn(listTest)
            ListHelper listHelper = new ListHelper(mockedListApi)
        when:
            Integer result = listHelper.maxValue();
        then:
            result == 5;
    }

    def "should return the number of elements"() {
        given:
            List<Integer> listTest = [1, 2, 3, 4, 5, 6, 7, 8, 9]
            ListApi mockedListApi = Mockito.mock(ListApi)
            Mockito.when(mockedListApi.findAll()).thenReturn(listTest)
            ListHelper listHelper = new ListHelper(mockedListApi)
        when:
            Integer result = listHelper.numberOfElements()
        then:
            result == 9;
    }

    def "should return the average"() {
        given:
            List<Integer> listTest = [1, 2, 3, 4, 5]
            ListApi mockedListApi = Mockito.mock(ListApi)
            Mockito.when(mockedListApi.findAll()).thenReturn(listTest)
            ListHelper listHelper = new ListHelper(mockedListApi)
        when:
            Double result = listHelper.overage()
        then:
            result == 3.0f;
    }

    def "should valid with number of elements in the sequence equals 6 and average value biggest than 20"() {
        given:
            List<Integer> listTest = [6, 9, 15, -2, 92, 11]
            ListApi mockedListApi = Mockito.mock(ListApi)
            Mockito.when(mockedListApi.findAll()).thenReturn(listTest)
            ListHelper listHelper = new ListHelper(mockedListApi)
        when:
            Boolean result = listHelper.validation()
        then:
            result
    }

    def "should not valid the list with less of 6 elements"() {
        given:
            List<Integer> listTest = [6, 9, 15]
            ListApi mockedListApi = Mockito.mock(ListApi)
            Mockito.when(mockedListApi.findAll()).thenReturn(listTest)
            ListHelper listHelper = new ListHelper(mockedListApi)
        when:
            listHelper.validation()
        then:
            def e = thrown(RuntimeException)
            e.message == "The list has less than 6 elements"
    }
}
