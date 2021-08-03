import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main(String[] args) {

        ListHelper listHelper = new ListHelper();
        System.out.println(listHelper.checkMinimum(list()));
        System.out.println(listHelper.checkMaximum(list()));
        System.out.println(listHelper.elementNumberList(list()));
        System.out.println(listHelper.averageList(list()));
        System.out.println(listHelper.validationNumber(list()));

        RemoveDuplicated removeDuplicated = new RemoveDuplicated();
        System.out.println(removeDuplicated.removeDuplicate(list()));
    }

    private static List<Integer> list() {
        List<Integer> list = new ArrayList<>();

        list.add(6);
        list.add(9);
        list.add(15);
        list.add(-2);
        list.add(92);
        list.add(11);

        return list;
    }
}
