package com.example.servicecourse;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {
    private Context context;
    private AlertDialog alertDialog;

    @Override
    public void onReceive(Context context, Intent intent) {
        this.context = context;
        try {
            if (isOnline(context)) {
                Toast.makeText(context, "Online", Toast.LENGTH_SHORT).show();
                hideAlertDialog();
            } else {
                Toast.makeText(context, "Offline", Toast.LENGTH_SHORT).show();
                showAlertDialog();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private boolean isOnline(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            //should check null because in airplane mode it will be null
            return (netInfo != null && netInfo.isConnected());
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }


    private void showAlertDialog() {
        alertDialog = new AlertDialog.Builder(context)
                .setTitle("Network Alert")
                .setMessage("Please turn on WiFi")
                .setCancelable(false)
                .create();

        if (!alertDialog.isShowing()) {
            alertDialog.show();
        }

    }

    private void hideAlertDialog() {
        if (alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
    }


}
