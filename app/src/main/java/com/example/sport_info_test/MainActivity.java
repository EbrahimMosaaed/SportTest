package com.example.sport_info_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Integer> correctResults = new ArrayList<Integer>();
    private RadioGroup mRadioGroupOne;
    private RadioGroup mRadioGroupTwo;
    private RadioGroup mRadioGroupThree;
    private RadioGroup mRadioGroupFour;
    private EditText mEditText;
    private CheckBox mCheckBoxOne;
    private CheckBox mCheckBoxTwo;
    private CheckBox mCheckBoxThree;
    private boolean mCheckBoxOneResult;
    private boolean mCheckBoxTwoResult;
    private boolean mCheckBoxThreeResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRadioGroupOne = (RadioGroup) findViewById(R.id.raido_group_one);
        mRadioGroupOne.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.first_radio_qus1 && !correctResults.contains(R.id.first_radio_qus1))
                correctResults.add(R.id.first_radio_qus1);
        });

        mRadioGroupTwo = (RadioGroup) findViewById(R.id.raido_group_two);
        mRadioGroupTwo.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.second_radio_qus2 && !correctResults.contains(R.id.second_radio_qus2))
                correctResults.add(R.id.second_radio_qus2);
        });

        mRadioGroupThree = (RadioGroup) findViewById(R.id.raido_group_three);
        mRadioGroupThree.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.second_radio_qus3 && !correctResults.contains(R.id.second_radio_qus3))
                correctResults.add(R.id.second_radio_qus3);
        });

        mRadioGroupFour = (RadioGroup) findViewById(R.id.raido_group_four);
        mRadioGroupFour.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.third_radio_qus4 && !correctResults.contains(R.id.third_radio_qus4))
                correctResults.add(R.id.third_radio_qus4);
        });


        mCheckBoxOne = (CheckBox) findViewById(R.id.checkbox_one);
        mCheckBoxOne.setOnCheckedChangeListener((view, isChecked) -> {
            if (isChecked)
                mCheckBoxOneResult = true;
        });
        mCheckBoxTwo = (CheckBox) findViewById(R.id.checkbox_two);
        mCheckBoxTwo.setOnCheckedChangeListener((view, isChecked) -> {
            if (isChecked)
                mCheckBoxTwoResult = true;
        });

        mCheckBoxThree = (CheckBox) findViewById(R.id.checkbox_three);
        mCheckBoxThree.setOnCheckedChangeListener((view, isChecked) -> {
            if (isChecked)
                mCheckBoxThreeResult = true;
        });


        Button submitButton = (Button) findViewById(R.id.submit_btn);
        submitButton.setOnClickListener((v) -> {
            // call checkBoxs method
            checkBoxs();
            // call editText method
            onEditText();
            // Here we could reset all values for radio buttons..
            if (correctResults != null) {
                Toast.makeText(MainActivity.this, "Your correct answers is " + correctResults.size() + " out of 6", Toast.LENGTH_LONG).show();
                correctResults.clear();
                mRadioGroupOne.clearCheck();
                mRadioGroupTwo.clearCheck();
                mRadioGroupThree.clearCheck();
                mRadioGroupFour.clearCheck();
                mEditText.setText("");
                mCheckBoxOneResult = false;
                mCheckBoxTwoResult = false;
                mCheckBoxThreeResult = false;
                mCheckBoxOne.setChecked(false);
                mCheckBoxTwo.setChecked(false);
                mCheckBoxThree.setChecked(false);
            } else {
                Toast.makeText(MainActivity.this, "There is no answer have been submitted\nplease answer the questions firstly", Toast.LENGTH_LONG).show();
            }
        });
    }


    public void onEditText() {
        mEditText = (EditText) findViewById(R.id.edit_text_value);
        String value = mEditText.getText().toString().trim();
        if (value.contains("2003") && !correctResults.contains(R.id.edit_text_value))
            // right answer
            correctResults.add(R.id.edit_text_value);
    }

    public void checkBoxs() {
        // we just check if the values of checkbox one and two are true
        // set any integer number to increase the arraylist size
        if (mCheckBoxOneResult && mCheckBoxTwoResult) {
            correctResults.add(1);
        }
    }


}
