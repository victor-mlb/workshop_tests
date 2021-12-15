import api.EmailAPI
import api.ListHelperAPI
import exceptions.EmailListException
import exceptions.ListHelperException
import model.Email
import org.mockito.Mockito
import spock.lang.Specification

class RemoveDuplicatedTest extends Specification {

    def "should return empty when send null"() {
        given:
            List<Integer> mockedList = null

            ListHelperAPI mockListHelperAPI = Mockito.mock(ListHelperAPI)
            Mockito.when(mockListHelperAPI.fetchList()).thenReturn(mockedList)

            RemoveDuplicated removeDuplicated = new RemoveDuplicated(mockListHelperAPI)
        when:
            def result = removeDuplicated.RemoveDuplicate()
        then:
            result == []
    }

    def "should return empty when send empty"() {
        given:
            List<Integer> mockedList = []

            ListHelperAPI mockListHelperAPI = Mockito.mock(ListHelperAPI)
            Mockito.when(mockListHelperAPI.fetchList()).thenReturn(mockedList)

            RemoveDuplicated removeDuplicated = new RemoveDuplicated(mockListHelperAPI)
        when:
            def result = removeDuplicated.RemoveDuplicate()
        then:
            result == []
    }

    def "should return [1,2] when send [1,2]"() {
        given:
            List<Integer> mockedList = [1,2]

            ListHelperAPI mockListHelperAPI = Mockito.mock(ListHelperAPI)
            Mockito.when(mockListHelperAPI.fetchList()).thenReturn(mockedList)

            RemoveDuplicated removeDuplicated = new RemoveDuplicated(mockListHelperAPI)
        when:
            def result = removeDuplicated.RemoveDuplicate()
        then:
            result == [1,2]
    }

    def "should return [1,2,3] when send [1,1,2,2,3,3]"() {
        given:
            List<Integer> mockedList = [1,1,2,2,3,3]

            ListHelperAPI mockListHelperAPI = Mockito.mock(ListHelperAPI)
            Mockito.when(mockListHelperAPI.fetchList()).thenReturn(mockedList)

            RemoveDuplicated removeDuplicated = new RemoveDuplicated(mockListHelperAPI)
        when:
            def result = removeDuplicated.RemoveDuplicate()
        then:
            result == [1,2,3]
    }

    def "should return throw"() {
        given:
            List<Integer> mockedList = [1,1,2,2,3,3]
            ListHelperAPI mockListHelperAPI = new ListHelperAPI()
            mockListHelperAPI = Mockito.mock(ListHelperAPI)
            Mockito.when(mockListHelperAPI.fetchList()).thenReturn(mockedList)

            RemoveDuplicated removeDuplicated = new RemoveDuplicated(mockListHelperAPI)
        when:
            removeDuplicated.clear()
        then:
            def ex = thrown(ListHelperException)
            ex.message == "DON'T IMPLEMENT NOR REMOVE IT"
    }
}
