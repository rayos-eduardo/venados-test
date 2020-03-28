package eduarto.castro.venadostest.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import eduarto.castro.venadostest.ui.leagues.LeaguesObjectFragment;

public class LeaguesTabAdapter extends FragmentStateAdapter {

    public LeaguesTabAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = new LeaguesObjectFragment();
        Bundle args = new Bundle();
        args.putInt(LeaguesObjectFragment.ARG_OBJECT, position + 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

