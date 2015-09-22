package encomit.eu.testservices.services;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Andrzej Janeczek on 2015-09-22.
 */
public class MyOwnServices extends Service {

    @Override
    public void onCreate() {
        super.onCreate();

        Toast.makeText(MyOwnServices.this, "Start service.onCreate", Toast.LENGTH_SHORT).show();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(MyOwnServices.this, "Start service.onStartCommand", Toast.LENGTH_SHORT).show();


        // Uruchomienie taska
        new ServicesTask().execute();

        // Service zakończy się po jawnym wyłączeniu - asynctasku stopSelf();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(getApplicationContext(), "OnDestroy Service ", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    // Odpowiedzialne za polącznie z Activity
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



    // AsyncTask ..
    private class ServicesTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                Log.e(getClass().getName(), "Zablokowany watek");

            }
            return null;
        }


        @Override
        protected void onPreExecute() {
            Toast.makeText(getApplicationContext(), "Zakończyłem działanie taska", Toast.LENGTH_SHORT).show();
            // zakończenie działania services
            stopSelf();
        }
    }


}
