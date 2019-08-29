package info.yeasin.eventbus.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import info.yeasin.eventbus.AppResponse;
import info.yeasin.eventbus.BusProvider;
import info.yeasin.eventbus.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //private Toolbar toolbar;
    private Button btnSimpleTabs, btnIconTextTabs, btnIconTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSimpleTabs = (Button) findViewById(R.id.btnSimpleTabs);
        btnIconTextTabs = (Button) findViewById(R.id.btnIconTextTabs);
        btnIconTabs = (Button) findViewById(R.id.btnIconTabs);

        btnSimpleTabs.setOnClickListener(this);
        btnIconTextTabs.setOnClickListener(this);
        btnIconTabs.setOnClickListener(this);

        JSONObject dataPassEventBus = new JSONObject();
        try {
            dataPassEventBus.put("code","Yeasin Ali");
            dataPassEventBus.put("message","Developer");
            dataPassEventBus.put("data","arafat");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        BusProvider.getBus().postSticky(AppResponse.build(dataPassEventBus));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSimpleTabs:
                startActivity(new Intent(MainActivity.this, SimpleTabsActivity.class));
                break;
            case R.id.btnIconTextTabs:
                startActivity(new Intent(MainActivity.this, IconTextTabsActivity.class));
                break;
            case R.id.btnIconTabs:
                startActivity(new Intent(MainActivity.this, IconTabsActivity.class));
                break;

        }
    }
}
