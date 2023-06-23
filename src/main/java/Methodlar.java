import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Methodlar extends Urunler{
    Scanner scan = new Scanner(System.in);
    List<String> urunIsmiList = new ArrayList<>();
    List<String> ureticiList = new ArrayList<>();
    List<String> birimList = new ArrayList<>();
    List<Double> miktarList = new ArrayList<>();
    List<Integer> idList = new ArrayList<>();
    List<String> rafList = new ArrayList<>();
    int urunIndex;
    String stringId;
    int urunId;
    public void menuSor(){
        System.out.println("Ana menu icin =====> A   Cikmak icin =====> Q giriniz");
        char ch = scan.next().toUpperCase().charAt(0);
        if (ch=='A'){
            menu();
        }else if (ch=='Q'){
            menuCikis();
        }else {
            System.out.println("\u001B[31mGecersiz giris yaptiniz. Lutfen tekrar deneyiniz.\u001B[0m");
            menuSor();
        }
    }
    public void urunTanimla() {
        System.out.println("Urun Tanimla  ==>");
        System.out.print("Urun ismini giriniz: ");
        setUrunIsmi(scan.next());
        urunIsmiList.add(getUrunIsmi());
        idList.add(getId());
        setId(getId() + 1);
        System.out.print("Lutfen uretici adini giriniz: ");
        setUretici(scan.next());
        ureticiList.add(getUretici());
        birimsec();
        miktarList.add(getMiktar());
        rafList.add(getRaf());
        urunListeleCagir();
        menuSor();
    }
    private void birimsec() {
        System.out.print("Lutfen urunun birimini giriniz: ");
        setBirim(scan.next());
        birimList.add(getBirim());
    }
    public void urunListele() {
        System.out.println("Urun Listele ==>");
        System.out.println("  Id     Urun Adi    Uretici    Miktar     Birim      Raf");
        System.out.println("------  ----------  ---------  --------   -------    -----");
        for (int i = 0; i < urunIsmiList.size(); i++) {
            System.out.printf("%5d    %-11s %-10s %-10.2f %-6s %5s",
                    idList.get(i), urunIsmiList.get(i), ureticiList.get(i), miktarList.get(i), birimList.get(i), rafList.get(i));
            System.out.println();
        } menuSor();
    }
    public void urunListeleCagir() {
        System.out.println("  Id     Urun Adi    Uretici    Miktar     Birim      Raf");
        System.out.println("------  ----------  ---------  --------   -------    -----");
        for (int i = 0; i < urunIsmiList.size(); i++) {
            System.out.printf("%5d    %-11s %-10s %-10.2f %-6s %5s",
                    idList.get(i), urunIsmiList.get(i), ureticiList.get(i), miktarList.get(i), birimList.get(i), rafList.get(i));
            System.out.println();
        }
    }
    public void urunGirisi() {
        urunListeleCagir();
        System.out.println("Urun Girisi  ==>");
        idKontrol();
        rafaKoy(urunIndex);
        System.out.print("Giris yapacaginiz '" +urunIsmiList.get(urunIndex)+ "' miktarini giriniz :");
        double urunMiktari=scan.nextDouble();
        miktarList.set(urunIndex,miktarList.get(urunIndex)+urunMiktari);
        System.out.println("Urun Girisi  ==> Id: "+idList.get(urunIndex)+"  Urun Miktari: "+urunMiktari);
        urunListeleCagir();
        menuSor();
    }
    public void rafaKoy(int urunIndex) {
        if (rafList.get(urunIndex).equals("-")){
            System.out.println("Lutfen raf ismini yaziniz");
            String raf=scan.next();
            rafList.set(urunIndex,raf);
        }
    }
    public int idKontrol(){
        System.out.print("Listeye gore islem yapmak istediginiz Urunun Id'sini giriniz : ");
        stringId= scan.next();
        char charId=stringId.charAt(0);
        if((int)charId<49 || (int)charId>57){
            System.out.println("\u001B[31mHatalı giriş! Lutfen listeye gore bir ID deger giriniz.\u001B[0m");
            urunListeleCagir();
            idKontrol();
        }else {
            urunId=Integer.parseInt(stringId);
            if(urunId>getId()-1 || urunId<1000){
                System.out.println("\u001B[31mHatalı giriş! Lutfen listeye gore bir ID deger giriniz.\u001B[0m");
                urunListeleCagir();
                idKontrol();
            }else{
                urunIndex =idList.indexOf(urunId) ;
            }
        }
        return urunIndex;
    }
    public void urunCikisi() {
        urunListeleCagir();
        System.out.println("Urun Cikisi  ==>");
        idKontrol();
        System.out.print("Cikis yapacaginiz '" + urunIsmiList.get(urunIndex) + "' miktarini giriniz:");
        double urunMiktari=scan.nextDouble();
        if (urunMiktari<=miktarList.get(urunIndex)){
            miktarList.set(urunIndex, miktarList.get(urunIndex)-urunMiktari);
            System.out.println("Urun Cikisi  ==> Id: "+idList.get(urunIndex)+"  Urun Miktari: "+urunMiktari);
            if (miktarList.get(urunIndex)==0.00){
                rafList.set(urunIndex, getRaf());
                System.out.println("Stokta " + urunIsmiList.get(urunIndex) + " kalmamistir");
            }
            urunListeleCagir();
        }else {
            System.out.println("\u001B[31mCikis yapacaginiz miktar stoktan fazla olamaz!\u001B[0m");
            urunCikisi();
        }
        menuSor();
    }
    public void menuCikis() {
        System.out.println("Listenin son durumu  ==>");
        urunListeleCagir();
        String test="Sistemden cikis yaptiniz.";
    }
    public void menu() {
        String  menuSecim;
        System.out.println("     ANA MENU");
        System.out.println("========================");
        System.out.println("Urun Tanimlama   => 1");
        System.out.println("Urun Listeleme   => 2");
        System.out.println("Urun Girisi      => 3");
        System.out.println("Urun Cikisi      => 4");
        System.out.println("Urun Sil         => 5");
        System.out.println("Menu Cikisi      => 6");
        System.out.print("Lutfen seciminizi giriniz:");
        menuSecim = scan.next().substring(0,1);
        switch (menuSecim) {
            case "1":
                urunTanimla();
                break;
            case "2":
                urunListele();
                break;
            case "3":
                urunGirisi();
                break;
            case "4":
                double toplam=0;
                for (double w:miktarList) {
                    toplam = toplam+w;
                }if (toplam==0){
                System.out.println("\u001B[31mUyari! Henuz urun girisi yapilmamistir. Lutfen urun girisi yapiniz.\u001B[0m");
                menuSor();
            }else {
                urunCikisi();
            }
                break;
            case "5":
                urunSil();
                break;
            case "6":
                menuCikis();
                break;
            default:
                System.out.println("\u001B[31mHatali Giris! Lutfen gecerli giris yapiniz.\u001B[0m");
                menu(); }
    }
    private void urunSil() {
        urunListeleCagir();
        System.out.println("Urun Sil   ==>");
        idKontrol();
        System.out.print("Tanim listesinden '" + urunIsmiList.get(urunIndex) + "' silinecektir. ");
        System.out.println("Onaylamak icin 'E', iptal etmek icin 'H' giriniz.");
        String onay=scan.next().toUpperCase().substring(0,1);
        if(onay.equals("H")){
            menuSor();
        }else {
            if(rafList.get(urunIndex)=="-"){
                urunIsmiList.set(urunIndex,"-");
                ureticiList.set(urunIndex,"-");
                birimList.set(urunIndex,"-");
                urunListeleCagir();
                menuSor();
            }else{
                System.out.println("\u001B[31mUyari! Stokta " + urunIsmiList.get(urunIndex) +" bulunmaktadir. Oncelikle stokta urun bulunmamalidir. \u001B[0m");
                urunListeleCagir();
                menuSor();
            }
        }
    }
    public void hazirTanimliUrunler(){
        idList.add(1000);   urunIsmiList.add("Un"); ureticiList.add("Telli"); miktarList.add(0.0);birimList.add("Cuval");rafList.add("-");
        idList.add(1001);   urunIsmiList.add("Seker"); ureticiList.add("Beyaz"); miktarList.add(0.0);birimList.add("Koli");rafList.add("-");
        idList.add(1002);   urunIsmiList.add("Cay"); ureticiList.add("Rize"); miktarList.add(0.0);birimList.add("Paket");rafList.add("-");
        idList.add(1003);   urunIsmiList.add("Peynir"); ureticiList.add("Sutas"); miktarList.add(0.0);birimList.add("Teneke");rafList.add("-");
        idList.add(1004);   urunIsmiList.add("Zeytin"); ureticiList.add("Marin"); miktarList.add(0.0);birimList.add("Bidon");rafList.add("-");
        int maxId= getId();
        for(Integer w: idList){
            maxId = Math.max(w, maxId);
        }
        setId(maxId+1);
    }
}










