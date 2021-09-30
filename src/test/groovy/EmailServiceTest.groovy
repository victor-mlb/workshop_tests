import api.EmailApi
import api.ListApi
import model.Email
import org.mockito.Mockito
import spock.lang.Specification

class EmailServiceTest extends Specification {

    static final errorMessageEmail = "Email should not be empty"
    static final errorMessageId = "ID should not be empty"
    static final newEmail = "new@teste.com"
    static final oldmail = "old@teste.com"

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

            EmailApi mockEmailApi = Mockito.mock(EmailApi)
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

    def "should not save"() {
        when:
            emailObj = emailService.save(emailStr)
        then:
            def error = thrown(expectedException)
            error.message == expectedMessage
        where:
            emailStr    ||   emailemailObj   |  expectedException   |   expectedMessage
            null        ||   null            |  RuntimeException    |   errorMessageEmail
            ""          ||   null            |  RuntimeException    |   errorMessageEmail
    }

    def "should save"() {
        when:
            def emailObj = emailService.save(newEmail)
        then:
            noExceptionThrown()
            with(emailObj) {
                email == newEmail
                id != null
            }
    }

    def "should not update"() {
        when:
            emailObj = emailService.update(idEmail, emailStr)
        then:
            def error = thrown(expectedException)
            error.message == expectedMessage
        where:
            idEmail |   emailStr    ||   emailObj   |  expectedException    |   expectedMessage
            1       |   null        ||   null       |  RuntimeException     |   errorMessageEmail
            1       |   ""          ||   null       |  RuntimeException     |   errorMessageEmail
            null    |   newEmail    ||   null       |  RuntimeException     |   errorMessageId
            0       |   newEmail    ||   null       |  RuntimeException     |   errorMessageId
            -1      |   newEmail    ||   null       |  RuntimeException     |   errorMessageId
    }

    def "should update"() {
        given:
            Mockito.when(mockEmailApi.get(Mockito.anyLong())).thenReturn(new Email(1, oldmail))
        when:
            def emailObj = emailService.update(1, newEmail)
        then:
            noExceptionThrown()
            with(emailObj) {
                email == newEmail
            }
    }
}
