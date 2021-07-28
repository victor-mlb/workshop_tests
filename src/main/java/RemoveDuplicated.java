import api.ListApi;

import java.util.ArrayList;
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

    public List<Integer> removeDuplicate(List<Integer> numberList){
        if (numberList == null || numberList.isEmpty()){
            return new ArrayList<>();
        }
        return numberList.stream().distinct().collect(Collectors.toList());
    }
}
