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

    private List<Integer> list() {
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(1);
        lista.add(2);
        lista.add(2);
        lista.add(3);
        lista.add(3);

        return lista;
    }

    public List<Integer> removeDuplicate() {
        return list().stream()
                .distinct().collect(Collectors.toList());
    }
}
