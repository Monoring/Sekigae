import java.util.ArrayList;
import java.util.Collections;
import java.applet.*;

public class Irukasan{
  public static void main(String[] args){
    Dodoriasan dodo = new Dodoriasan(args);                 //指定した人(番号)、席の番号(左前から右横に数える)を格納
    Sound drum = new Sound();
    drum.clip.play();
    try{
      Thread.sleep(5000);
      System.out.println("----------- ----------- -----------");
      System.out.println("| "+dodo.ban()+" | "+dodo.ban()+" | | "+dodo.ban()+" | "+dodo.ban()+" | | "+dodo.ban()+" | "+dodo.ban()+" |");
      System.out.println("----------- ----------- -----------");
      System.out.println("----------- ----------- -----------");
      System.out.println("| "+dodo.ban()+" | "+dodo.ban()+" | | "+dodo.ban()+" | "+dodo.ban()+" | | "+dodo.ban()+" | "+dodo.ban()+" |");
      System.out.println("----------- ----------- -----------");
      System.out.println("----------- ----------- -----------");
      System.out.println("| "+dodo.ban()+" | "+dodo.ban()+" | | "+dodo.ban()+" | "+dodo.ban()+" | | "+dodo.ban()+" |    |");
      System.out.println("----------- ----------- -----------");
      Thread.sleep(2000);
      System.exit(0);
    }catch (InterruptedException e){
    }
  }
}

class Dodoriasan{
  int[] mae;
  ArrayList<Integer> list = new ArrayList<Integer>();
  public Dodoriasan(String[] uke){
    mae = new int[uke.length];
    for(int i=0;i<mae.length;i++) {
      mae[i] = Integer.parseInt(uke[i]);
    }
    label: for(int i=1;i<18;i++){
      for(int j=0;j<mae.length-1;j+=2) {                    //指定した人(番号)を省く
        if(i==mae[j]) continue label;
      }
      list.add(i);
    }
    Collections.shuffle(list);
    Collections.shuffle(list);
    for(int i=0;i<mae.length-1;i+=2) {                      //指定した人(番号)をリストに挿入
      list.add(mae[i+1]-1,mae[i]);
    }
  }
  public String ban(){
    int seki = seki();
    String ret;

    if(seki<10){
      ret = " " + seki;
    }else{
      ret = "" + seki;
    }
    return ret;
  }
  public int seki(){
    int ret = list.get(0);
    list.remove(0);
    return ret;
  }
}

class Sound{
  public AudioClip clip;
  public Sound(){
    clip = Applet.newAudioClip(getClass().getResource("drum.wav"));
  }
}
