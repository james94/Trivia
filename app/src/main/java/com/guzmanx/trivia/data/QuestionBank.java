package com.guzmanx.trivia.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.guzmanx.trivia.controller.AppController;
import com.guzmanx.trivia.model.Question;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import static com.guzmanx.trivia.controller.AppController.TAG;

// Help fetch questions from API
public class QuestionBank {
    ArrayList<Question> questionArrayList = new ArrayList<>();
    private String url = "https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements-data.json";

    public List<Question> getQuestions(final AnswerListAsyncResponse callBack) {

        // Fetch json data
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                (JSONArray) null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Log.d("JSON Stuff", "onResponse: " + response);
                        for(int i = 0; i < response.length(); i++) {
                            try {
                                // Create question object with question and true/false
                                Question question = new Question();
                                question.setAnswer(response.getJSONArray(i).get(0).toString());
                                question.setAnswerTrue(response.getJSONArray(i).getBoolean(1));

                                // Add question objects to array list
                                questionArrayList.add(question);
                                //Log.d("Hello", "onResponse: " + question.getAnswer());

                                //Log.d("JSON", "onResponse: " + response.getJSONArray(i).get(0));
                                //Log.d("JSON2", "onResponse: " + response.getJSONArray(i).getBoolean(1));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        if(null != callBack) {
                            callBack.processFinished(questionArrayList);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

        return questionArrayList;
    }
}
