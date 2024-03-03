package sorting;

import sample.*;

import java.util.Scanner;

import static sample.ArrayPI.matrixToString;

public class main_code_7 {
    public static void main(String[] args) throws Exception {
        System.out.println("Система такая: \n" + "1. Вводим команду \n" + "2. Нажимаем Enter \n" +
                "3. Вводим данные построчно (Enter - разделяет строчки), через пробел (при необходимости) \n");
        Scanner scan = new Scanner(System.in);
        String command_s = "0";
        int of_size = 35;
        int max_len = 0;
        int var = 0;
        String var_s = "";
        String of_size_s = "";
        String result = "";
        int masiv[] = new int[0];
        ArrayPI_7 arrayPI7 = new ArrayPI_7();
        Sort_7 sort7 = new Sort_7();
        Handler_7 handler_7 = new Handler_7();
        Excelik_7 exik_7 = new Excelik_7();
        while (true) {
            System.out.println("Текущая активная таблица: " + Const_7.OPERATIONS_TABLE + "\n");
            System.out.println("Консольное меню:");
            System.out.println("1. Вывести все таблицы из MySQL.\n" +
                    "2. Создать таблицу в MySQL.\n" +
                    "3. Ввести одномерный массив и сохранить в MySQL с последующим выводом в консоль.\n" +
                    "4. Отсортировать массив и сохранить в MySQL с последующим выводом в консоль.\n"+
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
                    handler_7.displayData();
                    break;
                case 2:
                    String name_table = handler_7.createNew();
                    System.out.println("Ура, мы создали таблицу " + name_table + "\n");
                    System.out.println("Если вдруг захотите переключатся между таблицами вводите команду - 11\n");
                    break;
                case 3:
                    masiv = arrayPI7.setMasiv();
                    arrayPI7.getMasiv(masiv);
                    handler_7.enterRes(arrayPI7.matrixToString(masiv));
                    break;
                case 4:
                    try {
                        if (masiv != null && masiv.length == 0) {
                            throw new IllegalArgumentException("Вы еще не создали массив");
                        }
                    } catch (Exception e) {
                        break;
                    }
                    while (true) {
                        try {
                            System.out.print("Как сортируем массив?\n" +
                                    " 1 - По возрастанию,\n" +
                                    " 2 - По убыванию \n");
                            var_s = scan.nextLine();
                            var = Integer.parseInt(var_s);
                            if (var != 1 && var != 2) {
                                throw new IllegalArgumentException("Доступные варианты: либо 1 либо 2");
                            }
                            else{
                                break;
                            }
                        } catch (Exception e){
                            System.out.println("Это не команда, бро");
                        }
                    }
                    int[] masiv_res = new int[0];
                    if (var == 1) {
                        masiv_res = sort7.sortInc(masiv);
                    }else{
                        masiv_res = sort7.sortDec(masiv);
                        }
                    handler_7.enterRes(arrayPI7.matrixToString(masiv_res));
                    sort7.getMasiv(masiv_res);
                    break;
                case 5:
                    System.out.println("Введите имя файла Excel, в который перенесем все ваши данные (создастся этот файл)");
                    String excel_name = scan.nextLine();
                    String[] data_table_1 = handler_7.selectAll(Const_7.OPERATIONS_TABLE);
                    max_len = handler_7.foundSize(Const_7.OPERATIONS_TABLE);
                    String[][] data_table = arrayPI7.redo(data_table_1, max_len);
                    exik_7.outputEx(data_table, excel_name, max_len - 1);
                    System.out.println("Занеслись данные из текущей активной таблицы - " + Const_7.OPERATIONS_TABLE + ":");
                    System.out.println("Данные из таблицы Excel: " + excel_name);
                    exik_7.inputEx(excel_name);
                    break;
                case 11:
                    System.out.println("Введите название таблицы, на которую хотите переключится \n");
                    scan.nextLine();
                    String table_active = scan.nextLine();
                    String[] tabs = handler_7.listTable();
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
                        Const_7.OPERATIONS_TABLE = table_active;
                        found = false;
                    }
                    System.out.println("Текущая активная страница: " + Const_7.OPERATIONS_TABLE);
                    break;
                default:
                    scan.nextLine();
                    System.out.println("Неизвестная команда :(");
            }
        }
    }
}