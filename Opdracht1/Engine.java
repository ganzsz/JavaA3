import java.util.Random;


public class Engine{
    Random rand = new Random();
    private int i  = rand.nextInt(1000);
    public void calculate() throws EngineException{
            if(i == 420){
                throw new EngineException();
            }
        }
    }
