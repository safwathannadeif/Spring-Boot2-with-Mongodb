package com.mongo.gutil;
public class ColorName {
    public static String getColorName(int c) {
        String name = "UNKNOWN";
        switch (c) {
            case 0:
                name ="AMBER" ;
                break ;
            case 1:
                name = "BLACK";
                break;
            case 2 :
                name = "BLUE";
                break;
            case 3:
                name = "GREEN";
                break;
            case 4:
                name = "CYAN";
                break;
            case 5:
                name = "RED";
                break;
            case 6:
                name = "MAGENTA";
                break;
            case 7:
                name = "YELLOW";
                break;
            case 8:
                name = "WHITE";
                break;
            case 9:
                name= "BEIGE" ;
                break ;
            case 10:
                name="BROWN" ;
                break ;
        }
        return name;
    }
}