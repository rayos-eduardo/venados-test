package eduarto.castro.venadostest.Model.Player;

import com.google.gson.annotations.SerializedName;

public class Teams {
    @SerializedName("team")
    private Positions positions;

    public Teams() {

    }

    public Teams(Positions positions) {
        this.positions = positions;
    }

    public Positions getPositions() {
        return positions;
    }

    public void setPositions(Positions positions) {
        this.positions = positions;
    }
}
