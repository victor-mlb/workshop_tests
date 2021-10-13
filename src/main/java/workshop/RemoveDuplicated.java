package workshop;

import workshop.api.IntegerApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
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

    public static <T> List<T> call(Collection<T> list) {
        if(list == null || list.isEmpty()) return Collections.emptyList();
        return new ArrayList<>(new HashSet<>(list));
    }

    public static <T> List<T> call(T[] list) {
        if(list == null || list.length == 0) return Collections.emptyList();
        return call(Arrays.asList(list));
    }

    public static List<Integer> call(IntegerApi api) {
        return call(api.fetchIntegers());
    }

}
