package id.web.yogataupan.infomobil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class detail_tipe_mobil extends AppCompatActivity {
    private int[] gambar;
    private DataTipe data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tipe_mobil);
        ActionBar toolbar = getSupportActionBar();
        toolbar.setDisplayHomeAsUpEnabled(true);
        bindData();
    }


    private void bindData() {
        Intent intent = getIntent();
        Gson gson = new Gson();
        data = gson.fromJson(intent.getStringExtra(Intent.EXTRA_TEXT), new TypeToken<DataTipe>() {}.getType());
        TextView tv_nama = (TextView) findViewById(R.id.text1);
        TextView tv_keter = (TextView) findViewById(R.id.text2);
        ImageView image = (ImageView) findViewById(R.id.imageView);
        tv_nama.setText(data.getNama());
        tv_keter.setText(data.getSpek());
        Glide.with(this).load(data.getGambar()).into(image);

    }
}
