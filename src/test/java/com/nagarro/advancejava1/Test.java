package com.nagarro.advancejava1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class Test {
	
	public static void main(String[] args) throws IOException, CsvException {
		FileReader csvFile=new FileReader("data/Adidas.csv");
		 CSVReader csvReader=new CSVReader(csvFile);
		 
		 List<String[]> list=csvReader.readAll();
		 
		 for(String[] str:list) {
			 for(String s:str)
		 System.out.println(s);
		 }
 }  	
}

