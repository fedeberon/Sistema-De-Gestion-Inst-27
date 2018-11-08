package com.instituto27.service.profesor;

import com.instituto27.service.Verificador;
import org.springframework.cglib.core.Local;
import org.springframework.expression.ParseException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Alan on 5/6/2018.
 */
public class ProfesorService extends Verificador {
   private Verificador verificador = new Verificador();
    
    public boolean verificarTextoObligatorio(String text) {
        return verificador.chequearTexto(text, false);
    }

    public boolean verificarNumero(String text) {
        return verificador.chequearNumero(text, true);
    }

    public boolean verificarCuil(String text, String text1, String text2) {
        String[] cuil = {text, text1, text2};
        return verificador.chequearCuil(cuil);
    }        
}

