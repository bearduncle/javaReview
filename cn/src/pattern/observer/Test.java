package pattern.observer;

import java.util.Date;
import java.util.UUID;

public class Test {
    public static void main(String[] args) {
        ObjectData data=new ObjectData(new Date(),"多云");
        Object object=new ObjectImpl();
        Observer one=new ObserverOne();
        Observer two=new ObserverTwo();
        object.update(data);
        System.out.println("还没有观察者订阅主题");
        String oneUid="one";
        object.bindObserver(oneUid,one);
        object.update(data);
        System.out.println("观察者one订阅主题");
        String twoUid="two";
        object.bindObserver(twoUid,two);
        object.update(data);
        System.out.println("观察者one,two订阅主题");
        object.unBindObserver(twoUid);
        object.update(data);
        System.out.println("观察者two退订主题");

    }
}
