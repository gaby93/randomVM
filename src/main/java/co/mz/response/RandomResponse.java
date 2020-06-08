package co.mz.response;

import java.io.Serializable;

public class RandomResponse implements Serializable {
    private String uuid;
    private String status;

    public RandomResponse(String uuid, String status) {
        this.uuid = uuid;
        this.status = status;
    }

    public RandomResponse() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
