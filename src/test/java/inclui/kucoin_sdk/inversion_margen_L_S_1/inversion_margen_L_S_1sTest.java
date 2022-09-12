/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package inclui.kucoin_sdk.inversion_margen_L_S_1;

import static inclui.kucoin_sdk.inversion_margen_L_S_1.inversion_margen_L_S_1s.k_in_ruta;
import innui.kucoin_sdk.kucoin_sdks;
import static innui.kucoin_sdk.kucoin_sdks.k_importe_maximo;
import static innui.kucoin_sdk.kucoin_sdks.k_pareja_simbolos;
import static innui.kucoin_sdk.kucoin_sdks.k_ratio_subida;
import innui.modelos.configuraciones.ResourceBundles;
import innui.modelos.configuraciones.iniciales;
import innui.modelos.errores.oks;
import innui.modelos.internacionalizacion.tr;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author emilio
 */
public class inversion_margen_L_S_1sTest {
    
    public inversion_margen_L_S_1sTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    public static boolean iniciar(inversion_margen_L_S_1s inversion_margen_L_S_1s, oks ok, Object ... extra_array) throws Exception {
        try{
            ResourceBundle in = null;
            in = ResourceBundles.getBundle(k_in_ruta);
            iniciales inicial = new iniciales ();
            ok.es = inicial.iniciar(inversion_margen_L_S_1s.getClass(), ok);
            inversion_margen_L_S_1s.kucoin_sdk = new kucoin_sdk_cluis();
            ok.es = inversion_margen_L_S_1s.kucoin_sdk.iniciar(ok);
            if (ok.es) {
                inversion_margen_L_S_1s.kucoin_sdk.modelo.clave = inicial.properties.getProperty(kucoin_sdks.modelos.k_clave);
                if (ok.no_nul(inversion_margen_L_S_1s.kucoin_sdk.modelo.clave) == false) {
                    ok.txt = tr.in(in, "No se encuentra el dato clave. ");
                }
            }
            if (ok.es) {
                inversion_margen_L_S_1s.kucoin_sdk.modelo.secreto = inicial.properties.getProperty(kucoin_sdks.modelos.k_secreto);
                if (ok.no_nul(inversion_margen_L_S_1s.kucoin_sdk.modelo.secreto) == false) {
                    ok.txt = tr.in(in, "No se encuentra el dato secreto. ");
                }
            }
            if (ok.es) {
                inversion_margen_L_S_1s.kucoin_sdk.modelo.contraseña = inicial.properties.getProperty(kucoin_sdks.modelos.k_contraseña);
                if (ok.no_nul(inversion_margen_L_S_1s.kucoin_sdk.modelo.contraseña) == false) {
                    ok.txt = tr.in(in, "No se encuentra la contraseña. ");
                }
            }
            if (ok.es) {
                ok.es = inversion_margen_L_S_1s.kucoin_sdk.crear_cliente(inversion_margen_L_S_1s.modo_pruebas, ok);
            }
            return ok.es;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Test of ver_pantalla_principal method, of class inversion_margen_L_S_1s.
     */
    @Ignore
    public void testVer_pantalla_principal() throws Exception {
        System.out.println("ver_pantalla_principal");
        oks ok = null;
        Object[] extra_array = null;
        inversion_margen_L_S_1s instance = new inversion_margen_L_S_1s();
        boolean expResult = false;
        boolean result = instance.ver_pantalla_principal(ok, extra_array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of escribir_linea method, of class inversion_margen_L_S_1s.
     */
    @Ignore
    public void testEscribir_linea() throws Exception {
        System.out.println("escribir_linea");
        String texto = "";
        oks ok = null;
        Object[] extra_array = null;
        inversion_margen_L_S_1s instance = new inversion_margen_L_S_1s();
        boolean expResult = false;
        boolean result = instance.escribir_linea(texto, ok, extra_array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of escribir_error method, of class inversion_margen_L_S_1s.
     */
    @Ignore
    public void testEscribir_error() {
        System.out.println("escribir_error");
        String texto = "";
        oks ok = null;
        Object[] extra_array = null;
        inversion_margen_L_S_1s instance = new inversion_margen_L_S_1s();
        boolean expResult = false;
        boolean result = instance.escribir_error(texto, ok, extra_array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leer_linea method, of class inversion_margen_L_S_1s.
     */
    @Ignore
    public void testLeer_linea() throws Exception {
        System.out.println("leer_linea");
        oks ok = null;
        Object[] extra_array = null;
        inversion_margen_L_S_1s instance = new inversion_margen_L_S_1s();
        String expResult = "";
        String result = instance.leer_linea(ok, extra_array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leer_bigdecimal method, of class inversion_margen_L_S_1s.
     */
    @Ignore
    public void testLeer_bigdecimal() throws Exception {
        System.out.println("leer_bigdecimal");
        oks ok = null;
        Object[] extra_array = null;
        inversion_margen_L_S_1s instance = new inversion_margen_L_S_1s();
        BigDecimal expResult = null;
        BigDecimal result = instance.leer_bigdecimal(ok, extra_array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ver_pantalla_principal_procesar_opciones method, of class inversion_margen_L_S_1s.
     */
    @Ignore
    public void testVer_pantalla_principal_procesar_opciones() throws Exception {
        System.out.println("ver_pantalla_principal_procesar_opciones");
        String texto = "";
        oks ok = null;
        Object[] extra_array = null;
        inversion_margen_L_S_1s instance = new inversion_margen_L_S_1s();
        String expResult = "";
        String result = instance.ver_pantalla_principal_procesar_opciones(texto, ok, extra_array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ver_pantalla_estrategia_l_s_1_margen method, of class inversion_margen_L_S_1s.
     */
    @Ignore
    public void testVer_pantalla_estrategia_l_s_1_margen() throws Exception {
        System.out.println("ver_pantalla_estrategia_l_s_1_margen");
        oks ok = null;
        Object[] extra_array = null;
        inversion_margen_L_S_1s instance = new inversion_margen_L_S_1s();
        boolean expResult = false;
        boolean result = instance.ver_pantalla_estrategia_l_s_1_margen(ok, extra_array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ver_pantalla_estrategia_l_s_1_margen_1 method, of class inversion_margen_L_S_1s.
     */
    @Test
    public void testVer_pantalla_estrategia_l_s_1_margen_1() throws Exception {
        System.out.println("ver_pantalla_estrategia_l_s_1_margen_1");
        Map<String, Object> datos_mapa = new HashMap<>();
        oks ok = new oks();
        Object[] extra_array = null;
        inversion_margen_L_S_1s instance = new inversion_margen_L_S_1s();
        iniciar(instance, ok);
        assertTrue(ok.es);
        datos_mapa.put(k_pareja_simbolos, "BTC-USDT");
        datos_mapa.put(k_importe_maximo, BigDecimal.valueOf(1000));
        instance.ver_pantalla_estrategia_l_s_1_margen_1(datos_mapa, ok, extra_array);
        assertTrue(ok.es);
    }

    /**
     * Test of ver_pantalla_estrategia_l_s_1_margen_2 method, of class inversion_margen_L_S_1s.
     */
    @Ignore
    public void testVer_pantalla_estrategia_l_s_1_margen_2() throws Exception {
        System.out.println("ver_pantalla_estrategia_l_s_1_margen_2");
        Map<String, Object> datos_mapa = new HashMap<>();
        oks ok = new oks();
        Object[] extra_array = null;
        inversion_margen_L_S_1s instance = new inversion_margen_L_S_1s();
        iniciar(instance, ok);
        assertTrue(ok.es);
        datos_mapa.put(k_pareja_simbolos, "BTC-USDT");
        datos_mapa.put(k_importe_maximo, BigDecimal.valueOf(1000));
        instance.ver_pantalla_estrategia_l_s_1_margen_1(datos_mapa, ok, extra_array);
        assertTrue(ok.es);
        datos_mapa.put(k_ratio_subida,BigDecimal.valueOf(0.5));
        instance.ver_pantalla_estrategia_l_s_1_margen_2(datos_mapa, ok, extra_array);
        assertTrue(ok.es);
    }

    /**
     * Test of run method, of class inversion_margen_L_S_1s.
     */
    @Ignore
    public void testRun() throws Exception {
        System.out.println("run");
        oks ok = null;
        Object[] extra_array = null;
        inversion_margen_L_S_1s instance = new inversion_margen_L_S_1s();
        boolean expResult = false;
        boolean result = instance.run(ok, extra_array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class inversion_margen_L_S_1s.
     */
    @Ignore
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        inversion_margen_L_S_1s.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
