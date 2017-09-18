package com.flicks.hinaikhan.flicks.data.model.response;


/**
 * Created by hinaikhan on 9/15/17.
 */

public class DateResponse{


    private final String TAG = DateResponse.class.getSimpleName();

    private String maximum;
    private String minimum;

    public DateResponse(String maximum, String minimum) {
        this.maximum = maximum;
        this.minimum = minimum;
    }

    public String getMaximum() {
        return maximum;
    }

    public void setMaximum(String maximum) {
        this.maximum = maximum;
    }

    public String getMinimum() {
        return minimum;
    }

    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }

    @Override
    public String toString() {
        return "DateResponse{" +
                "maximum='" + maximum + '\'' +
                ", minimum='" + minimum + '\'' +
                '}';
    }
}
