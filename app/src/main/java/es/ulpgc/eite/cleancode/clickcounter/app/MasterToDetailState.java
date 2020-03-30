package es.ulpgc.eite.cleancode.clickcounter.app;

public class MasterToDetailState {

  public CounterData counter;
  public Integer clicks;

  /*
  public MasterToDetailState(){
    counter = new CounterData();
    counter.value=2;
    clicks=3;
  }
  */

  public MasterToDetailState(CounterData counter, Integer clicks) {
    this.clicks=clicks;
    this.counter=counter;
  }
}
