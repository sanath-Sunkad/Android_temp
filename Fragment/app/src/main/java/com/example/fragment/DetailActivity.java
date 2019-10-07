package com.example.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    public static final String DESC_ID="id";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        DescriptionDetailFragment newDetailFrag = (DescriptionDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detailfrag);
        int descID=(int) Objects.requireNonNull(getIntent().getExtras()).get(DESC_ID);
        Objects.requireNonNull(newDetailFrag).setDetailDescID(descID);

    }
}
