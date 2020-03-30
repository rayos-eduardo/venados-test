package eduarto.castro.venadostest.network;

import eduarto.castro.venadostest.Model.Game.GameResponse;
import eduarto.castro.venadostest.Model.Player.PlayersResponse;
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

    @Headers( {"Accept: application/json" })
    @GET("players")
    Call<PlayersResponse> getPlayers();
}
