package com.example.cardcs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter <CardAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<LanguageClass> data;
   /*public CardAdapter(@NonNull Context context) {
        super(context);
    }*/

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView image;

        public MyViewHolder(View itemView){
            super(itemView);

            this.textView=(TextView)itemView.findViewById(R.id.textView);
            this.image=(ImageView)itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {

                }
            });

        }

    }

    CardAdapter(Context context,ArrayList<LanguageClass> dataSet)
    {
        this.data=dataSet;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TextView title=holder.textView;
        ImageView image=holder.image;

        title.setText(data.get(position).getName());
        image.setImageResource(data.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}
