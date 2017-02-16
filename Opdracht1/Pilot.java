import java.util.Random;


public class Pilot{
    Random rand = new Random();
    private int i  = rand.nextInt(200);
    public void calculate() throws PilotException{
        if(i == 42){
            throw new PilotException();
        }
    }
}
