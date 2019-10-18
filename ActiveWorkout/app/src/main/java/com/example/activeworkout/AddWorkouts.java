package com.example.activeworkout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddWorkouts extends AppCompatActivity {

    private String title,desc,sets,reps;
    EditText t,d,s,r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_workout);

        t=findViewById(R.id.inputTitle);
        d=findViewById(R.id.inputDesc);
        s=findViewById(R.id.inputSets);
        r=findViewById(R.id.inputReps);

        Button b1=findViewById(R.id.add);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertToDb();
            }
        });
    }

    private void insertToDb()
    {
        title=t.getText().toString();
        desc=d.getText().toString();
        sets=s.getText().toString();
        reps=r.getText().toString();

        DBHelper helper=new DBHelper(this);
        helper.insertValues(title,sets,reps,desc);

        this.finish();

    }
}
