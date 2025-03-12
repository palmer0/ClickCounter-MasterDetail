package es.ulpgc.eite.cleancode.clickcounter;

import static org.junit.Assert.assertEquals;
import static org.robolectric.Shadows.shadowOf;

import android.app.Activity;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import es.ulpgc.eite.cleancode.clickcounter.data.CounterData;

// Project: ClickCounter-MasterDetail
// Created by Luis Hernandez 
// Copyright (c) 2025 EITE (ULPGC)
public class RobolectricAppTestsSteps {

    private Activity activity;

    public RobolectricAppTestsSteps(Activity activity) {
        this.activity = activity;
    }

    public void mostrarListaConNumeroDeContadoresP1(String p1) {

        int expectedSize = Integer.valueOf(p1);

        ListView list = activity.findViewById(R.id.list);

        // Forzar el layout del ListView
        list.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        list.layout(0, 0, list.getMeasuredWidth(), list.getMeasuredHeight());

        assertEquals(
            "El ListView debe tener " + expectedSize + " elementos",
            expectedSize, list.getCount()
        );
    }


    public void pulsarBotonMaster() {

        /*
        // Opción 1: Usar el tipo FloatingActionButton
        FloatingActionButton master = activity.findViewById(R.id.master);
        master.performClick();
        */

        // Opción 2: Usar el tipo View
        View master = activity.findViewById(R.id.master);
        master.performClick();
    }

    public void mostrarContadorEnListaEnPosicionP1ConValorP2(String p1, String p2) {

        int pos = Integer.valueOf(p1);
        int expectedValue = Integer.valueOf(p2);

        ListView list = activity.findViewById(R.id.list);

        list.measure(
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        );
        list.layout(0, 0, list.getMeasuredWidth(), list.getMeasuredHeight());

        CounterData item = (CounterData) list.getAdapter().getItem(pos);
        int value = item.value;

        assertEquals(
            "El contador en la posición " + pos + " debe tener el valor " + expectedValue,
            expectedValue, value
        );
    }

    public void mostrarContadorConValorP1(String p1) {

        String expected = p1;

        TextView counter = activity.findViewById(R.id.counter);

        assertEquals(
            "El texto del contador debe ser " + expected,
            expected, counter.getText().toString()
        );
    }

    public void mostrarNumeroDeClicksConValorP1(String p1) {

        String expected = p1;

        TextView clicks = activity.findViewById(R.id.clicks);

        assertEquals(
            "El número de clicks debe ser " + expected,
            expected, clicks.getText().toString()
        );
    }

    public void pulsarBotonContadorEnPosicionP1(String p1) {

        /*
        // Recupera el Intent de la actividad iniciada
        Intent nextIntent = shadowOf(activity).getNextStartedActivity();

        // Construye la DetailActivity usando el Intent recuperado
        DetailActivity detailActivity =
            Robolectric.buildActivity(DetailActivity.class, nextIntent).setup().get();

        // Crea una nueva instancia de steps para DetailActivity
        //RobolectricTestsSteps detailSteps = new RobolectricTestsSteps(detailActivity);
        */


        int pos = Integer.valueOf(p1);

        ListView list = activity.findViewById(R.id.list);
        //ListView list = detailActivity.findViewById(R.id.list);

        // Forzar el layout del ListView
        list.measure(
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        );
        list.layout(0, 0, list.getMeasuredWidth(), list.getMeasuredHeight());

        // Obtener la vista del ítem en la posición indicada
        View item = list.getChildAt(pos);

        if (item == null) {

            // Si la vista del ítem aún no se ha creado, obtenerla manualmente
            item = list.getAdapter().getView(pos, null, list);

            item.measure(
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
            );
            item.layout(0, 0, item.getMeasuredWidth(), item.getMeasuredHeight());
        }

        // Simular el clic directamente en el ítem
        // para activar el listener configurado en el adaptador
        item.performClick();

        // Procesar runnables pendientes
        shadowOf(Looper.getMainLooper()).idle();
    }


    /*
    public void pulsarBotonContadorEnPosicionP1(String p1) {

        int pos = Integer.valueOf(p1);

        ListView list = activity.findViewById(R.id.list);

        list.measure(
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        );
        list.layout(0, 0, list.getMeasuredWidth(), list.getMeasuredHeight());

        View item = list.getChildAt(pos);

        if (item == null) {

            // Si la vista del ítem aún no se ha creado, forzar su obtención
            item = list.getAdapter().getView(pos, null, list);

            item.measure(
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
            );
            item.layout(0, 0, item.getMeasuredWidth(), item.getMeasuredHeight());
        }

        list.performItemClick(item, pos, list.getAdapter().getItemId(pos));


        // Procesa runnables pendientes
        shadowOf(Looper.getMainLooper()).idle();
    }
    */

    public void pulsarBotonDetalle() {
        Button detail = activity.findViewById(R.id.detail);
        detail.performClick();

        // Procesa runnables pendientes
        shadowOf(Looper.getMainLooper()).idle();
    }

    public void pulsarBotonRegresar() {
        activity.onBackPressed();

        // Procesa runnables pendientes
        shadowOf(Looper.getMainLooper()).idle();
    }

    public void pulsarBotonMasterNumeroDeVecesP1(String p1) {

        int times = Integer.valueOf(p1);

        for (int i = 0; i < times; i++) {
            pulsarBotonMaster();

            // Procesa runnables pendientes
            shadowOf(Looper.getMainLooper()).idle();
        }

    }

    public void pulsarBotonContadorEnPosicionP1NumeroDeVecesP2(String p1, String p2) {

        int times = Integer.valueOf(p2);

        for (int i = 0; i < times; i++) {
            pulsarBotonContadorEnPosicionP1(p1);

            // Procesa runnables pendientes
            shadowOf(Looper.getMainLooper()).idle();

            pulsarBotonRegresar();
        }
    }

    public void pulsarBotonDetalleNumeroDeVecesP1(String p1) {

        int times = Integer.valueOf(p1);

        for (int i = 0; i < times; i++) {
            pulsarBotonDetalle();

            // Procesa runnables pendientes
            shadowOf(Looper.getMainLooper()).idle();
        }
    }
}
