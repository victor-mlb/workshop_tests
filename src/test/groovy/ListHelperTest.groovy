
import api.ListHelperAPI
import org.mockito.Mockito
import spock.lang.Specification

class ListHelperTest extends Specification {

    def "should return minimum value"() {
        given:
            List<Integer> mockedList = [6, 9, 15, -2, 92, 11]
            ListHelperAPI mockListHelperAPI = Mockito.mock(ListHelperAPI)
            Mockito.when(mockListHelperAPI.fetchList()).thenReturn(mockedList)

            ListHelper listHelper = new ListHelper(mockListHelperAPI)
        when:
            def result = listHelper.minimumValue()
        then:
            result == -2
    }

    def "should return maximum value"() {
        given:
            List<Integer> mockedList = [6, 9, 15, -2, 92, 11]

            ListHelperAPI mockListHelperAPI = Mockito.mock(ListHelperAPI)
            Mockito.when(mockListHelperAPI.fetchList()).thenReturn(mockedList)

            ListHelper listHelper = new ListHelper(mockListHelperAPI)
        when:
            def result = listHelper.maximumValue()
        then:
            result == 92
    }

    def "should return number of elements in the sequence"() {
        given:
            List<Integer> mockedList = [6, 9, 15, -2, 92, 11]

            ListHelperAPI mockListHelperAPI = Mockito.mock(ListHelperAPI)
            Mockito.when(mockListHelperAPI.fetchList()).thenReturn(mockedList)

            ListHelper listHelper = new ListHelper(mockListHelperAPI)
        when:
            def result = listHelper.numberOfElementsInTheSequence()
        then:
            result == 6
    }

    def "should return the average value"() {
        given:
            List<Integer> mockedList = [6, 9, 15, -2, 92, 11]

            ListHelperAPI mockListHelperAPI = Mockito.mock(ListHelperAPI)
            Mockito.when(mockListHelperAPI.fetchList()).thenReturn(mockedList)

            ListHelper listHelper = new ListHelper(mockListHelperAPI)
        when:
            def result = listHelper.averageValue()
        then:
            result == 21.833333
    }

    def "should return true if the comparison elements in the sequence and average"() {
        given:
            List<Integer> mockedList = [6, 9, 15, -2, 92, 11]

            ListHelperAPI mockListHelperAPI = Mockito.mock(ListHelperAPI)
            Mockito.when(mockListHelperAPI.fetchList()).thenReturn(mockedList)

            ListHelper listHelper = new ListHelper(mockListHelperAPI)
        when:
            def result = listHelper.compereElementsInTheSequenceAndAverage()
        then:
            result == true
    }

    def "should return false if the comparison elements in the sequence is less than six and average"() {
        given:
            List<Integer> mockedList = [6, 9, 15, -2, 92]

            ListHelperAPI mockListHelperAPI = Mockito.mock(ListHelperAPI)
            Mockito.when(mockListHelperAPI.fetchList()).thenReturn(mockedList)

            ListHelper listHelper = new ListHelper(mockListHelperAPI)
        when:
            def result = listHelper.compereElementsInTheSequenceAndAverage()
        then:
            result == false
    }

    def "should return false if the comparison elements in the sequence and average is min"() {
        given:
            List<Integer> mockedList = [1, 1, 1, -2, 1, 1]

            ListHelperAPI mockListHelperAPI = Mockito.mock(ListHelperAPI)
            Mockito.when(mockListHelperAPI.fetchList()).thenReturn(mockedList)

            ListHelper listHelper = new ListHelper(mockListHelperAPI)
        when:
            def result = listHelper.compereElementsInTheSequenceAndAverage()
        then:
            result == false
    }
}
