import api.ListApi
import org.mockito.Mockito
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class ListHelperTest extends Specification {

    ListApi mockListApi

    ListHelper listHelper

    def setup() {
        mockListApi = Mockito.mock(ListApi)
        listHelper = new ListHelper(mockListApi)

    }

    @Unroll
    def "should minimum value"() {
        given:
            Mockito.when(mockListApi.fetchList()).thenReturn(value)
        when:
            def result = listHelper.searchMinimum()
        then:
            result == expectedResult
        where:
            value                    | expectedResult
            [2, 6, 3, 1]             | 1
            [20, 60, 30, 10, 0, -80] | -80
            []                       | 0
    }

    @Unroll
    def "should Maximum value"() {
        given:
            Mockito.when(mockListApi.fetchList()).thenReturn(value)
        when:
            def result = listHelper.searchMaximum()
        then:
            result == expectedResult
        where:
            value                    | expectedResult
            [2, 6, 3, 1]             | 6
            [20, 60, 30, 10, 0, -80] | 60
            []                       | 0
    }

    @Unroll
    def "should count Elements"() {
        given:
            Mockito.when(mockListApi.fetchList()).thenReturn(value)
        when:
            def result = listHelper.countElements()
        then:
            result == expectedResult
        where:
            value                    | expectedResult
            [2, 6, 3, 1]             | 4
            [20, 60, 30, 10, 0, -80] | 6
            []                       | 0
    }

    @Unroll
    def "should count Average"() {
        given:
            Mockito.when(mockListApi.fetchList()).thenReturn(value)
        when:
            def result = listHelper.countAverage()
        then:
            result == expectedResult
        where:
            value                    | expectedResult
            [6, 9, 15, -2, 92, 11]   | 21.833333
            [2, 6, 3, 1]             | 3
            [20, 60, 30, 10, 0, -80] | 6.666667
            []                       | 0
            [0, 0, 0, 0, 0]          | 0
    }

    @Unroll
    def "should valid Sequence"() {
        given:
            def result
            Mockito.when(mockListApi.fetchList()).thenReturn(value)
        when:
            result = listHelper.validSequence()
            Mockito.verify(mockListApi, Mockito.times(1)).fetchList()
        then:
            result == expectedResult

        where:
            value                   | expectedResult
            [2, 6, 3, 1]            | false
            [20, 60, 30, 10, 0, 80] | true
            []                      | false


    }

}
