package co.mz.storage;

import co.mz.models.RandomCommand;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;


@ApplicationScoped
public class Storage {
    private Map<String, RandomCommand> randomCommandMap = new HashMap<>();

    public void addCommand(RandomCommand randomCommand){
        this.randomCommandMap.put(randomCommand.getUuid().toString(), randomCommand);
    }

    public RandomCommand getCommand(String uuid){
        return this.randomCommandMap.get(uuid);
    }

    public Collection<RandomCommand> listRequestCommands(){
        return randomCommandMap.values();
    }

}