
package com.matthewxu.excelhandle;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.EncryptedDocumentException;
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

	private static final String FILE_PATH = "C:\\0AMatthewXu\\Files\\000WorkTemp\\2021\\0204-Yonghui\\List.xlsx";
	
	private static List<Yonghui> onlineList = new ArrayList<>();
	private static List<Yonghui> offlineList = new ArrayList<>();
	
	@SuppressWarnings("resource")
	private static void getDataFromExcel() throws EncryptedDocumentException, IOException{
		File file = new File(FILE_PATH);
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheetAt(0);
		int rowNum = sheet.getLastRowNum();
		for(int i = 1; i < rowNum; i++){
			Row row = sheet.getRow(i);
			String description = getStringFromCell(row.getCell(0));
			if(StringUtils.isBlank(description))
				continue;
			Yonghui yonghui = new Yonghui();
			yonghui.setDescription(description);
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
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		getDataFromExcel();
		getOldToNewUpdateSqls();
		//getNewToOldUpdateSqls();
	}
	
	public static void getOldToNewUpdateSqls(){
		for (Yonghui yonghui : onlineList) {
			System.out.println(buildUpdateSql(yonghui.getCurrentIP(), yonghui.getPreviousIP()));
		}
	}
	
	public static void getNewToOldUpdateSqls(){
		for (Yonghui yonghui : onlineList) {
			System.out.println(buildUpdateSql(yonghui.getPreviousIP(), yonghui.getCurrentIP()));
		}
	}
	
	private static String buildUpdateSql(String oldOne, String newOne){
		return "update public.cfsupervisors set ipaddress = '"+ oldOne +"' where ipaddress = '" + newOne + "';";
	}
	
	private static String getStringFromCell(Cell cell){
		return cell != null ? cell.toString() : "";
	}
	
	private static int getIntFromCell(Cell cell){
		return cell != null ? Double.valueOf(cell.toString()).intValue() : 0;
	}
	
	private static class Yonghui{
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

		@Override
		public String toString() {
			return "Yonghui [description=" + description + ", previousIP=" + previousIP + ", currentIP=" + currentIP
					+ ", isOnline=" + isOnline + ", comment=" + comment + "]";
		}
		
	}
	
	
	
}
