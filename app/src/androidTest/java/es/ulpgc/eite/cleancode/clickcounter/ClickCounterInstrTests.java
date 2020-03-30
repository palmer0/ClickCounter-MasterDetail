package es.ulpgc.eite.cleancode.clickcounter;


import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.ulpgc.eite.cleancode.clickcounter.master.MasterActivity;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ClickCounterInstrTests {


    @Rule
    public ActivityTestRule<MasterActivity> rule = 
        new ActivityTestRule<>(MasterActivity.class);

    private ClickCounterRobot robot = new ClickCounterRobot(rule);

    @Test
    public void testCrearContadorEnMaestro() {
        // Given  mostrar lista con numero de contadores "0"
        robot.mostrarListaConNumeroDeContadoresP1("0");
        // When pulsar boton master
        robot.pulsarBotonMaster();
        // Then mostrar contador en lista en posicion "0" con valor "0"
        robot.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        // And mostrar lista con numero de contadores "1"
        robot.mostrarListaConNumeroDeContadoresP1("1");
    }

    @Test
    public void testPulsarEnContadorDeMaestro() {
        // Given  mostrar lista con numero de contadores "0"
        robot.mostrarListaConNumeroDeContadoresP1("0");
        // And pulsar boton master
        robot.pulsarBotonMaster();
        // And mostrar contador en lista en posicion "0" con valor "0"
        robot.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        // And mostrar lista con numero de contadores "1"
        robot.mostrarListaConNumeroDeContadoresP1("1");
        // When pulsar boton contador en posicion "0"
        robot.pulsarBotonContadorEnPosicionP1("0");
        // And mostrar contador con valor "1"
        robot.mostrarContadorConValorP1("1");
        // And mostrar numero de clicks con valor "1"
        robot.mostrarNumeroDeClicksConValorP1("1");
    }

    @Test
    public void testPulsarEnContadorDeDetalle() {
        // Given  mostrar lista con numero de contadores "0"
        robot.mostrarListaConNumeroDeContadoresP1("0");
        // And pulsar boton master
        robot.pulsarBotonMaster();
        // And mostrar contador en lista en posicion "0" con valor "0"
        robot.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        // And mostrar lista con numero de contadores "1"
        robot.mostrarListaConNumeroDeContadoresP1("1");
        // And pulsar boton contador en posicion "0"
        robot.pulsarBotonContadorEnPosicionP1("0");
        // And mostrar contador con valor "1"
        robot.mostrarContadorConValorP1("1");
        // And mostrar numero de clicks con valor "1"
        robot.mostrarNumeroDeClicksConValorP1("1");
        // When pulsar boton detalle
        robot.pulsarBotonDetalle();
        // Then mostrar contador con valor "2"
        robot.mostrarContadorConValorP1("2");
        // And mostrar numero de clicks con valor "2"
        robot.mostrarNumeroDeClicksConValorP1("2");
    }

    @Test
    public void testPulsarEnRegresarDeDetalle() {
        // Given  mostrar lista con numero de contadores "0"
        robot.mostrarListaConNumeroDeContadoresP1("0");
        // And pulsar boton master
        robot.pulsarBotonMaster();
        // And mostrar contador en lista en posicion "0" con valor "0"
        robot.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        // And mostrar lista con numero de contadores "1"
        robot.mostrarListaConNumeroDeContadoresP1("1");
        // And pulsar boton contador en posicion "0"
        robot.pulsarBotonContadorEnPosicionP1("0");
        // And mostrar contador con valor "1"
        robot.mostrarContadorConValorP1("1");
        // And mostrar numero de clicks con valor "1"
        robot.mostrarNumeroDeClicksConValorP1("1");
        // And pulsar boton detalle
        robot.pulsarBotonDetalle();
        // And mostrar contador con valor "2"
        robot.mostrarContadorConValorP1("2");
        // And mostrar numero de clicks con valor "2"
        robot.mostrarNumeroDeClicksConValorP1("2");
        // When pulsar boton regresar
        robot.pulsarBotonRegresar();
        // And mostrar contador en lista en posicion "0" con valor "2"
        robot.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "2");
        // And mostrar lista con numero de contadores "1"
        robot.mostrarListaConNumeroDeContadoresP1("1");
    }

    @Test
    public void testCrearVariosContadoresEnMaestro() {
        // Given  mostrar lista con numero de contadores "0"
        robot.mostrarListaConNumeroDeContadoresP1("0");
        // When pulsar boton master numero de veces "3"
        robot.pulsarBotonMasterNumeroDeVecesP1("3");
        // Then mostrar contador en lista en posicion "0" con valor "0"
        robot.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        // And mostrar contador en lista en posicion "1" con valor "0"
        robot.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        // And mostrar contador en lista en posicion "2" con valor "0"
        robot.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        // And mostrar lista con numero de contadores "3"
        robot.mostrarListaConNumeroDeContadoresP1("3");
    }

    @Test
    public void testPulsarVariasVecesEnContadorDeMaestro() {
        // Given  mostrar lista con numero de contadores "0"
        robot.mostrarListaConNumeroDeContadoresP1("0");
        // And pulsar boton master numero de veces "3"
        robot.pulsarBotonMasterNumeroDeVecesP1("3");
        // And mostrar contador en lista en posicion "0" con valor "0"
        robot.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        // And mostrar contador en lista en posicion "1" con valor "0"
        robot.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        // And mostrar contador en lista en posicion "2" con valor "0"
        robot.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        // And mostrar lista con numero de contadores "3"
        robot.mostrarListaConNumeroDeContadoresP1("3");
        // When pulsar boton contador en posicion "2"
        robot.pulsarBotonContadorEnPosicionP1("2");
        // And mostrar contador con valor "1"
        robot.mostrarContadorConValorP1("1");
        // And mostrar numero de clicks con valor "1"
        robot.mostrarNumeroDeClicksConValorP1("1");
    }

    @Test
    public void testPulsarVariasVecesEnContadoresDeMaestro() {
        // Given  mostrar lista con numero de contadores "0"
        robot.mostrarListaConNumeroDeContadoresP1("0");
        // And pulsar boton master numero de veces "3"
        robot.pulsarBotonMasterNumeroDeVecesP1("3");
        // And mostrar contador en lista en posicion "0" con valor "0"
        robot.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        // And mostrar contador en lista en posicion "1" con valor "0"
        robot.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        // And mostrar contador en lista en posicion "2" con valor "0"
        robot.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        // And mostrar lista con numero de contadores "3"
        robot.mostrarListaConNumeroDeContadoresP1("3");
        // When pulsar boton contador en posicion "1" numero de veces "2"
        robot.pulsarBotonContadorEnPosicionP1NumeroDeVecesP2("1", "2");
        // And pulsar boton contador en posicion "2"
        robot.pulsarBotonContadorEnPosicionP1("2");
        // And mostrar contador con valor "1"
        robot.mostrarContadorConValorP1("1");
        // And mostrar numero de clicks con valor "3"
        robot.mostrarNumeroDeClicksConValorP1("3");
    }

    @Test
    public void testPulsarEnContadorDeDetalles() {
        // Given  mostrar lista con numero de contadores "0"
        robot.mostrarListaConNumeroDeContadoresP1("0");
        // And pulsar boton master numero de veces "3"
        robot.pulsarBotonMasterNumeroDeVecesP1("3");
        // And mostrar contador en lista en posicion "0" con valor "0"
        robot.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        // And mostrar contador en lista en posicion "1" con valor "0"
        robot.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        // And mostrar contador en lista en posicion "2" con valor "0"
        robot.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        // And mostrar lista con numero de contadores "3"
        robot.mostrarListaConNumeroDeContadoresP1("3");
        // And pulsar boton contador en posicion "1" numero de veces "2"
        robot.pulsarBotonContadorEnPosicionP1NumeroDeVecesP2("1", "2");
        // And mostrar contador en lista en posicion "1" con valor "2"
        robot.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "2");
        // And pulsar boton contador en posicion "1"
        robot.pulsarBotonContadorEnPosicionP1("1");
        // And mostrar contador con valor "3"
        robot.mostrarContadorConValorP1("3");
        // And mostrar numero de clicks con valor "3"
        robot.mostrarNumeroDeClicksConValorP1("3");
        // When pulsar boton detalle
        robot.pulsarBotonDetalle();
        // Then mostrar contador con valor "4"
        robot.mostrarContadorConValorP1("4");
        // And mostrar numero de clicks con valor "4"
        robot.mostrarNumeroDeClicksConValorP1("4");
    }

    @Test
    public void testPulsarVariasVecesContadorDeDetalles() {
        // Given  mostrar lista con numero de contadores "0"
        robot.mostrarListaConNumeroDeContadoresP1("0");
        // And pulsar boton master numero de veces "3"
        robot.pulsarBotonMasterNumeroDeVecesP1("3");
        // And mostrar contador en lista en posicion "0" con valor "0"
        robot.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        // And mostrar contador en lista en posicion "1" con valor "0"
        robot.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        // And mostrar contador en lista en posicion "2" con valor "0"
        robot.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        // And mostrar lista con numero de contadores "3"
        robot.mostrarListaConNumeroDeContadoresP1("3");
        // And pulsar boton contador en posicion "1" numero de veces "2"
        robot.pulsarBotonContadorEnPosicionP1NumeroDeVecesP2("1", "2");
        // And pulsar boton contador en posicion "2"
        robot.pulsarBotonContadorEnPosicionP1("2");
        // And mostrar contador con valor "1"
        robot.mostrarContadorConValorP1("1");
        // And mostrar numero de clicks con valor "3"
        robot.mostrarNumeroDeClicksConValorP1("3");
        // When pulsar boton detalle numero de veces "3"
        robot.pulsarBotonDetalleNumeroDeVecesP1("3");
        // Then mostrar contador con valor "4"
        robot.mostrarContadorConValorP1("4");
        // And mostrar numero de clicks con valor "6"
        robot.mostrarNumeroDeClicksConValorP1("6");
    }
}