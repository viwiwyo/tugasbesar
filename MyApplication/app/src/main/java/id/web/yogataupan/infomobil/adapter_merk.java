package id.web.yogataupan.infomobil;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by yogataupan on 03/12/2017.
 */

public class adapter_merk extends RecyclerView.Adapter<adapter_merk.HolderMerk> {
    //int img[];
    Context ctx;
    private MerkListener mListener;
    private List<DataMerk> list;
    /*
    public adapter_merk(Context ct, int i1[], MerkListener listener){
        ctx = ct;
        img = i1;
        mListener=listener;

    }*/

    interface MerkListener{
        void onClick(int position);
    }

    public adapter_merk(MerkListener mListener, Context ctx, List<DataMerk> list) {
        this.mListener = mListener;
        this.ctx = ctx;
        this.list = list;
    }

    public adapter_merk.HolderMerk onCreateViewHolder(ViewGroup parent, int viewType) {
        ctx = parent.getContext();
        View myMerkView = LayoutInflater.from(ctx).inflate(R.layout.row_merk,parent,false);
        return new adapter_merk.HolderMerk(myMerkView);
    }

    public void onBindViewHolder(HolderMerk holder, int position) {
        RecyclerView.LayoutParams  params = (RecyclerView.LayoutParams) holder.itemView.getLayoutParams();
        if(position == 0){
            params.topMargin = params.bottomMargin;
        }
        else{
            params.topMargin = 0;
        }
        //holder.t1.setText(list.get(position).getNama());
        //holder.t2.setText(list.get(position).getInfo());
        //holder.t1.setText(mjudul[position]);
        //holder.t2.setText(mket[position]);
        Glide.with(ctx).load(list.get(position).getGambarmerk()).into(holder.image_merk);
        Glide.with(ctx).load(list.get(position).getGambarmerk()).into(holder.image_merk);
        Log.d("MERKADAPTER", list.get(position).getGambarmerk());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class HolderMerk extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView image_merk;

        public HolderMerk(View itemView) {
            super(itemView);
            image_merk = itemView.findViewById(R.id.image_merk);
            image_merk.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onClick(getAdapterPosition());
        }
    }

}
