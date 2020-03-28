package eduarto.castro.venadostest.ui.leagues;

import android.os.Bundle;
import android.util.Log;
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

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.PreferenceChangeEvent;

import eduarto.castro.venadostest.Model.Game.Game;
import eduarto.castro.venadostest.R;
import eduarto.castro.venadostest.adapter.LeaguesRecyclerAdapter;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class LeaguesObjectFragment extends Fragment implements GameListContract.View, CalendarClickListener {
    public static final String ARG_OBJECT = "object";

    RecyclerView leagueRecyclerView;
    SwipeRefreshLayout leagueSwipeRefresh;

    GameListContract.Presenter presenter;
    LeaguesRecyclerAdapter adapter;
    private ArrayList<Game> gameList;
    CalendarClickListener calendarClickListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_league, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();

        leagueSwipeRefresh = view.findViewById(R.id.league_sr);
        leagueRecyclerView = view.findViewById(R.id.league_rv);
        //adapter = new LeaguesRecyclerAdapter(getContext(), gameList, calendarClickListener);
        leagueRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //leagueRecyclerView.setAdapter(adapter);

        presenter = new GameListPresenter(this);
        presenter.requestDataFromServer();
    }

    @Override
    public void onCalendarClick(View view, int position) {
        Toast.makeText(getContext(),"Cal",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        leagueSwipeRefresh.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        leagueSwipeRefresh.setRefreshing(false);
    }

    @Override
    public void setDataToRecyclerView(ArrayList<Game> gameArrayList) {
        adapter = new LeaguesRecyclerAdapter(getContext(), gameArrayList, calendarClickListener);
        adapter.notifyDataSetChanged();
        leagueRecyclerView.setAdapter(adapter);
    }


    @Override
    public void onResponseFailure(Throwable throwable) {
        Log.e(TAG, throwable.getMessage());
        Toast.makeText(getContext(),String.valueOf(throwable), Toast.LENGTH_LONG).show();
    }

}
