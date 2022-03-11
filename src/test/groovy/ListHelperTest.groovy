import api.NumbersApi
import org.mockito.Mockito
import spock.lang.Specification

class ListHelperTest extends Specification{

    def "should return minimun Value"() {
        given:
        NumbersApi mockNumberApi = Mockito.mock(NumbersApi)
        Mockito.when(mockNumberApi.arrayOfNumber()).thenReturn(test)

        ListHelper listHelper = new ListHelper(mockNumberApi)
        when:
        def result = listHelper.minimunValue()
        then:
        result == expected
        where:
        test | expected
        [6, 9, 15, -2, 92, 11] as int[] | -2
        null | null
    }

    def "should return maximun Value"() {
        given:
        NumbersApi mockNumberApi = Mockito.mock(NumbersApi)
        Mockito.when(mockNumberApi.arrayOfNumber()).thenReturn(test)

        ListHelper listHelper = new ListHelper(mockNumberApi)
        when:
        def result = listHelper.maximunValue()
        then:
        result == expected
        where:
        test | expected
        [6, 9, 15, -2, 92, 11] as int[] | 92
        null | null
    }

    def "should return number of elements"() {
        given:
        NumbersApi mockNumberApi = Mockito.mock(NumbersApi)
        Mockito.when(mockNumberApi.arrayOfNumber()).thenReturn(test)

        ListHelper listHelper = new ListHelper(mockNumberApi)
        when:
        def result = listHelper.numberOfElements()
        then:
        result == expected
        where:
        test | expected
        [6, 9, 15, -2, 92, 11] as int[] | 6
        null | null
    }

    def "should return averege"() {
        given:
        NumbersApi mockNumberApi = Mockito.mock(NumbersApi)
        Mockito.when(mockNumberApi.arrayOfNumber()).thenReturn(test)

        ListHelper listHelper = new ListHelper(mockNumberApi)
        when:
        def result = listHelper.averege()
        then:
        result == expected
        where:
        test | expected
        [6, 9, 15, -2, 92, 11] as int[] | 21.833333333333332
        null | null
    }

    def "should return number of sequence true or false"() {
        given:
        NumbersApi mockNumberApi = Mockito.mock(NumbersApi)
        Mockito.when(mockNumberApi.arrayOfNumber()).thenReturn(test)

        ListHelper listHelper = new ListHelper(mockNumberApi)
        when:
        def result = listHelper.numberOfSequenceTrueOrFalse()
        then:
        result == expected
        where:
        test | expected
        [6, 9, 15, -2, 92, 11] as int[] | true
        [6, 9, 15, -2] as int[] | false
        [6, 9, 15, -2,-4,-4] as int[] | false
        null | null
    }
}
