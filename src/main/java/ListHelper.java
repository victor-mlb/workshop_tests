import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * Your task is to process a sequence of integer numbers to determine the following statistics:
 *
 *     o) minimum value
 *     o) maximum value
 *     o) number of elements in the sequence
 *     o) average value
 *     o) number of elements in the sequence == 6 && average value >= 20
 *
 * For example: [6, 9, 15, -2, 92, 11]
 *
 *     o) minimum value = -2
 *     o) maximum value = 92
 *     o) number of elements in the sequence = 6
 *     o) average value = 21.833333
 *     o) true
 *
 * EXTRA CHALLENGE:
 * Get the list of numbers from an API (check EmailApi for examples)
 */
public class ListHelper {

    private List<Integer> list() {
        List<Integer> lista = new ArrayList<>();
        lista.add(6);
        lista.add(9);
        lista.add(15);
        lista.add(-2);
        lista.add(92);
        lista.add(11);

        return lista;
    }

    public Integer checkMinimum() {
        return list().stream()
                .min(Integer::compare).get();
    }

    public Integer checkMaximum() {
        return list().stream()
                .max(Integer::compare).get();
    }

    public Integer elementNumberList() {
        return list().size();
    }

    public Double averageList() {
        return list().stream()
                .collect(Collectors.averagingInt(cal -> cal));
    }

    public boolean validationNumber() {
        if (elementNumberList() == 6 && averageList() >= 20) {
            return true;
        }

        return false;
    }

}
