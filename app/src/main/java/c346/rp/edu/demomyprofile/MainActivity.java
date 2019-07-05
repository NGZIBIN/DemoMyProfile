package c346.rp.edu.demomyprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText etName;
EditText etGPA;
RadioGroup rgGender;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
        rgGender = findViewById(R.id.rg);
        btn = findViewById(R.id.buttonSave);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
    @Override
    protected void onPause() {
        super.onPause();
        String strName = etName.getText().toString();
        Float gpa = Float.parseFloat(etGPA.getText().toString());
        int genderID = rgGender.getCheckedRadioButtonId();
        //Step 1a: Obtain an instance of the sharedpreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Step 1b: Obtain an instance of the SharedPreferences Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();
        //Step 1c: Add the key-value pair
        prefEdit.putString("name", strName);
        prefEdit.putFloat("GPA", gpa);
        prefEdit.putInt("gender", genderID);
        //Step 1d Call commit() to save the changes into SharedPreferences
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String msg = prefs.getString("name", "No name saved");
        String msg1 = prefs.getString("GPA", "No GPA saved");
        int defaultGender = prefs.getInt("gender",0);
        etName.setText(msg);
        etGPA.setText(msg1);
        rgGender.check(defaultGender);

    }


}
