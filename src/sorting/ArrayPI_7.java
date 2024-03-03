package sorting;
import java.util.Arrays;
import java.util.Scanner;

import static sample.Const.OPERATIONS_MATRIX;

public class ArrayPI_7 {
    Scanner scan = new Scanner(System.in);
    public int[] setMasiv() {
        System.out.println("Введите ваш массив");
        int[] masiv_sort;
        while (true) {
            String elements = scan.nextLine();
            String[] masiv_sort_1 = elements.split(" ");
            masiv_sort = new int[masiv_sort_1.length];
            try {
                for (int i = 0; i < masiv_sort_1.length; i++) {
                    masiv_sort[i] = Integer.parseInt(masiv_sort_1[i]);
                }
                break;
            } catch (Exception e) {
                System.out.println("Что - то проблемка с вашим массивом, проверь его еще разок");
            }
        }
        return masiv_sort;
    }
    public void getMasiv(int[] masiv_sort) {
        for (int i = 0; i < masiv_sort.length; i++){
            System.out.print(masiv_sort[i] + " ");
        }
        System.out.println(" ");
    }
    public String matrixToString(int[] masiv_sort) {
        String masiv_sort_string = "";
        String element = "";
        for (int i = 0; i < masiv_sort.length; i++){
            element = String.valueOf(masiv_sort[i]);
            masiv_sort_string = masiv_sort_string + " " + element;
        }
        return masiv_sort_string;
    }

    public static String[][] stringToMatrix(String matrixString) {
        matrixString = matrixString.trim();
        String[] mas_strok = matrixString.split(" ");
        String[][] matrix = new String[1][mas_strok.length];
        matrix[0] = mas_strok;
        return matrix;
    }
    public String[][] mergeArrays(String[][] a, String[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int rowsB = b.length;

        String[][] mergedArray = new String[rowsA + rowsB + 1][colsA];

        for (int i = 0; i < rowsA; i++){
            for (int j = 0; j < colsA; j++){
                mergedArray[i][j] = a[i][j];
            }
        }
        for (int j = 0; j < colsA; j ++){
            mergedArray[rowsA][j] = " ";
        }
        for (int i = 0; i < rowsB; i++){
            for (int j = 0; j < colsA; j++){
                try {
                    mergedArray[rowsA + 1 + i][j] = b[i][j];
                }catch (Exception e){
                    break;
                }
            }
        }
        return mergedArray;
    }
    public int check_max(String[] data){
        for (int i = 0; i < data.length; i++){
            System.out.println(data[i]);
        }
        return 4;
    }

    public String[][] redo(String[] data, int max_len){
        String[] tabik_1 = new String[max_len];
        String[] tabik_2 = new String[max_len];
        Arrays.fill(tabik_1, " ");
        Arrays.fill(tabik_2, " ");
        tabik_1[0] = OPERATIONS_MATRIX;
        String[][] tabs = {tabik_1, tabik_2};
        for (int i = 0; i < data.length; i++){
            tabs = this.mergeArrays(tabs, this.stringToMatrix(data[i]));
        }
        return tabs;
    }
}
