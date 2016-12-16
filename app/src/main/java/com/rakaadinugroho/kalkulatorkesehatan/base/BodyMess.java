package com.rakaadinugroho.kalkulatorkesehatan.base;

import com.rakaadinugroho.kalkulatorkesehatan.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raka Adi Nugroho on 12/14/16.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 * @Reference https://www.masbroo.com/cara-menghitung-berat-badan-idea.html
 */

public class BodyMess extends HealthCalc implements Suggest {
    List<String> responses;
    boolean gender;
    int emoticon;

    int[] emoticons;
    public BodyMess(){
        super();
        responses   = new ArrayList<>();
        responses.add("Baiknya Anda mulai memberi berat tubuh serta konsumsi makanan berkarbohidrat diimbangi olahraga, karena Anda Kurusan");
        responses.add("Normal, berat badan Anda termasuk ideal. Terus jaga jangan lupa berolahraga");
        responses.add("Wah, gemukan nih. Mulai sekarang jauhi makan berlemak deh");
        responses.add("Program penurunan berat badan mulai dari sekarang, Anda kategori obesitas");
        emoticons   = new int[]{
                R.drawable.frown,
                R.drawable.meh,
                R.drawable.smile
        };
        this.gender = true;
        emoticon    = emoticons[2];
    }
    public BodyMess(double height, double weight){
        super(height, weight);
    }
    @Override
    public String recomendation() {
        String returnval=null;
        if (gender){    /* Body Mess Index for Male */
            if (getBmi()<17) {
                returnval   = responses.get(0);
                emoticon    = emoticons[0];
            }
            else if (getBmi()<=23){
                returnval   = responses.get(1);
                emoticon    = emoticons[2];
            }
            else if (getBmi()<=27) {
                returnval = responses.get(2);
                emoticon    = emoticons[1];
            }
            else if (getBmi()>27) {
                returnval = responses.get(3);
                emoticon    = emoticons[0];
            }
        }else{          /* Body Mess Index for Female*/
            if (getBmi()<17) {
                returnval = responses.get(0);
                emoticon    = emoticons[0];
            }
            else if (getBmi()<=23) {
                returnval = responses.get(1);
                emoticon    = emoticons[2];
            }
            else if (getBmi()<=27) {
                returnval = responses.get(2);
                emoticon    = emoticons[1];
            }
            else if (getBmi()>27) {
                returnval = responses.get(3);
                emoticon    = emoticons[0];
            }
        }
        return returnval;
    }

    @Override
    public int emoticon() {
        return emoticon;
    }

    public void setBmi(double height, double weight, boolean gender){
        super.setHeight(height);
        super.setWeight(weight);
        this.gender = gender;
    }
    public double getBmi(){
        double result;
        result  = super.getWeight()/(super.getHeight()*super.getHeight());
        return result;
    }
    public double getIdealWeight(){
        double result;
        if (gender){
            result  = (getHeight()*100-100)-(0.1*(getHeight()*100-100));
        }else{
            result  = (getHeight()*100-100)-(0.15*(getHeight()*100-100));
        }
        return result;
    }
    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
