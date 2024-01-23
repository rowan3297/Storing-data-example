package com.example.keepingdata;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button savebtn = findViewById(R.id.save);
        Button loadbtn = findViewById(R.id.load);
    }

    public void onClickSave(View view) {
        EditText lname_edit = findViewById(R.id.editLname);
        EditText fname_edit = findViewById(R.id.editFname);
        EditText dob_edit = findViewById(R.id.editBirth);
        EditText age_edit = findViewById(R.id.editAge);

        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        String lname = lname_edit.getText().toString();
        String fname = fname_edit.getText().toString();
        String dob = dob_edit.getText().toString();
        String age = age_edit.getText().toString();
        edit.putString("lname", lname);
        edit.putString("fname", fname);
        edit.putString("dob", dob);
        edit.putString("age", age);
        edit.apply();

        Toast.makeText(MainActivity.this, "Saved it", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onClickSave: Toast is an Android class which is used to display messages to the user");

    }

    public void onClickLoad(View view) {
        TextView name_text = findViewById(R.id.textView);

        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        String lname = sp.getString("lname", "na");
        String fname = sp.getString("fname", "na");
        String dob = sp.getString("dob", "na");
        String age = sp.getString("age", "na");
        name_text.setText(String.format("%s, %s,%s,%s", lname, fname,dob,age));
    }

}