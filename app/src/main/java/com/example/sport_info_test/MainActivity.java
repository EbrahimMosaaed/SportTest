package com.example.sport_info_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sport_info_test.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final ArrayList<Integer> correctResults = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Button submitButton = binding.submitBtn;
        submitButton.setOnClickListener((v) -> {
            int questionOneCheckedId = binding.QuestionOneGroup.getCheckedRadioButtonId();
            if (questionOneCheckedId == R.id.first_radio_qus1 && !correctResults.contains(R.id.first_radio_qus1))
                correctResults.add(R.id.first_radio_qus1);

            int questionTwoCheckedId = binding.QuestionTwoGroup.getCheckedRadioButtonId();
            if (questionTwoCheckedId == R.id.second_radio_qus2 && !correctResults.contains(R.id.second_radio_qus2))
                correctResults.add(R.id.second_radio_qus2);

            int questionThreeCheckedId = binding.QuestionThreeGroup.getCheckedRadioButtonId();
            if (questionThreeCheckedId == R.id.second_radio_qus3 && !correctResults.contains(R.id.second_radio_qus3))
                correctResults.add(R.id.second_radio_qus3);

            int questionFourCheckedId = binding.QuestionFourGroup.getCheckedRadioButtonId();
            if (questionFourCheckedId == R.id.third_radio_qus4 && !correctResults.contains(R.id.third_radio_qus4))
                correctResults.add(R.id.third_radio_qus4);

            // we just check if the values of checkbox one and two are true
            // set any integer number to increase the arraylist size
            if (binding.QuestionFiveOptionA.isChecked() && binding.QuestionFiveOptionB.isChecked() && !binding.QuestionFiveOptionC.isChecked()) {
                correctResults.add(1);
            }
            // call editText method
            onEditText();

            // Here we could reset all values for radio buttons..
            if (correctResults != null) {
                Toast.makeText(MainActivity.this, "Your correct answers is " + correctResults.size() + " out of 6", Toast.LENGTH_LONG).show();
                binding.QuestionOneGroup.clearCheck();
                binding.QuestionTwoGroup.clearCheck();
                binding.QuestionThreeGroup.clearCheck();
                binding.QuestionFourGroup.clearCheck();
                binding.editTextValue.setText("");
                binding.QuestionFiveOptionA.setChecked(false);
                binding.QuestionFiveOptionB.setChecked(false);
                binding.QuestionFiveOptionC.setChecked(false);
                correctResults.clear();
            } else {
                Toast.makeText(MainActivity.this, "There is no answer have been submitted\nplease answer the questions firstly", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void onEditText() {
        String value = binding.editTextValue.getText().toString().trim();
        if (value.equals("2003") && !correctResults.contains(R.id.edit_text_value))
            // right answer
            correctResults.add(R.id.edit_text_value);
    }
}
