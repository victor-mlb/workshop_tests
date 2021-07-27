import api.ListApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Define a function RemoveDuplicate(nlist) to remove duplicate elements from list.
 *  Here are some examples:
 *      null -> []
 *      [] -> []
 *      [1,2] -> [1,2]
 *      [1,1,2,2,3,3] -> [1,2,3]
 **/
public class RemoveDuplicated {
    ListApi listApi;

    public RemoveDuplicated(ListApi listApi) {
        this.listApi = listApi;
    }

    public List<Integer> removeDuplicateValue(){
        List<Integer> list = listApi.findAll();
        if(list == null) return Collections.emptyList();

        return new ArrayList<>(new LinkedHashSet<>(list));
    }
}
