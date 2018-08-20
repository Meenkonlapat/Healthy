package com.example.lab203_59.healthy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by LAB203_44 on 20/8/2561.
 */

public class RegisterFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frangment_register, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initregister();
    }

    private void initregister(){
        Button _registerBtn = (Button) getView().findViewById(R.id.register_acc_btn);
        _registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText _userId = (EditText) getView().findViewById(R.id.register_user_id);
                EditText _password = (EditText) getView().findViewById(R.id.register_password);
                EditText _name = (EditText) getView().findViewById(R.id.register_name);
                EditText _age = (EditText) getView().findViewById(R.id.register_age);
                String _userIdStr = _userId.getText().toString();
                String _passwordStr = _password.getText().toString();
                String _nameStr = _name.getText().toString();
                String _ageStr = _age.getText().toString();
                if (_userIdStr.isEmpty() || _passwordStr.isEmpty() || _nameStr.isEmpty() || _ageStr.isEmpty())
                {
                    Toast.makeText(getActivity(), "กรุณากรอกข้อมูลให้ครบถ้วน", Toast.LENGTH_SHORT).show();
                    Log.d("USER", "FIELD NAME IS EMPTY");
                }
                else if (_userIdStr.equals("admin"))
                {
                    Toast.makeText(getActivity(), "user นี้มีอยู่ในระบบแล้ว", Toast.LENGTH_SHORT).show();
                    Log.d("USER", "USER ALREADY EXIST");
                }
                else{

                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_view, new BMIFragment())
                            .addToBackStack(null)
                            .commit();

                    Log.d("USER", "GOTO BMI");
                }
            }
        });
    }
}
