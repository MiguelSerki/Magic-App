package PruebaWorkbook.app;
import java.io.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.*;
import java.util.Iterator;


public class WorkBook{

	private FileInputStream document;
	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private double price;
	private String category;
	private String name;
	private String expansion;
	private String link;
	private int amount;
	
	
	public WorkBook (int rowNumber, int cellNumber, String nombre, String name, String category, double price, String expansion, String link,int amount) throws IOException{
		FileInputStream document = new FileInputStream(new File(nombre));
	      //Get the workbook instance for XLSX file 
		 HSSFWorkbook workbook = new HSSFWorkbook(document); 
	        System.out.println("File open successfully.");
	    	this.name = name;
	    	this.category = category;
	    	this.price = price;
	    	this.expansion = expansion;
	    	this.link = link;
	    	this.amount = amount;
	    	
			HSSFSheet sheet = workbook.getSheetAt(0);
	    	int row = sheet.getRow(rowNumber).getRowNum();
	  	  Cell cell =  null; 
	  	  cell = sheet.getRow(row).getCell(cellNumber);
	  	  System.out.println("Writing into file");  
	   	  cell.setCellValue(this.name);
	   	  cell = sheet.getRow(row).getCell((cellNumber +1));
	   	  cell.setCellValue(this.amount);
	   	  cell = sheet.getRow(row).getCell((cellNumber +2));
	   	  cell.setCellValue(this.expansion);
	   	  cell = sheet.getRow(row).getCell((cellNumber +3));
	   	  cell.setCellValue(this.category);
	   	  cell = sheet.getRow(row).getCell((cellNumber +5));
	   	  cell.setCellValue(this.price);
	   	  cell = sheet.getRow(row).getCell((cellNumber +7));
	   	  cell.setCellValue(this.link);
	          document.close();
	          //Open FileOutputStream to write updates
	          FileOutputStream output_file =new FileOutputStream(new File(nombre));
	          //write changes
	          workbook.write(output_file);
	          workbook.close();
	          //close the stream
	          output_file.close();
	          System.out.println("Writing succesful!");
	   	}
		
	
	

	public FileInputStream getDocument() {
		return document;
	}


	public void setDocument(FileInputStream document) {
		this.document = document;
	}


	public HSSFWorkbook getWorkbook() {
		return workbook;
	}


	public void setWorkbook(HSSFWorkbook workbook) {
		this.workbook = workbook;
	}


	public HSSFSheet getSheet() {
		return sheet;
	}


	public void setSheet(HSSFSheet sheet) {
		this.sheet = sheet;
	}
}
