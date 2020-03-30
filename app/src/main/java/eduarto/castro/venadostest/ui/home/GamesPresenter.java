package eduarto.castro.venadostest.ui.home;

import androidx.annotation.NonNull;

import eduarto.castro.venadostest.Model.Game.GameResponse;
import eduarto.castro.venadostest.Model.Game.GamesList;
import eduarto.castro.venadostest.network.ApiClient;
import eduarto.castro.venadostest.network.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GamesPresenter {

    private GamesView gamesView;

    public GamesPresenter(GamesView gamesView) {
        this.gamesView = gamesView;
    }

    void getData(){
        gamesView.showLoading();

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<GameResponse> call = apiInterface.getGames();
        call.enqueue(new Callback<GameResponse>() {


            @Override
            public void onResponse(@NonNull Call<GameResponse> call, @NonNull Response<GameResponse> response) {
                gamesView.hideLoading();
                assert response.body() != null;
                GamesList gamesList = response.body().getGamesData();
                gamesView.onGetResult(gamesList.getGames());
            }

            @Override
            public void onFailure(@NonNull Call<GameResponse> call, @NonNull Throwable t) {
                gamesView.hideLoading();
                gamesView.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
