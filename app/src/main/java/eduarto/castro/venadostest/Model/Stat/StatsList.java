package eduarto.castro.venadostest.Model.Stat;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import eduarto.castro.venadostest.Model.Game.Game;

public class StatsList {
    @SerializedName("statistics")
    private List<Stats> statsList;

    public StatsList() {}

    public StatsList(List<Stats> statsList) {
        this.statsList = statsList;
    }

    public List<Stats> getStats() {
        return statsList;
    }

    public void setStats(List<Stats> statsList) {
        this.statsList = statsList;
    }
}
