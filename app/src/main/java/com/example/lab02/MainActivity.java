package com.example.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    // input fields
    private EditText nameTf, fnTf, editTextPhone;
    private RadioButton maleRb, femaleRb, nineRb, tenRb, radioButton;
    private CheckBox mathsCb, chemCb, phyCb, bioCb, compCb, islCb, pakCb, engCb, urduCb;
    private ToggleButton toggleButton;
    private SeekBar seekBar;
    private Button submitBtn;
    private RadioGroup rG1, rG2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Taking all input fields in this activity
        nameTf = (EditText) findViewById(R.id.nameTf);
        fnTf = (EditText) findViewById(R.id.fnTf);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);

        rG1 = (RadioGroup) findViewById(R.id.rG1);
        maleRb = (RadioButton) findViewById(R.id.maleRb);
        femaleRb = (RadioButton) findViewById(R.id.femaleRb);

        rG2 = (RadioGroup) findViewById(R.id.rG2);
        nineRb = (RadioButton) findViewById(R.id.nineRb);
        tenRb = (RadioButton) findViewById(R.id.tenRb);

        mathsCb = (CheckBox) findViewById(R.id.mathCb9);
        chemCb = (CheckBox) findViewById(R.id.chemCb);
        phyCb = (CheckBox) findViewById(R.id.phyCb);
        bioCb = (CheckBox) findViewById(R.id.bioCb);
        compCb = (CheckBox) findViewById(R.id.compCb);
        islCb = (CheckBox) findViewById(R.id.islCb);
        pakCb = (CheckBox) findViewById(R.id.pstCb);
        engCb = (CheckBox) findViewById(R.id.engCb);
        urduCb = (CheckBox) findViewById(R.id.urduCb);

        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        submitBtn = (Button) findViewById(R.id.button);


        // Validating & Displaying Data on Submit Button Clicking

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // taking the data in edit text fields
                String stdName = nameTf.getText().toString();
                String stdFName = fnTf.getText().toString();
                String stdPhone = editTextPhone.getText().toString();

//                System.out.println("value: "+maleRb.isSelected());

                // name edit text field is empty
                if(stdName.trim().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please enter name!",Toast.LENGTH_SHORT).show();
                }
                // father name edit text field is empty
                else if(stdFName.trim().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please enter father name!",Toast.LENGTH_SHORT).show();
                }
                // phone number edit text field is empty
                else if(stdPhone.trim().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please enter phone number!",Toast.LENGTH_SHORT).show();
                }
                // if phone number length is less than 11
                else if(!(stdPhone.length()==11)){
                    Toast.makeText(getApplicationContext(),"Phone number must be of 11 digits!",Toast.LENGTH_SHORT).show();
                }
                // any of the gender radio button is not selected
//                else if(!(maleRb.isSelected() || femaleRb.isSelected())){
                else if(rG1.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getApplicationContext(),"Please select gender!",Toast.LENGTH_SHORT).show();
                }
                // any of the class radio button is not selected
//                else if(!(nineRb.isSelected() || tenRb.isSelected())){
                else if(rG2.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getApplicationContext(),"Please select class!",Toast.LENGTH_SHORT).show();
                }
                // any of the subject checkbox is not selected
                else if(!(mathsCb.isChecked() || chemCb.isChecked() || phyCb.isChecked() || bioCb.isChecked() || compCb.isChecked() || islCb.isChecked() || pakCb.isChecked() || engCb.isChecked() || urduCb.isChecked())){
                    Toast.makeText(getApplicationContext(),"Please select a course!",Toast.LENGTH_SHORT).show();
                }
                // if anyone is selected
                else if(mathsCb.isChecked() || chemCb.isChecked() || phyCb.isChecked() || bioCb.isChecked() || compCb.isChecked() || islCb.isChecked() || pakCb.isChecked() || engCb.isChecked() || urduCb.isChecked()){

                    // count that at least three courses must be selected & store the selected courses;

                    int selectedCourses = 0;

                    String courses[] = new String[9];

                    if(mathsCb.isChecked()){
                        courses[selectedCourses] = "Maths";
                        selectedCourses++;
                    }
                    if(chemCb.isChecked()){
                        courses[selectedCourses] = "Chemistry";
                        selectedCourses++;
                    }
                    if(phyCb.isChecked()){
                        courses[selectedCourses] = "Physics";
                        selectedCourses++;
                    }
                    if(bioCb.isChecked()){
                        courses[selectedCourses] = "Biology";
                        selectedCourses++;
                    }
                    if(compCb.isChecked()){
                        courses[selectedCourses] = "Computer";
                        selectedCourses++;
                    }
                    if(engCb.isChecked()){
                        courses[selectedCourses] = "English";
                        selectedCourses++;
                    }
                    if(urduCb.isChecked()){
                        courses[selectedCourses] = "Urdu";
                        selectedCourses++;
                    }
                    if(islCb.isChecked()){
                        courses[selectedCourses] = "Islamiat";
                        selectedCourses++;
                    }
                    if(pakCb.isChecked()){
                        courses[selectedCourses] = "Pakistan Studies";
                        selectedCourses++;
                    }

                    // courses selected must be at least 6
                    // Came here when all the data is validated so display all the form data
                    if(selectedCourses>=6){

                        String stdGender=null;
                        String stdClass=null;
                        String news=null;

                        // get selected radio button from radioGroup of gender
                        int selectedId = rG1.getCheckedRadioButtonId();

                        // find the radiobutton by returned id
                        radioButton = (RadioButton) findViewById(selectedId);

                        stdGender = radioButton.getText().toString();

                        // taking the selected gender
//                        if(maleRb.isSelected()){
//                            stdGender = "Male";
//                        }
//                        else{
//                            stdGender = "Female";
//                        }

                        // get selected radio button from radioGroup for class
                        selectedId = rG2.getCheckedRadioButtonId();

                        // find the radiobutton by returned id
                        radioButton = (RadioButton) findViewById(selectedId);

                        stdClass = radioButton.getText().toString();

                        // taking the selected class
//                        if(nineRb.isSelected()){
//                            stdClass = "9th";
//                        }
//                        else{
//                            stdClass = "10th";
//                        }

                        // toggle button is on or off
                        if(toggleButton.isChecked()){
                            news = "Subscribed!";
                        }
                        else{
                            news = "Not Subscribed!";
                        }

                        // prepare form data
                        String formData = "Form Submitted Successfully!\nStudent Form Data:\nName: "+stdName+"\nFather Name: "+stdFName+"\nPhone Number: "+stdPhone+"\nGender: "+stdGender+"\nClass: "+stdClass+"\nNewsletter: "+news;

//                        +"\nCourses selected: "+courses[count-1]
//                        Toast.makeText(getApplicationContext(),"Courses: "+courses[count--],Toast.LENGTH_LONG).show();

                        // display data
                        Toast.makeText(getApplicationContext(),formData,Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Please select at least 6 courses!",Toast.LENGTH_SHORT).show();
                    }
                }

            }

        });
    }
}