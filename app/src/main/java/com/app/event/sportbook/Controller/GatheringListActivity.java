package com.app.event.sportbook.Controller;

import android.util.Log;

import androidx.fragment.app.Fragment;

/**
 * This Class extends SingleFragmentActivity which is a singleton class
 * before the CreateFragment() is called the onCreate method
 * in SingleFragmentActivity is invoked and the fragment manager is
 * initialized to start our fragment activity
 * this class creates a new SportsListFragment which is our
 * listView for all the sports
 */
public class GatheringListActivity extends SingleFragmentActivity {

    /*use for logging*/
    private static final String TAG = GatheringListActivity.class.getSimpleName();


    @Override
    protected Fragment createFragment() {
        Log.d(TAG, "createFragmnt()");
        return new GatheringListFragment();
    }//end CreateFragment

} //end GatheringListActivity
