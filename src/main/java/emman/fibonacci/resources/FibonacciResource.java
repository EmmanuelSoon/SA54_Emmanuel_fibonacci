package emman.fibonacci.resources;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import emman.fibonacci.api.*;



@Path("/fibonacci")
@Produces(MediaType.APPLICATION_JSON)
public class FibonacciResource {
    private final HashMap<Integer,Long> numDict;

    public FibonacciResource() {
        this.numDict = new HashMap<Integer,Long>();
        numDict.put(0, (long) 0);
        numDict.put(1,(long) 1);
        
        for (int i = 2; i <= 100; i++){
            numDict.put(i, numDict.get(i-1) + numDict.get(i-2));
        }
    }

    @POST 
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/submit")
    public Data sayHello(Body body) {

        int elements = body.getElements();
        ArrayList<Long> fibonacci = new ArrayList<Long>();
        for(int i = 0; i < elements; i++){
            fibonacci.add(numDict.get(i));
        }
        ArrayList<Long> sorted = new ArrayList<Long>();
        for (int i = elements-1; i >= 0; i--){
            if (fibonacci.get(i) % 2 == 0){
                sorted.add(fibonacci.get(i));
            }
        }
        for (int i = elements-1; i >= 0; i--){
            if (fibonacci.get(i) % 2 != 0){
                sorted.add(fibonacci.get(i));
            }
        }

        Data data = new Data(fibonacci, sorted); 
        return data;
    }
}
