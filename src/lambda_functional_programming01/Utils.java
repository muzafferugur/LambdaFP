package lambda_functional_programming01;

public class Utils {
    public static void ayniSatirdaBosluklaYazdir(Object obj) {

        System.out.print(obj + " ");
    }
    public static boolean ciftElemanlariSec(int x) {

        return x % 2 == 0;
    }
    public static boolean tekElemanlariSec(int x) {

        return x % 2 != 0;
    }
    public static int karesiniAl(int x){
        return x*x;
    }
    public static int kupunuAl(int x){
        return x*x*x;
    }
}
