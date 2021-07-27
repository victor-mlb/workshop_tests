import api.EmailApi
import model.Email
import net.bytebuddy.asm.Advice
import net.bytebuddy.implementation.bytecode.Throw
import org.mockito.Mockito
import spock.lang.Specification
import spock.lang.Unroll

class EmailServiceTest extends Specification {


    def "should save email"() {
        given:
            String emailTest = "nome@email.com" // olhar isso
            Email expectedEmail = new Email(1L, emailTest)

            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            Mockito.doNothing().when(mockEmailApi).save(expectedEmail)
            EmailService emailService = new EmailService(mockEmailApi)

        when:
            Email emailResult = emailService.save(emailTest)

        then:
            emailTest == emailResult.email
    }

    @Unroll
    def "should not save email"() {
        given:
            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            EmailService emailService = new EmailService(mockEmailApi)
        when:
           emailService.save(email)
        then:
            def e = thrown(RuntimeException)
            e.message == "Email should not be empty"
        where:
            email | _
            null  | _
            ''    | _
    }

    def "should update email"() {
        given:
            Email expectedEmail = new Email(1L, "novo@email.com")

            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            Mockito.when(mockEmailApi.get(1L)).thenReturn(new Email(1L, "nome@email.com"))
            Mockito.doNothing().when(mockEmailApi).update(expectedEmail)
            EmailService emailService = new EmailService(mockEmailApi)
        when:
            Email result = emailService.update(1L, "novo@email.com")
        then:
            expectedEmail.email == result.email
    }

    @Unroll
    def "should not update email"() {
        given:
            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            EmailService emailService = new EmailService(mockEmailApi)
        when:
            emailService.update(id, email)
        then:
            def e = thrown(RuntimeException)
            e.message == expectedMessage
        where:
               email     |    id    | expectedMessage
                null     |    1L    | "Email should not be empty"
                ''       |    1L    | "Email should not be empty"
            "nome@email" |   null   | "ID should not be empty"
            "nome@email" |   -1L    | "ID should not be empty"
    }

    def "should return ordered list"() {
        given:
            List<Email> mokedEmails = [
                    new Email(1L, 'dbc@mail.com'),
                    new Email(2L, 'abc@mail.com'),
                    new Email(3L, 'cbc@mail.com'),
                    new Email(4L, 'bbc@mail.com')
            ]

        EmailApi mockEmailApi = Mockito.mock(EmailApi)
        Mockito.when(mockEmailApi.fetchList()).thenReturn(mokedEmails)
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

    def "should return empty list"() {
        given:
            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            Mockito.when(mockEmailApi.fetchList()).thenReturn(Collections.emptyList())
            EmailService emailService = new EmailService(mockEmailApi)

        when:
            def result = emailService.orderedList()

        then:
            result == [ ]

    }

}
