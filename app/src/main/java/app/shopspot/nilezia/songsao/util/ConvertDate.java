package app.shopspot.nilezia.songsao.util;

import android.content.Context;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import app.shopspot.nilezia.songsao.controller.Contextor;

public class ConvertDate {

    private static ConvertDate instance;

    public static ConvertDate getInstance() {
        if (instance == null)
            instance = new ConvertDate();
        return instance;
    }

    private Context mContext;

    private ConvertDate() {
        mContext = Contextor.getInstance().getContext();
    }

    public String ConvertDate(Date oldDate) {

        //SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        SimpleDateFormat postFormater = new SimpleDateFormat("dd MMMM yyyy", Locale.US);
        String newDateStr = postFormater.format(oldDate);

        return newDateStr;
    }

}