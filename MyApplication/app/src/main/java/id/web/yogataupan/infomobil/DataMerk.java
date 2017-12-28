package id.web.yogataupan.infomobil;

/**
 * Created by yogataupan on 19/12/2017.
 */

class DataMerk {
    String merk, gambarmerk;

    public DataMerk(){

    }
    public DataMerk(String merk, String gambarmerk){
        this.merk = merk;
        this.gambarmerk = gambarmerk;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getGambarmerk() {
        return gambarmerk;
    }

    public void setGambarmerk(String gambarmerk) {
        this.gambarmerk = gambarmerk;
    }

}
