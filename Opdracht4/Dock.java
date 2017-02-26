public class Dock{
    private Container[] container = new Container[100];

    public synchronized void placeContainer(Container container, int i){
        System.out.println("Dock : Container" + i + " gekregen");
        System.out.println("");
        this.container[i] = container;
    }
}
