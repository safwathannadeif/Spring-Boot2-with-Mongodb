/***
 * https://www.minus40.info/sky/alphabetcountdec.html
 */
package com.mongo.app.urgenerator;
import com.mongo.gutil.SequenceGenerator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class GenerateUR {
    private static char[] alphabetToCharArray = ("zyxwvutsrqponmlkjihgfedcbazyxw").toCharArray();
    private static List<Integer> grpOffest = Arrays.asList(0, 10, 20);
    private static StringBuffer sb = new StringBuffer(0);
    private static SequenceGenerator sg = new SequenceGenerator();
    private static final Set<String> set1 = new HashSet<String>();
   // private static long wrkCurValue = 9012345678l ;
    private static long wrkCurValue = 500l ;
    private static long curIncValue= wrkCurValue ;
    private static long curDecValue= wrkCurValue ;
    private static Boolean  incrb = true ;
    //inp
    private static  int inpLen = 3 ;
    private static Long MaxValue= Long.MAX_VALUE ;
    private static Long MinValue= Long.MIN_VALUE ;

    public static void main(String[] args) {
        //// Math.log(x) / Math.log(2)
        Double dd = Math.log(25.0)/Math.log(26.0) ;
        System.out.println(dd) ;
        List<String> lisOut =
                IntStream.range(0, 99).mapToObj(i -> nextIntToStr()).map(s-> uniqStr(s)).collect(Collectors.toList());
       // lisOut.stream().forEach(str1 -> System.out.println(str1) ) ;
        /* fpor 18 wifth Chras this one is used
        List<String> lisOut =
                IntStream.range(0, 201001).mapToObj(i -> sg.nextIdStr()).collect(Collectors.toList());
        lisOut.stream().forEach(str1 -> {
                    String str2 = uniqStr(str1);
                    System.out.println("Adding [" + str2 + "]");
                    Boolean ret = set1.add(str2);
                    if (!ret) {
                        throw new RuntimeException("Duplicated  =" + str2);
                    }
                }
        );

        System.out.println("Final Size [" + set1.size() + "]");
        ///
        String ss = sg.nextIdStr();
        System.out.println("Size ss [" + ss.length() + "]" + ss);
        String s1 = uniqStr(sg.nextIdStr());
        Boolean ret = set1.add(s1);
        System.out.println("Size s1 [" + s1.length() + "]" + s1);
        if (!ret) {
            throw new RuntimeException("Duplicated  =" + s1);
        }
        ret = set1.add(s1);
        if (!ret) {
            throw new RuntimeException("Duplicated  =" + s1);
        }
        System.out.println("Final Size [" + set1.size() + "]");
        */
        ///
    }
    public static String nextIntToStr()
    {
        incrb = !incrb ;
       wrkCurValue=-1l;
        if (incrb) {
            wrkCurValue = incDir();
            if ( wrkCurValue==-1l)wrkCurValue =decDir() ;

        }
        else
        {
            wrkCurValue = decDir();
        }
        if ( wrkCurValue==-1l ) throw new RuntimeException("No more new Values" )  ;

      String outStr =   convToStrWithLength(wrkCurValue) ;

        return outStr ;
    }
    public static Long incDir() {
        if (curIncValue == MaxValue ) {
            System.out.println("Warning incDir reaches the maximum !!") ;
            return -1l ;
        }
        return (++curIncValue) ;
    }
    public static Long decDir() {
        if (curDecValue == MinValue ) {
            System.out.println("Warning decDir reaches the minimum !!") ;
            return -1l ;
        }
        return (--curDecValue) ;
    }
    public static String convToStrWithLength(Long ll) {
     //   System.out.println("InpNum:" + ll) ;
        String ssTemp = String.valueOf(ll) ;
        int diffi = ssTemp.length() - inpLen ;
        String sZeros = "" ;
        while (diffi > 0){
            sZeros = sZeros +"0" ;
           --diffi ;
        }
        String outStr =  sZeros+ssTemp ;
      //  System.out.println("OutStr:" + outStr) ;
        return(outStr) ;
    }
    public static String uniqStr(String ss) {
        String[] strAry = ss.split("");
        List<String> lisOfStr = Arrays.asList(strAry);
        ////            Collections.shuffle(lisOfStr);
        //   Collections.shuffle(Arrays.asList(ss.split(""))) ;
        sb.setLength(0);
        int countOFGrpOffestInx = -1;
        for (int i = 0; i < lisOfStr.size(); i++) {
            countOFGrpOffestInx++;
            if (countOFGrpOffestInx > 2) countOFGrpOffestInx = 0;
            Integer ingt = Integer.valueOf(lisOfStr.get(i));
            int inx = ingt + grpOffest.get(countOFGrpOffestInx);
            sb.append(alphabetToCharArray[inx]);
        }
        System.out.println("value/strout:" + ss +"/" + sb.toString() ) ;
        return (sb.toString());
    }
}
