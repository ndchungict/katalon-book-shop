package com.chungnd.utils

import java.math.RoundingMode
import java.text.NumberFormat

public class Converter {

	/**
	 * Convert String to currency
	 * @return 
	 */
	def BigDecimal stringToCurrency(String stringCurrency) {
		return new BigDecimal(stringCurrency.replaceAll("[^\\d.]+", ""))
	}

	def String formatCurrency(BigDecimal value) {
		NumberFormat format = NumberFormat.getInstance(new Locale("en", "US"));
		format.setMinimumFractionDigits(2);
		format.setMaximumFractionDigits(5);
		format.setRoundingMode(RoundingMode.HALF_EVEN);
		return format.format(value);
	}

	def String formatCurrency(BigDecimal value,Locale locale) {
		NumberFormat format = NumberFormat.getCurrencyInstance(locale);
		format.setMinimumFractionDigits(2);
		format.setMaximumFractionDigits(5);
		format.setRoundingMode(RoundingMode.HALF_EVEN);
		return format.format(value);
	}

	def String formatUSDCurrency(BigDecimal value) {
		return formatCurrency(value,new Locale("en", "US"));
	}

	def String formatVNDCurrency(BigDecimal value) {
		return formatCurrency(value,new Locale("vi", "VN"));
	}
}
