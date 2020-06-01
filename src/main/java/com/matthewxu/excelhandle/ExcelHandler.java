package com.matthewxu.excelhandle;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelHandler {
	private static final String EXCEL_XLS = "xls";
	private static final String EXCEL_XLSX = "xlsx";
	private static final String BASE_PATH = "C:\\0AMatthewXu\\Files\\000WorkTemp\\2020\\0601- ExcelHandler2\\base\\";
	private static final String SUB_PATH = "C:\\0AMatthewXu\\Files\\000WorkTemp\\2020\\0601- ExcelHandler2\\sub\\";
	
	public void importExcel(String filePath) {
//		InputStream is = ExcelHandler.class.getClassLoader().getResourceAsStream(filePath);
//		try {
//			Workbook wb = WorkbookFactory.create(is);
//			Sheet sheet = wb.getSheetAt(0);
//			Integer rowNum = sheet.getLastRowNum();
//
//			int[] paramLocation = getParamLocation(sheet.getRow(0));
//			int templateName = paramLocation[0];
//			int serialNumberLocation = paramLocation[1];
//			int dateProductLocation = paramLocation[2];
//			int itemCodeLocation = paramLocation[3];
//			int packCodeLocation = paramLocation[4];
//
//			for (int i = 1; i <= rowNum; i++) {
//
//				Row row = sheet.getRow(i);
//				if (TEMPLATE_NAME.indexOf(row.getCell(templateName).toString()) != -1) {
//					QRCode code = new QRCode();
//					code.setSerialNumber(row.getCell(serialNumberLocation).toString());
//					if (row.getCell(dateProductLocation) == null
//							|| row.getCell(dateProductLocation).toString().length() == 0) {
//						code.setProductionDate(null);
//					} else {
//						code.setProductionDate(DateUtils.dateTransform(row.getCell(dateProductLocation).toString()));
//					}
//					code.setItemCode(row.getCell(itemCodeLocation).toString());
//					if (row.getCell(packCodeLocation) != null && !row.getCell(packCodeLocation).toString().equals("")) {
//						code.setPackCode(row.getCell(packCodeLocation).toString());
//					}
//					code.setCreateTime(new Date());
//					code.setUpdateTime(new Date());
//					qrCodeRepository.save(code);
//				}
//			}
//			log.info("successful import");
//		} catch (Exception e) {
//			log.error("", e);
//		}
	}

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
	
	
	public void fixData(String baseDirPath, String subDirPath) {
//		InputStream is = ExcelHandler.class.getClassLoader().getResourceAsStream(filePath);
//		Date currentDate = new Date();
//		try {
//			Workbook wb = WorkbookFactory.create(is);
//			Sheet sheet = wb.getSheetAt(0);
//			for (Row row : sheet) {
//				String serialNumber = row.getCell(0).toString().trim();
//				Integer scanTimes = Double.valueOf(row.getCell(1).toString()).intValue();
//				Date firstScan = DateUtils.strToDate(YMD, row.getCell(2).toString());
//				List<QRCode> list = qrCodeRepository.findBySerialNumber(serialNumber);
//				QRCode qrCode = list.get(0);
//				String scanContent = qrCode.getSerialNumber() + "|" + qrCode.getProductionDate() + "|"
//						+ qrCode.getItemCode();
//				if (qrCode.getPackCode() != null && qrCode.getPackCode().trim().length() != 0)
//					scanContent += "|" + qrCode.getPackCode();
//				ScanEvent scanEvent = new ScanEvent(scanContent, null, scanTimes, firstScan, currentDate);
//				scanEventRepository.save(scanEvent);
//				ScanEvent scanEvent2 = scanEventRepository.findByScanContent(scanContent);
//				for (int i = 0; i < scanTimes; i++) {
//					scanDetailRepository.insertOne(qrCode.getId(), scanEvent2.getId(), null, null, currentDate,
//							currentDate);
//				}
//			}
//		} catch (EncryptedDocumentException | IOException e) {
//			log.error("", e);
//		}

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
    			for(int i = 6; i < subRowNum; i++){
    				Row createRow = baseSheet.createRow(baseRowNum + i + 1 - 6);
    				Row row = subSheet.getRow(i);
    				short firstCellNum = row.getFirstCellNum();
    				short lastCellNum = row.getLastCellNum();
    				for(int k = firstCellNum; k < lastCellNum; k++){
    					createRow.createCell(k);
    					createRow.getCell(k).setCellValue(row.getCell(k).toString());
    				}
    			}
			}
		}
	}

}
