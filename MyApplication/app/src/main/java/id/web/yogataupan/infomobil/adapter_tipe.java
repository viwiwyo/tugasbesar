package id.web.yogataupan.infomobil;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/**
 * Created by yogataupan on 23/11/2017.
 */
public class adapter_tipe extends RecyclerView.Adapter<adapter_tipe.HolderTipe> {

    private adapter_tipe.TipeListener mListener;
    private List<DataTipe> list;
    Context ctx;


    public adapter_tipe(TipeListener mListener, Context ctx, List<DataTipe> list) {
        this.mListener = mListener;
        this.ctx = ctx;
        this.list = list;

    }

    interface TipeListener {
        void onClick(int position);
    }

    @Override
    public HolderTipe onCreateViewHolder(ViewGroup parent, int viewType) {
        ctx = parent.getContext();
        View myOwnView = LayoutInflater.from(ctx).inflate(R.layout.row_tipe, parent, false);
        return new HolderTipe(myOwnView);
    }

    @Override
    public void onBindViewHolder(adapter_tipe.HolderTipe holder, int position) {
        RecyclerView.LayoutParams  params = (RecyclerView.LayoutParams) holder.ItemView.getLayoutParams();
        if(position == 0){
            params.topMargin = params.bottomMargin;
        }
        else{
            params.topMargin = 0;
        }
        holder.t1.setText(list.get(position).getNama());
        holder.t2.setText(list.get(position).getHarga());
        //holder.t1.setText(mjudul[position]);
        //holder.t2.setText(mket[position]);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

   /* public String getJudul(int position) {
        return mjudul[position];
    }*/

    public class HolderTipe extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView t1;
        private TextView t2;
        ImageView myImage;
        private View ItemView;

        public HolderTipe(View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.text1);
            t2 = (TextView) itemView.findViewById(R.id.text2);
            myImage = (ImageView)itemView.findViewById(R.id.imageView);
            ItemView = itemView;
            ItemView.setOnClickListener(this);

        }
/*
        public void setTipe(String judul, String ket) {
            t1.setText(judul);
            t2.setText(ket);
        }*/

        @Override
        public void onClick(View v) {
            mListener.onClick(getAdapterPosition());
        }
    }
}