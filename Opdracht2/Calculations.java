import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Calculations{
    public static String calculateAge (String bday, int i) {
        long[] differenceList = new long[6];
         try{
            LocalDateTime currentDate = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
            LocalDate bdayDate = LocalDate.parse(bday,formatter);
            LocalTime time = LocalTime.now();
            LocalTime zero = LocalTime.now();
            zero.with(LocalTime.MIDNIGHT);
            LocalDateTime finalBday = LocalDateTime.of(bdayDate, zero);
            differenceList[1] = finalBday.until( currentDate, ChronoUnit.SECONDS);
            differenceList[0] = differenceList[1] * 1000; //milliseconds
            differenceList[2] = finalBday.until( currentDate, ChronoUnit.MINUTES);
            differenceList[3] = finalBday.until( currentDate, ChronoUnit.HOURS);
            differenceList[4] = finalBday.until( currentDate, ChronoUnit.DAYS);
            differenceList[5] = finalBday.until( currentDate, ChronoUnit.YEARS);
            return Long.toString(differenceList[i]);
        }
        catch (DateTimeParseException e) {
            return "ERROR, have you used the correct format?";
        }
    }
    public static String calculateDifference (String bday1, String bday2, int i){
        long[] differenceList = new long[6];
         try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
            LocalDate bdayDate1 = LocalDate.parse(bday1,formatter);
            LocalDate bdayDate2 = LocalDate.parse(bday2,formatter);
            LocalTime time = LocalTime.now();
            LocalDateTime finalBday1 = LocalDateTime.of(bdayDate1, time);
            LocalDateTime finalBday2 = LocalDateTime.of(bdayDate2, time);
            differenceList[1] = finalBday1.until( finalBday2, ChronoUnit.SECONDS);
            differenceList[0] = differenceList[1] * 1000; //milliseconds
            differenceList[2] = finalBday1.until( finalBday2, ChronoUnit.MINUTES);
            differenceList[3] = finalBday1.until( finalBday2, ChronoUnit.HOURS);
            differenceList[4] = finalBday1.until( finalBday2, ChronoUnit.DAYS);
            differenceList[5] = finalBday1.until( finalBday2, ChronoUnit.YEARS);
            return Long.toString(Math.abs(differenceList[i]));
        }
        catch (DateTimeParseException e) {
            return "ERROR, have you used the correct format?";
        }
    }
}
