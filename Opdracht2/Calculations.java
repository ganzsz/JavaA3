import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Calculations{

    /**
    * Deze methode voert de calculaties uit voor de leeftijd in de diverse tijdeenheden.
    * @param A String die de datum van de eerste verjaardag bevat.
    * @param i Staat voor welke tijdseenheid gekozen is.
    * @return calculations geeft de juist tijdeenheid terug.
    */
    public static String calculateAge(String A, int i){

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        long [] calculations = new long [6];
        try{

            String birthDayString = A;
            //probeer de string om te zetten naar een datum.
            Date currentDate = new Date();
            Date birthDay1 = formatter.parse(birthDayString);
            calculations[0] = (currentDate.getTime() - birthDay1.getTime());
            calculations[1] = (currentDate.getTime() - birthDay1.getTime()) / 1000;
            calculations[2] = (currentDate.getTime() - birthDay1.getTime()) / 1000 / 60;
            calculations[3] = (currentDate.getTime() - birthDay1.getTime()) / 1000 / 60 / 60;
            calculations[4] = (currentDate.getTime() - birthDay1.getTime()) / 1000 / 60 / 60 /24;
            calculations[5] = (currentDate.getTime() - birthDay1.getTime()) / 1000 / 60 / 60 /24 / 365;
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
            long [] calculations = new long [6];

            Date currentDate = new Date();
            Date birthDay1 = formatter.parse(birthDayString);
            Date birthDay2 = formatter.parse(birthDayString2);
            calculations[0] = (birthDay2.getTime() - birthDay1.getTime());
            calculations[1] = (birthDay2.getTime() - birthDay1.getTime()) / 1000;
            calculations[2] = (birthDay2.getTime() - birthDay1.getTime()) / 1000 / 60;
            calculations[3] = (birthDay2.getTime() - birthDay1.getTime()) / 1000 / 60 / 60;
            calculations[4] = (birthDay2.getTime() - birthDay1.getTime()) / 1000 / 60 / 60 /24;
            calculations[5] = (birthDay2.getTime() - birthDay1.getTime()) / 1000 / 60 / 60 /24 / 365;

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
