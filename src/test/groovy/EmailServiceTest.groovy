import api.EmailApi
import model.Email
import org.mockito.Mockito
import spock.lang.Specification
import spock.lang.Unroll

class EmailServiceTest extends Specification {

    EmailApi mockEmailApi
    EmailService emailService

    def setup() {
        mockEmailApi = Mockito.mock(EmailApi)
        emailService = new EmailService(mockEmailApi)
    }

    def "should return ordered list"() {
        given:
            List<Email> mockedList = [
                    new Email(1L, 'dbc@mail.com'),
                    new Email(2L, 'abc@mail.com'),
                    new Email(3L, 'cbc@mail.com'),
                    new Email(4L, 'bbc@mail.com')
            ]

            Mockito.when(mockEmailApi.fetchList()).thenReturn(mockedList)
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

    def "should return saved email"() {
        given:
            EmailApi mockEmailApi = Mockito.mock(EmailApi)

            EmailService emailService = new EmailService(mockEmailApi)
            String emailMock = "teste@test.com"
        when:
            Email result = emailService.save(emailMock)
        then:
            result.email == emailMock
            result.id != null
    }

    @Unroll
    def "should return empty email error when saving"() {
        when:
            emailService.save(email)
        then:
            RuntimeException ex = thrown(RuntimeException)
            ex.message == expectedResult
        where:
            email | expectedResult
            ""    | "Email should not be empty"
            " "   | "Email should not be empty"
            null  | "Email should not be empty"
    }

    @Unroll
    def "should return email error or empty id when updating"() {
        when:
            emailService.update(id, newEmail)
        then:
            RuntimeException ex = thrown(RuntimeException)
            ex.message == expectedResult
        where:
            id   | newEmail  | expectedResult
            5    | null      | "Email should not be empty"
            5    | ""        | "Email should not be empty"
            5    | "  "      | "Email should not be empty"
            null | "t@t.com" | "ID should not be empty"
            0    | "t@t.com" | "ID should not be empty"
            -5   | "t@t.com" | "ID should not be empty"
    }

    def "should return updated email"() {
        given:
            Long idMock = 5L
            Email emailMock = new Email(5L, "test@test.com")
            Mockito.when(mockEmailApi.get(idMock)).thenReturn(emailMock)
            String emailUpdateMock = "testUpdate@test.com"
        when:
            Email result = emailService.update(idMock, emailUpdateMock)
        then:
            result.email == emailUpdateMock
    }
}
