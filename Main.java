import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] keys = {40, 50, 62, 103, 204, 304, 328};
        int tableSize = 50;
        
        HashMap<Integer, Integer> hashMap = new HashMap<>(tableSize);
        for (int key : keys) {
            int hash = key % tableSize;
            while (hashMap.containsKey(hash)) {
                hash = (hash + 1) % tableSize; // Resolución de colisiones
            }
            hashMap.put(hash, key);
        }

        // Imprimir el contenido del HashMap
        System.out.println("--- Lista de las posiciones con valores ---");
        for (int i = 0; i < tableSize; i++) {
            if (hashMap.containsKey(i)) {
                System.out.println("Posición " + i + " : " + hashMap.get(i));
            }
        }
        System.out.println("----------------------------");
        System.out.println("¿Cual valor desea buscar?");
        Scanner scanner = new Scanner(System.in);
        int find = scanner.nextInt();
        lineal(find, hashMap);
        binaria(find, keys);
    }
    
    public static void lineal(int value, HashMap hashMap){
        System.out.println();
        System.out.println("--- Busqueda lineal ---");
        
        //buscar como clave
        System.out.print("Como clave: ");
        if (hashMap.containsKey(value)) {
            System.out.println(value+ " tiene como valor a "+hashMap.get(value));
        }else{
            System.out.println("No existe");
        }
        
        //buscar como valor
        System.out.print("Como valor: ");
        if (hashMap.containsValue(value)) {
            System.out.println(value+" existe");
        }else{
            System.out.println("No existe");
        }
    }
    
    public static void binaria(int value, int[] keys){
        System.out.println();
        System.out.println("--- Busqueda binaria ---");
        
        //variables
        int izquierda = 0, derecha = keys.length-1, medio = -1;
        boolean encontrado = false;
        
        //realizar la busqueda
        while (izquierda <= derecha && !encontrado){
            medio = izquierda + (derecha - izquierda) /2;
            if(keys[medio] == value){
                 encontrado = true;
                 medio = keys[medio];
            }else if(keys[medio] < value ){
                izquierda = medio+1;
                System.out.println("izquierda -> medio");
            }else{
                derecha = medio-1;
                System.out.println("medio <- derecha ");
            }
        }
        
        //salida
        System.out.println();
        if(encontrado){
            System.out.println("El valor "+medio+" fue hallado.");
        }else{
            System.out.println("No existe "+value+".");
        }
    }
}
