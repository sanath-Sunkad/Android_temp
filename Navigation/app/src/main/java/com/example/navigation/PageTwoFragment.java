package com.example.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class PageTwoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_detail,container,false);
    }

    @Override
    public void onStart()
    {
        super.onStart();
        View view=getView();
        if(view !=null)
        {
            TextView title=view.findViewById(R.id.texttitle);
            TextView desc=view.findViewById(R.id.textdesc);
            ImageView img=view.findViewById(R.id.imageView);

            title.setText(R.string.T1);
            desc.setText(R.string.T2);
            img.setImageResource(R.drawable.lion);
            img.setContentDescription("image");
        }
    }
}
