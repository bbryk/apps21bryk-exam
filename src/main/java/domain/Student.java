package domain;

import json.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    protected Tuple<String, Integer>[] exams;
    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        super(name, surname, year);
        this.exams = exams;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonPair firstName = new JsonPair("name", new JsonString(name));
        JsonPair lastName = new JsonPair("surname", new JsonString(surname));
        JsonPair yeear = new JsonPair("year", new JsonNumber(year));

        List<Json> list = new ArrayList<>();
        for (Tuple<String, Integer> exam : this.exams){
            JsonPair course = new JsonPair("course", new JsonString(exam.key));
            JsonPair mark = new JsonPair("mark", new JsonNumber(exam.value));
            JsonPair passed;
            if (exam.value > 2){
                passed = new JsonPair("passed", new JsonBoolean(true));
            }else{
                passed = new JsonPair("passed", new JsonBoolean(false));

            }
            list.add(new JsonObject(course, mark, passed));
        }
        JsonArray jsonArray = new JsonArray(list);
        JsonPair exams = new JsonPair("exams", jsonArray);

        JsonObject jsonObject = new JsonObject(firstName, lastName, yeear, exams);

        return jsonObject;
    }
}