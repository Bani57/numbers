package com.endava.numbers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
public class NumberController {

    @Autowired
    private NumberCollection numberCollection;

    @RequestMapping("/")
    public String home()
    {
        return "/numbers - Show all numbers\n/average - Show average of numbers\n/clear - Clear list of numbers\n/add - Add a number";
    }

    @RequestMapping("/numbers")
    public ArrayList<NumberInput> getNumbers()
    {
        return numberCollection.getNumberList();
    }

    @RequestMapping("/average")
    public Float getAverage()
    {
        return numberCollection.getAverage();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addNumber(@RequestBody @Valid NumberInput numberInput)
    {
        numberCollection.addNumber(numberInput);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/clear")
    public void clearList()
    {
        numberCollection.clearList();
    }
}
