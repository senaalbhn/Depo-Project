import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Methodlar extends Urunler {
    /*
    2-) methodlar olusturacagiz.
     *      urunTanimlama   ==>  urunun ismi, ureticisi ve birimi girilecek. id  alınacak.  //MAP<id,pojoUrun>   RAF="-"ve Miktar=0 //arraylist
     *
     *      urunListele     ==> tanimlanan urunler listelenecek. urunun adeti ve raf numarasi tanimlama yapilmadiysa default deger gorunsun.
     *     ///  printf(%10)
     *      urunGirisi      ==> giris yapmak istedigimiz urnunun id numarasi ile girecegiz.
     *
     *      urunuRafaKoy    ==> listeden urunu sececegiz ve id numarasina gore urunu rafa koyacagiz.
     *
     *      urunCikisi      ==> listeden urunu sececegiz ve urunun cikis yapcagiz. burada urun listesinden sadece miktarda degisiklik yapilacak.
     *                          urun adedi 0dan az olamaz. 0 olunca urun tanimlamasi silinmesin. sadece miktari 0 olsun.  ///exception
     *      ===> yaptigimiz tum degisiklikler listede de gorunsun.
     */
    Scanner scan = new Scanner(System.in);
    Urunler pojo = new Urunler();
    String  menuSecim;
    List<String> urunIsmiList = new ArrayList<>();
    List<String> ureticiList = new ArrayList<>();
    List<String> birimList = new ArrayList<>();
    List<Double> miktarList = new ArrayList<>();
    List<Integer> idList = new ArrayList<>();
    List<String> rafList = new ArrayList<>();
    public void menuSor(){
        System.out.println("Ana menu icin =====> A   Cikmak icin =====> Q giriniz");
        char ch = scan.next().toUpperCase().charAt(0);
        if (ch=='A'){
            menu();
        }else if (ch=='Q'){
            menuCikis();
        }else {
            System.out.println("Gecersiz giris yaptiniz. Lutfen tekrar deneyiniz.");
            menuSor();
        }
    }
    public void urunTanimla() {
        System.out.print("Urun ismini giriniz: ");
        pojo.setUrunIsmi(scan.next());
        urunIsmiList.add(pojo.getUrunIsmi());
        idList.add(pojo.getId());
        pojo.setId(pojo.getId() + 1);
        System.out.print("Lutfen uretici adini giriniz: ");
        pojo.setUretici(scan.next());
        ureticiList.add(pojo.getUretici());
        birimsec();
        miktarList.add(pojo.getMiktar());
        rafList.add(pojo.getRaf());
        urunListeleCagir();
        menuSor();
    }
    private void birimsec() {
        System.out.print("Lutfen urunun birimini giriniz: ");
        pojo.setBirim(scan.next());
        birimList.add(pojo.getBirim());
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
        System.out.println("Urun Listele ==>");
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
        System.out.println("Lutfen listeden eklemek istediginiz urunun id'sini giriniz");
        int urunId=scan.nextInt();
        int urunIndex=idList.indexOf(urunId);
        rafaKoy(urunIndex);
        System.out.println(urunIsmiList.get(urunIndex)+ " miktarini giriniz.");
        double urunMiktari=scan.nextDouble();
        miktarList.set(urunIndex,miktarList.get(urunIndex)+urunMiktari);
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
    public void urunCikisi() {
        urunListeleCagir();
        System.out.print("Lutfen listeye gore cikis yapacaganiz urunun id'sini giriniz:");
        int urunId=scan.nextInt();
        int urunIndex=idList.indexOf(urunId);
        System.out.print("Cikis yapacaginiz urun " + urunIsmiList.get(urunIndex) + " . Cikis miktarini giriniz:");
        double urunMiktari=scan.nextDouble();
        if (urunMiktari<=miktarList.get(urunIndex)){
            miktarList.set(urunIndex, miktarList.get(urunIndex)-urunMiktari);
            if (miktarList.get(urunIndex)==0.00){
                rafList.set(urunIndex, pojo.getRaf());
                System.out.println("Stokta " + urunIsmiList.get(urunIndex) + " kalmamistir");
            }
            urunListeleCagir();
        }else {
            System.out.println("Cikis yapacaginiz miktar stoktan fazla olamaz!");
            urunCikisi();
        }
        menuSor();
    }
    public void menuCikis() {
        System.out.println("Sistemden cikis yaptiniz.");
    }
    public void menu() {
        System.out.println("     ANA MENU");
        System.out.println("========================");
        System.out.println("Urun Tanimlama   => 1");
        System.out.println("Urun Listeleme   => 2");
        System.out.println("Urun Girisi      => 3");
        System.out.println("Urun Cikisi      => 4");
        System.out.println("Menu Cikisi      => 5");
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
                urunCikisi();
                break;
            case "5":
                menuCikis();
                break;
            default:
                System.out.println("Yanlis giris yaptiniz.Lutfen gecerli secim yapiniz");
                menu(); }
    }
    public void hazirTanimliUrunler(){
        idList.add(1000);   urunIsmiList.add("Un"); ureticiList.add("Telli"); miktarList.add(0.0);birimList.add("Cuval");rafList.add("-");
        idList.add(1001);   urunIsmiList.add("Seker"); ureticiList.add("Beyaz"); miktarList.add(0.0);birimList.add("Koli");rafList.add("-");
        idList.add(1002);   urunIsmiList.add("Cay"); ureticiList.add("Rize"); miktarList.add(0.0);birimList.add("Paket");rafList.add("-");
        idList.add(1003);   urunIsmiList.add("Peynir"); ureticiList.add("Sutas"); miktarList.add(0.0);birimList.add("Teneke");rafList.add("-");
        idList.add(1004);   urunIsmiList.add("Zeytin"); ureticiList.add("Marin"); miktarList.add(0.0);birimList.add("Bidon");rafList.add("-");
        int maxId= pojo.getId();
        for(Integer w: idList){
            maxId = Math.max(w, maxId);
        }
        pojo.setId(maxId+1);
    }
}
