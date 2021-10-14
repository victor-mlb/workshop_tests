import api.EmailApi;
import api.NumbersApi;
import jdk.nashorn.internal.runtime.linker.JavaAdapterFactory;
import model.Email;
import model.Numbers;

import java.util.Collections;
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

    private final NumbersApi numbersApi;

    public ListHelper(NumbersApi numbersApi) {
        this.numbersApi = numbersApi;
    }

    private int[] getArrayOfnumbers() {
        return numbersApi.arrayOfNumber();
    }

    public Integer maximunValue() {
        int[] numbers = getArrayOfnumbers();

        if(numbers == null) {
            return null;
        }

        int maior = numbers[0];
        for (int i = 1 ; i < numbers.length; i++){
            if ( numbers[i] > maior) {
                maior = numbers[i];
            }
        }
        return maior;
    }

    public Integer minimunValue() {
        int[] numbers = getArrayOfnumbers();

        if(numbers == null) {
            return null;
        }

        int menor = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if(numbers[i] < menor){
                menor = numbers[i];
            }
        }
        return menor;
    }

    public Integer numberOfElements() {
        int[] numbers = getArrayOfnumbers();

        if(numbers == null) {
            return null;
        }

        int numberOfElements =  numbers.length;
        return numberOfElements;
    }

    public Double averege(){
        int[] numbers = getArrayOfnumbers();

        if(numbers == null) {
            return null;
        }

        double total = 0;

        for(int i=0; i<numbers.length; i++){
            total = total + numbers[i];
        }

        double average = total / numbers.length;

        return average;
    }

    public Boolean numberOfSequenceTrueOrFalse(){
        int[] numbers = getArrayOfnumbers();

        if(numbers == null) {
            return null;
        }

        double average = averege();
        int numberOfElements = numberOfElements();
        if (numberOfElements == 6 && average >= 20){
            return true;
        }
        return false;
    }
}

