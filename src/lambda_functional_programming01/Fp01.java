package lambda_functional_programming01;

import java.util.ArrayList;
import java.util.List;

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

    }

    public static void listElemanlariniYazdirStructured(List<Integer> list) {////Ardışık list elementlerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Structured)
        //her bir integer veri ayrı scope da olduğundan List<Integer> list'e attık

        for (Integer each : list
        ) {
            System.out.print(each + " ");//foreach loop ile listedeki int verileri tek tek aldık listenin dışına çıkardık

        }
    }
//2)Ardışık list elementlerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional)

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
    //3) çift sayı olan list elementlerini aynı satırda aralarında
    // boşluk bırakarak yazdıran bir method oluşturun.(Structured

    public static void CiftElemanlariYazdirStructured(List<Integer> list){

        for (Integer each:list
        ) {
            if(each%2==0){
                System.out.print(each+" ");
            }
        }

    }
    //4)Ardışık çift list elementlerini aynı satırda aralarında
    // boşluk bırakarak yazdıran bir method oluşturun.(Functional)
    public static void CiftElemanlariYazdirFunctional(List<Integer> list){
        list.stream().filter(t-> t%2==0).forEach(t-> System.out.print(t+" "));//filter(t-> t%2==0) 2ye bölünenleri filtrele

    }

    //5) Ardışık tek list elementlerinin karelerini aynı satırda
    // aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional)
    public static void TekElemanlarinKareleriniYazdirFunctional(List<Integer> list){
        list.stream().filter(t->t%2!=0).map(t->t*t).forEach(t-> System.out.print(t+" "));
        //elemanların karelerini yazdıracağım değerler değişeceği için map() methodunu kullandım
    }

    //6) Ardışık tek list elementlerini kuplerini tekrarsiz olarak ayni satırda aralarında
    //boşluk bırakarak yazdıran bir method oluşturun.(Functional)

    public static void tekrarsizTekElemanlarinKupunuYazdir(List<Integer> list){
        list.stream().distinct().filter(t->t%2!=0).map(t->t*t*t).forEach(t-> System.out.print(t+" "));
        //distinct tekrarlari kaldirir(tekrarları alma)
        //distinct ve filter i stream olmadan kullanamayiz
    }

    //7) Tekrarsız çift elementlerin karelerinin toplamını hesaplayan bir method oluşturun.

    public static void tekrarsizCiftElemanlarinKareToplami(List<Integer> list){
        Integer toplam=list.stream().distinct().filter(t->t%2==0).map(t->t*t).reduce(0,(t,u)->t+u);
        System.out.println(toplam);//reduce() elinde birçok sayı var teke düşür->toplama yap der gibi,0'dan başlatmamızın sebebi başlangıç değeri t'nin
        //listedeki elemanları Integer konteynırının içine koyduk ve yazdırdık
    }

}