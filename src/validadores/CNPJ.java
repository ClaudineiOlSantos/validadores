/**
 * Classe simples para validação de CNPJ
 */
package validadores;

/**
 * *
 * @author claudinei
 */
public class CNPJ {

    /**
     * Informe um CNPJ para verificar se o mesmo é válido. 
     * EX:
     *  11.222.333/0001-32 ou 11222333000132
     *
     * @param String CNPJ
     * @return boolean
     * @throws Exception
     */
    static void validar(String CNPJ) throws Exception {
        CNPJ = CNPJ.replaceAll("\\.", "").replaceAll("/", "").replaceAll("-", "").trim();

        if (CNPJ.equals("00000000000000") || !calculaPrimeiroDigito(CNPJ) || !calculaSegundoDigito(CNPJ)) {
            throw new Exception("CNPJ:" + CNPJ + " inválido");
        }

    }

    /**
     * Calcula o primeiro digito
     *
     * @param String CNPJ
     * @return
     * @throws Exception
     */
    private static boolean calculaPrimeiroDigito(String CNPJ) throws Exception {
        int[] multiplicador = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] auxiliar = new int[12];

        int resultado = 0, resto, digito = Integer.parseInt(String.valueOf(CNPJ.charAt(12)));

        //Faz as devidas multiplicações
        for (int c = 0; c < auxiliar.length; c++) {
            auxiliar[c] = multiplicador[c] * Integer.parseInt(String.valueOf(CNPJ.charAt(c)));
        }

        //Faz as somas
        for (int c = 0; c < auxiliar.length; c++) {
            resultado += auxiliar[c];
        }

        // Calcula o valor do dígito
        resto = resultado % 11 < 2 ? 0 : resultado % 11;

        //Verifica se é válido
        if (resto == 0 && digito == 0) {
            return true;
        } else if (11 - resto == digito) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Calcula o segundo dígito
     *
     * @param String CNPJ
     * @return
     * @throws Exception
     */
    private static boolean calculaSegundoDigito(String CNPJ) throws Exception {
        int[] multiplicador = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] auxiliar = new int[13];

        int resultado = 0, resto = 0, digito = Integer.parseInt(String.valueOf(CNPJ.charAt(13)));

        //Faz as devidas multiplicações
        for (int c = 0; c < auxiliar.length; c++) {
            auxiliar[c] = multiplicador[c] * Integer.parseInt(String.valueOf(CNPJ.charAt(c)));
        }

        //Faz as somas
        for (int c = 0; c < auxiliar.length; c++) {
            resultado += auxiliar[c];
        }

        // Calcula o valor do dígito
        resto = resultado % 11 < 2 ? 0 : resultado % 11;

        //Verifica se é válido
        if (resto == 0 && digito == 0) {
            return true;
        } else if (11 - resto == digito) {
            return true;
        } else {
            return false;
        }
    }
}
