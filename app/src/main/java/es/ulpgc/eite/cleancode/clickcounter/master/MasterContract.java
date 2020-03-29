package es.ulpgc.eite.cleancode.clickcounter.master;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.clickcounter.app.DetailToMasterState;
import es.ulpgc.eite.cleancode.clickcounter.app.MasterToDetailState;
import es.ulpgc.eite.cleancode.clickcounter.detail.DetailViewModel;

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

    void onListPressed(DetailViewModel data);
  }

  interface Model {
    List<DetailViewModel> getStoredData();

    void onDataFromNextScreen(DetailViewModel data);

    void onRestartScreen(List<DetailViewModel> datasource);

    void onAddData(DetailViewModel data);

    //void onDataFromPreviousScreen(String datasource);
  }

  interface Router {
    void navigateToNextScreen();

    void passStateToNextScreen(MasterToDetailState state);

    //MasterState getStateFromPreviousScreen();

    DetailToMasterState getStateFromNextScreen();

    //void passStateToPreviousScreen(MasterState state);
  }
}
