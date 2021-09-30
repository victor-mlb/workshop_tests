import api.ListApi
import org.mockito.Mockito
import spock.lang.Shared
import spock.lang.Specification

class ListHelperTest extends Specification {

    static final String NO_ELEMENTS = "No elements"

    @Shared
    private List<Integer> list = [6, 9, 15, -2, 92, 11]

    ListApi listApi
    ListHelper listHelper

    def setup() {
        listApi = Mockito.mock(ListApi)
        listHelper = new ListHelper(listApi)
    }

    def "should not get list"() {
        given:
            Mockito.when(listApi.fetchList()).thenReturn(mockList)
        when:
            listHelper.getList();
        then:
            def error = thrown(expectedException)
            error.message == expectedMessage
        where:
            mockList    ||   expectedException   |   expectedMessage
            null        ||   RuntimeException    |   NO_ELEMENTS
            []          ||   RuntimeException    |   NO_ELEMENTS
    }

    def "should get min"() {
        given:
            Mockito.when(listApi.fetchList()).thenReturn(list)
        expect:
            listHelper.getMin() == -2
    }

    def "should get max"() {
        given:
            Mockito.when(listApi.fetchList()).thenReturn(list)
        expect:
            listHelper.getMax() == 92
    }

    def "should get size"() {
        given:
            Mockito.when(listApi.fetchList()).thenReturn(list)
        expect:
            listHelper.getSize() == 6
    }

    def "should get avarege"() {
        given:
           Mockito.when(listApi.fetchList()).thenReturn(list)
        expect:
            listHelper.getAverage() == 21.833333333333332
    }

    def "should be or not be validated this is the question"() {
        given:
            Mockito.when(listApi.fetchList()).thenReturn(mockList)
        expect:
            listHelper.validate() == validated
        where:
            mockList                    ||  validated
            [6, 9, 15, -2, 92, 11]      ||  true
            [6, 9, 15, -2]              ||  false
            [6, 9, 15, -2, 11, 50]      ||  false
            [20, 20, 20, 20, 20, 20, 20]||  false

    }
}
