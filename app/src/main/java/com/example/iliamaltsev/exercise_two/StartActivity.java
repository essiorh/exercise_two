package com.example.iliamaltsev.exercise_two;

import android.content.Intent;
import android.app.Fragment;
import android.os.Bundle;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;



public class StartActivity extends AppCompatActivity implements View.OnClickListener{
    public static final int CHOOSE_THIEF = 0;
    TextView histori;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Button buttonStart=(Button)findViewById(R.id.button_one);
        buttonStart.setOnClickListener(this);
        histori=(TextView)findViewById(R.id.histori);
        //FrameLayout fragmentFrame = (FrameLayout) findViewById(R.id.one);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_one:
                //This code for animation
                //SplitAnimation.startActivity(MainActivity.this, new Intent(MainActivity.this, SecondActivity.class));
                startActivityForResult(new Intent(StartActivity.this, SecondActivity.class), CHOOSE_THIEF);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode!=RESULT_OK) {
            return;
        } else{
            Bundle bundle=data.getBundleExtra("mas");

            ArrayList<Operation> showListOperation= (ArrayList<Operation>) bundle.getSerializable("mas");
            String sHistori=getString(R.string.number)+"| "+getString(R.string.first_fragment)+" | "+getString(R.string.second_fragment)+'\n';
            for(int i=0;i<showListOperation.size();i++) {
                int first = showListOperation.get(i).getFirstFragment();
                int second = showListOperation.get(i).getSecondFiagment();
                if (Integer.toString(i).length() > 1)
                    sHistori = sHistori + Integer.toString(i) + "| " + Integer.toString(first) + " | " + Integer.toString(second) + '\n';
                else
                    sHistori = sHistori + Integer.toString(i) + "  | " + Integer.toString(first) + " | " + Integer.toString(second) + '\n';

            }
            histori.setText(sHistori);
        }
    }
}
