import api.EmailApi;

import java.util.List;

public class ListEmails {

    private EmailApi emailApi;

    public ListEmails(EmailApi emailApi) {
        this.emailApi = emailApi;
    }

    public List<String> listEmails() {
        return emailApi.listEmails();
    }
}
