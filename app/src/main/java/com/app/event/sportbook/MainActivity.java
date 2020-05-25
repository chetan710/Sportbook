package com.app.event.sportbook;

import com.firebase.client.Firebase;

/**
 * Includes one-time initialization of Firebase related code
 * Class specific for Firebase so the
 */
public class MainActivity extends android.app.Application{

    @Override
    public void onCreate() {
        super.onCreate();
        /* Initialize Firebase */
        Firebase.setAndroidContext(this);
        /* Enable disk persistence  */
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
    }

}
