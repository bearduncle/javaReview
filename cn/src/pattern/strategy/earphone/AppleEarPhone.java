package pattern.strategy.earphone;

import pattern.strategy.insertPath.ApplePath;

public class AppleEarPhone extends EarPhone {

    public AppleEarPhone() {
        this.insertPath=new ApplePath();
    }

    @Override
    public void playMusic() {
        this.insertPath.insertPath();
    }
}
