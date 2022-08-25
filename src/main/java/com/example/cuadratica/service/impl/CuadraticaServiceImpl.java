package com.example.cuadratica.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cuadratica.controller.CuadraticaResponse;
import com.example.cuadratica.service.CuadraticaService;

@Service
public class CuadraticaServiceImpl implements CuadraticaService {

    @Override
    public CuadraticaResponse resultado() {
        LocalDateTime locaDate = LocalDateTime.now();
        int hours = locaDate.getHour();
        int minutes = locaDate.getMinute();
        int seconds = locaDate.getSecond();
        String hora = hours + ":" + minutes + ":" + seconds;

        int a = hours % 10;
        int b = minutes % 10;
        int c = seconds % 10;

        List<Integer> valoresUsados = new ArrayList<>();

        valoresUsados.add(a);
        valoresUsados.add(b);
        valoresUsados.add(c);

        int resultadoRaiz = b*b - 4*a*c;
        int resultadoDenominador = 2*a;

        if(resultadoRaiz < 0 && resultadoDenominador != 0){
            return new CuadraticaResponse(hora, valoresUsados, "No se puede, porque raiz negativa", "No se puede, porque raiz negativa", 
            String.valueOf(resultadoDenominador), "No se puede, porque raiz negativa");
        }

        if(resultadoRaiz < 0 && resultadoDenominador == 0){
            return new CuadraticaResponse(hora, valoresUsados, "No se puede, porque raiz negativa", "No se puede, porque raiz negativa", 
            "No se puede, porque denominador negativo", "No se puede, porque raiz negativa");
        }

        double resultadoNumerador =  ((-b) + Math.sqrt(resultadoRaiz));

        if(resultadoRaiz > 0 && resultadoDenominador == 0){
            return new CuadraticaResponse(hora, valoresUsados, String.valueOf(resultadoRaiz), String.valueOf(resultadoNumerador), 
            "No se puede, porque denominador negativo", "No se puede, porque denominador negativo");
        }

        double resultado = resultadoNumerador/resultadoDenominador;

        return new CuadraticaResponse(hora, valoresUsados, String.valueOf(resultadoRaiz), String.valueOf(resultadoNumerador), 
                    String.valueOf(resultadoDenominador), String.valueOf(resultado));
    }

}
