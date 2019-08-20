package com.joaomedeiros.workshopmongo;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class Defaults {

    public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy/mm/dd");

    static {
        SDF.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

}
