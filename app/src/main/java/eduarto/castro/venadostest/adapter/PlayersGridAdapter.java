package eduarto.castro.venadostest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import eduarto.castro.venadostest.Model.Player.Player;
import eduarto.castro.venadostest.R;
import eduarto.castro.venadostest.ui.players.PlayersFragment;
import eduarto.castro.venadostest.ui.players.details.PlayersDetailsDialog;

public class PlayersGridAdapter extends BaseAdapter {

    private Context context;
    private List<Player> players;

    public PlayersGridAdapter(Context context, List<Player> players) {
        this.context = context;
        this.players = players;
    }

    @Override
    public int getCount() {
        return players.size();
    }

    @Override
    public Player getItem(int i) {
        return players.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            assert layoutInflater != null;
            view = layoutInflater.inflate(R.layout.item_players, null);
            ImageView playerImage = view.findViewById(R.id.player_iv);
            TextView playerName = view.findViewById(R.id.player_name_tv);
            TextView playerPosition = view.findViewById(R.id.player_position_tv);

            String fullName = players.get(i).getName() + " " + players.get(i).getFirstSurname();

            Glide.with(context).load(players.get(i).getPlayerImage()).circleCrop().diskCacheStrategy(DiskCacheStrategy.ALL).thumbnail(0.5f).into(playerImage);
            playerName.setText(fullName);
            playerPosition.setText(players.get(i).getPosition() == null ? players.get(i).getRole() : players.get(i).getPosition());
        }

        return view;
    }
}
