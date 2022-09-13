/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package innui.kucoin_sdk;

import com.kucoin.sdk.rest.response.AccountBalancesResponse;
import com.kucoin.sdk.rest.response.BorrowQueryResponse;
import com.kucoin.sdk.rest.response.BorrowResponse;
import com.kucoin.sdk.rest.response.MarginAccountResponse;
import com.kucoin.sdk.rest.response.MarginOrderCreateResponse;
import com.kucoin.sdk.rest.response.MarketItemResponse;
import com.kucoin.sdk.rest.response.OrderCreateResponse;
import com.kucoin.sdk.rest.response.StopOrderResponse;
import com.kucoin.sdk.rest.response.SymbolResponse;
import innui.ref;
import static innui.kucoin_sdk.kucoin_sdks.k_ejecutar_estrategia_l_s_1_margen_2_identificador;
import static innui.kucoin_sdk.kucoin_sdks.k_importe_maximo;
import static innui.kucoin_sdk.kucoin_sdks.k_pareja_simbolos;
import static innui.kucoin_sdk.kucoin_sdks.k_ratio_subida;
import innui.modelos.errores.oks;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static innui.kucoin_sdk.kucoin_sdks.k_margen;
import static innui.kucoin_sdk.kucoin_sdks.k_no_prestamo_si_hay;

/**
 *
 * @author emilio
 */
public class kucoin_sdksTest {
    
    public kucoin_sdksTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    public boolean iniciar(kucoin_sdks kucoin_sdk, oks ok, Object ... extras_array) throws Exception {
        ok.es = kucoin_sdk.iniciar(ok);
        kucoin_sdk.modelo.clave = "????????????????????????";
        kucoin_sdk.modelo.secreto = "????????-????-????-????-????????????";
        kucoin_sdk.modelo.contraseña = "??????????????????";
        return ok.es;
    }
    
    /**
     * Test of iniciar method, of class kucoin_sdks.
     */
    @Ignore
    public void testIniciar() throws Exception {
        System.out.println("iniciar");
        Object[] extra_array = null;
        kucoin_sdks instance = new kucoin_sdks();
        boolean expResult = true;
        oks ok = new oks();
        boolean result = instance.iniciar(ok, extra_array);
        assertEquals(expResult, result);
    }

    /**
     * Test of conectar method, of class kucoin_sdks.
     */
    @Ignore
    public void testCrear_cliente() throws Exception {
        System.out.println("crear_cliente");
        Object[] extra_array = null;
        boolean expResult = true;
        oks ok = new oks();
        kucoin_sdks instance = new kucoin_sdks();
        iniciar(instance, ok);
        assertEquals(ok.es, true);
        boolean result = instance.crear_cliente(true, ok, extra_array);
        assertEquals(ok.es, true);
    }

    /**
     * Test of listar_balances_de_cuentas method, of class kucoin_sdks.
     */
    @Ignore
    public void testListar_balances_de_cuentas() throws Exception {
        oks ok = new oks();
        System.out.println("listar_balances_de_cuentas");
        Object[] extra_array = null;
        kucoin_sdks instance = new kucoin_sdks();
        List<AccountBalancesResponse> expResult = null;
        iniciar(instance, ok);
        assertEquals(ok.es, true);
        instance.crear_cliente(true, ok);
        assertEquals(ok.es, true);
        List<AccountBalancesResponse> result = instance.listar_balances_de_cuentas(ok);
        assertNotEquals(ok.es, true);
    }

    /**
     * Test of listar_balances_de_cuentas_escribir method, of class kucoin_sdks.
     */
    @Ignore
    public void testListar_balances_de_cuentas_escribir() throws Exception {
    }

    /**
     * Test of escribir_linea method, of class kucoin_sdks.
     */
    @Ignore
    public void testEscribir_linea() throws Exception {
        System.out.println("escribir_linea");
        String texto = "Texto de prueba";
        oks ok = new oks();
        Object[] extra_array = null;
        kucoin_sdks instance = new kucoin_sdks();
        boolean expResult = true;
        boolean result = instance.escribir_linea(texto, ok, extra_array);
        assertEquals(expResult, result);
    }

    /**
     * Test of listar_balances_de_cuenta_intercambio method, of class kucoin_sdks.
     */
    @Ignore
    public void testListar_balances_de_cuenta_intercambio() throws Exception {
        System.out.println("listar_balances_de_cuenta_intercambio");
        oks ok = new oks();
        Object[] extra_array = null;
        kucoin_sdks instance = new kucoin_sdks();
        iniciar(instance, ok);
        assertEquals(ok.es, true);
        instance.crear_cliente(true, ok);
        assertEquals(ok.es, true);
        List<AccountBalancesResponse> expResult = null;
        List<AccountBalancesResponse> result = instance.listar_balances_de_cuenta_intercambio(ok, extra_array);
        assertNotNull(result);
    }

    /**
     * Test of listar_balances_de_cuenta_margen method, of class kucoin_sdks.
     */
    @Ignore
    public void testListar_balances_de_cuenta_margen() throws Exception {
        System.out.println("listar_balances_de_cuenta_margen");
        oks ok = new oks();
        Object[] extra_array = null;
        kucoin_sdks instance = new kucoin_sdks();
        iniciar(instance, ok);
        assertEquals(ok.es, true);
        instance.crear_cliente(true, ok);
        assertEquals(ok.es, true);
        List<AccountBalancesResponse> expResult = null;
        List<AccountBalancesResponse> result = instance.listar_balances_de_cuenta_margen(ok, extra_array);
        assertNotNull(result);
    }

    /**
     * Test of listar_simbolos method, of class kucoin_sdks.
     */
    @Ignore
    public void testListar_simbolos_oks_ObjectArr() throws Exception {
        System.out.println("listar_simbolos");
        oks ok = new oks();
        Object[] extra_array = null;
        kucoin_sdks instance = new kucoin_sdks();
        iniciar(instance, ok);
        assertEquals(ok.es, true);
        instance.crear_cliente(true, ok);
        assertEquals(ok.es, true);
        List<SymbolResponse> result = instance.listar_simbolos(ok, extra_array);
        assertNotNull(result);
    }

    /**
     * Test of listar_simbolos method, of class kucoin_sdks.
     */
    @Ignore
    public void testListar_simbolos_4args() throws Exception {
        System.out.println("listar_simbolos");
        String moneda = "BTC";
        String mercado = k_margen;
        oks ok = new oks();
        Object[] extra_array = null;
        kucoin_sdks instance = new kucoin_sdks();
        iniciar(instance, ok);
        assertEquals(ok.es, true);
        instance.crear_cliente(true, ok);
        assertEquals(ok.es, true);
        List<SymbolResponse> result = instance.listar_simbolos(moneda, mercado, ok, extra_array);
        assertNotNull(result);
    }

    /**
     * Test of listar_simbolos_escribir method, of class kucoin_sdks.
     */
    @Ignore
    public void testListar_simbolos_escribir() throws Exception {
    }

    /**
     * Test of buscar_par method, of class kucoin_sdks.
     */
    @Ignore
    public void testBuscar_par() throws Exception {
        System.out.println("buscar_par");
        String par = "BTC-USDT";
        String mercado = k_margen;
        oks ok = new oks();
        Object[] extra_array = null;
        kucoin_sdks instance = new kucoin_sdks();
        iniciar(instance, ok);
        assertEquals(ok.es, true);
        instance.crear_cliente(true, ok);
        assertEquals(ok.es, true);
        List<SymbolResponse> result = instance.buscar_par(par, mercado, ok, extra_array);
        assertNotNull(result);
    }

    /**
     * Test of leer_cotizacion_usd method, of class kucoin_sdks.
     */
    @Ignore
    public void testLeer_cotizacion_usd() throws Exception {
        System.out.println("leer_cotizacion_usd");
        String simbolo_base = "BTC";
        String simbolo_contra = "USDT";
        oks ok = new oks();
        Object[] extra_array = null;
        kucoin_sdks instance = new kucoin_sdks();
        iniciar(instance, ok);
        assertEquals(ok.es, true);
        instance.crear_cliente(true, ok);
        assertEquals(ok.es, true);        
        Map<String, BigDecimal> result = instance.leer_cotizacion_usd(simbolo_base, simbolo_contra, ok, extra_array);
        assertNotNull(result);
    }

    /**
     * Test of consultar_mercado_de_prestamos_7_dias method, of class kucoin_sdks.
     */
    @Ignore
    public void testConsultar_mercado_de_prestamos_7_dias() throws Exception {
        System.out.println("consultar_mercado_de_prestamos_7_dias");
        String simbolo = "USDT";
        oks ok = new oks();
        Object[] extra_array = null;
        kucoin_sdks instance = new kucoin_sdks();
        iniciar(instance, ok);
        assertEquals(ok.es, true);
        instance.crear_cliente(true, ok);
        assertEquals(ok.es, true);
        List<MarketItemResponse> result = instance.consultar_mercado_de_prestamos_7_dias(simbolo, ok, extra_array);
        assertNotNull(result);
    }

    /**
     * Test of obtener_ratios_mercado_de_prestamos_7_dias method, of class kucoin_sdks.
     */
    @Ignore
    public void testObtener_ratios_mercado_de_prestamos_7_dias() throws Exception {
        System.out.println("obtener_ratios_mercado_de_prestamos_7_dias");
        String simbolo = "";
        oks ok = new oks();
        Object[] extra_array = null;
        kucoin_sdks instance = new kucoin_sdks();
        iniciar(instance, ok);
        assertEquals(ok.es, true);
        instance.crear_cliente(true, ok);
        assertEquals(ok.es, true);
        TreeMap<BigDecimal, MarketItemResponse> result = instance.obtener_ratios_mercado_de_prestamos_7_dias(simbolo, ok, extra_array);
        assertNotNull(result);
    }

    /**
     * Test of consultar_mercado_de_prestamos_7_dias_escribir method, of class kucoin_sdks.
     */
    @Ignore
    public void testConsultar_mercado_de_prestamos_7_dias_escribir() throws Exception {
    }

    /**
     * Test of ejecutar_estrategia_l_s_1_margen_1 method, of class kucoin_sdks.
     */
    @Ignore
    public void testEjecutar_estrategia_l_s_1_margen_1() throws Exception {
        System.out.println("ejecutar_estrategia_l_s_1_margen_1");
        Map<String, Object> datos_mapa = new HashMap<>();
        oks ok = new oks();
        Object[] extra_array = null;
        kucoin_sdks instance = new kucoin_sdks();
        iniciar(instance, ok);
        assertEquals(ok.es, true);
        instance.crear_cliente(true, ok);
        assertEquals(ok.es, true);
        datos_mapa.put(k_pareja_simbolos, "BTC-USDT");
        datos_mapa.put(k_importe_maximo, BigDecimal.valueOf(10000.00));
        Map<String, Object> result = instance.ejecutar_estrategia_l_s_1_margen_1(datos_mapa, ok, extra_array);
        assertNotNull(result);
        datos_mapa.putAll(result);
        datos_mapa.put(k_ratio_subida, BigDecimal.valueOf(1));
        result = instance.ejecutar_estrategia_l_s_1_margen_2(k_no_prestamo_si_hay, datos_mapa, ok, extra_array);
        System.out.println("Identificador: " + result.get(k_ejecutar_estrategia_l_s_1_margen_2_identificador));        
        assertNotNull(result);
    }

    /**
     * Test of ejecutar_estrategia_l_s_1_margen_2 method, of class kucoin_sdks.
     */
    @Ignore
    public void testEjecutar_estrategia_l_s_1_margen_2() throws Exception {
    }

    /**
     * Test of pedir_prestamo_7_dias method, of class kucoin_sdks.
     */
    @Ignore
    public void testPedir_prestamo_7_dias() throws Exception {
        System.out.println("pedir_prestamo_7_dias");
        String simbolo = "USDT";
        BigDecimal cantidad = BigDecimal.valueOf(1000.00);
        oks ok = new oks();
        Object[] extra_array = null;
        kucoin_sdks instance = new kucoin_sdks();
        iniciar(instance, ok);
        assertEquals(ok.es, true);
        instance.crear_cliente(true, ok);
        assertEquals(ok.es, true);
        BorrowResponse result = instance.pedir_prestamo_7_dias(simbolo, new ref<BigDecimal>(cantidad), ok, extra_array);
        assertNotNull(result);
        BorrowQueryResponse result_1 = instance.consultar_prestamo(result, ok, extra_array);
        assertNotNull(result_1);
    }

    /**
     * Test of consultar_prestamo method, of class kucoin_sdks.
     */
    @Ignore
    public void testConsultar_prestamo() throws Exception {
    }

    /**
     * Test of comprar_stop_limit_en_margen method, of class kucoin_sdks.
     */
    @Ignore
    public void testComprar_stop_limit_subida_en_margen() throws Exception {
        System.out.println("comprar_stop_limit_subida_en_margen");
        String par_base_contra = "BTC-USDT";
        BigDecimal cantidad_base = BigDecimal.valueOf(0.05);
        BigDecimal cotizacion_base = BigDecimal.valueOf(10000.00); 
        oks ok = new oks();
        Object[] extra_array = null;
        kucoin_sdks instance = new kucoin_sdks();
        iniciar(instance, ok);
        assertEquals(ok.es, true);
        instance.crear_cliente(true, ok);
        assertEquals(ok.es, true);
        OrderCreateResponse result = instance.comprar_stop_limit_subida_en_margen(par_base_contra, cantidad_base, new ref<BigDecimal>(cotizacion_base), ok, extra_array);
        assertNotNull(result);
        StopOrderResponse result_1 = instance.consultar_stop_limit_orden(result, ok, extra_array);
        assertNotNull(result_1);
    }

    /**
     * Test of vender_stop_limit_en_margen method, of class kucoin_sdks.
     */
    @Ignore
    public void testVender_stop_limit_subida_en_margen() throws Exception {
        System.out.println("vender_stop_limit_subida_en_margen");
        String par_base_contra = "BTC-USDT";
        BigDecimal cantidad_base = BigDecimal.valueOf(0.05);
        BigDecimal cotizacion_base = BigDecimal.valueOf(90000.00); 
        oks ok = new oks();
        Object[] extra_array = null;
        kucoin_sdks instance = new kucoin_sdks();
        iniciar(instance, ok);
        assertEquals(ok.es, true);
        instance.crear_cliente(true, ok);
        assertEquals(ok.es, true);
        OrderCreateResponse result = instance.vender_stop_limit_subida_en_margen(par_base_contra, cantidad_base, new ref<BigDecimal>(cotizacion_base), ok, extra_array);
        assertNotNull(result);
        StopOrderResponse result_1 = instance.consultar_stop_limit_orden(result, ok, extra_array);
        assertNotNull(result_1);
    }
    /**
     * Test of comprar_stop_limit_en_margen method, of class kucoin_sdks.
     */
    @Ignore
    public void testComprar_stop_limit_bajada_en_margen() throws Exception {
        System.out.println("comprar_stop_limit_bajada_en_margen");
        String par_base_contra = "BTC-USDT";
        BigDecimal cantidad_base = BigDecimal.valueOf(0.05);
        BigDecimal cotizacion_base = BigDecimal.valueOf(10000.00); 
        oks ok = new oks();
        Object[] extra_array = null;
        kucoin_sdks instance = new kucoin_sdks();
        iniciar(instance, ok);
        assertEquals(ok.es, true);
        instance.crear_cliente(true, ok);
        assertEquals(ok.es, true);
        OrderCreateResponse result = instance.comprar_stop_limit_bajada_en_margen(par_base_contra, cantidad_base, new ref<BigDecimal>(cotizacion_base), ok, extra_array);
        assertNotNull(result);
        StopOrderResponse result_1 = instance.consultar_stop_limit_orden(result, ok, extra_array);
        assertNotNull(result_1);
    }

    /**
     * Test of vender_stop_limit_en_margen method, of class kucoin_sdks.
     */
    @Ignore
    public void testVender_stop_limit_bajada_en_margen() throws Exception {
        System.out.println("vender_stop_limit_bajada_en_margen");
        String par_base_contra = "BTC-USDT";
        BigDecimal cantidad_base = BigDecimal.valueOf(0.05);
        BigDecimal cotizacion_base = BigDecimal.valueOf(90000.00); 
        oks ok = new oks();
        Object[] extra_array = null;
        kucoin_sdks instance = new kucoin_sdks();
        iniciar(instance, ok);
        assertEquals(ok.es, true);
        instance.crear_cliente(true, ok);
        assertEquals(ok.es, true);
        OrderCreateResponse result = instance.vender_stop_limit_bajada_en_margen(par_base_contra, cantidad_base, new ref<BigDecimal>(cotizacion_base), ok, extra_array);
        assertNotNull(result);
        StopOrderResponse result_1 = instance.consultar_stop_limit_orden(result, ok, extra_array);
        assertNotNull(result_1);
    }

    /**
     * Test of operar_stop_limit_en_margen method, of class kucoin_sdks.
     */
    @Ignore
    public void testOperar_stop_limit_en_margen() throws Exception {
    }

    /**
     * Test of consultar_stop_limit_orden method, of class kucoin_sdks.
     */
    @Ignore
    public void testConsultar_stop_limit_orden() throws Exception {
    }

    /**
     * Test of comprar_con_prestamo_en_margen method, of class kucoin_sdks.
     */
    @Ignore
    public void testComprar_con_prestamo_en_margen() throws Exception {
        System.out.println("comprar_con_prestamo_en_margen");
        String par_base_contra = "BTC-USDT";
        BigDecimal cantidad_base = BigDecimal.valueOf(0.05);
        BigDecimal cotizacion_base = BigDecimal.valueOf(10000.00); 
        oks ok = new oks();
        Object[] extra_array = null;
        kucoin_sdks instance = new kucoin_sdks();
        iniciar(instance, ok);
        assertEquals(ok.es, true);
        instance.crear_cliente(true, ok);
        assertEquals(ok.es, true);
        MarginOrderCreateResponse result = instance.comprar_en_margen(par_base_contra, cantidad_base, new ref<BigDecimal>(cotizacion_base), ok, extra_array);
        assertNotNull(result);
    }

    /**
     * Test of vender_con_prestamo_en_margen method, of class kucoin_sdks.
     */
    @Ignore
    public void testVender_con_prestamo_en_margen() throws Exception {
        System.out.println("vender_con_prestamo_en_margen");
        String par_base_contra = "BTC-USDT";
        BigDecimal cantidad_base = BigDecimal.valueOf(0.05);
        BigDecimal cotizacion_base = BigDecimal.valueOf(90000.00); 
        oks ok = new oks();
        Object[] extra_array = null;
        kucoin_sdks instance = new kucoin_sdks();
        iniciar(instance, ok);
        assertEquals(ok.es, true);
        instance.crear_cliente(true, ok);
        assertEquals(ok.es, true);
        MarginOrderCreateResponse result = instance.vender_en_margen(par_base_contra, cantidad_base, new ref<BigDecimal>(cotizacion_base), ok, extra_array);
        assertNotNull(result);
    }

    /**
     * Test of operar_con_prestamo_en_margen method, of class kucoin_sdks.
     */
    @Ignore
    public void testOperar_con_prestamo_en_margen() throws Exception {
    }

    /**
     * Test of comprar_en_margen method, of class kucoin_sdks.
     */
    @Ignore
    public void testComprar_en_margen() throws Exception {
        System.out.println("comprar_en_margen");
        String par_base_contra = "";
        BigDecimal cantidad_base = null;
        BigDecimal cotizacion_base = null;
        oks ok = null;
        Object[] extra_array = null;
        kucoin_sdks instance = new kucoin_sdks();
        MarginOrderCreateResponse expResult = null;
        MarginOrderCreateResponse result = instance.comprar_en_margen(par_base_contra, cantidad_base, new ref<BigDecimal>(cotizacion_base), ok, extra_array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of vender_en_margen method, of class kucoin_sdks.
     */
    @Ignore
    public void testVender_en_margen() throws Exception {
        System.out.println("vender_en_margen");
        String par_base_contra = "";
        BigDecimal cantidad_base = null;
        BigDecimal cotizacion_base = null;
        oks ok = null;
        Object[] extra_array = null;
        kucoin_sdks instance = new kucoin_sdks();
        MarginOrderCreateResponse expResult = null;
        MarginOrderCreateResponse result = instance.vender_en_margen(par_base_contra, cantidad_base, new ref<BigDecimal>(cotizacion_base), ok, extra_array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of operar_en_margen method, of class kucoin_sdks.
     */
    @Ignore
    public void testOperar_en_margen() throws Exception {
        System.out.println("operar_en_margen");
        String operacion = "";
        String par_base_contra = "";
        BigDecimal cantidad_base = null;
        BigDecimal cotizacion_base = null;
        oks ok = null;
        Object[] extra_array = null;
        kucoin_sdks instance = new kucoin_sdks();
        MarginOrderCreateResponse expResult = null;
        MarginOrderCreateResponse result = instance.operar_en_margen(operacion, par_base_contra, cantidad_base, new ref<BigDecimal>(cotizacion_base), ok, extra_array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of consultar_cuenta_margen method, of class kucoin_sdks.
     */
    @Ignore
    public void testConsultar_cuenta_margen() throws Exception {
        System.out.println("consultar_cuenta_margen");
        oks ok = null;
        Object[] extra_array = null;
        kucoin_sdks instance = new kucoin_sdks();
        MarginAccountResponse expResult = null;
        MarginAccountResponse result = instance.consultar_cuenta_margen(ok, extra_array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of comprobar_estrategia_l_s_1_margen method, of class kucoin_sdks.
     */
    @Test
    public void testComprobar_estrategia_l_s_1_margen() throws Exception {
        System.out.println("comprobar_estrategia_l_s_1_margen");
        Map<String, Object> datos_mapa = new HashMap<>();
        oks ok = new oks();
        Object[] extra_array = null;
        kucoin_sdks instance = new kucoin_sdks();
        iniciar(instance, ok);
        assertEquals(ok.es, true);
        instance.crear_cliente(true, ok);
        assertEquals(ok.es, true);
        datos_mapa.put(k_ejecutar_estrategia_l_s_1_margen_2_identificador
                , "BTC-USDT, 631b2c8180903200011eb21f, 631b2c8e6526ab000184cf45, ovs, vs8ueoor5ic3dkgv000v3jv6, ocb, vs8ueoor5if8141i000lehn8, ovb, vs8ueoor5ihjdkgv000v3jv7, ocb, vs8ueoor5iko141i000lehn9, ovsm, 631b2cb40091a6000148da71, ocbm, 631b2cc10091a6000148da80");
        Map<String, Object> result = instance.comprobar_estrategia_l_s_1_margen(datos_mapa, ok, extra_array);
        assertNotNull(result);
    }
    
}
