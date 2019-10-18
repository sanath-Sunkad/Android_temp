package com.example.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.fragment.app.ListFragment;

public class PageThreeFragment extends ListFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(inflater.getContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.PageThree));
        setListAdapter(adapter);
        return super.onCreateView(inflater,container,savedInstanceState);
    }
}
