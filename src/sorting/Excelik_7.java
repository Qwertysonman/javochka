package sorting;
import java.io.*; // Ввод - вывод, доступ к файлу
import java.util.*; // читать данные строк и столбцов
import org.apache.poi.ss.usermodel.*; // внутри самого файла excel
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet; // страница excel
import org.apache.poi.xssf.usermodel.XSSFWorkbook; // вся книга, весь файл excel
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;


public class Excelik_7 {
    public void inputEx(String path_name) throws Exception {
        try{
            System.out.println(path_name);
            FileInputStream file = new FileInputStream(new File("C:\\Users\\User\\Desktop\\" + path_name + ".xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file); // Объект для доступа к файлу
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    System.out.print(cell.getStringCellValue() + "\t\t");
                }
                System.out.print("\n");

            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void outputEx(String[][] data, String path_name, int cop) throws Exception {
        Workbook workbook = new XSSFWorkbook();
        Sheet newSheet = workbook.createSheet("Листик");

        // Создаем стиль для центрирования текста
        CellStyle centerAlignStyle = workbook.createCellStyle();
        centerAlignStyle.setAlignment(HorizontalAlignment.CENTER);

        // Создаем первую строку
        Row firstRow = newSheet.createRow(0);
        for (int j = 0; j < 5; j++) {
            // Заполняем первые 5 ячеек и применяем стиль центрирования
            firstRow.createCell(j).setCellValue(data[0][j]);
            firstRow.getCell(j).setCellStyle(centerAlignStyle);
        }
        newSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, cop));

        // Заполняем остальные строки
        for (int i = 1; i < data.length; i++) {
            Row row = newSheet.createRow(i);
            for (int j = 0; j < data[i].length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(data[i][j]);
                cell.setCellStyle(centerAlignStyle); // Применяем стиль центрирования
            }
        }

        try {
            FileOutputStream fileOut = new FileOutputStream("C:\\Users\\User\\Desktop\\" + path_name + ".xlsx");
            workbook.write(fileOut);
            fileOut.close();
            System.out.println("Проверяй рабочий стол, там твои данные в " + path_name + ".xlsx");
        } catch (Exception e) {
            System.out.println("Бро, проблемы с Excel");
        }
    }
}

