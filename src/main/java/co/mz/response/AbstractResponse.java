package co.mz.response;

public class AbstractResponse {

    private int status;
    private long timeToGenerate;

    public AbstractResponse() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTimeToGenerate() {
        return timeToGenerate;
    }

    public void setTimeToGenerate(long timeToGenerate) {
        this.timeToGenerate = timeToGenerate;
    }
}
