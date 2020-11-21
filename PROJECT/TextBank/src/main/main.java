package main;

import DataService.DataOperator;

public class main {
    public static void main(String[] args) {
        DataOperator dataOperator=new DataOperator();
        int c=dataOperator.getCount();
        System.out.println(c);
    }
}
