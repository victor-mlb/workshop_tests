public class Teste {

    public static void main(String[] args) {

        ListHelper listHelper = new ListHelper();
        System.out.println(listHelper.checkMinimum());
        System.out.println(listHelper.checkMaximum());
        System.out.println(listHelper.elementNumberList());
        System.out.println(listHelper.averageList());
        System.out.println(listHelper.validationNumber());

        RemoveDuplicated removeDuplicated = new RemoveDuplicated();
        System.out.println(removeDuplicated.removeDuplicate());
    }
}
