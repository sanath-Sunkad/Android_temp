package com.example.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

public class DescriptionListFragment extends ListFragment {

    interface DescriptionListner{
        void itemClicked(long id);
    }

    private DescriptionListner listner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState)
    {
        String [] listTitles=new String [Description.descriptionArray.length];
        for(int i=0;i<listTitles.length;i++)
        {
            listTitles[i]=Description.descriptionArray[i].getName();
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(inflater.getContext(),android.R.layout.simple_list_item_1,listTitles);
        setListAdapter(adapter);
        return super.onCreateView(inflater,viewGroup,savedInstanceState);
    }
    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if (context instanceof DescriptionListner)
        {
            listner=(DescriptionListner)context;
        }
        else
        {
            throw new RuntimeException(context.toString()+" must implement listner");

        }
    }

    @Override
    public void onListItemClick(ListView l,View v,int position,long id)
    {
        if(listner!=null)
        {
            listner.itemClicked(id);
        }
    }

}
