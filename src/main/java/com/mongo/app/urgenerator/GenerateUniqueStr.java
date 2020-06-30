/*
*  Here  the Algorithm  based on Numbering System for Base 26 :
*  where min Value=0 and max Value =25
*  use Cases for Input Length : min=1 and Max=26
*/
package com.mongo.app.urgenerator;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class GenerateUniqueStr {
    public static final int BASE=26 ;
    public static BigInteger BigBase= BigInteger.valueOf(26) ;
    private static final char[] alphabetToCharArray = ("zyxwvutsrqponmlkjihgfedcba").toCharArray();     //?? no need zyxw
    public static BigInteger[] intOuResAndRemin = new BigInteger[3] ;
    private static  int lenRequired  ;
    public static BigInteger[] encodedAry  ;
    public static BigInteger curValueToEncodUP ;
    public static BigInteger curValueToEncodDN ;
    public static BigInteger curValueToEncod ;
    public static Boolean dirDn = true ;
    public BigInteger maxNumToGenrate ;

    private static StringBuilder sb = new StringBuilder() ;

    public static void main(String[] args) {
        BigInteger ValuOf26P26 = BigDecimal.valueOf(Math.pow(26, 26)).toBigInteger();
       // System.out.println( "ValuOf26P26 and ValuOf26P26toStr:["+ ValuOf26P26+"] [" + ValuOf26P26.toString() +"]") ;
        GenerateUniqueStr generateUniqueStri = new GenerateUniqueStr(4) ;  //18 Looks OK
        for (int t=0 ; t < 100000; t++) {
            String outStr = generateUniqueStri.getNextStr();
            System.out.println("String Result:[" + outStr +"]");
            //Check:
            BigInteger decodedValue = decode26(encodedAry);
            if ( decodedValue.compareTo(curValueToEncod) != 0 ) {
                throw new RuntimeException("Encode Value Not Match Decode value Encode/Decode:" + curValueToEncod + "/" + decodedValue) ;
            }
           // System.out.println("Decode26 Check inToEncode/outbackeFromDecode =" + curValueToEncod + "/" + decodedValue);
        }
    }
    private GenerateUniqueStr() { }
    public GenerateUniqueStr(int lengthi) {
        lenRequired = lengthi ;
        encodedAry = new BigInteger[lenRequired] ;
        maxNumToGenrate = maxToGenerate(lengthi) ;
        BigInteger starValue =maxNumToGenrate.divide(BigInteger.valueOf(2l)) ;
        curValueToEncodUP=starValue ;
        curValueToEncodDN=starValue.add(BigInteger.valueOf(1l) ); //Adjust Firist DN to start with the startValue
        System.out.println("Max BigInteger :[" + maxNumToGenrate +"]") ;
    }
    public  String  getNextStr()   {
        getNextEncodedValue() ;
        sb.setLength(0);
        for (int inx =0 ; inx < encodedAry.length ; inx++) {
            //System.out.println("inx/leng" + inx +"/" +  encodedAry.length) ;
            sb.append(alphabetToCharArray[encodedAry[inx].intValue()]) ;
        }
        return sb.toString() ;
    }
    public void getNextEncodedValue()  {
        if (dirDn) {
            curValueToEncodDN =curValueToEncodDN.subtract(BigInteger.ONE) ;
            curValueToEncod= curValueToEncodDN ;
        }
        else
        {
            curValueToEncodUP = curValueToEncodUP.add(BigInteger.ONE) ;
            curValueToEncod= curValueToEncodUP.add(BigInteger.ONE) ;
        }
        dirDn=!dirDn ;
        if (curValueToEncod.compareTo(BigInteger.valueOf(0l)) == -1 || curValueToEncod.compareTo(maxNumToGenrate) == 1 )
        {
            System.out.println ("Excessded  value = " + curValueToEncod  ) ;
           throw new RuntimeException("Max No Already generated. No More uniqiue value for the given length") ;
        }
        encodeBase26(curValueToEncod) ;
    }
    public static void encodeBase26(BigInteger inpx)  {
        int power4EncodeBase26 = lenRequired -1 ;
        if (power4EncodeBase26==0) {
            encodedAry[0] = inpx ;
            return ;
            //   encodedAry[1] = 0l ;
        }
        BigInteger inpToEncode= inpx ;
        while ( power4EncodeBase26 >= 1)
        {
            DivideByP26(inpToEncode,power4EncodeBase26) ;
            encodedAry[power4EncodeBase26] = intOuResAndRemin[0] ;
            inpToEncode=intOuResAndRemin[1] ;
            --power4EncodeBase26 ;
        }
        encodedAry[0] =intOuResAndRemin[1] ; //reminder index=1 of the array intOuResAndRemin
        //
        //String enocdeDisplay = Stream.of(encodedAry).map(a -> String.valueOf(a)).collect(Collectors.joining("/"));

        //System.out.println("EnocodecResult:[" + enocdeDisplay+"]" ) ;

    }
    public static void DivideByP26(BigInteger dividend, int power) {
/*
            Dividend - The dividend is the number you are dividing up for Encoding
	        Divisor - The divisor is the Base == 26
	        Quotient - The quotient is the answer -- return in array[0]
	        Remainder - the R return in array[1]
*/
        BigInteger noOf26s = BigInteger.valueOf(1l);
        for ( int k =0 ; k< power; k++ )  {
            noOf26s = noOf26s.multiply(BigInteger.valueOf(26l)) ;
        }

        BigInteger  quotient = dividend.divide(noOf26s);
        BigInteger  remainder = dividend.subtract(quotient.multiply(noOf26s));
        intOuResAndRemin[0] = quotient ;
        intOuResAndRemin[1] = remainder;
        return  ;
    }
    public static BigInteger  decode26(BigInteger[] encodedIntAry) {
        //Check:
        int i=0 ;
        BigInteger pow = BigInteger.ONE ;
        BigInteger decodeValue =  BigInteger.valueOf(0l) ;
        while ( i <= lenRequired-1 ) {
            BigInteger tt = encodedIntAry[i].multiply(pow) ;
            decodeValue = decodeValue.add(tt);
            pow= pow.multiply(BigBase)  ;
            //System.out.println("ipow value=" + pow) ;
            ++i ;
        }
        return decodeValue ;
    }
    private BigInteger maxToGenerate(int leni) {
        BigInteger [] tmpIntAry = new BigInteger[leni] ;
        for(int j=0 ; j< leni ; j++) {
            tmpIntAry[j] = BigInteger.valueOf(BASE-1) ;
        }
        BigInteger maxToGen = decode26(tmpIntAry) ;
        System.out.println("Maximum No To Generate:[" + maxToGen +"]");
        return maxToGen ;
    }
}