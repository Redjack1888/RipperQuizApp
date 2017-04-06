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

public class MainActivity extends AppCompatActivity {
    private RadioGroup rg1;
    private RadioGroup rg2;
    private RadioGroup rg3;
    private RadioGroup rg4;
    private RadioGroup rg5;
    private RadioGroup rg7;
    private RadioGroup rg8;
    private RadioGroup rg9;
    private RadioGroup rg10;

    private CheckBox chk6a;
    private CheckBox chk6b;
    private CheckBox chk6c;
    private CheckBox chk6d;

    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = 0;

        rg1 = (RadioGroup) findViewById(R.id.rg1View); //Multiple
        rg2 = (RadioGroup) findViewById(R.id.rg3View); //True False
        rg3 = (RadioGroup) findViewById(R.id.rg4View); //True False
        rg4 = (RadioGroup) findViewById(R.id.rg5View); //Multiple
        rg5 = (RadioGroup) findViewById(R.id.rg7View); //Multiple
        rg7 = (RadioGroup) findViewById(R.id.rg11View); //True False
        rg8 = (RadioGroup) findViewById(R.id.rg12View); //True False
        rg9 = (RadioGroup) findViewById(R.id.rg13View); //Multiple
        rg10 = (RadioGroup) findViewById(R.id.rg15View); //Multiple

        chk6a = (CheckBox) findViewById(R.id.check6a); //Multiple checkboxes
        chk6b = (CheckBox) findViewById(R.id.check6b); //Multiple checkboxes
        chk6c = (CheckBox) findViewById(R.id.check6c); //Multiple checkboxes
        chk6d = (CheckBox) findViewById(R.id.check6d); //Multiple checkboxes


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

    public void reset(View v) {

        score = 0;

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

        Button submit = (Button) findViewById(R.id.submit_button);
        submit.setEnabled(true);

    }

    public void submit(View view) {
        EditText nameView = (EditText) findViewById(R.id.your_name_view);
        String name = nameView.getText().toString();

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
        if (score <= 20) {
            Toast toast = Toast.makeText(this, getString(R.string.Toast1a) + name + getString(R.string.Toast2a) + getString(R.string.Toast3a) + getString(R.string.Toast4a) + score + getString(R.string.Toast5a) + getString(R.string.Toast6a) + correctAnswer + getString(R.string.Toast7a), Toast.LENGTH_LONG);
            toast.show();
        }
        if (score > 21 && score <= 80) {
            Toast toast = Toast.makeText(this, getString(R.string.Toast8a) + name + getString(R.string.Toast9a) + getString(R.string.Toast4a) + score + getString(R.string.Toast5a) + getString(R.string.Toast6a) + correctAnswer + getString(R.string.Toast7a), Toast.LENGTH_LONG);
            toast.show();
        } else {
            Toast toast = Toast.makeText(this, getString(R.string.Toast10a) + name + getString(R.string.Toast11a) + getString(R.string.Toast4a) + score + getString(R.string.Toast5a) + getString(R.string.Toast6a) + correctAnswer + getString(R.string.Toast7a), Toast.LENGTH_LONG);
            toast.show();
        }
        Button submit = (Button) findViewById(R.id.submit_button);
        submit.setEnabled(false);
    }
}
