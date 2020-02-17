package com.guzmanx.trivia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.guzmanx.trivia.controller.AppController;
import com.guzmanx.trivia.data.AnswerListAsyncResponse;
import com.guzmanx.trivia.data.QuestionBank;
import com.guzmanx.trivia.model.Question;

import java.util.ArrayList;
import java.util.List;

// https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements-data.json

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Question> questionList = new QuestionBank().getQuestions(new AnswerListAsyncResponse() {
            @Override
            public void processFinished(ArrayList<Question> questionArrayList) {
                Log.d("Inside", "processFinished: " + questionArrayList);
            }
        });
        //Log.d("Main", "onCreate: " + questionList);
    }
}
