import api.ListApi;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

        if(list == null) {
            return Collections.emptyList();
        }

        return list.stream().distinct().collect(Collectors.toList());
    }
}
