package dunn.matt.com.simonstddextravaganza.data;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by Matt on 02/08/2017.
 */

public class FruitModel implements Serializable{

    private String type;
    private int price, weight;

    public FruitModel(JSONObject jsonObject){

        try{
            this.type = jsonObject.getString("type");
            this.price = jsonObject.getInt("price");
            this.weight = jsonObject.getInt("weight");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }
}
