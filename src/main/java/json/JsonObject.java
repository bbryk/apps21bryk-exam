package json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private List<JsonPair> jsonPairs = new ArrayList<>();
    public JsonObject(JsonPair... jsonPairs) {
        // ToDo
        this.jsonPairs.addAll(Arrays.asList(jsonPairs));
    }

    @Override
    public String toJson() {
        String jsonResult = "{";
        for (JsonPair pair : this.jsonPairs){
            jsonResult += pair.key;
            jsonResult += ": ";

            jsonResult += pair.value.toJson();
            jsonResult += ", ";
        }
        if (jsonResult.length() > 2){
            jsonResult = jsonResult.substring(0, jsonResult.length() - 2);

        }
        jsonResult += "}";

        return jsonResult;
    }

    public void add(JsonPair jsonPair) {
        this.jsonPairs.add(jsonPair);
    }

    public Json find(String name) {
        for (JsonPair pair : this.jsonPairs){
            if (pair.key.equals(name)){
                return pair.value;

            }        }
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject jsonObject = new JsonObject();
        for (JsonPair pair : this.jsonPairs){
            for (String el : names){
                if (el == pair.key){
                    jsonObject.add(pair);
                }
            }
        }
        return jsonObject;
    }
    public static  void main(String[] args){
        JsonPair jSurname = new JsonPair("surname", new JsonString("Nik"));
        JsonPair jActive = new JsonPair("active", new JsonBoolean(true));
        JsonObject jsonObject = new JsonObject(jSurname, jActive);

        String expectedJSON = "{'surname': 'Nik', 'active': true}";

        System.out.println(jsonObject.toJson());
    }
}
