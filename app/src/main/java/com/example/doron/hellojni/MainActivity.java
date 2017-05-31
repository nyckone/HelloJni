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
        // Example of a call to a native method
        do {
            tmp_prop_value_string = stringFromJNI(num);
            prop_value_string = prop_value_string + "\n" + tmp_prop_value_string;
            num++;
        } while(!"".equals(tmp_prop_value_string));

        tv.setText(prop_value_string);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI(int num);

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}
