import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java. util. LinkedList;

public class CoffeeMachine {
    int N;
    Pantry pantry;
    ExecutorService pool;

    CoffeeMachine(int N, Pantry pantry){
        this.N=N;
        this.pantry=pantry;
        this.pool = Executors.newFixedThreadPool(N);
    }

    public void MakeBeverages(HashMap<String,HashMap<String,Integer>> orders){
        Queue<String> q = new LinkedList<String>(orders.keySet());
            for (int i = 1; i <= N; i++) {
                Runnable r = new MakeSingleBeverage(q,orders,pantry);
                pool.execute(r);
            }
    }
}

