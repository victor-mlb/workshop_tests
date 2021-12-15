import abstracts.APIAbstract;
import api.ListHelperAPI;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Define a function RemoveDuplicate(nlist) to remove duplicate elements from list.
 * Here are some examples:
 * null -> []
 * [] -> []
 * [1,2] -> [1,2]
 * [1,1,2,2,3,3] -> [1,2,3]
 **/
public class RemoveDuplicated extends APIAbstract {

    public RemoveDuplicated(ListHelperAPI listHelperValue) {
        super(listHelperValue);
    }

    public List<Integer> RemoveDuplicate() {
        if (ObjectUtils.isEmpty(listHelper.fetchList())) {
            return Collections.emptyList();
        }
        return listHelper.fetchList().stream().distinct().collect(Collectors.toList());
    }

    public void clear(){
        listHelper.clearList();
    }
}
