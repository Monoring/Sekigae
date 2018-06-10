// -*- coding: utf-8 -*-

import java.util.ArrayList;
import java.util.Collections;
import java.applet.*;

public class Sekigae{
  public static void main(String[] args){
    ExecutionPart person = new ExecutionPart(args);                 //指定した人(番号)、席の番号(左前から右横に数える)を格納
    Sound drum = new Sound();
    drum.clip.play();
    try{
      Thread.sleep(5000);
      System.out.println("----------- ----------- -----------");
      System.out.println("| "+person.format()+" | "+person.format()+" | | "+person.format()+" | "+person.format()+" | | "+person.format()+" | "+person.format()+" |");
      System.out.println("----------- ----------- -----------");
      System.out.println("----------- ----------- -----------");
      System.out.println("| "+person.format()+" | "+person.format()+" | | "+person.format()+" | "+person.format()+" | | "+person.format()+" | "+person.format()+" |");
      System.out.println("----------- ----------- -----------");
      System.out.println("----------- ----------- -----------");
      System.out.println("| "+person.format()+" | "+person.format()+" | | "+person.format()+" | "+person.format()+" | | "+person.format()+" |    |");
      System.out.println("----------- ----------- -----------");
      Thread.sleep(2000);
      System.exit(0);
    }catch (InterruptedException e){
      System.out.println("!!! Exception occured !!!");
      System.out.println("");
      System.out.println(e);

    }finally{
      System.out.println("End of Sekigae.java");
    }
  }
}

class ExecutionPart{
  int[] reserve;
  ArrayList<Integer> seat_list = new ArrayList<Integer>();
  public ExecutionPart(String[] target){
    reserve = new int[target.length];
    for(int i=0;i<reserve.length;i++) {
      reserve[i] = Integer.parseInt(target[i]);
    }
    label: for(int i=1;i<18;i++){
      for(int j=0;j<reserve.length-1;j+=2) {                    //指定した人(番号)を省く
        if(i==reserve[j]) continue label;
      }
      seat_list.add(i);
    }
    Collections.shuffle(seat_list);
    Collections.shuffle(seat_list);
    for(int i=0;i<reserve.length-1;i+=2) {                      //指定した人(番号)をリストに挿入
      seat_list.add(reserve[i+1]-1,reserve[i]);
    }
  }
  public String format(){
    int result = result();
    String ret;

    if(result<10){
      ret = " " + result;
    }else{
      ret = "" + result;
    }
    return ret;
  }
  public int result(){
    int ret = seat_list.get(0);
    seat_list.remove(0);
    return ret;
  }
}

class Sound{
  public AudioClip clip;
  public Sound(){
    clip = Applet.newAudioClip(getClass().getResource("drum.wav"));
  }
}
