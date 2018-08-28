package br.com.victorlsn.questions5_7.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.com.victorlsn.questions5_7.Node;
import br.com.victorlsn.questions5_7.Questions;

/**
 * Created by victorlsn on 28/08/18.
 */

public class EmailService extends Service {

    private Messenger messenger;
    private ExecutorService executor;
    private IncomingHandler handler;

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Email processing service started", Toast.LENGTH_SHORT);
        executor = Executors.newSingleThreadExecutor();
        handler = new IncomingHandler();
        messenger = new Messenger(handler);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            Message message = handler.obtainMessage();
            handler.handleMessage(message);
        }
        return Service.START_STICKY;

    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Email processing service stopped", Toast.LENGTH_SHORT);
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }

    private void returnEmail(String email) {
        Intent myIntent = new Intent("EMAIL_PROCESSED");
        myIntent.putExtra("result", email);
        sendBroadcast(myIntent);
    }

    @SuppressLint("HandlerLeak")
    class IncomingHandler extends Handler {

        @Override
        public void handleMessage(Message message) {
            if (message.getData() != null) {
                Bundle dataBundle = message.getData();
                String emailJson = dataBundle.getString("email");
                final Node node = new Gson().fromJson(emailJson, Node.class);
                executor.submit(new Runnable() {
                    @Override
                    public void run() {
                        Node updatedNode = Questions.removeDuplicateMessages(node);
                        String updatedEmail = new Gson().toJson(updatedNode, Node.class);
                        returnEmail(updatedEmail);
                    }
                });
            }
        }
    }
}
