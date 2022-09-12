/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inclui.kucoin_sdk.inversion_margen_L_S_1;

import com.kucoin.sdk.rest.response.AccountBalancesResponse;
import com.kucoin.sdk.rest.response.MarketItemResponse;
import com.kucoin.sdk.rest.response.SymbolResponse;
import innui.kucoin_sdk.kucoin_sdks;
import innui.modelos.errores.oks;
import java.util.List;

/**
 *
 * @author emilio
 */
public class kucoin_sdk_cluis extends kucoin_sdks {
    public static String k_listar_balances_de_cuenta_cabecera = "%15s, %15s, %15s, %15s, %15s";
    public static String k_listar_balances_de_cuenta_linea = "%15s, %15s, %15.4f, %15.4f, %15.4f";
    public static String k_listar_simbolos_cabecera = "%15s, %15s, %15s, %15s, %15s, %15s, %15s, %15s";
    public static String k_listar_simbolos = "%15s, %15s, %15s, %15s, %15s, %15s, %15s, %15s";
    public static String k_consultar_mercado_de_prestamos_7_dias_cabecera = "%15s, %15s, %15s, %15s";
    public static String k_consultar_mercado_de_prestamos_7_dias = "%15s, %15.4f, %15.4f, %15d";

    public boolean escribir_formateado(String formato, oks ok, Object... extra_array) throws Exception {
        try {
            escribir_linea(formar_texto("", formato, ok, extra_array), ok);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public boolean listar_balances_de_cuentas_escribir(List<AccountBalancesResponse> accountBalancesResponses_list, oks ok, Object... extra_array) throws Exception {
        try {
            if (ok.es == false) { return false; }
            escribir_formateado(k_listar_balances_de_cuenta_cabecera, ok,
            "Tipo", "Moneda", "Balance", "Disponible","Retenido");
            for (AccountBalancesResponse accountBalancesResponse : accountBalancesResponses_list) {
                escribir_formateado(k_listar_balances_de_cuenta_linea, ok,
                accountBalancesResponse.getType(),
                accountBalancesResponse.getCurrency(),
                accountBalancesResponse.getBalance().doubleValue(),
                accountBalancesResponse.getAvailable().doubleValue(),
                accountBalancesResponse.getHolds().doubleValue());                   
            }
            return ok.es;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean listar_simbolos_escribir(List<SymbolResponse> symbolResponse_list, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return false; }
            escribir_formateado(k_listar_simbolos_cabecera, ok,
            "Símbolo", "Nombre", "Mercado", "Moneda base", "Moneda contra","Moneda pago", "A vista", "Margen");
            for (SymbolResponse symbolResponse : symbolResponse_list) {
                escribir_formateado(k_listar_simbolos, ok,
                symbolResponse.getSymbol(),
                symbolResponse.getName(),
                symbolResponse.getMarket(),
                symbolResponse.getBaseCurrency(),
                symbolResponse.getQuoteCurrency(),
                symbolResponse.getFeeCurrency(),
                symbolResponse.getEnableTrading()?"Sí":"No",
                symbolResponse.getIsMarginEnabled()?"Sí":"No");
            }
            return ok.es;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Escribir los datos del mercado de prestamos a 7 dias para un simbolo
     * @param marketItemResponse_list Listado que escribir
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return true si todo va bien
     * @throws Exception Opción de notificar errores de excepción
     */
    @Override
    public boolean consultar_mercado_de_prestamos_7_dias_escribir(String simbolo, List<MarketItemResponse> marketItemResponse_list, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return false; }
            escribir_formateado(k_consultar_mercado_de_prestamos_7_dias_cabecera, ok,
            simbolo, "Interés diario", "Cant.prestable", "Duración");
            for (MarketItemResponse marketItemResponse : marketItemResponse_list) {
                escribir_formateado(k_consultar_mercado_de_prestamos_7_dias, ok,
                    "",
                    marketItemResponse.getDailyIntRate(),
                    marketItemResponse.getSize(),
                    marketItemResponse.getTerm());
            }
            return ok.es;
        } catch (Exception e) {
            throw e;
        }
    }
    
}
