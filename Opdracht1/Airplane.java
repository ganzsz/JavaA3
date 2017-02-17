/**
* @author Tommie Terhoeve
* @version 1.0
* Dit is de airplane classe
*/
public class Airplane{
    //arrays om te registreren ofdat de onderdelen zijn gefaalt.
    private boolean [] flapFail = new boolean[2];
    private boolean [] engineFail = new boolean[4];
    private boolean [] pilotFail = new boolean[3];
    //onderdelen
    private Engine [] engineList = new Engine[4];
    private Flap [] flapList = new Flap[2];
    private Pilot [] pilotList = new Pilot[3];


    /**
    *Dit is de flight methode die de vlucht simuleert
    *@throws CrashException crashed
    */
    public void flight() throws CrashException{
        for(int i = 0; i < 2; i++){
            try{
                flapList[i] = new Flap();
                flapList[i].calculate();
            }
            catch(FlapException x){
                flapFail[i] = true;
            }
        }
        for(int i = 0; i < 4; i++){
            try{
                engineList[i] = new Engine();
                engineList[i].calculate();
            }
            catch(EngineException x){
                engineFail[i] = true;
            }
        }
        for(int i = 0; i < 3; i++){
            try{
                pilotList[i] = new Pilot();
                pilotList[i].calculate();
            }
            catch(PilotException x){
                pilotFail[i] = true;
            }
        }
        //simuleer elk onderdeel en indien het onderdeel faalt word de boolean op true gezet.
        if((flapFail[0] && flapFail[1]) || ((engineFail[1] && engineFail[2]) && (engineFail[0] || engineFail[3])) || (pilotFail[0] && pilotFail[1] && pilotFail[2])){
            throw new CrashException();
        }
    }
    //getters
    public int getFlapFail(int i){
        if(flapFail[i]){
            return 1;
        }
        return 0;
    }

    public int getEngineFail(int i){
        if(engineFail[i]){
            return 1;
        }
        return 0;
    }

    public int getPilotFail(int i){
        if(pilotFail[i]){
             return 1;
        }
        return 0;
    }
}
