package com.paolo.cinemille.converters;

import java.text.ParseException;

import java.util.Date;
import java.util.Locale;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Component;

/*
 * Converter utile nel caso in cui le stringhe delle date in ingresso nei parametri delle richieste risultano 
 * vuote o non parsabili
 */

@Component
public class StringToDateSafeConverter implements Converter<String, Date>{

	@Override
	public Date convert(String source) {
		
		if(source != null && source.trim().isEmpty()) {
			return null;
		}
		
		try {
			DateFormatter df = new DateFormatter();
			df.setIso(ISO.DATE);
			return df.parse(source, Locale.US);
		}
		catch(ParseException ex) {
			return null;
		}		
	}

}
