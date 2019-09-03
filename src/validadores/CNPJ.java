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
     * Informe um CNPJ para verificar se o mesmo é válido. EX:
     * 11.222.333/0001-32 ou 11222333000132
     *
     * @param CNPJ
     * @throws Exception
     */
    public static void validar(String CNPJ) throws Exception {
        //Limpa a string
        CNPJ = CNPJ.replaceAll("\\.", "").replaceAll("/", "").replaceAll("-", "").trim();

        //Valida o CNPJ
        if (CNPJ.equals("00000000000000")
                || !validaPrimeiroDigito(CNPJ)
                || !validaSegundoDigito(CNPJ)
                || CNPJ.length() != 14) {
            throw new Exception("CNPJ:" + CNPJ + " inválido.");
        }
    }

    /**
     * Calcula o primeiro digito
     *
     * @param String CNPJ
     * @return
     * @throws Exception
     */
    private static boolean validaPrimeiroDigito(String CNPJ) throws Exception {
        int[] multiplicador = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] auxiliar = new int[multiplicador.length];

        int somatorio = 0, resultado, digito = Integer.parseInt(String.valueOf(CNPJ.charAt(12)));

        //Faz as devidas multiplicações
        for (int c = 0; c < auxiliar.length; c++) {
            auxiliar[c] = multiplicador[c] * Integer.parseInt(String.valueOf(CNPJ.charAt(c)));
            somatorio += auxiliar[c];
        }

        // Calcula o valor do dígito
        int resto = somatorio % 11;
        resultado = (resto < 2 ? 0 : 11 - resto);

        //Verifica se é válido
        return resultado == digito;
    }

    /**
     * Calcula o segundo dígito
     *
     * @param String CNPJ
     * @return
     * @throws Exception
     */
    private static boolean validaSegundoDigito(String CNPJ) throws Exception {
        int[] multiplicador = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] auxiliar = new int[multiplicador.length];

        int somatorio = 0, resultado, digito = Integer.parseInt(String.valueOf(CNPJ.charAt(13)));

        //Faz as devidas multiplicações
        for (int c = 0; c < auxiliar.length; c++) {
            auxiliar[c] = multiplicador[c] * Integer.parseInt(String.valueOf(CNPJ.charAt(c)));
            somatorio += auxiliar[c];
        }

        // Calcula o valor do dígito
        int resto = somatorio % 11;
        resultado = (resto < 2 ? 0 : 11 - resto);

        //Verifica se é válido
        return resultado == digito;
    }
}
