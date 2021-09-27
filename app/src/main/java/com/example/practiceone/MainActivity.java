package com.example.practiceone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    Button btn_confirm;
    RadioButton radioBtnOne, radioBtnTwo,radioBtnThree,radioBtnFour, btn_select;
    TextView moneyEarned, question;
    int num = 0, wrong = 0, correct = 0, amount = 0;
    String answer;
    QuizInfo quizInfo = new QuizInfo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        radioGroup = findViewById(R.id.radioGroup);
        moneyEarned = findViewById(R.id.money);
        moneyEarned.setText(moneyEarned.getText() + String.valueOf(amount));
        question = findViewById(R.id.question);
        btn_confirm = findViewById(R.id.btn_confirm);
        radioBtnOne = findViewById(R.id.btn_one);
        radioBtnTwo = findViewById(R.id.btn_two);
        radioBtnThree = findViewById(R.id.btn_three);
        radioBtnFour = findViewById(R.id.btn_four);

        getQuestions(num);



    }


    public void getAnswer(View view) {
        int radioID = radioGroup.getCheckedRadioButtonId();
        btn_select = findViewById(radioID);


        if (btn_select.getText().toString().equals(answer))
        {
            Toast.makeText(this,"" + btn_select.getText() + " is Correct Answer",Toast.LENGTH_LONG).show();
            amount = Integer.parseInt(moneyEarned.getText().toString());

            if (amount == 0) { amount +=100;}
            else if (amount == 100) { amount += 150;}
            else { amount = amount*2; }
            moneyEarned.setText(String.valueOf(amount));
            correct++;

        } else {
            Toast.makeText(this,"" + btn_select.getText() + " is Wrong!",Toast.LENGTH_LONG).show();
            wrong++;
        }

        if (num == 6) {getStats();}
        else
        {
            num++;
            getQuestions(num);
        }
    }

   private void getStats() {
        Intent intent = new Intent(this, Stats.class);
        intent.putExtra("correct", correct);
        intent.putExtra("wrong", wrong);
       intent.putExtra("amount", amount);
        startActivity(intent);
    }


    public void getQuestions(int num)
    {
        question.setText(quizInfo.getQuestion(num));
        radioBtnOne.setText(quizInfo.getOption1(num));
        radioBtnTwo.setText(quizInfo.getOption2(num));
        radioBtnThree.setText(quizInfo.getOption3(num));
        radioBtnFour.setText(quizInfo.getOption4(num));
        answer = quizInfo.getAnswer(num);
        radioGroup.clearCheck();
    }



}