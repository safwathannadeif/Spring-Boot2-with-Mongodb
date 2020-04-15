package com.mongo.gutil;
public class TestSeqGen {

        public static void main(String[] args) {
            Long lll = Long.MAX_VALUE ;
            System.out.println("MAX:" + lll) ;
            SequenceGenerator sequenceGenerator = new SequenceGenerator() ;
            Long ll = sequenceGenerator.nextId() ;
            System.out.println(ll) ;
            int noOfTest =2 ;
            while ( noOfTest > 0 ) {
                ll = sequenceGenerator.nextId() ;
                System.out.println(ll) ;
                noOfTest-- ;
            }
    }
}
