package eduarto.castro.venadostest.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

import eduarto.castro.venadostest.Model.Game.Game;
import eduarto.castro.venadostest.R;
import eduarto.castro.venadostest.adapter.GamesRecyclerAdapter;
import eduarto.castro.venadostest.adapter.LeaguesTabAdapter;

public class GamesFragment extends Fragment implements GamesView{

    private RecyclerView gameRecyclerView;
    private GamesRecyclerAdapter gamesRecyclerAdapter;
    private SwipeRefreshLayout swipeRefresh;
    private GamesPresenter gamesPresenter;

    private List<Game> gameList;
    private int league;

    public GamesFragment(List<Game> gameList, int league) {
        this.gameList = gameList;
        this.league = league;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_league, container, false);

        swipeRefresh = view.findViewById(R.id.league_sr);
        gameRecyclerView = view.findViewById(R.id.league_rv);
        gameRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        gamesPresenter = new GamesPresenter(this);
        gamesPresenter.getData();

        swipeRefresh.setOnRefreshListener(
                () -> gamesPresenter.getData()
        );

        return view;
    }

    @Override
    public void showLoading() {
        swipeRefresh.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        swipeRefresh.setRefreshing(false);
    }

    @Override
    public void onGetResult(List<Game> games) {

        List<Game> tabGames = new ArrayList<>();
        tabGames.clear();

        switch (league){
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

        gamesRecyclerAdapter = new GamesRecyclerAdapter(getContext(), tabGames, getActivity());
        gamesRecyclerAdapter.notifyDataSetChanged();
        gameRecyclerView.setAdapter(gamesRecyclerAdapter);
    }

    @Override
    public void onErrorLoading(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}