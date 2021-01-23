package poi;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Vector;


 
class Data{
   private String date;
   private String value;
   public String getDate() {
      return date;
   }
   public void setDate(String date) {
      this.date = date;
   }
   public String getValue() {
      return value;
   }
   public void setValue(String value) {
      this.value = value;
   }
   public Data(String date, String value) {
      super();
      this.date = date;
      this.value = value;
   }
   public Data() {}
}
 
 
 
public class ExcelParser {
   public static final String projectPath = System.getProperty("user.dir");
   public static int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
   public static void main(String[] args) {
      GregorianCalendar gregori = new GregorianCalendar();//윤년 확인을 위한 객체
      Vector<Data> vector = new Vector<Data>();//데이터 수집용 벡터
      String zone = null;//시트명
      Data newData;
      try {
         //디렉토리에서 파일 읽기
         File dirFile = new File(projectPath+"\\source\\"); //프로젝트 폴더에 source폴더
         File[] fileList = dirFile.listFiles();//해당 디렉토리에 파일리스트를 
         for(File tempFile : fileList) {
           if(tempFile.isFile()) {
               String fileName = tempFile.getName();//파일명 "Temp~~.xls"
               //엑셀파일이 아니면 건너뜀
               if(!(fileName.endsWith(".xls") && fileName.startsWith("Temp"))) {
                  continue;
               }
               String filePath = tempFile.getAbsolutePath();//전체절대경로
               String[] dirName = filePath.split("\\\\");//해당 폴더명 가져오기 위해 자르기
               zone = dirName[dirName.length-2];//바로 위의 디렉토리 명
               String temp = fileName.substring(0, fileName.indexOf("."));
               String year = temp.substring(temp.length()-4, temp.length());//year
 
               //윤년계산
               if(gregori.isLeapYear(Integer.parseInt(year))) {
                  days[1] = 29;
               }else {
                  days[1] = 28;
               }
 
               FileInputStream inputStream = new FileInputStream(filePath);
               HSSFWorkbook workbook = new HSSFWorkbook(inputStream);//엑셀읽기
               HSSFSheet sheet = workbook.getSheetAt(0);//시트가져오기 0은 첫번째 시트
               int rows = sheet.getPhysicalNumberOfRows();//시트에서 총 행수
               for(int j=1;j<=12;j++) {
                  for(int i=3;i<rows;i++) {
                     //해당 월의 말일보다 크면 무시
                     if(i>(2+days[j-1])) {
                        continue;
                     }
                     //해당 셀 값 가져오기
                     HSSFCell cell = sheet.getRow(i).getCell(j);
                     String value = "";
                     if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK){
                            value="";
                     }else{
                            //타입별로 내용 읽기
                            switch (cell.getCellType()){
                            case HSSFCell.CELL_TYPE_FORMULA:
                                value=cell.getCellFormula();
                                break;
                            case HSSFCell.CELL_TYPE_NUMERIC:
                                value=cell.getNumericCellValue()+"";
                                break;
                            case HSSFCell.CELL_TYPE_STRING:
                                value=cell.getStringCellValue()+"";
                                break;
                            case HSSFCell.CELL_TYPE_BLANK:
                                value=cell.getBooleanCellValue()+"";
                                break;
                            case HSSFCell.CELL_TYPE_ERROR:
                                value=cell.getErrorCellValue()+"";
                                break;
                            }
                        }
                     SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");//포맷정의
                     String date = year+"-"+j+ "-"+ (i-2);//날짜만들기 ex)2005-8-10
                     Date date1 = java.sql.Date.valueOf(date);//String->Date타입
                     String str = format.format(date1);//포맷에 매핑 ex)2005-08-10
                     newData = new Data(str,value);
                     vector.add(newData);
                  }
               }
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      try {
         Iterator<Data> iter = vector.iterator();
         HSSFWorkbook writebook = new HSSFWorkbook();//새 엑셀파일만들기
         HSSFSheet mySheet = writebook.createSheet(zone);//새 시트 만들기 (zone이라는 이름의 시트)
         int rowIndex = 0;
         //파일 생성
         HSSFRow row;
         Data d;
         while(iter.hasNext()) {
            d = iter.next();
            row = mySheet.createRow(++rowIndex);//행 생성
            HSSFCell cell = row.createCell(0);//해당 행의 1열
            cell.setCellValue(d.getDate());//값넣기
            cell = row.createCell(1);//해당 행의 2열
            cell.setCellValue(d.getValue());//값넣기
         }
         FileOutputStream output = new FileOutputStream(projectPath+File.separator+"dest\\result.xls");
         writebook.write(output);//파일 생성
         output.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}


출처: https://jeong-pro.tistory.com/152 [기본기를 쌓는 정아마추어 코딩블로그]