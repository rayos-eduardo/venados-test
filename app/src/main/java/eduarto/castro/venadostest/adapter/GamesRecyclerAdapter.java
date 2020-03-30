package eduarto.castro.venadostest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import eduarto.castro.venadostest.Model.Game.Game;
import eduarto.castro.venadostest.R;

public class GamesRecyclerAdapter extends RecyclerView.Adapter<GamesRecyclerAdapter.leaguesViewHolder>{

    private Context context;
    private List<Game> games;

    public GamesRecyclerAdapter(Context context, List<Game> games) {
        this.context = context;
        this.games = games;
    }

    @NonNull
    @Override
    public GamesRecyclerAdapter.leaguesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(context).inflate(R.layout.item_games, parent, false);
      return new leaguesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GamesRecyclerAdapter.leaguesViewHolder holder, int position) {
        Game game = games.get(position);

        holder.homeScore.setText(String.valueOf(game.getHomeScore()));
        holder.awayScore.setText(String.valueOf(game.getAwayScore()));

        if (game.isLocal()){
            Glide.with(context).load(R.mipmap.venados_escudo).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.homeImage);
            holder.homeName.setText(R.string.team_name);
            Glide.with(context).load(game.getOpponentImage()).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).thumbnail(0.5f).into(holder.awayImage);
            holder.awayName.setText(game.getOpponent());
        }
        else {
            Glide.with(context).load(game.getOpponentImage()).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).thumbnail(0.5f).into(holder.homeImage);
            holder.homeName.setText(game.getOpponent());
            Glide.with(context).load(R.mipmap.venados_escudo).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.awayImage);
            holder.awayName.setText(R.string.team_name);
        }
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public class leaguesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView calendar;
        private TextView day;
        private TextView weekDay;
        private ImageView homeImage;
        private TextView homeName;
        private TextView homeScore;
        private TextView awayScore;
        private ImageView awayImage;
        private TextView awayName;

        public leaguesViewHolder(View view){
            super(view);

            calendar = view.findViewById(R.id.calendar_button);
            day = view.findViewById(R.id.day_tv);
            weekDay = view.findViewById(R.id.weekday_tv);
            homeImage = view.findViewById(R.id.home_image);
            homeName = view.findViewById(R.id.home_tv);
            homeScore = view.findViewById(R.id.home_score_tv);
            awayScore = view.findViewById(R.id.away_score_tv);
            awayImage = view.findViewById(R.id.away_image);
            awayName = view.findViewById(R.id.away_tv);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == calendar.getId()){
                Toast.makeText(context,"Calendario", Toast.LENGTH_SHORT).show();
            }
        }
    }


}


