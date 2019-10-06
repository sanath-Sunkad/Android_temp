package com.example.cslanguages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    TypedArray images;
    String [] titleList;
    String [] descList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleList=getResources().getStringArray(R.array.languages);
        descList=getResources().getStringArray(R.array.languageDesc);
        images=getResources().obtainTypedArray(R.array.langImg);
        lv=(ListView)findViewById(R.id.listview);

        OurAdapter ouradapter=new OurAdapter(this,titleList,descList,images);
        lv.setAdapter(ouradapter);


    }
}
