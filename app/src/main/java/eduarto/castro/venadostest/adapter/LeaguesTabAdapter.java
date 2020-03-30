package eduarto.castro.venadostest.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
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

        List<Game> tabGames = new ArrayList<>();
        tabGames.clear();

        switch (position){

            case 0:
                for (int i=0; i<games.size(); i++){
                    if (games.get(i).getLeague().equals("Copa MX")){
                        tabGames.add(games.get(i));
                    }
                }
                break;
            case 1:
                for (int i=0; i<games.size(); i++){
                    if (games.get(i).getLeague().equals("Ascenso MX")){
                        tabGames.add(games.get(i));
                    }
                }
                break;
        }

        return new GamesFragment(tabGames);
    }

    @Override
    public int getItemCount() {
        return 2;
    }


}

