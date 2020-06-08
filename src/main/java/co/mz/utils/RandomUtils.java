package co.mz.utils;


import co.mz.models.Pending;
import co.mz.models.RandomCommand;
import co.mz.models.Statistic;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class RandomUtils {

//    public static RandomResponse randomNumber(){
//        RandomResponse response = new RandomResponse();
//        try {
//            RandomUtils.getRandomNumber();
//            response.setStatus(1);
//        }catch (Exception e){
//            response.setStatus(0);
//        }
//        return response;
//    }
//
    public static int getRandomNumber(){
        int value = (int) (Math.random()*(1000000-3))+3;
        return value;
    }

    public static Statistic getStats(Collection<RandomCommand> commands){

        List<RandomCommand> randomCommands = new ArrayList<>(commands);

        RandomCommand randomCommandMax = Collections.max(randomCommands, Comparator.comparing(s -> s.getSubmitTime().getNano()));
        RandomCommand randomCommandMin = Collections.min(randomCommands, Comparator.comparing(s -> s.getSubmitTime().getNano()));

        int totalPendind = 0;
        for(RandomCommand command : randomCommands){
            if(command.getStatus().trim().equalsIgnoreCase("pending")){
                totalPendind +=1;
            }
        }
        Statistic statistic = new Statistic();
        statistic.setMaxTime(randomCommandMax.getSubmitTime().getNano());
        statistic.setMinTime(randomCommandMin.getSubmitTime().getNano());
        statistic.setPending(totalPendind);
        return statistic;
    }

    public static List<Pending> getPendings(Collection<RandomCommand> commands){
        List<RandomCommand> randomCommands = new ArrayList<>(commands);

        List<Pending> pendings = new ArrayList<>();

        for(RandomCommand command : randomCommands){
            if(command.getStatus().trim().equalsIgnoreCase("pending")){
                Pending pending = new Pending();
                pending.setSubmittedAt(command.getSubmitTime());
                pending.setUid(command.getUuid().toString());
                long elapsedTimeMillis = TimeUnit.MILLISECONDS.convert(System.nanoTime() -command.getSubmitTime().getNano(), TimeUnit.NANOSECONDS);
                pending.setWaitedFor(elapsedTimeMillis);
                pendings.add(pending);
            }
        }
        return pendings;
    }
}
