import api.EmailApi
import api.ListApi
import org.mockito.Mockito
import spock.lang.Specification
import spock.lang.Unroll

class ListHelperTest extends Specification {

    ListApi mockListApi
    ListHelper listHelper

    def setup() {
        mockListApi = Mockito.mock(ListApi)
        listHelper = new ListHelper(mockListApi)
    }
    
    def "should return list"() {
        given:
        List<Integer> list = new ArrayList<Integer>([6, 9, 15, -2, 92, 11]);
        Mockito.when(mockListApi.fetchList()).thenReturn(list)
        when:
        List<Integer> result = listHelper.getList();
        then:
        result == list;
    }

    @Unroll
    def "should return error when fetching list"() {
        given:
        Mockito.when(mockListApi.fetchList()).thenReturn(list)
        when:
        listHelper.getList();
        then:
        NoSuchElementException error = thrown(NoSuchElementException)
        error.message == expectedMessage
        where:
        list  | expectedMessage
        null  | "Empty or null list"
        []    | "Empty or null list"
    }

    @Unroll
    def "should return min value"() {
        given:
        Mockito.when(mockListApi.fetchList()).thenReturn(list)
        when:
        Integer result = listHelper.getMinValue();
        then:
        result == expectedResult
        where:
        list              | expectedResult
        [-1, -20, -3, -7] | -20
        [9, 20, 5, 8]     | 5
        [-10, 10, 8, 7]   | -10
    }

    @Unroll
    def "should return max value"() {
        given:
        Mockito.when(mockListApi.fetchList()).thenReturn(list)
        when:
        Integer result = listHelper.getMaxValue();
        then:
        result == expectedResult
        where:
        list  | expectedResult
        [-1, -20, -3, -7] | -1
        [9, 20, 5, 8]     | 20
        [-10, 10, 8, 7]   | 10
    }

    @Unroll
    def "should return size list"() {
        given:
        Mockito.when(mockListApi.fetchList()).thenReturn(list)
        when:
        Integer result = listHelper.getSize();
        then:
        result == expectedResult
        where:
        list              | expectedResult
        [-1, -20, -3, -7] | 4
        [9, 20, 8]        | 3
    }

    @Unroll
    def "should return average"() {
        given:
        Mockito.when(mockListApi.fetchList()).thenReturn(list)
        when:
        Double result = listHelper.getAverage();
        then:
        result == expectedResult
        where:
        list              | expectedResult
        [-1, -20, -3, -7] | -7.75
        [9, 20, 8]        | 12.333333333333334
    }

    @Unroll
    def "should return list valid or invalid"() {
        given:
        Mockito.when(mockListApi.fetchList()).thenReturn(list)
        when:
        Boolean result = listHelper.isValid();
        then:
        result == expectedResult
        where:
        list  | expectedResult
        [-1, -20, -3, -7]        | false
        [5, 3, 1, 3, 4, 5]       | false
        [50, 70, 50]             | false
        [60, 25, 30, 33, 44, 15] | true
    }



}
