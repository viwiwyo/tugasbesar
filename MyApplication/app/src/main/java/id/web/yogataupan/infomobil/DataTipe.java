package id.web.yogataupan.infomobil;

/**
 * Created by yogataupan on 20/12/2017.
 */

class DataTipe {
    String nama, merk, harga, spek,gambar;

    public DataTipe(){

    }

    public DataTipe(String nama, String merk, String harga, String spek, String gambar){
        this.nama=nama;
        this.merk=merk;
        this.harga=harga;
        this.spek=spek;
        this.gambar=gambar;
    }
    public String getNama(){return nama; }
    public void setNama(String nama){this.nama=nama; }
    public String getMerk(){return merk; }
    public void setMerk(String merk){this.merk=merk; }
    public String getHarga(){return harga; }
    public void setHarga(String harga){this.harga=harga; }
    public String getSpek(){return spek; }
    public void setSpek(String spek){this.spek=spek; }
    public String getGambar(){return gambar; }
    public void setGambar(String gambar){this.gambar=gambar; }



}
