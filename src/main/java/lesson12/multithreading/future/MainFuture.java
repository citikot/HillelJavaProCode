package lesson12.multithreading.future;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MainFuture {
    public static void main(String argvs[]) throws Exception {

        // FutureTask is the concrete class  
        List<FutureTask<Integer>> futureTasks = new ArrayList<>();
        Random random = new Random();

        // loop for spawning 10 threads  
        for (int j = 0; j < 10; j++) {
            // Creating a new object of the JavaCallable class  
            Callable<Integer> clble = new FactorialTask(random.nextInt(10));

            // Creating the FutureTask with Callable  
            FutureTask<Integer> futureTask = new FutureTask<>(clble);
            futureTasks.add(futureTask);

            // Since FutureTask implements Runnable,   
            // one can create a Thread  
            // with a FutureTask object  
            new Thread(futureTask).start();
        }

        // loop for receiving the random numbers  
        for (int j = 0; j < 10; j++) {
            // invoking the get() method  
            FutureTask<Integer> futureTask = futureTasks.get(j);

            // The get method holds the control until the result is received  
            // The get method may throw the checked exceptions  
            // like when the method is interrupted. Because of this reason  
            // we have to add the throws clause to the main method  

            // printing the generated random number  
            System.out.println("The random number is: " + futureTask.get());
        }
    }
}
