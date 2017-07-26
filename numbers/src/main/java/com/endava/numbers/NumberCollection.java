package com.endava.numbers;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NumberCollection {
    private ArrayList<NumberInput> numberList=new ArrayList<>();
    private Float sum=(float)0;

    public void addNumber(NumberInput numberInput)
    {
        numberList.add(numberInput);
        sum+=numberInput.getNumber();
    }

    public ArrayList<NumberInput> getNumberList() {
        return numberList;
    }

    public void clearList()
    {
        numberList.clear();
        sum=(float)0;
    }
    public Float getAverage()
    {
        return sum/numberList.size();
    }
}
