package br.com.victorlsn.questions5_7.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by victorlsn on 28/08/18.
 */

public class EmailServiceAutoStart extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent myService = new Intent(context,  EmailService.class);
        context.startService(myService);

    }
}
