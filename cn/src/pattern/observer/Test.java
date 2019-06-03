package pattern.observer;

import java.util.Date;
/*
* 观察者模式
* 可以看成报社(主题)- -订阅者(观察者)的一个系统
* 主题方是更新数据后通知所有观察者的一方,而在主题方注册的观察者都可以接收到主题最新的数据
* 比如:招聘软件(主题)更新一些招聘信息通知给找工作的人(观察者)
*      QQ群聊:每个群里面的成员既是主题又是观察者,游戏里面的喇叭喊话
* */
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
