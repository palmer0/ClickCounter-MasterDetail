package es.ulpgc.eite.cleancode.clickcounter;

import androidx.test.rule.ActivityTestRule;

import es.ulpgc.eite.cleancode.clickcounter.master.MasterActivity;

public class ClickCounterRobot {

    private InstrumentedRobot robot;
    //private ActivityTestRule<MasterActivity> rule;

    public ClickCounterRobot(ActivityTestRule<MasterActivity> rule) {
        //this.rule=rule;
        robot = new InstrumentedRobot(rule);
    }

    public void mostrarListaConNumeroDeContadoresP1(String p1) {
        robot.mostrarListaConNumeroDeContadores(p1);
    }

    public void pulsarBotonMaster() {
        robot.pulsarBotonMaster();
    }

    public void mostrarContadorEnListaEnPosicionP1ConValorP2(String p1, String p2) {
        robot.mostrarContadorEnListaEnPosicionConValor(p1, p2);
    }

    public void mostrarContadorConValorP1(String p1) {
        robot.mostrarContadorConValor(p1);
    }

    public void mostrarNumeroDeClicksConValorP1(String p1) {
        robot.mostrarNumeroDeClicksConValor(p1);
    }

    public void pulsarBotonContadorEnPosicionP1(String p1) {
        robot.pulsarBotonContadorEnPosicion(p1);
    }


    public void pulsarBotonDetalle() {
        robot.pulsarBotonDetalle();
    }

    public void pulsarBotonRegresar() {
        robot.pulsarBotonRegresar();
    }

    public void pulsarBotonMasterNumeroDeVecesP1(String p1) {
        robot.pulsarBotonMasterNumeroDeVeces(p1);
    }

    public void pulsarBotonContadorEnPosicionP1NumeroDeVecesP2(String p1, String p2) {
        robot.pulsarBotonContadorEnPosicionNumeroDeVeces(p1, p2);
    }

    public void pulsarBotonDetalleNumeroDeVecesP1(String p1) {
        robot.pulsarBotonDetalleNumeroDeVeces(p1);
    }
}