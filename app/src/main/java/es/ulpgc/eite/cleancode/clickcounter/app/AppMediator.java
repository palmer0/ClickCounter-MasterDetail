package es.ulpgc.eite.cleancode.clickcounter.app;

import android.app.Application;

import es.ulpgc.eite.cleancode.clickcounter.detail.DetailState;
import es.ulpgc.eite.cleancode.clickcounter.master.MasterState;

public class AppMediator extends Application {

  private DetailState detailState;
  private MasterState masterState;

  private DetailToMasterState detailToMasterState;
  private MasterToDetailState masterToDetailState;

  @Override
  public void onCreate() {
    super.onCreate();

    detailState= new DetailState();
    masterState= new MasterState();
  }

  public DetailState getDetailState() {
    return detailState;
  }

  public MasterState getMasterState() {
    return masterState;
  }

  public void setDetailPreviousScreenState(DetailToMasterState state) {
    detailToMasterState=state;
  }

  public MasterToDetailState getDetailPreviousScreenState() {
    MasterToDetailState state = masterToDetailState;
    masterToDetailState = null;
    return state;
  }

  public DetailToMasterState getMasterNextScreenState() {
    DetailToMasterState state = detailToMasterState;
    detailToMasterState = null;
    return state;
  }


  public void setMasterNextScreenState(MasterToDetailState state) {
    masterToDetailState=state;
  }
}
