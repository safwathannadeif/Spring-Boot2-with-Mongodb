/*
 *  Here  the Algorithm  based on Numbering System for Base 26 :
 *  where min Value=0 and max Value =25
 *  use Cases for Input Length : min=1 and Max=26
 * for alphabet a,b,c,d,...,z say given string "bcac", then it can be represented as:
 *       the first char in the string is b. the index of first char from the inp string is 0, and the index value of b  from alphabet is 1 then R0= 1*26^0
 *       the second char in the string is c. the index of second char from the inp string is 1, and the index value of c  from alphabet is 2 then R1= 2*26^1
 *       the third char in the string is a. the index of second char from the inp string is 2, and the index value of a  from alphabet is 0 then R2= 0*26^2
 *       the 4th char in the string is c. the index of 4th char from the inp string is 3, and the index value of c  from alphabet is 2 then R3= 2*26^3
 *       The int value of "bcac" is R0+R1+R2+R3
 *       if the reverse algo  (int to alphabet) applied, the int value 0 - 10000000000000...  can produce unique string
 */
package com.mongo.app.urgenerator;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.math.BigInteger.*;
public class GenerateUniqueStr {
    public static final int BASE=26 ;
    public static BigInteger BigBase= valueOf(26) ;
    private static final char[] alphabetToCharArray = ("zyxwvutsrqponmlkjihgfedcba").toCharArray();
    public static BigInteger[] intOuResAndRemin = new BigInteger[2] ;
    private static  int lenRequired  ;
    public static BigInteger[] encodedAry  ;
    public static BigInteger curValueToEncodUP ;
    public static BigInteger curValueToEncodDN ;
    public static BigInteger curValueToEncod ;
    public static Boolean dirDn = true ;
    public static BigInteger maxNumToGenrate ;

    private static StringBuilder sb = new StringBuilder() ;

    public static void main(String[] args) {
       // BigInteger ValuOf26P26 = BigDecimal.valueOf(Math.pow(26, 26)).toBigInteger();
       System.out.println( "Length Of AlphabetArray= [" + alphabetToCharArray.length+"]") ;
        GenerateUniqueStr generateUniqueStri = new GenerateUniqueStr(1,"j") ;
        int counter = 1;
       // for (int t=0 ; t <= maxNumToGenrate.intValue(); t++) {
          for (int t=0 ; t <= 9 ; t++) {
            System.out.println("t Counter :[" + counter + "]") ;
            String outStr = generateUniqueStri.getNextStr();
            System.out.println("String Result:[" + outStr +"] [ curValueToEncod=" + curValueToEncod  + "] [" + !dirDn + "]") ;
            System.out.println("String To Bigvalue Revers output:[" + generateUniqueStri.valueAsBigIntFrmOutStr(outStr) + "]") ;
            //Check:
            BigInteger decodedValue = decode26(encodedAry);
            if ( decodedValue.compareTo(curValueToEncod) != 0 ) {
                throw new RuntimeException("Encode Value Not Match Decode value Encode/Decode:" + curValueToEncod + "/" + decodedValue) ;
            }
           // System.out.println("Decode26 Check inToEncode/outbackeFromDecode =" + curValueToEncod + "/" + decodedValue);
            ++counter ;
        }
    }
    private GenerateUniqueStr() { }
    //Constructor for fresh generation
    public GenerateUniqueStr(int lengthi) {
        commonConstructor(lengthi) ;
        BigInteger starValue =maxNumToGenrate.divide(valueOf(2l)) ;
        curValueToEncodUP=starValue ;
        curValueToEncodDN=starValue.add(valueOf(1l) ); //Adjust First DN to start with the startValue
        System.out.println("curValueToEncodDN / curValueToEncodUP/starValue" + curValueToEncodDN+"/"+curValueToEncodUP+"/" + starValue) ;
    }
    //Constructor To Resume Generation and Continuity after subsequent
    public GenerateUniqueStr(int lengthi,String lastOutStr) {
        commonConstructor(lengthi) ;
        BigInteger startValue =maxNumToGenrate.divide(valueOf(2l)) ;
        BigInteger lastInt = valueAsBigIntFrmOutStr(lastOutStr);
        dirDn = startValue.compareTo(lastInt) == 1 ? true:false ;
        if (dirDn) {
            BigInteger diff = startValue.subtract(lastInt) ;
            curValueToEncodDN = lastInt ;
            curValueToEncodUP= startValue.add(diff) ;
        } else {
            BigInteger diff = lastInt.subtract(startValue) ;
            curValueToEncodUP=lastInt ;
            curValueToEncodDN = startValue.subtract(diff).add(ONE) ;
        }
        dirDn = !dirDn;
    }
    private void commonConstructor(int lengthi) {
        lenRequired = lengthi ;
        if ( lenRequired < 1 || lenRequired > BASE ) throw new RuntimeException("Length Range should be: 1-26. Inp-Length:" + lenRequired + " is OutSide Range.");
        encodedAry = new BigInteger[lenRequired] ;
        maxNumToGenrate = maxToGenerate(lenRequired) ;
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
            curValueToEncodDN =curValueToEncodDN.subtract(ONE) ;
            curValueToEncod= curValueToEncodDN ;
        }
        else
        {
            curValueToEncodUP = curValueToEncodUP.add(ONE) ;
            curValueToEncod= curValueToEncodUP ;
        }
        dirDn=!dirDn ;
        if (curValueToEncod.compareTo(valueOf(0l)) == -1 || curValueToEncod.compareTo(maxNumToGenrate) == 1 )
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
            encodedAry[power4EncodeBase26] = intOuResAndRemin[0] ;   //value 0-26 and the power of 26 =index(lenRequired-1 to 0 )
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
        BigInteger noOf26s = valueOf(1l);
        for ( int k =0 ; k< power; k++ )  {
            noOf26s = noOf26s.multiply(valueOf(26l)) ;
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
        BigInteger pow = ONE ;
        BigInteger decodeValue =  valueOf(0l) ;
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
            tmpIntAry[j] = valueOf(BASE-1) ;
        }
        BigInteger maxToGen = decode26(tmpIntAry) ;
        System.out.println("Maximum No To Generate:[" + maxToGen +"]");
        return maxToGen ;
    }
    public BigInteger valueAsBigIntFrmOutStr(String inpStr)
    {
        // result Int is the sum  = CharValue*26^n where n is the index num in the inpStr
        // CharValue is calculted from charToIntValueFromAlphabetToCharArray procedure
        char[] chrAry = inpStr.toCharArray();
        List<Long> lisOfIntg = IntStream.range(0,chrAry.length).mapToObj(i-> charToIntValueFromAlphabetToCharArray(chrAry[i])).collect(Collectors.toList()) ;
        BigInteger resultBI = valueOf(0l);
        BigInteger powerOf26 = valueOf(0l);
       // IntStream.range(0,lisOfIntg.size()).reduce(i-> lisOfIntg[i]*Math.pow(i)
        for ( int i=0 ; i< lisOfIntg.size(); ++i) {
            powerOf26 = powerOf26.multiply(BigBase) ;
            powerOf26 = (i == 0 ) ? BigInteger.ONE:powerOf26 ;
            resultBI = resultBI.add( powerOf26.multiply(BigInteger.valueOf(lisOfIntg.get(i)))  ) ;
        }

        return resultBI ;
    }
    //Int Value of Char:for inp c ==> range[z-a] values are z=0,y=1,... and a=25 as per the alphabetToCharArray seuence order
    public  Long charToIntValueFromAlphabetToCharArray(char c) {  //
        long ix = -1;
        int seqInArray = 0 ;
        while (ix == -1) {
           if( alphabetToCharArray[seqInArray] == c ) ix=seqInArray ;
           ++seqInArray ;
        }
        return ix ;
    }


}