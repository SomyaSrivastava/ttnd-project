package com.ttnd.Entity;

/**
 * Created by Lenovo-1 on 19-07-2017.
 */
public enum Seriousness {
    SERIOUS("serious"),VERY_SERIOUS("verySerious"),CASUAL("casual");

    String seriousness;
    Seriousness(String seriousness) {
        this.seriousness=seriousness;
    }

}
