package com.example.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;

public class Helper {
   //


   public static boolean isConnected(Context context) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
// check the network connect or not

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
// Reports the type of network to which the info in this NetworkInfo pertains.
        if(networkInfo!=null){
            if(networkInfo.isConnected())
                return true;
            else
                return false;
        }
        else
            return false;

    }
}
