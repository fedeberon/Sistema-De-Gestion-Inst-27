package service.profesor;

import service.profesor.validar.ValidacionDeString;

/**
 * Created by Alan on 5/6/2018.
 */
public class ProfesorService {
    private ValidacionDeString validar = new ValidacionDeString();

    public boolean verificarTextoObligatorio(String text) {
        return validar.chequearTextoObligatorio(text);
    }

    public boolean verificarTexto(String text) {
        return validar.chequearTexto(text, 0);
    }

    public boolean verificarNumero(String text) {
        return validar.chequearNumero(text);
    }

    public boolean verificarCuil(String text, String text1, String text2) {
        String[] cuil = {text, text1, text2};
        return validar.chequearCuil(cuil);
    }
}
