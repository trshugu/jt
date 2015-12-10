/*
public class tmp {public static void main(String args[]) {
}}
*/




import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeSet;
import java.io.InputStreamReader;

public class ntmp {
  public static final int TYPE_FILE_OR_DIR = 1;
  public static final int TYPE_FILE = 2;
  public static final int TYPE_DIR = 3;
  
  public static void main(String args[]) {
    File files[] = listFiles("./","*");
    System.out.println( new InputStreamReader(System.in).getEncoding() );
    /*
    for (int i=0; i<files.length; i++) {
        System.out.println("ファイル" + (i+1) + "→" + files[i]);
    }
    */
  }

  public static File[] listFiles(String directoryPath, String fileName) {
    // ワイルドカード文字として*を正規表現に変換
    if (fileName != null) {
      fileName = fileName.replace(".", "\\.");
      fileName = fileName.replace("*", ".*");
    }
    return listFiles(directoryPath, fileName, TYPE_FILE, true, 0);
  }
  
  public static File[] listFiles(String directoryPath, String fileNamePattern, int type, boolean isRecursive, int period)
  {
    File dir = new File(directoryPath);
    if (!dir.isDirectory()) {
      throw new IllegalArgumentException
      ("引数で指定されたパス[" + dir.getAbsolutePath() + "]はディレクトリではありません。");
    }
    File[] files = dir.listFiles();
    //for (int i=0; i<files.length; i++) {
    //    System.out.println("ファイル" + (i+1) + "→" + files[i]);
    //}
    
    // その出力
    for (int i = 0; i < files.length; i++) {
      File file = files[i];
      addFile(type, fileNamePattern, set, file, period);
      // 再帰的に検索＆ディレクトリならば再帰的にリストに追加
      if (isRecursive && file.isDirectory()) {
        listFiles(file.getAbsolutePath(), fileNamePattern, type, isRecursive, period);
      }
    }
    
    return (File[]) set.toArray(new File[set.size()]);
  }
  
  private static void addFile(int type, String match, TreeSet set, File file,int period) {
    switch (type) {
    case TYPE_FILE:
      if (!file.isFile()) {
        return;
      }
      break;
    case TYPE_DIR:
      if (!file.isDirectory()) {
        return;
      }
      break;
    }
    if (match != null && !file.getName().matches(match)) {
      return;
    }
    // 指定日数経過しているかどうかの指定がある場合
    if (period != 0) {
      // ファイル更新日付
      Date lastModifiedDate = new Date(file.lastModified());
      String lastModifiedDateStr = new SimpleDateFormat("yyyyMMdd").format(lastModifiedDate);
      
      // 指定の日付（１日をミリ秒で計算）
      long oneDayTime = 24L * 60L * 60L * 1000L; 
      long periodTime = oneDayTime * Math.abs(period);
      Date designatedDate = new Date(System.currentTimeMillis() - periodTime);
      String designatedDateStr = new SimpleDateFormat("yyyyMMdd").format(designatedDate);
      
      if (period > 0) {
        if (lastModifiedDateStr.compareTo(designatedDateStr) < 0) {
          return;
        }
      } else {
        if (lastModifiedDateStr.compareTo(designatedDateStr) > 0) {
          return;
        }
      }
    }
    // 全ての条件に該当する場合リストに格納
    set.add(file);
  }
  
  private static TreeSet set = new TreeSet();
  
  public static void clear(){
    set.clear();
  }
}



/*
public class ntmp {public static void main(String args[]) {
  System.out.println( new InputStreamReader(System.in).getEncoding() );
  
  String path = "./";
  File dir = new File(path);
  File[] files = dir.listFiles();
  for (int i=0; i<files.length; i++) {
      System.out.println("fffff" + (i+1) + "->" + files[i]);
  }
  
}}
*/

