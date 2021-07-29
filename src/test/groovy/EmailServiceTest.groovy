import api.EmailApi
import model.Email
import org.mockito.Mockito
import spock.lang.Specification
import spock.lang.Unroll

class EmailServiceTest extends Specification {

    EmailApi mockEmailApi
    EmailService emailService

    def setup(){
        mockEmailApi = Mockito.mock(EmailApi)
        emailService = new EmailService(mockEmailApi)
    }

    def "should save email"() {
        given:
            String emailTest = "nome@email.com"
            Mockito.doNothing().when(mockEmailApi).save(Mockito.any(Email))
        when:
            Email emailResult = emailService.save(emailTest)
        then:
            emailTest == emailResult.email
            emailResult.id > 0
    }

    @Unroll
    def "should not save email"() {
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
            Mockito.when(mockEmailApi.get(Mockito.any())).thenReturn(new Email(1L, "name@email.com"))
            Mockito.doNothing().when(mockEmailApi).update(Mockito.any())
        when:
            Email result = emailService.update(1L, "new@email.com")
        then:
            result.email == "new@email.com"
            result.id == 1L
    }

    @Unroll
    def "should not update email"() {
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
            "nome@email" |    0L    | "ID should not be empty"
    }

    def "should return ordered list"() {
        given:
            List<Email> mockedEmails = [
                    new Email(1L, 'dbc@mail.com'),
                    new Email(2L, 'abc@mail.com'),
                    new Email(3L, 'cbc@mail.com'),
                    new Email(4L, 'bbc@mail.com')
            ]

            Mockito.when(mockEmailApi.fetchList()).thenReturn(mockedEmails)
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

    @Unroll
    def "should return empty list"() {
        given:
            Mockito.when(mockEmailApi.fetchList()).thenReturn(apiList)
        when:
            def result = emailService.orderedList()
        then:
            result == [ ]
        where:
            apiList  | _
            []       | _
            null     | _
    }

}
