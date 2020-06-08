package co.mz;

import co.mz.models.RandomCommand;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.*;

@JMSDestinationDefinitions(
        value = {
                @JMSDestinationDefinition(
                        name = "java:/topic/GenerateRandomNumber",
                        interfaceName = "javax.jms.Queue",
                        destinationName = "GenerateNumber"
                )
        }
)
public class RandomProducer {

    @Inject
    private JMSContext context;

    @Resource(lookup = "java:/topic/GenerateRandomNumber")
    private Queue queue;


    public  void sendCommand(RandomCommand randomCommand){
        final Destination destination = queue;
        context.createProducer().send(destination, randomCommand.getUuid().toString());
    }

}
