package pooi;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class poiTest {

	public static void main(String[] args) {

		HSSFWorkbook wb = null;
		HSSFSheet sheet = null;
		Row row =null;
		Cell cell = null;	
		
		XSSFWorkbook xssfWb = null; // .xlsx
		XSSFSheet xssfSheet = null; // .xlsx
		XSSFRow xssfRow = null; // .xlsx
		XSSFCell xssfCell = null;// .xlsx
		
		
		try {
			int rowNo=0;
			//
			xssfWb= new XSSFWorkbook();
			xssfSheet = xssfWb.createSheet("엑소시스트");
			
			XSSFFont font = xssfWb.createFont();
			font
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
