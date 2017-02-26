public class Ship{

    private Container[] container = new Container[100];
    private int containerID = 0;

    public Ship(){
        for(int i = 0; i < container.length; i++){
            container[i] = new Container(i);
        }
    }
    public synchronized Container getContainer(){
        containerID++;
        System.out.println("Schip : Container " + containerID + " gegeven");
        return container[containerID];
    }
    public synchronized int getContainerID(){
        return containerID;
    }
}
