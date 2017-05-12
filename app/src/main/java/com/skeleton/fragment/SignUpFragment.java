package com.skeleton.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.kbeanie.multipicker.api.entity.ChosenImage;
import com.skeleton.R;
import com.skeleton.model.SignUpResponce;
import com.skeleton.retrofit.APIError;
import com.skeleton.retrofit.MultipartParams;
import com.skeleton.retrofit.ResponseResolver;
import com.skeleton.retrofit.RestClient;
import com.skeleton.util.ValidateEditText;
import com.skeleton.util.imagepicker.ImageChooser;

import java.io.File;
import java.util.List;

/**
 * Created by abc on 11-May-17.
 */

public class SignUpFragment extends BaseFragment {
    private EditText etName, etPhoneNumber, etEmail, etDateofBirth, etPassword, etConfirmPassword;
    private RadioGroup radioGroup;
    private Button button;
    private ImageView imageView;
    private MultipartParams multipartParams;
    private int mselectGender, x;
    private RadioButton mMale, mFemale;
    private ImageChooser imageChooser;
    private File file;
    private String mName, mPhoneNumber, mEmail, mDateofBirth, mPassword, mGender;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        init(view);
        return view;
    }

    @Override
    public void onRequestPermissionsResult(final int requestCode, @NonNull final String[] permissions, @NonNull final int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        imageChooser.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        imageChooser.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * @param v parameter
     */
    @Override
    public void onClick(final View v) {
        super.onClick(v);
        int id = v.getId();
        switch (id) {
            case R.id.xxx:
                if (file != null) {
                    postData();
                } else {
                    Toast.makeText(getContext(), "Please Upload Your Picture", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.iv_image:
                imageChooser = new ImageChooser.Builder(SignUpFragment.this).build();
                imageChooser.selectImage(new ImageChooser.OnImageSelectListener() {
                    @Override
                    public void loadImage(final List<ChosenImage> list) {
                        file = new File(list.get(0).getOriginalPath());
                        Glide.with(SignUpFragment.this)
                                .load(list.get(0).getQueryUri())
                                .into(imageView);
                    }

                    @Override
                    public void croppedImage(final File mCroppedImage) {

                    }
                });
                break;
            default:
                break;
        }
    }

    /**
     * @param view view
     */

    private void init(final View view) {
        etName = (EditText) view.findViewById(R.id.et_name);
        etPhoneNumber = (EditText) view.findViewById(R.id.et_phno);
        etEmail = (EditText) view.findViewById(R.id.et_email);
        etDateofBirth = (EditText) view.findViewById(R.id.et_dob);
        etPassword = (EditText) view.findViewById(R.id.et_pass);
        etConfirmPassword = (EditText) view.findViewById(R.id.et_conpass);
        radioGroup = (RadioGroup) view.findViewById(R.id.rg_gender);
        button = (Button) view.findViewById(R.id.xxx);
        imageView = (ImageView) view.findViewById(R.id.iv_image);
        mselectGender = radioGroup.getCheckedRadioButtonId();
        mMale = (RadioButton) view.findViewById(R.id.rb_male);
        mFemale = (RadioButton) view.findViewById(R.id.rb_female);
        button.setOnClickListener(this);
        imageView.setOnClickListener(this);
    }

    /**
     * module
     */
    private void postData() {
        if (validate()) {
            getData();
            multipartParams = new MultipartParams.Builder()
                    .add("firstName", mName)
                    .add("dob", mDateofBirth)
                    .add("countryCode", "+91")
                    .add("phoneNo", mPhoneNumber)
                    .add("email", mEmail)
                    .add("gender", x)
                    .add("deviceToken", "Raman")
                    .add("appVersion", "hello")
                    .add("profilePic", file)
                    .add("language", "EN")
                    .add("deviceType", "ANDROID")
                    .add("password", mPassword).build();
            RestClient.getApiInterface().register(multipartParams.getMap()).enqueue(new ResponseResolver<SignUpResponce>(getContext()
                    , true) {
                @Override
                public void success(final SignUpResponce signUpResponce) {
                    Toast.makeText(getContext(), signUpResponce.getMessage(), Toast.LENGTH_SHORT).show();

                }

                @Override
                public void failure(final APIError error) {

                }
            });
        }
    }

    /**
     * @return boolean value
     */
    private boolean validate() {
        if (!ValidateEditText.checkName(etName, true)) {
            return false;
        } else if (!ValidateEditText.checkPhoneNumber(etPhoneNumber)) {
            return false;
        } else if (!ValidateEditText.checkEmail(etEmail)) {
            return false;
        } else if (!ValidateEditText.checkPassword(etPassword, false)) {
            return false;
        } else if (!ValidateEditText.checkPassword(etConfirmPassword, true)) {
            return false;
        } else if (!ValidateEditText.comparePassword(etPassword, etConfirmPassword)) {
            return false;
        } else if (mMale.isChecked()) {
            x = 0;
        } else {
            x = 1;
        }
        return true;

    }

    /**
     * getter
     */
    private void getData() {
        mName = etName.getText().toString();
        mEmail = etEmail.getText().toString();
        mPhoneNumber = etPhoneNumber.getText().toString();
        mPassword = etPassword.getText().toString();
        mDateofBirth = etDateofBirth.getText().toString();


    }

}
