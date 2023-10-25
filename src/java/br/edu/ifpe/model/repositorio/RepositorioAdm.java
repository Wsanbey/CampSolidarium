/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.model.repositorio;

import br.edu.ifpe.model.negocio.Adm;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Well
 */
public class RepositorioAdm {

    public static List<Adm> adms = null;

    static {
        adms = new ArrayList<>();

        Adm ad = new Adm();

        ad.setLogin("matias_faio@hotmail.com");
        ad.setSenha("aSASdsdd1#123123");

        Adm ad2 = new Adm();
        ad2.setLogin("joana_admin@gmail.com");
        ad2.setSenha("qweRtyu!45");
        adms.add(ad2);

        Adm ad3 = new Adm();
        ad3.setLogin("pedro_admin@yahoo.com");
        ad3.setSenha("P@ssw0rd");
        adms.add(ad3);

        Adm ad4 = new Adm();
        ad4.setLogin("lucas_admin@outlook.com");
        ad4.setSenha("Admin123!");
        adms.add(ad4);

        Adm ad5 = new Adm();
        ad5.setLogin("maria_admin@live.com");
        ad5.setSenha("Adm@5678");
        adms.add(ad5);

        Adm ad6 = new Adm();
        ad6.setLogin("ana_admin@gmail.com");
        ad6.setSenha("AdminPass#123");
        adms.add(ad6);

    }

    public static void create(Adm o) {
        adms.add(o);
    }

    public static void update(Adm a) {

        for (Adm Aux : adms) {
            if (Aux.getLogin() == a.getLogin()) {
                Aux.setLogin(a.getLogin());
                Aux.setSenha(a.getSenha());
                return;
            }
        }
    }

    public static Adm read(String login) {
        for (Adm adm : adms) {
            if (adm.getLogin() == login) {
                return adm;
            }
        }
        return null;
    }

    public static void delete(Adm a) {
        adms.remove(a);
    }

    public static List<Adm> readAll() {
        return adms;
    }
}
