package encomit.eu.testservices.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by Andrzej Janeczek on 2015-09-22.
 */
public class MyOwnServices  extends Service{

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    // Odpowiedzialne za polącznie z Activity
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
