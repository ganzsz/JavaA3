/**
* @author Tommie Terhoeve
* @version 1.0
* Dit is de Recorder klasse
*/
public class Recorder{
    /**
    * Dit is de methode simulate die de Airplane objecten aanmaakt en defecte onderdelen registreerd.
    */
    public void simulate(){
        int crashes = 0;
        int [] flapFail = new int[2];
        int [] engineFail = new int[4];
        int [] pilotFail = new int[3];
        String crashedNumbers = "Dit zijn de neergestorte vliegtuigen: ";
        String crashDetails = "Dit is er gebeurt op vlucht: ";
        for(int i = 0; i < 1000000; i++){
            Airplane plane = new Airplane();
            //simuleer de vlucht
            try{
            plane.flight();
            }
            //indien het vliegtuig is gecrasht.
            catch(CrashException x){
                crashes++;
                crashedNumbers = crashedNumbers + i + ",";
                //details over crash
                crashDetails = crashDetails + i;
                if(plane.getFlapFail(0) == 1 && plane.getFlapFail(1) == 1){
                    crashDetails = crashDetails + " De flaps zijn beide defect geraakt. ";
                }
                if((plane.getEngineFail(1) == 1 && plane.getEngineFail(2) == 1) && (plane.getEngineFail(0) == 1 || plane.getEngineFail(3) == 1)){
                    crashDetails = crashDetails + " Motoren 2 en 3 zijn uitgevallen. ";
                }
                if(plane.getPilotFail(0) == 1 && plane.getPilotFail(1) == 1 && plane.getPilotFail(2) == 1){
                    crashDetails = crashDetails + " Alle piloten waren door onbekende omstandigheden niet in staat om het vliegtuig te besturen. ";
                }
                System.out.println(crashDetails);
                System.out.println("");
                System.out.println("");
                crashDetails = "Dit is er gebeurt op vlucht: ";
            }
            //totale aantal waarden uitrekenen
            for(int j = 0; j < 2; j++){
                flapFail[j] += plane.getFlapFail(j);
            }
            for(int j = 0; j < 4; j++){
                engineFail[j] += plane.getEngineFail(j);
            }
            for(int j = 0; j < 3; j++){
                pilotFail[j] += plane.getPilotFail(j);
            }
            //indien de simulatie voledig is doorgelopen.
            if(i == 999999){
                if(crashes == 0){
                    crashedNumbers = "Er zijn geen neergestorte vliegtuigen";
                }
                System.out.println("Het aantal crashes: " + crashes);
                System.out.println(crashedNumbers);
                System.out.println("Het aantal gefaalde flaps 1 : " + flapFail[0]);
                System.out.println("Het aantal gefaalde flaps 2 : " + flapFail[1]);

                System.out.println("Het aantal gefaalde engines 1 : " + engineFail[0]);
                System.out.println("Het aantal gefaalde engines 2 : " + engineFail[1]);
                System.out.println("Het aantal gefaalde engines 3 : " + engineFail[2]);
                System.out.println("Het aantal gefaalde engines 4: " + engineFail[3]);

                System.out.println("Het aantal gefaalde pilots 1 : " + pilotFail[0]);
                System.out.println("Het aantal gefaalde pilots 2 : " + pilotFail[1]);
                System.out.println("Het aantal gefaalde pilots 3 : " + pilotFail[2]);
            }
        }
    }
}
