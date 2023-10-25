/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.model.repositorio;

import br.edu.ifpe.model.negocio.Campanha;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Well
 */
public class RepositorioCampanha {

    public static List<Campanha> campanhas = null;

    static {
        campanhas = new ArrayList<>();

        Campanha c = new Campanha();
        c.setCodigo(01);
        c.setDataInicio("22/02/1578");
        c.setDataFim("22/02/2022");
        c.setObjetivo("Testar o cumprimento dos campos");
        c.setDescricao("Inserir novos controles nas academias");
        campanhas.add(c);

        Campanha c2 = new Campanha();
        c2.setCodigo(02);
        c2.setDataInicio("15/05/2020");
        c2.setDataFim("15/05/2021");
        c2.setObjetivo("Aumentar o número de inscrições");
        c2.setDescricao("Oferecer descontos especiais para novos membros");
        campanhas.add(c2);

        Campanha c3 = new Campanha();
        c3.setCodigo(03);
        c3.setDataInicio("10/10/2021");
        c3.setDataFim("10/12/2021");
        c3.setObjetivo("Promover eventos esportivos");
        c3.setDescricao("Realizar torneios de diferentes modalidades esportivas");
        campanhas.add(c3);

        Campanha c4 = new Campanha();
        c4.setCodigo(04);
        c4.setDataInicio("01/03/2022");
        c4.setDataFim("01/06/2022");
        c4.setObjetivo("Incentivar a fidelidade dos clientes");
        c4.setDescricao("Programa de recompensas para membros frequentes");
        campanhas.add(c4);

        Campanha c5 = new Campanha();
        c5.setCodigo(05);
        c5.setDataInicio("05/08/2022");
        c5.setDataFim("05/12/2022");
        c5.setObjetivo("Expandir para novas localidades");
        c5.setDescricao("Abrir filiais em outras cidades");
        campanhas.add(c5);

        Campanha c6 = new Campanha();
        c6.setCodigo(06);
        c6.setDataInicio("20/01/2023");
        c6.setDataFim("20/02/2023");
        c6.setObjetivo("Promover o bem-estar da comunidade");
        c6.setDescricao("Realizar ações sociais e doações para instituições de caridade");
        campanhas.add(c6);

    }

    public static void create(Campanha o) {
        campanhas.add(o);
    }

    public static void update(Campanha o) {

        for (Campanha oAux : campanhas) {
            if (oAux.getCodigo() == o.getCodigo()) {
                oAux.setCodigo(o.getCodigo());
                oAux.setDataInicio(o.getDataInicio());
                oAux.setDataFim(o.getDataFim());
                oAux.setObjetivo(o.getObjetivo());
                oAux.setDescricao(o.getDescricao());
                return;
            }
        }

    }

    public static Campanha read(int codigo) {

        for (Campanha oAux : campanhas) {
            if (oAux.getCodigo() == codigo) {
                return oAux;
            }
        }
        return null;
    }

    public static void delete(Campanha o) {
        campanhas.remove(o);
    }

    public static List<Campanha> readAll() {
        return campanhas;
    }
}
