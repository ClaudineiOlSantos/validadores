/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validadores;

/**
 *
 * @author claudinei
 */
public class Validadores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        try {
            CNPJ.validar("11.222.333/0001-81");
            CNPJ.validar("14.572.457.0001-85");
            CNPJ.validar("71.967.796/0001-02");
            CNPJ.validar("15.476.007/0001-51");
            CNPJ.validar("56.913.012/0001-61");
            CNPJ.validar("36.172.855/0001-47");
            CNPJ.validar("74.803.675/0001-05");
            CNPJ.validar("43.637.897/0001-71");
            CNPJ.validar("68.506.554/0001-07");
            CNPJ.validar("80.555.080/0001-80");
            CNPJ.validar("28.454.332/0001-65");
            CNPJ.validar("69.896.606/0001-53");
            CNPJ.validar("03.984.842/0001-13");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        // TODO code application logic here
    }

}
