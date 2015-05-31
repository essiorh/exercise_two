package com.example.iliamaltsev.exercise_two;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity implements View.OnClickListener{
    public static final int CHOOSE_THIEF = 0;
    TextView history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Button buttonStart=(Button)findViewById(R.id.button_one);
        buttonStart.setText(getString(R.string.gogogo));
        buttonStart.setOnClickListener(this);
        history =(TextView)findViewById(R.id.history);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_one:
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
                String first = showListOperation.get(i).getFirstFragment();
                String second = showListOperation.get(i).getSecondFiagment();
                if (Integer.toString(i+1).length() > 1)
                    sHistori = sHistori + Integer.toString(i+1) + "| " + first + " | " + second + '\n';
                else
                    sHistori = sHistori + Integer.toString(i+1) + "  | " + first + " | " + second + '\n';
            }
            history.setText(sHistori);
        }
    }
}
