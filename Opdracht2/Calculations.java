import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.format.ResolverStyle;

public class Calculations{
    public static String calculateAge (String bday, int i) {
        long difference = 0;;
         try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM uuuu").withResolverStyle(ResolverStyle.STRICT);
            LocalDate bdayDate = LocalDate.parse(bday,formatter);
            LocalTime zero = LocalTime.MIN;
            LocalDateTime currentDateTime = LocalDateTime.now();
            LocalDateTime bdayDateTime = LocalDateTime.of(bdayDate, zero);
            switch(i){
                case 0: difference = bdayDateTime.until( currentDateTime, ChronoUnit.MILLIS);
                        return Long.toString(difference) + " milliseconds";
                case 1: difference = bdayDateTime.until( currentDateTime, ChronoUnit.SECONDS);
                        return Long.toString(difference) + " seconds";
                case 2: difference = bdayDateTime.until( currentDateTime, ChronoUnit.MINUTES);
                        return Long.toString(difference) + " minutes";
                case 3: difference = bdayDateTime.until( currentDateTime, ChronoUnit.HOURS);
                        return Long.toString(difference) + " hours";
                case 4: difference = bdayDateTime.until( currentDateTime, ChronoUnit.DAYS);
                        return Long.toString(difference) + " days";
                case 5: difference = bdayDateTime.until( currentDateTime, ChronoUnit.YEARS);
                        return Long.toString(difference) + " years";
            }
            return "NO INPUT FOUND";
        }
        catch (DateTimeParseException e) {
            return "ERROR, have you used the correct format?";
        }
    }
    public static String calculateDifference (String bday1, String bday2, int i){
        long difference = 0;
         try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM uuuu").withResolverStyle(ResolverStyle.STRICT);
            LocalDate bdayDate1 = LocalDate.parse(bday1,formatter);
            LocalDate bdayDate2 = LocalDate.parse(bday2,formatter);
            LocalTime time = LocalTime.now();
            LocalDateTime localBday1 = LocalDateTime.of(bdayDate1, time);
            LocalDateTime localBday2 = LocalDateTime.of(bdayDate2, time);
            switch(i){
                case 0: difference = localBday1.until( localBday2, ChronoUnit.MILLIS);
                        return Long.toString(difference) + " milliseconds";
                case 1: difference = localBday1.until( localBday2, ChronoUnit.SECONDS);
                        return Long.toString(difference) + " seconds";
                case 2: difference = localBday1.until( localBday2, ChronoUnit.MINUTES);
                        return Long.toString(difference) + " minutes";
                case 3: difference = localBday1.until( localBday2, ChronoUnit.HOURS);
                        return Long.toString(difference) + " hours";
                case 4: difference = localBday1.until( localBday2, ChronoUnit.DAYS);
                        return Long.toString(difference) + " days";
                case 5: difference = localBday1.until( localBday2, ChronoUnit.YEARS);
                        return Long.toString(difference) + " years";
            }
            return "NO INPUT FOUND";
        }
        catch (DateTimeParseException e) {
            return "ERROR, have you used the correct format?";
        }
    }
}
