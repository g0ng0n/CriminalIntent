package com.ltacompany.gonzalo.criminalintent.activities.implementations;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;


import com.ltacompany.gonzalo.criminalintent.R;
import com.ltacompany.gonzalo.criminalintent.activities.Fragments.CrimeFragment;
import com.ltacompany.gonzalo.criminalintent.activities.SingleFragmentActivity;

public class CrimeActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }
}
