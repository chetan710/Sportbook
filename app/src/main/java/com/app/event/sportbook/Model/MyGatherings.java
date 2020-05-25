package com.app.event.sportbook.Model;

import com.app.event.sportbook.Controller.LoginActivity;
import java.util.List;
import java.util.ArrayList;

/**
 */
public class MyGatherings {

    String mListOwner;
    //List<String> mGatherings;
    //String mGatherings;


    public MyGatherings(){
    }

    public MyGatherings(String mListOwner){
        this.mListOwner = mListOwner;
        //this.mGatherings = new ArrayList<String>();
        //this.mGatherings = mGatherings;

        //mGatherings.add("TEST");
        //mGatherings.add("test2");
    }

    public String getmListOwner()
    {
        return mListOwner;
    }

    /*public List getMGathering() {
        return mGatherings;
    }*/

    /*public void addGathering(String sportUID)
    {
        mGatherings.add(sportUID);
    }*/


}
