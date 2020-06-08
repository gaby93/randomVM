package co.mz.models;

import java.io.Serializable;

public class History implements Serializable {

    private int number;
    private long timeToGenerate;

    public History() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getTimeToGenerate() {
        return timeToGenerate;
    }

    public void setTimeToGenerate(long timeToGenerate) {
        this.timeToGenerate = timeToGenerate;
    }

    @Override
    public String toString() {
        return "RandomNumber{" +
                "number=" + number +
                ", timeToGenerate=" + timeToGenerate +
                '}';
    }
}
