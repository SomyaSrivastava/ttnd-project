package com.ttnd.Entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

public enum Visibility {

    PUBLIC("public"),PRIVATE("private");
    public String s;

    Visibility() {
    }

    Visibility(String s) {
        this.s = s;
    }

    public String getVisiblity(){
        return s;
    }
}
