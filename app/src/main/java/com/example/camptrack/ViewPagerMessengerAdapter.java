package com.example.camptrack;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerMessengerAdapter extends FragmentPagerAdapter {
    public ViewPagerMessengerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position ==0){
            return new CSEFragment();
        } else if (position==1) {
            return new ECEFragment();
        } else if (position==2) {
            return new CivilFragment();
        } else if (position==3) {
            return new MechanicalFragment();
        } else if (position==4) {
            return new ManagementFragment();
        }
        else return new LawFragment();
    }

    @Override
    public int getCount() {
        return 6;
    }
    public CharSequence getPageTitle(int position) {
        if(position ==0){
            return "CSE";
        } else if (position==1) {
            return "ECE";
        }else if (position==2){
            return "CIVIL";
        }else if (position==3){
            return "MECHANICAL";
        }else if (position==4){
            return "MANAGEMENT";
        }
        else  return "LAW";
    }
}
