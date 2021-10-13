package workshop;

import workshop.api.IntegerApi;
import workshop.model.IntegerStatistics;

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

    public static IntegerStatistics getStatistics(Integer[] values) {
        if(values == null || values.length == 0) return new IntegerStatistics();

        int listSize = values.length;

        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;
        int sum = 0;

        for (Integer value : values) {
            if(value > maximum) maximum = value;
            if(value < minimum) minimum = value;
            sum += value;
        }

        double average = (double)sum / listSize;
        boolean satisfyMagicCondition = listSize == 6 && average >= 20;

        return new IntegerStatistics(minimum, maximum, listSize, average, satisfyMagicCondition);
    }

    public static IntegerStatistics getStatistics(IntegerApi api) {
        return getStatistics(api.fetchIntegers());
    }

    public static IntegerStatistics getStatistics(List<Integer> values) {
        if(values == null) return new IntegerStatistics();
        return getStatistics(values.toArray(new Integer[0]));
    }
}
