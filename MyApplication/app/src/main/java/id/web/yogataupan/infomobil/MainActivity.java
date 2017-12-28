package id.web.yogataupan.infomobil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btt_merk(View view) {
        Intent intent = new Intent(MainActivity.this,merk_mobil.class);
        startActivity(intent);
    }

    public void btt_news(View view) {
        Intent intent = new Intent(MainActivity.this,news_info.class);
        startActivity(intent);
    }

    public void btt_lokasi(View view) {
        Intent intent = new Intent(MainActivity.this,lokasi_atpm.class);
        startActivity(intent);
    }

    public void btt_keluar(View view) {
        Intent exit = new Intent(Intent.ACTION_MAIN);
        exit.addCategory(Intent.CATEGORY_HOME);
        exit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(exit);
    }
}