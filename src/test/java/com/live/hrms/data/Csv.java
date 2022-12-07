package com.live.hrms.data;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Csv {
    String filePath = null;
    public void connectionCSV(String csvFileName) {
        BufferedReader br = null;
        try {
            String fileName = csvFileName + ".csv";
            filePath = System.getProperty("user.dir") + "//src//test//resources//Data//" + fileName;

            //File path = null;
            boolean flag = (new File(filePath).exists());
            if (!flag) {
                //path = new File(filePath);
            }
            br = new BufferedReader(new FileReader(filePath));
        }catch (Exception var1) {
            System.out.println("Exception - " + var1);
        }
        finally{
            if (br != null){
                try{
                    br.close();
                }catch (IOException var1){
                    System.out.println("Exception " + var1);
                }
            }
        }
    }


    public HashMap readData(String key){

        HashMap<Integer, String> data = new LinkedHashMap();
        HashMap<String, String> data1 = new LinkedHashMap();
        int counter = 1;
        String valueName = null;
        try{
            Reader in = new FileReader(filePath);
            Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);

            for(Iterator var2 = records.iterator(); var2.hasNext(); ++counter){
                CSVRecord record = (CSVRecord)var2.next();
                int j;
                if(counter == 1){
                    for(j = 0; j < record.size();++j){
                        data.put(j,record.get(j));
                    }
                }
                if(key.equalsIgnoreCase(record.get(0))){
                    for(j = 0; j < data.size();++j){
                        try{
                            if(record.get(j).trim().startsWith("#")){
                                valueName = record.get(j).substring(1);
                                data1.put(data.get(j),valueName);
                            }else{
                                data1.put(data.get(j),record.get(j));
                            }
                        }catch(Exception var3){
                            data.put(j, (String)null);
                        }
                    }
                }
            }
        } catch(IOException val1){
            System.out.println("Exception " + val1);
        }
        return data1;
    }

}
