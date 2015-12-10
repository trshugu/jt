/*
public class tmp {public static void main(String args[]) {
}}
*/




import java.io.File;
public class ntmp {public static void main(String args[]) {
  System.out.println( new InputStreamReader(System.in).getEncoding() );
  
  String path = "./";
  File dir = new File(path);
  File[] files = dir.listFiles();
  for (int i=0; i<files.length; i++) {
      System.out.println("ファイル" + (i+1) + "→" + files[i]);
  }
  
}}


