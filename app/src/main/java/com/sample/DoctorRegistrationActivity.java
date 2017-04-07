package com.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.sample.db.DatabaseHelper_Doctor;
import com.sample.models.DoctorRegistration;


/**
 * Created by TEST_GAME on 3/19/2017.
 */

public class DoctorRegistrationActivity extends AppCompatActivity {
    int flag2=0;
    @BindView(R.id.txt_doctor_reg)
    LinearLayout mdoc_reg;
    @BindView(R.id.txt_layout_doctor1)
    LinearLayout mlayout_doctor;
    @BindView(R.id.txt_layout_doctor2)
    LinearLayout mlayout_doctor2;
    @BindView(R.id.txt_doc_full_name)
    EditText mfullname_doctor;
    @BindView(R.id.txt_hospitalName)
    EditText mhospital_name;
    @BindView(R.id.txt_hospitaladdress)
    EditText mhospitaladdress;
    @BindView(R.id.txt_specialisation)
    EditText mspecialisation;
    @BindView(R.id.txt_doc_cell)
    EditText mdocnumber;
    @BindView(R.id.txt_age)
    EditText mage;
    @BindView(R.id.txt_hos_number)
            EditText mhosnumber;
    CheckBox c1;
    CheckBox c2;

    private DatabaseHelper_Doctor db2;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_registration);
        ButterKnife.bind(this);
        db2 = new DatabaseHelper_Doctor(this);
        c1 = (CheckBox) findViewById(R.id.checkBox_male);
        c2 = (CheckBox) findViewById(R.id.checkBox_female);
    }


    public boolean onCheckboxClicked(boolean view) {


        c1.setEnabled(false);
        c2.setEnabled(false);

        c1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                if (c1.isChecked()) {
                    c1.setChecked(true);
                    c2.setEnabled(false);

                } else {
                    c1.setChecked(false);
                    c2.setEnabled(true);
                }
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (c2.isChecked()) {
                    c2.setChecked(true);
                    c1.setEnabled(false);

                } else {
                    c2.setChecked(false);
                    c1.setEnabled(true);
                }
            }
        });

        return view;
    }

    @OnClick(R.id.button_save_pi)
    public void save2() {
       // DoctorRegistration doctorRegistration = null;

        DoctorRegistration doctorRegistration = new DoctorRegistration();
        try {
            doctorRegistration.setFullName2(mfullname_doctor.getText().toString());
            doctorRegistration.setSpecialization(mspecialisation.getText().toString());
            doctorRegistration.setMobile2(mdocnumber.getText().toString());
            doctorRegistration.setHospital_name2(mhospital_name.getText().toString());
            doctorRegistration.setCity2(mhospitaladdress.getText().toString());
            doctorRegistration.setHospital_mobile2(mhosnumber.getText().toString());
            doctorRegistration.setAge(Integer.parseInt(mage.getText().toString().equals("") ? "0" : mage.getText().toString()));
            if (onCheckboxClicked(c1.isChecked())) {
               doctorRegistration.setGender(c1.getText().toString());

            } else
                doctorRegistration.setGender(c2.getText().toString());
        } catch (Exception e) {
            flag2 = 1;
            Toast.makeText(this, "Please Fill All The Field Correctly", Toast.LENGTH_SHORT).show();
        }

        db2.addDoctor(doctorRegistration);
        if (flag2 == 0) {
            Intent intent = new Intent(getApplicationContext(), DoctorActivity.class);
            startActivity(intent);
        }

    }



    }


