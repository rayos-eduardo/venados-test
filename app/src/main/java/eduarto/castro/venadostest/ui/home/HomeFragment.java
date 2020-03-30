package eduarto.castro.venadostest.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

import eduarto.castro.venadostest.Model.Game.Game;
import eduarto.castro.venadostest.R;
import eduarto.castro.venadostest.adapter.LeaguesTabAdapter;

public class HomeFragment extends Fragment implements GamesView {

    private LeaguesTabAdapter leaguesTabAdapter;
    private GamesPresenter gamesPresenter;
    private ViewPager2 pager;
    private TabLayout tabLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        pager = view.findViewById(R.id.view_pager);
        tabLayout = view.findViewById(R.id.home_tabs);

        gamesPresenter = new GamesPresenter(this);
        gamesPresenter.getData();

        return view;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onGetResult(List<Game> games) {
        leaguesTabAdapter = new LeaguesTabAdapter(this, games);
        leaguesTabAdapter.notifyDataSetChanged();
        pager.setAdapter(leaguesTabAdapter);

        new TabLayoutMediator(tabLayout, pager, (tab, position) -> {
            switch (position){
                case 0:
                    tab.setText("COPA MX");
                    break;
                case 1:
                    tab.setText("ASCENSO MX");
                    break;
            }
        }).attach();

    }

    @Override
    public void onErrorLoading(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
