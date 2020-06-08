package co.mz;

import co.mz.models.RandomCommand;
import co.mz.storage.Storage;
import co.mz.utils.RandomUtils;
import co.mz.utils.Task.RandomNumberGeneratorTask;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


@MessageDriven(name = "GenerateNumber", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "topic/GenerateRandomNumber"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")})
public class RandomConsumer implements MessageListener {
    @Resource
    MessageDrivenContext messageDrivenContext;

    ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

    @Inject
    Storage storage;

    @Inject
    RandomNumberGeneratorTask randomNumberGeneratorTask;

    @Override
    public void onMessage(Message message) {
        System.out.println(message.getClass().getName());
        TextMessage msg = null;
        try {
            if (message instanceof TextMessage) {
                msg = (TextMessage) message;

                System.out.println("Received randomCommand: " + msg.getText());

                randomNumberGeneratorTask.setUuid(msg.getText());

                executor.execute(randomNumberGeneratorTask);

                RandomCommand randomCommand = storage.getCommand(msg.getText());
                randomCommand.setNumber(RandomUtils.getRandomNumber());
                randomCommand.setStatus("processed");

                System.out.println("Processed " + randomCommand);
                storage.addCommand(randomCommand);

            } else {
                System.out.println("Message of wrong type: " + message.getClass().getName());
            }
        } catch (JMSException e) {
            messageDrivenContext.setRollbackOnly();
            throw new RuntimeException(e);
        }
    }
}
