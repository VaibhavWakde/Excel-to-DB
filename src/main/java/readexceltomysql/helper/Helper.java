package readexceltomysql.helper;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import readexceltomysql.entity.FaqData;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Helper {

    //check that file is of excel type or not
    public static boolean checkExcelFormat(MultipartFile file) {
        String contentType = file.getContentType();

        if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        }
        return false;
    }

    //convert excel to list of FaqData
    public static List<FaqData> convertExcelToListOfProduct(InputStream is) {
        List<FaqData> list = new ArrayList<>();

        try {

            XSSFWorkbook workbook = new XSSFWorkbook(is);

            XSSFSheet sheet = workbook.getSheet("data");

            int rowNumber=0;
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()){
                Row row = iterator.next();
                if(rowNumber==0){
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();

                int cid = 0;

                FaqData faqData = new FaqData();

                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cid) {
                        case 0 :
                            faqData.setId((long) cell.getNumericCellValue());
                            break;
                        case 1:
                            faqData.setCategory(cell.getStringCellValue());
                            break;
                        case 2:
                            faqData.setCategoryId((long) cell.getNumericCellValue());
                            break;
                        case 3:
                            faqData.setQuestion(cell.getStringCellValue());
                            break;
                        case 4 :
                            faqData.setAnswer(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    cid++;
                }
                list.add(faqData);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
