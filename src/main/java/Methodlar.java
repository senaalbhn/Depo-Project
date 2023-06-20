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

    static Scanner scan = new Scanner(System.in);
    static int menuSecim;

    static List<String> urunIsmiList = new ArrayList<>();
    static List<String> ureticiList = new ArrayList<>();
    static List<String> birimList = new ArrayList<>();
    static List<Double> miktarList = new ArrayList<>();
    static List<Integer> idList = new ArrayList<>();


    public void urunTanimla() {
        System.out.print("Urun ismini giriniz: ");
        String urunIsmi= scan.next();
        urunIsmiList.add("Un");
    }

    public void urunListele() {

    }

    public void urunGirisi() {

    }

    public void rafaKoy() {

    }

    public void urunCikisi() {

    }

    public void menuCikis() {

    }

    public void menu() {
        System.out.println("ANA MENU");
        System.out.println("========================");
        System.out.println("Urun Tanimlama   => 1");
        System.out.println("Urun Listeleme   => 2");
        System.out.println("Urun Girisi      => 3");
        System.out.println("Urunu Rafa Koy   => 4");
        System.out.println("Urun Cikisi      => 5");
        System.out.println("Menu Cikisi      => 6");
        System.out.println("Lutfen seciminizi giriniz");
        menuSecim = scan.nextInt();

        switch (menuSecim){
            case 1:
                urunTanimla();
                break;
            case 2:
                urunListele();
                break;
            case 3:
                urunGirisi();
                break;
            case 4:
                rafaKoy();
                break;
            case 5:
                urunCikisi();
                break;
            case 6:
                menuCikis();
                break;
            default:
                System.out.println("Yanlis giris yaptiniz.Lutfen gecerli secim yapiniz");
                menu();
        }
    }


}
