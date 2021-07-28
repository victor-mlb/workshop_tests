import api.EmailApi
import model.Email
import org.mockito.Mockito
import spock.lang.Specification

class EmailServiceTest extends Specification {


    private static final String ERRO_NO_EMAIL = "Email should not be empty"
    private static final String ERRO_NO_ID = "ID should not be empty"

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

    def "should return empty list"(){
        given:
            List<Email> mockedNullList = null;

            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            Mockito.when(mockEmailApi.fetchList()).thenReturn(mockedNullList)

            EmailService emailService = new EmailService(mockEmailApi)
        when:
            def result = emailService.orderedList()
        then:
            result == []
    }


    def "should return empty list 2"(){
        given:
            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            Mockito.when(mockEmailApi.fetchList()).thenReturn(mockedNullList)

            EmailService emailService = new EmailService(mockEmailApi)
        when:
            def result = emailService.orderedList()
        then:
            result == expectedresult
        where:
            mockedNullList          | expectedresult
            null                    | []
    }


    def "should error to save email" (){
        given:
            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            EmailService mockEmailService = new EmailService(mockEmailApi)

        when:
            mockEmailService.save(inputEmail)

        then:
            def error = thrown(expectedErro)
            error.message == expectedMessage
        where:
            inputEmail    || expectedErro       | expectedMessage
            null          || RuntimeException   | ERRO_NO_EMAIL
            ""            || RuntimeException   | ERRO_NO_EMAIL
    }

    def "should save email" (){
        given: "An email that does not exist in the system database"
            Email mockedEmail = new Email(1, "pessoal@email.com");

        and: "an instance of the service class"
            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            EmailService emailService = new EmailService(mockEmailApi)

        when:
            def result = emailService.save("pessoal@email.com")

        then:
            result.getEmail() == mockedEmail.getEmail()
    }


    def "should error to update with invalid email" (){
        given:
            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            EmailService mockEmailService = new EmailService(mockEmailApi)

        when:
            mockEmailService.update(inputId, inputEmail)

        then:
            def error = thrown(expectedErro)
            error.message == expectedMessage
        where:
            inputEmail       | inputId    || expectedErro       | expectedMessage
            null             | 1          || RuntimeException   | ERRO_NO_EMAIL
            null             | 0          || RuntimeException   | ERRO_NO_EMAIL
            null             | -1         || RuntimeException   | ERRO_NO_EMAIL
            null             | null       || RuntimeException   | ERRO_NO_EMAIL
            ""               | 1          || RuntimeException   | ERRO_NO_EMAIL
            ""               | 0          || RuntimeException   | ERRO_NO_EMAIL
            ""               | -1         || RuntimeException   | ERRO_NO_EMAIL
            ""               | null       || RuntimeException   | ERRO_NO_EMAIL
    }

    def "should error to update with invalid id" (){
        given:
            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            EmailService mockEmailService = new EmailService(mockEmailApi)

        when:
            mockEmailService.update(inputId, inputEmail)

        then:
            def error = thrown(expectedErro)
            error.message == expectedMessage
        where:
            inputEmail       | inputId    || expectedErro       | expectedMessage
            "test@email.com" | null       || RuntimeException   | ERRO_NO_ID
            "test@email.com" | 0          || RuntimeException   | ERRO_NO_ID
            "test@email.com" | -1         || RuntimeException   | ERRO_NO_ID

    }

    def "should error to update with nonexistent email" (){
        given:
            String new_email_address = "new_test@email.com"
            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            Mockito.when(mockEmailApi.get(1L)).thenReturn(null)
            EmailService mockEmailService = new EmailService(mockEmailApi)

        when:
            mockEmailService.update(1L, new_email_address)

        then:
            thrown(NullPointerException)
    }

    def "should update email" (){
        given:
            String new_email_address = "new_test@email.com"
            Email mockedEmail = new Email(1L, "test@email.com")
            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            Mockito.when(mockEmailApi.get(1L)).thenReturn(mockedEmail)
            EmailService mockEmailService = new EmailService(mockEmailApi)

        when:
            def result = mockEmailService.update(1L, new_email_address)

        then:
            result.getEmail() == new_email_address
    }


}
