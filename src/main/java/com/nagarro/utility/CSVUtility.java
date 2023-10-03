package com.nagarro.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.nagarro.entities.Tshirt;
import com.nagarro.validation.DataNotSufficientException;
import com.nagarro.validation.InvalidCategoryException;
import com.nagarro.validation.InvalidHeadingException;
import com.opencsv.CSVReader;

public class CSVUtility {

	
	
	public List<Tshirt> getTshirts(File[] files,String color,String size,String gender) throws InvalidHeadingException, DataNotSufficientException, NumberFormatException, InvalidCategoryException, FileNotFoundException{
		//result arraylist
		List<Tshirt> tshirts=new ArrayList<>();
		
		int n=files.length;
		
		for(int i=0;i<n;i++) {
			//System.out.println(files[i].getPath());
		FileReader reader=new FileReader(files[i].getPath());
		CSVReader csvReader=new CSVReader(reader);
		Iterator it=csvReader.iterator();
		
		String headings[]=(String[])it.next();
		String heading=headings[0];
		TshirtUtility tsu=new TshirtUtility(heading);
		while(it.hasNext()) {
//			String str[]=(String[])it.next();
//			System.out.println(str[0]);
			
			
			String raws[]=(String[])it.next();
			String raw=raws[0];
			
			//if tshirt match tghen add to list
			tsu.getGender(gender);
			tsu.getTSize(size);
			if(tsu.isMatchTshirt(color, size, gender, raw)) {
				tshirts.add(tsu.parseTshirt(raw));
			}
			
		}
		}
		return tshirts;
	}
	
}
