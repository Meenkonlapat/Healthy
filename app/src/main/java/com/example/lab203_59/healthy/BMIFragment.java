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
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by LAB203_44 on 20/8/2561.
 */

public class BMIFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bmi, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initcalculate();
    }
    private void initcalculate(){
        Button _Calculate = (Button) getView().findViewById(R.id.calculate_btn);
        _Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText _weight = (EditText) getView().findViewById(R.id.weight_info);
                EditText _height = (EditText) getView().findViewById(R.id.height_info);
                String _weightStr = _weight.getText().toString();
                String _heightStr = _height.getText().toString();
                TextView _BMI = (TextView) getView().findViewById(R.id.text_set);
                String _BMIStr = _BMI.getText().toString();
                if (_weightStr.isEmpty() || _heightStr.isEmpty())
                {
                    Toast.makeText(getActivity(), "กรุณาระบุข้อมูลให้ครบถ้วน", Toast.LENGTH_SHORT).show();
                    Log.d("USER", "FIELD NAME IS EMPTY");
                }
                else
                {
                    Double _weightInt = Double.parseDouble(_weightStr);
                    Double _heightInt = Double.parseDouble(_heightStr);
                    Double BMI = _weightInt/((_heightInt/100)*(_heightInt/100));
                    String _BMISTR = String.format("%.2f", BMI);
                    _BMI.setText(_BMISTR);
                }
            }
        });

    }
}
