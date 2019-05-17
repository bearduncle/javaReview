package pattern.observer;

public class ObserverTwo implements Observer {
    @Override
    public void update(ObjectData data) {
        System.out.println("observerTwo接收到的数据:"+data.toString());
    }
}
