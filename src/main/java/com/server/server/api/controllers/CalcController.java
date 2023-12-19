package com.server.server.api.controllers;

import com.server.server.api.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import static com.server.server.utils.Numeric.*;
import static com.server.server.db.CalcDb.*;

@RestController
public class CalcController {
    @RequestMapping(value = "calc/{operation}/{num1}/{num2}", method = RequestMethod.GET)
    public double operation(
            @PathVariable(value = "operation") String operation,
            @PathVariable(value = "num1") String num1,
            @PathVariable(value = "num2") String num2
    ) {
        if (!isNumeric(num1) || !isNumeric(num2)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return switch (operation) {
            case "sum" -> sum(num1, num2);

            case "sub" -> sub(num1, num2);

            case "times" -> times(num1, num2);

            case "div" -> div(num1, num2);

            case "mean" -> mean(num1, num2);

            default -> throw new UnsupportedMathOperationException("Please set a valid operation!");
        };
    }

    @RequestMapping(value = "calc/sqrt/{num1}", method = RequestMethod.GET)
    public double operation(@PathVariable(value = "num1") String num1) {
        if (!isNumeric(num1)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return sqrt(num1);
    }
}