import api.ListApi;

import java.util.Collections;
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

    ListApi listApi;

    public ListHelper(ListApi listApi) {
        this.listApi = listApi;
    }

    public Integer minValue(){
        List<Integer> list = findAll();
        return list.stream().mapToInt(x-> x).min().orElseThrow(() -> new RuntimeException("Empty List"));
    }

    public Integer maxValue(){
        List<Integer> list = findAll();
        return list.stream().mapToInt(x-> x).max().orElseThrow(() -> new RuntimeException("Empty List"));
    }

    public Integer numberOfElements(){
        return listApi.findAll().size();
    }

    public Double average() {
        List<Integer> list = findAll();
        return average(list);
    }

    public Boolean validation() {
        List<Integer> list = findAll();

        if (list.size() != 6) {
            throw new RuntimeException("The list need has 6 elements");
        }

        return average(list) >= 20;
    }

    private Double average(List<Integer> list) {
        return list.stream().mapToDouble(x -> x).average().orElseThrow(() -> new RuntimeException("Empty List"));
    }

    private List<Integer> findAll() {
        List<Integer> list = listApi.findAll();
        if(list == null) {
            return Collections.emptyList();
        }
        return list;
    }
}
