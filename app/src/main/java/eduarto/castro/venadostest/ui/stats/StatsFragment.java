package eduarto.castro.venadostest.ui.stats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import eduarto.castro.venadostest.Model.Stat.Stats;
import eduarto.castro.venadostest.R;
import eduarto.castro.venadostest.adapter.StatsAdapter;

public class StatsFragment extends Fragment implements StatsView{

    private RecyclerView statsRecyclerView;
    private StatsPresenter presenter;
    private StatsAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stats, container, false);
        statsRecyclerView = view.findViewById(R.id.stats_rv);
        statsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        presenter = new StatsPresenter(this);
        presenter.getData();

        return view;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onGetResult(List<Stats> stats) {
        adapter = new StatsAdapter(getContext(), stats);
        adapter.notifyDataSetChanged();
        statsRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onErrorLoading(String message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
    }
}
