package com.example.jdmon.lightbot;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class JSONHandler {

    public static String set_action(List<Integer> list) throws JSONException {

        JSONArray moves = new JSONArray();

        for (int i = 0; i <= list.size() - 1; i++) {
            moves.put(list.get(i));
        }

        return moves.toString();
    }

}