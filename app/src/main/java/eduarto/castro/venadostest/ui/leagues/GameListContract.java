package eduarto.castro.venadostest.ui.leagues;

import java.util.ArrayList;

import eduarto.castro.venadostest.Model.Game.Game;

public interface GameListContract {
    interface Model {

        interface OnFinishedListener {
            void onFinished(ArrayList<Game> gameArrayList);

            void onFailure(Throwable t);
        }

        void getGameList(OnFinishedListener onFinishedListener);

    }

    interface View {

        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(ArrayList<Game> gameArrayList);

        void onResponseFailure(Throwable throwable);

    }

    interface Presenter {

        void onDestroy();

        void getMoredata();

        void requestDataFromServer();

    }
}
