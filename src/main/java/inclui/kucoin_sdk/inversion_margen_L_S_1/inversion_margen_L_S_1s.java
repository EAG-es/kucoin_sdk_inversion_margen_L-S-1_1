/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inclui.kucoin_sdk.inversion_margen_L_S_1;

import static innui.utiles.bigdecimals.BigDecimals.nulo_es_0;
import innui.bases;
import innui.kucoin_sdk.kucoin_sdks;
import static innui.kucoin_sdk.kucoin_sdks.k_cantidad_base;
import static innui.kucoin_sdk.kucoin_sdks.k_cantidad_contra;
import static innui.kucoin_sdk.kucoin_sdks.k_comprobar_estrategia_l_s_1_es_bajada_terminada;
import static innui.kucoin_sdk.kucoin_sdks.k_comprobar_estrategia_l_s_1_es_subida_terminada;
import static innui.kucoin_sdk.kucoin_sdks.k_consulta_prestamo_importe_base;
import static innui.kucoin_sdk.kucoin_sdks.k_consulta_prestamo_importe_contra;
import static innui.kucoin_sdk.kucoin_sdks.k_consulta_prestamo_pendiente_repago_base;
import static innui.kucoin_sdk.kucoin_sdks.k_consulta_prestamo_pendiente_repago_contra;
import static innui.kucoin_sdk.kucoin_sdks.k_consulta_prestamo_simbolo_base;
import static innui.kucoin_sdk.kucoin_sdks.k_consulta_prestamo_simbolo_contra;
import static innui.kucoin_sdk.kucoin_sdks.k_consultar_orden_origen_resultado;
import static innui.kucoin_sdk.kucoin_sdks.k_consultar_orden_pendiente;
import static innui.kucoin_sdk.kucoin_sdks.k_consultar_orden_resultado;
import static innui.kucoin_sdk.kucoin_sdks.k_cotizacion_base;
import static innui.kucoin_sdk.kucoin_sdks.k_cotizacion_contra;
import static innui.kucoin_sdk.kucoin_sdks.k_ejecutar_estrategia_l_s_1_margen_2_identificador;
import static innui.kucoin_sdk.kucoin_sdks.k_ejecutar_estrategia_l_s_1_margen_2_incidencias;
import static innui.kucoin_sdk.kucoin_sdks.k_importe_base;
import static innui.kucoin_sdk.kucoin_sdks.k_importe_contra;
import static innui.kucoin_sdk.kucoin_sdks.k_importe_maximo;
import static innui.kucoin_sdk.kucoin_sdks.k_importe_mitad_ratio;
import static innui.kucoin_sdk.kucoin_sdks.k_maximo_prestable_base;
import static innui.kucoin_sdk.kucoin_sdks.k_maximo_prestable_contra;
import static innui.kucoin_sdk.kucoin_sdks.k_maximo_ratio_endeudamiento_margen;
import static innui.kucoin_sdk.kucoin_sdks.k_ocb;
import static innui.kucoin_sdk.kucoin_sdks.k_ocsm;
import static innui.kucoin_sdk.kucoin_sdks.k_orden_compra_bajada_cantidad;
import static innui.kucoin_sdk.kucoin_sdks.k_orden_compra_bajada_cotizacion;
import static innui.kucoin_sdk.kucoin_sdks.k_orden_compra_subida_mitad_cantidad;
import static innui.kucoin_sdk.kucoin_sdks.k_orden_compra_subida_mitad_cotizacion;
import static innui.kucoin_sdk.kucoin_sdks.k_orden_venta_bajada_mitad_cantidad;
import static innui.kucoin_sdk.kucoin_sdks.k_orden_venta_bajada_mitad_cotizacion;
import static innui.kucoin_sdk.kucoin_sdks.k_orden_venta_subida_cantidad;
import static innui.kucoin_sdk.kucoin_sdks.k_orden_venta_subida_cotizacion;
import static innui.kucoin_sdk.kucoin_sdks.k_ovbm;
import static innui.kucoin_sdk.kucoin_sdks.k_ovs;
import static innui.kucoin_sdk.kucoin_sdks.k_pareja_simbolos;
import static innui.kucoin_sdk.kucoin_sdks.k_prestamo_obtenido_base;
import static innui.kucoin_sdk.kucoin_sdks.k_prestamo_obtenido_contra;
import static innui.kucoin_sdk.kucoin_sdks.k_ratio_deuda_inicial;
import static innui.kucoin_sdk.kucoin_sdks.k_ratio_subida;
import static innui.kucoin_sdk.kucoin_sdks.k_simbolo_base;
import static innui.kucoin_sdk.kucoin_sdks.k_simbolo_contra;
import static innui.kucoin_sdk.kucoin_sdks.k_total_balance_base;
import static innui.kucoin_sdk.kucoin_sdks.k_total_balance_contra;
import static innui.kucoin_sdk.kucoin_sdks.k_total_deudas_base;
import static innui.kucoin_sdk.kucoin_sdks.k_total_deudas_contra;
import innui.modelos.configuraciones.ResourceBundles;
import innui.modelos.configuraciones.iniciales;
import innui.modelos.errores.oks;
import innui.modelos.internacionalizacion.tr;
import static java.lang.System.exit;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import static innui.kucoin_sdk.kucoin_sdks.k_comprobar_estrategia_l_s_1_resultado_subida;
import static innui.kucoin_sdk.kucoin_sdks.k_comprobar_estrategia_l_s_1_resultado_bajada;
import static innui.kucoin_sdk.kucoin_sdks.k_margen;
import static innui.kucoin_sdk.kucoin_sdks.k_no_prestamo_si_hay;
import innui.utiles.bigdecimals.BigDecimals;
// Probar logger
//import innui.modelos.errores.Strings_max_Handler;
//import static innui.modelos.errores.Strings_max_Handler.extraer;

/**
 *
 * @author emilio
 */
public class inversion_margen_L_S_1s extends bases {
    public static String k_in_ruta = "in/in";  //NOI18N
    public kucoin_sdk_cluis kucoin_sdk;
    boolean modo_pruebas = false;

    /**
     * Pantalla principal
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return true si todo va bien
     * @throws Exception Opción de notificar errores de excepción
     */
    public boolean ver_pantalla_principal(oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return false; }
            String opcion = "";
            String linea;
            ResourceBundle in = null;
            in = ResourceBundles.getBundle(k_in_ruta);
            while (opcion.equals("0") == false) {
                if (ok.es == false) {
                    escribir_error(ok.getTxt(), ok);
                    ok.es = true;
                    escribir_linea(tr.in(in, "Fin de menú. "), ok);
                    break;
                }
                escribir_linea(tr.in(in, "Opciones: "), ok);
                escribir_linea("0- " +  tr.in(in, "Salir."), ok);
                escribir_linea("1- " +  tr.in(in, "Listar balances de cuentas. "), ok);
                escribir_linea("2- " +  tr.in(in, "Listar balances de cuenta de intercambio a vista. "), ok);
                escribir_linea("3- " +  tr.in(in, "Listar balances de cuenta de margen. "), ok);
                escribir_linea("4- " +  tr.in(in, "Listar simbolos. "), ok);
                escribir_linea("5- " +  tr.in(in, "Listar simbolos con BTC. "), ok);
                escribir_linea("6- " +  tr.in(in, "Listar simbolos con USDT. "), ok);
                escribir_linea("7- " +  tr.in(in, "Listar simbolos con USDC. "), ok);
                escribir_linea("8- " +  tr.in(in, "Listar simbolos con BTC en Margen. "), ok);
                escribir_linea("9- " +  tr.in(in, "Listar simbolos con USDT en Margen. "), ok);
                escribir_linea("a- " +  tr.in(in, "Listar simbolos con USDC en Margen. "), ok);
                escribir_linea("b- " +  tr.in(in, "Aplicar estrategia L-S-1 Margen. "), ok);
                escribir_linea("c- " +  tr.in(in, "Comprobar estrategia L-S-1 Margen. "), ok);
                linea = leer_linea(ok);
                if (ok.es == false) { continue; }
                opcion = ver_pantalla_principal_procesar_opciones(linea, ok);
            }
            return ok.es;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Lee una linea de la entrada estándar
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return true si todo va bien
     * @throws Exception Opción de notificar errores de excepción
     */
    public String leer_linea(oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            return inclui.utiles.clui_lecturas.leer_linea(ok, extra_array);
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Lee una linea de la entrada estándar
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return true si todo va bien
     * @throws Exception Opción de notificar errores de excepción
     */
    public BigDecimal leer_bigdecimal(oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return null; }
            return inclui.utiles.clui_lecturas.leer_bigdecimal(ok, extra_array);
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Procesa las opciones de la pantalla principal
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return true si todo va bien
     * @throws Exception Opción de notificar errores de excepción
     */
    public String ver_pantalla_principal_procesar_opciones(String texto, oks ok, Object ... extra_array) throws Exception {
        if (ok.es == false) { return null; }
        String opcion = "";
        ResourceBundle in = null;
        in = ResourceBundles.getBundle(k_in_ruta);
        try {
            opcion = texto.trim().toLowerCase();
            if (opcion.equals("0")) {
            } else if (opcion.equals("1")) {
                kucoin_sdk.listar_balances_de_cuentas(ok);
            } else if (opcion.equals("2")) {
                kucoin_sdk.listar_balances_de_cuenta_intercambio(ok);
            } else if (opcion.equals("3")) {
                kucoin_sdk.listar_balances_de_cuenta_margen(ok);
            } else if (opcion.equals("4")) {
                kucoin_sdk.listar_simbolos(ok);
            } else if (opcion.equals("5")) {
                kucoin_sdk.listar_simbolos("BTC", null, ok);
            } else if (opcion.equals("6")) {
                kucoin_sdk.listar_simbolos("USDT", null, ok);
            } else if (opcion.equals("7")) {
                kucoin_sdk.listar_simbolos("USDC", null, ok);
            } else if (opcion.equals("8")) {
                kucoin_sdk.listar_simbolos("BTC", k_margen, ok);
            } else if (opcion.equals("9")) {
                kucoin_sdk.listar_simbolos("USDT", k_margen, ok);
            } else if (opcion.equals("a")) {
                kucoin_sdk.listar_simbolos("USDC", k_margen, ok);
            } else if (opcion.equals("b")) {
                ver_pantalla_estrategia_l_s_1_margen(ok);
            } else if (opcion.equals("c")) {
                ver_pantalla_comprobar_estrategia_l_s_1_margen(ok);
            } else {
                ok.setTxt(tr.in(in, "Opción no válida. "));
                ok.es = true;
            }
        } catch (Exception e) {
            ok.setTxt(e.getMessage(), tr.in(in, "Excepción en pantalla_principal_procesar_opciones. "));
        }
        return opcion;
    }
    /**
     * Pantalla de estrategia_l_s_1_margen
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return true si todo va bien
     * @throws Exception Opción de notificar errores de excepción
     */
    public boolean ver_pantalla_estrategia_l_s_1_margen(oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return false; }
            int opcion = -1;
            String linea;
            ResourceBundle in = null;
            BigDecimal bigDecimal = null;
            Map<String, Object> datos_mapa = new HashMap<>();
            in = ResourceBundles.getBundle(k_in_ruta);
            while (opcion != 0) {
                if (ok.es == false) {
                    escribir_error(ok.getTxt(), ok);
                    ok.es = true;                    
                    escribir_linea(tr.in(in, "Fin de menú. "), ok);
                    break;
                }
                escribir_linea(tr.in(in, "Opciones: "), ok);
                escribir_linea("0- " +  tr.in(in, "Salir."), ok);
                escribir_linea(tr.in(in, "Escriba la pareja de símbolos del mercado de margen (- separador). "), ok);
                linea = leer_linea(ok);
                if (linea.equals("0")) {
                    break;
                }
                if (ok.es == false) { continue; }
                datos_mapa.put(k_pareja_simbolos, linea);
                escribir_linea(tr.in(in, "El importe máximo en dólares USA ($) que pedir prestado. "), ok);
                bigDecimal = leer_bigdecimal(ok);
                if (bigDecimal.intValue() == 0) {
                    break;
                }
                if (ok.es == false) { continue; }
                datos_mapa.put(k_importe_maximo, bigDecimal);
                opcion = ver_pantalla_estrategia_l_s_1_margen_1(datos_mapa, ok);
                if (ok.es == false) { continue; }
                while (true) {
                    if (ok.es == false) {
                        escribir_error(ok.getTxt(), ok);
                        ok.es = true;
                        escribir_linea(tr.in(in, "Fin de menú. "), ok);
                        break;
                    }
                    escribir_linea(tr.in(in, "¿Desea continuar? (0=No/1=Sí). "), ok);
                    if (ok.es == false) { continue; }
                    linea = leer_linea(ok);
                    if (ok.es == false) { continue; }
                    if (linea.equals("0")) {
                        break;
                    } else if (linea.equals("1")) {
                        break;
                    }
                }
                if (linea.equals("0")) {
                    break;
                }
                if (ok.es == false) { continue; }
                escribir_linea(tr.in(in, "% de subida del precio de 'moneda base'/'moneda contraprestación'. "), ok);
                bigDecimal = leer_bigdecimal(ok);
                if (bigDecimal.intValue() == 0) {
                    break;
                }
                if (ok.es == false) { continue; }
                escribir_linea(tr.in(in, "Procesando... "), ok);
                datos_mapa.put(k_ratio_subida, bigDecimal);
                ver_pantalla_estrategia_l_s_1_margen_2(datos_mapa, ok);
            }
            return ok.es;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Procesa la pantalla estrategia l_s_1 (1)
     * @param datos_mapa Datos que utilizar
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return true si todo va bien
     * @throws Exception Opción de notificar errores de excepción
     */
    public int ver_pantalla_estrategia_l_s_1_margen_1(Map<String, Object> datos_mapa, oks ok, Object ... extra_array) throws Exception {
        if (ok.es == false) { return 0; }
        int opcion = -1;
        ResourceBundle in = null;
        in = ResourceBundles.getBundle(k_in_ruta);
        String texto;
        String simbolo_base = null;
        String simbolo_contra = null;
        BigDecimal bigDecimal;
        oks ok_local = new oks();
        Map<String, Object> ejecutar_estrategia_mapa = null;
        try {
            texto = (String) datos_mapa.get(k_pareja_simbolos);
            if (kucoin_sdk.buscar_par(texto.toUpperCase(), k_margen, ok) == null) {
                ok_local.setTxt("No se encuentra el par. ", ok_local.getTxt());
            }
            bigDecimal = (BigDecimal) datos_mapa.get(k_importe_maximo);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            if (bigDecimal.intValue() <= 0) {
                ok_local.setTxt("Importe no válido. ", ok.getTxt());
            }
            if (ok_local.txt.isBlank() == false) {
                ok.setTxt(ok_local.getTxt());
            }
            if (ok.es == false) { return 0; }
            ejecutar_estrategia_mapa = kucoin_sdk.ejecutar_estrategia_l_s_1_margen_1(datos_mapa, ok);
            if (ok.es == false) { return 0; }
            datos_mapa.putAll(ejecutar_estrategia_mapa);
            texto = (String) ejecutar_estrategia_mapa.get(k_simbolo_base);
            simbolo_base = texto;
            ok.no_nul(texto);
            escribir_linea(k_simbolo_base + " = " + texto, ok);
            if (ok.es == false) { return 0; }
            texto = (String) ejecutar_estrategia_mapa.get(k_simbolo_contra);
            simbolo_contra = texto;
            ok.no_nul(texto);
            escribir_linea(k_simbolo_contra + " = " + texto, ok);
            if (ok.es == false) { return 0; }
            bigDecimal = (BigDecimal) ejecutar_estrategia_mapa.get(k_importe_base);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            escribir_linea(k_importe_base + " = " + bigDecimal.toPlainString() + " USD", ok);
            if (ok.es == false) { return 0; }
            bigDecimal = (BigDecimal) ejecutar_estrategia_mapa.get(k_importe_contra);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            escribir_linea(k_importe_contra + " = " + bigDecimal.toPlainString() + " USD", ok);
            if (ok.es == false) { return 0; }
            bigDecimal = (BigDecimal) ejecutar_estrategia_mapa.get(k_importe_mitad_ratio);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            escribir_linea(k_importe_mitad_ratio + " = " + bigDecimal.toPlainString() + " USD", ok);
            if (ok.es == false) { return 0; }
            bigDecimal = (BigDecimal) ejecutar_estrategia_mapa.get(k_cotizacion_base);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            escribir_linea(k_cotizacion_base + " = " + bigDecimal.toPlainString() + " USD", ok);
            if (ok.es == false) { return 0; }
            bigDecimal = (BigDecimal) ejecutar_estrategia_mapa.get(k_cotizacion_contra);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            escribir_linea(k_cotizacion_contra + " = " + bigDecimal.toPlainString() + " USD", ok);
            if (ok.es == false) { return 0; }
            bigDecimal = (BigDecimal) ejecutar_estrategia_mapa.get(k_cantidad_base);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            escribir_linea(k_cantidad_base + " = " + bigDecimal.toPlainString() + " " + simbolo_base, ok);
            if (ok.es == false) { return 0; }
            bigDecimal = (BigDecimal) ejecutar_estrategia_mapa.get(k_cantidad_contra);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            escribir_linea(k_cantidad_contra + " = " + bigDecimal.toPlainString() + " " + simbolo_contra, ok);
            if (ok.es == false) {
                ok.setTxt(ok.getTxt(), "Error en los datos de la fase 1. ");
            }
            if (ok.es == false) { return 0; }
            ok_local.es = kucoin_sdk.consultar_mercado_de_prestamos_7_dias(simbolo_base, ok).isEmpty() == false;
            if (ok_local.es == false) {
                ok_local.setTxt(ok_local.getTxt(), "No hay préstamos disponibles para la moneda base. ");
                ok_local.es = true;
            }
            if (ok.es == false) { return 0; }
            ok_local.es = kucoin_sdk.consultar_mercado_de_prestamos_7_dias(simbolo_contra, ok).isEmpty() == false;
            if (ok_local.es == false) {
                ok_local.setTxt(ok_local.getTxt(), "No hay préstamos disponibles para la moneda de contraprestación. ");
                ok_local.es = true;
            }
            if (ok.es == false) { return 0; }
            bigDecimal = (BigDecimal) ejecutar_estrategia_mapa.get(k_maximo_ratio_endeudamiento_margen);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            escribir_linea(k_maximo_ratio_endeudamiento_margen + " = " + bigDecimal.toPlainString() + " (> 0, < 1) ", ok);
            if (ok.es == false) { return 0; }
            bigDecimal = (BigDecimal) ejecutar_estrategia_mapa.get(k_ratio_deuda_inicial);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            escribir_linea(k_ratio_deuda_inicial + " = " + bigDecimal.toPlainString() + " (> 0, < 1) ", ok);
            if (ok.es == false) { return 0; }
            bigDecimal = (BigDecimal) ejecutar_estrategia_mapa.get(k_maximo_prestable_base);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            escribir_linea(k_maximo_prestable_base + " = " + bigDecimal.toPlainString() + " " + simbolo_base, ok);
            if (ok.es == false) { return 0; }
            bigDecimal = (BigDecimal) ejecutar_estrategia_mapa.get(k_total_deudas_base);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            escribir_linea(k_total_deudas_base + " = " + bigDecimal.toPlainString() + " " + simbolo_base, ok);
            if (ok.es == false) { return 0; }
            bigDecimal = (BigDecimal) ejecutar_estrategia_mapa.get(k_total_balance_base);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            escribir_linea(k_total_balance_base + " = " + bigDecimal.toPlainString() + " " + simbolo_base, ok);
            if (ok.es == false) { return 0; }
            bigDecimal = (BigDecimal) ejecutar_estrategia_mapa.get(k_maximo_prestable_contra);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            escribir_linea(k_maximo_prestable_contra + " = " + bigDecimal.toPlainString() + " " + simbolo_contra, ok);
            if (ok.es == false) { return 0; }
            bigDecimal = (BigDecimal) ejecutar_estrategia_mapa.get(k_total_deudas_contra);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            escribir_linea(k_total_deudas_contra + " = " + bigDecimal.toPlainString() + " " + simbolo_contra, ok);
            if (ok.es == false) { return 0; }
            bigDecimal = (BigDecimal) ejecutar_estrategia_mapa.get(k_total_balance_contra);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            escribir_linea(k_total_balance_contra + " = " + bigDecimal.toPlainString() + " " + simbolo_contra, ok);
            if (ok.es == false) { return 0; }
            ok.setTxt(ok_local.getTxt());
        } catch (Exception e) {
            ok.setTxt(e.getMessage(), tr.in(in, "Excepción en pantalla_estrategia_l_s_1_margen_procesar. "));
        }
        return opcion;
    }
    /**
     * Procesa la pantalla estrategia l_s_1 (2)
     * @param datos_mapa Datos que utilizar
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return true si todo va bien
     * @throws Exception Opción de notificar errores de excepción
     */
    public boolean ver_pantalla_estrategia_l_s_1_margen_2(Map<String, Object> datos_mapa, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return false; }
            BigDecimal bigDecimal = null;
            BigDecimal ratio_subida = null;
            ResourceBundle in = null;
            String texto = "";
            String simbolo_base = "";
            String simbolo_contra = "";
            Map<String, Object> ejecutar_estrategia_mapa = null;
            in = ResourceBundles.getBundle(k_in_ruta);
            ratio_subida = (BigDecimal) datos_mapa.get(k_ratio_subida);
            if (ratio_subida.doubleValue() <= 0.25) {
                ok.setTxt("Importe demasiado bajo. ", ok.getTxt());
            }
            if (ok.es == false) { return false; }
            ejecutar_estrategia_mapa = kucoin_sdk.ejecutar_estrategia_l_s_1_margen_2(k_no_prestamo_si_hay, datos_mapa, ok);
            if (ok.es == false) { return false; }
            datos_mapa.putAll(ejecutar_estrategia_mapa);
            texto = (String) datos_mapa.get(k_simbolo_base);
            simbolo_base = texto;
            ok.no_nul(texto);
            escribir_linea(k_simbolo_base + " = " + texto, ok);
            if (ok.es == false) { return false; }
            texto = (String) datos_mapa.get(k_simbolo_contra);
            simbolo_contra = texto;
            ok.no_nul(texto);
            if (ok.es == false) { return false; }
            bigDecimal = (BigDecimal) datos_mapa.get(k_cantidad_base);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            escribir_linea(k_cantidad_base + " = " + bigDecimal.toPlainString() + " " + simbolo_base, ok);
            if (ok.es == false) { return false; }
            bigDecimal = (BigDecimal) datos_mapa.get(k_prestamo_obtenido_base);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            escribir_linea(k_prestamo_obtenido_base + " = " + bigDecimal.toPlainString() + " " + simbolo_base, ok);
            if (ok.es == false) { return false; }
            bigDecimal = (BigDecimal) datos_mapa.get(k_cantidad_contra);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            escribir_linea(k_cantidad_contra + " = " + bigDecimal.toPlainString() + " " + simbolo_contra, ok);
            if (ok.es == false) { return false; }
            bigDecimal = (BigDecimal) datos_mapa.get(k_prestamo_obtenido_contra);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            escribir_linea(k_prestamo_obtenido_contra + " = " + bigDecimal.toPlainString() + " " + simbolo_contra, ok);
            if (ok.es == false) { return false; }
            bigDecimal = (BigDecimal) datos_mapa.get(k_orden_venta_subida_cantidad);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            escribir_linea(k_orden_venta_subida_cantidad + " = " + bigDecimal.toPlainString() + " " + simbolo_base, ok);
            if (ok.es == false) { return false; }
            bigDecimal = (BigDecimal) datos_mapa.get(k_orden_venta_subida_cotizacion);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            escribir_linea(k_orden_venta_subida_cotizacion + " = " + bigDecimal.toPlainString() + " USD", ok);
            if (ok.es == false) { return false; }
            bigDecimal = (BigDecimal) datos_mapa.get(k_orden_compra_subida_mitad_cantidad);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            escribir_linea(k_orden_compra_subida_mitad_cantidad + " = " + bigDecimal.toPlainString() + " " + simbolo_base, ok);
            if (ok.es == false) { return false; }
            bigDecimal = (BigDecimal) datos_mapa.get(k_orden_compra_subida_mitad_cotizacion);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            escribir_linea(k_orden_compra_subida_mitad_cotizacion + " = " + bigDecimal.toPlainString() + " USD", ok);
            if (ok.es == false) { return false; }
            bigDecimal = (BigDecimal) datos_mapa.get(k_orden_venta_bajada_mitad_cantidad);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            escribir_linea(k_orden_venta_bajada_mitad_cantidad + " = " + bigDecimal.toPlainString() + " " + simbolo_base, ok);
            if (ok.es == false) { return false; }
            bigDecimal = (BigDecimal) datos_mapa.get(k_orden_venta_bajada_mitad_cotizacion);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            escribir_linea(k_orden_venta_bajada_mitad_cotizacion + " = " + bigDecimal.toPlainString() + " USD", ok);
            if (ok.es == false) { return false; }
            bigDecimal = (BigDecimal) datos_mapa.get(k_orden_compra_bajada_cantidad);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            escribir_linea(k_orden_compra_bajada_cantidad + " = " + bigDecimal.toPlainString() + " " + simbolo_base, ok);
            if (ok.es == false) { return false; }
            bigDecimal = (BigDecimal) datos_mapa.get(k_orden_compra_bajada_cotizacion);
            bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
            escribir_linea(k_orden_compra_bajada_cotizacion + " = " + bigDecimal.toPlainString() + " USD", ok);
            if (ok.es == false) { return false; }
            texto = (String) datos_mapa.get(k_ejecutar_estrategia_l_s_1_margen_2_incidencias);
            ok.no_nul(texto);
            if (ok.es == false) { return false; }
            escribir_linea(k_ejecutar_estrategia_l_s_1_margen_2_incidencias + " = " + texto, ok);
            if (ok.es == false) { return false; }
            texto = (String) datos_mapa.get(k_ejecutar_estrategia_l_s_1_margen_2_identificador);
            ok.no_nul(texto);
            if (ok.es == false) { return false; }
            escribir_linea(k_ejecutar_estrategia_l_s_1_margen_2_identificador + " = " + texto, ok);
            return ok.es;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Pantalla de comprobar estrategia_l_s_1_margen
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return true si todo va bien
     * @throws Exception Opción de notificar errores de excepción
     */
    @SuppressWarnings("unchecked")
    public boolean ver_pantalla_comprobar_estrategia_l_s_1_margen(oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return false; }
            int opcion = -1;
            String texto = "";
            String linea;
            ResourceBundle in = null;
            BigDecimal bigDecimal = null;
            Map<String, Object> datos_mapa = new HashMap<>();
            Map<String, Object> resultado_mapa = null;
            Map<String, Object> mapa = null;
            in = ResourceBundles.getBundle(k_in_ruta);
            while (opcion != 0) {
                if (ok.es == false) {
                    escribir_error(ok.getTxt(), ok);
                    ok.es = true;
                    escribir_linea(tr.in(in, "Fin de menú. "), ok);
                    break;
                }
                escribir_linea(tr.in(in, "Opciones: "), ok);
                escribir_linea("0- " +  tr.in(in, "Salir."), ok);
                escribir_linea(tr.in(in, "Escriba en una línea el identificador de la operación de estratégia L-S-1. "), ok);
                linea = leer_linea(ok);
                if (linea.equals("0")) {
                    break;
                }
                if (ok.es == false) { continue; }
                datos_mapa.put(k_ejecutar_estrategia_l_s_1_margen_2_identificador, linea);
                resultado_mapa = kucoin_sdk.comprobar_estrategia_l_s_1_margen(datos_mapa, ok);
                if (ok.es == false) { continue; }
                texto = (String) resultado_mapa.get(k_consulta_prestamo_simbolo_base);
                escribir_linea(k_consulta_prestamo_simbolo_base + " = " + texto, ok);
                if (ok.es == false) { continue; }
                bigDecimal = (BigDecimal) resultado_mapa.get(k_consulta_prestamo_importe_base);
                bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
                escribir_linea(k_consulta_prestamo_importe_base + " = " + bigDecimal.toPlainString(), ok);
                if (ok.es == false) { continue; }
                bigDecimal = (BigDecimal) resultado_mapa.get(k_consulta_prestamo_pendiente_repago_base);
                bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
                escribir_linea(k_consulta_prestamo_pendiente_repago_base + " = " + bigDecimal.toPlainString(), ok);
                if (ok.es == false) { continue; }
                texto = (String) resultado_mapa.get(k_consulta_prestamo_simbolo_contra);
                escribir_linea(k_consulta_prestamo_simbolo_contra + " = " + texto, ok);
                if (ok.es == false) { continue; }
                bigDecimal = (BigDecimal) resultado_mapa.get(k_consulta_prestamo_importe_contra);
                bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
                escribir_linea(k_consulta_prestamo_importe_contra + " = " + bigDecimal.toPlainString(), ok);
                if (ok.es == false) { continue; }
                bigDecimal = (BigDecimal) resultado_mapa.get(k_consulta_prestamo_pendiente_repago_contra);
                bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
                escribir_linea(k_consulta_prestamo_pendiente_repago_contra + " = " + bigDecimal.toPlainString(), ok);
                if (ok.es == false) { continue; }
                mapa = (Map<String, Object>) resultado_mapa.get(k_ovs);
                ok.no_nul(mapa);
                if (ok.es == false) { continue; }
                escribir_linea(k_ovs + " " + tr.in(in, " Orden Venta Subida ") + " -------------------------------------------------------- ", ok);
                bigDecimal = (BigDecimal) mapa.get(k_consultar_orden_origen_resultado);
                if (bigDecimal == null) {
                    escribir_linea(tr.in(in, "Orden no ejecutada todavía. "), ok);
                }
                escribir_linea(k_consultar_orden_origen_resultado + " = " + nulo_es_0(bigDecimal).toPlainString(), ok);
                if (ok.es == false) { continue; }
                bigDecimal = (BigDecimal) mapa.get(k_consultar_orden_resultado);
                bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
                escribir_linea(k_consultar_orden_resultado + " = " + nulo_es_0(bigDecimal).toPlainString(), ok);
                if (ok.es == false) { continue; }
                bigDecimal = (BigDecimal) mapa.get(k_consultar_orden_pendiente);
                bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
                escribir_linea(k_consultar_orden_pendiente + " = " + nulo_es_0(bigDecimal).toPlainString(), ok);
                if (ok.es == false) { continue; }
                mapa = (Map<String, Object>) resultado_mapa.get(k_ocsm);
                ok.no_nul(mapa);
                if (ok.es == false) { continue; }
                ok.no_nul(mapa);
                if (ok.es == false) { continue; }
                escribir_linea(k_ocsm + " " + tr.in(in, " Orden Compra Subida Mitad ") + " -------------------------------------------------------- ", ok);
                bigDecimal = (BigDecimal) mapa.get(k_consultar_orden_origen_resultado);
                if (bigDecimal == null) {
                    escribir_linea(tr.in(in, "Orden no ejecutada todavía. "), ok);
                }
                escribir_linea(k_consultar_orden_origen_resultado + " = " + nulo_es_0(bigDecimal).toPlainString(), ok);
                if (ok.es == false) { continue; }
                bigDecimal = (BigDecimal) mapa.get(k_consultar_orden_resultado);
                bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
                escribir_linea(k_consultar_orden_resultado + " = " + nulo_es_0(bigDecimal).toPlainString(), ok);
                if (ok.es == false) { continue; }
                bigDecimal = (BigDecimal) mapa.get(k_consultar_orden_pendiente);
                bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
                escribir_linea(k_consultar_orden_pendiente + " = " + nulo_es_0(bigDecimal).toPlainString(), ok);
                if (ok.es == false) { continue; }
                mapa = (Map<String, Object>) resultado_mapa.get(k_ovbm);
                ok.no_nul(mapa);
                if (ok.es == false) { continue; }
                escribir_linea(k_ovbm + " " + tr.in(in, " Orden Venta Bajada Mitad ") + " -------------------------------------------------------- ", ok);
                bigDecimal = (BigDecimal) mapa.get(k_consultar_orden_origen_resultado);
                if (bigDecimal == null) {
                    escribir_linea(tr.in(in, "Orden no ejecutada todavía. "), ok);
                }
                escribir_linea(k_consultar_orden_origen_resultado + " = " + nulo_es_0(bigDecimal).toPlainString(), ok);
                if (ok.es == false) { continue; }
                bigDecimal = (BigDecimal) mapa.get(k_consultar_orden_resultado);
                bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
                escribir_linea(k_consultar_orden_resultado + " = " + nulo_es_0(bigDecimal).toPlainString(), ok);
                if (ok.es == false) { continue; }
                bigDecimal = (BigDecimal) mapa.get(k_consultar_orden_pendiente);
                bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
                escribir_linea(k_consultar_orden_pendiente + " = " + nulo_es_0(bigDecimal).toPlainString(), ok);
                if (ok.es == false) { continue; }
                mapa = (Map<String, Object>) resultado_mapa.get(k_ocb);
                ok.no_nul(mapa);
                if (ok.es == false) { continue; }
                escribir_linea(k_ocb + " " + tr.in(in, " Orden Compra Bajada ") + " -------------------------------------------------------- ", ok);
                bigDecimal = (BigDecimal) mapa.get(k_consultar_orden_origen_resultado);
                if (bigDecimal == null) {
                    escribir_linea(tr.in(in, "Orden no ejecutada todavía. "), ok);
                }
                escribir_linea(k_consultar_orden_origen_resultado + " = " + nulo_es_0(bigDecimal).toPlainString(), ok);
                if (ok.es == false) { continue; }
                bigDecimal = (BigDecimal) mapa.get(k_consultar_orden_resultado);
                bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
                escribir_linea(k_consultar_orden_resultado + " = " + nulo_es_0(bigDecimal).toPlainString(), ok);
                if (ok.es == false) { continue; }
                bigDecimal = (BigDecimal) mapa.get(k_consultar_orden_pendiente);
                bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
                escribir_linea(k_consultar_orden_pendiente + " = " + nulo_es_0(bigDecimal).toPlainString(), ok);
                if (ok.es == false) { continue; }
                escribir_linea(" -------------------------------------------------------- ", ok);
                if (ok.es == false) { continue; }
                escribir_linea(k_comprobar_estrategia_l_s_1_es_subida_terminada + " = " + (boolean) resultado_mapa.get(k_comprobar_estrategia_l_s_1_es_subida_terminada), ok);
                if (ok.es == false) { continue; }
                bigDecimal = (BigDecimal) resultado_mapa.get(k_comprobar_estrategia_l_s_1_resultado_subida);
                bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
                escribir_linea(k_comprobar_estrategia_l_s_1_resultado_subida + " = " + nulo_es_0(bigDecimal).toPlainString(), ok);
                if (ok.es == false) { continue; }
                escribir_linea(k_comprobar_estrategia_l_s_1_es_bajada_terminada + " = " + (boolean) resultado_mapa.get(k_comprobar_estrategia_l_s_1_es_bajada_terminada), ok);
                if (ok.es == false) { continue; }
                bigDecimal = (BigDecimal) resultado_mapa.get(k_comprobar_estrategia_l_s_1_resultado_bajada);
                bigDecimal = BigDecimals.nulo_es_0(bigDecimal);
                escribir_linea(k_comprobar_estrategia_l_s_1_resultado_bajada + " = " + nulo_es_0(bigDecimal).toPlainString(), ok);
            }
            return ok.es;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * 
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return true si todo va bien
     * @throws Exception Opción de notificar errores de excepción
     */
    public boolean run(oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return false; }
            ResourceBundle in = null;
            in = ResourceBundles.getBundle(k_in_ruta);
            iniciales inicial = new iniciales ();
            inicial.iniciar(this.getClass(), ok);
            kucoin_sdk = new kucoin_sdk_cluis();
            kucoin_sdk.iniciar(ok);
            if (ok.es == false) { return false; }
            kucoin_sdk.modelo.clave = inicial.properties.getProperty(kucoin_sdks.modelos.k_clave);
            if (ok.no_nul(kucoin_sdk.modelo.clave) == false) {
                ok.txt = tr.in(in, "No se encuentra el dato clave. ");
            }
            if (ok.es == false) { return false; }
            kucoin_sdk.modelo.secreto = inicial.properties.getProperty(kucoin_sdks.modelos.k_secreto);
            if (ok.no_nul(kucoin_sdk.modelo.secreto) == false) {
                ok.txt = tr.in(in, "No se encuentra el dato secreto. ");
            }
            if (ok.es == false) { return false; }
            kucoin_sdk.modelo.contraseña = inicial.properties.getProperty(kucoin_sdks.modelos.k_contraseña);
            if (ok.no_nul(kucoin_sdk.modelo.contraseña) == false) {
                ok.txt = tr.in(in, "No se encuentra la contraseña. ");
            }
            if (ok.es == false) { return false; }
            kucoin_sdk.crear_cliente(modo_pruebas, ok);
            ver_pantalla_principal(ok);
            return ok.es;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void main(String[] args) {
        oks ok = new oks();
        ResourceBundle in = null;
        inversion_margen_L_S_1s inversion_margen_L_S_1 = null;
        try {
            inversion_margen_L_S_1 = new inversion_margen_L_S_1s();
            in = ResourceBundles.getBundle(k_in_ruta);
            inversion_margen_L_S_1.run(ok);
        } catch (Exception e) {
            try {
                ok.setTxt(tr.in(in, "Excepción en el método principal. "), e);
            } catch (Exception e_i) {
                // Se ignora esta excepción
            }
        } finally {
            if (ok.es == false) {
                inversion_margen_L_S_1.escribir_error(ok.txt, ok);
                exit(1);
            } else {
                exit(0);
            }
        }
    }    
}
