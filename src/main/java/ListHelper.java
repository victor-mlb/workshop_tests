import api.ListApi;

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

    private static final String ERROR_NULL_NUMBER = "There are no elements in the list";
    private ListApi listApi;

    public ListHelper(ListApi listApi){
        this.listApi = listApi;
    }

    private List<Integer> getList(){
        List<Integer> list = this.listApi.fetchList();
        if(list.isEmpty()){
            throw new RuntimeException("List is not should be empty");
        }
        return list;
    }

    public Integer min(){
        return getList().stream().min(Comparator.comparing(Integer::valueOf)).orElseThrow(() -> new RuntimeException(ERROR_NULL_NUMBER));
    }

    public Integer max(){
        return getList().stream().max(Comparator.comparing(Integer::valueOf)).orElseThrow(() -> new RuntimeException(ERROR_NULL_NUMBER));
    }

    public Integer numberOfElements(){
        return getList().size();
    }

    public double average(){
        return getList().stream().mapToInt(Integer::intValue).average().orElseThrow(() -> new RuntimeException(ERROR_NULL_NUMBER));
    }

    public boolean validationList(){

        if(numberOfElements() == 6 && average() >= 20){
            return true;
        }
        return false;
    }

}
