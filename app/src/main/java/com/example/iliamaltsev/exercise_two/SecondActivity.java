package com.example.iliamaltsev.exercise_two;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;


public class SecondActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener,
                                                                    ImageFragment.OnSelectedButtonListener {
    private ArrayList<Operation> listOperation = new ArrayList<>();
    private ImageFragment fragmentFirst;
    private Drawable drawableFirst;

    @Override
    public void onButtonSelected(int buttonIndex, Drawable drawableIndex) {
        if (fragmentFirst != null) {
            FragmentManager fragmentManager = getFragmentManager();
            ImageFragment fragmentNext = (ImageFragment) fragmentManager
                    .findFragmentByTag(String.valueOf(buttonIndex));
            if (!fragmentFirst.equals(fragmentNext)) {
                fragmentFirst.setDescription(drawableIndex);
                fragmentNext.setDescription(drawableFirst);
                fragmentFirst.setBorder(false);
                listOperation.add(new Operation(fragmentFirst.getTag(), fragmentNext.getTag()));
                drawableFirst = null;
                fragmentFirst = null;
            }
        } else {
            drawableFirst = drawableIndex;
            FragmentManager fragmentManager = getFragmentManager();
            fragmentFirst = (ImageFragment) fragmentManager
                    .findFragmentByTag(String.valueOf(buttonIndex));
            fragmentFirst.setBorder(true);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button buttonFinish = (Button) findViewById(R.id.button_finish);
        buttonFinish.setText(getString(R.string.finish));
        buttonFinish.setOnClickListener(this);
        Spinner ourSpinner = (Spinner) findViewById(R.id.our_spinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.scale_names, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ourSpinner.setAdapter(arrayAdapter);
        ourSpinner.setOnItemSelectedListener(this);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().setCustomAnimations(R.animator.animator, R.animator.animator_end);
        ;
        fragmentTransaction.add(R.id.one, ImageFragment.newInstance("1", "FIT_XY"), "1");
        fragmentTransaction.add(R.id.two, ImageFragment.newInstance("2", "FIT_XY"), "2");
        fragmentTransaction.add(R.id.three, ImageFragment.newInstance("3", "FIT_XY"), "3");
        fragmentTransaction.add(R.id.four, ImageFragment.newInstance("4", "FIT_XY"), "4");
        fragmentTransaction.add(R.id.five, ImageFragment.newInstance("5", "FIT_XY"), "5");
        fragmentTransaction.add(R.id.six, ImageFragment.newInstance("6", "FIT_XY"), "6");
        fragmentTransaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(this, StartActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Bundle bundle = new Bundle();
                bundle.putSerializable("mas", listOperation);
                homeIntent.putExtra("mas", bundle);
                setResult(RESULT_OK, homeIntent);
                finish();
        }
        return (super.onOptionsItemSelected(menuItem));
    }

    @Override
    public void onBackPressed() {
        Intent homeIntent = new Intent(this, StartActivity.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Bundle bundle = new Bundle();
        bundle.putSerializable("mas", listOperation);
        homeIntent.putExtra("mas", bundle);
        setResult(RESULT_OK, homeIntent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_finish:
                Intent homeIntent = new Intent(this, StartActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Bundle bundle = new Bundle();
                bundle.putSerializable("mas", listOperation);
                homeIntent.putExtra("mas", bundle);
                setResult(RESULT_OK, homeIntent);
                finish();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, getResources().getStringArray(R.array.scale_values));
        String sScaleType = arrayList.get(position).toString();
        FragmentManager fragmentManager = getFragmentManager();
        for (int i = 1; i <= 6; i++) {
            ((ImageFragment) fragmentManager
                    .findFragmentByTag(String.valueOf(i))).setScale(sScaleType);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
