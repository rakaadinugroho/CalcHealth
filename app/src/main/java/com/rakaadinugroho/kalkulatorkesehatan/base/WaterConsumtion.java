package com.rakaadinugroho.kalkulatorkesehatan.base;

import com.rakaadinugroho.kalkulatorkesehatan.R;

/**
 * Created by Raka Adi Nugroho on 12/16/16.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

public class WaterConsumtion extends HealthCalculator implements Suggest {
    private int need;
    private int age;


    public WaterConsumtion(){
        super();
        need    = 0;
        this.age    = age;
    }
    public WaterConsumtion(double weight, int age){
        super.setWeight(weight);
        need    = 0;
        this.age    = age;
    }
    @Override
    public String recomendation() {
        int result;
        result  = this.need/220; /* 1 Cup Equals 220Ml, to Get perCup */
        return "Kebutuhan minum harianmu sekitar "+result+ " gelas";
    }

    @Override
    public int emoticon() {
        return R.drawable.glass;
    }
    public void setConsume(double weight, int age){
        super.setWeight(weight);
        this.age    = age;
    }
    public int getNeed() {
        return need;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void consumeNeed(){
        this.need   = (int) (consumePerKg()*getWeight());
    }
    public int consumePerKg(){
        int consumeperkg = 0;
        if (age<25)
            consumeperkg    = 30;
        else if (age<55)
            consumeperkg    = 35;
        else if (age<65)
            consumeperkg    = 30;
        else if (age>=65)
            consumeperkg    = 25;
        return consumeperkg;
    }
}
