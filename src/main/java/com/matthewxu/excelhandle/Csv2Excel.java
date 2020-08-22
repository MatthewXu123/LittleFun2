
package com.matthewxu.excelhandle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Description:
 * @author Matthew Xu
 * @date Aug 21, 2020
 */
public class Csv2Excel {
	
	private static final String FILE_PATH = "C:\\0AMatthewXu\\Files\\000WorkTemp\\2020\\0730-Auchan Modbus Slave\\tables\\pvp2\\";
	
	public static void getAllFileName(String path, List<String> listFileName){
		File file = new File(path);
		File[] files = file.listFiles();
		String[] names = file.list();
		if(names != null && names.length != 0){
			String[] completNames = new String[names.length];
			for(int i = 0; i < names.length; i++){
				completNames[i] = path + names[i];
			}
			listFileName.addAll(Arrays.asList(completNames));
		}
		for (File f : files) {
			if(f.isDirectory()){
				getAllFileName(f.getAbsolutePath() + "\\", listFileName);
			}
		}
	}
	
	public static void main(String[] args){
		try {
			List<String> baseFiles = new ArrayList<String>(); 
	        getAllFileName(FILE_PATH,baseFiles);
	        for (String baseFile : baseFiles) {
	        	FileInputStream fis = new FileInputStream(new File(baseFile));
	        	Workbook baseWb = WorkbookFactory.create(fis);
	        	Sheet baseSheet = baseWb.getSheetAt(0);
				Integer baseRowNum = baseSheet.getLastRowNum();
				for(int i = 0; i < baseRowNum; i++){
					Row row = baseSheet.getRow(i);
					String rowStr = row.getCell(0).toString();
					String[] rowSplit = rowStr.split("\\|");
					int columnNum = rowSplit.length;
					if(columnNum <= 1 && i < 3)
						continue;
					for(int k = 0; k < columnNum; k++){
						row.createCell(k);
						row.getCell(k).setCellValue(rowSplit[k]);
    				}
				}
				FileOutputStream fileOut = new FileOutputStream(baseFile);
				baseWb.write(fileOut);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
