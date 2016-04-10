package yagotome.testepraticomobile;

import android.app.Application;

/**
 * Singleton da Application.
 */
public class ProvaMobileApplication extends Application {
    private static ProvaMobileApplication instance;
    public static ProvaMobileApplication getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
