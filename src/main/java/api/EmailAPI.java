package api;

import exceptions.EmailListException;
import model.Email;

import java.util.List;

public class EmailAPI {

    public static Email get(int id, List<Email> emailList) {
        return emailList.stream().filter(idList -> idList.getId() == id).findFirst().get();
    }

    public static void save(Email email) {
        throw new EmailListException("DON'T IMPLEMENT NOR REMOVE IT");
    }

    public static void update(Email email) {
        throw new EmailListException("DON'T IMPLEMENT NOR REMOVE IT");
    }

    public List<Email> fetchList() {
        throw new EmailListException("DON'T IMPLEMENT NOR REMOVE IT");
    }
}
