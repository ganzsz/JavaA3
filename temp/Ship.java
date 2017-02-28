public class Ship{
    private Container[] container;
    private int containerID;
    public Ship(){
        containerID = 0;
        container = new Container[100];
        for(int i = 0; i < container.length; i++){
            container[i] = new Container(i);
        }
    }
    public synchronized Container getContainer(){
        Container temp = container[containerID];
        container[containerID] = null;
        containerID++;
        System.out.println("Schip : Container " + container[containerID].getContainerid() + " gegeven");
        return temp;
    }
}
