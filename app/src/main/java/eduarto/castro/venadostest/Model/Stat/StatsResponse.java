package eduarto.castro.venadostest.Model.Stat;

import com.google.gson.annotations.SerializedName;

import eduarto.castro.venadostest.Model.Game.GamesList;

public class StatsResponse {
    @SerializedName("success")
    private boolean success;
    @SerializedName("data")
    private StatsList statsData;
    @SerializedName("code")
    private int code;

    public StatsResponse(boolean success, StatsList statsData, int code) {
        this.success = success;
        this.statsData = statsData;
        this.code = code;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public StatsList getStatsData() {
        return statsData;
    }

    public void setStatsData(StatsList statsData) {
        this.statsData = statsData;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
