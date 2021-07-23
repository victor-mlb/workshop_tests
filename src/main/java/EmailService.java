import api.EmailApi;
import model.Email;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class EmailService {

    private final EmailApi emailApi;


    public EmailService(EmailApi emailApi) {
        this.emailApi = emailApi;
    }

    public Email save(String mail) {
        Email email = new Email();
        email.setId(new Random().nextLong());
        email.setEmail(mail);
        emailApi.save(email);

        return email;
    }

    public Email update(Long id, String newEmail) {
        Email email = emailApi.get(id);
        email.setEmail(newEmail);
        emailApi.update(email);

        return email;
    }

    public List<Email> list() {
        return emailApi.fetchList();
    }

    public List<Email> orderedList() {
        List<Email> emails = emailApi.fetchList();

        return emails.stream()
                .sorted(Comparator.comparing(Email::getEmail))
                .collect(Collectors.toList());
    }
}
