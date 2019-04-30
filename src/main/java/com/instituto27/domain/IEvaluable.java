package com.instituto27.domain;

import java.util.function.Function;

/**
 * Created by ISFDyT Nº 27 on 09/04/2019.
 */
public interface IEvaluable {

    <T> T evaluar(Function<Usuario, ? extends T> usuario, Function<Profesor, ? extends T> profesor, Function<Alumno, ? extends T> alumno, Function<Administrativo, ? extends T> administrativo);

}
