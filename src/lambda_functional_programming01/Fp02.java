package lambda_functional_programming01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp02 {

    /*
  1- ) t-> "Logic" , (t,u) -> "logic"
       Bu yapiya "Lambda Expession"

  2- ) Functional Programming kapsaminda "Lambda Expession" kullanilabilir ama onerilmez.
       "Lambda Expession" yerine "FunctionMethod Reference" tercih edilir.

  3- ) "Method Reference" kullanimi "Class Name :: Method Name
        Ayni zamanda kendi class'larinizi da kullanabilirsiniz.

        Ornegin bir Animal class'ınız var ve bu class "eat()" methoduna sahip ==> "Animal :: eat"
     */


    public static void main(String[] args) {

        List<Integer> liste = new ArrayList<>();
        liste.add(8);
        liste.add(9);
        liste.add(131);
        liste.add(10);
        liste.add(9);
        liste.add(10);
        liste.add(2);
        liste.add(8);
        System.out.println(liste);
        listElemanlariniYazdirFunctional(liste);
        System.out.println();
        ciftElemanlariYAzdirFunctional(liste);
        System.out.println();
        tekElemanlarinKareleriniYazdir(liste);
        System.out.println();
        tekrarsizTekElemanlarinKupunuYazdir(liste);
        System.out.println();
        tekrarsizCiftElemanlarinKareToplami01(liste);
        System.out.println();
        tekrarsizCiftElemanlarinKareToplami02(liste);
        System.out.println();
        tekrarsizCiftElemanlarinKareToplami03(liste);
        System.out.println();
        tekrarsizCiftElemanlarinKupununCarpimi(liste);
        System.out.println();
        getMaxEleman(liste);
        System.out.println();
        getMinEleman(liste);
        System.out.println();
        yedidenBuyukCiftMin(liste);
        System.out.println();
        tersSiralamaylaTekrarsizElemanlarinYarisi(liste);


    }

    // 1- ) Ardışık list elemanlarını aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional ve method reference)
    public static void listElemanlariniYazdirFunctional(List<Integer> list) {
        list.stream().forEach(Utils::ayniSatirdaBosluklaYazdir);
    }

    /*
    2- )Ardışık çift list elementlerini aynı satırda aralarında boşluk bırakarak
    yazdıran bir method oluşturun.(Functional)
     */
    public static void ciftElemanlariYAzdirFunctional(List<Integer> list) {
        list.stream().filter(Utils::ciftElemanlariSec).forEach(Utils::ayniSatirdaBosluklaYazdir);
    }

    /*
    3) Ardışık tek list elemanlarının karelerini aynı satırda aralarında
    boşluk bırakarak yazdıran bir method oluşturun.(Functional)
     */
    public static void tekElemanlarinKareleriniYazdir(List<Integer> list) {
        list.stream().filter(Utils::tekElemanlariSec).map(Utils::karesiniAl).forEach(Utils::ayniSatirdaBosluklaYazdir);
    }

    /*
    4- ) Ardışık tek list elemanlarının küplerini tekrarsız olarak aynı satırda
    aralarında boşluk bırakarak yazdıran bir method oluşturun.
     */
    public static void tekrarsizTekElemanlarinKupunuYazdir(List<Integer> list) {
        list.stream().filter(Utils::tekElemanlariSec).map(Utils::kupunuAl).forEach(Utils::ayniSatirdaBosluklaYazdir);
    }

    /*
    5- ) Tekrarsız çift elemanların karelerinin toplamını hesaplayan bir method oluşturun.
     */
    public static void tekrarsizCiftElemanlarinKareToplami01(List<Integer> list) {
        Integer toplam = list.stream().distinct().filter(Utils::ciftElemanlariSec).map(Utils::karesiniAl).reduce(0, Math::addExact);
        System.out.print(toplam);

    }

    public static void tekrarsizCiftElemanlarinKareToplami02(List<Integer> list) {
        Integer toplam = list.stream().distinct().filter(Utils::ciftElemanlariSec).map(Utils::karesiniAl).reduce(Math::addExact).get();
        System.out.print(toplam);
    }

    public static void tekrarsizCiftElemanlarinKareToplami03(List<Integer> list) {
        Integer toplam = list.stream().distinct().filter(Utils::ciftElemanlariSec).map(Utils::karesiniAl).reduce(0, Integer::sum);
        System.out.print(toplam);
    }

    /*
    6- ) Tekrarsız çift elemanların küpünün çarpımını hesaplayan bir method oluşturun.
     */
    public static void tekrarsizCiftElemanlarinKupununCarpimi(List<Integer> list) {
        Integer carpım = list.stream().distinct().filter(Utils::ciftElemanlariSec).map(Utils::kupunuAl).reduce(1, Math::multiplyExact);
        System.out.print(carpım);
    }

    //7- ) List elemanları arasından en büyük değeri bulan bir method oluşturun.

    public static void getMaxEleman(List<Integer> list) {
        Integer max = list.stream().distinct().reduce(Math::max).get();
        System.out.print(max);
    }

    // 8- )List elemanları arasından en küçük değeri bulan bir method oluşturun.(Method Reference)
    public static void getMinEleman(List<Integer> list) {
        Integer min = list.stream().distinct().reduce(Math::min).get();
        System.out.print(min);
    }

    // 9- ) List elemanları arasından 7'den büyük, çift, en küçük değeri bulan bir method oluşturun.
    public static void yedidenBuyukCiftMin(List<Integer> list) {
        Integer min = list.stream().distinct().filter(t -> t > 7).filter(Utils::ciftElemanlariSec).reduce(Math::min).get();
        System.out.print(min);
    }

    /*
     10) Ters sıralama ile tekrarsız ve 5'ten büyük elemanların yarı değerlerini
            (elamanın ikiye bölüm sonucunu) bulan bir method oluşturun.
            */
    public static void tersSiralamaylaTekrarsizElemanlarinYarisi(List<Integer> list) {
        List<Double> sonuc = list.
                stream().//Gerekli methodları kullanmamızı sağlar
                        distinct().//Tekarlı olanları almaz
                        filter(t -> t > 5).//Koşula göre filtreleme yapar
                        map(Utils::yarisiniAl).//Her bir elemanın değerini değiştirmeye yarar
                        sorted(Comparator.reverseOrder()).//Sıralama yapar
                        collect(Collectors.toList());//Elamanları collection'a çevirir.
        System.out.print(sonuc);
    }
}
