package pl.tomasz.weather.prezentacje.githubfull;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import pl.tomasz.weather.R;
import pl.tomasz.weather.prezentacje.GitHubRepoModel;

/**
 * Created by Tomasz on 05.10.2017.
 */

public class GitHubViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView address;
    private TextView lang;
    private TextView isPrivate;

    public GitHubViewHolder(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.city_res);
        address = (TextView) itemView.findViewById(R.id.date_res);
        lang = (TextView) itemView.findViewById(R.id.temp_res);
        isPrivate = (TextView) itemView.findViewById(R.id.is_private);
    }

    public void bindData(GitHubRepoModel repo) {
        name.setText(repo.getName());
        address.setText(repo.getAddress());
        lang.setText(repo.getLanguage());
        if (repo.isPrivate()) {
            isPrivate.setText("Private");
        } else {
            isPrivate.setText("Public");
        }
    }
}
