/**** https://www.mockaroo.com/schemas/download */
package com.mongo.app;

import com.mongo.entity.Customer2CarDB;
import com.mongo.gutil.SequenceGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ReadCSVFileToCus2CarDB {
    //C:\DataFiles\MOCK_DATA2.csv
    // read lines once
    private static SequenceGenerator sequenceGenerator = new SequenceGenerator() ;

    public static void main(String[] args) throws IOException {
        String path = "C:\\DataFiles\\Try11.txt";
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            List<Customer2CarDB> lisout = lines.map(l -> new Customer2CarDB(l.split(",",11),sequenceGenerator.nextIdStr()))
                                                .collect(toList());
            lisout.forEach(c-> debugRead(c) ) ;
        }
    }
private static void debugRead(Customer2CarDB cdb) {
        System.out.println(cdb.toString());
}
}
