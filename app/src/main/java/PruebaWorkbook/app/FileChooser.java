package PruebaWorkbook.app;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;

public class FileChooser {
	
	JFileChooser file_chooser = new JFileChooser();
	
	public String saveMe() throws FileNotFoundException {
		if(file_chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
			File file = file_chooser.getSelectedFile();
			
			if (!(file.getName().endsWith(".xls"))) {
				return file.getAbsolutePath().concat(".xls");
			}else {
				return file.getAbsolutePath();
			}
			}
			else{
				return null;
			}
		}
	}
