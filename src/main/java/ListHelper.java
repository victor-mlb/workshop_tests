import api.ListApi;
import model.Email;

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

    private final Integer   REFERENCE_LIST_SIZE = 6;
    private final Double    REFERENCE_LIST_AVG  = 20.0;
    private final ListApi   listApi;

    public ListHelper(ListApi listApi){
        this.listApi = listApi;
    }

    private List<Integer> list() {
        List<Integer> listElemments = listApi.fetchList();
        if (listElemments == null || listElemments.isEmpty() ){
            throw new RuntimeException("Elemments not found!");
        }
        return listElemments;
    }

    public Integer minValue(){
        return this.list().stream().min(Comparator.comparing(x -> x)).get();
    }

    public Integer maxValue(){
        return list().stream().max(Comparator.comparing(x -> x)).get();
    }

    public Integer sequenceSize(){
        return list().size();
    }

    public Double avgValue(){
        return list().stream().mapToDouble(x -> x).average().getAsDouble();
    }

    public Boolean valueVerification(){
        List<Integer> listElemments = list();

        if (listElemments.size() == REFERENCE_LIST_SIZE && listElemments.stream()
                                                            .mapToDouble(x -> x)
                                                                    .average()
                                                                    .getAsDouble() >= REFERENCE_LIST_AVG){
            return true;
        }
        return false;
    }
}
