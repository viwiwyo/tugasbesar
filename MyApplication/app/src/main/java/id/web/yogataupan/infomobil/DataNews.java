package id.web.yogataupan.infomobil;

/**
 * Created by Vivi Widyawati on 12/21/2017.
 */

class DataNews {
    String isi, judul, gambar;

    public DataNews(){

    }

    public DataNews(String isi, String judul, String gambar){
        this.isi=isi;
        this.judul=judul;
        this.gambar=gambar;
    }
    public String getIsi(){return isi; }
    public void setIsi(String isi){this.isi=isi; }
    public String getJudul(){return judul; }
    public void setJudul(String judul){this.judul=judul; }
    public String getGambar(){return gambar; }
    public void setGambar(String gambar){this.gambar=gambar; }

}
