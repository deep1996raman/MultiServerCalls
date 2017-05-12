package com.skeleton.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.skeleton.R;
import com.skeleton.model.SignUpResponce;
import com.skeleton.retrofit.APIError;
import com.skeleton.retrofit.CommonParams;
import com.skeleton.retrofit.ResponseResolver;
import com.skeleton.retrofit.RestClient;
import com.skeleton.util.ValidateEditText;

/**
 * Created by Ramna on 9/5/17.
 */

public class SignInFragment extends BaseFragment {
    private EditText etEmail, etPassword;
    private String mUsetName, mPassword;
    private Button btnLogin, btnFbLogin;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sigin, container, false);
        init(view);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                getdata();
                if (validate()) {
                    CommonParams params = new CommonParams.Builder()
                            .add("email", mUsetName)
                            .add("password", mPassword)
                            .add("deviceType", "ANDROID")
                            .add("language", "EN")
                            .add("deviceToken", "XYZ")
                            .add("flushPreviousSessions", true)
                            .add("appVersion", "101")
                            .build();
                    RestClient.getApiInterface().login(null, params.getMap()).enqueue(new ResponseResolver<SignUpResponce>(getContext(), true, true
                    ) {
                        @Override
                        public void success(final SignUpResponce signUpResponce) {
                            Toast.makeText(getContext(), signUpResponce.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void failure(final APIError error) {
                            Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });


        return view;

    }

    /**
     * @return t/f
     */
    private boolean validate() {
        if (!ValidateEditText.checkEmail(etEmail)) {
            return false;
        } else if (!ValidateEditText.checkPassword(etPassword, false)) {
            return false;
        }
        return true;

    }

    /**
     * getting data
     */
    private void getdata() {
        mUsetName = etEmail.getText().toString();
        mPassword = etPassword.getText().toString();
    }

    /**
     * init
     *
     * @param view refrence
     */
    private void init(final View view) {
        etEmail = (EditText) view.findViewById(R.id.et_em_phno);
        btnLogin = (Button) view.findViewById(R.id.btn_signin);
        etPassword = (EditText) view.findViewById(R.id.et_password);

    }
}

