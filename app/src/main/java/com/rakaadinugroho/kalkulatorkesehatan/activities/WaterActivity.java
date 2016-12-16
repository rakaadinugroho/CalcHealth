package com.rakaadinugroho.kalkulatorkesehatan.activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.rakaadinugroho.kalkulatorkesehatan.R;
import com.rakaadinugroho.kalkulatorkesehatan.base.WaterConsumtion;

public class WaterActivity extends AppCompatActivity implements View.OnClickListener {
    WaterConsumtion waterConsumtion;

    /* Component */
    EditText water_age;
    EditText water_weight;
    AppCompatButton water_result;
    TextView water_ideal;
    TextView water_suggest;
    ImageView water_emoticon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);
        initViews();
        waterConsumtion = new WaterConsumtion();

        water_result.setOnClickListener(this);
    }

    private void initViews() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);
        setTitle("Cek Kebutuhan Minum");

        water_age   = (EditText)findViewById(R.id.water_age);
        water_weight    = (EditText)findViewById(R.id.water_weight);
        water_result    = (AppCompatButton)findViewById(R.id.water_result);
        water_ideal = (TextView)findViewById(R.id.water_ideal);
        water_emoticon  = (ImageView)findViewById(R.id.water_emoticon);
        water_suggest   = (TextView)findViewById(R.id.water_suggest);
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
    private void calc(){
        double weight  = Double.parseDouble(water_weight.getText().toString());
        int age = Integer.parseInt(water_age.getText().toString());
        if (weight == 0 || age == 0){
            Toast.makeText(this, "Masukan Data Dengan Benar", Toast.LENGTH_SHORT).show();
            return;
        }
        waterConsumtion.setConsume(weight, age);
        waterConsumtion.consumeNeed();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.water_result:
                calc();
                Glide.with(this).load(waterConsumtion.emoticon()).into(water_emoticon);
                water_suggest.setText(waterConsumtion.recomendation());
                water_ideal.setText("Idealnya : "+String.valueOf(waterConsumtion.getNeed())+" ml");
                break;
        }
    }
}
