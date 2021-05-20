package com.example.firetest;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edit_name = findViewById(R.id.edit_name);
        EditText edit_position = findViewById(R.id.edit_position);
        Button btn = findViewById(R.id.btn_submit);
        DAOEmployee dao = new DAOEmployee();
        btn.setOnClickListener(v->
        {
            Employee emp = new Employee(edit_name.getText().toString(),edit_position.getText().toString());
            dao.add(emp).addOnSuccessListener(suc->{
                Toast.makeText(this,"Record is inserted",Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->
            {
              Toast.makeText(this,""+er.getMessage(),Toast.LENGTH_SHORT).show();
            });
        });

    }
}