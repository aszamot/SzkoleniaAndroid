package pl.tomasz.weather.prezentacje.githubfull;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import pl.tomasz.weather.R;
import pl.tomasz.weather.prezentacje.GitHubRepoModel;

/**
 * Created by Tomasz on 05.10.2017.
 */

public class GitHubAdapter extends RecyclerView.Adapter<GitHubViewHolder> {

    private List<GitHubRepoModel> repos;
    private Context context;

    public GitHubAdapter(Context context, List<GitHubRepoModel> repos) {
        this.context = context;
        this.repos = repos;
    }

    @Override
    public GitHubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_github, parent, false);

        return new GitHubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GitHubViewHolder holder, int position) {
        holder.bindData(repos.get(position));
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    public void insertList(List<GitHubRepoModel> list) {
        repos.clear();
        for (int i = 0; i < list.size(); i++) {
            repos.add(list.get(i));
            notifyItemInserted(repos.size() - 1);
        }
    }
}
