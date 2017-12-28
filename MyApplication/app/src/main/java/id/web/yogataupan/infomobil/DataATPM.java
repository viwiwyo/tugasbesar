package id.web.yogataupan.infomobil;

/**
 * Created by Vivi Widyawati on 12/28/2017.
 */

public class DataATPM {
    String alamat, gambar, lokasi, nama, telp;

    public DataATPM(){

    }
    public DataATPM(String alamat, String gambar, String lokasi, String nama, String telp){
        this.alamat = alamat;
        this.gambar = gambar;
        this.lokasi = lokasi;
        this.nama = nama;
        this.telp = telp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }
}
