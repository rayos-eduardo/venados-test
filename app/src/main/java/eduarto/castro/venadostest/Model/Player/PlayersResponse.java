package eduarto.castro.venadostest.Model.Player;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PlayersResponse implements Serializable {
    @SerializedName("sucess")
    private boolean success;
    @SerializedName("data")
    private Teams teams;
    @SerializedName("code")
    private int code;

    public PlayersResponse(boolean success, Teams teams, int code) {
        this.success = success;
        this.teams = teams;
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Teams getTeams() {
        return teams;
    }

    public void setTeams(Teams teams) {
        this.teams = teams;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
