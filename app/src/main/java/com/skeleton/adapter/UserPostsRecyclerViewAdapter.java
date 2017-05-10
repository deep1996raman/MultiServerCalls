package com.skeleton.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skeleton.R;
import com.skeleton.model.UserPosts;
import com.skeleton.util.Log;

import java.util.List;

/**
 * Created by mcgreen on 8/5/17.
 */

public class UserPostsRecyclerViewAdapter extends RecyclerView.Adapter<UserPostsRecyclerViewAdapter.ViewHolder> {
    private List<UserPosts> userPostses;
    private Context mContext;

    /**
     * @param userPostses cons
     * @param mContext    param
     */
    public UserPostsRecyclerViewAdapter(final List<UserPosts> userPostses, final Context mContext) {
        this.userPostses = userPostses;
        this.mContext = mContext;
    }

    @Override
    public UserPostsRecyclerViewAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.item_view_posts, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final UserPostsRecyclerViewAdapter.ViewHolder holder, final int position) {
        UserPosts userPosts = userPostses.get(position);
        int x = userPosts.getPostId();
        String ok = String.valueOf(x);
        Log.d("hi", ok);
        holder.tvId.setText(String.valueOf(userPosts.getPostId()));
        holder.tvTitle.setText(userPosts.getTitle());
        holder.tvPost.setText(userPosts.getBody());
    }

    @Override
    public int getItemCount() {
        return userPostses.size();
    }

    /**
     * viewholder class
     */

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvId, tvTitle, tvPost;

        /**
         * @param itemView item view
         */
        public ViewHolder(final View itemView) {
            super(itemView);
            tvId = (TextView) itemView.findViewById(R.id.tvPostId);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvPost = (TextView) itemView.findViewById(R.id.tvPost);
        }
    }
}
