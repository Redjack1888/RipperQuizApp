package com.example.android.ripperquizapp;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.example.android.ripperquizapp.R.id.answer10d;
import static com.example.android.ripperquizapp.R.id.answer1c;
import static com.example.android.ripperquizapp.R.id.answer2a;
import static com.example.android.ripperquizapp.R.id.answer3b;
import static com.example.android.ripperquizapp.R.id.answer4a;
import static com.example.android.ripperquizapp.R.id.answer5b;
import static com.example.android.ripperquizapp.R.id.answer7b;
import static com.example.android.ripperquizapp.R.id.answer8a;
import static com.example.android.ripperquizapp.R.id.answer9b;
import static com.example.android.ripperquizapp.R.id.reset_button;

public class MainActivity extends AppCompatActivity {

    boolean allQuestionsFilled;
    private RadioGroup radioGroupQuestion1;
    private RadioGroup radioGroupQuestion2;
    private RadioGroup radioGroupQuestion3;
    private RadioGroup radioGroupQuestion4;
    private RadioGroup radioGroupQuestion5;
    private RadioGroup radioGroupQuestion7;
    private RadioGroup radioGroupQuestion8;
    private RadioGroup radioGroupQuestion9;
    private RadioGroup radioGroupQuestion10;
    private CheckBox answerCheckbox6a;
    private CheckBox answerCheckbox6b;
    private CheckBox answerCheckbox6c;
    private CheckBox answerCheckbox6d;
    private Button resetButton;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupQuestion1 = (RadioGroup) findViewById(R.id.rg1View); //Multiple
        radioGroupQuestion2 = (RadioGroup) findViewById(R.id.rg3View); //True False
        radioGroupQuestion3 = (RadioGroup) findViewById(R.id.rg4View); //True False
        radioGroupQuestion4 = (RadioGroup) findViewById(R.id.rg5View); //Multiple
        radioGroupQuestion5 = (RadioGroup) findViewById(R.id.rg7View); //Multiple
        answerCheckbox6a = (CheckBox) findViewById(R.id.check6a); //Multiple checkboxes
        answerCheckbox6b = (CheckBox) findViewById(R.id.check6b); //Multiple checkboxes
        answerCheckbox6c = (CheckBox) findViewById(R.id.check6c); //Multiple checkboxes
        answerCheckbox6d = (CheckBox) findViewById(R.id.check6d); //Multiple checkboxes
        radioGroupQuestion7 = (RadioGroup) findViewById(R.id.rg11View); //True False
        radioGroupQuestion8 = (RadioGroup) findViewById(R.id.rg12View); //True False
        radioGroupQuestion9 = (RadioGroup) findViewById(R.id.rg13View); //Multiple
        radioGroupQuestion10 = (RadioGroup) findViewById(R.id.rg15View); //Multiple

        resetButton = (Button) findViewById(reset_button);
        resetButton.setVisibility(View.INVISIBLE); //To set invisible
        submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setVisibility(View.VISIBLE);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.MyToolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapse_toolbar);
        collapsingToolbarLayout.setTitle("Jack the Ripper Quiz");
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);

        Context context = this;
        collapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(context, R.color.colorPrimary));

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("submitSavedVisibility", submitButton.getVisibility());
        outState.putInt("resetSavedVisibility", resetButton.getVisibility());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.getInt("submitSavedVisibility") == View.VISIBLE) {
            submitButton.setVisibility(View.VISIBLE);
        } else {
            submitButton.setVisibility(View.INVISIBLE);
        }
        if (savedInstanceState.getInt("resetSavedVisibility") == View.VISIBLE) {
            resetButton.setVisibility(View.VISIBLE);
        } else {
            resetButton.setVisibility(View.INVISIBLE);
        }
        super.onRestoreInstanceState(savedInstanceState);
    }

    public void reset(View v) {

        EditText userName = (EditText) findViewById(R.id.your_name_view);

        userName.setText(null);

        radioGroupQuestion1.clearCheck();
        radioGroupQuestion2.clearCheck();
        radioGroupQuestion3.clearCheck();
        radioGroupQuestion4.clearCheck();
        radioGroupQuestion5.clearCheck();
        radioGroupQuestion7.clearCheck();
        radioGroupQuestion8.clearCheck();
        radioGroupQuestion9.clearCheck();
        radioGroupQuestion10.clearCheck();

        answerCheckbox6a.setChecked(false);
        answerCheckbox6b.setChecked(false);
        answerCheckbox6c.setChecked(false);
        answerCheckbox6d.setChecked(false);

        submitButton.setVisibility(View.VISIBLE);
        resetButton.setVisibility(View.INVISIBLE);
    }

    public void submit(View view) {
        allQuestionsFilled = true;

        allFilled(radioGroupQuestion1);
        allFilled(radioGroupQuestion2);
        allFilled(radioGroupQuestion3);
        allFilled(radioGroupQuestion4);
        allFilled(radioGroupQuestion5);
        allFilled(radioGroupQuestion7);
        allFilled(radioGroupQuestion8);
        allFilled(radioGroupQuestion9);
        allFilled(radioGroupQuestion10);
        editTextFilled();
        checkBoxesFilled();

        if (allQuestionsFilled) {
            resetButton.setVisibility(View.VISIBLE); //To set visible
            submitButton.setVisibility(View.INVISIBLE);
            evaluate();
        } else {
            String alert_message = getString(R.string.alert_message);
            displayToast(alert_message);
        }
    }

    private void evaluate() {
        EditText nameView = (EditText) findViewById(R.id.your_name_view);
        String userName = nameView.getText().toString();
        int score = 0;

        if (radioGroupQuestion1.getCheckedRadioButtonId() == answer1c) {
            score = score + 10;
        }
        if (radioGroupQuestion2.getCheckedRadioButtonId() == answer2a) {
            score = score + 10;
        }
        if (radioGroupQuestion3.getCheckedRadioButtonId() == answer3b) {
            score = score + 10;
        }
        if (radioGroupQuestion4.getCheckedRadioButtonId() == answer4a) {
            score = score + 10;
        }
        if (radioGroupQuestion5.getCheckedRadioButtonId() == answer5b) {
            score = score + 10;
        }
        if (!(answerCheckbox6a.isChecked() && answerCheckbox6c.isChecked())) { //Question 6
            if (answerCheckbox6b.isChecked()) {
                score = score + 5;
            }
            if (answerCheckbox6d.isChecked()) {
                score = score + 5;
            }
        }
        if (radioGroupQuestion7.getCheckedRadioButtonId() == answer7b) {
            score = score + 10;
        }
        if (radioGroupQuestion8.getCheckedRadioButtonId() == answer8a) {
            score = score + 10;
        }
        if (radioGroupQuestion9.getCheckedRadioButtonId() == answer9b) {
            score = score + 10;
        }
        if (radioGroupQuestion10.getCheckedRadioButtonId() == answer10d) {
            score = score + 10;
        }
        int correctAnswerSubmitted = score / 10;
        String scoreMessage1 = getString(R.string.Toast1a) + userName + getString(R.string.Toast2a) + getString(R.string.Toast3a) + getString(R.string.Toast4a) + score + getString(R.string.Toast5a) + getString(R.string.Toast6a) + correctAnswerSubmitted + getString(R.string.Toast7a);
        String scoreMessage2 = getString(R.string.Toast8a) + userName + getString(R.string.Toast9a) + getString(R.string.Toast4a) + score + getString(R.string.Toast5a) + getString(R.string.Toast6a) + correctAnswerSubmitted + getString(R.string.Toast7a);
        String scoreMessage3 = getString(R.string.Toast10a) + userName + getString(R.string.Toast11a) + getString(R.string.Toast4a) + score + getString(R.string.Toast5a) + getString(R.string.Toast6a) + correctAnswerSubmitted + getString(R.string.Toast7a);
        if (correctAnswerSubmitted <= 5) {
            displayToast(scoreMessage1);
        }
        if (correctAnswerSubmitted > 5 && correctAnswerSubmitted <= 8) {
            displayToast(scoreMessage2);
        }
        if (correctAnswerSubmitted > 8) {
            displayToast(scoreMessage3);
        }
    }

    private void allFilled(RadioGroup radioGroup) {
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            allQuestionsFilled = false;
        }
    }

    private void editTextFilled() {
        EditText nameView = (EditText) findViewById(R.id.your_name_view);
        String name = nameView.getText().toString();
        if (name.equals("")) {
            allQuestionsFilled = false;
        }
    }

    private void checkBoxesFilled() {
        if (!answerCheckbox6a.isChecked() && !answerCheckbox6b.isChecked() && !answerCheckbox6c.isChecked() && !answerCheckbox6d.isChecked()) {
            allQuestionsFilled = false;
        }
    }

    private void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
