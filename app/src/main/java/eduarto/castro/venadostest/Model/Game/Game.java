package eduarto.castro.venadostest.Model.Game;

import com.google.gson.annotations.SerializedName;

public class Game {
    @SerializedName("local")
    private boolean local;
    @SerializedName("opponent")
    private String opponent;
    @SerializedName("opponent_image")
    private String opponentImage;
    @SerializedName("datetime")
    private String datetime;
    @SerializedName("league")
    private String league;
    @SerializedName("home_score")
    private int homeScore;
    @SerializedName("away_score")
    private int awayScore;

    public Game(boolean local, String opponent, String opponentImage, String datetime, String league, int homeScore, int awayScore){
        this.local = local;
        this.opponent = opponent;
        this.opponentImage = opponentImage;
        this.datetime = datetime;
        this.league = league;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }

    public boolean isLocal() {
        return local;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponentImage(String opponentImage) {
        this.opponentImage = opponentImage;
    }

    public String getOpponentImage() {
        return opponentImage;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getLeague() {
        return league;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public int getAwayScore() {
        return awayScore;
    }
}
