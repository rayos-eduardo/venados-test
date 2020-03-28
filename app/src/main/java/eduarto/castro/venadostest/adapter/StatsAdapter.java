package eduarto.castro.venadostest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import eduarto.castro.venadostest.Model.Stat.Stats;
import eduarto.castro.venadostest.R;

public class StatsAdapter extends RecyclerView.Adapter<StatsAdapter.statsViewHolder> {

    private Context context;
    private List<Stats> stats;

    public StatsAdapter(Context context, List<Stats> stats) {
        this.context = context;
        this.stats = stats;
    }

    @NonNull
    @Override
    public StatsAdapter.statsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_stats,parent,false);
        return new statsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatsAdapter.statsViewHolder holder, int position) {
        Stats stat = stats.get(position);
        holder.position.setText(String.valueOf(stat.getPosition()));
        holder.teamName.setText(stat.getTeamName());
        holder.playedGames.setText(String.valueOf(stat.getGameNumber()));
        holder.scoreDiff.setText(String.valueOf(stat.getScoreDiff()));
        holder.points.setText(String.valueOf(stat.getPoints()));
        Glide.with(context).load(stat.getTeamImage()).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).thumbnail(0.5f).into(holder.teamImage);
    }

    @Override
    public int getItemCount() {
        return stats.size();
    }

    class statsViewHolder extends RecyclerView.ViewHolder {

        TextView position, teamName, playedGames, scoreDiff, points;
        ImageView teamImage;
        public statsViewHolder(@NonNull View itemView) {
            super(itemView);

            position = itemView.findViewById(R.id.position_tv);
            teamName = itemView.findViewById(R.id.team_name_tv);
            playedGames = itemView.findViewById(R.id.played_games_tv);
            scoreDiff = itemView.findViewById(R.id.score_diff_tv);
            points = itemView.findViewById(R.id.points_tv);
            teamImage = itemView.findViewById(R.id.team_iv);
        }
    }
}
