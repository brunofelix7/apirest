package com.products.apirest.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateManager {

    public static String dateNow(){
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        return date.format(dateFormat);
    }

}
