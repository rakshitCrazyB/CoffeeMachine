import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.*;

public class Pantry {
    Pantry(ConcurrentHashMap<String,Integer> ingredientList){
        this.ingredientList=ingredientList;
    }
    ConcurrentHashMap<String,Integer> ingredientList;

    public void checkIngredient(String name, Integer amount) throws  IngredientLowException{
        if(ingredientList.get(name)==null || ingredientList.get(name)<amount){
            throw new IngredientLowException(" cannot be prepared because " + name + " is not available");
        }
    }

    public void consumeIngredient(String name, Integer amount){
        ingredientList.put(name,ingredientList.get(name)-amount);
    }
}
