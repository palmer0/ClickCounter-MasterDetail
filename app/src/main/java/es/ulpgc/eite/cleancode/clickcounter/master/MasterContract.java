package es.ulpgc.eite.cleancode.clickcounter.master;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.clickcounter.app.CounterData;
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
    List<CounterData> getStoredDataSource();
    void onDataFromNextScreen(CounterData data);
    void onRestartScreen(List<CounterData> dataSource);
    void onAddData(CounterData data);
  }

  interface Router {
    void navigateToNextScreen();

    void passStateToNextScreen(MasterToDetailState state);

    DetailToMasterState getStateFromNextScreen();

  }
}
