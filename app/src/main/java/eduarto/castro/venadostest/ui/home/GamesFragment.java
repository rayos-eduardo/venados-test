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

import java.util.List;

import eduarto.castro.venadostest.Model.Game.Game;
import eduarto.castro.venadostest.R;
import eduarto.castro.venadostest.adapter.GamesRecyclerAdapter;

public class GamesFragment extends Fragment {

    private RecyclerView gameRecyclerView;
    private SwipeRefreshLayout gameSwipeRefresh;
    private GamesRecyclerAdapter gamesRecyclerAdapter;

    List<Game> gameList;

    public GamesFragment(List<Game> gameList) {
        this.gameList = gameList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_league, container, false);

        gameSwipeRefresh = view.findViewById(R.id.league_sr);
        gameRecyclerView = view.findViewById(R.id.league_rv);
        gameRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        gamesRecyclerAdapter = new GamesRecyclerAdapter(getContext(), gameList);
        gamesRecyclerAdapter.notifyDataSetChanged();
        gameRecyclerView.setAdapter(gamesRecyclerAdapter);

        return view;
    }
}