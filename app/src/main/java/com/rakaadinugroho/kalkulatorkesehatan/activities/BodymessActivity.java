package com.rakaadinugroho.kalkulatorkesehatan.activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.rakaadinugroho.kalkulatorkesehatan.R;
import com.rakaadinugroho.kalkulatorkesehatan.base.BodyMess;

public class BodymessActivity extends AppCompatActivity implements View.OnClickListener {
    BodyMess bmi;

    /* UI Components */
    AppCompatButton bm_result;
    RadioGroup bm_gender;
    RadioButton gender;
    EditText bm_weight;
    EditText bm_height;
    ImageView bm_emoticon;
    TextView bm_ideal;
    TextView bm_suggest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bodymess);
        initViews();
        bmi = new BodyMess();

        /* Result */
        bm_result.setOnClickListener(this);
    }

    private void initViews() {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);
        setTitle("Berat Ideal");
        bm_result   = (AppCompatButton)findViewById(R.id.bm_result);
        bm_gender   = (RadioGroup)findViewById(R.id.bm_gender);
        bm_weight   = (EditText)findViewById(R.id.bm_weight);
        bm_height   = (EditText)findViewById(R.id.bm_height);
        bm_emoticon = (ImageView)findViewById(R.id.bm_emoticon);
        bm_ideal    = (TextView)findViewById(R.id.bm_ideal);
        bm_suggest  = (TextView)findViewById(R.id.bm_suggest);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void calc(){
        /* Validation */
        double height   = Double.parseDouble(bm_height.getText().toString())/100;
        double weight   = Double.parseDouble(bm_weight.getText().toString());
        if (height == 0 || weight == 0)
            return;

        boolean isgender;
        int selected    = bm_gender.getCheckedRadioButtonId();
        gender          = (RadioButton)findViewById(selected);
        if (gender.getText().toString().equals(R.string.gender_male)) {
            isgender    = true;
        }else{
            isgender    = false;
        }
        bmi.setBmi(height, weight, isgender);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bm_result:
                calc();
                Glide.with(this).load(bmi.emoticon()).into(bm_emoticon);
                bm_suggest.setText(bmi.recomendation());
                bm_ideal.setText("Idealnya : "+String.valueOf(bmi.getIdealWeight())+" Kg");
                break;
        }
    }
}
