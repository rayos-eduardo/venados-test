package eduarto.castro.venadostest.ui.players.details;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.zip.Inflater;

import eduarto.castro.venadostest.Model.Player.Player;
import eduarto.castro.venadostest.R;

public class PlayersDetailsDialog extends DialogFragment {

    private Context context;
    private Player player;

    public PlayersDetailsDialog() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_players_details, container, false);

        ImageView playerDetailsImage = view.findViewById(R.id.player_details_iv);
        TextView playerDetailsName = view.findViewById(R.id.player_details_name_tv);
        TextView playerDetailsPosition = view.findViewById(R.id.player_details_position_tv);
        TextView playerDetailsBirthday = view.findViewById(R.id.player_details_birthday_tv);
        TextView playerDetailsBirthPlace = view.findViewById(R.id.player_details_birthplace_tv);
        TextView playerDetailsWeight = view.findViewById(R.id.player_details_weight_tv);
        TextView playerDetailsHeight = view.findViewById(R.id.player_details_height_tv);
        TextView playerDetailsPreviousTeam = view.findViewById(R.id.player_details_previous_tv);

        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SS:SS");
        SimpleDateFormat targetFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date date = null;
        try {
            date = originalFormat.parse(player.getBirthday());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String Birthday = targetFormat.format(Objects.requireNonNull(date));

        if (isAdded()){
            if (player != null){
                Glide.with(context).load(player.getPlayerImage()).circleCrop().diskCacheStrategy(DiskCacheStrategy.ALL).thumbnail(0.5f).into(playerDetailsImage);
                playerDetailsName.setText(player.getName());
                playerDetailsPosition.setText(player.getPosition() == null ? player.getRole() : player.getPosition());
                playerDetailsBirthday.setText(Birthday);
                playerDetailsBirthPlace.setText(player.getBirthPlace());
                playerDetailsWeight.setText(String.valueOf(player.getWeight()));
                playerDetailsHeight.setText(String.valueOf(player.getHeight()));
                playerDetailsPreviousTeam.setText(player.getLastTeam());
            }
        }

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
