package com.skeleton.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skeleton.R;
import com.skeleton.activity.DisplayActivity;
import com.skeleton.fragment.BelowFragment;
import com.skeleton.model.UserInfo;

import java.util.List;

/**
 * Created by abc on 09-May-17.
 */

public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<UserInfo> mUserInfo;
    private Context mContext;

    /**
     * @param mUserInfo userinfo
     * @param mContext  context
     */

    public DataAdapter(final List<UserInfo> mUserInfo, final Context mContext) {
        this.mUserInfo = mUserInfo;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View dataView;
        dataView = LayoutInflater.from(mContext).inflate(R.layout.item_display, parent, false);
        return new ViewHolder(dataView);
    }

    /**
     * @param holder   holder
     * @param position position
     */
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        UserInfo currentUser = mUserInfo.get(position);

        viewHolder.mId.setText(String.valueOf(currentUser.getId()));
        viewHolder.mName.setText(currentUser.getName());


    }

    /**
     * @return user info
     */

    @Override
    public int getItemCount() {
        return mUserInfo.size();

    }

    /**
     * view holder class
     */

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mName;
        private TextView mId;

        /**
         * @param itemView item view
         */

        public ViewHolder(final View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.user_name);
            mId = (TextView) itemView.findViewById(R.id.user_id);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    int position = getAdapterPosition();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("obj", mUserInfo.get(position));
                    BelowFragment belowFragment = new BelowFragment();
                    belowFragment.setArguments(bundle);
                    FragmentManager fragmentManager = ((DisplayActivity) mContext).getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.lldisplay2, belowFragment);
                    fragmentTransaction.commit();

                }
            });
        }
    }
}
