package com.app.event.sportbook.Model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.UUID;

import com.app.event.sportbook.utils.App;
import com.app.event.sportbook.utils.Constants;

/**
 * dummy class for now to generate the dummy sports
 */
public class SportLab extends Observable{

    /*use for logging*/
    private static final String TAG = SportLab.class.getSimpleName();

    public List<Gathering> getSports() { return App.mGatherings; }

    public Gathering getSport(String ID){
        Log.i(TAG, "getSport()");

        for(Gathering gathering : App.mGatherings) {
            /*crime.getId() == id (only true if they are same object
             * must use equals for different but identical objects */
            Log.i(TAG, gathering.getID() + "    " +ID);
            if (gathering.getID().equals(ID))
                return gathering;
        }//end for


        /*sport not found*/
        return null;
    }//end getSport

    public void loadGatherings() {
        Log.i(TAG, "loadGatherings");
        Firebase gatheringRef = new Firebase("https://gspot.firebaseio.com/Gatherings");
        gatheringRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i(TAG, "onDataChange");
                App.mGatherings.removeAll(App.mGatherings);
                for (DataSnapshot gatheringSnapshot : dataSnapshot.getChildren()) {
                    Gathering gathering = gatheringSnapshot.getValue(Gathering.class);
                    App.mGatherings.add(gathering);
                }
                Log.i(TAG, "end onDataChange");
                /*To notify the observers we have changed*/
                setChanged();
                notifyObservers();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.e(TAG, "FireBaseError " + firebaseError.getMessage());

            }
        });
    }

}
