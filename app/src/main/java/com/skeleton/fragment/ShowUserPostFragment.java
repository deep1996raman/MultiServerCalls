package com.skeleton.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skeleton.R;
import com.skeleton.adapter.UserPostsRecyclerViewAdapter;
import com.skeleton.model.UserPosts;
import com.skeleton.retrofit.APIError;
import com.skeleton.retrofit.ResponseResolver;
import com.skeleton.retrofit.RestClient;
import com.skeleton.util.Log;

import java.util.List;

import static android.R.attr.id;

/**
 * Created by abc on 10-May-17.
 */

public class ShowUserPostFragment extends BaseFragment {
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_posts, container, false);
        init(view);
        int id;
        id = getArguments().getInt("postid");

        Log.d("abc1", String.valueOf(id));
        RestClient.getApiInterface().getUserPosts(1 + id).enqueue(new ResponseResolver<List<UserPosts>>(getContext(), true) {
            @Override
            public void success(final List<UserPosts> userPostses) {

                UserPostsRecyclerViewAdapter userPostsRecyclerViewAdapter = new UserPostsRecyclerViewAdapter(userPostses, getContext());
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(userPostsRecyclerViewAdapter);

            }

            @Override
            public void failure(final APIError error) {

            }
        });
        return view;
    }

    /**
     * @param view parameter
     */
    private void init(final View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_posts);
    }
}
