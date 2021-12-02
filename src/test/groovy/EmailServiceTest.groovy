import api.EmailApi
import model.Email
import org.mockito.Mockito
import spock.lang.Specification

class EmailServiceTest extends Specification {

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

    def "should return empty list"() {
        given:
            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            Mockito.when(mockEmailApi.fetchList()).thenReturn(null)
            EmailService emailService = new EmailService(mockEmailApi)
        when:
            def result = emailService.orderedList()
        then:
            result == []
    }

    def "should throw exception when email is null"() {
        given:
            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            EmailService emailService = new EmailService(mockEmailApi)
        when:
            def result = emailService.save(null)
        then:
            thrown(RuntimeException)
    }

    def "should throw exception when email is empty"() {
        given:
            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            EmailService emailService = new EmailService(mockEmailApi)
        when:
            def result = emailService.save("")
        then:
            thrown(RuntimeException)
    }

    def "should save"() {
        given:
            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            EmailService emailService = new EmailService(mockEmailApi)
        when:
            def result = emailService.save("alex.rodin@mercadolivre.com")
        then:
            result != null
    }

    def "should throw exception when email is null on update"() {
        given:
            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            EmailService emailService = new EmailService(mockEmailApi)
        when:
            def result = emailService.update(1l, null)
        then:
            thrown(RuntimeException)
    }

    def "should throw exception when email is empty on update"() {
        given:
            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            EmailService emailService = new EmailService(mockEmailApi)
        when:
            def result = emailService.update(1l, "")
        then:
            thrown(RuntimeException)
    }

    def "should throw exception when id is null on update"() {
        given:
            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            EmailService emailService = new EmailService(mockEmailApi)
        when:
            def result = emailService.update(null, "teste@email.com")
        then:
            thrown(RuntimeException)
    }

    def "should throw exception when id is less or equal then zero on update"() {
        given:
            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            EmailService emailService = new EmailService(mockEmailApi)
        when:
            def result = emailService.update(0, "teste@email.com")
        then:
            thrown(RuntimeException)
    }

    def "should update"() {
        given:
            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            Mockito.when(mockEmailApi.get(1l)).thenReturn(new Email())
            EmailService emailService = new EmailService(mockEmailApi)
        when:
            def result = emailService.update(1l, "alex.rodin@mercadolivre.com")
        then:
            result != null
    }
}
