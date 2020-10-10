package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.model.NumberModel;

public class DataBase {

    /*NumberInterface anInterface;

    public DataBase(NumberInterface anInterface) {
        this.anInterface = anInterface;
    }*/

    public NumberModel getNumbers(){
        return new NumberModel(4, 2);
    }

    /*public void getNumber(){
        anInterface.onGetNumbers(getNumbers());
    }*/
}
