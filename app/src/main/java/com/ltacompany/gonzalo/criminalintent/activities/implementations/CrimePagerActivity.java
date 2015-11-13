package com.ltacompany.gonzalo.criminalintent.activities.implementations;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ltacompany.gonzalo.criminalintent.R;
import com.ltacompany.gonzalo.criminalintent.activities.Fragments.CrimeFragment;
import com.ltacompany.gonzalo.criminalintent.model.Crime;
import com.ltacompany.gonzalo.criminalintent.model.CrimeLab;

import java.util.List;
import java.util.UUID;

/**
 * Created by g0ng0n on 11/12/15.
 */
public class CrimePagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private List<Crime> mCrimes;


    private static final String EXTRA_CRIME_ID="com.ltacompany.gonzalo.criminalintent.crime_id";


    public static Intent newIntent(Context packageContext, UUID crimeId){

        Intent intent = new Intent(packageContext, CrimePagerActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_pager);

        final UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);

        mViewPager = (ViewPager) findViewById(R.id.activity_crime_pager_view_pager);

        mCrimes = CrimeLab.get(this).getmCrimes();

        FragmentManager fragmentManager= getSupportFragmentManager();
                mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {

            @Override
            public Fragment getItem(int position) {
                Crime crime=mCrimes.get(position);
                return CrimeFragment.newInstance(crime.getmId());
            }

            @Override
            public int getCount() {
                return mCrimes.size();
            }


        });
        for (int i = 0;i<mCrimes.size() ; i++){
            if (mCrimes.get(i).getmId().equals(crimeId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
