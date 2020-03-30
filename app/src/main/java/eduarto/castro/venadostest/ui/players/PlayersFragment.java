package eduarto.castro.venadostest.ui.players;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import eduarto.castro.venadostest.Model.Player.Player;
import eduarto.castro.venadostest.R;
import eduarto.castro.venadostest.adapter.PlayersGridAdapter;
import eduarto.castro.venadostest.ui.players.details.PlayersDetailsDialog;

public class PlayersFragment extends Fragment implements PlayersView{

    Context context;

    private GridView playersGridView;
    private PlayersGridAdapter playersGridAdapter;
    private PlayersPresenter playersPresenter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_players, container, false);
        playersGridView = view.findViewById(R.id.players_gv);

        playersPresenter = new PlayersPresenter(this);
        playersPresenter.getData();

        playersGridView.setOnItemClickListener((adapterView, view1, i, l) -> {
            Player item = (Player) adapterView.getItemAtPosition(i);

            PlayersDetailsDialog playersDetailsDialog = new PlayersDetailsDialog();
            playersDetailsDialog.setPlayer(item);
            playersDetailsDialog.show(getParentFragmentManager(), "Details");
        });
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onGetResult(ArrayList<Player> players) {
        playersGridAdapter = new PlayersGridAdapter(context, players);
        playersGridView.setAdapter(playersGridAdapter);
    }

    @Override
    public void onErrorLoading(String message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
    }
}
