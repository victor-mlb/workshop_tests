import api.EmailApi
import model.Email
import org.mockito.Mockito
import spock.lang.Specification
import spock.lang.Unroll

class EmailServiceTest extends Specification {

    def "should return ordered list"() {
        given:
            List<Email> mockedList = lista

            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            Mockito.when(mockEmailApi.fetchList()).thenReturn(mockedList)

            EmailService emailService = new EmailService(mockEmailApi)
        when:
            def result = emailService.orderedList()
        then:
            result == exprectedResult
        where:
            lista                                                                                                                          | exprectedResult
            [new Email(1L, 'dbc@mail.com'), new Email(2L, 'abc@mail.com'), new Email(3L, 'cbc@mail.com'),  new Email(4L, 'bbc@mail.com')]  | [new Email(2L, 'abc@mail.com'),new Email(4L, 'bbc@mail.com'),new Email(3L, 'cbc@mail.com'),new Email(1L, 'dbc@mail.com')]
            null                                                                                                                           | []
    }

    @Unroll
    def "should return update"() {
        given:
            EmailApi mockEmailApi = Mockito.mock(EmailApi)

            EmailService emailService = new EmailService(mockEmailApi);
        when:
            emailService.update(id, newEmail)
        then:
            def msg = thrown(RuntimeException)
            msg.message == expectedResult
        where:
            id   | newEmail       | expectedResult
            0    | 'tes@mail.com' | "ID should not be empty"
            null | 'tes@mail.com' | "ID should not be empty"
            -1   | null           | "Email should not be empty"
            null | null           | "Email should not be empty"
            -1   | ""             | "Email should not be empty"
    }

    @Unroll
    def "should return update "() {
        given:
            Email mockEmail = email

            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            Mockito.when(mockEmailApi.get(id))thenReturn(mockEmail)

            EmailService emailService = new EmailService(mockEmailApi);

        when:
            emailService.update(id, newEmail)
        then:
            newEmail
        where:
            id  | newEmail       | email
            1L  | 'bbb@mail.com' | new Email(1L, 'dbc@mail.com')
    }

    @Unroll
    def "should return save"() {
        given:
            EmailApi mockEmailApi = Mockito.mock(EmailApi)

            EmailService emailService = new EmailService(mockEmailApi);
        when:
            emailService.save(mail)
        then:
            def msg = thrown(RuntimeException)
            msg.message == expectedResult
        where:
            mail           | expectedResult
            ""             | "Email should not be empty"
            null           | "Email should not be empty"
    }

    @Unroll
    def "should return save return email"() {
        given:
            EmailApi mockEmailApi = Mockito.mock(EmailApi)

            EmailService emailService = new EmailService(mockEmailApi)
        when:
             emailService.save(mail)
        then:
             mail
        where:
            mail          | _
           'abc@mail.com' | _

    }
}
