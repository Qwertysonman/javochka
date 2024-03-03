package sample;
import com.microsoft.schemas.office.visio.x2012.main.IconType;

import java.sql.ResultSetMetaData;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class Handler extends dataconnect{
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }
    public String[] listTable(){
        String[] tables_list = new String[20];
        String select = "SHOW TABLES";
        int i = 0;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            ResultSet res_select = prSt.executeQuery();
            while (res_select.next()) {
                String tableName = res_select.getString(1);
                tables_list[i] = String.valueOf(tableName);
                i += 1;
            }
            return tables_list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String[][] selectAll(String table_name){
        System.out.println("Что-то выбрать (все)");
        String select = "SELECT * FROM " + table_name;
        String [][] tables_list = new String[6][1];
        int i = 0;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            ResultSet res_select = prSt.executeQuery();
            while (res_select.next()) {
                tables_list[i][0] = String.valueOf(res_select.getString(1));
                i += 1;
            }

            return tables_list;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void displayData() {
        String select = "SHOW TABLES";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            ResultSet res_select = prSt.executeQuery();
            while (res_select.next()) {
                String tableName = res_select.getString(1);
                System.out.println("Table: " + tableName);

                String selectAllQuery = "SELECT * FROM " + tableName;
                try {
                    PreparedStatement prSt_1 = getDbConnection().prepareStatement(selectAllQuery);
                    ResultSet resultSet = prSt_1.executeQuery();

                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();

                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(metaData.getColumnName(i) + "\t\t");
                    }
                    System.out.println();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "  \t\t\t\t\t\t");
                        }
                        System.out.println();
                    }

                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public String createNew() {
         String new_name = " ";
         System.out.println("Введите имя новой таблицы: ");
         Scanner scan = new Scanner(System.in);
         new_name = scan.nextLine();
         try{
            String create = "CREATE TABLE IF NOT EXISTS " + new_name + "( " +
                    Const.OPERATIONS_MATRIX + " TEXT NOT NULL" +
                    " );";
            try {
                PreparedStatement prSt = getDbConnection().prepareStatement(create);
                prSt.executeUpdate();
                return new_name;
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }catch (Exception e){
        System.out.println("НЕЛЬЗЯ ТАКОЕ ИМЯ");
        }
        return "";
    }
    public void enterRes(String matrix){
        String insert = "INSERT INTO " + Const.OPERATIONS_TABLE + "(" + Const.OPERATIONS_MATRIX + ")"
                + " VALUES (?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, matrix);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
