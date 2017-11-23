package PruebaWorkbook.app;

import java.io.*;

import javax.swing.JTable;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.*;

public class WorkBook<XSSFWorkbook, XSSFSheet> {

	private FileInputStream document;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private double price;
	private String category;
	private String name;
	private String expansion;
	private String link;
	private String language;
	private String condition;
	private int amount;
	private JTable table;
	

	public WorkBook() {

	}

	public void getData(String name, int amount, String expansion, String category, double object, String link) {
		this.name = name;
		this.category = category;
		this.price = object;
		this.expansion = expansion;
		this.link = link;
		this.amount = amount;
		if (category.startsWith("English")) {
			language = "English";
		}else {
			language = "Chinese";
		}
		if (category.endsWith("Regular")){
			condition = "Regular";
		}else {
			condition = "Foil";
		}
	}

	public void edditExcel(int rowNumber, int cellNumber, String nombre, JTable table, String buyer) throws IOException {
		FileInputStream document = new FileInputStream(new File(nombre));
		HSSFWorkbook workbook = new HSSFWorkbook(document);
		HSSFSheet sheet = workbook.getSheetAt(0);
		int row = sheet.getRow(rowNumber).getRowNum();
		Cell cell = null;
		for (int i = 0; i < table.getModel().getRowCount(); i++) {
			this.getData(table.getModel().getValueAt(i, 0).toString(),
					(Integer) table.getModel().getValueAt(i, 1),
					table.getModel().getValueAt(i, 2).toString(),
					table.getModel().getValueAt(i, 3).toString(),
					(Double) table.getModel().getValueAt(i, 4),
					table.getModel().getValueAt(i, 5).toString());
			cell = sheet.getRow(row).getCell(cellNumber);
			cell.setCellValue(this.name);
			cell = sheet.getRow(row).getCell((cellNumber + 1));
			cell.setCellValue(this.amount);
			cell = sheet.getRow(row).getCell((cellNumber + 2));
			cell.setCellValue(this.expansion);
			cell = sheet.getRow(row).getCell((cellNumber + 3));
			cell.setCellValue(this.language);
			cell = sheet.getRow(row).getCell((cellNumber + 4));
			cell.setCellValue(this.condition);
			cell = sheet.getRow(row).getCell((cellNumber + 5));
			cell.setCellValue(this.price);
			cell = sheet.getRow(row).getCell((cellNumber + 7));
			cell.setCellValue(this.link);
			row++;
		}
		Row row2 = sheet.getRow(21);
		cell = sheet.getRow(row2.getRowNum()).getCell(3);
		cell.setCellValue(buyer);
		document.close();
		// Open FileOutputStream to write updates
		FileOutputStream output_file = new FileOutputStream(new File(nombre));
		// write changes
		workbook.write(output_file);
		workbook.close();
		// close the stream
		output_file.close();
	}
	
	public FileInputStream getDocument() {
		return document;
	}

	public void setDocument(FileInputStream document) {
		this.document = document;
	}

	public XSSFWorkbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(XSSFWorkbook workbook) {
		this.workbook = workbook;
	}

	public XSSFSheet getSheet() {
		return sheet;
	}

	public void setSheet(XSSFSheet sheet) {
		this.sheet = sheet;
	}

}
