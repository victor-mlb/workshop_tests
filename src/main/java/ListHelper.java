import api.ListApi;

import java.util.List;

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

    public static final String NO_ELEMENTS = "No elements";
    private final ListApi listApi;

    public ListHelper(ListApi listApi) {
        this.listApi = listApi;
    }

    public List<Integer> getList() {
        List<Integer> list = this.listApi.fetchList();

        if( list == null || list.isEmpty())
            throw new RuntimeException(NO_ELEMENTS);

        return list;
    }

    public Integer getMin() {
        return getList().stream().min(Integer::compareTo).orElseThrow(() -> new RuntimeException(NO_ELEMENTS));
    }

    public Integer getMax() {
        return getList().stream().max(Integer::compareTo).orElseThrow(() -> new RuntimeException(NO_ELEMENTS));
    }

    public Integer getSize() {
        return getList().size();
    }

    public Double getAverage() {
        return getList().stream().mapToInt(Integer::intValue).average().orElseThrow(() -> new RuntimeException(NO_ELEMENTS));
    }

    public boolean validate() {

        if (getSize() == 6 && getAverage() >= 20 ) {
            return true;
        }

        return false;
    }
}
