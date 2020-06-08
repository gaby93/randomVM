package co.mz.response;

import co.mz.models.Statistic;

public class StatisticResponse extends AbstractResponse{
    private Statistic statistic;

    public StatisticResponse(){}

    public Statistic getStatistic() {
        return statistic;
    }
    public void setStatistic(Statistic statistic) {
        this.statistic = statistic;
    }

    @Override
    public String toString() {
        return "StatisticResponse{" +
                "statistic=" + statistic +
                '}';
    }
}
