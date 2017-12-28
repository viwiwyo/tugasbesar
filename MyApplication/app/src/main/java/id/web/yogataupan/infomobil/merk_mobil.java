package id.web.yogataupan.infomobil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
public class merk_mobil extends AppCompatActivity implements adapter_merk.MerkListener {

    RecyclerView r1;
    //    public static final String POSITION = "position";
    //  int imageResource[]={R.drawable.audi,R.drawable.daihatsu,R.drawable.honda,R.drawable.kia,R.drawable.mitsubishi};
    adapter_merk ad;
    //private int[] gambar;
    private List<DataMerk> list;

    private FirebaseDatabase database;
    private DatabaseReference references;
    private ValueEventListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merk_mobil);
        r1 = (RecyclerView) findViewById(R.id.grid_merk);
        database = FirebaseDatabase.getInstance();
        references = database.getReference("gambar");
        //r1.setAdapter(ad);
        r1.setLayoutManager(new LinearLayoutManager(this));
        tambahListener();
        //r1.setLayoutManager(manager);
        //r1.setHasFixedSize(true);
        //r1.setAdapter(ad);
    }


    @Override
    public void onClick(int position) {
        Intent intent = new Intent(this, tipe_mobil.class);
        intent.putExtra(Intent.EXTRA_TEXT, list.get(position).getMerk());
        startActivity(intent);
    }

    public void tambahListener() {
        listener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    if (dataSnapshot.getChildrenCount() > 0) {
                        list = new ArrayList<>();
                        for (DataSnapshot child : dataSnapshot.getChildren()) {
                            DataMerk data = child.getValue(DataMerk.class);
                            list.add(data);
                            Log.d("MERK MOBIL", data.getGambarmerk());
                        }
                        ad = new adapter_merk(merk_mobil.this, merk_mobil.this, list);
                        r1.setAdapter(ad);
                    } else {
                        Toast.makeText(merk_mobil.this, "kosong", Toast.LENGTH_SHORT).show();
                    }
                    Log.d("MainMerk", "Count : " + dataSnapshot.getChildrenCount());

                } else {
                    Log.d("MainMerk", "NULL");
                    Toast.makeText(merk_mobil.this, "kosong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(merk_mobil.this, "error", Toast.LENGTH_SHORT).show();
            }
        };
        references.addListenerForSingleValueEvent(listener);
    }
}