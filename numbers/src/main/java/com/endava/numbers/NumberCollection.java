package com.endava.numbers;

import java.util.ArrayList;

public class NumberCollection {
    private ArrayList<Float> numberList;
    private Float numberSum;

    public NumberCollection() {
        numberList=new ArrayList<Float>();
        numberSum=(float)0;
    }

    public ArrayList<Float> getNumberList() {
        return numberList;
    }

    public void setNumberList(ArrayList<Float> numberList) {
        this.numberList = numberList;
    }

    public Float getNumberSum() {
        return numberSum;
    }

    public void setNumberSum(Float numberSum) {
        this.numberSum = numberSum;
    }

    public void addNumber(Float number) {
        numberList.add(number);
        numberSum+=number;
    }
    public void clearList()
    {
        numberList.clear();
        numberSum=(float)0;
    }
    public Float getAverage()
    {
        return numberSum/numberList.size();
    }
}
