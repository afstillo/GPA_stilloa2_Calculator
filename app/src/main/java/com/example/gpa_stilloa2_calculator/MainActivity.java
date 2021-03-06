package com.example.gpa_stilloa2_calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

/*
NOTE: I tried to keep string literals entirely out of my code, and as such any instance of a String
is stored in the strings.xml file.
 */
public class MainActivity extends AppCompatActivity {

    Button calculateGPA;
    EditText gpa1, gpa2, gpa3, gpa4, gpa5;
    TextView outputGPA;
    ConstraintLayout layout;
    /*
    calculateGPA = Button to calculate GPA or reset all fields once the GPA has been calculated.
    gpa1, gpa2, gpa3, gpa4, gpa5 = EditText fields for each individual grade entered by the user.
    outputGPA = TextView for the output GPA. Also has the default instructions for use, and error messages.
    layout = constraint layout for use in changing the background color.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculateGPA = findViewById(R.id.calculate);
        gpa1 = findViewById(R.id.entry1);
        gpa2 = findViewById(R.id.entry2);
        gpa3 = findViewById(R.id.entry3);
        gpa4 = findViewById(R.id.entry4);
        gpa5 = findViewById(R.id.entry5);
        outputGPA = findViewById(R.id.showGPA);
        layout = findViewById(R.id.constraintLayout);
        //Associating each value with its respective widget id in the XML.//

        gpa1.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (calculateGPA.getText().toString().equals(getString(R.string.clear))) {
                    outputGPA.setText(R.string.instructions);
                    layout.setBackgroundResource(R.color.black);
                    calculateGPA.setText(R.string.compute_gpa);
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        gpa2.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (calculateGPA.getText().toString().equals(getString(R.string.clear))) {
                    outputGPA.setText(R.string.instructions);
                    layout.setBackgroundResource(R.color.black);
                    calculateGPA.setText(R.string.compute_gpa);
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        gpa3.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (calculateGPA.getText().toString().equals(getString(R.string.clear))) {
                    outputGPA.setText(R.string.instructions);
                    layout.setBackgroundResource(R.color.black);
                    calculateGPA.setText(R.string.compute_gpa);
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        gpa4.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (calculateGPA.getText().toString().equals(getString(R.string.clear))) {
                    outputGPA.setText(R.string.instructions);
                    layout.setBackgroundResource(R.color.black);
                    calculateGPA.setText(R.string.compute_gpa);
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        gpa5.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (calculateGPA.getText().toString().equals(getString(R.string.clear))) {
                    outputGPA.setText(R.string.instructions);
                    layout.setBackgroundResource(R.color.black);
                    calculateGPA.setText(R.string.compute_gpa);
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        /*
        Each of these text listeners are the same, they just function on different EditTexts.
        If the button to calculate GPA has been pressed, and any of the EditTexts are modified,
        the background is reset to black and the button and text are reset to their initial states.
         */

    }
    public void onClick(View v){
        if (calculateGPA.getText().toString().equals(getString(R.string.compute_gpa))) {
            /*
            The way I chose to handle the button switching to clear was through checking the text
            on the button itself. This case executes if the button has the default text.
             */

            boolean flag = true;
            /*
            flag = boolean flag variable used to show that all entered grades are valid.
            true = valid, false = invalid.
             */

            gpa1.setBackgroundResource(R.color.gray);
            gpa2.setBackgroundResource(R.color.gray);
            gpa3.setBackgroundResource(R.color.gray);
            gpa4.setBackgroundResource(R.color.gray);
            gpa5.setBackgroundResource(R.color.gray);

            float grade1, grade2, grade3, grade4, grade5, avgGPA;
            /*
            grade1, grade2, grade3, grade4, grade5 = each grader entered by the user.
            avgGPA = the final average gpa computed.
             */

            if (gpa1.getText().toString().equals("") || gpa2.getText().toString().equals("")
                    || gpa3.getText().toString().equals("") || gpa4.getText().
                    toString().equals("") || gpa5.getText().toString().equals("")) {
                outputGPA.setText(R.string.blank_field);
                return;
                /*
                While this return is not necessary in a void method, I chose to include
                it as a way of stopping execution of the method, as I could not find a better
                way of doing so. The alternative was another indent later in the program
                that I felt made the code unnecessarily complex to read and look at.
                There most likely is a better implementation of this, but this is functional.
                 */
            }
            //Check for any empty fields, and notify the user if so.

            grade1 = Float.parseFloat(gpa1.getText().toString());
            grade2 = Float.parseFloat(gpa2.getText().toString());
            grade3 = Float.parseFloat(gpa3.getText().toString());
            grade4 = Float.parseFloat(gpa4.getText().toString());
            grade5 = Float.parseFloat(gpa5.getText().toString());
            //Parse the text from each EditText to a float.

            if (grade1 < 0 || grade1 > 100) {
                gpa1.setBackgroundResource(R.color.red);
                outputGPA.setText(R.string.invalid_grade);
                flag = false;
            }

            if (grade2 < 0 || grade2 > 100) {
                gpa2.setBackgroundResource(R.color.red);
                outputGPA.setText(R.string.invalid_grade);
                flag = false;
            }

            if (grade3 < 0 || grade3 > 100) {
                gpa3.setBackgroundResource(R.color.red);
                outputGPA.setText(R.string.invalid_grade);
                flag = false;
            }

            if (grade4 < 0 || grade4 > 100) {
                gpa4.setBackgroundResource(R.color.red);
                outputGPA.setText(R.string.invalid_grade);
                flag = false;
            }

            if (grade5 < 0 || grade5 > 100) {
                gpa5.setBackgroundResource(R.color.red);
                outputGPA.setText(R.string.invalid_grade);
                flag = false;
            }
            /*
            Each of these if cases function the same with respect to different EditTexts. If the
            value is not a valid grade (out of the range of 0 to 100), highlight it in red and
            set the flag to false so the GPA will not be calculated.
             */

            if (flag) {
                avgGPA = (grade1 + grade2 + grade3 + grade4 + grade5) / 5;
                outputGPA.setText(String.format(Locale.US, "%.2f", avgGPA));
                //calculate and display the average GPA.

                if (avgGPA < 60) {
                    layout.setBackgroundResource(R.color.red);
                } else if (avgGPA < 80) {
                    layout.setBackgroundResource(R.color.yellow);
                } else {
                    layout.setBackgroundResource(R.color.green);
                }
                calculateGPA.setText(R.string.clear);
                //change the background accordingly and change the button text.
            }
        }
        else {
            /*
            This case executes if the button text reads anything other than "calculate GPA", which
            the only other possibility for is "clear form".
             */

            outputGPA.setText(R.string.instructions);
            gpa1.setText("");
            gpa2.setText("");
            gpa3.setText("");
            gpa4.setText("");
            gpa5.setText("");
            layout.setBackgroundResource(R.color.black);
            calculateGPA.setText(R.string.compute_gpa);
            //clear each text field, reset the background, and set the button to its initial state.
        }
    }
}
