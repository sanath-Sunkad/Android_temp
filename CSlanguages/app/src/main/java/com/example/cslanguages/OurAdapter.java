package com.example.cslanguages;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class OurAdapter extends BaseAdapter {

    private String[] titles;
    private String[] desc;
    private TypedArray imgid;

    private Context context;
    private static LayoutInflater layoutInflater;

    OurAdapter(Context adaptercontext,String [] titleList,String [] descList,TypedArray images){
        titles=titleList;
        desc=descList;
        imgid=images;
        context=adaptercontext;
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class ViewHolder{
        TextView tv1,tv2;
        ImageView img;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder viewholder=new ViewHolder();
        if(view==null){
            view=layoutInflater.inflate(R.layout.list_layout,parent,false);
            viewholder.tv1=(TextView) view.findViewById(R.id.textView);
            viewholder.tv2=(TextView) view.findViewById(R.id.textView2);
            viewholder.img=(ImageView) view.findViewById(R.id.imageView);
            view.setTag(viewholder);
        }
        else{
            viewholder=(ViewHolder)view.getTag();
        }
        viewholder.tv1.setText(titles[position]);
        viewholder.tv2.setText(desc[position]);
        viewholder.img.setImageResource(imgid.getResourceId(position,0));

        return view;
    }

}
