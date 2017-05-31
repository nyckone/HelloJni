package com.example.doron.hellojni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int num = 0;
        String tmp_prop_value_string;
        String prop_value_string = "";
        TextView tv = (TextView) findViewById(R.id.sample_text);

        /*
         * This loop goes through property number 0 untill the last property and concates it
         * to one string that we will eventually print
         */
        do {
            tmp_prop_value_string = getNthFormattedPropValueString(num);
            prop_value_string = prop_value_string + "\n" + tmp_prop_value_string;
            num++;
        } while(!"".equals(tmp_prop_value_string));

        tv.setText(prop_value_string);
    }

    /**
     * This function returns a prop:value string in the num place
     */
    public native String getNthFormattedPropValueString(int num);

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}
