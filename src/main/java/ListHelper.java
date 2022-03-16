import api.ListApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

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

    public static final Integer SIZE_VALIDATE = 6;
    public static final Integer AVERAGE_VALIDATE = 20;
    public static final String MESSAGE_ERROR_LIST = "Empty or null list";

    private ListApi list;
    private List<Integer> listApi;

    public ListHelper(ListApi list) {
        this.list = list;
    }

    public List<Integer> getList() {
        if(this.listApi == null)
            this.listApi = list.fetchList();

        if(this.listApi == null || this.listApi.isEmpty())
            throw new NoSuchElementException(MESSAGE_ERROR_LIST);

        return this.listApi;
    }

    public Integer getMinValue() {
       return getList().stream().mapToInt(v -> v).min().getAsInt();
    }

    public Integer getMaxValue() {
        return getList().stream().mapToInt(v -> v).max().getAsInt();
    }

    public Integer getSize() {
        return getList().size();
    }

    public Double getAverage() {
        return getList().stream().mapToInt(v -> v).average().getAsDouble();
    }

    public Boolean isValid() {
        if (getSize() == SIZE_VALIDATE && getAverage() >= AVERAGE_VALIDATE)
            return true;

        return false;
    }



}
