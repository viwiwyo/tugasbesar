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

public class lokasi_atpm extends AppCompatActivity implements adapter_atpm.ATPMListener {

    RecyclerView r1;
    // String s1[],s2[];
    //public static final String POSITION = "position";
    //int imageResource[]={R.drawable.toyota,R.drawable.honda,R.drawable.suzuki,R.drawable.daihatsu,R.drawable.nissan};
    adapter_atpm ad;
    private List<DataATPM> list;

    private FirebaseDatabase database;
    private DatabaseReference references;
    private ValueEventListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lokasi_atpm);
        r1=(RecyclerView)findViewById(R.id.viewatpm);
        database = FirebaseDatabase.getInstance();
        references = database.getReference("atpm");
        r1.setLayoutManager(new LinearLayoutManager(this));
        tambahListener();
    }


    @Override
    public void onClick(int position) {
        Intent intent = new Intent(this,detail_atpm.class);
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
                            DataATPM data = child.getValue(DataATPM.class);
                            list.add(data);
                        }
                        ad = new adapter_atpm(lokasi_atpm.this,lokasi_atpm.this, list);
                        r1.setAdapter(ad);
                    }
                    else{
                        Toast.makeText(lokasi_atpm.this,"kosong",Toast.LENGTH_SHORT).show();
                    }
                    Log.d("MainLokasi", "Count : " + dataSnapshot.getChildrenCount());

                }
                else{
                    Log.d("MainLokasi", "NULL" );
                    Toast.makeText(lokasi_atpm.this,"kosong",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(lokasi_atpm.this,"error",Toast.LENGTH_SHORT).show();
            }
        };
        references.addListenerForSingleValueEvent(listener);
    }

}
