import api.ListApi;

import java.util.Collections;
import java.util.List;
import java.util.stream.DoubleStream;

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
        List<Integer> list = listApi.findAll();
        return list.stream().mapToInt(x-> x).min().getAsInt();
    }

    public Integer maxValue(){
        List<Integer> list = listApi.findAll();
        return list.stream().mapToInt(x-> x).max().getAsInt();
    }

    public Integer numberOfElements(){
        return listApi.findAll().size();
    }

    public Double overage() {
        List<Integer> list = listApi.findAll();
        return list.stream().mapToDouble(x -> x).average().getAsDouble();
    }

    public Boolean validation() {
        List<Integer> list = listApi.findAll();
        int count = 0;

        if (list.size() < 6) throw new RuntimeException("The list has less than 6 elements");

        for (int i = 0; i < 6; i++) {
            count = count + list.get(i);
        }

        return count / 6 >= 20;
    }
}
