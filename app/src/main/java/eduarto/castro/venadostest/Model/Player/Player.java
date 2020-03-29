package eduarto.castro.venadostest.Model.Player;

import com.google.gson.annotations.SerializedName;

public class Player {
    @SerializedName("name")
    private String name;
    @SerializedName("first_surname")
    private String firstSurname;
    @SerializedName("second_surname")
    private String secondSurname;
    @SerializedName("birthday")
    private String birthday;
    @SerializedName("birth_place")
    private String birthPlace;
    @SerializedName("weight")
    private double weight;
    @SerializedName("height")
    private double height;
    @SerializedName("position")
    private String position;
    @SerializedName("number")
    private int number;
    @SerializedName("last_team")
    private String lastTeam;
    @SerializedName("image")
    private String playerImage;
    @SerializedName("role")
    private String role;

    public Player(String name, String firstSurname, String secondSurname, String birthday, String birthPlace, double weight, double height, String position, int number, String lastTeam, String playerImage) {
        this.name = name;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.birthday = birthday;
        this.birthPlace = birthPlace;
        this.weight = weight;
        this.height = height;
        this.position = position;
        this.number = number;
        this.lastTeam = lastTeam;
        this.playerImage = playerImage;
    }

    public Player(String name, String firstSurname, String secondSurname, String birthday, String birthPlace, double weight, double height, String role, String playerImage) {
        this.name = name;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.birthday = birthday;
        this.birthPlace = birthPlace;
        this.weight = weight;
        this.height = height;
        this.playerImage = playerImage;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getLastTeam() {
        return lastTeam;
    }

    public void setLastTeam(String lastTeam) {
        this.lastTeam = lastTeam;
    }

    public String getPlayerImage() {
        return playerImage;
    }

    public void setPlayerImage(String playerImage) {
        this.playerImage = playerImage;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
