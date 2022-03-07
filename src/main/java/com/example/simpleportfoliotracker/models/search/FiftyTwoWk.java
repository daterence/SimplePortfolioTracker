package com.example.simpleportfoliotracker.models.search;

public class FiftyTwoWk {
    String low, high, low_change, high_change, range;

    public String getLow() {
        return low;
    }
    public void setLow(String low) {
        this.low = low;
    }

    public String getHigh() {
        return high;
    }
    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow_change() {
        return low_change;
    }
    public void setLow_change(String low_change) {
        this.low_change = low_change;
    }

    public String getHigh_change() {
        return high_change;
    }
    public void setHigh_change(String high_change) {
        this.high_change = high_change;
    }

    public String getRange() {
        return range;
    }
    public void setRange(String range) {
        this.range = range;
    }

    @Override
    public String toString() {
        return "FiftyTwoWk{" +
                "low='" + low + '\'' +
                ", high='" + high + '\'' +
                ", low_change='" + low_change + '\'' +
                ", high_change='" + high_change + '\'' +
                ", range='" + range + '\'' +
                '}';
    }
}
