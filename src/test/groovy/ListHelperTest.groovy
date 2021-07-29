import api.ListApi
import org.mockito.Mockito
import spock.lang.Specification

class ListHelperTest extends Specification {

    ListApi mockedListApi = Mockito.mock(ListApi)
    ListHelper listHelper = new ListHelper(mockedListApi)

    def setup() {
        mockedListApi = Mockito.mock(ListApi)
        listHelper = new ListHelper(mockedListApi)
    }

    def "should return the minimum value"() {
        given:
            List<Integer> listTest = [1, 2, 3, 4, 5]
            Mockito.when(mockedListApi.findAll()).thenReturn(listTest)
        when:
            Integer result = listHelper.minValue();
        then:
            result == 1;
    }
    def "should return empty list for the minimum value"() {
        given:
            Mockito.when(mockedListApi.findAll()).thenReturn(Collections.emptyList())
        when:
            listHelper.minValue();
        then:
            def e = thrown(RuntimeException)
            e.message == "Empty List"
    }

    def "should return the maximum value"() {
        given:
            List<Integer> listTest = [1, 2, 3, 4, 5]
            Mockito.when(mockedListApi.findAll()).thenReturn(listTest)
        when:
            Integer result = listHelper.maxValue();
        then:
            result == 5;
    }
    def "should return empty list for the maximum value"() {
        given:
            Mockito.when(mockedListApi.findAll()).thenReturn(Collections.emptyList())
        when:
            listHelper.maxValue();
        then:
            def e = thrown(RuntimeException)
            e.message == "Empty List"
    }

    def "should return the number of elements"() {
        given:
            List<Integer> listTest = [1, 2, 3, 4, 5, 6, 7, 8, 9]
            Mockito.when(mockedListApi.findAll()).thenReturn(listTest)
        when:
            Integer result = listHelper.numberOfElements()
        then:
            result == 9;
    }

    def "should return the average"() {
        given:
            List<Integer> listTest = [1, 2, 3, 4, 5]
            Mockito.when(mockedListApi.findAll()).thenReturn(listTest)
        when:
            Double result = listHelper.average()
        then:
            result == 3.0f;
    }
    def "should return empty list for the average"() {
        given:
            Mockito.when(mockedListApi.findAll()).thenReturn(Collections.emptyList())
        when:
            listHelper.average()
        then:
            def e = thrown(RuntimeException)
            e.message == "Empty List"
    }

    def "should valid with number of elements in the sequence equals 6 and average value biggest than 20"() {
        given:
            List<Integer> listTest = [6, 9, 15, -2, 92, 11]
            Mockito.when(mockedListApi.findAll()).thenReturn(listTest)
        when:
            Boolean result = listHelper.validation()
        then:
            result
    }
    def "should not valid the list with less of 6 elements"() {
        given:
            List<Integer> listTest = [6, 9, 15]
            Mockito.when(mockedListApi.findAll()).thenReturn(listTest)
        when:
            listHelper.validation()
        then:
            def e = thrown(RuntimeException)
            e.message == "The list need has 6 elements"
    }
}
