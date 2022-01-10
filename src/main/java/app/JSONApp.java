package app;

import domain.*;
import json.*;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JSONApp {
    public static void main(String[] args) {
//        Json jYear = new JsonNumber(2);
//        print(jYear); // 2
//
//        Json jMarks = new JsonArray(new JsonNumber(3), new JsonNumber(4));
//        print(jMarks); // [3, 4]
//
//        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
//        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));
//        JsonPair marks = new JsonPair("marks", jMarks);
//        JsonPair year = new JsonPair("year", jYear);
//        JsonObject jsonObj = new JsonObject(name, surname, year, marks);
//        print(jsonObj); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}
//
//        print(jsonObj.projection("surname", "age", "year", "marks")); // {'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}
//
//        BasicStudent basicStudent = new BasicStudent("Andrii", "Rodionov", 2);
//        print(basicStudent.toJsonObject()); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2}
        System.out.println(sessionResult().toJson());

    }

    private static void print(Json json) {
        System.out.println(json.toJson());
    }

    public static JsonObject sessionResult() {
        Json jYear = new JsonNumber(2);
        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));
        JsonPair year = new JsonPair("year", jYear);

        JsonPair jsonPair1 = new JsonPair("course", new JsonString("OOP"));
        JsonPair jsonPair2 = new JsonPair("mark", new JsonNumber(3));
        JsonPair jsonPair3 = new JsonPair("passed", new JsonBoolean(true));

        JsonPair jsonPair4 = new JsonPair("course", new JsonString("English"));
        JsonPair jsonPair5 = new JsonPair("mark", new JsonNumber(5));
        JsonPair jsonPair6 = new JsonPair("passed", new JsonBoolean(true));

        JsonPair jsonPair7 = new JsonPair("course", new JsonString("Math"));
        JsonPair jsonPair8 = new JsonPair("mark", new JsonNumber(2));
        JsonPair jsonPair9 = new JsonPair("passed", new JsonBoolean(false));



        JsonArray jsonArray = new JsonArray(new JsonObject(jsonPair1, jsonPair2, jsonPair3), new JsonObject(jsonPair4, jsonPair5, jsonPair6), new JsonObject(jsonPair7, jsonPair8, jsonPair9));
        JsonPair exams = new JsonPair("exams", jsonArray);

        JsonObject jsonObject = new JsonObject(name, surname, year, exams);

        return jsonObject;
    }
}
