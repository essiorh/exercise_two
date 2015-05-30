package com.example.iliamaltsev.exercise_two;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;


public class SecondActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener,
                                                                    ImageFragment.OnSelectedButtonListener{
    private ArrayList<Operation> listOpetation=new ArrayList<>();
    FrameLayout frameLayoutImage;
    ImageFragment fragmentOne;
    ImageFragment fragmentTwo;
    ImageFragment fragmentThree;
    ImageFragment fragmentFour;
    ImageFragment fragmentFive;
    ImageFragment fragmentSix;
    ImageFragment fragmentFirst;
    @Override
    public void onButtonSelected(int buttonIndex) {

        if (fragmentFirst != null) {
            String tagThis = fragmentFirst.getTag();
            FragmentManager fragmentManager = getFragmentManager();

            // Получаем ссылку на второй фрагмент по ID
            ImageFragment fragmentNext= (ImageFragment) fragmentManager
                    .findFragmentByTag(String.valueOf(buttonIndex));
            fragmentFirst.setDescription(Integer.valueOf(fragmentNext.getTag()));
            fragmentNext.setDescription(Integer.valueOf(fragmentFirst.getTag()));

            fragmentFirst = null;
        } else {
            // подключаем FragmentManager
            FragmentManager fragmentManager = getFragmentManager();

            // Получаем ссылку на второй фрагмент по ID
            fragmentFirst= (ImageFragment) fragmentManager
                    .findFragmentByTag(String.valueOf(buttonIndex));

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button buttonFinish=(Button)findViewById(R.id.button_finish);
        buttonFinish.setOnClickListener(this);
        Spinner ourSpinner=(Spinner)findViewById(R.id.our_spinner);
        ArrayAdapter<CharSequence> arrayAdapter=ArrayAdapter.createFromResource(this, R.array.scale_names, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ourSpinner.setAdapter(arrayAdapter);
        ourSpinner.setOnItemSelectedListener(this);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentOne=ImageFragment.newInstance("1", "FIT_XY");
        fragmentTwo=ImageFragment.newInstance("2", "FIT_XY");
        fragmentThree=ImageFragment.newInstance("3", "FIT_XY");
        fragmentFour=ImageFragment.newInstance("4", "FIT_XY");
        fragmentFive=ImageFragment.newInstance("5", "FIT_XY");
        fragmentSix=ImageFragment.newInstance("6", "FIT_XY");
        fragmentTransaction.add(R.id.one, fragmentOne, "1");
        fragmentTransaction.add(R.id.two, fragmentTwo, "2");
        fragmentTransaction.add(R.id.three, fragmentThree, "3");
        fragmentTransaction.add(R.id.four, fragmentFour, "4");
        fragmentTransaction.add(R.id.five, fragmentFive, "5");
        fragmentTransaction.add(R.id.six, fragmentSix, "6");
        fragmentTransaction.commit();

        /*
        findViewById(R.id.one).setOnClickListener(this);
        findViewById(R.id.two).setOnClickListener(this);
        findViewById(R.id.three).setOnClickListener(this);
        findViewById(R.id.four).setOnClickListener(this);
        findViewById(R.id.five).setOnClickListener(this);
        findViewById(R.id.six).setOnClickListener(this);*/
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(this, StartActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Bundle bundle=new Bundle();
                bundle.putSerializable("mas",listOpetation);
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
        Bundle bundle=new Bundle();
        bundle.putSerializable("mas", listOpetation);
        homeIntent.putExtra("mas", bundle);
        setResult(RESULT_OK, homeIntent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_finish:
                Intent homeIntent = new Intent(this, StartActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Bundle bundle=new Bundle();
                bundle.putSerializable("mas", listOpetation);
                homeIntent.putExtra("mas", bundle);
                setResult(RESULT_OK, homeIntent);
                finish();
                break;
            /*default:
                if (frameLayoutImage==null){
                    frameLayoutImage=(FrameLayout)findViewById(R.id.one);
                }
                else
                replaceImages(v.getId());
                findViewById(v.getId()).setBackgroundColor(getResources().getColor(R.color.primary));
                break;
                */
        }
    }

    private void replaceImages(int secondId) {
        int firstId=frameLayoutImage.getId();
        FragmentTransaction ft = getFragmentManager().beginTransaction().setCustomAnimations(R.animator.animator,R.animator.animator_end);
        ft.replace(firstId, ImageFragment.newInstance("two", "FIT_XY"));
        ft.replace(secondId, ImageFragment.newInstance("one", "FIT_XY"));
        ft.commit();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, getResources().getStringArray(R.array.scale_values));
        String sScaleType = arrayList.get(position).toString();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentOne=ImageFragment.newInstance("1", sScaleType);
        fragmentTwo=ImageFragment.newInstance("2", sScaleType);
        fragmentThree=ImageFragment.newInstance("3", sScaleType);
        fragmentFour=ImageFragment.newInstance("4", sScaleType);
        fragmentFive=ImageFragment.newInstance("5", sScaleType);
        fragmentSix=ImageFragment.newInstance("6", sScaleType);
        fragmentTransaction.add(R.id.one, fragmentOne, "1");
        fragmentTransaction.add(R.id.two, fragmentTwo, "2");
        fragmentTransaction.add(R.id.three, fragmentThree, "3");
        fragmentTransaction.add(R.id.four, fragmentFour, "4");
        fragmentTransaction.add(R.id.five, fragmentFive, "5");
        fragmentTransaction.add(R.id.six, fragmentSix, "6");
        fragmentTransaction.commit();
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
