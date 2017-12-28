package id.web.yogataupan.infomobil;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by yogataupan on 29/11/2017.
 */

public class adapter_atpm extends RecyclerView.Adapter<adapter_atpm.HolderATPM> {

    private adapter_atpm.ATPMListener mListener;
    private List<DataATPM> list;
    Context ctx;


    public adapter_atpm(adapter_atpm.ATPMListener mListener, Context ctx, List<DataATPM> list) {
        this.mListener = mListener;
        this.ctx = ctx;
        this.list = list;
    }

    interface ATPMListener {
        void onClick(int position);
    }

    @Override
    public adapter_atpm.HolderATPM onCreateViewHolder(ViewGroup parent, int viewType) {
        ctx = parent.getContext();
        View myOwnView = LayoutInflater.from(ctx).inflate(R.layout.row_atpm, parent, false);
        return new adapter_atpm.HolderATPM(myOwnView);
    }

    @Override
    public void onBindViewHolder(adapter_atpm.HolderATPM holder, int position) {
        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) holder.ItemView.getLayoutParams();
        if (position == 0) {
            params.topMargin = params.bottomMargin;
        } else {
            params.topMargin = 0;
        }
        holder.t1.setText(list.get(position).getNama());
        holder.t2.setText(list.get(position).getAlamat());
        Glide.with(ctx).load(list.get(position).getGambar()).into(holder.myImage);

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

   /* public String getJudul(int position) {
        return mjudul[position];
    }*/

    public class HolderATPM extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView t1;
        private TextView t2;
        ImageView myImage;
        private View ItemView;

        public HolderATPM(View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.nm_news);
            t2 = (TextView) itemView.findViewById(R.id.detnews);
            myImage = (ImageView) itemView.findViewById(R.id.imageatpm);
            ItemView = itemView;
            ItemView.setOnClickListener(this);

        }
      /*  public void setATPM(String judul,String ket){
            t1.setText(judul);
            t2.setText(ket);
        }*/

        @Override
        public void onClick(View v) {
            mListener.onClick(getAdapterPosition());
        }
    }
}
