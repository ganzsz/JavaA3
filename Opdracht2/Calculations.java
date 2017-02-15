import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Calculations{

    /**
    * Deze methode voert de calculaties uit voor de leeftijd in de diverse tijdeenheden.
    * @param A String die de datum van de eerste verjaardag bevat.
    * @param i Staat voor welke tijdseenheid gekozen is.
    * @return calculations geeft de juist tijdeenheid terug.
    */
    public static String calculateAge(String a, int i){

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        long [] calculations = new long [6];
        try{

            String birthDayString = a;

            Calendar bday1 = new GregorianCalendar();
            Calendar currentTime = Calendar.getInstance();
            bday1.setTime(formatter.parse(birthDayString));

            calculations[0] = currentTime.getTimeInMillis() - bday1.getTimeInMillis();
            calculations[1] = (currentTime.getTimeInMillis() - bday1.getTimeInMillis()) / 1000;
            calculations[2] = (currentTime.getTimeInMillis() - bday1.getTimeInMillis()) / 1000 / 60;
            calculations[3] = (currentTime.getTimeInMillis() - bday1.getTimeInMillis()) / 1000 / 60 / 60;
            calculations[4] = (currentTime.getTimeInMillis() - bday1.getTimeInMillis()) / 1000 / 60 / 60 /24;
            calculations[5] = (currentTime.getTimeInMillis() - bday1.getTimeInMillis()) / 1000 / 60 / 60 /24 / 365;
            if(Integer.parseInt(birthDayString.substring(0,2)) > 31 || (Integer.parseInt(birthDayString.substring(0,2)) < 1)){

                return "Date is not entered correctly";

            }

    }

        catch(ParseException e){
            return "Date is not entered correctly";
        }
        return String.valueOf(calculations[i]);
    }

    /**
    * Deze methode voert de calculaties uit voor het verschil tussen de 2 verjaardagen in de diverse tijdeenheden te berekenen.
    * @param A String die de datum van de eerste verjaardag bevat.
    * @param B string die de datum van de tweede verjaardag bevat.
    * @param i Staat voor welke tijdseenheid gekozen is.
    * @return calculations geeft de juist tijdeenheid terug.
    */
    public static String calculateDifference(String A, String B, int i){

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String birthDayString = A;
        String birthDayString2 = B;

        try{
            Calendar bday1 = new GregorianCalendar();
            Calendar bday2 = Calendar.getInstance();
            bday1.setTime(formatter.parse(birthDayString));
            bday2.setTime(formatter.parse(birthDayString2));
            long [] calculations = new long [6];

            calculations[0] =  bday2.getTimeInMillis() - bday1.getTimeInMillis();
            calculations[1] = (bday2.getTimeInMillis() - bday1.getTimeInMillis()) / 1000;
            calculations[2] = (bday2.getTimeInMillis() - bday1.getTimeInMillis()) / 1000 / 60;
            calculations[3] = (bday2.getTimeInMillis() - bday1.getTimeInMillis()) / 1000 / 60 / 60;
            calculations[4] = (bday2.getTimeInMillis() - bday1.getTimeInMillis()) / 1000 / 60 / 60 /24;
            calculations[5] = (bday2.getTimeInMillis() - bday1.getTimeInMillis()) / 1000 / 60 / 60 /24 / 365;

            if(calculations[i] < 0){
                //indien het getal negatief is word het positief gemaakt.
                calculations[i] -= calculations[i] * 2;
            }

            if(((Integer.parseInt(birthDayString.substring(0,2)) > 31 || (Integer.parseInt(birthDayString.substring(0,2)) < 1))) || (((Integer.parseInt(birthDayString2.substring(0,2)) > 31) || (Integer.parseInt(birthDayString2.substring(0,2)) < 1)))){

                return "Date is not entered correctly";

            }

            return String.valueOf(calculations[i]);
        }
        catch(ParseException e){
            return "Date is not entered correctly";
        }
    }
}
