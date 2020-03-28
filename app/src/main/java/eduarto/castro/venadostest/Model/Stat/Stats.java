package eduarto.castro.venadostest.Model.Stat;

import com.google.gson.annotations.SerializedName;

public class Stats {
    @SerializedName("position")
    private int position;
    @SerializedName("image")
    private String teamImage;
    @SerializedName("team")
    private String teamName;
    @SerializedName("games")
    private int gameNumber;
    @SerializedName("score_diff")
    private int scoreDiff;
    @SerializedName("points")
    private int points;

    public Stats(int position, String teamImage, String teamName, int gameNumber, int scoreDiff, int points){
        this.position = position;
        this.teamImage = teamImage;
        this.teamName = teamName;
        this.gameNumber = gameNumber;
        this.scoreDiff = scoreDiff;
        this.points = points;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getTeamImage() {
        return teamImage;
    }

    public void setTeamImage(String teamImage) {
        this.teamImage = teamImage;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public int getScoreDiff() {
        return scoreDiff;
    }

    public void setScoreDiff(int scoreDiff) {
        this.scoreDiff = scoreDiff;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
