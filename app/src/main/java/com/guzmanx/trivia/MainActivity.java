package com.guzmanx.trivia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.guzmanx.trivia.controller.AppController;
import com.guzmanx.trivia.data.QuestionBank;

// https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements-data.json

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new QuestionBank().getQuestions();
    }
}
