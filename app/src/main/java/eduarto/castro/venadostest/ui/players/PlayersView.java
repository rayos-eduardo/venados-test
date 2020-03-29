package eduarto.castro.venadostest.ui.players;

import java.util.ArrayList;
import java.util.List;

import eduarto.castro.venadostest.Model.Player.Player;
import eduarto.castro.venadostest.Model.Stat.Stats;

public interface PlayersView {
    void showLoading();

    void hideLoading();

    void onGetResult(ArrayList<Player> players);

    void onErrorLoading(String message);
}
