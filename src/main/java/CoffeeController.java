import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.util.concurrent.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CoffeeController {

    public static void MakeBeverages(ConcurrentHashMap<String,Integer> ingredientList, Integer outlets,  HashMap<String,HashMap<String,Integer>> orders){
        Pantry pantry = new Pantry(ingredientList);
        CoffeeMachine coffeeMachine = new CoffeeMachine(outlets,pantry);
        coffeeMachine.MakeBeverages(orders);
    }

    public static void Start (String input){   // Main function
        ObjectMapper mapper = new ObjectMapper();
        try {
            CoffeePOJO pojo = mapper.readValue(input, CoffeePOJO.class);
            if(pojo!=null && pojo.getMachine()!=null
                    && pojo.getMachine().getTotalItemsQuantity()!=null
                    && pojo.getMachine().getBeverages()!=null
                    && pojo.getMachine().getOutlets()!=null){
            }
            MakeBeverages(pojo.getMachine().getTotalItemsQuantity(),pojo.getMachine().getOutlets().getCountN(),pojo.getMachine().getBeverages());
        }catch (IOException e){
            System.out.println("Error in Input");
        }
    }

    public static void main(String args[]){      // Just to test locally
        ObjectMapper mapper = new ObjectMapper();
        CoffeePOJO pojo;
        String jsonString = "{\n" +
                "  \"machine\": {\n" +
                "    \"outlets\": {\n" +
                "      \"count_n\": 3\n" +
                "    },\n" +
                "    \"total_items_quantity\": {\n" +
                "      \"hot_water\": 500,\n" +
                "      \"hot_milk\": 500,\n" +
                "      \"ginger_syrup\": 100,\n" +
                "      \"sugar_syrup\": 100,\n" +
                "      \"tea_leaves_syrup\": 100\n" +
                "    },\n" +
                "    \"beverages\": {\n" +
                "      \"hot_tea\": {\n" +
                "        \"hot_water\": 200,\n" +
                "        \"hot_milk\": 100,\n" +
                "        \"ginger_syrup\": 10,\n" +
                "        \"sugar_syrup\": 10,\n" +
                "        \"tea_leaves_syrup\": 30\n" +
                "      },\n" +
                "      \"hot_coffee\": {\n" +
                "        \"hot_water\": 100,\n" +
                "        \"ginger_syrup\": 30,\n" +
                "        \"hot_milk\": 400,\n" +
                "        \"sugar_syrup\": 50,\n" +
                "        \"tea_leaves_syrup\": 30\n" +
                "      },\n" +
                "      \"black_tea\": {\n" +
                "        \"hot_water\": 300,\n" +
                "        \"ginger_syrup\": 30,\n" +
                "        \"sugar_syrup\": 50,\n" +
                "        \"tea_leaves_syrup\": 30\n" +
                "      },\n" +
                "      \"green_tea\": {\n" +
                "        \"hot_water\": 100,\n" +
                "        \"ginger_syrup\": 30,\n" +
                "        \"sugar_syrup\": 50,\n" +
                "        \"green_mixture\": 30\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";
                Start(jsonString);
    }
}
