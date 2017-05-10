package com.skeleton.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.skeleton.R;
import com.skeleton.activity.DisplayActivity;
import com.skeleton.model.UserInfo;


/**
 * Created by abc on 09-May-17.
 */

public class BelowFragment extends BaseFragment {
    private UserInfo.Company company;
    private Button button;
    private TextView tvName, tvUserName, tvEmail, tvStreet, tvPhNo, tvcmpny;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_user_details, container, false);
        init(view);
        final Bundle bundle = getArguments();
        final UserInfo obj = bundle.getParcelable("obj");
        tvName.setText(obj.getName());
        tvEmail.setText(obj.getEmail());
        tvUserName.setText(obj.getUsername());
        company = obj.getCompany();
        tvcmpny.setText(company.getName());
        tvStreet.setText(String.valueOf(obj.getAddress().getStreet()));
        tvPhNo.setText(String.valueOf(obj.getPhone()));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Bundle bundle1 = new Bundle();
                int id;
                id = obj.getId();
                bundle1.putInt("postid", id);
                ShowUserPostFragment showUserPostFragment = new ShowUserPostFragment();
                showUserPostFragment.setArguments(bundle1);
                FragmentManager fragmentManager = ((DisplayActivity) getContext()).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction;
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.llfulldisplay, showUserPostFragment);
                fragmentTransaction.commit();
            }
        });
        return view;
    }


    /**
     * @param view param
     */
    private void init(final View view) {
        button = (Button) view.findViewById(R.id.btn_ShowPost);
        tvName = (TextView) view.findViewById(R.id.tvName);
        tvUserName = (TextView) view.findViewById(R.id.tvUsername);
        tvStreet = (TextView) view.findViewById(R.id.tvStreet);
        tvEmail = (TextView) view.findViewById(R.id.tvEmail);
        tvcmpny = (TextView) view.findViewById(R.id.tvCompny);
        tvPhNo = (TextView) view.findViewById(R.id.tvphoneNumber);
    }
}
