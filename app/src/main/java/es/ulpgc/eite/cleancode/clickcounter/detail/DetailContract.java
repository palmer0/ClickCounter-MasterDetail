package es.ulpgc.eite.cleancode.clickcounter.detail;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.clickcounter.data.CounterData;
import es.ulpgc.eite.cleancode.clickcounter.app.DetailToMasterState;
import es.ulpgc.eite.cleancode.clickcounter.app.MasterToDetailState;

public interface DetailContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void onDataUpdated(DetailViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    //void injectRouter(Router router);

    void onResume();
    void onStart();
    void onRestart();
    void onBackPressed();
    void onPause();
    void onDestroy();
    void onButtonPressed();
  }

  interface Model {
    CounterData getStoredCounter();
    Integer getStoredNumOfClick();
    void onIncrementNumOfClicks();
    void onRestartScreen(CounterData counter, Integer clicks);
    void onDataFromPreviousScreen(CounterData counter, Integer clicks);
    void onIncrementCounter();
  }

//  interface Router {
//
//    MasterToDetailState getStateFromPreviousScreen();
//    void passStateToPreviousScreen(DetailToMasterState state);
//  }
}
