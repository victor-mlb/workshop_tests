import abstracts.APIAbstract;
import api.ListHelperAPI;

import java.text.DecimalFormat;
import java.util.Comparator;

import static java.lang.Double.parseDouble;

/**
 * Your task is to process a sequence of integer numbers to determine the following statistics:
 * <p>
 * o) minimum value
 * o) maximum value
 * o) number of elements in the sequence
 * o) average value
 * o) number of elements in the sequence == 6 && average value >= 20
 * <p>
 * For example: [6, 9, 15, -2, 92, 11]
 * <p>
 * o) minimum value = -2
 * o) maximum value = 92
 * o) number of elements in the sequence = 6
 * o) average value = 21.833333
 * o) true
 * <p>
 * EXTRA CHALLENGE:
 * Get the list of numbers from an API (check EmailApi for examples)
 */
public class ListHelper extends APIAbstract {

    public ListHelper(ListHelperAPI listHelperValue) {
        super(listHelperValue);
    }

    public Integer minimumValue() {
        return listHelper
                .fetchList()
                .stream()
                .min(Comparator.naturalOrder())
                .get();
    }

    public Integer maximumValue() {
        return listHelper
                .fetchList()
                .stream()
                .max(Comparator.naturalOrder())
                .get();
    }

    public Integer numberOfElementsInTheSequence() {
        return listHelper
                .fetchList()
                .size();
    }

    public Double averageValue() {
        return round(listHelper
                .fetchList()
                .stream().
                mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0));
    }

    private Double round(Double value) {
        return parseDouble(new DecimalFormat("#,##0.000000")
                .format(value)
                .replace(",", "."));
    }

    public Boolean compereElementsInTheSequenceAndAverage() {
        return numberOfElementsInTheSequence() == 6 && averageValue() >= 20;
    }
}
