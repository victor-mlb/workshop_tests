import api.EmailApi
import model.Email
import org.mockito.Mockito
import spock.lang.Specification

class EmailServiceTest extends Specification {


    def "save email"() {
        given:
        Email email = new Email(1222,"guilherme")

        EmailApi mockEmailApi = Mockito.mock(EmailApi)
        Mockito.doNothing().when(mockEmailApi).save(email)

        EmailService emailService = new EmailService(mockEmailApi)

        when:
        def result = emailService.save("lucas")
        then:
        result.email ==  result.email
    }

    def "should return exception in email empty or empty"() {
        given:
        Email mockedList = null

        EmailApi mockEmailApi = Mockito.mock(EmailApi)
        Mockito.doNothing().when(mockEmailApi).save(mockedList)

        EmailService emailService = new EmailService(mockEmailApi)
        when:
        emailService.save(mail)
        then:

        def test = thrown(expectedException)
        test.message == message
        where:
        mail | expectedException | message
        null | RuntimeException  | "Email should not be empty"
        ""   | RuntimeException  | "Email should not be empty"
    }

    def "updade email"() {
        given:
        Email email = new Email(1234,"guilherme")

        EmailApi mockEmailApi = Mockito.mock(EmailApi)
        Mockito.when(mockEmailApi.get(1234)).thenReturn(email)

        EmailService emailService = new EmailService(mockEmailApi)

        when:
        def result = emailService.update(1234,"lucas")
        then:
        result.getId() == email.getId()
        result.email ==  email.email

    }

    def "should return exception in updade email empty or empty"() {
        given:
        Email mockedList = null

        EmailApi mockEmailApi = Mockito.mock(EmailApi)
        Mockito.doNothing().when(mockEmailApi).update(mockedList)

        EmailService emailService = new EmailService(mockEmailApi)

        when:
        emailService.update(id, newEmail)

        then:
        def test = thrown(expectedException)
        test.message == message

        where:
         id   | newEmail     | expectedException | message
         1    | null         | RuntimeException  | "Email should not be empty"
         1    | ""           | RuntimeException  | "Email should not be empty"
         null | "guilherme"  | RuntimeException  | "ID should not be empty"
         0    | "guilherme"  | RuntimeException  | "ID should not be empty"
        -10   | "guilherme"  | RuntimeException  | "ID should not be empty"

    }


    def "should return ordered list"() {
        given:
            List<Email> mockedList = [
                    new Email(1L, 'dbc@mail.com'),
                    new Email(2L, 'abc@mail.com'),
                    new Email(3L, 'cbc@mail.com'),
                    new Email(4L, 'bbc@mail.com'),
            ]

            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            Mockito.when(mockEmailApi.fetchList()).thenReturn(mockedList)

            EmailService emailService = new EmailService(mockEmailApi)
        when:
            def result = emailService.orderedList()
            def result2 = Email.equals(new Object())
        then:
            result == [
                    new Email(2L, 'abc@mail.com'),
                    new Email(4L, 'bbc@mail.com'),
                    new Email(3L, 'cbc@mail.com'),
                    new Email(1L, 'dbc@mail.com')
            ]
        !result2
    }

    def "should return list empty"() {
        given:
        List<Email> mockedList = null

        EmailApi mockEmailApi = Mockito.mock(EmailApi)
        Mockito.when(mockEmailApi.fetchList()).thenReturn(mockedList)

        EmailService emailService = new EmailService(mockEmailApi)
        when:
        def result = emailService.orderedList()
        then:
        result == Collections.emptyList()
    }

}
