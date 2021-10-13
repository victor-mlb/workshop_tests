package workshop;

public class Calculator {

    public static int sum(int a, int b) {
        return a + b;
    }

    public static float divide(float value, float dividend) {
        if(dividend == 0) {
            return 0;
        }

        return (value / dividend);
    }

    public static Integer absoluteSum(Integer a, Integer b) {
        if(a == null || b == null) {
            return null;
        }

        return Math.abs(a) + Math.abs(b);
    }
}
