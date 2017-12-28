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

public class news_info extends AppCompatActivity implements adapter_news.NewsListener {

    RecyclerView r1;
    adapter_news ad;
    private List<DataNews> list;

    private FirebaseDatabase database;
    private DatabaseReference references;
    private ValueEventListener listener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_info);
        r1=(RecyclerView)findViewById(R.id.viewNews);
        database = FirebaseDatabase.getInstance();
        references = database.getReference("berita");
        r1.setLayoutManager(new LinearLayoutManager(this));
        tambahListener();
    }


    @Override
    public void onClick(int position) {
        Intent intent = new Intent(this,detail_news.class);
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
                            DataNews data = child.getValue(DataNews.class);
                            list.add(data);
                        }
                        ad = new adapter_news(news_info.this,news_info.this, list);
                        r1.setAdapter(ad);
                    }
                    else{
                        Toast.makeText(news_info.this,"kosong",Toast.LENGTH_SHORT).show();
                    }
                    Log.d("MainNews", "Count : " + dataSnapshot.getChildrenCount());

                }
                else{
                    Log.d("MainNews", "NULL" );
                    Toast.makeText(news_info.this,"kosong",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(news_info.this,"error",Toast.LENGTH_SHORT).show();
            }
        };
        references.addListenerForSingleValueEvent(listener);
    }
}
