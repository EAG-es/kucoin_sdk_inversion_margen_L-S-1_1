/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package innui.kucoin_sdk;

import com.kucoin.sdk.KucoinPrivateWSClient;
import com.kucoin.sdk.model.enums.PrivateChannelEnum;
import com.kucoin.sdk.websocket.event.OrderChangeEvent;
import innui.modelos.errores.oks;
import java.util.function.Function;

/**
 *
 * @author emilio
 */
public class kucoin_escuchadores {
    /**
     * Atributo agregable obligatorio
     */
    public kucoin_sdks _kucoin_sdks;
    public KucoinPrivateWSClient _kucoinPrivateWSClient;
    /**
     * Conecta el objeto con Kucoin
     * @param kucoin_sdks Objeto de manejo de sdk de kucoin.
     * @param ok Comunicar resultados
     * @param extra_array Opción de añadir parámetros en el futuro.
     * @return true si todo va bien
     * @throws Exception Opción de notificar errores de excepción
     */
    public boolean crear_cliente(kucoin_sdks kucoin_sdks, oks ok, Object ... extra_array) throws Exception  {
        try {
            if (ok.es == false) { return false; }
            _kucoin_sdks = kucoin_sdks;
            _kucoinPrivateWSClient = _kucoin_sdks._kucoinClientBuilder.buildPrivateWSClient();
            return ok.es;
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Establece un escuchador de órdenes para un par de simbolos
     * @param function_array Objeto con el método apply que será ejecutado al ejecutarse la escucha.
     * @param par_de_simbolos
     * @param ok
     * @param extra_array
     * @return
     * @throws Exception 
     */
    public boolean escuchar_orden_cambia(Function<OrderChangeEvent, Boolean> function_array, String par_de_simbolos, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return false; }
            _kucoinPrivateWSClient.onOrderChange(response -> {
                if (function_array.apply(response.getData())) {
                    _kucoinPrivateWSClient.unsubscribe(PrivateChannelEnum.ORDER_CHANGE, par_de_simbolos);
                }
            }, par_de_simbolos);
            return ok.es;
        } catch (Exception e) {
            throw e; // Ayuda a la depuración
        }
    }
    
    /**
     * Establece un escuchador de órdenes para un par de simbolos
     * @param par_de_simbolos
     * @param ok
     * @param extra_array
     * @return
     * @throws Exception 
     */
    public boolean des_escuchar_orden_cambia(String par_de_simbolos, oks ok, Object ... extra_array) throws Exception {
        try {
            if (ok.es == false) { return false; }
            _kucoinPrivateWSClient.unsubscribe(PrivateChannelEnum.ORDER_CHANGE, par_de_simbolos);
            return ok.es;
        } catch (Exception e) {
            throw e; // Ayuda a la depuración
        }
    }
}
