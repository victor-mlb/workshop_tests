import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
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
    private static final Integer MAX_NUMB_ELEMENTS = 6;
    private static final Integer AVERAGE_VALID=20;
    static Integer searchMinimum(List<Integer> list) {
      if (list.isEmpty())
        return 0;
      return list.stream().min(Comparator.comparing(x -> x)).get();

  }
    static Integer searchMaximum(List<Integer> list){
        if (list.isEmpty())
            return 0;
        return list.stream().max(Comparator.comparing(x -> x)).get();
    }
    static Integer countElements(List<Integer> list){
        return (int) list.stream().count();
    }
    static BigDecimal countAverage(List<Integer> list){
        int count = countElements(list);
        int sum =0;
        BigDecimal avg;
        for (Integer item : list) {
            sum += item;
        }
            if( sum != 0 && count!= 0) {
                avg = BigDecimal.valueOf(sum).divide(BigDecimal.valueOf(count),6, RoundingMode.HALF_UP);
                return avg;
            } else {
                return new BigDecimal(0);
            }
    }
    static Boolean validSequence(List<Integer> list) {
        return (countElements(list) == MAX_NUMB_ELEMENTS &&  (countAverage(list).compareTo(BigDecimal.valueOf(AVERAGE_VALID)) == 1 ));

    }



}
