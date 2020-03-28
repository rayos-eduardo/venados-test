package eduarto.castro.venadostest.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import eduarto.castro.venadostest.R;
import eduarto.castro.venadostest.adapter.LeaguesTabAdapter;

public class HomeFragment extends Fragment {
    private LeaguesTabAdapter leaguesTabAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        leaguesTabAdapter = new LeaguesTabAdapter(this);

        ViewPager2 pager = view.findViewById(R.id.view_pager);

        pager.setAdapter(leaguesTabAdapter);

        TabLayout tabLayout = view.findViewById(R.id.home_tabs);
        new TabLayoutMediator(tabLayout, pager, (tab, position) -> {
            switch (position){
                case 0:
                    tab.setText("COPA MX");
                    break;
                case 1:
                    tab.setText("ASCENSO MX");
                    break;
            }
        }).attach();
    }
}
