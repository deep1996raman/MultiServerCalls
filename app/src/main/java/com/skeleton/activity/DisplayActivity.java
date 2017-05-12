package com.skeleton.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.skeleton.R;
import com.skeleton.adapter.DataAdapter;
import com.skeleton.model.UserInfo;
import com.skeleton.retrofit.APIError;
import com.skeleton.retrofit.ResponseResolver;
import com.skeleton.retrofit.RestClient;

import java.util.List;

/**
 * display activity
 */

public class DisplayActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button buttonSignup;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        init();
        RestClient.getApiInterface().getUserData().enqueue(new ResponseResolver<List<UserInfo>>(this, true) {
            @Override
            public void success(final List<UserInfo> userInfos) {
                DataAdapter recyclerViewAdapter = new DataAdapter(userInfos, DisplayActivity.this);

                recyclerView = (RecyclerView) findViewById(R.id.rv_display);
                recyclerView.setLayoutManager(new LinearLayoutManager(DisplayActivity.this));
                recyclerView.setAdapter(recyclerViewAdapter);

            }

            @Override
            public void failure(final APIError error) {
                Toast.makeText(DisplayActivity.this, "failed!", Toast.LENGTH_LONG).show();


            }
        });
        buttonSignup.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param v view
             */
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent(DisplayActivity.this, SignUpActivity.class);
                startActivity(intent);

            }
        });
    }

    /**
     * init
     */

    private void init() {
        buttonSignup = (Button) findViewById(R.id.btn_signup);
    }

}
