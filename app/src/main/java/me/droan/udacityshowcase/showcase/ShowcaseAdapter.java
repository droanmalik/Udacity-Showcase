package me.droan.udacityshowcase.showcase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.droan.udacityshowcase.data.Post;
import me.droan.udacityshowcase.R;

/**
 * Created by drone on 03-07-2016.
 */
public class ShowcaseAdapter extends RecyclerView.Adapter<ShowcaseAdapter.Holder> {


    private Context context;
    private List<Post> posts = new ArrayList<>();

    public ShowcaseAdapter(Context context) {
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = (inflater.inflate(R.layout.showcase_item, parent, false));
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.bind(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void refresh(List<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    class Holder extends RecyclerView.ViewHolder {
        ShowcaseItem itemView;

        public Holder(View itemView) {
            super(itemView);
            this.itemView = (ShowcaseItem) itemView;
        }

        public void bind(Post post) {
            itemView.bind(post);
        }
    }
}
