package com.group4.joseph.firebasetutorial1;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity{

    private Button firebase_button;
    private FirebaseDatabase mDatabase;
    private EditText nameInput, emailInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebase_button = (Button)findViewById(R.id.firebase_button);


        nameInput = (EditText)findViewById(R.id.nameInput);
        emailInput = (EditText)findViewById(R.id.emailInput);

        mDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = mDatabase.getReference();       //This will point straight to the root directory
        //final DatabaseReference myRef = mDatabase.getReference("child");      //This will point to directory called "child"

        firebase_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String name = nameInput.getText().toString().trim();
                String email = emailInput.getText().toString().trim();

                HashMap<String, String> dataMap = new HashMap<String, String>();
                dataMap.put("Name", name);
                dataMap.put("Email", email);

                //OnCompleteListener will check if our task was completed successfully
                //myRef.push() will add our entry to the Firebase DB with a unique/ random key
                myRef.push().setValue(dataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Data stored successfully", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Error storing data", Toast.LENGTH_LONG).show();

                        }
                    }
                });
            }
        });
    }



}
