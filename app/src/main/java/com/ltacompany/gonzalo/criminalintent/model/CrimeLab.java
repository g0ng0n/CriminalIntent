package com.ltacompany.gonzalo.criminalintent.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by g0ng0n on 11/11/15.
 */
public class CrimeLab {
    
    private static CrimeLab sCrimeLab;

    private List<Crime> mCrimes;

    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
        for (int i = 0; i<100; i++){
            Crime crime = new Crime();
            crime.setTitle("Crime #"+i);
            crime.setmSolved(i%2==0);
            mCrimes.add(crime);
        }

    }

    public static CrimeLab get(Context context){
        if (sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        
        return sCrimeLab;
    }

    public List<Crime> getmCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id){
        for (Crime crime : mCrimes){
            if(crime.getmId().equals(id)){
                return crime;
            }
        }
        return null;
    }
}
