package co.mz.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Locale;

public class Pending implements Serializable {

    private String uid;
    private LocalDateTime submittedAt;
    private long waitedFor;

    public Pending() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    public long getWaitedFor() {
        return waitedFor;
    }

    public void setWaitedFor(long waitedFor) {
        this.waitedFor = waitedFor;
    }

    @Override
    public String toString() {
        return "Pending{" +
                "uid='" + uid + '\'' +
                ", submittedAt=" + submittedAt +
                ", waitedFor=" + waitedFor +
                '}';
    }
}
