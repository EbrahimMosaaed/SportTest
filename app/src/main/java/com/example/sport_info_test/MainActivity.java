package com.example.sport_info_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Integer> correctResults = new ArrayList<Integer>();
    private RadioGroup mRadioGroupOne;
    private RadioGroup mRadioGroupTwo;
    private RadioGroup mRadioGroupThree;
    private RadioGroup mRadioGroupFour;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRadioGroupOne = (RadioGroup) findViewById(R.id.raido_group_one);
        mRadioGroupOne.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.first_radio_qus1 && !correctResults.contains(R.id.first_radio_qus1))
                    correctResults.add(R.id.first_radio_qus1);
            }
        });

        mRadioGroupTwo = (RadioGroup) findViewById(R.id.raido_group_two);
        mRadioGroupTwo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.second_radio_qus2 && !correctResults.contains(R.id.second_radio_qus2))
                    correctResults.add(R.id.second_radio_qus2);
            }
        });

        mRadioGroupThree = (RadioGroup) findViewById(R.id.raido_group_three);
        mRadioGroupThree.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.second_radio_qus3 && !correctResults.contains(R.id.second_radio_qus3))
                    correctResults.add(R.id.second_radio_qus3);
            }
        });

        mRadioGroupFour = (RadioGroup) findViewById(R.id.raido_group_four);
        mRadioGroupFour.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.third_radio_qus4 && !correctResults.contains(R.id.third_radio_qus4))
                    correctResults.add(R.id.third_radio_qus4);
            }
        });

    }

//    public void onQustionOneClicked(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//        // Check which radio button was clicked
//        switch (view.getId()) {
//            case R.id.first_radio_qus1:
//                if (checked)
//                    // right answer
//                    correctResults.add(true);
//                break;
//            case R.id.second_radio_qus1:
//            case R.id.third_radio_qus1:
//                if (checked)
//                    break;
//        }
//    }


    public void onEditText() {
        mEditText = (EditText) findViewById(R.id.edit_text_value);
        String value = mEditText.getText().toString();
        // Log.v("MainActivity", "value " + value);
        if (value.contains("2003") && !correctResults.contains(R.id.edit_text_value))
            // right answer
            correctResults.add(R.id.edit_text_value);


    }

    public void onSubmitClicked(View v) {
        onEditText();
        if (correctResults != null) {
            Toast.makeText(MainActivity.this, "Your correct answers is " + correctResults.size() + " out of 5", Toast.LENGTH_LONG).show();

        }
        // Here we could reset all values for radio buttons..
        correctResults.clear();
        mRadioGroupOne.clearCheck();
        mRadioGroupTwo.clearCheck();
        mRadioGroupThree.clearCheck();
        mRadioGroupFour.clearCheck();
        mEditText.setText("");

    }
}