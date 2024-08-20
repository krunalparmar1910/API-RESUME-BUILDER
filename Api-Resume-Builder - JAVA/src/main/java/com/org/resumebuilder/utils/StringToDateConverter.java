//package com.org.resumebuilder.utils;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Locale;
//import java.util.Optional;
//
//import org.modelmapper.AbstractConverter;
//
//public class StringToDateConverter extends AbstractConverter<String, Date> {
//	private static final String DATE_FORMAT = "yyyy-MM-dd";
//	private static final String ALTERNATE_DATE_FORMAT = "EEE MMM dd HH:mm:ss zzz yyyy";
//	private static final String CUSTOM_DATE_FORMAT = "dd MMMM yyyy"; // New format
//
//	@Override
//	protected Date convert(String source) {
//		return parseDate(source, DATE_FORMAT).orElseGet(() -> parseDate(source, ALTERNATE_DATE_FORMAT)
//				.orElseGet(() -> parseDate(source, CUSTOM_DATE_FORMAT).orElseThrow(() -> new IllegalArgumentException(
//						"Date format should be yyyy-MM-dd, EEE MMM dd HH:mm:ss zzz yyyy, or dd MMMM yyyy"))));
//	}
//
//	private Optional<Date> parseDate(String dateStr, String format) {
//		SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.ENGLISH);
//		try {
//			return Optional.of(sdf.parse(dateStr));
//		} catch (ParseException e) {
//			return Optional.empty();
//		}
//	}
//}
