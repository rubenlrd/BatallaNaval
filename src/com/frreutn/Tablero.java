package com.frreutn;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by rmlrd on 6/9/2016.
 */
public class Tablero {
    //atributos del tablero
    private String tablero[][] = new String[10][10];
    private Barco barco;
    private ArrayList<Barco>flota = new ArrayList<Barco>();
    private int tocados = 0;

    //cargo la matriz por constructor
    public Tablero() {
        //llamo al procedimiento cargarMatriz
        cargarMatriz();
    }

    //mostrar tablero
    public void mostrarTablero(){
        for (int i=0;i<10;i++){
            for(int j=0;j<10;j++){
              System.out.print("  "+tablero[i][j]);
            }
            System.out.println();
        }
    }

    //cargo en un arrayList la posición de los barcos de la flota
    public void cargarBarco(String pos1, String pos2, int orientacion){
        if (!(flota.size()>=3)) {
            barco = new Barco();
            barco.setOrientacion(orientacion);
            barco.setPosicion1(pos1);
            barco.setPosicion2(pos2);
            flota.add(barco);
        }else{
            System.out.println("Flota completa");
        }
    }

    //cargo la matriz
    public void cargarMatriz(){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                tablero[i][j]="*";
            }
        }
    }

    //posicion del ataque enemigo
    public void ataqueEnemigo(String tiro){
        String uno = tiro.substring(0);
        int i = Integer.parseInt(uno);
        String dos = tiro.substring(1);
        int j = Integer.parseInt(dos);

        for (Barco nave : flota) {
            if (nave.getPosicion1().equals(tiro)) {
                tablero[i][j] = "T";
                tocados++;

            }else if (nave.getPosicion2().equals(tiro)){

            }else{
                //tablero[i][j] = "A";
            }

//            if(nave.getEstado().equals("bueno")){
//                nave.setEstado("averiado");
//            }
        }

        if(tocados==6){
            System.out.println("Ha ganado el juego");
        }
        mostrarTablero();
    }

    @Override
    public String toString() {
        return "Tablero{" +
                "flota=" + flota +
                '}';
    }
//    public Barco recorrerBarcos(){
//        for (Barco grupo: flota) {
//            if (grupo.getPosicion().equals())
//                return grupo.getPosicion();
//        }
//
//    }

//    //metodo para convertir una letra en numero
//    public String convertir(String num){
//        String convertir[] = {"a", "b", "c", "d","e", "f", "g", "h", "i", "j"};
//        String valor;
//        for (int i=0;i<=convertir.length;i++){
//            if (convertir[i].equalsIgnoreCase(num)){
//                valor = String.valueOf(i);
//                return valor;
//            }
//        }
//        return "";
//    }//fin de metodo

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tablero tablero1 = (Tablero) o;

        if (tocados != tablero1.tocados) return false;
        if (!Arrays.deepEquals(tablero, tablero1.tablero)) return false;
        if (barco != null ? !barco.equals(tablero1.barco) : tablero1.barco != null) return false;
        return flota != null ? flota.equals(tablero1.flota) : tablero1.flota == null;

    }

    @Override
    public int hashCode() {
        int result = Arrays.deepHashCode(tablero);
        result = 31 * result + (barco != null ? barco.hashCode() : 0);
        result = 31 * result + (flota != null ? flota.hashCode() : 0);
        result = 31 * result + tocados;
        return result;
    }
}//finde clase

