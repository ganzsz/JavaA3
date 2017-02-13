import java.util.Random;


public class Flap{
    Random rand = new Random();
    private int i  = rand.nextInt(2000);
    public void calculate() throws FlapException{
            if(i == 420){
                throw new FlapException();
            }
        }
    }
