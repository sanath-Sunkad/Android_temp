package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class DescriptionDetailFragment extends Fragment {

    private long detailDescID;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if(savedInstanceState!=null)
        {

            detailDescID=savedInstanceState.getLong("detailDescID");
        }
    }
    @Override
    public View onCreateView(LayoutInflater i, ViewGroup container,Bundle savedInstanceState)
    {
        return i.inflate(R.layout.fragment_description_detail,container,false);
    }

    @Override
    public void onStart()
    {
        super.onStart();

        View view =getView();

        if (view!=null)
        {
            Description description=Description.descriptionArray[(int)detailDescID];

            TextView title= view.findViewById(R.id.textView4);
            TextView desc=view.findViewById(R.id.textView3);
            ImageView img=view.findViewById(R.id.imageView);

            title.setText(description.getName());
            desc.setText(description.getDesc());
            img.setImageResource(description.getImgres());
            img.setContentDescription(description.getName());
        }
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putLong("detailDescID",detailDescID);
    }

    void setDetailDescID(long id)
    {
        this.detailDescID=id;
    }


}
