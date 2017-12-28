package id.web.yogataupan.infomobil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class tipe_mobil extends AppCompatActivity implements adapter_tipe.TipeListener {

    RecyclerView r1;
    //String s1[],s2[];
    //public static final String POSITION = "position";
    adapter_tipe ad;
    private List<DataTipe> list;

    private FirebaseDatabase database;
    private DatabaseReference references;
    private ValueEventListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipe_mobil);
        r1=(RecyclerView)findViewById(R.id.viewtipe);
        database = FirebaseDatabase.getInstance();
        references = database.getReference("mobil").child(getIntent().getStringExtra(Intent.EXTRA_TEXT).toLowerCase());
        //s1=getResources().getStringArray(R.array.nama_tipe);
        //s2=getResources().getStringArray(R.array.harga);
        //ad=new adapter_tipe(this, s2, s1,this);
        //r1.setAdapter(ad);
        r1.setLayoutManager(new LinearLayoutManager(this));
        tambahListener();
    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(this,detail_tipe_mobil.class);
        Gson gson = new Gson();
        String data = gson.toJson(list.get(position));
        intent.putExtra(Intent.EXTRA_TEXT, data);
        startActivity(intent);
    }

    public void tambahListener(){
        listener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot != null){
                    if(dataSnapshot.getChildrenCount() > 0){
                        list = new ArrayList<>();
                        for(DataSnapshot child : dataSnapshot.getChildren()){
                            DataTipe data = child.getValue(DataTipe.class);
                            list.add(data);
                        }
                        ad = new adapter_tipe(tipe_mobil.this,tipe_mobil.this, list);
                        r1.setAdapter(ad);
                    }
                    else{
                        Toast.makeText(tipe_mobil.this,"kosong",Toast.LENGTH_SHORT).show();
                    }
                    Log.d("MainTipe", "Count : " + dataSnapshot.getChildrenCount());

                }
                else{
                    Log.d("MainTipe", "NULL" );
                    Toast.makeText(tipe_mobil.this,"kosong",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(tipe_mobil.this,"error",Toast.LENGTH_SHORT).show();
            }
        };
        references.addListenerForSingleValueEvent(listener);
    }
}