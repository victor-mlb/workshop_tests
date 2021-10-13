package workshop;

import workshop.api.IntegerApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
        HashSet<T> result = new HashSet<>(list);
        return new ArrayList<>(result);
    }

    public static <T> List<T> call(T[] list) {
        return call(Arrays.asList(list));
    }

    public static List<Integer> call(IntegerApi api) {
        return call(api.fetchIntegers());
    }

}
