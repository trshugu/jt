/*
public class tmp {public static void main(String args[]) {
}}
*/




import java.io.File;
public class ntmp {public static void main(String args[]) {

  File file = new File("./");
  File files[] = file.listFiles();

  for (int i=0; i<files.length; i++) {
      System.out.println("ffff" + (i+1) + ":::" + files[i]);
  }

}}


