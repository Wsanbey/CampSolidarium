/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.model.repositorio;

import br.edu.ifpe.model.negocio.Emergencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Well
 */
public class RepositorioEmergencia {

    public static List<Emergencia> emergencia = null;

    static {
        emergencia = new ArrayList<>();
 
    }

    public static void create(Emergencia o) {
        emergencia.add(o);
    }

    public static void update(Emergencia o) {

        for (Emergencia oAux : emergencia) {
            if (oAux.getCodigo() == o.getCodigo()) {
                oAux.setCodigo(o.getCodigo());
                oAux.setLocal(o.getLocal());
                oAux.setTipo(o.getTipo());
                oAux.setDescricao(o.getDescricao());
                return;
            }
        }

    }

    public static Emergencia read(int codigo) {

        for (Emergencia oAux : emergencia) {
            if (oAux.getCodigo() == codigo) {
                return oAux;
            }
        }
        return null;
    }

    public static void delete(Emergencia o) {
        emergencia.remove(o);
    }

    public static List<Emergencia> readAll() {
        return emergencia;
    }

}
