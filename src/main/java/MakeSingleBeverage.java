import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class MakeSingleBeverage implements  Runnable{
    Queue<String> q;
    HashMap<String,HashMap<String,Integer>> orders;
    Pantry pantry;

    MakeSingleBeverage(Queue<String> q, HashMap<String,HashMap<String,Integer>> orders,Pantry pantry){
        this.q = q;
        this.orders=orders;
        this.pantry=pantry;
    }

    public void run(){
        String orderName;
        while((orderName =q.poll())!=null){
            HashMap<String,Integer> orderRecipe= orders.get(orderName);
            try {
                synchronized(this)
                {
                    for (String ingredient : orderRecipe.keySet()) {
                        pantry.checkIngredient(ingredient,orderRecipe.get(ingredient));
                    }
                    for (String ingredient : orderRecipe.keySet()) {
                        pantry.consumeIngredient(ingredient,orderRecipe.get(ingredient));
                    }
                    try {
                        Thread.sleep(5000); // Simulating preparation
                    }catch (InterruptedException e){

                    }
                    System.out.println(orderName+" is prepared");
                }
            }catch (IngredientLowException e){
                System.out.println(orderName + "" +e.getMessage());
            }

        }

    }

}
