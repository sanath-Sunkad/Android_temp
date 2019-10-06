package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements DescriptionListFragment.DescriptionListner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void itemClicked(long id) {
        View fragmentContainer=findViewById(R.id.fragcontainer);

        if(fragmentContainer!=null)
        {
            DescriptionDetailFragment newDetailFrag=new DescriptionDetailFragment();
            newDetailFrag.setDetailDescID(id);

            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();

            ft.replace(R.id.fragcontainer,newDetailFrag);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();

        }
        else
        {
            Intent intent=new Intent(this,DetailActivity.class);
            intent.putExtra(DetailActivity.DESC_ID,(int)id);
            startActivity(intent);

        }
    }
}
