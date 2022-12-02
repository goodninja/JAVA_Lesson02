// 1. В файле содержится строка с исходными данными в такой форме:
// {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
// SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";

// Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder.
// Значения null не включаются в запрос.

package Task01;

import java.io.BufferedReader;
import java.io.FileReader;

public class task01 {
    
    public static void main (String[] args) throws Exception {
        
        BufferedReader bufferreader = new BufferedReader(new FileReader("task01.txt"));
        
        String data;
        StringBuilder stringbuilder = new StringBuilder();
        StringBuilder stringbuilder_key = new StringBuilder();
        String sNull = "null";
        
        while ((data = bufferreader.readLine()) != null) {
            System.out.printf ("%s\n", data);
            data = data.substring (1, data.length() - 1);
            String[] data_new;
            data_new = data.split(", ");
            String select = "SELECT * FROM students WHERE ";
            stringbuilder.append(String.format("%s", select));
            for (String dn : data_new) {
                String[] data_key;
                data_key = dn.split(":");
                String key = data_key[0];
                key = key.substring(1, key.length() - 1);
                String value = data_key[1];
                if ((value.substring(1, value.length() - 1)).equals(sNull) != true) {
                    stringbuilder_key.append(String.format(" AND %s = %s", key, value));
                }
            }
            String output = stringbuilder_key.toString();
            output = output.substring(5);
            stringbuilder.append(String.format("%s", output));
            System.out.println(stringbuilder);
        }  
        try {
            if (bufferreader != null)
            bufferreader.close();
        } catch (Exception e) {
            System.out.println("Reading file error");
        }       
    }
}