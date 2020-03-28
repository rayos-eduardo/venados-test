package eduarto.castro.venadostest.Model.Game;

import com.google.gson.annotations.SerializedName;

public class GameResponse {
    @SerializedName("success")
    private boolean success;
    @SerializedName("data")
    private GamesList gamesData;
    @SerializedName("code")
    private int code;

    public GameResponse(boolean success, GamesList gamesData, int code) {
        this.success = success;
        this.gamesData = gamesData;
        this.code = code;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public GamesList getGamesData() {
        return gamesData;
    }

    public void setGamesData(GamesList gamesData) {
        this.gamesData = gamesData;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
