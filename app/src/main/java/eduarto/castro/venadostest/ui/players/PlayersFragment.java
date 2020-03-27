package eduarto.castro.venadostest.ui.players;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import eduarto.castro.venadostest.R;

public class PlayersFragment extends Fragment {

    private PlayersViewModel playersViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        playersViewModel = new ViewModelProvider(this).get(PlayersViewModel.class);
        View root = inflater.inflate(R.layout.fragment_players, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        return root;
    }
}
