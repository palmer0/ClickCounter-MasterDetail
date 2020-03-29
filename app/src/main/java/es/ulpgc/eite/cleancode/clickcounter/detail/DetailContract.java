package es.ulpgc.eite.cleancode.clickcounter.detail;

import java.lang.ref.WeakReference;

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
    String getStoredData();

    //void onDataFromNextScreen(String data);

    void onRestartScreen(DetailViewModel data);

    void onDataFromPreviousScreen(DetailViewModel data);
  }

  interface Router {
    void navigateToNextScreen();

    //void passStateToNextScreen(DetailState state);

    MasterToDetailState getStateFromPreviousScreen();

    //DetailState getStateFromNextScreen();

    void passStateToPreviousScreen(DetailToMasterState state);
  }
}
