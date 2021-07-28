import api.ListApi
import org.mockito.Mockito
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class ListHelperTest extends Specification {

    private static final Integer MAX_REFERENCE_VALUE = 43
    private static final Integer MIN_REFERENCE_VALUE = 5
    private static final Integer SIZE_REFERENCE_VALUE = 6
    private static final Double  AVG_REFERENCE_VALUE = 20.0
    private static final String ERRO_NO_LIST = "Elemments not found!"

    @Shared
    private List<Integer> sharedListTest = [13, 43, 20, 27, 5, 12]

    def "should return min value"() {
        given:
            ListApi mockListApi = Mockito.mock(ListApi)
            Mockito.when(mockListApi.fetchList()).thenReturn(sharedListTest)
            ListHelper mockListHelper = new ListHelper(mockListApi)

        when:
            def result = mockListHelper.minValue()

        then:
            MIN_REFERENCE_VALUE == result
    }

    def "should return max value"() {
        given:
            ListApi mockListApi = Mockito.mock(ListApi)
            Mockito.when(mockListApi.fetchList()).thenReturn(sharedListTest)
            ListHelper mockListHelper = new ListHelper(mockListApi)

        when:
            def result = mockListHelper.maxValue()

        then:
            MAX_REFERENCE_VALUE == result
    }

    def "should return list size"() {
        given:
            ListApi mockListApi = Mockito.mock(ListApi)
            Mockito.when(mockListApi.fetchList()).thenReturn(sharedListTest)
            ListHelper mockListHelper = new ListHelper(mockListApi)

        when:
            def result = mockListHelper.sequenceSize()

        then:
            SIZE_REFERENCE_VALUE == result
    }

    def "should return elemments average"() {
        given:
            ListApi mockListApi = Mockito.mock(ListApi)
            Mockito.when(mockListApi.fetchList()).thenReturn(sharedListTest)
            ListHelper mockListHelper = new ListHelper(mockListApi)

        when:
            def result = mockListHelper.avgValue()

        then:
            AVG_REFERENCE_VALUE == result
    }

    def "should check values with true result"() {
        given:
            ListApi mockListApi = Mockito.mock(ListApi)
            Mockito.when(mockListApi.fetchList()).thenReturn(sharedListTest)
            ListHelper mockListHelper = new ListHelper(mockListApi)

        when:
            def result = mockListHelper.valueVerification()

        then:
            result
    }

    @Unroll
    def "should check values with false result"() {
        given:
            sharedListTest.add(MAX_REFERENCE_VALUE)
            ListApi mockListApi = Mockito.mock(ListApi)
            Mockito.when(mockListApi.fetchList()).thenReturn(inputList)
            ListHelper mockListHelper = new ListHelper(mockListApi)

        when:
            def result = mockListHelper.valueVerification()

        then:
            result == referenceResult

        where:
            inputList                       || referenceResult
            [1, 2, 3, 4, 5, 6]              || false // six elemments without avg 20
            [20, 20]                        || false // avg 20 with two elemments
            [20, 20, 20, 20, 20, 20, 20]    || false // avg 20 with seven elemments
    }

    @Unroll
    def "should error to load elemments"() {
        given:
            ListApi mockListApi = Mockito.mock(ListApi)
            Mockito.when(mockListApi.fetchList()).thenReturn(fakeList)
            ListHelper mockListHelper = new ListHelper(mockListApi)

        when:
            mockListHelper.list()

        then:
            def error = thrown(expectedErro)
            error.message == expectedMessage
        where:
            fakeList         || expectedErro       | expectedMessage
            []               || RuntimeException   | ERRO_NO_LIST
            null             || RuntimeException   | ERRO_NO_LIST

    }
}
