package com.example.simpleportfoliotracker.models;

import com.google.gson.Gson;

import java.util.Arrays;

public class TimeSeries {
    Meta meta;
    TimeSeriesValue value;
    TimeSeriesValue[] values;

    public Meta getMeta() {
        return meta;
    }
    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public TimeSeriesValue getValue() {
        return value;
    }

    public void setValue(TimeSeriesValue value) {
        this.value = value;
    }

    public TimeSeriesValue[] getValues() {
        return values;
    }

    public void setValues(TimeSeriesValue[] values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "TimeSeries{" +
                "meta=" + meta +
                ", value=" + value +
                ", values=" + Arrays.toString(values) +
                '}';
    }

    public static TimeSeries getTimeSeries (String s) {
        Gson gson = new Gson();
        TimeSeries timeSeries = gson.fromJson(s, TimeSeries.class);
        TimeSeriesValue[] values = timeSeries.getValues();
        TimeSeriesValue value = values[0];
        float close = Float.parseFloat(value.getClose());
        float open = Float.parseFloat(value.getOpen());
        float percentChange = ((close-open)/open)*100;
        value.setPercentChange(String.valueOf(percentChange));

        TimeSeries newTs = new TimeSeries();
        newTs.setMeta(timeSeries.getMeta());
        newTs.setValue(value);
        return newTs;
    }
}
