package com.example.activeworkout;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Workouts extends AppCompatActivity {

    public static final String EXTRA_ID="id";

    private static final String TAG ="Workouts";

    private SQLiteDatabase db;

    private Cursor cursor;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workouts);

        final int workoutID=(Integer)getIntent().getExtras().get(EXTRA_ID);
        final DBHelper helper=new DBHelper(this);
        try{


            db=helper.getReadableDatabase();

            String [] tableCols={DBHelper.KEY_ROWID,DBHelper.KEY_TITLE,DBHelper.KEY_SETS,DBHelper.KEY_REPS,DBHelper.KEY_DESC};

            String wherClause=DBHelper.KEY_ROWID+" = ?";
            String [] whereArgs={Integer.toString(workoutID)};

            cursor=db.query(DBHelper.TABLE_NAME, tableCols , wherClause ,whereArgs,null,null,null,null);
            cursor.moveToFirst();

            String t=cursor.getString(1);
            String s=cursor.getString(2);
            String r=cursor.getString(3);
            String d=cursor.getString(4);

            TextView txt1=findViewById(R.id.title);
            TextView txt2=findViewById(R.id.set);
            TextView txt3=findViewById(R.id.reps);
            TextView txt4=findViewById(R.id.desc);

            txt1.setText(t);
            txt2.setText(s);
            txt3.setText(r);
            txt4.setText(d);

            cursor.close();
            db.close();




        } catch (SQLiteException e) {
            e.printStackTrace();
        }

        Button b1=findViewById(R.id.delete);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.deleteWrkout(workoutID);
                finish();
            }
        });

    }
}
