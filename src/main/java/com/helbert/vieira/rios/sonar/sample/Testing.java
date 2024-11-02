package com.helbert.vieira.rios.sonar.sample;

import java.util.Date;

public class Testing {
    public static void main(String[] args) {
        Date date = new Date();  // Noncompliant
        date.toInstant();
    }
}
