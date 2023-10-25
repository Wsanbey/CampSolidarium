/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.model.repositorio;

import br.edu.ifpe.model.negocio.Insumo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Well
 */
public class RepositorioInsumo {

    public static List<Insumo> insumos = null;

    static {
        insumos = new ArrayList<>();
 
    }

    public static void create(Insumo o) {
        insumos.add(o);
    }

    public static void update(Insumo o) {

        for (Insumo oAux : insumos) {
            if (oAux.getCodigo() == o.getCodigo()) {
                oAux.setCodigo(o.getCodigo());
                oAux.setNome(o.getNome());
                oAux.setMarca(o.getMarca());
                oAux.setCategoria(o.getCategoria());
                return;
            }
        }

    }

    public static Insumo read(int codigo) {

        for (Insumo oAux : insumos) {
            if (oAux.getCodigo() == codigo) {
                return oAux;
            }
        }
        return null;
    }

    public static void delete(Insumo o) {
        insumos.remove(o);
    }

    public static List<Insumo> readAll() {
        return insumos;
    }

}
