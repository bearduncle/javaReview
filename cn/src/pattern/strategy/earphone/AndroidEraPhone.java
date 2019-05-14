package pattern.strategy.earphone;

import pattern.strategy.insertPath.AndroidPath;

public class AndroidEraPhone extends EarPhone{
    public AndroidEraPhone() {
        this.insertPath=new AndroidPath();
    }

    @Override
    public void playMusic() {
        insertPath.insertPath();
    }
}
