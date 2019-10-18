package com.example.activeworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Cursor cursor;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume()
    {
        super.onResume();
        DBHelper helper=new DBHelper(this);

        db=helper.getReadableDatabase();

        String [] findCols={DBHelper.KEY_ROWID,DBHelper.KEY_TITLE};

        cursor=db.query(DBHelper.TABLE_NAME,findCols,null,null,null,null,null,null);
        ListView listView=findViewById(R.id.mainlist);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==0)
                {
                    if(cursor.moveToFirst()) {
                        Intent intent = new Intent(getApplicationContext(), WorkoutLists.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Please Add Workout First",Toast.LENGTH_SHORT).show();
                    }

                }
                else if(position==1)
                {
                    Intent intent=new Intent(getApplicationContext(),AddWorkouts.class);
                    startActivity(intent);
                }


            }
        });
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        cursor.close();
        db.close();
    }
}
