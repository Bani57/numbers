package com.endava.numbers;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;
public class NumberInput {
    @NotNull
    @Max(value = 1000,message = "The number you entered is too large.")
    @Pattern(regexp = "[0-9.]",message = "You didn't enter a number!")
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
