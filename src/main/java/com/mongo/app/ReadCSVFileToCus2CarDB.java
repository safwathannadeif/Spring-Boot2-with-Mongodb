/**** https://www.mockaroo.com/schemas/download */
package com.mongo.app;

import com.mongo.entity.Customer2;
import com.mongo.gutil.SequenceGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;
//Fields : id,first_name,last_name,email,gender,street,postal ,city ,phone number,states ,company ,sss
import static java.util.stream.Collectors.toList;

public class ReadCSVFileToCus2CarDB {
    //C:\DataFiles\MOCK_DATA2.csv
    // read lines once
    private static SequenceGenerator sequenceGenerator = new SequenceGenerator() ;

    public static void main(String[] args) throws IOException {

//        String path = "C:\\DataFiles\\MOCK_DATA2.csv";
//        try (Stream<String> lines = Files.lines(Paths.get(path))) {
//            List<Customer2> lisout = lines.map(l -> new Customer2(l.split(",",11))).collect(toList());
//            lisout.forEach(c-> debugRead(c) ) ;
//        }
    }
private static void debugRead(Customer2 cdb) {
        System.out.println(cdb.toString());
}
}
