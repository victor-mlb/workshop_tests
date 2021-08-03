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
            lista          | exprectedResult
            exampleList()  | orderedList()
            null           | []
    }

    def exampleList() {
        return [
                new Email(1L, 'dbc@mail.com'),
                new Email(2L, 'abc@mail.com'),
                new Email(3L, 'cbc@mail.com'),
                new Email(4L, 'bbc@mail.com'),
        ]
    }

    def orderedList() {
        return [
                new Email(2L, 'abc@mail.com'),
                new Email(4L, 'bbc@mail.com'),
                new Email(3L, 'cbc@mail.com'),
                new Email(1L, 'dbc@mail.com'),
        ]
    }

    @Unroll
    def "should validate before update"() {
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
            1    | null           | "Email should not be empty"
            null | null           | "Email should not be empty"
            -1   | ""             | "Email should not be empty"
    }

    @Unroll
    def "should return update"() {
        given:
            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            Mockito.when(mockEmailApi.get(id)).thenReturn(email)

            Email savedEmail = null
            Mockito.when(mockEmailApi.update(Mockito.any()))
                    .then({ args ->
                        savedEmail = args.getArgument(0)
                    })

            EmailService emailService = new EmailService(mockEmailApi);
        when:
            def result = emailService.update(id, newEmail)
        then:
            result.email == newEmail
            savedEmail.email == newEmail
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
            mail | expectedResult
            ""   | "Email should not be empty"
            null | "Email should not be empty"
    }

    @Unroll
    def "should return save return email"() {
        given:
            EmailApi mockEmailApi = Mockito.mock(EmailApi)

            Email savedEmail = null
            Mockito.when(mockEmailApi.save(Mockito.any()))
                    .then({ args ->
                        savedEmail = args.getArgument(0)
                    })

            EmailService emailService = new EmailService(mockEmailApi)
        when:
            def email = emailService.save(mail)
        then:
            savedEmail.id != null
            savedEmail.email == mail
            email.id == savedEmail.id
            email.email == mail
        where:
            mail          | _
           'abc@mail.com' | _
    }
}
