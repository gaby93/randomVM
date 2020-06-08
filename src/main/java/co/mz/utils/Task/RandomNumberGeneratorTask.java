package co.mz.utils.Task;

import co.mz.models.RandomCommand;
import co.mz.storage.Storage;
import co.mz.utils.RandomUtils;

import javax.inject.Inject;


public class RandomNumberGeneratorTask implements Runnable {
    private  String uuid;

    @Inject
    Storage storage;

    public RandomNumberGeneratorTask() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public RandomNumberGeneratorTask(String uuid){
        this.uuid = uuid;
    }

    @Override
    public void run() {
        RandomCommand randomCommand = storage.getCommand(uuid);
        randomCommand.setNumber(RandomUtils.getRandomNumber());
        randomCommand.setStatus("processed");

        System.out.println("Processed " + randomCommand);
        storage.addCommand(randomCommand);
    }
}
