package id.eightstudio.danboru.practicefunction.SplashScreen;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import id.eightstudio.danboru.practicefunction.MainActivity;
import id.eightstudio.danboru.practicefunction.R;

public class SplashScreen extends Activity {

    //Tag logger
    private static final String TAG = "SplashScreen";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Fullscreen mode
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Thread untuk menjalankan activity
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //Set Thread duration
                    Thread.sleep(3000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Log.d(TAG, "run: berhasil running intent");
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
        //Menjalankan thred
        thread.start();
    }
}
