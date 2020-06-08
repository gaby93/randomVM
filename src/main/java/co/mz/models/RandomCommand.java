package co.mz.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class RandomCommand implements Serializable {
    private UUID uuid;
    private LocalDateTime submitTime;
    private int maxWaitTime;
    private String status;
    private int number;

    public RandomCommand(){

    }

    public RandomCommand(int maxWaitTime){
        this.maxWaitTime = maxWaitTime;
        this.uuid = UUID.randomUUID();
        this.submitTime = LocalDateTime.now();
        this.status = "pending";
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public LocalDateTime getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(LocalDateTime submitTime) {
        this.submitTime = submitTime;
    }

    public int getMaxWaitTime() {
        return maxWaitTime;
    }

    public void setMaxWaitTime(int maxWaitTime) {
        this.maxWaitTime = maxWaitTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "RandomCommand{" +
                "uuid=" + uuid +
                ", submitTime=" + submitTime +
                ", maxWaitTime=" + maxWaitTime +
                ", status='" + status + '\'' +
                '}';
    }
}
