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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import eduarto.castro.venadostest.Model.Game.Game;
import eduarto.castro.venadostest.R;

public class GamesRecyclerAdapter extends RecyclerView.Adapter<GamesRecyclerAdapter.leaguesViewHolder>{

    private Context context;
    private List<Game> games;

    Locale spanish = new Locale("es", "MX");
    SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SS:SS");
    SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM", spanish);
    SimpleDateFormat weekFormat = new SimpleDateFormat("EEE", spanish);

    public GamesRecyclerAdapter(Context context, List<Game> games) {
        this.context = context;
        this.games = games;
    }

    @NonNull
    @Override
    public GamesRecyclerAdapter.leaguesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = null;
      switch (viewType){
          case 0:
              view = LayoutInflater.from(context).inflate(R.layout.item_month_sep, parent, false);
              break;
          case 1:
              view = LayoutInflater.from(context).inflate(R.layout.item_games, parent, false);
              break;
      }
      return new leaguesViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull GamesRecyclerAdapter.leaguesViewHolder holder, int position) {
        Game game = games.get(position);
        
        Date date = null;
        try {
            date = originalFormat.parse(game.getDatetime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String dayString = dayFormat.format(Objects.requireNonNull(date));
        String month = monthFormat.format(Objects.requireNonNull(date));
        String week = weekFormat.format(Objects.requireNonNull(date));


        holder.day.setText(dayString.toUpperCase());
        holder.weekDay.setText(week);
        holder.homeScore.setText(String.valueOf(game.getHomeScore()));
        holder.awayScore.setText(String.valueOf(game.getAwayScore()));

        if (holder.ViewType == 0){
            holder.monthSep.setText(month.toUpperCase());
        }

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

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        }
        else
        {
            String lastMonth = null;
            Date date = null;
            try {
                date = originalFormat.parse(games.get(position).getDatetime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String month = monthFormat.format(Objects.requireNonNull(date));

            if (position > 0) {
                Date lastDate = null;
                try {
                    lastDate = originalFormat.parse(games.get(position - 1).getDatetime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                lastMonth = monthFormat.format(Objects.requireNonNull(lastDate));
            }

            if (month.equals(lastMonth)) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public class leaguesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        int ViewType;
        private ImageView calendar;
        private TextView day;
        private TextView weekDay;
        private ImageView homeImage;
        private TextView homeName;
        private TextView homeScore;
        private TextView awayScore;
        private ImageView awayImage;
        private TextView awayName;
        
        private TextView monthSep;

        public leaguesViewHolder(View view, int viewType){
            super(view);
            
            switch (viewType){
                case 0:
                    monthSep = view.findViewById(R.id.month_sep);
                    calendar = view.findViewById(R.id.calendar_button);
                    day = view.findViewById(R.id.day_tv);
                    weekDay = view.findViewById(R.id.weekday_tv);
                    homeImage = view.findViewById(R.id.home_image);
                    homeName = view.findViewById(R.id.home_tv);
                    homeScore = view.findViewById(R.id.home_score_tv);
                    awayScore = view.findViewById(R.id.away_score_tv);
                    awayImage = view.findViewById(R.id.away_image);
                    awayName = view.findViewById(R.id.away_tv);
                    ViewType = 0;
                    break;
                case 1:
                    calendar = view.findViewById(R.id.calendar_button);
                    day = view.findViewById(R.id.day_tv);
                    weekDay = view.findViewById(R.id.weekday_tv);
                    homeImage = view.findViewById(R.id.home_image);
                    homeName = view.findViewById(R.id.home_tv);
                    homeScore = view.findViewById(R.id.home_score_tv);
                    awayScore = view.findViewById(R.id.away_score_tv);
                    awayImage = view.findViewById(R.id.away_image);
                    awayName = view.findViewById(R.id.away_tv);
                    ViewType = 1;
                    break;
            }
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == calendar.getId()){
                Toast.makeText(context,"Calendario", Toast.LENGTH_SHORT).show();
            }
        }
    }


}


