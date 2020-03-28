package eduarto.castro.venadostest.ui.leagues;

import android.util.Log;

import java.util.ArrayList;

import eduarto.castro.venadostest.Model.Game.Game;
import eduarto.castro.venadostest.Model.Game.GameResponse;
import eduarto.castro.venadostest.Model.Game.GamesList;
import eduarto.castro.venadostest.network.ApiClient;
import eduarto.castro.venadostest.network.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameListModel implements GameListContract.Model{

    private final String TAG = "GameListModel";
    ArrayList<Game> games = new ArrayList<>();

    @Override
    public void getGameList(final OnFinishedListener onFinishedListener) {
        ApiInterface apiService =
                ApiClient.getApiClient().create(ApiInterface.class);

        Call<GameResponse> call = apiService.getGames();
        call.enqueue(new Callback<GameResponse>() {
            @Override
            public void onResponse(Call<GameResponse> call, Response<GameResponse> response) {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    GamesList statsList = response.body().getGamesData();
                    onFinishedListener.onFinished(statsList.getGames());
                }
                else {
                    Log.e(TAG, String.valueOf(response.errorBody()));
                }
            }

            @Override
            public void onFailure(Call<GameResponse> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }
}
