package lambda_functional_programming01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Fp03 {
    public static void main(String[] args) {

        List<String> liste = new ArrayList<>();
        liste.add("Ali");
        liste.add("Ali");
        liste.add("Mark");
        liste.add("Amanda");
        liste.add("Christopher");
        liste.add("Jackson");
        liste.add("Mariano");
        liste.add("Alberto");
        liste.add("Tucker");
        liste.add("Benjamin");
        System.out.println(liste);
        buyukHarfleYazdir01(liste);
        System.out.println();
        kucukHarfleYazdir(liste);
        System.out.println();
        //buyukHarfleYazdir2(liste);
        uzunlugaGoreYazdir(liste);
        System.out.println();
        uzunlugagoreTerstenYazdir(liste);
        System.out.println();
        sonKarakteregoreTekrarsizSirala(liste);
        System.out.println();
        uzunlukveIlkHarfegoreSiralaYazdir(liste);
        System.out.println();
        //uzunluguBestenBuyukleriSil(liste);
        // baslangiclariAyadaSonuNolaniSil(liste);
        //baslangiclariAyadaSonuNolaniSil2(liste);
        //uzunluguSekizIleOnArasiveoIleBiteniSil(liste);
        System.out.println("uzunlugu12denAzMi = " + uzunlugu12denAzMi(liste));
        System.out.println("xileBaslamiyorMu = " + xileBaslamiyorMu(liste));
        System.out.println("rIleBitenVarMi= " + rIleBitenVarMi(liste));

    }
    // 1- ) Tüm elemanları büyük harf ile yazdıran bir method oluşturun.

    public static void buyukHarfleYazdir01(List<String> list) {
        list.stream().map(String::toUpperCase).forEach(Utils::ayniSatirdaBosluklaYazdir);
    }
    /* public static void buyukHarfleYazdir02(List<String> list){ // 2. YOL
        list.replaceAll(String::toUpperCase);
        System.out.print(list);
        Listemiz mutable oldugu icin yorum satirina aldik. Bu method listemizi degistirdi.
    }
    */


    /*
    2- ) Elemanları uzunluklarına göre sıralayıp yazdıran bir method oluşturun.
     */
    public static void uzunlugaGoreYazdir(List<String> list) {
        list.stream().sorted(Comparator.comparing(String::length)).forEach(Utils::ayniSatirdaBosluklaYazdir);
        // Comparator.comparing(); --> siralama kosulunu belirtmek icin kullanilir.

    }

    public static void kucukHarfleYazdir(List<String> list) {

        list.stream().map(String::toLowerCase).forEach(Utils::ayniSatirdaBosluklaYazdir);
    }

    // 3- ) Elemanları uzunluklarına göre ters sıralayıp yazdıran bir method oluşturun.
    public static void uzunlugagoreTerstenYazdir(List<String> list) {
        list.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(Utils::ayniSatirdaBosluklaYazdir);
    }

    // 4- ) Elemanları son karakterlerine göre sıralayıp tekrarsız yazdıran bir method oluşturun.
    public static void sonKarakteregoreTekrarsizSirala(List<String> list) {
        list.stream().distinct().sorted(Comparator.comparing(Utils::sonKarekteriniAl)).forEach(Utils::ayniSatirdaBosluklaYazdir);
    }

    /*
    5) Elemanları önce uzunluklarına göre ve sonra ilk karakterine göre sıralayıp
    yazdıran bir method oluşturun.
     */
    public static void uzunlukveIlkHarfegoreSiralaYazdir(List<String> list) {
        list.stream().sorted(Comparator.comparing(String::length).thenComparing(Utils::ilkKarekteriniAl)).forEach(Utils::ayniSatirdaBosluklaYazdir);
        //==>thenComparing() sıralama için bir koşul daha belirtir
    }
    /*
    6- ) Uzunluğu 5'ten büyük olan elemanları silen bir method oluşturun.
     */
    /*public static void bestenBuyukleriSil(List<String> list) {
        list.removeIf(t->t.length()>5);
        System.out.print(list);
        Listemizi degistiriyor. Biz bu sekilde olmasini istemiyoruz.
        List mutable oldugu icin elemanlari işlem sonrasi kalici degistiginden
        comment-out yapiyoruz
    }*/


    /*
    7- ) ‘A’, ‘a’ ile başlayan yada ‘N’, ‘n’ ile biten elemanları silen bir method oluşturun.
     */
    /*public static void baslagiciAYadaSonuNOlaniSil01(List<String> list) { // 1. YOL
        list.removeIf(t -> t.charAt(0) == 'A' || t.charAt(0) == 'a' || t.charAt(t.length() - 1) == 'N' || t.charAt(t.length() - 1) == 'n');
        System.out.println(list);
        Listemizi degistiriyor. Biz bu sekilde olmasini istemiyoruz.
        List mutable oldugu icin elemanlari işlem sonrasi kalici degistiginden
        comment-out yapiyoruz
    }*/


    /*public static void baslagiciAYadaSonuNOlaniSil02(List<String> list) { // 2. YOL
        list.removeIf(t -> t.startsWith("A") || t.startsWith("a") || t.endsWith("N") || t.endsWith("n"));
        System.out.print(list);
        Listemizi degistiriyor. Biz bu sekilde olmasini istemiyoruz.
        List mutable oldugu icin elemanlari işlem sonrasi kalici degistiginden
        comment-out yapiyoruz
    }*/


    /*
    8- ) Uzunluğu 8 ile 10 arası olan yada 'o' ile biten elemanları yazdıran bir method oluşturun.
     */
    /*public static void uzunlugu8ile10ArasiVeOIleBiteniSil(List<String> list) {
        list.removeIf(t -> (t.length() > 7 && t.length() < 11) || t.endsWith("O") || t.endsWith("o"));
        System.out.println(list);
        Listemizi degistiriyor. Biz bu sekilde olmasini istemiyoruz.
        List mutable oldugu icin elemanlari işlem sonrasi kalici degistiginden
        comment-out yapiyoruz
    }*/


    /*
    9- ) Tüm elemanların uzunluklarının 12'den az olup olmadığını kontrol eden
    bir method oluşturun.
     */
    public static boolean uzunlugu12denAzMi(List<String> list) {
        return list.stream().allMatch(t -> t.length() < 12);

    }

    //10-)Hiçbir elemanının 'X' ile başşlamadığını kontrol edin
    public static boolean xileBaslamiyorMu(List<String> list) {
        return list.stream().noneMatch(t -> t.startsWith("X"));
    }
    //11) Herhangi bir elemanın 'r' ile bitip bitmediğini kontrol eden bir method oluşturun.

    public static boolean rIleBitenVarMi(List<String> list) {

        return list.stream().anyMatch(t -> t.endsWith("r"));
    }
}
