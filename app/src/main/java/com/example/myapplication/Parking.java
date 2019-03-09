package com.example.myapplication;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import java.util.*;


public class Parking extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    Button button6;

    private TextView info;
    private TextView info2;

    int[] x = new int[3];

    int nearpark;

    public void onClick(View v) {
        Toast.makeText(Parking.this,"Parking Reserved:"+nearpark, Toast.LENGTH_SHORT).show();

    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);

        PhotoView photoview = findViewById(R.id.photo_view);
        photoview.setImageResource(R.drawable.parking);

        info = (TextView) findViewById(R.id.textView2);
        info2 = (TextView) findViewById(R.id.textView4);

        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            x[i] = rand.nextInt(40) + 1;
        }


        info.setText("Available Parkings :-" + x[0] + "," + x[1] + "," + x[2]);
        Arrays.sort(x);
        if(x[0]>=1 && x[0]<=4 || x[0]>=11 && x[0]<=18 || x[0]>=27 && x[0]<=34)
        {
          nearpark=x[0];
        }else if (x[1]>=1 && x[1]<=4 || x[1]>=11 && x[1]<=18 || x[1]>=27 && x[1]<=34)
        {
            nearpark=x[1];
        }else if (x[2]>=1 && x[2]<=4 || x[2]>=11 && x[2]<=18 || x[2]>=27 && x[2]<=34)
        {
            nearpark=x[2];
        }else if(x[0]>=5 && x[0]<=10 || x[0]>=19 && x[0]<=26 )
        {
            nearpark=x[0];
        }else if (x[1]>=5 && x[1]<=10 || x[1]>=19 && x[2]<=26)
        {
            nearpark=x[1];
        }else if(x[2]>=5 && x[2]<=10 || x[2]>=19 && x[0]<=26)
        {
            nearpark=x[2];
        }else{

            nearpark=x[0];
        }

        info2.setText("Nearest Parkings : " +nearpark);


        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id= menuItem.getItemId();
        if(id== R.id.home)
        {
            Intent intent = new Intent(Parking.this, Homepage.class);
            startActivity(intent);
        }else if(id==R.id.exit)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to Exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            System.exit(0);
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        } else if(id==R.id.DB){

            Intent intent = new Intent(Parking.this, frag.class);
            startActivity(intent);
        }
        return false;
    }
}
