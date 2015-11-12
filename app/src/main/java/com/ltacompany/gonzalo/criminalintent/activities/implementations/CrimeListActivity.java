package com.ltacompany.gonzalo.criminalintent.activities.implementations;

import android.support.v4.app.Fragment;

import com.ltacompany.gonzalo.criminalintent.activities.Fragments.CrimeListFragment;
import com.ltacompany.gonzalo.criminalintent.activities.SingleFragmentActivity;

/**
 * Created by g0ng0n on 11/11/15.
 */
public class CrimeListActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
