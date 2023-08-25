package chungnd.utilites

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

public class DateTimeGenerator {
	public LocalDateTime getLocalDateTime() {
		LocalDateTime localDateTime = LocalDateTime.now()
		return localDateTime;
	}
	
	public String getTimeInSecond() {
		return getLocalDateTime().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))
	}
	
	public String getTimeInMilliSecond() {
		return getLocalDateTime().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"))
	}
	
	public String getTimeInSecondWithUTC() {
		return getLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"))
	}
}
