package workshop.model;

public class IntegerStatistics {
    private Integer minimum = 0;

    private Integer maximum = 0;

    private Integer size = 0;

    private Double average = 0d;

    private boolean satisfyCondition = false;

    public IntegerStatistics() { }

    public IntegerStatistics(Integer minimum, Integer maximum, Integer size, Double average, boolean satisfyCondition) {
        this.minimum = minimum;
        this.maximum = maximum;
        this.size = size;
        this.average = average;
        this.satisfyCondition = satisfyCondition;
    }

    public Integer getMinimum() {
        return minimum;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public Integer getSize() {
        return size;
    }

    public Double getAverage() {
        return average;
    }

    public boolean isSatisfyCondition() {
        return satisfyCondition;
    }
}
