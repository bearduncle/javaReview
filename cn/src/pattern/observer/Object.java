package pattern.observer;

public interface Object {
    //观察者订阅
    void bindObserver(String bindID,Observer observer);
    //观察者解绑
    void unBindObserver(String bindID);
    //更新主题是
    void update(ObjectData data);
}
