import java.util.ArrayList;
import java.util.Collections;
import java.applet.*;

public class Irukasan{
  public static void main(String[] args){
    Dodoriasan dodo = new Dodoriasan(args);
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
//  static int[] maenohito;
  ArrayList<Integer> list = new ArrayList<Integer>();
  public Dodoriasan(String[] uke){
    int i;
//    maenohito = new int[uke.length];
//    for(i=0;i<uke.length;i++){
//      maenohito[i] = uke[i];
//    }
    for(i=1;i<18;i++){
      list.add(i);
      Collections.shuffle(list);
    }
  }
  public int seki(){
    int ret = list.get(0);
    list.remove(0);
    return ret;
  }
  public String ban(){
    int seki = seki();
    String ret;

    if(seki<10){
//    }elseif(seki<10){
      ret = " " + seki;
    }else{
      ret = "" + seki;
    }
    return ret;
  }
}

class Sound{
  public AudioClip clip;
  public Sound(){
    clip = Applet.newAudioClip(getClass().getResource("drum.wav"));
  }
}
