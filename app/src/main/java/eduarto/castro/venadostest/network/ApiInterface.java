package eduarto.castro.venadostest.network;

import java.util.List;

import eduarto.castro.venadostest.Model.Game.Game;
import eduarto.castro.venadostest.Model.Game.GameResponse;
import eduarto.castro.venadostest.Model.Stat.StatsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiInterface {

    @Headers( {"Accept: application/json" })
    @GET("games")
    Call<GameResponse> getGames();

    @Headers( {"Accept: application/json" })
    @GET("statistics")
    Call<StatsResponse> getStats();
}
