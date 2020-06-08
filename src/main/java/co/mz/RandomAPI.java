package co.mz;

import co.mz.models.Pending;
import co.mz.models.RandomCommand;
import co.mz.models.Statistic;
import co.mz.response.RandomResponse;
import co.mz.storage.Storage;
import co.mz.utils.RandomUtils;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;



@Path("/random")
public class RandomAPI {
    @Inject
    Storage storage;

    @Inject
    RandomProducer randomProducer;

    @POST
    @Path("random")
    @Produces(MediaType.APPLICATION_JSON)
    public Response random(@HeaderParam("X-Max-Wait") String maxWaitTime) throws InterruptedException {
        if(maxWaitTime == null || maxWaitTime.trim() == "")
            maxWaitTime = "30";

        int max = Integer.parseInt(maxWaitTime);
        RandomCommand randomCommand = new RandomCommand(max);
        storage.addCommand(randomCommand);
        randomProducer.sendCommand(randomCommand);
        RandomResponse randomResponse = new RandomResponse(randomCommand.getUuid().toString(), "submitted");

        return javax.ws.rs.core.Response.status(200).entity(randomResponse).build();
    }


    @GET
    @Path("history")
    @Produces(MediaType.APPLICATION_JSON)
    public Response history(){

        Collection<RandomCommand> commands = storage.listRequestCommands();

        return javax.ws.rs.core.Response.status(200).entity(commands).build();
    }

    @GET
    @Path("{requestId}/cancel")
    @Produces(MediaType.APPLICATION_JSON)
    public Response cancel(@PathParam("requestId") String requestId){
        RandomCommand randomCommand = storage.getCommand(requestId);


        if(randomCommand == null){
             return javax.ws.rs.core.Response.status(200).entity("No uuid found").build();
        }

        randomCommand.setStatus("cancelled");
        storage.addCommand(randomCommand);

        return javax.ws.rs.core.Response.status(200).entity(randomCommand).build();
    }

    @GET
    @Path("stats")
    @Produces(MediaType.APPLICATION_JSON)
    public Response stats(){

        Collection<RandomCommand> commands = storage.listRequestCommands();
        Statistic statistic = RandomUtils.getStats(commands);
        return javax.ws.rs.core.Response.status(200).entity(statistic).build();
    }

    @GET
    @Path("pending")
    @Produces(MediaType.APPLICATION_JSON)
    public Response pending(){

        Collection<RandomCommand> commands = storage.listRequestCommands();
        List<Pending> pendings = RandomUtils.getPendings(commands);
        return javax.ws.rs.core.Response.status(200).entity(pendings).build();
    }
}
