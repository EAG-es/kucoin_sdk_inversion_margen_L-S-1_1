/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package innui.kucoin_sdk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kucoin.sdk.KucoinClientBuilder;
import com.kucoin.sdk.KucoinRestClient;
import com.kucoin.sdk.exception.KucoinApiException;
import com.kucoin.sdk.rest.request.BorrowRequest;
import com.kucoin.sdk.rest.request.MarginOrderCreateRequest;
import com.kucoin.sdk.rest.request.StopOrderCreateRequest;
import com.kucoin.sdk.rest.response.AccountBalancesResponse;
import com.kucoin.sdk.rest.response.BorrowQueryResponse;
import com.kucoin.sdk.rest.response.BorrowResponse;
import com.kucoin.sdk.rest.response.MarginAccount;
import com.kucoin.sdk.rest.response.MarginAccountResponse;
import com.kucoin.sdk.rest.response.MarginOrderCreateResponse;
import com.kucoin.sdk.rest.response.MarketItemResponse;
import com.kucoin.sdk.rest.response.OrderCreateResponse;
import com.kucoin.sdk.rest.response.OrderResponse;
import com.kucoin.sdk.rest.response.StopOrderResponse;
import com.kucoin.sdk.rest.response.SymbolResponse;
import innui.bases;
import innui.ref;
import innui.utiles.bigdecimals.BigDecimals;
import static innui.utiles.bigdecimals.BigDecimals.divide_0;
import static innui.utiles.bigdecimals.BigDecimals.nulo_es_0;
import innui.modelos.configuraciones.ResourceBundles;
import innui.modelos.errores.oks;
import innui.modelos.internacionalizacion.tr;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.UUID;

/**
 *
 * @author emilio
 */
public class kucoin_sdks extends bases {
    public static class modelos {
        public static String k_url_base_sandbox_kucoin = "https://openapi-sandbox.kucoin.com";
        public static String k_url_base_kucoin = "https://openapi-v2.kucoin.com";
        public static String k_clave = "innui.kucoin_sdk.kucoin_sdks.modelo.clave";
        public static String k_secreto = "innui.kucoin_sdk.kucoin_sdks.modelo.secreto";
        public static String k_contraseña = "innui.kucoin_sdk.kucoin_sdks.modelo.contraseña";        
        public static String k_es_modo_prueba = "innui.kucoin_sdk.kucoin_sdks.modelo.es_modo_prueba";
        public String url_base; 
        public String clave;
        public String secreto;
        public String contraseña;
        public boolean es_modo_prueba;
    }
    public static String k_in_ruta = "in/innui/kucoin_sdk/in";  //NOI18N    
    public static String k_margen="k_margen";
    public static String k_pareja_simbolos = "k_pareja_simbolos";
    public static String k_importe_maximo = "k_importe_maximo";
    public static int k_7_dias = 7;    
    public static String k_simbolo_base = "simbolo_base";
    public static String k_simbolo_contra = "simbolo_contra";
    public static String k_importe_base = "importe_base";
    public static String k_importe_contra = "importe_contra";
    public static String k_importe_mitad_ratio = "importe_mitad_ratio";
    public static String k_cotizacion_base = "cotizacion_base";
    public static String k_cotizacion_contra = "cotizacion_contra";
    public static String k_cantidad_base = "cantidad_base";
    public static String k_cantidad_contra = "cantidad_contra";
    public static String k_ratio_subida = "ratio_subida";
    public static String k_ejecutar_estrategia_l_s_1_margen_2_incidencias = "ejecutar_estrategia_l_s_1_margen_2_incidencias";
    public static String k_ejecutar_estrategia_l_s_1_margen_2_identificador = "ejecutar_estrategia_l_s_1_margen_2_identificador";
    public static String k_orden_venta_subida_cantidad = "orden_venta_subida_cantidad";
    public static String k_orden_venta_subida_cotizacion = "orden_venta_subida_cotizacion";
    public static String k_orden_compra_bajada_cantidad = "orden_compra_bajada_cantidad";
    public static String k_orden_compra_bajada_cotizacion = "orden_compra_bajada_cotizacion";
    public static String k_orden_compra_subida_mitad_cantidad = "orden_compra_subida_mitad_cantidad";
    public static String k_orden_compra_subida_mitad_cotizacion = "orden_compra_subida_mitad_cotizacion";
    public static String k_orden_venta_bajada_mitad_cantidad = "orden_venta_bajada_mitad_cantidad";
    public static String k_orden_venta_bajada_mitad_cotizacion = "orden_venta_bajada_mitad_cotizacion";
    public static String k_prestamo_obtenido_base = "prestamo_obtenido_base";
    public static String k_prestamo_obtenido_contra = "prestamo_obtenido_contra";
    public static String k_maximo_ratio_endeudamiento_margen = "maximo_ratio_endeudamiento_margen";
    public static String k_ratio_deuda_inicial = "ratio_deuda_inicial";
    public static String k_maximo_prestable_base = "maximo_prestable_base";
    public static String k_total_deudas_base = "total_deudas_base";
    public static String k_total_balance_base = "total_balance_base";
    public static String k_maximo_prestable_contra = "maximo_prestable_contra";
    public static String k_total_deudas_contra = "total_deudas_contra";
    public static String k_total_balance_contra = "total_balance_contra";
    public static String k_consulta_prestamo_simbolo_base = "consulta_prestamo_simbolo_base";
    public static String k_consulta_prestamo_importe_base = "consulta_prestamo_importe_base";
    public static String k_consulta_prestamo_simbolo_contra = "consulta_prestamo_simbolo_contra";
    public static String k_consulta_prestamo_importe_contra = "consulta_prestamo_importe_contra";
    public static String k_consulta_prestamo_pendiente_repago_base = "consulta_prestamo_pendiente_repago_base";
    public static String k_consulta_prestamo_pendiente_repago_contra = "consulta_prestamo_pendiente_repago_contra";
    public static String k_ovs = "ovs";
    public static String k_ocb = "ocb";
    public static String k_ocsm = "ocsm";
    public static String k_ovbm = "ovbm";
    public static String k_consultar_orden_stop_fecha_inicio = "consultar_orden_stop_fecha_inicio";
    public static String k_consultar_orden_es_trato = "consultar_orden_es_en_proceso";
    public static String k_consultar_orden_origen_resultado = "consultar_orden_origen_resultado";
    public static String k_consultar_orden_resultado = "consultar_orden_resultado";
    public static String k_consultar_orden_pendiente = "consultar_orden_pendiente";
    public static String k_comprobar_estrategia_l_s_1_resultado_subida = "comprobar_estrategia_l_s_1_resultado_subida";
    public static String k_comprobar_estrategia_l_s_1_resultado_bajada = "comprobar_estrategia_l_s_1_resultado_bajada";
    public static String k_comprobar_estrategia_l_s_1_es_bajada_terminada = "comprobar_estrategia_l_s_1_es_bajada_terminada";
    public static String k_comprobar_estrategia_l_s_1_es_subida_terminada = "comprobar_estrategia_l_s_1_es_subida_terminada";
    public static String k_no_prestamo_si_hay = "no_prestamo_si_hay";
    public static BigDecimal k_maximo_ratio_endeudamiento_margen_por_defecto = BigDecimal.valueOf(0.5); // Ratio entre 0 - 1 que se permite de endeudamiento 
    public static BigDecimal K_porcentaje_a_invertir = BigDecimal.valueOf(0.98);
    public modelos modelo;
    public KucoinClientBuilder _kucoinClientBuilder;
    public KucoinRestClient _kucoinRestClient;
    
    /**
     * Inicia el objeto
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return true si todo va bien
     * @throws Exception Opción de notificar errores de excepción
     */
    public boolean iniciar(oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return false; }
            modelo = new modelos();
            return ok.es;
        } catch (Exception e) {
            throw e;
        }
    }    
    /**
     * Conecta el objeto con Kucoin
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return true si todo va bien
     * @throws Exception Opción de notificar errores de excepción
     */
    public boolean crear_cliente(oks ok, Object ... extra_array) throws Exception  {
        try {
            if (ok.es == false) { return false; }
            _kucoinClientBuilder = new KucoinClientBuilder();
            if (modelo.es_modo_prueba) { 
                _kucoinClientBuilder = _kucoinClientBuilder.withBaseUrl(modelos.k_url_base_sandbox_kucoin)
                    .withApiKey(modelo.clave, modelo.secreto, modelo.contraseña);
            } else {
                _kucoinClientBuilder = _kucoinClientBuilder.withBaseUrl(modelos.k_url_base_kucoin)
                    .withApiKey(modelo.clave, modelo.secreto, modelo.contraseña);
            }
            _kucoinRestClient  = _kucoinClientBuilder.buildRestClient();
            return ok.es;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Listar balances de cuentas
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return true si todo va bien
     * @throws Exception Opción de notificar errores de excepción
     */
    public List<AccountBalancesResponse> listar_balances_de_cuentas(oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            List<AccountBalancesResponse> accountBalancesResponses_list = _kucoinRestClient.accountAPI()
                    .listAccounts(null, null);
            listar_balances_de_cuentas_escribir(accountBalancesResponses_list, ok);
            if (ok.es == false) { return null; }
            return accountBalancesResponses_list;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Escribir los datos de Listar balances de cuentas
     * @param accountBalancesResponses_list Listado que escribir
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return true si todo va bien
     * @throws Exception Opción de notificar errores de excepción
     */
    public boolean listar_balances_de_cuentas_escribir(List<AccountBalancesResponse> accountBalancesResponses_list, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return false; }
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            String texto = gson.toJson(accountBalancesResponses_list);
            escribir_linea(texto, ok);
            return ok.es;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Listar balances de cuentas de intercambio (trade)
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return la lista
     * @throws Exception Opción de notificar errores de excepción
     */
    public List<AccountBalancesResponse> listar_balances_de_cuenta_intercambio(oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            List<AccountBalancesResponse> accountBalancesResponses_list = _kucoinRestClient.accountAPI()
                    .listAccounts(null, "trade");
            ok.es = listar_balances_de_cuentas_escribir(accountBalancesResponses_list, ok);
            if (ok.es == false) { return null; }
            return accountBalancesResponses_list;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Listar balances de cuentas de margen (margin)
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return la lista
     * @throws Exception Opción de notificar errores de excepción
     */
    public List<AccountBalancesResponse> listar_balances_de_cuenta_margen(oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            List<AccountBalancesResponse> accountBalancesResponses_list = _kucoinRestClient.accountAPI()
                    .listAccounts(null, "margin");
            ok.es = listar_balances_de_cuentas_escribir(accountBalancesResponses_list, ok);
            if (ok.es == false) { return null; }
            return accountBalancesResponses_list;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Listar simbolos de mercado
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return true si todo va bien
     * @throws Exception Opción de notificar errores de excepción
     */
    public List<SymbolResponse> listar_simbolos(oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            List<SymbolResponse> symbolResponse_list = _kucoinRestClient.symbolAPI().getSymbols();
            ok.es = listar_simbolos_escribir(symbolResponse_list, ok);
            if (ok.es == false) { return null; }
            return symbolResponse_list;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Listar simbolos de mercado
     * @param moneda Simbolo de la moneda que buscar
     * @param mercado k_margin o "" o null
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return true si todo va bien
     * @throws Exception Opción de notificar errores de excepción
     */
    public List<SymbolResponse> listar_simbolos(String moneda, String mercado, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            List<SymbolResponse> symbolResponse_list = _kucoinRestClient.symbolAPI().getSymbols();
            List<SymbolResponse> symbolResponse_resultado_list;
            int i = 0;
            int tam = symbolResponse_list.size();
            SymbolResponse symbolResponse;
            String texto_buscado, texto_encontrado;
            texto_buscado = moneda.toLowerCase();
            if (mercado == null) {
                mercado = "";
            }
            mercado = mercado.toLowerCase();
            symbolResponse_resultado_list = new ArrayList<>();
            boolean es = false;
            while (true) {
                if (i >= tam) {
                    break;
                }
                es = false;
                symbolResponse = symbolResponse_list.get(i);
                texto_encontrado = symbolResponse.getBaseCurrency().toLowerCase();
                if (texto_encontrado.equals(texto_buscado)) {
                    es = true;
                } else {
                    texto_encontrado = symbolResponse.getQuoteCurrency().toLowerCase();
                    if (texto_encontrado.equals(texto_buscado)) {
                        es = true;
                    } 
                }
                if (es) {
                    if (mercado.equals(k_margen)) {
                        if (symbolResponse.getIsMarginEnabled()) {
                            symbolResponse_resultado_list.add(symbolResponse);
                        }
                    } else {
                        symbolResponse_resultado_list.add(symbolResponse);
                    }
                }
                i = i + 1;
            }
            listar_simbolos_escribir(symbolResponse_resultado_list, ok);
            if (ok.es == false) { return null; }
            return symbolResponse_list;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Escribir los datos de Listar balances de cuentas
     * @param symbolResponse_list Listado que escribir
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return true si todo va bien
     * @throws Exception Opción de notificar errores de excepción
     */
    public boolean listar_simbolos_escribir(List<SymbolResponse> symbolResponse_list, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return false; }
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            String texto = gson.toJson(symbolResponse_list);
            escribir_linea(texto, ok);
            return ok.es;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Listar simbolos de mercado
     * @param par Par de símbolos de la moneda que buscar
     * @param mercado k_margin o "" o null
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return true si todo va bien
     * @throws Exception Opción de notificar errores de excepción
     */
    public List<SymbolResponse> buscar_par(String par, String mercado, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            List<SymbolResponse> symbolResponse_list = _kucoinRestClient.symbolAPI().getSymbols();
            List<SymbolResponse> symbolResponse_resultado_list;
            int i = 0;
            int tam = symbolResponse_list.size();
            SymbolResponse symbolResponse;
            String texto_buscado, texto_encontrado;
            texto_buscado = par.toLowerCase();
            if (mercado == null) {
                mercado = "";
            }
            mercado = mercado.toLowerCase();
            symbolResponse_resultado_list = new ArrayList<>();
            boolean es = false;
            while (true) {
                if (i >= tam) {
                    break;
                }
                es = false;
                symbolResponse = symbolResponse_list.get(i);
                texto_encontrado = symbolResponse.getSymbol().toLowerCase();
                if (texto_encontrado.equals(texto_buscado)) {
                    es = true;
                }
                if (es) {
                    if (mercado.equals(k_margen)) {
                        if (symbolResponse.getIsMarginEnabled()) {
                            symbolResponse_resultado_list.add(symbolResponse);
                        }
                    } else {
                        symbolResponse_resultado_list.add(symbolResponse);
                    }
                }
                i = i + 1;
            }
            listar_simbolos_escribir(symbolResponse_resultado_list, ok);
            if (ok.es == false) { return null; }
            return symbolResponse_list;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Leer las cotizaciones en USD de dos símbolos
     * @param simbolo_base Símbolo base
     * @param simbolo_contra Símbolo de contraprestación
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return Un mapa con las cotizaciones de los dos símbolos, o null.
     * @throws Exception Opción de notificar errores de excepción
     */    
    public Map<String, BigDecimal> leer_cotizacion_usd(String simbolo_base, String simbolo_contra, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            Map<String, BigDecimal> fiatPrice_map;
            fiatPrice_map = _kucoinRestClient.currencyAPI().getFiatPrice("USD", simbolo_base + ", " + simbolo_contra);
            return fiatPrice_map;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Listar simbolos de los que se puede pedir préstamo
     * @param simbolo Símbolo de la moneda
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return true si todo va bien
     * @throws Exception Opción de notificar errores de excepción
     */
    public List<MarketItemResponse> consultar_mercado_de_prestamos_7_dias(String simbolo, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            List<MarketItemResponse> marketItemResponse_list = _kucoinRestClient.loanAPI().queryMarket(simbolo, k_7_dias);
            ok.es = consultar_mercado_de_prestamos_7_dias_escribir(simbolo, marketItemResponse_list, ok);
            if (ok.es == false) { return null; }
            return marketItemResponse_list;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Listar ordenadamente los ratios de préstamo para un simbolo
     * @param simbolo Símbolo de la moneda
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return true si todo va bien
     * @throws Exception Opción de notificar errores de excepción
     */
    public TreeMap<BigDecimal, MarketItemResponse> obtener_ratios_mercado_de_prestamos_7_dias(String simbolo, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            TreeMap<BigDecimal, MarketItemResponse> sortedMap = null;
            List<MarketItemResponse> marketItemResponse_list = _kucoinRestClient.loanAPI().queryMarket(simbolo, k_7_dias);
            sortedMap = new TreeMap<>();
            for (MarketItemResponse marketItemResponse: marketItemResponse_list) {
                sortedMap.put(marketItemResponse.getDailyIntRate(), marketItemResponse);
            }
            return sortedMap;
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
    public boolean consultar_mercado_de_prestamos_7_dias_escribir(String simbolo, List<MarketItemResponse> marketItemResponse_list, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return false; }
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            String texto = gson.toJson(marketItemResponse_list);
            escribir_linea(simbolo, ok);
            escribir_linea(texto, ok);
            return ok.es;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Primera fase de la estrategia_l_s_1_margen
     * @param datos_mapa Mapa con los datos de entrada
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return mapa con los resultados, o null
     * @throws Exception Opción de notificar errores de excepción
     */
    public Map<String, Object> ejecutar_estrategia_l_s_1_margen_1(Map<String, Object> datos_mapa, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            oks ok_local = new oks();
            Map<String, Object> mapa_retorno = null;
            Map<String, BigDecimal> fiatPrice_map = null;
            BigDecimal importe_maximo;
            BigDecimal importe_base = null;
            BigDecimal importe_contra = null;
            BigDecimal importe_mitad_ratio = null;
            BigDecimal cotizacion_base = null;
            BigDecimal cotizacion_contra = null;
            BigDecimal cantidad_base = null;
            BigDecimal cantidad_contra = null;
            BigDecimal ratio_deuda = null;
            BigDecimal maxBorrowSize = null;
            BigDecimal liability = null;
            BigDecimal totalBalance = null;
            BigDecimal ratio_deuda_maximo = null;
            String pareja_simbolos;
            String simbolo_base;
            String simbolo_contra;
            String [] simbolos_array;
            MarginAccountResponse marginAccountResponse = null;
            MathContext mathContext;
            mathContext = new MathContext(5, RoundingMode.HALF_UP);
            ResourceBundle in = null;
            in = ResourceBundles.getBundle(k_in_ruta);
            mapa_retorno = new HashMap<> ();
            importe_maximo = (BigDecimal) datos_mapa.get(k_importe_maximo);
            pareja_simbolos = (String) datos_mapa.get(k_pareja_simbolos);
            pareja_simbolos = pareja_simbolos.toUpperCase();
            simbolos_array = pareja_simbolos.split("-");
            simbolo_base = simbolos_array[0].trim();
            simbolo_contra = simbolos_array[1].trim();
            importe_base = divide_0(importe_maximo, BigDecimal.valueOf(2), ok, 2, mathContext.getRoundingMode());
            if (ok.es == false) { return null; }
            importe_contra = importe_base;
            importe_mitad_ratio = importe_base;
            fiatPrice_map = leer_cotizacion_usd(simbolo_base, simbolo_contra, ok);
            if (ok.es == false) { return null; }
            cotizacion_base = fiatPrice_map.get(simbolo_base);
            ok_local.no_nul(cotizacion_base);
            if (ok_local.es == false) {
                ok_local.setTxt(ok_local.getTxt(), "No se ha encontrado la cotización del símbolo base. ");
            }
            if (ok.es == false) { return null; }
            cotizacion_contra = fiatPrice_map.get(simbolo_contra);
            ok_local.no_nul(cotizacion_contra);
            if (ok_local.es == false) {
                ok_local.setTxt(ok_local.getTxt(), "No se ha encontrado la cotización del símbolo de contraprestación. ");
            }
            if (ok_local.es == false) {
                ok.setTxt(ok_local.getTxt());
            }
            if (ok.es == false) { return null; }
            cantidad_base = divide_0(importe_base, cotizacion_base, ok, mathContext.getPrecision(), mathContext.getRoundingMode());
            cantidad_contra = divide_0(importe_contra, cotizacion_contra, ok, mathContext.getPrecision(), mathContext.getRoundingMode());
            if (ok.es == false) { return null; }
            mapa_retorno.put(k_simbolo_base, simbolo_base);
            mapa_retorno.put(k_simbolo_contra, simbolo_contra);
            mapa_retorno.put(k_importe_base, importe_base);
            mapa_retorno.put(k_importe_contra, importe_contra);
            mapa_retorno.put(k_importe_mitad_ratio, importe_mitad_ratio);
            mapa_retorno.put(k_cotizacion_base, cotizacion_base);
            mapa_retorno.put(k_cotizacion_contra, cotizacion_contra);
            mapa_retorno.put(k_cantidad_base, cantidad_base);
            mapa_retorno.put(k_cantidad_contra, cantidad_contra);
            marginAccountResponse = consultar_cuenta_margen(ok);
            if (ok.es == false) { return null; }
            ratio_deuda_maximo = (BigDecimal) datos_mapa.get(k_maximo_ratio_endeudamiento_margen);
            if (ratio_deuda_maximo == null) {
                ratio_deuda_maximo = k_maximo_ratio_endeudamiento_margen_por_defecto;
                mapa_retorno.put(k_maximo_ratio_endeudamiento_margen, k_maximo_ratio_endeudamiento_margen_por_defecto);
            }
            ratio_deuda = marginAccountResponse.getDebtRatio();
            mapa_retorno.put(k_ratio_deuda_inicial, ratio_deuda);
            if (ratio_deuda.compareTo(ratio_deuda_maximo) > 0) {
                ok.setTxt(tr.in(in, "Error: máximo ratio de endeudamiento superado: ")
                    + ratio_deuda_maximo.toPlainString());
            }
            if (ok.es == false) { return null; }
            for (MarginAccount marginAccount: marginAccountResponse.getAccounts()) {
                if (marginAccount.getCurrency().equals(simbolo_base)
                        || marginAccount.getCurrency().equals(simbolo_contra)) {
                    maxBorrowSize = marginAccount.getMaxBorrowSize();
                    liability = marginAccount.getLiability();
                    totalBalance = marginAccount.getTotalBalance();
                    if (marginAccount.getCurrency().equals(simbolo_base)) {
                        mapa_retorno.put(k_maximo_prestable_base, maxBorrowSize);
                        mapa_retorno.put(k_total_deudas_base, liability);
                        mapa_retorno.put(k_total_balance_base, totalBalance);
                        if (cantidad_base.compareTo(maxBorrowSize) >= 0) {
                            ok_local.setTxt(ok_local.getTxt(), simbolo_base + " " + tr.in(in, "Error: Solicita más cantidad de la que se le presta: ")
                                + maxBorrowSize.toPlainString());
                        }
                    } else {
                        mapa_retorno.put(k_maximo_prestable_contra, maxBorrowSize);
                        mapa_retorno.put(k_total_deudas_contra, liability);
                        mapa_retorno.put(k_total_balance_contra, totalBalance);
                        if (cantidad_contra.compareTo(maxBorrowSize) >= 0) {
                            ok_local.setTxt(ok_local.getTxt(), simbolo_contra + " " + tr.in(in, "Error: Solicita más cantidad de la que se le presta: ")
                                + maxBorrowSize.toPlainString());
                        }
                    }
                }
            }
            ok.setTxt(ok_local.getTxt());
            return mapa_retorno;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Segunda fase de la estrategia_l_s_1_margen
     * @param datos_mapa Mapa con los datos de entrada
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return mapa con los resultados, o null
     * @throws Exception Opción de notificar errores de excepción
     */
    public Map<String, Object> ejecutar_estrategia_l_s_1_margen_2(String modo, Map<String, Object> datos_mapa, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            Map<String, Object> mapa_retorno = null;
            BigDecimal ratio_subida = null;
            BigDecimal ratio_subida_mitad = null;
            BigDecimal cotizacion_contra = null;
            BigDecimal cotizacion_base = null;
            BigDecimal cotizacion_base_subida_mitad = null;
            BigDecimal cotizacion_base_subida = null;
            BigDecimal cotizacion_base_bajada_mitad = null;
            BigDecimal cotizacion_base_bajada = null;
            String pareja_simbolos = null;
            String identificador = "";
            String simbolo_base = null;
            String simbolo_contra = null;
            BigDecimal cantidad_base = null;
            BigDecimal cantidad_contra = null;
            BigDecimal cantidad_base_prestada = null;
            BigDecimal cantidad_contra_prestada = null;
            BigDecimal bigDecimal = null;
            BigDecimal total_balance_base = null;
            BigDecimal total_balance_contra = null;
            BigDecimal parte_ya_hay_base = null;
            BigDecimal parte_ya_hay_contra = null;
            boolean es_prestamo_base = false;
            boolean es_prestamo_contra = false;
            ref<BigDecimal> ref_BigDecimal = new ref<>();
            BorrowResponse prestamo_base_borrowResponse = null;
            BorrowResponse prestamo_contra_borrowResponse = null;
            OrderCreateResponse orden_venta_subida = null;
            OrderCreateResponse orden_compra_bajada = null;
            OrderCreateResponse orden_compra_subida_mitad = null;
            OrderCreateResponse orden_venta_bajada_mitad = null;
            MathContext mathContext;
            mathContext = new MathContext(5, RoundingMode.HALF_UP);
            ResourceBundle in = null;
            in = ResourceBundles.getBundle(k_in_ruta);
            oks ok_local = new oks();
            BorrowQueryResponse borrowQueryResponse_base = null;
            BorrowQueryResponse borrowQueryResponse_contra = null;
            ratio_subida = (BigDecimal) datos_mapa.get(k_ratio_subida);
            // Pasar % a número (dividir entre 100)
            ratio_subida = divide_0(ratio_subida, BigDecimal.valueOf(100.00), ok, 4, mathContext.getRoundingMode());
            ratio_subida_mitad = divide_0(ratio_subida, BigDecimal.valueOf(2.0), ok, 4, mathContext.getRoundingMode());
            if (ok.es == false) { return null; }
            cotizacion_contra = (BigDecimal) datos_mapa.get(k_cotizacion_contra);
            cotizacion_base = (BigDecimal) datos_mapa.get(k_cotizacion_base);
            cotizacion_base_subida_mitad = cotizacion_base.multiply(ratio_subida_mitad.add(BigDecimal.ONE), mathContext);
            cotizacion_base_subida = cotizacion_base.multiply(ratio_subida.add(BigDecimal.ONE), mathContext);
            cotizacion_base_bajada_mitad = divide_0(cotizacion_base, ratio_subida_mitad.add(BigDecimal.ONE), ok, 4, mathContext.getRoundingMode());
            cotizacion_base_bajada = divide_0(cotizacion_base, ratio_subida.add(BigDecimal.ONE), ok, 4, mathContext.getRoundingMode());
            if (ok.es == false) { return null; }
            // Préstamos
            simbolo_base = (String) datos_mapa.get(k_simbolo_base);
            simbolo_contra = (String) datos_mapa.get(k_simbolo_contra);
            cantidad_base = (BigDecimal) datos_mapa.get(k_cantidad_base);
            cantidad_contra = (BigDecimal) datos_mapa.get(k_cantidad_contra);
            parte_ya_hay_base = BigDecimal.ZERO;
            if (modo.equals(k_no_prestamo_si_hay)) {
                total_balance_base = (BigDecimal) datos_mapa.get(k_total_balance_base);
                if (total_balance_base.compareTo(cantidad_base) < 0) {
                    parte_ya_hay_base = total_balance_base;
                    bigDecimal = cantidad_base.subtract(total_balance_base, mathContext);
                    ref_BigDecimal.set(bigDecimal);
                    es_prestamo_base = true;
                } else {
                    es_prestamo_base = false;
                }
            } else {
                ref_BigDecimal.set(cantidad_base);
                es_prestamo_base = true;
            }
            if (es_prestamo_base) {
                prestamo_base_borrowResponse = pedir_prestamo_7_dias(simbolo_base, ref_BigDecimal, ok);
                cantidad_base = ref_BigDecimal.get();
                ok.no_nul(prestamo_base_borrowResponse);
                if (ok.es == false) {
                    if (cantidad_base.compareTo(BigDecimal.ZERO) > 0) {
                        ok.setTxt(tr.in(in, "Error al pedir préstamo de moneda base. "), ok.getTxt());
                    } else {
                        ok.es = true;
                    }                    
                }
                if (ok.es == false) { return null; }
                cantidad_base = cantidad_base.add(parte_ya_hay_base, mathContext);
            }
            parte_ya_hay_contra = BigDecimal.ZERO;
            if (modo.equals(k_no_prestamo_si_hay)) {
                total_balance_contra = (BigDecimal) datos_mapa.get(k_total_balance_contra);
                if (total_balance_contra.compareTo(cantidad_contra) < 0) {
                    parte_ya_hay_contra = total_balance_contra;
                    bigDecimal = cantidad_contra.subtract(total_balance_contra, mathContext);
                    ref_BigDecimal.set(bigDecimal);
                    es_prestamo_contra = true;
                } else {
                    es_prestamo_contra = false;
                }
            } else {
                ref_BigDecimal.set(cantidad_contra);
                es_prestamo_contra = true;
            }
            if (es_prestamo_contra) {
                prestamo_contra_borrowResponse = pedir_prestamo_7_dias(simbolo_contra, ref_BigDecimal, ok);
                cantidad_contra = ref_BigDecimal.get();
                ok.no_nul(prestamo_base_borrowResponse);
                if (ok.es == false) {
                    if (cantidad_contra.compareTo(BigDecimal.ZERO) > 0) {
                        ok.setTxt(tr.in(in, "Error al pedir préstamo de moneda de contrapartida. "), ok.getTxt());
                    } else {
                        ok.es = true;
                    }
                }
                if (ok.es == false) { return null; }
                cantidad_contra = cantidad_contra.add(parte_ya_hay_contra, mathContext);
            }
            cantidad_base = cantidad_base.multiply(K_porcentaje_a_invertir, mathContext);
            cantidad_base = divide_0(cantidad_base, BigDecimal.ONE.add(ratio_subida), ok, mathContext);
            if (ok.es == false) { return null; }
            mapa_retorno = new HashMap<>();
            pareja_simbolos = (String) datos_mapa.get(k_pareja_simbolos);
            pareja_simbolos = pareja_simbolos.toUpperCase();
            ref_BigDecimal.set(cotizacion_base_subida);
            orden_venta_subida = vender_stop_limit_subida_en_margen(pareja_simbolos,
                    cantidad_base,
                    ref_BigDecimal, ok);
            ok.no_nul(orden_venta_subida);
            if (ok.es == false) {
                ok.setTxt(tr.in(in, "Error al poner orden de venta de subida límite. "), ok.getTxt());
            }
            if (ok.es == false) { return null; }
            cotizacion_base_subida = ref_BigDecimal.get();
            mapa_retorno.put(k_orden_venta_subida_cantidad, cantidad_base);
            mapa_retorno.put(k_orden_venta_subida_cotizacion, cotizacion_base_subida);
            ref_BigDecimal.set(cotizacion_base_bajada);
            orden_compra_bajada = comprar_stop_limit_bajada_en_margen(pareja_simbolos,
                    cantidad_base,
                    ref_BigDecimal, ok);
            ok.no_nul(orden_compra_bajada);
            if (ok.es == false) {
                ok.setTxt(tr.in(in, "Error al poner orden de compra de bajada límite. "), ok.getTxt());
            }
            if (ok.es == false) { return null; }
            cotizacion_base_bajada = ref_BigDecimal.get();
            mapa_retorno.put(k_orden_compra_bajada_cantidad, cantidad_base);
            mapa_retorno.put(k_orden_compra_bajada_cotizacion, cotizacion_base_bajada);
            if (prestamo_contra_borrowResponse != null) {
                borrowQueryResponse_contra = consultar_prestamo(prestamo_contra_borrowResponse, ok);
                if (ok.es == false) { return null; }
                mapa_retorno.put(k_prestamo_obtenido_contra, borrowQueryResponse_contra.getFilled());
                if (borrowQueryResponse_contra.getFilled().compareTo(borrowQueryResponse_contra.getSize()) < 0) {
                    ok_local.setTxt(ok_local.getTxt(), tr.in(in, "La cantidad de contraprestación pedida prestada es mayor que la cantidad prestada. "));
                }
                if (ok.es == false) { return null; }
                cantidad_contra_prestada = borrowQueryResponse_contra.getFilled();
                cantidad_contra_prestada = cantidad_contra_prestada.multiply(cotizacion_contra, mathContext);
                cantidad_contra_prestada = divide_0(cantidad_contra_prestada, cotizacion_base, ok, mathContext.getPrecision(), mathContext.getRoundingMode());
                cantidad_contra_prestada = cantidad_contra_prestada.multiply(K_porcentaje_a_invertir, mathContext);
                if (cantidad_contra_prestada.compareTo(cantidad_base) > 0) {
                    cantidad_contra_prestada = cantidad_base;
                }
            } else {
                cantidad_contra_prestada = cantidad_base;
            }
            ref_BigDecimal.set(cotizacion_base_subida_mitad);
            orden_compra_subida_mitad = comprar_stop_limit_subida_en_margen(pareja_simbolos,
                    cantidad_contra_prestada,
                    ref_BigDecimal, ok);
            ok.no_nul(orden_compra_subida_mitad);
            if (ok.es == false) {
                ok.setTxt(tr.in(in, "Error al poner orden de venta de mitad de subida. "), ok.getTxt());
            }
            if (ok.es == false) { return null; }
            cotizacion_base_subida_mitad = ref_BigDecimal.get();
            mapa_retorno.put(k_orden_compra_subida_mitad_cantidad, cantidad_contra_prestada);
            mapa_retorno.put(k_orden_compra_subida_mitad_cotizacion, cotizacion_base_subida_mitad);
            if (prestamo_base_borrowResponse != null) {
                borrowQueryResponse_base = consultar_prestamo(prestamo_base_borrowResponse, ok);
                mapa_retorno.put(k_prestamo_obtenido_base, borrowQueryResponse_base.getFilled());
                if (borrowQueryResponse_base.getFilled().compareTo(borrowQueryResponse_base.getSize()) < 0) {
                    ok_local.setTxt(ok_local.getTxt(), tr.in(in, "La cantidad base pedida prestada es mayor que la cantidad prestada. "));
                }
                if (ok.es == false) { return null; }
                cantidad_base_prestada = borrowQueryResponse_base.getFilled();
                cantidad_base_prestada = cantidad_base_prestada.multiply(K_porcentaje_a_invertir, mathContext);
                if (cantidad_base_prestada.compareTo(cantidad_base) > 0) {
                    cantidad_base_prestada = cantidad_base;
                }
            } else {
                cantidad_base_prestada = cantidad_base;
            }
            ref_BigDecimal.set(cotizacion_base_bajada_mitad);
            orden_venta_bajada_mitad = vender_stop_limit_bajada_en_margen(pareja_simbolos,
                    cantidad_base_prestada, 
                    ref_BigDecimal, ok);
            ok.no_nul(orden_venta_bajada_mitad);
            if (ok.es == false) {
                ok.setTxt(tr.in(in, "Error al poner orden de compra de mitad de bajada. "), ok.getTxt());
            }
            if (ok.es == false) { return null; }
            cotizacion_base_bajada_mitad = ref_BigDecimal.get();
            mapa_retorno.put(k_orden_venta_bajada_mitad_cantidad, cantidad_base_prestada);
            mapa_retorno.put(k_orden_venta_bajada_mitad_cotizacion, cotizacion_base_bajada_mitad);
            identificador = identificador + pareja_simbolos + ", ";
            if (prestamo_base_borrowResponse != null) {
                identificador = identificador + prestamo_base_borrowResponse.getOrderId() + ", ";
            } else {
                identificador = identificador + "" + ", ";
            }
            if (prestamo_contra_borrowResponse != null) {
                identificador = identificador + prestamo_contra_borrowResponse.getOrderId() + ", ";
            } else {
                identificador = identificador + "" + ", ";
            }
            identificador = identificador
                    + k_ovs + ", " + orden_venta_subida.getOrderId() + ", "
                    + k_ocb + ", " + orden_compra_bajada.getOrderId() + ", "
                    + k_ovbm + ", " + orden_venta_bajada_mitad.getOrderId() + ", "
                    + k_ocsm + ", " + orden_compra_subida_mitad.getOrderId();
            mapa_retorno.put(k_ejecutar_estrategia_l_s_1_margen_2_identificador, identificador);        
            mapa_retorno.put(k_ejecutar_estrategia_l_s_1_margen_2_incidencias, ok_local.getTxt());        
            return mapa_retorno;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Pedir un préstamo a devolver en 7 días (se renueva automáticamente si no se puede cobrar)
     * @param simbolo Moneda que pedir prestada
     * @param ref_cantidad de moneda que pedir prestada. 
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return Información del resultado del préstamo
     * @throws Exception Opción de notificar errores de excepción
     */
    public BorrowResponse pedir_prestamo_7_dias(String simbolo, ref<BigDecimal> ref_cantidad, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            BorrowRequest borrowRequest = null;
            BorrowResponse borrow = null;
            BigDecimal cantidad_sumada = null;
            BigDecimal interes_diario_mas_bajo = BigDecimal.ZERO;
            TreeMap<BigDecimal, MarketItemResponse> sortedmap;
            MarketItemResponse marketItemResponse;
            sortedmap = obtener_ratios_mercado_de_prestamos_7_dias(simbolo, ok);
            if (ok.es == false) { return null; }
            interes_diario_mas_bajo = sortedmap.firstKey();
            marketItemResponse = sortedmap.get(interes_diario_mas_bajo);
            cantidad_sumada = marketItemResponse.getSize();
            while (true) {
                if (cantidad_sumada.compareTo(ref_cantidad.get()) > 0) {
                    break;
                }
                interes_diario_mas_bajo = sortedmap.lowerKey(interes_diario_mas_bajo);
                marketItemResponse = sortedmap.get(interes_diario_mas_bajo);
                cantidad_sumada = cantidad_sumada.add(marketItemResponse.getSize());
            }
            while (true) {
                try {
                    borrowRequest = BorrowRequest.builder()
                            .currency(simbolo)
                            .type("FOK")
                            .size(ref_cantidad.get())
                            .maxRate(interes_diario_mas_bajo)
                            .term(String.valueOf(k_7_dias))
                    .build();
                    borrow = _kucoinRestClient.loanAPI().borrow(borrowRequest);
                    break;
                } catch (KucoinApiException e) {
                    if (e.getCode().equals("400100")) {
                        if (e.getMessage().contains("increment")
                          || e.getMessage().contains("precision")
                          || e.getMessage().contains("must")) {
                            if ((ref_cantidad.get()).compareTo(BigDecimal.ZERO) <= 0) {
                                break;
                            }
                            ref_cantidad.set(BigDecimals.quitar_decimales(ref_cantidad.get(), 1, ok));
                        } else {
                            ok.setTxt("Error de excepción. ", e);
                            break;
                        }
                    } else {
                        ok.setTxt("Error de excepción. ", e);
                        break;
                    }
                }
            }
            return borrow;
        } catch (Exception e) {
            throw e;
        }
    }    
    /**
     * Consultar un préstamo
     * @param borrowResponse datos del préstamo
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return Información del resultado del préstamo
     * @throws Exception Opción de notificar errores de excepción
     */
    public BorrowQueryResponse consultar_prestamo(BorrowResponse borrowResponse, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            BorrowQueryResponse borrowQuery = _kucoinRestClient.loanAPI().queryBorrow(borrowResponse.getOrderId());
            return borrowQuery;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Comprar en el mercado de margen con stop limit cuando suba
     * @param par_base_contra Par de intercambio
     * @param cantidad_base Cantidad base que comprar
     * @param ref_cotizacion_base a que cotizacion_base vender
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return Información del resultado de la orden de venta.
     * @throws Exception Opción de notificar errores de excepción
     */
    public OrderCreateResponse comprar_stop_limit_subida_en_margen(String par_base_contra, BigDecimal cantidad_base, ref<BigDecimal> ref_cotizacion_base, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            return operar_stop_limit_en_margen("buy", "entry", par_base_contra, cantidad_base, ref_cotizacion_base, ok, extra_array);
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Comprar en el mercado de margen con stop limit cuando suba
     * @param par_base_contra Par de intercambio
     * @param cantidad_base quecotizacion_basevender
     * @param ref_cotizacion_base al que se hace la operación
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return Información del resultado de la orden de venta.
     * @throws Exception Opción de notificar errores de excepción
     */
    public OrderCreateResponse vender_stop_limit_subida_en_margen(String par_base_contra, BigDecimal cantidad_base, ref<BigDecimal> ref_cotizacion_base, oks ok, Object ... extra_array) throws Exception {
        try {
            return operar_stop_limit_en_margen("sell", "entry", par_base_contra, cantidad_base, ref_cotizacion_base, ok, extra_array);
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Comprar en el mercado de margen con stop limit cuando baje
     * @param par_base_contra Par de intercambio
     * @param cantidad_base quecotizacion_basevender
     * @param ref_cotizacion_base al que se hace la operación
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return Información del resultado de la orden de venta.
     * @throws Exception Opción de notificar errores de excepción
     */
    public OrderCreateResponse comprar_stop_limit_bajada_en_margen(String par_base_contra, BigDecimal cantidad_base, ref<BigDecimal> ref_cotizacion_base, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            return operar_stop_limit_en_margen("buy", "loss", par_base_contra, cantidad_base, ref_cotizacion_base, ok, extra_array);
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Comprar en el mercado de margen con stop limit cuando baje
     * @param par_base_contra Par de intercambio
     * @param cantidad_base quecotizacion_basevender
     * @param ref_cotizacion_base al que se hace la operación
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return Información del resultado de la orden de venta.
     * @throws Exception Opción de notificar errores de excepción
     */
    public OrderCreateResponse vender_stop_limit_bajada_en_margen(String par_base_contra, BigDecimal cantidad_base, ref<BigDecimal> ref_cotizacion_base, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            return operar_stop_limit_en_margen("sell", "loss", par_base_contra, cantidad_base, ref_cotizacion_base, ok, extra_array);
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Operar en el mercado de margen
     * @param operacion operación que realizar: sell o buy
     * @param entry_loss "entry" stop en subida, "loss" stop en bajada.
     * @param par_base_contra Par de intercambio
     * @param cantidad_base quecotizacion_basevender
     * @param ref_cotizacion_base al que se hace la operación
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return Información del resultado de la orden de venta.
     * @throws Exception Opción de notificar errores de excepción
     */
    public OrderCreateResponse operar_stop_limit_en_margen(String operacion, String entry_loss, String par_base_contra, BigDecimal cantidad_base, ref<BigDecimal> ref_cotizacion_base, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            StopOrderCreateRequest request = null;
            OrderCreateResponse stopOrder = null;
            while (true) {
                try {
                    request = StopOrderCreateRequest.builder()
                            .price(ref_cotizacion_base.get())
                            .size(cantidad_base)
                            .side(operacion)
                            .stop(entry_loss)
                            .stopPrice(ref_cotizacion_base.get())
                            .symbol(par_base_contra)
                            .tradeType("MARGIN_TRADE")
                            .type("limit")
                            .clientOid(UUID.randomUUID().toString())
                            .build();
                    stopOrder = _kucoinRestClient.stopOrderAPI()
                            .createStopOrder(request);
                    break;
                } catch (KucoinApiException e) {
                    if (e.getCode().equals("400100")) {
                        if (e.getMessage().contains("increment")
                          || e.getMessage().contains("precision")
                          || e.getMessage().contains("must")) {
                            if ((ref_cotizacion_base.get()).compareTo(BigDecimal.ZERO) <= 0) {
                                break;
                            }
                            ref_cotizacion_base.set(BigDecimals.quitar_decimales(ref_cotizacion_base.get(), 1, ok));
                        } else {
                            ok.setTxt("Error de excepción. ", e);
                            break;
                        }
                    } else {
                        ok.setTxt("Error de excepción. ", e);
                       break;
                    }
                }
            }
            return stopOrder;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Consultar Stop Order
     * @param orderCreateResponse orden que comprobar.
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return Información del resultado de la orden de venta.
     * @throws Exception Opción de notificar errores de excepción
     */
    public StopOrderResponse consultar_stop_limit_orden(OrderCreateResponse orderCreateResponse, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            StopOrderResponse stopOrderResponse; 
            stopOrderResponse = _kucoinRestClient.stopOrderAPI().getStopOrder(orderCreateResponse.getOrderId());
            return stopOrderResponse;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Comprar en el mercado de margen con préstamo
     * @param par_base_contra Par de intercambio
     * @param cantidad_base quecotizacion_basevender
     * @param ref_cotizacion_base al que se hace la operación
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return Información del resultado de la orden de venta.
     * @throws Exception Opción de notificar errores de excepción
     */
    public MarginOrderCreateResponse comprar_en_margen(String par_base_contra, BigDecimal cantidad_base, ref<BigDecimal> ref_cotizacion_base, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            return operar_en_margen("buy", par_base_contra, cantidad_base, ref_cotizacion_base, ok, extra_array);
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Vender en el mercado de margen con préstamo
     * @param par_base_contra Par de intercambio
     * @param cantidad_base quecotizacion_basevender
     * @param ref_cotizacion_base al que se hace la operación
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return Información del resultado de la orden de venta.
     * @throws Exception Opción de notificar errores de excepción
     */
    public MarginOrderCreateResponse vender_en_margen(String par_base_contra, BigDecimal cantidad_base, ref<BigDecimal> ref_cotizacion_base, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            return operar_en_margen("sell", par_base_contra, cantidad_base, ref_cotizacion_base, ok, extra_array);
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Operar en el mercado de margen con préstamo
     * @param operacion "sell" o "buy"
     * @param par_base_contra Par de intercambio
     * @param cantidad_base quecotizacion_basevender
     * @param ref_cotizacion_base al que se hace la operación
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return Información del resultado de la orden de venta.
     * @throws Exception Opción de notificar errores de excepción
     */
    public MarginOrderCreateResponse operar_en_margen(String operacion, String par_base_contra, BigDecimal cantidad_base, ref<BigDecimal> ref_cotizacion_base, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            MarginOrderCreateRequest request = null;
            MarginOrderCreateResponse marginOrderResponse = null;
            while (true) {
                try {
                    request = MarginOrderCreateRequest.builder()
                            .price(ref_cotizacion_base.get())
                            .size(cantidad_base)
                            .side(operacion)
                            .symbol(par_base_contra)
                            .type("limit")
                            .clientOid(UUID.randomUUID().toString())
                            .marginMode("cross")
                            .build();
                    marginOrderResponse = _kucoinRestClient.marginAPI().createMarginOrder(request);
                    break;
                } catch (KucoinApiException e) {
                    if (e.getCode().equals("400100")) {
                        if (e.getMessage().contains("increment")
                          || e.getMessage().contains("precision")
                          || e.getMessage().contains("must")) {
                            if ((ref_cotizacion_base.get()).compareTo(BigDecimal.ZERO) <= 0) {
                                break;
                            }
                            ref_cotizacion_base.set(BigDecimals.quitar_decimales(ref_cotizacion_base.get(), 1, ok));
                        } else {
                            ok.setTxt("Error de excepción. ", e);
                            break;
                        }
                    } else {
                        ok.setTxt("Error de excepción. ", e);
                        break;
                    }
                }
            }
            return marginOrderResponse;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Consulta la cuenta de margen.
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return Información de la consulta.
     * @throws Exception Opción de notificar errores de excepción
     */
    public MarginAccountResponse consultar_cuenta_margen(oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            MarginAccountResponse marginAccount = _kucoinRestClient.marginAPI().getMarginAccount();
            return marginAccount;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Comprueva el estado de un identificador de estrategia L-S-1
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return un mapa con los datos resultantes.
     * @throws Exception Opción de notificar errores de excepción
     */
    public Map<String, Object> comprobar_estrategia_l_s_1_margen(Map<String, Object> datos_mapa, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            Map<String, Object> resultados_mapa = new HashMap<>();
            Map<String, Object> mapa = null;
            ResourceBundle in = null;
            String pareja_simbolos = null;
            String prestamo_base_id = null;
            String prestamo_contra_id = null;
            String orden_venta_subida_id = null;
            String orden_compra_bajada_id = null;
            String orden_compra_subida_mitad_id = null;
            String orden_venta_bajada_mitad_id = null;
            BigDecimal prestamo_base_cantidad = null;
            BigDecimal prestamo_contra_cantidad = null;
            BigDecimal orden_venta_subida_cantidad = null;
            BigDecimal orden_compra_bajada_cantidad = null;
            BigDecimal orden_compra_subida_mitad_cantidad = null;
            BigDecimal orden_venta_bajada_mitad_cantidad = null;
            BigDecimal orden_venta_subida_origen_importe = null;
            BigDecimal orden_compra_bajada_origen_importe = null;
            BigDecimal orden_compra_subida_mitad_origen_importe = null;
            BigDecimal orden_venta_bajada_mitad_origen_importe = null;
            BigDecimal subida_resultado = null;
            BigDecimal bajada_resultado = null;
            BigDecimal bigDecimal = null;
            boolean es_subida_terminada = true;
            boolean es_bajada_terminada = true;
            MathContext mathContext = new MathContext(5, RoundingMode.HALF_EVEN);
            in = ResourceBundles.getBundle(k_in_ruta);
            String identificador;
            String [] identificador_array = null;
            identificador = (String) datos_mapa.get(k_ejecutar_estrategia_l_s_1_margen_2_identificador);
            ok.no_nul(identificador);
            if (ok.es == false) { return null; }
            identificador_array = identificador.split(", ");
            pareja_simbolos = identificador_array[0].trim();
            prestamo_base_id = identificador_array[1].trim();
            prestamo_contra_id = identificador_array[2].trim();
            mapa = consultar_prestamos_base_contra(prestamo_base_id, prestamo_contra_id, ok);
            if (ok.es == false) { return null; }
            resultados_mapa.putAll(mapa);
            prestamo_base_cantidad = (BigDecimal) mapa.get(k_consulta_prestamo_importe_base);
            prestamo_base_cantidad = BigDecimals.nulo_es_0(prestamo_base_cantidad);
            prestamo_contra_cantidad = (BigDecimal) mapa.get(k_consulta_prestamo_importe_contra);
            prestamo_contra_cantidad = BigDecimals.nulo_es_0(prestamo_contra_cantidad);
            ok.es = k_ovs.equals(identificador_array[3].trim());
            if (ok.es == false) { return null; }
            orden_venta_subida_id = identificador_array[4].trim();
            mapa = consultar_orden_stop_limit(orden_venta_subida_id, ok);
            if (ok.es == false) { return null; }
            orden_venta_subida_origen_importe = (BigDecimal) mapa.get(k_consultar_orden_origen_resultado);
            orden_venta_subida_origen_importe = BigDecimals.nulo_es_0(orden_venta_subida_origen_importe);
            orden_venta_subida_cantidad = (BigDecimal) mapa.get(k_consultar_orden_resultado);
            orden_venta_subida_cantidad = BigDecimals.nulo_es_0(orden_venta_subida_cantidad);
            bigDecimal = (BigDecimal) mapa.get(k_consultar_orden_pendiente);
            es_subida_terminada = bigDecimal != null && bigDecimal.compareTo(BigDecimal.ZERO) <= 0;
            resultados_mapa.put(k_ovs, mapa);
            ok.es = k_ocb.equals(identificador_array[5].trim()); 
            if (ok.es == false) { return null; }
            orden_compra_bajada_id = identificador_array[6].trim();
            mapa = consultar_orden_stop_limit(orden_compra_bajada_id, ok);
            if (ok.es == false) { return null; }
            orden_compra_bajada_origen_importe = (BigDecimal) mapa.get(k_consultar_orden_origen_resultado);
            orden_compra_bajada_origen_importe = BigDecimals.nulo_es_0(orden_compra_bajada_origen_importe);
            orden_compra_bajada_cantidad = (BigDecimal) mapa.get(k_consultar_orden_resultado);
            orden_compra_bajada_cantidad = BigDecimals.nulo_es_0(orden_compra_bajada_cantidad);
            bigDecimal = (BigDecimal) mapa.get(k_consultar_orden_pendiente);
            es_bajada_terminada = bigDecimal != null && bigDecimal.compareTo(BigDecimal.ZERO) <= 0;
            resultados_mapa.put(k_ocb, mapa);
            ok.es = k_ovbm.equals(identificador_array[7].trim());
            if (ok.es == false) { return null; }
            orden_venta_bajada_mitad_id = identificador_array[8].trim();
            mapa = consultar_orden_stop_limit(orden_venta_bajada_mitad_id, ok);
            if (ok.es == false) { return null; }
            orden_venta_bajada_mitad_origen_importe = (BigDecimal) mapa.get(k_consultar_orden_origen_resultado);
            orden_venta_bajada_mitad_origen_importe = BigDecimals.nulo_es_0(orden_venta_bajada_mitad_origen_importe);
            orden_venta_bajada_mitad_cantidad = (BigDecimal) mapa.get(k_consultar_orden_resultado);
            orden_venta_bajada_mitad_cantidad = BigDecimals.nulo_es_0(orden_venta_bajada_mitad_cantidad);
            bigDecimal = (BigDecimal) mapa.get(k_consultar_orden_pendiente);
            es_bajada_terminada = es_bajada_terminada && bigDecimal != null && bigDecimal.compareTo(BigDecimal.ZERO) <= 0;
            resultados_mapa.put(k_ovbm, mapa);
            ok.es = k_ocsm.equals(identificador_array[9].trim());
            if (ok.es == false) { return null; }
            orden_compra_subida_mitad_id = identificador_array[10].trim();
            mapa = consultar_orden_stop_limit(orden_compra_subida_mitad_id, ok);
            if (ok.es == false) { return null; }
            orden_compra_subida_mitad_origen_importe = (BigDecimal) mapa.get(k_consultar_orden_origen_resultado);
            orden_compra_subida_mitad_origen_importe = BigDecimals.nulo_es_0(orden_compra_subida_mitad_origen_importe);
            orden_compra_subida_mitad_cantidad = (BigDecimal) mapa.get(k_consultar_orden_resultado);
            orden_compra_subida_mitad_cantidad = BigDecimals.nulo_es_0(orden_compra_subida_mitad_cantidad);
            bigDecimal = (BigDecimal) mapa.get(k_consultar_orden_pendiente);
            es_subida_terminada = es_subida_terminada && bigDecimal != null && bigDecimal.compareTo(BigDecimal.ZERO) <= 0;
            resultados_mapa.put(k_ocsm, mapa);
            subida_resultado = nulo_es_0(orden_venta_subida_cantidad)
                    .subtract(nulo_es_0(orden_compra_subida_mitad_origen_importe), mathContext);
            resultados_mapa.put(k_comprobar_estrategia_l_s_1_resultado_subida, subida_resultado);
            bajada_resultado = nulo_es_0(orden_venta_bajada_mitad_cantidad)
                    .subtract(nulo_es_0(orden_compra_bajada_origen_importe), mathContext);
            resultados_mapa.put(k_comprobar_estrategia_l_s_1_resultado_bajada, bajada_resultado);
            resultados_mapa.put(k_comprobar_estrategia_l_s_1_es_bajada_terminada, es_bajada_terminada);
            resultados_mapa.put(k_comprobar_estrategia_l_s_1_es_subida_terminada, es_subida_terminada);
            return resultados_mapa;
        } catch (Exception e) {
            throw e;
        }
    }
    
    /**
     * Recupera datos de un préstamo en moneda base y otro en moneda de contrapartida.
     * @param id_base Identificador del préstamo en moneda base
     * @param id_contra Identificador del préstamo en moneda de contraprestación
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return Información de la consulta, o null si hay error.
     * @throws Exception Opción de notificar errores de excepción
     */
    public Map<String, Object> consultar_prestamos_base_contra(String id_base, String id_contra, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            Map<String, Object> retorno_mapa = new HashMap<>();
            MarginAccountResponse marginAccountResponse = null;
            BorrowQueryResponse borrowQueryResponse_base = null;
            BorrowQueryResponse borrowQueryResponse_contra = null;
            String simbolo_base = "";
            String simbolo_contra = "";
            BigDecimal importe_base = null;
            BigDecimal importe_contra = null;
            BigDecimal pendiente_repago_base = null;
            BigDecimal pendiente_repago_contra = null;
            if (id_base.isBlank() == false) {
                borrowQueryResponse_base = _kucoinRestClient.loanAPI().queryBorrow(id_base);
                ok.no_nul(borrowQueryResponse_base);
                if (ok.es == false) { return null; }
                simbolo_base = borrowQueryResponse_base.getCurrency();
                retorno_mapa.put(k_consulta_prestamo_simbolo_base, simbolo_base);
                importe_base = borrowQueryResponse_base.getFilled();
                retorno_mapa.put(k_consulta_prestamo_importe_base, importe_base);
            }
            if (id_contra.isBlank() == false) {
                borrowQueryResponse_contra = _kucoinRestClient.loanAPI().queryBorrow(id_contra);
                ok.no_nul(borrowQueryResponse_contra);
                if (ok.es == false) { return null; }
                simbolo_contra = borrowQueryResponse_contra.getCurrency();
                retorno_mapa.put(k_consulta_prestamo_simbolo_contra, simbolo_contra);
                importe_contra = borrowQueryResponse_contra.getFilled();
                retorno_mapa.put(k_consulta_prestamo_importe_contra, importe_contra);
            }
            marginAccountResponse = consultar_cuenta_margen(ok);
            ok.no_nul(marginAccountResponse);
            if (ok.es == false) { return null; }
            for (MarginAccount marginAccount :marginAccountResponse.getAccounts()) {
                if (marginAccount.getCurrency().equals(simbolo_base)) {
                    pendiente_repago_base = marginAccount.getLiability();
                    retorno_mapa.put(k_consulta_prestamo_pendiente_repago_base, pendiente_repago_base);
                } else if (marginAccount.getCurrency().equals(simbolo_contra)) {
                    pendiente_repago_contra = marginAccount.getLiability();
                    retorno_mapa.put(k_consulta_prestamo_pendiente_repago_contra, pendiente_repago_contra);
                }
            }
            return retorno_mapa;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Recupera datos de una orden stop limit.
     * @param id Identificador de la orden.
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return Información de la consulta, o null si hay error.
     * @throws Exception Opción de notificar errores de excepción
     */
    public Map<String, Object> consultar_orden_stop_limit(String id, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            Map<String, Object> retorno_mapa = new HashMap<>();
            BigDecimal importe_ejecutado = null;
            BigDecimal cantidad_ejecutado = null;
            BigDecimal precio_en_operacion = null;
            BigDecimal cantidad_en_operacion = null;
            BigDecimal importe_en_operacion = null;
            MathContext mathContext;
            mathContext = new MathContext(5, RoundingMode.HALF_UP);
            StopOrderResponse stopOrderResponse = _kucoinRestClient.stopOrderAPI().getStopOrder(id);
            ok.no_nul(stopOrderResponse);
            if (ok.es) {
                Date date = stopOrderResponse.getStopTriggerTime();
                if (date != null) {
                    importe_ejecutado = stopOrderResponse.getFunds();
                    cantidad_ejecutado = stopOrderResponse.getSize();
                    precio_en_operacion = stopOrderResponse.getPrice();
                    cantidad_en_operacion = stopOrderResponse.getSize();
                    importe_en_operacion = cantidad_en_operacion.multiply(precio_en_operacion, mathContext);
                    retorno_mapa.put(k_consultar_orden_stop_fecha_inicio, date);
                    if (stopOrderResponse.getSide().toLowerCase().equals("buy")) {
                        retorno_mapa.put(k_consultar_orden_origen_resultado, importe_ejecutado);
                        retorno_mapa.put(k_consultar_orden_resultado, cantidad_ejecutado);
                        retorno_mapa.put(k_consultar_orden_pendiente
                                , cantidad_en_operacion.subtract(cantidad_ejecutado));
                    } else {
                        retorno_mapa.put(k_consultar_orden_origen_resultado, cantidad_ejecutado);
                        retorno_mapa.put(k_consultar_orden_resultado, importe_ejecutado);
                        retorno_mapa.put(k_consultar_orden_pendiente
                                , importe_en_operacion.subtract(importe_ejecutado));
                    }
                } 
            } else {
                ok.es = true;
                retorno_mapa = consultar_orden(id, ok);
            }
            return retorno_mapa;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Recupera datos de una orden
     * @param id Identificador de la orden.
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return Información de la consulta, o null si hay error.
     * @throws Exception Opción de notificar errores de excepción
     */
    public Map<String, Object> consultar_orden(String id, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            Map<String, Object> retorno_mapa = new HashMap<>();
            BigDecimal importe_ejecutado = null;
            BigDecimal cantidad_ejecutado = null;
            BigDecimal precio_en_operacion = null;
            BigDecimal cantidad_en_operacion = null;
            BigDecimal importe_en_operacion = null;
            MathContext mathContext;
            mathContext = new MathContext(5, RoundingMode.HALF_UP);
            OrderResponse orderResponse = _kucoinRestClient.orderAPI().getOrder(id);
            ok.no_nul(orderResponse);
            if (ok.es == false) { return null; }
            String tipo = orderResponse.getOpType();
            if (tipo.toLowerCase().equals("deal")) {
                importe_ejecutado = orderResponse.getDealFunds();
                cantidad_ejecutado = orderResponse.getDealSize();
                precio_en_operacion = orderResponse.getPrice();
                cantidad_en_operacion = orderResponse.getSize();
                importe_en_operacion = cantidad_en_operacion.multiply(precio_en_operacion, mathContext);
                retorno_mapa.put(k_consultar_orden_es_trato, true);
                if (orderResponse.getSide().toLowerCase().equals("buy")) {
                    retorno_mapa.put(k_consultar_orden_origen_resultado, importe_ejecutado);
                    retorno_mapa.put(k_consultar_orden_resultado, cantidad_ejecutado);
                    retorno_mapa.put(k_consultar_orden_pendiente
                            , cantidad_en_operacion.subtract(cantidad_ejecutado));
                } else {
                    retorno_mapa.put(k_consultar_orden_origen_resultado, cantidad_ejecutado);
                    retorno_mapa.put(k_consultar_orden_resultado, importe_ejecutado);
                    retorno_mapa.put(k_consultar_orden_pendiente
                            , importe_en_operacion.subtract(importe_ejecutado));
                }
            } else {
                importe_ejecutado = orderResponse.getFunds();
                cantidad_ejecutado = orderResponse.getSize();
                precio_en_operacion = orderResponse.getPrice();
                cantidad_en_operacion = orderResponse.getSize();
                importe_en_operacion = cantidad_en_operacion.multiply(precio_en_operacion, mathContext);
                retorno_mapa.put(k_consultar_orden_es_trato, true);
                if (orderResponse.getSide().toLowerCase().equals("buy")) {
                    retorno_mapa.put(k_consultar_orden_origen_resultado, importe_ejecutado);
                    retorno_mapa.put(k_consultar_orden_resultado, cantidad_ejecutado);
                    retorno_mapa.put(k_consultar_orden_pendiente
                            , cantidad_en_operacion.subtract(cantidad_ejecutado));
                } else {
                    retorno_mapa.put(k_consultar_orden_origen_resultado, cantidad_ejecutado);
                    retorno_mapa.put(k_consultar_orden_resultado, importe_ejecutado);
                    retorno_mapa.put(k_consultar_orden_pendiente
                            , importe_en_operacion.subtract(importe_ejecutado));
                }
            }
            return retorno_mapa;
        } catch (Exception e) {
            throw e;
        }
    }
    
}

