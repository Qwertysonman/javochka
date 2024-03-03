package sample;
import java.util.Arrays;
import java.util.Scanner;

import static sample.Const.OPERATIONS_MATRIX;

public class ArrayPI {
    Scanner scan = new Scanner(System.in);
    public int[][] setMat(int size_x, int size_y) {
        System.out.println("Введите вашу матрицу");
        int[][] read_mat = new int[size_x][];
        for (int i = 0; i < size_x; i++) {
            String[] inputArr = this.scan.nextLine().split(" ");
            while(inputArr.length != size_y){
                System.out.println("Не корректное колличество введенных чисел");
                inputArr = this.scan.nextLine().split(" ");
            }
            int[] inputArr_int = new int[size_y];
            try{
                for(int j = 0; j < size_y; j++){
                    inputArr_int[j] = Integer.parseInt(inputArr[j]);
                }
                read_mat[i] = inputArr_int;
            }catch(Exception e){
                System.out.println("Введены не корректные числа или вообще блин не числа");
                i--;
            }
        }
        return read_mat;
    }
    public void getMat(int[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void getMat(String[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static String matrixToString(int[][] matrix) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]);
                if (j < matrix[i].length - 1) {
                    sb.append(" ");
                }
            }
            if (i < matrix.length - 1) {
                sb.append("\n");
            }
        }

        return sb.toString() + '\n';
    }

    public static String[][] stringToMatrix(String matrixString) {
        matrixString = matrixString.substring(1, matrixString.length());
        String[] rows = matrixString.split("\n");
        int rowCount = rows.length - 1;
        int colCount = rows[0].split(" ").length;

        String[][] matrix = new String[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            String[] elements = rows[i].split(" ");
            for (int j = 0; j < colCount; j++) {
                try {
                    matrix[i][j] = elements[j];
                }catch (Exception e){
                    break;
                }
            }
        }
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
    public String[][] redo(String[][] data){
        String[][] tabs = {{OPERATIONS_MATRIX, " ", " ", " ", " ", " ", " "}, {" ", " ", " ", " ", " ", " ", " "}};
        for(int i = 0; i < data.length; i++){
            tabs = this.mergeArrays(tabs, this.stringToMatrix(Arrays.toString(data[i])));
        }
        return tabs;
    }

}
