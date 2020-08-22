package com.matthewxu.excelhandle;

import java.io.*;

import org.apache.poi.hssf.usermodel.*;

/**
* This class provides utility for operating excel file
* @version 1.0
*/
public class ExcelUtil
{

/**
  * transform csv file into excel file
  *
  * @param csv name of a csv file that will be transformed
  * @param excel name of a excel file that will store the transformed file
  *
  * @throws IOException
  */
public final static void CsvToExcel(String csv, String excel) throws IOException
{
  HSSFWorkbook wb = new HSSFWorkbook();
  HSSFSheet sheet = wb.createSheet("Sheet1");

  BufferedReader r = null;
 
  try
  {
   r = new BufferedReader(new FileReader(csv));
 
   int i = 0;

   while (true)
   {
    String ln = r.readLine();

    if (ln == null)
     break;

    HSSFRow row = sheet.createRow((short) i++);
    int j = 0;

    for (CSVTokenizer it = new CSVTokenizer(ln); it.hasMoreTokens();)
    {
     String val = it.nextToken();

     HSSFCell cell = row.createCell((short) j++);
     cell.setCellValue(val);
    }
   }
  }
  finally
  {
   if (r != null)
    r.close();
  }

  FileOutputStream fileOut = null;
 
  try
  {
   fileOut = new FileOutputStream(excel);
   wb.write(fileOut);
  }
  finally
  {
   if (fileOut != null)
    fileOut.close();
  }
}



public final static Object getCellValue(HSSFCell cell)
{
  if (cell != null)
  {
   int t = cell.getCellType();

   if (t == HSSFCell.CELL_TYPE_NUMERIC)
   {
    int f = cell.getCellStyle().getDataFormat();
    //if (f >= 0x0A && f <= 0x16) // Datetime format
    if (((f >= 14 && f <= 17) || (f >= 164 && f <= 168) || (f >= 172 && f <= 177) || f == 22))
     return (java.util.Date) cell.getDateCellValue();

    double d = cell.getNumericCellValue();
    if (d == Math.floor(d))
     return new Long((long) d);

    return new Double(d);
   }
   else if (t == HSSFCell.CELL_TYPE_STRING)
    return cell.getStringCellValue();
  }

  return null;
}



/**
  *
  *
  * @param args
  *
  * @throws IOException
  */
public static void main(String[] args) throws IOException
{
  CsvToExcel("x.csv", "x.xls");
}
}