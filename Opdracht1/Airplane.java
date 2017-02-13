/**
* @author Tommie Terhoeve
* @version 1.0
* Dit is de airplane classe
*/
public class Airplane{
    //flap pointers
    Flap flap1 = new Flap();
    Flap flap2 = new Flap();
    //arrays om te registreren ofdat de onderdelen zijn gefaalt.
    private boolean [] flapFail = new boolean[2];
    private boolean [] engineFail = new boolean[4];
    private boolean [] pilotFail = new boolean[3];
    //engine pointers.
    Engine engine1 = new Engine();
    Engine engine2 = new Engine();
    Engine engine3 = new Engine();
    Engine engine4 = new Engine();
    //pilot pointers
    Pilot pilot1 = new Pilot();
    Pilot pilot2 = new Pilot();
    Pilot pilot3 = new Pilot();


    /**
    *Dit is de flight methode die de vlucht simuleert
    */
    public void flight() throws CrashException{
        //simuleer elk onderdeel en indien het onderdeel faalt word de boolean op true gezet.
        try{

        flap1.calculate();

        }

        catch(FlapException x){
            flapFail[0] = true;
        }

        try{

        flap2.calculate();

        }

        catch(FlapException x){
            flapFail[1] = true;

        }

        try{

        engine1.calculate();

        }

        catch(EngineException x){
            engineFail[0] = true;

        }

        try{

        engine2.calculate();

        }

        catch(EngineException x){
            engineFail[1] = true;

        }

        try{

        engine3.calculate();

        }

        catch(EngineException x){
            engineFail[2] = true;

        }

        try{

        engine4.calculate();

        }

        catch(EngineException x){
            engineFail[3] = true;

        }

        try{

        pilot1.calculate();

        }

        catch(PilotException x){
            pilotFail[0] = true;

        }

        try{

        pilot2.calculate();

        }

        catch(PilotException x){
            pilotFail[1] = true;

        }

        try{

        pilot3.calculate();

        }

        catch(PilotException x){
            pilotFail[2] = true;

        }


        if((flapFail[0] == true && flapFail[1] == true) || ((engineFail[1] == true && engineFail[2] == true ) && (engineFail[0] == true || engineFail[3] == true)) || (pilotFail[0] == true && pilotFail[1] == true && pilotFail[2] == true)){
            throw new CrashException();
            }
    }

    //getters, setters niet nodig.
    public int getFlapFail(int i){
        if(flapFail[i] == true){
            return 1;
        }
        return 0;
    }

    public int getEngineFail(int i){
        if(engineFail[i] == true){
            return 1;
        }
        return 0;
    }

    public int getPilotFail(int i){
        if(pilotFail[i] == true){
             return 1;
        }
        return 0;
    }
}
