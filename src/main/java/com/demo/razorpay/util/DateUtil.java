package com.demo.razorpay.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static final String getDate(long time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        return simpleDateFormat.format(new Date(time));
    }
}

