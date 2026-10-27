package com.pluralsight;

import java.util.ArrayList;

public class ForEachApp {

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        ArrayList<String> moreStrings = new ArrayList<String>();

        strings.add("Aaron");
        strings.add("Blake");
        strings.add("Jaquilin");

        moreStrings.add("Dave");
        moreStrings.add("Dave");
        moreStrings.add("Dave");

        for ( String currentString : strings) {
            System.out.println(currentString);
        }
    }


}
