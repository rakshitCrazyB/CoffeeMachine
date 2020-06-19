import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.concurrent.*;
import javax.crypto.Mac;
import java.util.HashMap;

class Outlets {
    @JsonProperty("count_n")
    Integer countN;
    Integer getCountN(){
        return countN;
    }

}

class Machine{
    @JsonProperty("outlets")
    Outlets outlets;

    @JsonProperty("total_items_quantity")
    ConcurrentHashMap<String,Integer> totalItemsQuantity;

    @JsonProperty("beverages")
    HashMap<String,HashMap<String,Integer>> beverages;

    Outlets getOutlets(){
        return outlets;
    }

    ConcurrentHashMap<String,Integer> getTotalItemsQuantity(){
        return totalItemsQuantity;
    }

    HashMap<String,HashMap<String,Integer>> getBeverages(){
        return beverages;
    }

}

public class CoffeePOJO {
    @JsonProperty("machine")
    Machine machine;

    Machine getMachine(){
        return machine;
    }
}
