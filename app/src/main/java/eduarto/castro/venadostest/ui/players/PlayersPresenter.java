package eduarto.castro.venadostest.ui.players;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import eduarto.castro.venadostest.Model.Player.Player;
import eduarto.castro.venadostest.Model.Player.PlayersResponse;
import eduarto.castro.venadostest.Model.Player.Teams;
import eduarto.castro.venadostest.network.ApiClient;
import eduarto.castro.venadostest.network.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.util.stream.Collectors.toList;

public class PlayersPresenter {

    private PlayersView playersView;
    private ArrayList<Player> players = new ArrayList<>();

    public PlayersPresenter(PlayersView playersView){
        this.playersView = playersView;
    }

    void getData(){
        playersView.showLoading();

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<PlayersResponse> call = apiInterface.getPlayers();
        call.enqueue(new Callback<PlayersResponse>() {
            @Override
            public void onResponse(@NonNull Call<PlayersResponse> call, @NonNull Response<PlayersResponse> response) {
                playersView.hideLoading();
                if (response.body() != null) {
                    Teams teams = response.body().getTeams();

                    players.addAll(teams.getPositions().getForwards());
                    players.addAll(teams.getPositions().getCenters());
                    players.addAll(teams.getPositions().getDefenses());
                    players.addAll(teams.getPositions().getGoalKeepers());
                    players.addAll(teams.getPositions().getCoaches());

                    playersView.onGetResult(players);
                }
            }

            @Override
            public void onFailure(@NonNull Call<PlayersResponse> call, @NonNull Throwable t) {
                playersView.hideLoading();
                playersView.onErrorLoading(t.getLocalizedMessage());
            }
        });

    }
}
