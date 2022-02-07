import api.EmailApi
import model.Email
import org.mockito.Mockito
import spock.lang.Specification
import spock.lang.Unroll

class EmailServiceTest extends Specification {

    private String

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

    def "should save email"(){
        given:
            String email = "test@email.com"
        when:
            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            EmailService emailService = new EmailService(mockEmailApi)
            def emailResponse = emailService.save(email)
        then:
            emailResponse != null

    }

    @Unroll
    def "should exception save email"(){
        when:
            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            EmailService emailService = new EmailService(mockEmailApi)
            def emailResponse = emailService.save(email)
        then:
             def ex = thrown(RuntimeException)
             ex.message == expectedMessage
        where:
            email | expectedMessage
            null  | "Email should not be empty"
            ''    | "Email should not be empty"
    }

    def "should update email"(){
        given:
             EmailApi mockEmailApi = Mockito.mock(EmailApi)
             Mockito.when(mockEmailApi.get(Mockito.anyLong())).thenReturn(new Email(10l, "test@email.com"))
             EmailService emailService = new EmailService(mockEmailApi)
        when:
             def result = emailService.update(10l,"test@email.com")
        then:
            result.id == 10l
            result.email == "test@email.com"

    }

    @Unroll
    def "should exception update email"(){
        when:
            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            EmailService emailService = new EmailService(mockEmailApi)
            def result = emailService.update(id, email)
        then:
            def ex = thrown(RuntimeException)
            ex.message == expectedResult
        where:
            id     | email              | expectedResult
            1      | null               | "Email should not be empty"
            1      | ''                 | "Email should not be empty"
            null   | "test@email.com"  | "ID should not be empty"
            -1     | "test@email.com"  | "ID should not be empty"


    }
}
