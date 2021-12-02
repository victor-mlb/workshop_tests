import model.Stats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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

    public static Stats process(List<Integer> values){
        Stats stats = new Stats();

        Integer min = Integer.MAX_VALUE;
        Integer max = Integer.MIN_VALUE;
        Integer sum = 0;

        for(Integer v:values){
            min = Math.min(v, min);
            max = Math.max(v, max);
            sum += v;
        }

        int size = values.size();
        stats.setCount(size);
        stats.setMax(max);
        stats.setMin(min);
        stats.setAvg((Double.valueOf(sum)/size));
        stats.setValid(size == 6 && stats.getAvg() >= 20);

        return  stats;
    }
}
