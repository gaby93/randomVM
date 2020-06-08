package co.mz.response;

import co.mz.models.History;

import java.util.List;

public class HistoryResponse extends AbstractResponse{

    private List<History> histories;

    public HistoryResponse() {
    }

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }

    @Override
    public String toString() {
        return "HistoryResponse{" +
                "histories=" + histories +
                '}';
    }
}
