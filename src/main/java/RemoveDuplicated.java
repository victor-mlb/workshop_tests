import java.util.ArrayList;
import java.util.List;
/**
 * Define a function RemoveDuplicate(nlist) to remove duplicate elements from list.
 *  Here are some examples:
 *      null -> []
 *      [] -> []
 *      [1,2] -> [1,2]
 *      [1,1,2,2,3,3] -> [1,2,3]
 **/
public class RemoveDuplicated {
   public static List<Integer> removeDuplicate(List<Integer> list){
       List<Integer> newList = new ArrayList<>();
       if(list == null || list.isEmpty()) {
           return newList;
       } else {
           for (Integer item : list) {
               if (!newList.contains(item)) {
                   newList.add(item);
               }
           }
       }
       return newList;
   }
}
