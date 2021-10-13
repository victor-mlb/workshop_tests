package workshop

import workshop.api.EmailApi
import workshop.model.Email
import org.mockito.Mockito
import spock.lang.Specification

class EmailServiceTest extends Specification {

    def "should throw exception if save email with invalid mail"() {
        given:
            EmailApi emailApi = Mockito.mock(EmailApi.class)
            EmailService emailService = new EmailService(emailApi)
        when:
            emailService.save(mail)
        then:
            def error = thrown(expectedException)
            error.message == messsage
        where:
            mail || expectedException || messsage
            null  || RuntimeException  || "Email should not be empty"
            ""    || RuntimeException  || "Email should not be empty"
    }

    def "should throw exception if update email with invalid mail"() {
        given:
            EmailApi emailApi = Mockito.mock(EmailApi.class)
            EmailService emailService = new EmailService(emailApi)
        when:
            emailService.update(id, mail)
        then:
            def error = thrown(expectedException)
            error.message == messsage
        where:
            mail  | id || expectedException || messsage
            null  | 1  || RuntimeException  || "Email should not be empty"
            ""    | 1  || RuntimeException  || "Email should not be empty"
    }

    def "should throw exception if update email with invalid id"() {
        given:
            EmailApi emailApi = Mockito.mock(EmailApi.class)
            EmailService emailService = new EmailService(emailApi)
        when:
            emailService.update(id, mail)
        then:
            def error = thrown(expectedException)
            error.message == messsage
        where:
        mail     | id    || expectedException || messsage
        "email"  | 0     || RuntimeException  || "ID should not be empty"
        "email"  | null  || RuntimeException  || "ID should not be empty"
    }

    def "should save email if mail is valid"() {
        given:
            Email email = new Email(1, input)
            EmailApi emailApi = Mockito.mock(EmailApi.class)
            EmailService emailService = new EmailService(emailApi)
            Mockito.doNothing().when(emailApi).save(email)
        when:
            Email savedEmail = emailService.save(input)
        then:
            savedEmail.getEmail() == input
            savedEmail.getId() != 0
        where:
            input   | output
            "mail"  | _
    }

    def "should update email if id and mail is valid"() {
        given:
            Email email = new Email(id, input)
            EmailApi emailApi = Mockito.mock(EmailApi.class)
            EmailService emailService = new EmailService(emailApi)
            Mockito.when(emailApi.get(id)).thenReturn(email)
        when:
            Email updatedEmail = emailService.update(id, newEmail)
        then:
            updatedEmail.getEmail() == newEmail
            updatedEmail.getId() == id
        where:
            input  | id | newEmail   | output
            "mail" | 1  | "newEamil" | _
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

    def "should return empty collection if not exist email"() {
        given:
            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            Mockito.when(mockEmailApi.fetchList()).thenReturn(null)
            EmailService emailService = new EmailService(mockEmailApi)
        when:
            def result = emailService.orderedList()
        then:
            result == Collections.emptyList()
    }
}
