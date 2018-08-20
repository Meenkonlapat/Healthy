package com.example.lab203_59.healthy;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by LAB203_44 on 20/8/2561.
 */

public class LoginFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false );
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       initLoginBtn();
        initRegisterBtn();

    }

    private void initLoginBtn(){
        Button _loginBtm = (Button) getView().findViewById(R.id.login_btn);
        _loginBtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText _userId = (EditText) getView().findViewById(R.id.login_user_id);
                EditText _userPassword = (EditText) getView().findViewById(R.id.login_user_password);
                String _userIdStr = _userId.getText().toString();
                String _userPasswordStr = _userPassword.getText().toString();
                if(_userIdStr.isEmpty() || _userPasswordStr.isEmpty()){
                    Toast.makeText(getActivity(), "กรุณาระบุ user หรือ password",Toast.LENGTH_SHORT).show();
                    Log.d("USER", "USER OR PASSWORD IS EMPTY");
                }
                else if(_userIdStr.equals("admin") && _userPasswordStr.equals("admin"))
                {
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_view, new BMIFragment())
                            .addToBackStack(null)
                            .commit();

                    Log.d("USER", "GOTO BMI");
                }

                else {
                    Log.d("USER", "INVALID USERNAME OR PASSWORD");
                }
            }
        });
    }
    private void initRegisterBtn(){
        TextView _registerBtn = (TextView) getView().findViewById(R.id.register_btn);
        _registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_view, new RegisterFragment())
                        .addToBackStack(null)
                        .commit();
                Log.d("USER", "GOTO REGISTER");
            }
        });
    }
}
