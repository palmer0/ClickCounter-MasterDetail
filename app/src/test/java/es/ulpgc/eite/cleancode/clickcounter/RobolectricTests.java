package es.ulpgc.eite.cleancode.clickcounter;

import android.content.pm.ActivityInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

import es.ulpgc.eite.cleancode.clickcounter.master.MasterActivity;


// Project: ClickCounter-MasterDetail
// Created by Luis Hernandez 
// Copyright (c) 2025 EITE (ULPGC)
@RunWith(RobolectricTestRunner.class)
@Config(sdk = 30)
public class RobolectricTests {

    private ActivityController<MasterActivity> activityController;
    private MasterActivity activity;
    private RobolectricTestsSteps steps;

    @Before
    public void setUp() {
        // Se crea y configura la actividad con Robolectric
        activityController = Robolectric.buildActivity(MasterActivity.class).setup();
        activity = activityController.get();
        steps = new RobolectricTestsSteps(activity);
    }

    /**
     * Simula la rotación de pantalla cambiando la orientación y
     * ejecutando el ciclo de recreación de la actividad.
     */
    private void rotateScreen() {
        // Cambia la orientación a landscape
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        activityController.configurationChange();
    }

    @Test
    public void test01CrearContadorEnMaestro() {
        steps.mostrarListaConNumeroDeContadoresP1("0");
        steps.pulsarBotonMaster();
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        steps.mostrarListaConNumeroDeContadoresP1("1");
    }

    @Test
    public void test02CrearContadorEnMaestroConRotacion() {
        steps.mostrarListaConNumeroDeContadoresP1("0");
        steps.pulsarBotonMaster();
        rotateScreen();
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        steps.mostrarListaConNumeroDeContadoresP1("1");
    }

    @Test
    public void test03PulsarEnContadorDeMaestro() {
        steps.mostrarListaConNumeroDeContadoresP1("0");
        steps.pulsarBotonMaster();
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        steps.mostrarListaConNumeroDeContadoresP1("1");
        steps.pulsarBotonContadorEnPosicionP1("0");
        steps.mostrarContadorConValorP1("1");
        steps.mostrarNumeroDeClicksConValorP1("1");
    }

    @Test
    public void test04PulsarEnContadorDeMaestroConRotacion() {
        steps.mostrarListaConNumeroDeContadoresP1("0");
        steps.pulsarBotonMaster();
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        steps.mostrarListaConNumeroDeContadoresP1("1");
        steps.pulsarBotonContadorEnPosicionP1("0");
        rotateScreen();
        steps.mostrarContadorConValorP1("1");
        steps.mostrarNumeroDeClicksConValorP1("1");
    }

    @Test
    public void test05PulsarEnContadorDeDetalle() {
        steps.mostrarListaConNumeroDeContadoresP1("0");
        steps.pulsarBotonMaster();
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        steps.mostrarListaConNumeroDeContadoresP1("1");
        steps.pulsarBotonContadorEnPosicionP1("0");
        steps.mostrarContadorConValorP1("1");
        steps.mostrarNumeroDeClicksConValorP1("1");
        steps.pulsarBotonDetalle();
        steps.mostrarContadorConValorP1("2");
        steps.mostrarNumeroDeClicksConValorP1("2");
    }

    @Test
    public void test06PulsarEnContadorDeDetalleConRotacion() {
        steps.mostrarListaConNumeroDeContadoresP1("0");
        steps.pulsarBotonMaster();
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        steps.mostrarListaConNumeroDeContadoresP1("1");
        steps.pulsarBotonContadorEnPosicionP1("0");
        steps.mostrarContadorConValorP1("1");
        steps.mostrarNumeroDeClicksConValorP1("1");
        steps.pulsarBotonDetalle();
        rotateScreen();
        steps.mostrarContadorConValorP1("2");
        steps.mostrarNumeroDeClicksConValorP1("2");
    }

    @Test
    public void test07PulsarEnRegresarDeDetalle() {
        steps.mostrarListaConNumeroDeContadoresP1("0");
        steps.pulsarBotonMaster();
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        steps.mostrarListaConNumeroDeContadoresP1("1");
        steps.pulsarBotonContadorEnPosicionP1("0");
        steps.mostrarContadorConValorP1("1");
        steps.mostrarNumeroDeClicksConValorP1("1");
        steps.pulsarBotonDetalle();
        steps.mostrarContadorConValorP1("2");
        steps.mostrarNumeroDeClicksConValorP1("2");
        steps.pulsarBotonRegresar();
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "2");
        steps.mostrarListaConNumeroDeContadoresP1("1");
    }

    @Test
    public void test08PulsarEnRegresarDeDetalleConRotacion() {
        steps.mostrarListaConNumeroDeContadoresP1("0");
        steps.pulsarBotonMaster();
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        steps.mostrarListaConNumeroDeContadoresP1("1");
        steps.pulsarBotonContadorEnPosicionP1("0");
        steps.mostrarContadorConValorP1("1");
        steps.mostrarNumeroDeClicksConValorP1("1");
        steps.pulsarBotonDetalle();
        steps.mostrarContadorConValorP1("2");
        steps.mostrarNumeroDeClicksConValorP1("2");
        steps.pulsarBotonRegresar();
        rotateScreen();
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "2");
        steps.mostrarListaConNumeroDeContadoresP1("1");
    }

    @Test
    public void test09CrearVariosContadoresEnMaestro() {
        steps.mostrarListaConNumeroDeContadoresP1("0");
        steps.pulsarBotonMasterNumeroDeVecesP1("3");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        steps.mostrarListaConNumeroDeContadoresP1("3");
    }

    @Test
    public void test10CrearVariosContadoresEnMaestroConRotacion() {
        steps.mostrarListaConNumeroDeContadoresP1("0");
        steps.pulsarBotonMasterNumeroDeVecesP1("3");
        rotateScreen();
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        steps.mostrarListaConNumeroDeContadoresP1("3");
    }

    @Test
    public void test11PulsarVariasVecesEnContadorDeMaestro() {
        steps.mostrarListaConNumeroDeContadoresP1("0");
        steps.pulsarBotonMasterNumeroDeVecesP1("3");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        steps.mostrarListaConNumeroDeContadoresP1("3");
        steps.pulsarBotonContadorEnPosicionP1("2");
        steps.mostrarContadorConValorP1("1");
        steps.mostrarNumeroDeClicksConValorP1("1");
    }

    @Test
    public void test12PulsarVariasVecesEnContadorDeMaestroConRotacion() {
        steps.mostrarListaConNumeroDeContadoresP1("0");
        steps.pulsarBotonMasterNumeroDeVecesP1("3");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        steps.mostrarListaConNumeroDeContadoresP1("3");
        steps.pulsarBotonContadorEnPosicionP1("2");
        rotateScreen();
        steps.mostrarContadorConValorP1("1");
        steps.mostrarNumeroDeClicksConValorP1("1");
    }

    @Test
    public void test13PulsarVariasVecesEnContadoresDeMaestro() {
        steps.mostrarListaConNumeroDeContadoresP1("0");
        steps.pulsarBotonMasterNumeroDeVecesP1("3");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        steps.mostrarListaConNumeroDeContadoresP1("3");
        steps.pulsarBotonContadorEnPosicionP1NumeroDeVecesP2("1", "2");
        steps.pulsarBotonContadorEnPosicionP1("2");
        steps.mostrarContadorConValorP1("1");
        steps.mostrarNumeroDeClicksConValorP1("3");
    }

    @Test
    public void test14PulsarVariasVecesEnContadoresDeMaestroConRotacion() {
        steps.mostrarListaConNumeroDeContadoresP1("0");
        steps.pulsarBotonMasterNumeroDeVecesP1("3");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        steps.mostrarListaConNumeroDeContadoresP1("3");
        steps.pulsarBotonContadorEnPosicionP1NumeroDeVecesP2("1", "2");
        steps.pulsarBotonContadorEnPosicionP1("2");
        rotateScreen();
        steps.mostrarContadorConValorP1("1");
        steps.mostrarNumeroDeClicksConValorP1("3");
    }

    @Test
    public void test15PulsarEnContadorDeDetalles() {
        steps.mostrarListaConNumeroDeContadoresP1("0");
        steps.pulsarBotonMasterNumeroDeVecesP1("3");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        steps.mostrarListaConNumeroDeContadoresP1("3");
        steps.pulsarBotonContadorEnPosicionP1NumeroDeVecesP2("1", "2");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "2");
        steps.pulsarBotonContadorEnPosicionP1("1");
        steps.mostrarContadorConValorP1("3");
        steps.mostrarNumeroDeClicksConValorP1("3");
        steps.pulsarBotonDetalle();
        steps.mostrarContadorConValorP1("4");
        steps.mostrarNumeroDeClicksConValorP1("4");
    }

    @Test
    public void test16PulsarEnContadorDeDetallesConRotacion() {
        steps.mostrarListaConNumeroDeContadoresP1("0");
        steps.pulsarBotonMasterNumeroDeVecesP1("3");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        steps.mostrarListaConNumeroDeContadoresP1("3");
        steps.pulsarBotonContadorEnPosicionP1NumeroDeVecesP2("1", "2");
        steps.pulsarBotonContadorEnPosicionP1("1");
        steps.mostrarContadorConValorP1("3");
        steps.mostrarNumeroDeClicksConValorP1("3");
        steps.pulsarBotonDetalle();
        rotateScreen();
        steps.mostrarContadorConValorP1("4");
        steps.mostrarNumeroDeClicksConValorP1("4");
    }

    @Test
    public void test17PulsarVariasVecesContadorDeDetalles() {
        steps.mostrarListaConNumeroDeContadoresP1("0");
        steps.pulsarBotonMasterNumeroDeVecesP1("3");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        steps.mostrarListaConNumeroDeContadoresP1("3");
        steps.pulsarBotonContadorEnPosicionP1NumeroDeVecesP2("1", "2");
        steps.pulsarBotonContadorEnPosicionP1("2");
        steps.mostrarContadorConValorP1("1");
        steps.mostrarNumeroDeClicksConValorP1("3");
        steps.pulsarBotonDetalleNumeroDeVecesP1("3");
        steps.mostrarContadorConValorP1("4");
        steps.mostrarNumeroDeClicksConValorP1("6");
    }

    @Test
    public void test18PulsarVariasVecesContadorDeDetallesConRotacion() {
        steps.mostrarListaConNumeroDeContadoresP1("0");
        steps.pulsarBotonMasterNumeroDeVecesP1("3");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("0", "0");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("1", "0");
        steps.mostrarContadorEnListaEnPosicionP1ConValorP2("2", "0");
        steps.mostrarListaConNumeroDeContadoresP1("3");
        steps.pulsarBotonContadorEnPosicionP1NumeroDeVecesP2("1", "2");
        steps.pulsarBotonContadorEnPosicionP1("2");
        steps.mostrarContadorConValorP1("1");
        steps.mostrarNumeroDeClicksConValorP1("3");
        steps.pulsarBotonDetalleNumeroDeVecesP1("3");
        rotateScreen();
        steps.mostrarContadorConValorP1("4");
        steps.mostrarNumeroDeClicksConValorP1("6");
    }
}
