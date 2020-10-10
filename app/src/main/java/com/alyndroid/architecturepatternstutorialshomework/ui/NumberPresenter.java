package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.model.NumberModel;

public class NumberPresenter {

    NumberInterface numberInterface;
    DataBase dataBase;

    public NumberPresenter(NumberInterface numberInterface) {
        this.numberInterface = numberInterface;
    }

    public void getNumbers(){
        dataBase =new DataBase();
        NumberModel model = dataBase.getNumbers();
        int num1 = model.getFirstNum();
        int num2 = model.getSecondNum();
        int division = num1 / num2;
        numberInterface.onGetNumbers(division);
    }

}
