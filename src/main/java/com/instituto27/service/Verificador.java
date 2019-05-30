/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto27.service;

/**
 *
 * @author Alan
 */
public class Verificador {
    /*Esta clase se encuentra compuesta por metodos cuyo proposito es evaluar si los datos 
    que van a ser introducidos en la base de datos poseen el formato apropiado (por ejemplo,
    que no haya numeros donde debe haber solo texto y vice versa)*/

    //==================================================================================================================
    public boolean chequearEspacios(String text, boolean nullable) {
        /*-En caso de que el string acepte espacios, verifica que no se comp1onga solo de ellos
          -El segundo parametro (nullable) establece si es aceptable que el string sea de valor nulo
        */

        int cantidadDeEspacios = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                cantidadDeEspacios++;
            }
        }

        if (cantidadDeEspacios != text.length()) {
            return true;
        } else {
            return (cantidadDeEspacios == 0 ? nullable : false);
        }
    }

    public boolean chequearTexto(String text, boolean nullable) {
        /*Verifica que el contenido del campo sea1 texto puro (sin numeros ni simbolos)*/
        for (Character i : text.toCharArray())
            if (!Character.isLetter(i) && i != ' ') {
                return false;
            }
        return chequearEspacios(text, nullable);
    }

    public boolean chequearNumero(String text, boolean nullable) {
        /*Verifica que el contenido del campo sean numeros puros (sin letras ni simbolos)*/
        for (Character i : text.toCharArray())
            if (!Character.isDigit(i) && i != ' ') {
                return false;
            }
        return chequearEspacios(text, nullable);
    }

    public boolean chequearCuil(String[] cuil) {
        /*-Verifica que solo se pueda introducir un numero de CUIL valido en el programa.
          -Devuelve falso de ser un valor erroneo*/

        //Puesto que el CUIL no es un campo obligatorio, si no se introduce dato alguno no se detectara un error.
        if (cuil[0].isEmpty() && cuil[1].isEmpty() && cuil[2].isEmpty()) {
            return false;
        }

        //Verificacion para evitar que uno de los tres campos que componene el CUIL esten vacios.
        if ((cuil[0].isEmpty() && cuil[1].isEmpty()) || (cuil[2].isEmpty() && cuil[1].isEmpty()) || (cuil[0].isEmpty() && cuil[2].isEmpty())) {
            return false;
        }

        //Verificacion parte por parte de cada campo que compone el CUIL, tanto de longitud, como de composicin (solo se aceptan numeros)
        if (cuil[0].length() != 2 || !chequearNumero(cuil[0], false)) {
            return false;
        }
        if (cuil[1].length() != 8 || !chequearNumero(cuil[1], false)) {
            return false;
        }
        return !(cuil[2].length() != 1 || !chequearNumero(cuil[2], false));
    }

}
