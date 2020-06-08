package co.mz.response;

import co.mz.models.Pending;

import java.util.List;

public class PendingResponse extends AbstractResponse{

    private List<Pending> pendings;

    public PendingResponse() {
    }

    public List<Pending> getPendings() {
        return pendings;
    }

    public void setPendings(List<Pending> pendings) {
        this.pendings = pendings;
    }

    @Override
    public String toString() {
        return "PendingResponse{" +
                "pendings=" + pendings +
                '}';
    }
}
