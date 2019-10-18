package com.example.cardcs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    public  static String [] titles;
    public static TypedArray images;

    public static ArrayList<LanguageClass> languageClassArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerView);

        titles=getResources().getStringArray(R.array.languages);
        images=getResources().obtainTypedArray(R.array.langImg);

        languageClassArrayList =new ArrayList<>();
        if(savedInstanceState==null) {
            for (int i = 0; i < titles.length; i++) {
                languageClassArrayList.add(new LanguageClass(titles[i], images.getResourceId(i, 0)));
            }
        }
        else
        {
            languageClassArrayList=savedInstanceState.getParcelableArrayList("list");
        }

        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(this,span());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);

        final RecyclerView.Adapter adapter=new CardAdapter(this,languageClassArrayList);

        ItemTouchHelper.Callback callback=new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                return makeFlag(ItemTouchHelper.ACTION_STATE_DRAG, ItemTouchHelper.DOWN | ItemTouchHelper.UP | ItemTouchHelper.START | ItemTouchHelper.END);
            }

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {

                int from=viewHolder.getAdapterPosition();
                int to=target.getAdapterPosition();

                if(from<to)
                {
                    for(int i=from;i<to;i++)
                    {
                        Collections.swap(languageClassArrayList,i,i+1);
                    }
                }
                else
                {
                    for(int i=from;i>to;i--)
                    {
                        Collections.swap(languageClassArrayList,i,i-1);
                    }
                }

                adapter.notifyItemMoved(from,to);

                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            }
        };

        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        FloatingActionButton fab=(FloatingActionButton)findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Input Action",Toast.LENGTH_SHORT).show();

            }
        });


        recyclerView.setAdapter(adapter);

    }
    private int span(){

        int screenWidth= Resources.getSystem().getDisplayMetrics().widthPixels;
        float cardWidth=getResources().getDimension(R.dimen.cardview);

        return (int) Math.floor(screenWidth/cardWidth);

    }

    @Override
    public void onSaveInstanceState(Bundle savedState)
    {
        super.onSaveInstanceState(savedState);
        savedState.putParcelableArrayList("list",languageClassArrayList);
    }
}
