package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View btn= findViewById(R.id.button);
        btn.setOnClickListener(this);
        Button btn1= (Button) findViewById(R.id.button2);
        final TextView txt=(TextView) findViewById(R.id.textView);
        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                txt.setText("hekk");
            }

        });
    }
    public void onClick(View v){
        switch(v.getId()){
            case R.id.button:
            Toast.makeText(this,"sanath",Toast.LENGTH_LONG).show();
        }

    }
}
