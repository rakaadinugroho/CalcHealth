package com.rakaadinugroho.kalkulatorkesehatan.base;

/**
 * Created by Raka Adi Nugroho on 12/14/16.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

public class HealthCalc {
    private double height;
    private double weight;

    public HealthCalc(){
        this.height = 0;
        this.weight = 0;
    }
    public HealthCalc(double height, double weight){
        this.height = height;
        this.weight = weight;
    }
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
