package co.mz.models;

import java.io.Serializable;

public class Statistic implements Serializable {

    private int minTime;
    private int maxTime;
    private int pending;

    public Statistic() {
    }

    public int getMinTime() {
        return minTime;
    }

    public void setMinTime(int minTime) {
        this.minTime = minTime;
    }

    public int getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(int maxTime) {
        this.maxTime = maxTime;
    }

    public int getPending() {
        return pending;
    }

    public void setPending(int pending) {
        this.pending = pending;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "minTime=" + minTime +
                ", maxTime=" + maxTime +
                ", pending=" + pending +
                '}';
    }
}
