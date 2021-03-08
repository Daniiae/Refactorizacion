import java.util.Scanner;
public class Criba {

    int dato;

    public static int [] cribaPrimos (int dato) {
        int dim = dato + 1;
        boolean[] esPrimo = new boolean[dim];
        for (int i=0; i<dim; i++) {
            esPrimo[i] = true;
        }
        esPrimo[0] = esPrimo[1] = false;

        for (int i=2; i<Math.sqrt(dato)+1; i++) {
            if (esPrimo[i]) {
                for (int j=2*i; j<dato; j+=i) {
                    esPrimo[j] = false;
                }
            }
        }
        int cuenta = 0;
        for (int i=0; i<dato; i++) {
            if (esPrimo[i]) {
                cuenta++;
            }
        }
        int[] primos = new int[cuenta];
        for (int i=0, j=0; i<dato; i++) {
            if (esPrimo[i]) {
                primos[j++] = i;
            }
        }
        return primos;
    }

    public static int[] cribaPrimosMenosDos (int dato) {

        return new int[0];

    }

    public static int pedirNumero () {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato=teclado.nextInt();
        return dato;
    }
    public static void cribaErastotenes (int dato){
        int vector[]=new int[dato];
        System.out.println("\nVector inicial hasta :"+dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) {
                System.out.println();
            }else {
                System.out.print(i+1+"\t");
            }
        }

        vector=cribaPrimos( dato);
        System.out.println("\nVector de primos hasta:"+dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10 == 0) {
                System.out.println();
            }else {
                System.out.print(vector[i]+"\t");}
        }

    }

    public static void main(String[] args) {

        int dato;
        dato = Criba.pedirNumero();

        if (dato >= 2) {
            Criba.cribaPrimos (dato);
        } else {
            Criba.cribaPrimosMenosDos(dato);
        }
        Criba.cribaErastotenes(dato);
    }

}