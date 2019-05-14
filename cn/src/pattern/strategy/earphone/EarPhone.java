package pattern.strategy.earphone;

import pattern.strategy.insertPath.InsertPath;

public class EarPhone {
    InsertPath insertPath;

    public void setInsertPath(InsertPath insertPath) {
        this.insertPath = insertPath;
    }

    public void playMusic(){
        insertPath.insertPath();
    }
}
