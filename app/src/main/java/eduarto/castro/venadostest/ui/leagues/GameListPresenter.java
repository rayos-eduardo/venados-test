package eduarto.castro.venadostest.ui.leagues;

import java.util.ArrayList;

import eduarto.castro.venadostest.Model.Game.Game;

public class GameListPresenter implements GameListContract.Presenter, GameListContract.Model.OnFinishedListener {

    private GameListContract.View gameListView;
    private GameListContract.Model gameListModel;

    public GameListPresenter(GameListContract.View gameListView) {
        this.gameListView = gameListView;
        gameListModel = new GameListModel();
    }

    @Override
    public void onFinished(ArrayList<Game> gameArrayList) {
        gameListView.setDataToRecyclerView(gameArrayList);
        if (gameListView != null){
            gameListView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        gameListView.onResponseFailure(t);
        if (gameListView != null){
            gameListView.hideProgress();
        }
    }

    @Override
    public void onDestroy() {
        this.gameListView = null;
    }

    @Override
    public void getMoredata() {

    }

    @Override
    public void requestDataFromServer() {

        if (gameListView != null) {
            gameListView.showProgress();
        }
        gameListModel.getGameList(this);
    }
}
