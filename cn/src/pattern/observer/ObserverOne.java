package pattern.observer;

public class ObserverOne implements Observer {
    @Override
    public void update(ObjectData data) {
        System.out.println("observerOne接收到的数据:"+data.toString());
    }
}
