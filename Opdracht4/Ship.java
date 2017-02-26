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
        System.out.println("Schip : Container " + (containerID+1) + " gegeven");
        containerID++;
        return temp;
    }
    public synchronized int getContainerID(){
        return containerID;
    }
}
