package com.example.activeworkout;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class WorkoutLists extends ListActivity {

    private static final String TAG="WorkoutLists";
    private SimpleCursorAdapter cursorAdapter;
    private ListView listView;
    private Cursor cursor;
    private SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listView=getListView();
        int layout=android.R.layout.simple_list_item_1;
        String [] findCols={DBHelper.KEY_ROWID,DBHelper.KEY_TITLE};

        String [] displayCols={DBHelper.KEY_TITLE};

        int [] to={android.R.id.text1};

        cursor=null;
        cursorAdapter=new SimpleCursorAdapter(this,layout,cursor,displayCols,to,0);

        listView.setAdapter(cursorAdapter);


    }
    @Override
    protected void onResume(){
        super.onResume();
        cursor=updateCursor();
        cursorAdapter.changeCursor(cursor);
        if(! cursor.moveToFirst()){
            finish();
        }
    }

    private Cursor updateCursor() {
        cursor=null;

        try{
            DBHelper helper=new DBHelper(this);
            db=helper.getReadableDatabase();
            String [] findCols={DBHelper.KEY_ROWID,DBHelper.KEY_TITLE};

            cursor=db.query(DBHelper.TABLE_NAME,findCols,null,null,null,null,null,null);


        } catch (SQLiteException e) {
            Log.e(TAG,"something went wrong");
            e.printStackTrace();
        }

        return cursor;
    }


    @Override
    public void onListItemClick(ListView listView, View view,int position,long id)
    {
        Intent intent=new Intent(this,Workouts.class);

        intent.putExtra(Workouts.EXTRA_ID,(int) id);
        startActivity(intent);
        //finish();
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        cursor.close();
        db.close();
    }

}
