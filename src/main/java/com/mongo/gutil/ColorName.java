package com.mongo.gutil;
public class ColorName {
    public static String getColorName(int c) {
        String name = "UNKNOWN";
        switch (c) {
            case 0:
                name ="SILVER" ;
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
                name = "GOLD";
                break;
            case 9:
                name= "BEIGE" ;
                break ;
            case 10:
                name="BROWN" ;
                break ;
            case 11:
                name="DARKKHAKI" ;
                break ;
            case 12:
                name="DARKORANGE" ;
                break ;
            case 13:
                name="ALICEBLUE" ;
                break ;
            case 14:
                name="CHOCOLATE" ;
                break ;
            case 15:
                name="OLIVE" ;
                break ;
            case 16:
                name="LIGHTGRAY" ;
                break ;
            case 17:
                name="TURQUOISE" ;
                break ;
            case 18:
                name="PLUM" ;
                break ;
            case 19:
                name="DEEPSKYBLUE" ;
                break ;
            case 20:
                name="SALMON" ;
                break ;
            case 21:
                name="DARKGREEN" ;
                break ;

        }
        return name;
    }
}