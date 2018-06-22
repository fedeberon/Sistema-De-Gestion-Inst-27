package service.profesor.validar;

/**
 * Created by Alan on 5/6/2018.
 */
public class ValidacionDeString {

    private boolean chequearEspacios (String text){
        //Verifica que, a pesar de que se puedan incluir espacios, el string no este compuesto solo de ellos.

        int cantidadDeEspacios = 0;
        for(int i = 0; i<text.length(); i++){
            if (text.charAt(i) == ' '){
                cantidadDeEspacios++;
            }
        }

        if(cantidadDeEspacios == text.length()){
            cantidadDeEspacios = 0;
            return false;
        }else{
            return true;
        }
    }

    public boolean chequearTexto(String text, int indispensable){
        /*Comprueba si el texto contiene caracteres que no deberian ir (numeros, simbolos,
        ademas verifica que ,aunque los espacios si esten permitidos, el string no este compuesto solo por espacios.*/

        for(Character i: text.toCharArray())
            if (!Character.isLetter(i) && i != ' ') {
                return false;
            }
        return chequearEspacios(text);
    }

    public boolean chequearNumero(String text){
        /*Comprueba si el texto contiene caracteres que no deberian ir (letras, simbolos,
        ademas verifica que ,aunque los espacios si esten permitidos, el string no este compuesto solo por espacios.*/
        if(text.isEmpty()){
            return true;
        }

        for(Character i: text.toCharArray())
            if (!Character.isDigit(i) && i != ' ') {
                return false;
            }
        return chequearEspacios(text);
    }

    public boolean chequearTextoObligatorio(String text) {
        /*Comprueba que haya texto escrito en un campo obligatorio y que este sea valido*/
        if(text.equals("")){
            return false;
        }else{
            return chequearTexto(text, 1);
        }
    }

    public boolean chequearCuil(String[] cuil) {
        if(cuil[0].isEmpty() && cuil[1].isEmpty() && cuil[2].isEmpty() ){
            return true;
        }

        if((cuil[0].isEmpty() && cuil[1].isEmpty()) || (cuil[2].isEmpty() && cuil[1].isEmpty()) || (cuil[0].isEmpty() && cuil[2].isEmpty())){
            return false;
        }


        if(cuil[0].length()!=2 || !chequearNumero(cuil[0])){
            return false;
        }
        if(cuil[1].length()!=8 || !chequearNumero(cuil[1])){
            return false;
        }
        if(cuil[2].length()!=1 || !chequearNumero(cuil[2])){
            return false;
        }

        return true;
    }
}
