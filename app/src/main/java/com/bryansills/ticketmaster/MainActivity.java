package com.bryansills.ticketmaster;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.ticketmaster.amgr.sdk.app.AmgrConfig;
import com.ticketmaster.amgr.sdk.app.AmgrGlobal;
import com.ticketmaster.amgr.sdk.fragment.AmgrSdkGatewayFragment;
import com.ticketmaster.amgr.sdk.objects.AmgrSdkEvent;


public class MainActivity extends ActionBarActivity implements AmgrSdkGatewayFragment.OnAmgrSdkEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AmgrConfig config = new AmgrConfig();

        config.setTicketMasterId(getResources().getString(R.string.ticketmaster_id));
        config.setPrimaryColor(getResources().getColor(R.color.red));

        try {
            AmgrGlobal.initialize(this, config);
        } catch (Exception ex) {
            // This is bad!
        }

        AmgrSdkGatewayFragment fragment = AmgrSdkGatewayFragment.getInstance();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, fragment).commit(); // Add Fragment to container.
    }

    @Override
    public void onAmgrSdkEvent(AmgrSdkEvent amgrSdkEvent) {

    }
}
