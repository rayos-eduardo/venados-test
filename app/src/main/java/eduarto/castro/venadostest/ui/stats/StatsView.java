package eduarto.castro.venadostest.ui.stats;

import java.util.List;

import eduarto.castro.venadostest.Model.Stat.Stats;

public interface StatsView {
    void showLoading();
    void hideLoading();
    void onGetResult(List<Stats> stats);
    void onErrorLoading(String message);
}
