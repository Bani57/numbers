package com.endava.numbers;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class NumberInput {
    @NotNull
    @Max(value = 1000,message = "The number you entered is too large!")
    private Float number;

    public NumberInput() {
    }

    public NumberInput(Float number) {
        this.number = number;
    }

    public Float getNumber() {
        return number;
    }

    public void setNumber(Float number) {
        this.number = number;
    }
}
