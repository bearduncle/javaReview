package pattern.observer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ObjectImpl implements Object {

    //存放订阅了这个主题的观察者
    private Map<String,Observer> observerMap=new HashMap<>();

    @Override
    public void bindObserver(String bindID,Observer observer) {
        observerMap.put(bindID,observer);
    }

    @Override
    public void unBindObserver(String bindID) {
        observerMap.remove(bindID);
    }

    @Override
    public void update(ObjectData data) {
        Set<String> keys=observerMap.keySet();
        for(String key:keys){
            Observer observer=(Observer) observerMap.get(key);
            observer.update(data);
        }
    }
}
