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
 * Created by yogataupan on 03/12/2017.
 */
public class adapter_news extends RecyclerView.Adapter<adapter_news.HolderNews> {

    private adapter_news.NewsListener mListener;
    private List<DataNews> list;
    Context ctx;


    public adapter_news(adapter_news.NewsListener mListener, Context ctx, List<DataNews> list){
        this.mListener = mListener;
        this.ctx = ctx;
        this.list = list;
    }

    interface NewsListener{
        void onClick(int position);
    }

    @Override
    public adapter_news.HolderNews onCreateViewHolder(ViewGroup parent, int viewType) {
        ctx = parent.getContext();
        View myOwnView = LayoutInflater.from(ctx).inflate(R.layout.row_news,parent,false);
        return new adapter_news.HolderNews(myOwnView);
    }

    @Override
    public void onBindViewHolder(adapter_news.HolderNews holder, int position) {
        RecyclerView.LayoutParams  params = (RecyclerView.LayoutParams) holder.ItemView.getLayoutParams();
        if(position == 0){
            params.topMargin = params.bottomMargin;
        }
        else{
            params.topMargin = 0;
        }
        holder.t1.setText(list.get(position).getIsi());
        holder.t2.setText(list.get(position).getJudul());
        Glide.with(ctx).load(list.get(position).getGambar()).into(holder.myImage);

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    /*public String getJudul(int position) {
        return mjudul[position];
    }*/

    public class HolderNews extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView t1;
        private TextView t2;
        ImageView myImage;
        private View ItemView;

        public HolderNews(View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.nm_news);
            t2 = (TextView) itemView.findViewById(R.id.detnews);
            myImage = (ImageView)itemView.findViewById(R.id.imagenews);
            ItemView = itemView;
            ItemView.setOnClickListener(this);

        }
        /*public void setNews(String judul,String ket){
            t1.setText(judul);
            t2.setText(ket);
        }*/
        @Override
        public void onClick(View v) {
            mListener.onClick(getAdapterPosition());
        }
    }
}