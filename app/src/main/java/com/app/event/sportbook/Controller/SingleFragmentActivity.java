package com.app.event.sportbook.Controller;

import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.app.event.sportbook.R;

/**
 */
public abstract class SingleFragmentActivity extends BaseNavBarActivity {

    /*for Other classes to say which fragment to use*/
    protected abstract Fragment createFragment();

    /*use for logging*/
    private static final String TAG = SingleFragmentActivity.class.getSimpleName();

    @Override
    public void onCreate (Bundle savedInstanceState) {
        Log.i(TAG, "onCreate()::SingleFragmentActivity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        /*when an activity is destroyed--> fm saves out its list of fragments*/
        FragmentManager fm = getSupportFragmentManager();

        /*on create could have been re-created*/
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);

        /*first time the fragments is being created*/
        if(fragment == null){
            fragment = createFragment();
            /**where should the fragments view appear in activity*/
            fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
        } //end if


    }//end onCreate
} //end SingleFragmentActivity
