package pl.fermich.pool;

public class PoolableObject {
    public void printObjectRef() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this);
    }
}
