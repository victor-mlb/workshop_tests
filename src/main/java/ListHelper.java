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
    public Integer checkMinimum(List<Integer> list) {
        if (list == null) {
            return 0;
        }
        return list.stream()
                .min(Integer::compare)
                .orElse(0);
    }

    public Integer checkMaximum(List<Integer> list) {
        if (list == null) {
            return 0;
        }
        return list.stream()
                .max(Integer::compare)
                .orElse(0);
    }

    public Integer elementNumberList(List<Integer> list) {
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Double averageList(List<Integer> list) {
        if (list == null) {
            return 0d;
        }
        return list.stream()
                .collect(Collectors.averagingInt(cal -> cal));
    }

    public boolean validationNumber(List<Integer> list) {
        return elementNumberList(list) == 6 && averageList(list) >= 20;
    }
}
