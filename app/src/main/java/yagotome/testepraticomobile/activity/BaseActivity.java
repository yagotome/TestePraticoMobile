package yagotome.testepraticomobile.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import yagotome.testepraticomobile.ProvaMobileApplication;
import yagotome.testepraticomobile.R;

/**
 * Mãe das Activities do app.
 */
public class BaseActivity extends AppCompatActivity {
    protected ProvaMobileApplication app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = ProvaMobileApplication.getInstance();
    }

    /**
     * Adiciona a toolbar como action bar
     */
    protected void setUpActionBar(final int id) {
        if (findViewById(id) != null) {
            setSupportActionBar((Toolbar)findViewById(id));
        }
    }
}
