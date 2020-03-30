package eduarto.castro.venadostest.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

import eduarto.castro.venadostest.Model.Game.Game;
import eduarto.castro.venadostest.ui.home.GamesFragment;

public class LeaguesTabAdapter extends FragmentStateAdapter {

    private List<Game> games;

    public LeaguesTabAdapter(@NonNull Fragment fragment, List<Game> games) {
        super(fragment);
        this.games = games;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new GamesFragment(games);
    }

    @Override
    public int getItemCount() {
        return 2;
    }


}

