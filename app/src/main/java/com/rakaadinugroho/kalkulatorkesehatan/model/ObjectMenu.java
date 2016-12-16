package com.rakaadinugroho.kalkulatorkesehatan.model;

/**
 * Created by Raka Adi Nugroho on 12/15/16.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

public class ObjectMenu {
    private int img;
    private String title;

    public ObjectMenu(int img, String title) {
        this.img = img;
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
