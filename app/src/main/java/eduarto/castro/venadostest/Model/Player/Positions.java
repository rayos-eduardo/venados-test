package eduarto.castro.venadostest.Model.Player;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Positions {
    @SerializedName("forwards")
    private ArrayList<Player> forwards;
    @SerializedName("centers")
    private ArrayList<Player> centers;
    @SerializedName("defenses")
    private ArrayList<Player> defenses;
    @SerializedName("goalkeepers")
    private ArrayList<Player> goalKeepers;
    @SerializedName("coaches")
    private ArrayList<Player> coaches;

    public Positions(ArrayList<Player> forwards, ArrayList<Player> centers, ArrayList<Player> defenses, ArrayList<Player> goalKeepers, ArrayList<Player> coaches) {
        this.forwards = forwards;
        this.centers = centers;
        this.defenses = defenses;
        this.goalKeepers = goalKeepers;
        this.coaches = coaches;
    }

    public ArrayList<Player> getForwards() {
        return forwards;
    }

    public void setForwards(ArrayList<Player> forwards) {
        this.forwards = forwards;
    }

    public ArrayList<Player> getCenters() {
        return centers;
    }

    public void setCenters(ArrayList<Player> centers) {
        this.centers = centers;
    }

    public ArrayList<Player> getDefenses() {
        return defenses;
    }

    public void setDefenses(ArrayList<Player> defenses) {
        this.defenses = defenses;
    }

    public ArrayList<Player> getGoalKeepers() {
        return goalKeepers;
    }

    public void setGoalKeepers(ArrayList<Player> goalKeepers) {
        this.goalKeepers = goalKeepers;
    }

    public ArrayList<Player> getCoaches() {
        return coaches;
    }

    public void setCoaches(ArrayList<Player> coaches) {
        this.coaches = coaches;
    }
}
