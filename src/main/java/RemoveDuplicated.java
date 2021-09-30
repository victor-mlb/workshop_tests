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

    public static <T> List<T> removeDuplicate(List<T> list) {

        if(list == null || list.isEmpty())
            return Collections.emptyList();

        return list.stream().distinct().collect(Collectors.toList());
    }
}
