/**
 * Classe para validação de CPF
 */
package validadores;

/**
 *
 * @author claudinei
 */
public class CPF {

    /**
     * Informe um CPF para verificar se o mesmo é válido. EX: 11.222.333/0001-32
     * ou 11222333000132
     *
     * @param CPF
     * @throws Exception
     */
    public static void validar(String CPF) throws Exception {
        CPF = CPF.replaceAll("\\.", "").replaceAll("/", "").replaceAll("-", "").trim();

        if (CPF.equals("00000000000") || !calculaPrimeiroDigito(CPF) || !calculaSegundoDigito(CPF)) {
            throw new Exception("CPF:" + CPF + " inválido.");
        }
    }

    /**
     * Calcula o primeiro digito
     *
     * @param String CPF
     * @return
     * @throws Exception
     */
    private static boolean calculaPrimeiroDigito(String CPF) throws Exception {
        int[] multiplicador = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] auxiliar = new int[multiplicador.length];

        int somatorio = 0, resultado, digito = Integer.parseInt(String.valueOf(CPF.charAt(9)));

        //Faz as devidas multiplicações
        for (int c = 0; c < auxiliar.length; c++) {
            auxiliar[c] = multiplicador[c] * Integer.parseInt(String.valueOf(CPF.charAt(c)));
        }

        //Faz as somas
        for (int c = 0; c < auxiliar.length; c++) {
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
     * @param String CPF
     * @return
     * @throws Exception
     */
    private static boolean calculaSegundoDigito(String CPF) throws Exception {
        int[] multiplicador = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] auxiliar = new int[multiplicador.length];

        int somatorio = 0, resultado, digito = Integer.parseInt(String.valueOf(CPF.charAt(10)));

        //Faz as devidas multiplicações
        for (int c = 0; c < auxiliar.length; c++) {
            auxiliar[c] = multiplicador[c] * Integer.parseInt(String.valueOf(CPF.charAt(c)));
        }

        //Faz as somas
        for (int c = 0; c < auxiliar.length; c++) {
            somatorio += auxiliar[c];
        }

        // Calcula o valor do dígito
        int resto = somatorio % 11;
        resultado = (resto < 2 ? 0 : 11 - resto);

        //Verifica se é válido
        return resultado == digito;
    }
}
