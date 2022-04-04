import api.ListApi;

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
public class ListHelper extends ListApi {
    private static final Integer MAX_NUMB_ELEMENTS = 6;
    private static final Integer AVERAGE_VALID=20;

  private ListApi listApi;
  private  List<Integer> list;
  private Integer numbElemnt;



    public ListHelper(ListApi list) {
        this.listApi = list;

    }


  @Override
  public List<Integer> fetchList() {
    return this.listApi.fetchList();


  }

  Integer searchMinimum() {
    if( this.list == null )
        this.list = this.fetchList();
      if (this.list.isEmpty())
        return 0;
      return this.list.stream().min(Comparator.comparing(x -> x)).get();

  }
     Integer searchMaximum(){
       if( this.list == null)
       this.list = this.fetchList();
           if (this.list.isEmpty())
            return 0;
        return this.list.stream().max(Comparator.comparing(x -> x)).get();
    }
     Integer countElements(){
      if(this.list == null)
       this.list = this.fetchList();
        return (int) list.stream().count();
    }
     BigDecimal countAverage(){
        int count = countElements();
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
     Boolean validSequence() {
        return (countElements() == MAX_NUMB_ELEMENTS &&  (countAverage().compareTo(BigDecimal.valueOf(AVERAGE_VALID)) == 1 ));

    }



}
