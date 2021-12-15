import org.apache.commons.lang3.ObjectUtils;

public class Calculator {

    public static int sum(int a, int b) {
        return a + b;
    }

    public static float divide(float value, float dividend) {
        if (dividend == 0) {
            return 0;
        }

        return (value / dividend);
    }

    public static Integer absoluteSum(Integer a, Integer b) {
        if (ObjectUtils.isEmpty(a) || ObjectUtils.isEmpty(b)) {
            return null;
        }

        return Math.abs(a) + Math.abs(b);
    }
}
