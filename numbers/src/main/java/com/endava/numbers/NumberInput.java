package com.endava.numbers;


public class NumberInput {
    private String type;
    private Integer length;
    private Integer[] data;
    public NumberInput() {
    }

    public NumberInput(String type, Integer length, Integer[] data) {
        this.type = type;
        this.length = length;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer[] getData() {
        return data;
    }

    public void setData(Integer[] data) {
        this.data = data;
    }

    public boolean equals(NumberInput numberInput)
    {
        int n=numberInput.getLength();
        boolean equal=true;
        for(int i=0;i<n;i++)
        {
            if(!numberInput.getData()[i].equals(data[i]))
            {
                equal=false;
                break;
            }
        }
        return equal;
    }
}
