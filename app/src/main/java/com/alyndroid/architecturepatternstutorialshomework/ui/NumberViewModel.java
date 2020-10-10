package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alyndroid.architecturepatternstutorialshomework.model.NumberModel;

public class NumberViewModel extends ViewModel {

    MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
    DataBase dataBase;

    /*private NumberModel getNumbers(){
        return new NumberModel(4, 2);
    }*/

    public void getModel(){
        dataBase = new DataBase();
        NumberModel model = dataBase.getNumbers();
        int num1 = model.getFirstNum();
        int num2 = model.getSecondNum();
        int multipy = num1 + num1;
        mutableLiveData.setValue(multipy);
    }

}
