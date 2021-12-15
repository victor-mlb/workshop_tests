package abstracts;

import api.ListHelperAPI;

public abstract class APIAbstract {

    public ListHelperAPI listHelper;

    public APIAbstract(ListHelperAPI listHelperValue) {
        listHelper = listHelperValue;
    }
}
