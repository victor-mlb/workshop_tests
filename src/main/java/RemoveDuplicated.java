import api.NumbersApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Define a function RemoveDuplicate(nlist) to remove duplicate elements from list.
 *  Here are some examples:
 *      null -> []
 *      [] -> []
 *      [1,2] -> [1,2]
 *      [1,1,2,2,3,3] -> [1,2,3]
 **/
public class RemoveDuplicated {

    public List<Integer> distinctListOrder(Integer[] numbers){
        if (numbers == null || numbers.length == 0){
            return new ArrayList<>();
        }
        Integer[] num = numbers;
        List<Integer> distinctList = Arrays.asList(num).stream().distinct().collect(Collectors.toList());
        Collections.sort(distinctList);
        return distinctList;
    }









//    private final NumbersApi numbersApi;
//
//    public RemoveDuplicated(NumbersApi numbersApi) {
//        this.numbersApi = numbersApi;
//    }
//
//    private int[] getArrayOfnumbers() {
//        return numbersApi.arrayOfNumber();
//    }
//
//    private int[] removeDuplicateElements(int arr[], int n){
//
//        int[] tempA = new int[n];
//        int j = 0;
//        for (int i=0; i<n-1; i++){
//            if (arr[i] != arr[i+1]){
//                tempA[j++] = arr[i];
//            }
//        }
//        tempA[j++] = arr[n-1];
//        for (int i=0; i<j; i++){
//            arr[i] = tempA[i];
//        }
//        return tempA;
//    }
//
//    public void elements() {
//
//        int[] numbers = getArrayOfnumbers();
//        int[] empty = {};
//        if(numbers == null || numbers == empty) {
//            return empty;
//        }
//
//        Integer[] ja = {1,2,3,3,4,5,6,6,8,9};
//        List<Integer> distinctList = Arrays.asList(ja).stream().distinct().collect(Collectors.toList());
//    }

    }
