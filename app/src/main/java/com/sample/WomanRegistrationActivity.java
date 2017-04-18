package com.sample;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import com.sample.db.DatabaseHelper;
import com.sample.models.WomanRegistration;
import java.util.Calendar;

/**
 * Created by User on 1/30/2017.
 */

public class WomanRegistrationActivity extends AppCompatActivity {

    int flag=0;

    @BindView(R.id.layout_woman)
    LinearLayout mLayoutWoman;
    @BindView(R.id.radio_woman)
    RadioButton mWoman;
    @BindView(R.id.radio_other)
    RadioButton mOther;
    //@BindView(R.id.spn_woman_district) Spinner mDistrict;
    //@BindView(R.id.spn_woman_division) Spinner mDivision;
    @BindView(R.id.txt_woman_fullname)
    EditText mFullName;
    // @BindView(R.id.txt_woman_opazila) EditText mOpazilla;
    //@BindView(R.id.txt_woman_union) EditText mUnion;
    @BindView(R.id.enter_number)
    EditText mMobile;
    static Button mLmpDate;
    static Button mDueDate;
    @BindView(R.id.txt_woman_cycle_time)
    EditText mCycleDay;
    @BindView(R.id.txt_woman_ovulation)
    EditText mOvulationDay;
    @BindView(R.id.txt_woman_prepregnancy)
    EditText mWeight;
    @BindView(R.id.txt_woman_prepregnancy_height)
    EditText mHeight;
    //@BindArray(R.array.divisions) String[] mDivisions;
    //@BindArray(R.array.dhaka_distric) String[] mDhakaDistricts;
    //@BindArray(R.array.ctg_distric) String[] mCtgDistricts;



    @BindView(R.id.spn_woman_district)
    Spinner mDistrict;
    @BindView(R.id.spn_woman_division)
    Spinner mDivision;
    @BindView(R.id.spn_woman_upazila)
    Spinner mUpazila;
    @BindView(R.id.spn_woman_union)
    Spinner mUnion;


    @BindArray(R.array.division_name)
    String[] mDivisions;
    @BindArray(R.array.dhaka_district_name)
    String[] mDhakaDistricts;
    @BindArray(R.array.chittagong_district_name)
    String[] mCtgDistricts;
    @BindArray(R.array.rajshahi_district_name)
    String[] mRajshahiDistricts;
    @BindArray(R.array.khulna_district)
    String[] mKhulnaDistricts;
    @BindArray(R.array.mymensingh_district)
    String[] mMymonDistrict;
    @BindArray(R.array.Rangpur_district)
    String[] mRangDistrict;
    @BindArray(R.array.sylhet_district_name)
    String[] mSylhetDistrict;
    @BindArray(R.array.barishal_district_name)
    String[] mBarishal;
    @BindArray(R.array.dhaka_upazila_list)
    String[] mDhaka_upazila_list;
    @BindArray(R.array.gajipur_upazila_list)
    String[] mGazipur;
    @BindArray(R.array.faridpur)
    String[] mfaridpur;
    @BindArray(R.array.gopal_upazila_list)
    String[] mGopal;
    @BindArray(R.array.kishor_upazila_list)
    String[] mKishor;
    @BindArray(R.array.madaripu_upazila_list)
    String[] mMadaripur;
    @BindArray(R.array.manik_upazila_list)
    String[] mManik;
    @BindArray(R.array.munshigang_upazila_list)
    String[] mMunshi;
    @BindArray(R.array.narayangang_upazila_list)
    String[] mNaraya;
    @BindArray(R.array.narsingdi)
    String[] mNarasi;
    @BindArray(R.array.razbari_upazila_list)
    String[] mRazbari;
    @BindArray(R.array.shariatpur_upazila_list)
    String[] mShariat;
    @BindArray(R.array.tangail)
    String[] mTangail;

    @BindArray(R.array.Joypurhat_Upazila)
    String[] mJoypurUnion;
    @BindArray(R.array.Akkelpur_Upazila)
    String[] mAkkel;
    @BindArray(R.array.Kalai_Upazila)
    String[] mKalai;
    @BindArray(R.array.Panchbibi_Upazila)
    String[] mPanch;
    @BindArray(R.array.Khetlal_Upazila)
    String[] mKhet;


    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_woman_registration);
        ButterKnife.bind(this);
        mDueDate = (Button) findViewById(R.id.btn_woman_due_date);
        mLmpDate = (Button) findViewById(R.id.btn_woman_lmp_date);
        db = new DatabaseHelper(this);

        Spinner spinner = (Spinner) findViewById(R.id.spn_woman_division);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.division_name, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

    }


    @OnItemSelected(R.id.spn_woman_division)

    public void spinnerItemSelected(Spinner spinner, int position) {
        Toast.makeText(this, position + " ", Toast.LENGTH_LONG).show();
        ArrayAdapter<String> adapter = null;
        switch (position) {
            case 0:
                adapter =
                        new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mDhakaDistricts);
                mDistrict.setAdapter(adapter);
                break;
            case 1:
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mCtgDistricts);
                mDistrict.setAdapter(adapter);
                break;
            case 2:
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mRajshahiDistricts);
                mDistrict.setAdapter(adapter);
                break;
            case 3:
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mSylhetDistrict);
                mDistrict.setAdapter(adapter);
                break;
            case 4:
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mBarishal);
                mDistrict.setAdapter(adapter);
                break;
            case 5:
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mKhulnaDistricts);
                mDistrict.setAdapter(adapter);
                break;
            case 6:
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mRangDistrict);
                mDistrict.setAdapter(adapter);
                break;
            case 7:
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mMymonDistrict);
                mDistrict.setAdapter(adapter);
                break;
            default:
                break;
        }
    }

    @OnItemSelected(R.id.spn_woman_district)

    public void spinnerItemSelected2(Spinner spinner2, int position2) {
        Toast.makeText(this, position2 + " ", Toast.LENGTH_LONG).show();
        ArrayAdapter<String> adapter = null;
        switch (position2) {
            case 0:
                adapter =
                        new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mDhaka_upazila_list);
                mUpazila.setAdapter(adapter);
                break;
            case 1:
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mNaraya);
                mUpazila.setAdapter(adapter);
                break;
            case 2:
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mNarasi);
                mUpazila.setAdapter(adapter);
                break;
            case 3:
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mKishor);
                mUpazila.setAdapter(adapter);
                break;
            case 4:
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mTangail);
                mUpazila.setAdapter(adapter);
                break;
            case 5:
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mfaridpur);
                mUpazila.setAdapter(adapter);
                break;
            case 6:
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mRazbari);
                mUpazila.setAdapter(adapter);
                break;
            case 7:
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mMunshi);
                mUpazila.setAdapter(adapter);
                break;
            case 8:
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mGopal);
                mUpazila.setAdapter(adapter);
                break;
            case 9:
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mMadaripur);
                mUpazila.setAdapter(adapter);
                break;
            case 10:
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mManik);
                mUpazila.setAdapter(adapter);
                break;
            case 11:
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mShariat);
                mUpazila.setAdapter(adapter);
                break;
            case 12:
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mGazipur);
                mUpazila.setAdapter(adapter);
                break;

            default:
                break;
        }
    }

    @OnItemSelected(R.id.spn_woman_upazila)

    public void spinnerItemSelected3(Spinner spinner3, int position3) {
        Toast.makeText(this, position3 + " ", Toast.LENGTH_LONG).show();
        ArrayAdapter<String> adapter = null;
        switch (position3) {
            case 0:
                adapter =
                        new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mJoypurUnion);
                mUnion.setAdapter(adapter);
                break;
            case 1:
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mKalai);
                mUnion.setAdapter(adapter);
                break;
            case 2:
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mKhet);
                mUnion.setAdapter(adapter);
                break;
            case 3:
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mAkkel);
                mUnion.setAdapter(adapter);
                break;
            case 4:
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mPanch);
                mUnion.setAdapter(adapter);
                break;


            default:
                break;
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        mLayoutWoman.setVisibility(View.GONE);
    }


    @OnClick(R.id.radio_woman)
    public void woman() {
        if (mWoman.isChecked()) {
            //flag=1;
            mOther.setChecked(false);
            mLayoutWoman.setVisibility(View.VISIBLE);
        }

    }

    @OnClick(R.id.radio_other)
    public void other() {
        if (mOther.isChecked()) {
            //flag = 0;
            mWoman.setChecked(false);
            mLayoutWoman.setVisibility(View.GONE);

        }
    }




    @OnClick(R.id.btn_woman_due_date) public void setmDueDate() {
        DialogFragment newFragment = new DueDatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @OnClick(R.id.btn_woman_lmp_date) public void setmLmpDateDate() {
        DialogFragment newFragment = new LmpDatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }



    @OnClick(R.id.btn_woman_save)
    public void save() {

        WomanRegistration womanRegistration = new WomanRegistration();
        womanRegistration.setFullName(mFullName.getText().toString());
        womanRegistration.setDivision(mDivision.getSelectedItem().toString());
        womanRegistration.setDistrict(mDistrict.getSelectedItem().toString());
        womanRegistration.setUnion(mUnion.getSelectedItem().toString());
        womanRegistration.setOpazila(mUpazila.getSelectedItem().toString());
        womanRegistration.setMobile(mMobile.getText().toString());

        if (mWoman.isChecked()) {
            try {
                womanRegistration.setLmpDate(mLmpDate.getText().toString());
                womanRegistration.setDueDate(mDueDate.getText().toString());


                womanRegistration.setPrePregnancyWeight(Float.parseFloat(mWeight.getText().toString().equals("") ? "0" : mWeight.getText().toString()));
                womanRegistration.setPrePregnancyHeight(Integer.parseInt(mHeight.getText().toString().equals("") ? "0" : mHeight.getText().toString()));
                womanRegistration.setCycleDays((int) Float.parseFloat(mCycleDay.getText().toString().equals("") ? "0" : mCycleDay.getText().toString()));
                womanRegistration.setOvulationDays((int) Float.parseFloat(mOvulationDay.getText().toString().equals("") ? "0" : mOvulationDay.getText().toString()));


            } catch (Exception e) {
                flag = 1;
                Toast.makeText(this, "Please Fill All The Field Correctly", Toast.LENGTH_SHORT).show();
            }
            db.addWoman(womanRegistration);
            if (flag == 0) {
                Intent intent = new Intent(getApplicationContext(), WomanActivity.class);
                startActivity(intent);
            }
        }
        else if(mOther.isChecked())
        {
            womanRegistration.setuser_choise(mOther.getText().toString());
            db.addWoman(womanRegistration);

            Intent intent = new Intent(getApplicationContext(), WomanActivity.class);
            startActivity(intent);

        }


    }




    public static class LmpDatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            mLmpDate.setText(day + "/" + (month + 1) + "/" + year);
        }
    }

    public static class DueDatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            mDueDate.setText(day + "/" + (month + 1) + "/" + year);
        }
    }
}

