package com.frreutn;

import java.util.Arrays;

/**
 * Created by rmlrd on 6/9/2016.
 */
public class Barco {
    //atributos del barco
    private String posicion1;
    private String posicion2;
    private int orientacion;
    private String estado = "bueno";


    public void setOrientacion(int orientacion) {
        //0 representa a la orientacion vertical
        //1 representa a la orientacion horizonal
        if (orientacion == 0 || orientacion == 1) {
            this.orientacion = orientacion;
        } else {
            System.out.println("Debe ingresar  vertical o horizontal");
        }
    }

    //obtengo la orientación del barco
    public int getOrientacion() {
        //retorna si es la posicion es vertical o horizontal
        return orientacion;
    }

    //ingreso la primera posición del barco
    public void setPosicion1(String posicion1) {
        this.posicion1 = posicion1;
    }


    //valido las adyacencias para armar la posicion del barco
    public void setPosicion2(String posicion2){
        //calculo la adyacencia de la primera posición
        int adyacencia1, adyacencia2, fila, columna;
        String sub, num1, num2;
        if (orientacion == 0){
            sub = posicion1.substring(0);
            fila = Integer.parseInt(sub);
            adyacencia1 = fila - 1;
            num1= String.valueOf(adyacencia1);
            adyacencia2 = fila + 1;
            num2 = String.valueOf(adyacencia2);
            //vuelvo a armar el la posicion
            num1 = num1 + "," + posicion1.substring(1);
            num2 = num2 + "," + posicion1.substring(1);
           if (posicion2.equals(num1)|| posicion2.equals(num2)){
               this.posicion2 = posicion2;
           }
        }else if (orientacion == 1){
            sub = posicion1.substring(1);
            columna = Integer.parseInt(sub);
            adyacencia1 = columna - 1;
            num1 = String.valueOf(adyacencia1);
            adyacencia2 = columna + 1;
            num2 = String.valueOf(adyacencia2);
            num1 = posicion1.substring(0) + "," + num1;
            num2 = posicion1.substring(0) + "," + num2;
            if (posicion2.equals(num1)|| posicion2.equals(num2)) {
                this.posicion2 = posicion2;
            }
        }
    }
    //retorna posicion
    public String getPosicion1() {
        return posicion1;
    }

    public String getPosicion2() {
        return posicion2;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Barco barco = (Barco) o;

        if (orientacion != barco.orientacion) return false;
        if (!posicion1.equals(barco.posicion1)) return false;
        if (!posicion2.equals(barco.posicion2)) return false;
        return estado.equals(barco.estado);

    }

    @Override
    public int hashCode() {
        int result = posicion1.hashCode();
        result = 31 * result + posicion2.hashCode();
        result = 31 * result + orientacion;
        result = 31 * result + estado.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Barco{" +
                "posicion1='" + posicion1 + '\'' +
                ", posicion2='" + posicion2 + '\'' +
                ", orientacion=" + orientacion +
                ", estado='" + estado + '\'' +
                '}';
    }
}//fin de clase
