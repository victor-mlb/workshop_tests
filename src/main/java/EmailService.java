import api.EmailAPI;
import exceptions.EmailListException;
import model.Email;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class EmailService {

    private final EmailAPI emailApi;


    public EmailService(EmailAPI emailApi) {
        this.emailApi = emailApi;
    }

    public Email save(String mail) {
        if (isBlank(mail)) {
            throw new EmailListException("Email should not be empty");
        }

        Email email = new Email();
        email.setId(new Random().nextLong());
        email.setEmail(mail);
        emailApi.save(email);

        return email;
    }

    public Email update(Integer id, String newEmail) throws Exception {
        if (isBlank(newEmail)) {
            throw new EmailListException("Email should not be empty");
        }

        if (id == null || id <= 0) {
            throw new EmailListException("ID should not be empty");
        }

        Email email = emailApi.get(id, emailApi.fetchList());
        email.setEmail(newEmail);
        emailApi.update(email);

        return email;
    }

    private List<Email> list() {
        return isNotEmpty(emailApi) ? emailApi.fetchList() : null;
    }

    public List<Email> orderedList() {
        List<Email> emails = list();

        if (isEmpty(emails)) {
            return Collections.emptyList();
        }

        return emails.stream()
                .sorted(Comparator.comparing(Email::getEmail))
                .collect(Collectors.toList());
    }
}
