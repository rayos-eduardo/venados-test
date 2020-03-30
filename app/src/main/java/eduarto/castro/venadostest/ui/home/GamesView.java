package eduarto.castro.venadostest.ui.home;

import java.util.List;
import eduarto.castro.venadostest.Model.Game.Game;


public interface GamesView {
    void showLoading();

    void hideLoading();

    void onGetResult(List<Game> games);

    void onErrorLoading(String message);
}
