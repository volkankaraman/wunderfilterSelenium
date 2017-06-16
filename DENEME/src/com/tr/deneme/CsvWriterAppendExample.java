package com.tr.deneme;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.csvreader.CsvWriter;


public class CsvWriterAppendExample {
	
	public static void main(String[] args) {
		
		CsvWriterYaz("aa", "hkjhkjh", "khkjhj", "motorKodu", "hjkh", "kjhkjh", "hkjh", "hava", "yag", "yakıt", "icMekan,", "diger");
		String outputFile = "users.csv";
		
		// before we open the file check to see if it already exists
		boolean alreadyExists = new File(outputFile).exists();
			
		try {
			// use FileWriter constructor that specifies open for appending
			CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
			
			// if the file didn't already exist then we need to write out the header line
			if (!alreadyExists)
			{
				csvOutput.write("id");
				csvOutput.write("name");
				csvOutput.write("Aracın Markası");
				csvOutput.write("Model");
				csvOutput.write("Model Tipi");
				csvOutput.write("Motor Kodu");
				csvOutput.write("Kw");
				csvOutput.write("Ps");
				csvOutput.write("Üretim Yılı");
				csvOutput.write("Hava Filtresi");
				csvOutput.write("Yağ Filtresi");
				csvOutput.write("Yakıt Filtresi");
				csvOutput.write("İç Mekan Filtresi");
				csvOutput.write("Diğer Filtreler");
				csvOutput.endRecord();
			}
			// else assume that the file already has the correct header line
			
			// write out a few records
			csvOutput.write("1");
			csvOutput.write("Bruce");
			csvOutput.endRecord();
			
			csvOutput.write("2");
			csvOutput.write("John");
			csvOutput.endRecord();
			
			csvOutput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void CsvWriterYaz(String uretici,String model,String modelTipi,String motorKodu,String kw,String ps,String uretimSuresi,String hava,String yag,String yakit,String icMekan,String diger) {
String outputFile = "users4.csv";
		
		// before we open the file check to see if it already exists
		boolean alreadyExists = new File(outputFile).exists();
			
		try {
			// use FileWriter constructor that specifies open for appending
			CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), '#');
			
			// if the file didn't already exist then we need to write out the header line
			if (!alreadyExists)
			{
				csvOutput.write("Aracın Markası");
				csvOutput.write("Model");
				csvOutput.write("Model Tipi");
				csvOutput.write("Motor Kodu");
				csvOutput.write("Kw");
				csvOutput.write("Ps");
				csvOutput.write("Üretim Yılı");
				csvOutput.write("Hava Filtresi");
				csvOutput.write("Yağ Filtresi");
				csvOutput.write("Yakıt Filtresi");
				csvOutput.write("İç Mekan Filtresi");
				csvOutput.write("Diğer Filtreler");
				csvOutput.endRecord();
			}
			// else assume that the file already has the correct header line
			
			// write out a few records
			csvOutput.write(uretici);
			csvOutput.write(model);
			csvOutput.write(modelTipi);
			csvOutput.write(motorKodu);
			csvOutput.write(kw);
			csvOutput.write(ps);
			csvOutput.write(uretimSuresi);
			csvOutput.write(hava);
			csvOutput.write(yag);
			csvOutput.write(yakit);
			csvOutput.write(icMekan);
			csvOutput.write(diger);		
			csvOutput.endRecord();
			
			
			csvOutput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
}
}

