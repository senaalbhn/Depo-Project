import java.util.List;

public class Urunler {
    /*
     id
      urunIsmi
      uretici
      miktar
      birim ve
      raf (6 adet fields mevcut)
     */

    private int id= 1000;
    private String urunIsmi;
    private String uretici;
    private double miktar=0;
    private String birim;
    private String raf="-";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrunIsmi() {
        return urunIsmi;
    }

    public void setUrunIsmi(String urunIsmi) {
        this.urunIsmi = urunIsmi;
    }

    public String getUretici() {
        return uretici;
    }

    public void setUretici(String uretici) {
        this.uretici = uretici;
    }

    public double getMiktar() {
        return miktar;
    }

    public void setMiktar(double miktar) {
        this.miktar = miktar;
    }

    public String getBirim() {
        return birim;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public String getRaf() {
        return raf;
    }

    public void setRaf(String raf) {
        this.raf = raf;
    }

    public Urunler() {
    }

    public Urunler(int id, String urunIsmi, String uretici, double miktar, String birim, String raf) {
        this.id = id;
        this.urunIsmi = urunIsmi;
        this.uretici = uretici;
        this.miktar = miktar;
        this.birim = birim;
        this.raf = raf;
    }

    @Override
    public String toString() {
        return "Urunler{" +
                "id=" + id +
                ", Urun Ismi='" + urunIsmi + '\'' +
                ", Uretici='" + uretici + '\'' +
                ", Miktar=" + miktar +
                ", Birim='" + birim + '\'' +
                ", Raf='" + raf + '\'' +
                '}';
    }











































}
