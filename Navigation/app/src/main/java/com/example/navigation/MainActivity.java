package com.example.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;



import com.google.android.material.navigation.NavigationView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private String[] titles;
    private ListView drawerList;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    ActionBar actionBar;
    private int currentPosition=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);
        actionBar=getSupportActionBar();

        if(actionBar!=null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);

        }

        titles=getResources().getStringArray(R.array.titles);
        //NavigationView navigationView = findViewById(R.id.nav_view);

        drawerList=findViewById(R.id.drawer);

        ArrayAdapter<String> adapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, titles);

        drawerList.setAdapter(adapter);

        drawerLayout =(DrawerLayout) findViewById(R.id.drawerlayout);
        drawerList.setOnItemClickListener(new DrawerItemClickListener());

        if(savedInstanceState!=null)
        {
            currentPosition=savedInstanceState.getInt("position");
            setActionBarTitle(currentPosition);
        }
        else
        {
            selectItem(0);
        }

        drawerToggle =new ActionBarDrawerToggle(this,drawerLayout,R.string.open_drawer,R.string.close_drawer)
        {
            public void onDrawerClosed(View view)
            {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();


            }
            public void onDrawerOpened(View view)
            {
                super.onDrawerOpened(view);
                invalidateOptionsMenu();


            }
        };

        drawerLayout.addDrawerListener(drawerToggle);

        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                FragmentManager fragmentManager=getSupportFragmentManager();
                Fragment fragment=fragmentManager.findFragmentByTag("visible_fragment");

                if(fragment instanceof TopLevelFragment)
                {
                    currentPosition=0;
                }
                if(fragment instanceof PageOneFragment)
                {
                    currentPosition=1;
                }
                if(fragment instanceof PageTwoFragment)
                {
                    currentPosition=2;
                }
                if(fragment instanceof PageThreeFragment)
                {
                    currentPosition=3;
                }

                setActionBarTitle(currentPosition);
                drawerList.setItemChecked(currentPosition,true);

            }
        });


    }
    private class DrawerItemClickListener implements ListView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> adapterView,View view,int i,long l)
        {
            selectItem(i);
        }
    }

    private void selectItem(int position)
    {
        currentPosition=position;

        Fragment fragment;
        switch(position)
        {
            case 1: fragment=new PageOneFragment();
                break;
            case 2:fragment=new PageTwoFragment();
                break;
            case 3:  fragment=new PageThreeFragment();
                break;
            default: fragment=new TopLevelFragment();

        }

        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_content,fragment,"visible_fragment");
        ft.addToBackStack(null);
        ft.commit();
        setActionBarTitle(position);
        //drawerLayout.oncloseDrawer(drawerList);
        //drawerLayout.closeDrawer(drawerList,true);
        //drawerToggle.onDrawerClosed(drawerList);


    }


    private void setActionBarTitle(int position)
    {
        String title;
        if(position==0)
        {
            title=getResources().getString(R.string.app_name);
        }
        else
        {
            title=titles[position];
        }

        Objects.requireNonNull(getSupportActionBar()).setTitle(title);

        //drawerLayout.closeDrawer(drawerList);
        //drawerLayout.closeDrawer(drawerList,true);

    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle state)
    {
        super.onSaveInstanceState(state);
        state.putInt("position",currentPosition);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration config)
    {
        super.onConfigurationChanged(config);
        drawerToggle.onConfigurationChanged(config);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(drawerToggle.onOptionsItemSelected(item))
        {
            return false;
        }
        switch (item.getItemId())
        {
            case R.id.settings:
                Toast.makeText(this,"u clicked settings",Toast.LENGTH_LONG).show();
                //do something
                return true;
            case R.id.example:
                Toast.makeText(this,"u clicked examples",Toast.LENGTH_LONG).show();
                //do something
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
