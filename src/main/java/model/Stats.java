package model;

import java.util.Objects;

public class Stats {
    private Integer min;
    private Integer max;
    private Integer count;
    private Double avg;
    private Boolean isValid;

    public Stats() {
    }

    public Stats(Integer min, Integer max, Integer count, Double avg, Boolean isValid) {
        this.min = min;
        this.max = max;
        this.count = count;
        this.avg = avg;
        this.isValid = isValid;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stats stats = (Stats) o;
        return Objects.equals(min, stats.min)
                && Objects.equals(max, stats.max)
                && Objects.equals(count, stats.count)
                && Math.abs(avg - stats.avg) < 0.0001
                && Objects.equals(isValid, stats.isValid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max, count, avg, isValid);
    }
}
