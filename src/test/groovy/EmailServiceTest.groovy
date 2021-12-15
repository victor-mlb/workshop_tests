import api.EmailAPI
import exceptions.EmailListException
import model.Email
import org.mockito.Mockito
import spock.lang.Specification

class EmailServiceTest extends Specification {

    def "should return ordered list"() {
        given:
            List<Email> mockedList = [
                    new Email(1L, 'dbc@mail.com'),
                    new Email(2L, 'abc@mail.com'),
                    new Email(3L, 'cbc@mail.com'),
                    new Email(4L, 'bbc@mail.com')
            ]

            EmailAPI mockEmailApi = Mockito.mock(EmailAPI)
            Mockito.when(mockEmailApi.fetchList()).thenReturn(mockedList)

            EmailService emailService = new EmailService(mockEmailApi)
        when:
            def result = emailService.orderedList()
        then:
            result == [
                    new Email(2L, 'abc@mail.com'),
                    new Email(4L, 'bbc@mail.com'),
                    new Email(3L, 'cbc@mail.com'),
                    new Email(1L, 'dbc@mail.com')
            ]
    }

    def "should return list null"() {
        given:
            List<Email> mockedList = null

            EmailAPI mockEmailApi = Mockito.mock(EmailAPI)
            Mockito.when(mockEmailApi.fetchList()).thenReturn(mockedList)

            EmailService emailService = new EmailService(mockEmailApi)
        when:
            def result = emailService.orderedList()
        then:
            result.size() == 0
    }

    def "should return error for method 'update'"() {
        given:
            List<Email> mockedList = [
                    new Email(1L, 'a@mail.com'),
                    new Email(2L, 'b@mail.com')
            ]

            EmailAPI mockEmailApi = Mockito.mock(EmailAPI)
            Mockito.when(mockEmailApi.fetchList()).thenReturn(mockedList)

            EmailService emailService = new EmailService(mockEmailApi)
        when:
            emailService.update(valueA, valueB)
        then:
            def ex = thrown(EmailListException)
            ex.message == expectedResult
        where:
            valueA  | valueB        | expectedResult
            2       | null          | "Email should not be empty"
            null    | "c@mail.com"  | "ID should not be empty"
            0       | "c@mail.com"  | "ID should not be empty"
            2       | "c@mail.com"  | "DON'T IMPLEMENT NOR REMOVE IT"
    }

    def "should return error for method 'save'"() {
        given:
            List<Email> mockedList = [
                    new Email(1L, 'a@mail.com'),
                    new Email(2L, 'b@mail.com')
            ]

            EmailAPI mockEmailApi = Mockito.mock(EmailAPI)
            Mockito.when(mockEmailApi.fetchList()).thenReturn(mockedList)

            EmailService emailService = new EmailService(mockEmailApi)
        when:
            emailService.save(valueA)
        then:
            def ex = thrown(EmailListException)
            ex.message == expectedResult
        where:
            valueA          | expectedResult
            null            | "Email should not be empty"
            "c@mail.com"    | "DON'T IMPLEMENT NOR REMOVE IT"
    }
}
