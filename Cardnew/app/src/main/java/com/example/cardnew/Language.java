package com.example.cardnew;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Objects;

public class Language extends AppCompatActivity {
    public static final String EXTRA_ID="position";
    public  static String [] titles;
    public static TypedArray images;

    TextView text=findViewById(R.id.textView2);
    ImageView im=findViewById(R.id.imageView2);
    public static ArrayList<LanguageClass> languageClassArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        //DescriptionDetailFragment newDetailFrag = (DescriptionDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detailfrag);
        int pos=(int) Objects.requireNonNull(getIntent().getExtras()).get(EXTRA_ID);
        //Objects.requireNonNull(newDetailFrag).setDetailDescID(descID);
        titles=getResources().getStringArray(R.array.languages);
        images=getResources().obtainTypedArray(R.array.langImg);

        languageClassArrayList =new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
                languageClassArrayList.add(new LanguageClass(titles[i], images.getResourceId(i, 0)));
            }
        text.setText(titles[0]);
        im.setImageResource(images.getResourceId(0,0));




    }


}

