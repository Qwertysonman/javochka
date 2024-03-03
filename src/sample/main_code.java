package sample;

import java.util.Scanner;
import java.util.InputMismatchException;
import sample.dataconnect;
import sample.Handler;
import sample.Const;

public class main_code {
    public static void main(String[] args) throws Exception {
        System.out.println("Система такая: \n" + "1. Вводим команду \n" + "2. Нажимаем Enter \n" +
                "3. Вводим данные построчно (Enter - разделяет строчки), через пробел (при необходимости) \n");
        Scanner scan = new Scanner(System.in);
        String command_s = "0";
        int of_size = 7;
        String result = "";
        Matrix matrik = new Matrix();
        Handler handler = new Handler();
        Excelik exik = new Excelik();
        int[][] mat_1 = new int[of_size][of_size];
        int[][] mat_2 = new int[of_size][of_size];
        while (true) {
            System.out.println("Это калькулятор группы №2");
            System.out.println("Текущая активная таблица: " + Const.OPERATIONS_TABLE + "\n");
            System.out.println("Консольное меню:");
            System.out.println("1. Вывести все таблицы из MySQL.\n" +
                    "2. Создать таблицу в MySQL.\n" +
                    "3. Ввести две матрицы с клавиатуры и каждую из них сохранить в MySQL с последующим выводом в консоль.\n" +
                    "4. Перемножить матрицы, сохранить перемноженные матрицы в MySQL и вывести в консоль.\n"+
                    "5. Сохранить результаты из MySQL в Excel и вывести их в консоль.\n"
            );
            int command = 0;
            try {
                command_s = scan.nextLine();
                command = Integer.parseInt(command_s);
            } catch (Exception e) {
                System.out.println("Это не команда, бро");
                continue;
            }
            switch (command) {
                case 1:
                    System.out.println("Вот данные из таблиц: ");
                    handler.displayData();
                    break;
                case 2:
                    String name_table = handler.createNew();
                    System.out.println("Ура, мы создали таблицу " + name_table + "\n");
                    System.out.println("Если вдруг захотите переключатся между таблицами вводите команду - 11\n");
                    break;
                case 3:
                    mat_1 = matrik.setMat(of_size, of_size);
                    mat_2 = matrik.setMat(of_size, of_size);
                    System.out.println("Матрица №1");
                    matrik.getMat(mat_1);
                    System.out.println("Матрица №2");
                    matrik.getMat(mat_2);
                    handler.enterRes(matrik.matrixToString(mat_1));
                    handler.enterRes(matrik.matrixToString(mat_2));
                    break;
                case 4:
                    try {
                        if (matrik.cheak(mat_1, mat_2)) {
                            System.out.println("Недопустимые размеры исходных матриц (несоответсвтие строк / столбцов), Перемножить невохможно");
                        } else {
                            System.out.println("Результат умножения матриц:");
                            int[][] res = matrik.multiplication(mat_1, mat_2);
                            matrik.getMat(res);
                            handler.enterRes(matrik.matrixToString(res));
                        }
                    } catch (Exception e) {
                        System.out.println("Нельзя перемножить матрицы, которых вы еще не написали!!!");
                    }
                    break;
                case 5:
                    System.out.println("Введите имя файла Excel, в который перенесем все ваши данные (создастся этот файл)");
                    String excel_name = scan.nextLine();
                    String[][] data_table_1 = handler.selectAll(Const.OPERATIONS_TABLE);
                    String[][] data_table = matrik.redo(data_table_1);
                    exik.outputEx(data_table, excel_name);
                    System.out.println("Занеслись данные из текущей активной таблицы - " + Const.OPERATIONS_TABLE + ":");
                    System.out.println("Данные из таблицы Excel: " + excel_name);
                    exik.inputEx(excel_name);
                    break;
                case 11:
                    System.out.println("Введите название таблицы, на которую хотите переключится \n");
                    scan.nextLine();
                    String table_active = scan.nextLine();
                    String[] tabs = handler.listTable();
                    boolean found = false;
                    for (String nama : tabs) {
                        try {
                            if (nama.equals(table_active)) {
                                found = true;
                                break;
                            }
                        } catch (NullPointerException e) {
                            System.out.println("Бонобо справились");
                            break;
                        }
                    }
                    if (found) {
                        Const.OPERATIONS_TABLE = table_active;
                        found = false;
                    }
                    System.out.println("Текущая активная страница: " + Const.OPERATIONS_TABLE);
                    break;
                default:
                    scan.nextLine();
                    System.out.println("Неизвестная команда :(");
            }
        }
    }
}