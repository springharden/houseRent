package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    //日期转换为字符串
    public static String dateToString(Date date , String partten){
        SimpleDateFormat sdf = new SimpleDateFormat(partten);
        String format = sdf.format(date);
        return format;
    }
    //字符串转为日期
    public static Date stringToDate(String str,String partten) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat(partten);
        Date date = sdf.parse(str);
        return date;
    }
}
