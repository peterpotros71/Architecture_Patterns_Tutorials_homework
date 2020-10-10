package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;

import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.databinding.ActivityMainBinding;
import com.alyndroid.architecturepatternstutorialshomework.model.NumberModel;

public class MainActivity extends AppCompatActivity implements NumberInterface {

    ActivityMainBinding binding;
    NumberModel model;
    DataBase dataBase;
    NumberViewModel viewModel;
    NumberPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        dataBase = new DataBase();
        presenter = new NumberPresenter(this);

        viewModel = ViewModelProviders.of(this).get(NumberViewModel.class);
        viewModel.mutableLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer multiply) {
                binding.mulResultTextView.setText(multiply+"");
            }
        });

        binding.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum();
            }
        });

        binding.divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                divide();
            }
        });

        binding.mulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multiply();
            }
        });

    }

    private void sum(){
        model = dataBase.getNumbers();
        int num1 = model.getFirstNum();
        int num2 = model.getSecondNum();
        int sum = num1 + num2;
        binding.plusResultTextView.setText(sum+"");
    }

    private void divide(){
        presenter.getNumbers();
    }

    private void multiply(){
        viewModel.getModel();
    }

    @Override
    public void onGetNumbers(int division) {
        binding.divResultTextView.setText(division+"");
    }


}
