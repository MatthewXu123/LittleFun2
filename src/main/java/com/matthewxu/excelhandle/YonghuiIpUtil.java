
package com.matthewxu.excelhandle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hpsf.Array;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Description:
 * @author Matthew Xu
 * @date Feb 2, 2021
 */
public class YonghuiIpUtil {

	private static final String FILE_PATH = "";
	
	private List<Yonghui> onlineList = new ArrayList<>();
	private List<Yonghui> offlineList = new ArrayList<>();
	
	@SuppressWarnings("resource")
	private void getDataFromExcel() throws EncryptedDocumentException, IOException{
		File file = new File(FILE_PATH);
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheetAt(0);
		int rowNum = sheet.getLastRowNum();
		List<Yonghui> abnormalList = new ArrayList<>();
		for(int i = 1; i < rowNum; i++){
			Row row = sheet.getRow(i);
			
			Yonghui yonghui = new Yonghui();
			yonghui.setDescription(getStringFromCell(row.getCell(0)));
			yonghui.setPreviousIP(getStringFromCell(row.getCell(1)));
			yonghui.setCurrentIP(getStringFromCell(row.getCell(2)));
			yonghui.setComment(getStringFromCell(row.getCell(4)));
			
			int isOnlineVal = getIntFromCell(row.getCell(3));
			if(isOnlineVal == 0){
				yonghui.setOnline(false);
				offlineList.add(yonghui);
			}else{
				yonghui.setOnline(true);
				onlineList.add(yonghui);
			}
			
		}
		
	}
	
	private String getStringFromCell(Cell cell){
		return cell != null ? cell.toString() : "";
	}
	
	private int getIntFromCell(Cell cell){
		return cell != null ? Integer.valueOf(cell.toString()) : 0;
	}
	
	private class Yonghui{
		private String description;
		
		private String previousIP;
		
		private String currentIP;
		
		private boolean isOnline;
		
		private String comment;

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getPreviousIP() {
			return previousIP;
		}

		public void setPreviousIP(String previousIP) {
			this.previousIP = previousIP;
		}

		public String getCurrentIP() {
			return currentIP;
		}

		public void setCurrentIP(String currentIP) {
			this.currentIP = currentIP;
		}

		public boolean isOnline() {
			return isOnline;
		}

		public void setOnline(boolean isOnline) {
			this.isOnline = isOnline;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}
		
	}
	
	
	
}
