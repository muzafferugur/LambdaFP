package lambda_functional_programming01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp01 {
    /*
    1)lambda java 8 ile kullanılmaya başlanmıştır.
    2)functional programming ne yapılacak(what to do) üzerine yoğunlaşılır.
    Structured Programming "nasıl yapılacak" how to do üzerine yoğunlaşılır
    3)functional programming arrays ve collections ile kullanılır
    4)"entrySet() methodu ile Map,Set e dönüştürülerek functional programming de kullanılabilir"
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

        //1) Ardışık list elementlerini aynı satırda aralarında boşluk


        listElemanlariniYazdirStructured(liste);//aşağıdaki methodu cağırıp yazdırdık
        System.out.println();
        listElemanlariniYazdirFunctional(liste);
        System.out.println();
        CiftElemanlariYazdirStructured(liste);
        System.out.println();
        CiftElemanlariYazdirFunctional(liste);
        System.out.println();
        TekElemanlarinKareleriniYazdirFunctional(liste);
        System.out.println();
        tekrarsizTekElemanlarinKupunuYazdir(liste);
        System.out.println();
        tekrarsizCiftElemanlarinKareToplami(liste);
        System.out.println();
        tekrarsizCiftElemanlarinKupunuYazdir(liste);
        System.out.println();
        getMaxEleman(liste);
        System.out.println();
        getMinEleman(liste);
        System.out.println();
        getYedidenBuyukCiftMin01(liste);
        System.out.println();
        getYedidenBuyukCiftMin02(liste);
        System.out.println( );
        getTersSiralamaylaTekrarsizElemanlarinYarisi(liste);


    }

    public static void listElemanlariniYazdirStructured(List<Integer> list) {
        //Ardışık list elementlerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Structured)
        //her bir integer veri ayrı scope da olduğundan List<Integer> list'e attık

        for (Integer each : list
        ) {
            System.out.print(each + " ");//foreach loop ile listedeki int verileri tek tek aldık listenin dışına çıkardık

        }
    }

//1)Ardışık list elementlerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional)

    public static void listElemanlariniYazdirFunctional(List<Integer> list) {

        list.stream().forEach(t -> System.out.print(t + " "));//stream kullanarak verileri akışa aldık foreach methoduna ulaşabilmek için

        /*
        stream() methodu collection dan elementleri akisa dahil etmek icin ve methodlara
        ulasmak icin kullanilir

         Java IO sınıflarında yer alan ve art arda işlemler için kullanılmaktadır.
         Java 8 ile birlikte gelen Stream API fonksiyonel programlama yaklaşımına göre koleksiyon,
         dizi gibi veriler üzerinde filtreleme, döngü, dönüştürme, dönüşüm gibi işlemler yapmayı sağlar.
         */
    }

    //2) çift sayı olan list elementlerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Structured

    public static void CiftElemanlariYazdirStructured(List<Integer> list) {

        for (Integer each : list
        ) {
            if (each % 2 == 0) {
                System.out.print(each + " ");
            }
        }

    }

    //2) Ardışık çift list elementlerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional)
    public static void CiftElemanlariYazdirFunctional(List<Integer> list) {
        list.stream().filter(t -> t % 2 == 0).forEach(t -> System.out.print(t + " "));//filter(t-> t%2==0) 2ye bölünenleri filtrele

    }

    //3) Ardışık tek list elementlerinin karelerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional)
    public static void TekElemanlarinKareleriniYazdirFunctional(List<Integer> list) {
        list.stream().filter(t -> t % 2 != 0).map(t -> t * t).forEach(t -> System.out.print(t + " "));
        //elemanların karelerini yazdıracağım değerler değişeceği için map() methodunu kullandım
    }

    //4) Ardışık tek list elementlerini kuplerini tekrarsiz olarak ayni satırda aralarında
    //boşluk bırakarak yazdıran bir method oluşturun.(Functional)

    public static void tekrarsizTekElemanlarinKupunuYazdir(List<Integer> list) {
        list.stream().distinct().filter(t -> t % 2 != 0).map(t -> t * t * t).forEach(t -> System.out.print(t + " "));
        //distinct tekrarlari kaldirir(tekrarları alma)
        //distinct ve filter i stream olmadan kullanamayiz
    }

    //5) Tekrarsız çift elementlerin karelerinin toplamını hesaplayan bir method oluşturun.

    public static void tekrarsizCiftElemanlarinKareToplami(List<Integer> list) {
        Integer toplam = list.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t).reduce(0, (t, u) -> t + u);
        System.out.print(toplam);//reduce() elinde birçok sayı var teke düşür->toplama yap der gibi,0'dan başlatmamızın sebebi başlangıç değeri t'nin
        //listedeki elemanları Integer konteynırının içine koyduk ve yazdırdık

    }

    //6) Tekrarsız çift elemanların küpünün çarpımını hesaplayan bir method oluşturun.
    public static void tekrarsizCiftElemanlarinKupunuYazdir(List<Integer> list) {
        Integer carpım = list.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t * t).reduce(1, (t, u) -> t * u);
        System.out.print(carpım);
    }

    //7) List elemanları arasından en büyük değeri bulan bir method oluşturun
    public static void getMaxEleman(List<Integer> list) {

        //1.yol
        Integer max = list.stream().distinct().reduce(Integer.MIN_VALUE, (t, u) -> t > u ? t : u);

        //2. yol Integer max = list.stream().distinct().sorted().reduce(Integer.MIN_VALUE, (t, u) -> u);

        //3. yol Integer max = list.stream().max(Integer::compareTo).get();

        System.out.print(max);

    }

    // 8- )List elemanları arasından en küçük değeri bulan bir method oluşturun.(2 Yol ile)
    public static void getMinEleman(List<Integer> list) {

        //Integer min = list.stream().distinct().sorted().reduce(Integer.MIN_VALUE, (t, u) -> t);
        Integer min = list.stream().min(Integer::compareTo).get();//bu yol daha güzel
        System.out.print(min);

    }

    //9 ) List elemanları arasından 7'den büyük, çift, en küçük değeri bulan bir method oluşturun.
    public static void getYedidenBuyukCiftMin01(List<Integer> list) {

        Integer number = list.stream().filter(t -> t > 7 && t % 2 == 0).min(Integer::compareTo).orElse(-1);
        System.out.print(number);
    }

    public static void getYedidenBuyukCiftMin02(List<Integer> list) {

        Integer mın = list.stream().filter(t -> t % 2 == 0).filter(t -> t > 7).reduce(Integer.MAX_VALUE, (t, u) -> t < u ? t : u);
        System.out.println(mın);

        /*
        Integer min = list.stream().distinct().filter(t -> t % 2 == 0).filter(t -> t > 7).sorted(Comparator.reverseOrder()).reduce(Integer.MAX_VALUE, (t, u) -> u);
        System.out.print(min + " ");
        //sorted(Comparator.reverseOrder())-->büyükten küçüğe sıralamak için kullandığımız sorted(k den b ye) methodunun tersi
         */

        /*
        Integer min = list.stream().distinct().filter(t -> t % 2 == 0).filter(t -> t > 7).sorted().findFirst().get();
        System.out.println(min + " ");
         */


    }

    //10 ) Ters sıralama ile tekrarsız ve 5'ten büyük elemanların yarı değerlerin (elamanın ikiye bölüm sonucunu) bulan bir method oluşturun.
    public static void getTersSiralamaylaTekrarsizElemanlarinYarisi(List<Integer> list) {
        List<Double> sonuc = list.stream().distinct().filter(t -> t > 5).map(t -> t / 2.0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sonuc);
    }

}