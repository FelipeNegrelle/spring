package com.server.server.db;

import com.server.server.api.exceptions.ResourceNotFoundException;

import static com.server.server.utils.Numeric.convertToDouble;

public class CalcDb {
    public static double sum(String num1, String num2) {
        try {
            final double n1 = convertToDouble(num1);
            final double n2 = convertToDouble(num2);

            return n1 + n2;
        } catch (NumberFormatException e) {
            throw new ResourceNotFoundException("Please set a numeric value!");
        }
    }

    public static double sub(String num1, String num2) {
        try {
            final double n1 = convertToDouble(num1);
            final double n2 = convertToDouble(num2);

            return n1 - n2;
        } catch (NumberFormatException e) {
            throw new ResourceNotFoundException("Please set a numeric value!");
        }
    }

    public static double times(String num1, String num2) {
        try {
            final double n1 = convertToDouble(num1);
            final double n2 = convertToDouble(num2);

            return n1 * n2;
        } catch (NumberFormatException e) {
            throw new ResourceNotFoundException("Please set a numeric value!");
        }
    }

    public static double div(String num1, String num2) {
        try {
            final double n1 = convertToDouble(num1);
            final double n2 = convertToDouble(num2);

            if (n2 == 0) throw new ResourceNotFoundException("You cannot divide by 0");

            return n1 / n2;
        } catch (NumberFormatException e) {
            throw new ResourceNotFoundException("Please set a numeric value!");
        }
    }

    public static double mean(String num1, String num2) {
        try {
            final double n1 = convertToDouble(num1);
            final double n2 = convertToDouble(num2);

            return (n1 + n2) / 2;
        } catch (NumberFormatException e) {
            throw new ResourceNotFoundException("Please set a numeric value!");
        }
    }

    public static double sqrt(String num1) {
        try {
            final double n1 = convertToDouble(num1);

            return Math.sqrt(n1);
        } catch (NumberFormatException e) {
            throw new ResourceNotFoundException("Please set a numeric value!");
        }
    }
}
