package eduarto.castro.venadostest.ui.stats;

import androidx.annotation.NonNull;

import java.util.List;

import eduarto.castro.venadostest.Model.Stat.StatsList;
import eduarto.castro.venadostest.Model.Stat.StatsResponse;
import eduarto.castro.venadostest.network.ApiClient;
import eduarto.castro.venadostest.network.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatsPresenter {

    private StatsView statsView;

    public StatsPresenter(StatsView statsView){
        this.statsView = statsView;
    }

    void getData(){
        statsView.showLoading();

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<StatsResponse> call = apiInterface.getStats();
        call.enqueue(new Callback<StatsResponse>() {
            @Override
            public void onResponse(@NonNull Call<StatsResponse> call, @NonNull Response<StatsResponse> response) {
                statsView.hideLoading();
                assert response.body() != null;
                StatsList statsList = response.body().getStatsData();
                statsView.onGetResult(statsList.getStats());
            }

            @Override
            public void onFailure(@NonNull Call<StatsResponse> call, @NonNull Throwable t) {
                statsView.hideLoading();
                statsView.onErrorLoading(t.getLocalizedMessage());
            }
        });

    }
}
