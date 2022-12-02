// В файле содержится строка с данными:
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
// {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

package Task03;

import java.io.BufferedReader;
import java.io.FileReader;

public class task03 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferReader = new BufferedReader(new FileReader("task03.txt"));
        String data;
        StringBuilder stringBuilder = new StringBuilder();
        while ((data = bufferReader.readLine()) != null) {
            System.out.println(data);
            data = data.substring(1, data.length() - 1);
            data = data.replaceAll("\\{", "");
            data = data.replaceAll("\\}", "");
            String[] newData = data.split(", ");
            
            for (int i = 0; i < newData.length; i++) {
                String[] newData1 = newData[i].split(",");
                
                for (int j = 0; j < newData1.length; j++) {
                    String[] newData2 = newData1[j].split(":");
                    String key = newData2[0];
                    key = key.substring(1, key.length() - 1);
                    String value = newData2[1];
                    value = value.substring(1, value.length() - 1);
                    stringBuilder.append(value);
                    stringBuilder.append(" ");
                }
            }
        }
        String[] stringArray = stringBuilder.toString().split(" ");
        for (int i = 0; i < stringArray.length; i += 3) {
            System.out.println("Студент " + stringArray[i] + " получил " + stringArray[i + 1]
                                + " по предмету " + stringArray[i + 2] + ".");
        }
        try {
            if (bufferReader != null) {
                bufferReader.close();
            }
        } catch (Exception e) {
            System.out.println("Reading file error");
        }
    }
}