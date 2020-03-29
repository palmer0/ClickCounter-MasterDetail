package es.ulpgc.eite.cleancode.clickcounter.detail;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.clickcounter.app.CounterData;
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

    void injectRouter(Router router);

    void onResume();

    void onStart();

    void onRestart();

    void onBackPressed();

    void onPause();

    void onDestroy();
  }

  interface Model {
    CounterData getStoredData();

    void onRestartScreen(CounterData counter);

    void onDataFromPreviousScreen(CounterData counter);
  }

  interface Router {
    void navigateToNextScreen();

    MasterToDetailState getStateFromPreviousScreen();

    void passStateToPreviousScreen(DetailToMasterState state);
  }
}
