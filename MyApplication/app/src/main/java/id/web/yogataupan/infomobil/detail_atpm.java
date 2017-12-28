package id.web.yogataupan.infomobil;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class detail_atpm extends AppCompatActivity {
    private ArrayList<Integer>ATPM_ImageID;
    private int[] gambar;
    private DataATPM data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_atpm);
        ActionBar toolbar=getSupportActionBar();
        toolbar.setDisplayHomeAsUpEnabled(true);
        bindData();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void bindData() {
        Intent intent = getIntent();
        Gson gson = new Gson();
        data = gson.fromJson(intent.getStringExtra(Intent.EXTRA_TEXT), new TypeToken<DataATPM>(){}.getType());
        TextView tv_nama=(TextView)findViewById(R.id.nm_news);
        TextView tv_keter = (TextView) findViewById(R.id.detnews);
        ImageView image = (ImageView) findViewById(R.id.imageatpm);
        tv_nama.setText(data.getNama());
        tv_keter.setText(data.getAlamat());
        Glide.with(this).load(data.getGambar()).into(image);

    }
    /*
    public void btt_lokasi(View view) {
        Intent intent = new Intent(this,MapsActivity.class);
        intent.putExtra("lokasi",data.getLokasi());
        startActivity(intent);

    }*/
}
