package com.example.android.ripperquizapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CheckResult;
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

    private RadioGroup rg1;
//    private RadioButton a1a;
//    private RadioButton a1b;
//    private RadioButton a1c;
//    private RadioButton a1d;
    private RadioGroup rg2;
//    private RadioButton a2a;
//    private RadioButton a2b;
    private RadioGroup rg3;
//    private RadioButton a3a;
//    private RadioButton a3b;
    private RadioGroup rg4;
//    private RadioButton a4a;
//    private RadioButton a4b;
//    private RadioButton a4c;
//    private RadioButton a4d;
    private RadioGroup rg5;
//    private RadioButton a5a;
//    private RadioButton a5b;
//    private RadioButton a5c;
//    private RadioButton a5d;

    private RadioGroup rg7;
//    private RadioButton a7a;
//    private RadioButton a7b;
    private RadioGroup rg8;
//    private RadioButton a8a;
//    private RadioButton a8b;
    private RadioGroup rg9;
//    private RadioButton a9a;
//    private RadioButton a9b;
//    private RadioButton a9c;
//    private RadioButton a9d;
    private RadioGroup rg10;
//    private RadioButton a10a;
//    private RadioButton a10b;
//    private RadioButton a10c;
//    private RadioButton a10d;

    private CheckBox chk6a;
    private CheckBox chk6b;
    private CheckBox chk6c;
    private CheckBox chk6d;

    private Button resetButton;
    private Button submit;
//    private int submitVisibility;
//    private int resetVisibility;
//    private String submitSavedVisibility;

    boolean allFilled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg1 = (RadioGroup) findViewById(R.id.rg1View); //Multiple
//        a1a = (RadioButton) findViewById(R.id.answer1a);
//        a1b = (RadioButton) findViewById(R.id.answer1b);
//        a1c = (RadioButton) findViewById(R.id.answer1c);
//        a1d = (RadioButton) findViewById(R.id.answer1d);
        rg2 = (RadioGroup) findViewById(R.id.rg3View); //True False
//        a2a = (RadioButton) findViewById(R.id.answer2a);
//        a2b = (RadioButton) findViewById(R.id.answer2b);
        rg3 = (RadioGroup) findViewById(R.id.rg4View); //True False
//        a3a = (RadioButton) findViewById(R.id.answer3a);
//        a3b = (RadioButton) findViewById(R.id.answer3b);
        rg4 = (RadioGroup) findViewById(R.id.rg5View); //Multiple
//        a4a = (RadioButton) findViewById(R.id.answer4a);
//        a4b = (RadioButton) findViewById(R.id.answer4b);
//        a4c = (RadioButton) findViewById(R.id.answer4c);
//        a4d = (RadioButton) findViewById(R.id.answer4d);
        rg5 = (RadioGroup) findViewById(R.id.rg7View); //Multiple
//        a5a = (RadioButton) findViewById(R.id.answer5a);
//        a5b = (RadioButton) findViewById(R.id.answer5b);
//        a5c = (RadioButton) findViewById(R.id.answer5c);
//        a5d = (RadioButton) findViewById(R.id.answer5d);
        chk6a = (CheckBox) findViewById(R.id.check6a); //Multiple checkboxes
        chk6b = (CheckBox) findViewById(R.id.check6b); //Multiple checkboxes
        chk6c = (CheckBox) findViewById(R.id.check6c); //Multiple checkboxes
        chk6d = (CheckBox) findViewById(R.id.check6d); //Multiple checkboxes
        rg7 = (RadioGroup) findViewById(R.id.rg11View); //True False
//        a7a = (RadioButton) findViewById(R.id.answer7a);
//        a7b = (RadioButton) findViewById(R.id.answer7b);
        rg8 = (RadioGroup) findViewById(R.id.rg12View); //True False
//        a8a = (RadioButton) findViewById(R.id.answer8a);
//        a8b = (RadioButton) findViewById(R.id.answer8b);
        rg9 = (RadioGroup) findViewById(R.id.rg13View); //Multiple
//        a9a = (RadioButton) findViewById(R.id.answer9a);
//        a9b = (RadioButton) findViewById(R.id.answer9b);
//        a9c = (RadioButton) findViewById(R.id.answer9c);
//        a9d = (RadioButton) findViewById(R.id.answer9d);
        rg10 = (RadioGroup) findViewById(R.id.rg15View); //Multiple
//        a10a = (RadioButton) findViewById(R.id.answer10a);
//        a10b = (RadioButton) findViewById(R.id.answer10b);
//        a10c = (RadioButton) findViewById(R.id.answer10c);
//        a10d = (RadioButton) findViewById(R.id.answer10d);

        resetButton = (Button) findViewById(reset_button);
        resetButton.setVisibility(View.INVISIBLE); //To set invisible
        submit = (Button) findViewById(R.id.submit_button);
        submit.setVisibility(View.VISIBLE);

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
        outState.putInt("submitSavedVisibility", submit.getVisibility());
        outState.putInt("resetSavedVisibility", resetButton.getVisibility());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        submitVisibility = savedInstanceState.getInt("submitSavedVisibility");
//        resetVisibility = savedInstanceState.getInt("resetSavedVisibility");
//

        submit.setVisibility(savedInstanceState.getInt("submitSavedVisibility"));
        resetButton.setVisibility(savedInstanceState.getInt("resetSavedVisibility"));
        super.onRestoreInstanceState(savedInstanceState);
    }

    public void reset(View v) {

        EditText nameV = (EditText) findViewById(R.id.your_name_view);

        nameV.setText(null);

        rg1.clearCheck();
        rg2.clearCheck();
        rg3.clearCheck();
        rg4.clearCheck();
        rg5.clearCheck();
        rg7.clearCheck();
        rg8.clearCheck();
        rg9.clearCheck();
        rg10.clearCheck();

        chk6a.setChecked(false);
        chk6b.setChecked(false);
        chk6c.setChecked(false);
        chk6d.setChecked(false);

        submit.setVisibility(View.VISIBLE);
        resetButton.setVisibility(View.INVISIBLE);
    }

    public void submit(View view) {
        allFilled = true;

        allFilled(rg1);
        allFilled(rg2);
        allFilled(rg3);
        allFilled(rg4);
        allFilled(rg5);
        allFilled(rg7);
        allFilled(rg8);
        allFilled(rg9);
        allFilled(rg10);
        editTextFilled();
        checkBoxesFilled();

        if (allFilled){
            resetButton.setVisibility(View.VISIBLE); //To set visible
            submit.setVisibility(View.INVISIBLE);
            evaluate();
        }else {
            String alert_message = getString(R.string.alert_message);
            displayToast(alert_message);
        }
    }

    private void evaluate() {
        EditText nameView = (EditText) findViewById(R.id.your_name_view);
        String name = nameView.getText().toString();
        int score = 0;

        if (rg1.getCheckedRadioButtonId() == answer1c) {
            score = score + 10;
        }
        if (rg2.getCheckedRadioButtonId() == answer2a) {
            score = score + 10;
        }
        if (rg3.getCheckedRadioButtonId() == answer3b) {
            score = score + 10;
        }
        if (rg4.getCheckedRadioButtonId() == answer4a) {
            score = score + 10;
        }
        if (rg5.getCheckedRadioButtonId() == answer5b) {
            score = score + 10;
        }
        if (!(chk6a.isChecked() && chk6c.isChecked())) { //Question 6
            if (chk6b.isChecked()) {
                score = score + 5;
            }
            if (chk6d.isChecked()) {
                score = score + 5;
            }
        }
        if (rg7.getCheckedRadioButtonId() == answer7b) {
            score = score + 10;
        }
        if (rg8.getCheckedRadioButtonId() == answer8a) {
            score = score + 10;
        }
        if (rg9.getCheckedRadioButtonId() == answer9b) {
            score = score + 10;
        }
        if (rg10.getCheckedRadioButtonId() == answer10d) {
            score = score + 10;
        }
        int correctAnswer = score / 10;
        String message1 = getString(R.string.Toast1a) + name + getString(R.string.Toast2a) + getString(R.string.Toast3a) + getString(R.string.Toast4a) + score + getString(R.string.Toast5a) + getString(R.string.Toast6a) + correctAnswer + getString(R.string.Toast7a);
        String message2 = getString(R.string.Toast8a) + name + getString(R.string.Toast9a) + getString(R.string.Toast4a) + score + getString(R.string.Toast5a) + getString(R.string.Toast6a) + correctAnswer + getString(R.string.Toast7a);
        String message3 = getString(R.string.Toast10a) + name + getString(R.string.Toast11a) + getString(R.string.Toast4a) + score + getString(R.string.Toast5a) + getString(R.string.Toast6a) + correctAnswer + getString(R.string.Toast7a);
        if (correctAnswer <= 5) {
            displayToast(message1);
        }
        if (correctAnswer > 5 && correctAnswer <= 8) {
            displayToast(message2);
        }
        if (correctAnswer > 8) {
            displayToast(message3);
        }
    }
    private void allFilled(RadioGroup radioGroup) {
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            allFilled = false;
        }
    }

    private void editTextFilled() {
        EditText nameView = (EditText) findViewById(R.id.your_name_view);
        String name = nameView.getText().toString();
        if (name.equals("")) {
            allFilled = false;
        }
    }

    private void checkBoxesFilled() {
        if (!chk6a.isChecked() && !chk6b.isChecked() && !chk6c.isChecked() && !chk6d.isChecked()) {
            allFilled = false;
        }
    }

    private void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
