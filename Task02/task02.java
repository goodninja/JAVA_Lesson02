// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

package Task02;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class task02 {
    public static void main(String[] args) {
        int [] checkArray = { 8, 4, 5, 1, 3, 7, 0, 6, 2, 9 };
       
        massiveOutput(checkArray);
        System.out.println();
        bubbleSorting(checkArray);
        massiveOutput(checkArray);
        System.out.println();
    }

    public static void massiveOutput (int[] massive) {
        for (int i = 0; i < massive.length; i++){
            System.out.print(massive[i]);
            if(i < massive.length - 1) {
                System.out.print(", ");
            }
        }
    }

    public static void bubbleSorting (int[] massive) {
        boolean isSorted = false;
        int temp;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < massive.length - 1; i++) {
                if (massive[i] > massive[i+1]) {
                    isSorted = false;
                    temp = massive[i];
                    massive[i] = massive[i+1];
                    massive[i+1] = temp;

                    String str = Arrays.toString(massive);
                    try (FileWriter fileWriter = new FileWriter("log_task02.txt", true)) {
                        fileWriter.write(str);            
                        fileWriter.append('\n');
                        fileWriter.flush();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }
    }
}
