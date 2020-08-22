package com.matthewxu.excelhandle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelHandler {
	//private static final String BASE_PATH = "C:\\0AMatthewXu\\Files\\000WorkTemp\\2020\\0601- ExcelHandler2\\base\\";
	//private static final String SUB_PATH = "C:\\0AMatthewXu\\Files\\000WorkTemp\\2020\\0601- ExcelHandler2\\sub\\";
	private static final String BASE_PATH = "C:\\Users\\91641\\Desktop\\excel\\base\\";
	private static final String SUB_PATH = "C:\\Users\\91641\\Desktop\\excel\\sub\\";
	
	public static void getAllFileName(String path,ArrayList<String> listFileName){
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
	
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ArrayList<String> baseFiles = new ArrayList<String>(); 
		ArrayList<String> subFiles = new ArrayList<String>(); 
        getAllFileName(BASE_PATH,baseFiles);
        getAllFileName(SUB_PATH,subFiles);
        for (String baseFile : baseFiles) {
        	FileInputStream fis = new FileInputStream(new File(baseFile));
        	Workbook baseWb = WorkbookFactory.create(fis);
        	Sheet baseSheet = baseWb.getSheetAt(0);
			Integer baseRowNum = baseSheet.getLastRowNum();
        	for (String subFile : subFiles) {
        		FileInputStream fis2 = new FileInputStream(new File(subFile));
        		Workbook subWb = WorkbookFactory.create(fis2);
        		Sheet subSheet = subWb.getSheetAt(0);
    			Integer subRowNum = subSheet.getLastRowNum();
    			int j = 1;
    			for(int i = 6; i < subRowNum; i++){
    				Row createRow = baseSheet.createRow(baseRowNum + j++);
    				Row row = subSheet.getRow(i);
    				short firstCellNum = row.getFirstCellNum();
    				short lastCellNum = row.getLastCellNum();
    				for(int k = firstCellNum; k < lastCellNum; k++){
    					createRow.createCell(k);
    					createRow.getCell(k).setCellValue(row.getCell(k).toString());
    				}
    			}
    			FileOutputStream fileOut=new FileOutputStream(baseFile);
    			baseWb.write(fileOut);
    	        fileOut.close();
			}
		}
	}

}
