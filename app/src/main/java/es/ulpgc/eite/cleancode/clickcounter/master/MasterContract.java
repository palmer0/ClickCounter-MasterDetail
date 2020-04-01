package es.ulpgc.eite.cleancode.clickcounter.master;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.clickcounter.data.CounterData;
import es.ulpgc.eite.cleancode.clickcounter.app.DetailToMasterState;
import es.ulpgc.eite.cleancode.clickcounter.app.MasterToDetailState;

public interface MasterContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void onDataUpdated(MasterViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    void injectRouter(Router router);

    void onResume();
    void onStart();
    void onRestart();
    void onBackPressed();
    void onPause();
    void onDestroy();
    void onButtonPressed();
    void onListPressed(CounterData counter);
  }

  interface Model {
    List<CounterData> getStoredCounterList();
    void onDataFromNextScreen(CounterData counter, Integer clicks);
    void onRestartScreen(List<CounterData> counters, Integer clicks);
    void onAddCounter(CounterData counter);
    CounterData getStoredCounter(Long id);
    Integer getStoredNumOfClick();
    void onIncrementCounter(CounterData counter);
    void onIncrementNumOfClicks();
  }

  interface Router {
    void navigateToNextScreen();
    void passStateToNextScreen(MasterToDetailState state);
    DetailToMasterState getStateFromNextScreen();

  }
}
