package uz.b.application.config.utils;

import uz.b.application.config.exception.BadRequestException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private static final DateTimeFormatter fLocalDateDashed = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter toStringLocalDate = DateTimeFormatter.ofPattern("dd.MM.yyyy");


    public static String toString(LocalDateTime dateTime){
        return formatter.format(dateTime);
    }

    public static String toString(LocalDate date){
        return toStringLocalDate.format(date);
    }

    public static LocalDate parseLocalDate(String string) throws BadRequestException {
        try {
            return LocalDate.parse(string,fLocalDateDashed);
        }catch (Exception e){
            throw new BadRequestException(UIConstants.INVALID_TIME_PATTERN.concat(", pattern should be like that : \"yyyy-MM-dd\" "));
        }

    }

}
