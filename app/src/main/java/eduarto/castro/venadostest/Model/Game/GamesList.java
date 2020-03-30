package eduarto.castro.venadostest.Model.Game;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GamesList {
    @SerializedName("games")
    private List<Game> gamesList;

    public GamesList() {}

    public GamesList(ArrayList<Game> gamesList) {
        this.gamesList = gamesList;
    }

    public List<Game> getGames() {
        return gamesList;
    }

    public void setGames(ArrayList<Game> gamesList) {
        this.gamesList = gamesList;
    }
}
