/*
public class tmp {public static void main(String args[]) {
}}
*/


/*
import java.util.ArrayList;
import java.util.AbstractList;
import java.util.AbstractCollection;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class tmp {public static void main(String args[]) {
  long start = System.currentTimeMillis();
  for(int i = 0; i < 100; i++)
  {
    ArrayList<String> ltsv = new ArrayList<String>();
    for(int j = 0; j < 100; j++)
    {
      ltsv.add("test" + Integer.toString(j));
    }
    // System.out.println( StringUtils.join(ltsv, "\t") );
  }
  
  long end = System.currentTimeMillis();
  long isb = end - start;
  System.out.println("かかった時間：  " + isb);
}}
*/


/* 実行順により差異がでるので一個ずつやる
public class tmp {public static void main(String args[]) {
  Integer ra = 1000;
  
  //  ==================================================
  // Array
  long astart = System.currentTimeMillis();
  for(int i = 0; i < ra; i++)
  {
    ArrayList<String> altsv = new ArrayList<String>();
    for(int j = 0; j < ra; j++)
    {
      altsv.add("test" + Integer.toString(j));
    }
    // System.out.println( StringUtils.join(ltsv, "\t") );
  }
  
  long aend = System.currentTimeMillis();
  long aisb = aend - astart;
  System.out.println("Aかかった時間：  " + aisb);
  
  //  ==================================================
  // List
  long istart = System.currentTimeMillis();
  for(int i = 0; i < ra; i++)
  {
    ArrayList<String> iltsv = new ArrayList<String>();
    for(int j = 0; j < ra; j++)
    {
      iltsv.add("test" + Integer.toString(j));
    }
    //System.out.println( StringUtils.join(llltsv, "\t") );
  }
  long iend = System.currentTimeMillis();
  long iisb = iend - istart;
  System.out.println("Lかかった時間：  " + iisb);

  //  ==================================================
  // Abstract
  long bstart = System.currentTimeMillis();
  for(int i = 0; i < ra; i++)
  {
    ArrayList<String> bltsv = new ArrayList<String>();
      for(int j = 0; j < ra; j++)
      {
        bltsv.add("test" + Integer.toString(j));
      }
  }
  
  //System.out.println( StringUtils.join(lltsv, "\t") );
  
  long bend = System.currentTimeMillis();
  long bisb = bend - bstart;
  System.out.println("bかかった時間：  " + bisb);
  
}}

*/


/*
import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.regex.*;
import java.util.logging.*;
*/


/*
import java.io.*;
import java.util.HashMap;
import java.util.Map;
class tmp
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> map = new HashMap<>();
        try {
            while (true) {
                String line = br.readLine();
                if (line == null || line.length() == 0) {
                    break;
                }
                String[] keyValues = line.split(",");
                map.put(keyValues[0], keyValues[1]);
            }
        } finally {
            br.close();
        }
        if (map.containsKey("java")){
          System.out.println(map.get("java").toUpperCase());
        } else{
          System.out.println();
        }
        if (map.containsKey("ruby")){
          System.out.println(map.get("ruby").toUpperCase());
        } else{
          System.out.println();
        }
        if (map.containsKey("go")){
          System.out.println(map.get("go").toUpperCase());
        } else{
          System.out.println();
        }
    }
}
*/



/*
import java.math.*;
class tmp{
public static void main(String[] args){
    BigDecimal pointOne = new BigDecimal(0.1); 
    BigDecimal sum = new BigDecimal("0");
    
      for(int i=0;i<10;i++){
      //System.out.println(sum);
      sum = sum.add(pointOne);
    }
    System.out.println("ans:"+ sum);
    }
}
*/



/*
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeSet;
import java.io.InputStreamReader;

public class tmp {
  public static final int TYPE_FILE_OR_DIR = 1;
  public static final int TYPE_FILE = 2;
  public static final int TYPE_DIR = 3;
  
  public static void main(String args[]) {
    File files[] = listFiles("./","*");
    System.out.println( new InputStreamReader(System.in).getEncoding() );
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
*/

/*
import java.io.File;
public class tmp {public static void main(String args[]) {
  String path = "./";
  File dir = new File(path);
  File[] files = dir.listFiles();
  for (int i = 0; i < files.length; i++) {
      File file = files[i];
      System.out.println((i + 1) + ":    " + file);
  }
}}
*/

/*
import java.io.File;
public class tmp {public static void main(String args[]) {

  //ファイル名の一覧を取得する
  File file = new File("C:\\gh\\jt");
  File files[] = file.listFiles();

  //取得した一覧を表示する
  for (int i=0; i<files.length; i++) {
      System.out.println("ファイル" + (i+1) + "→" + files[i]);
  }

}}

*/

/*
public class tmp {public static void main(String args[]) throws Exception{
  try
  {
    System.out.println("asdf");
    String asdf = null;
    throw new Exception("erraa");
  }
  catch (Exception e)
  {
    System.out.println("ktiayo");
    System.out.println(e);
    e.printStackTrace();
  }
}}
*/


/*
// 32bitのOSでのアウトオブオーダー問題2
public class tmp
{
  private static long longValue = 0;
  
  public static void main(String[] args) throws Exception
  {
    final int LOOP = 1000 * 1000 * 1000;
    
    Thread th1 = new Thread(new Runnable()
    {
      public void run()
      {
        for (int i = 0; i < LOOP; i++)
        {
          longValue = 1;
          check(longValue);
        }
      }
    });
    
    Thread th2 = new Thread(new Runnable()
    {
      public void run()
      {
        for (int i = 0; i < LOOP; i++)
        {
          longValue = -1;
          check(longValue);
        }
      }
    });
    
    th1.start();
    th2.start();
    
    th1.join();
    th2.join();
    
    System.out.println("Finished");
  }
  
  // 1と-1以外になった場合には例外を発生させる
  private static void check(long value)
  {
    if (value != 1 && value != -1)
    {
      throw new RuntimeException(String.valueOf(value));
    }
  }
}
*/


/*
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

public class tmp {
    class DateTimeFormatterThreadTest {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");

        public void exec(int count) {
            IntStream.range(0, count)
            .mapToObj(i -> LocalDateTime.now()
                .plusYears(i)
                .plusMonths(i)
                .plusDays(i)
                .plusHours(i)
                .plusMinutes(i)
                .plusSeconds(i)
            )
            .map(d -> d + " : " + df.format(d))
            .parallel()
            .forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        new tmp().go();
    }

    public void go() {
        int count = 20;
        new DateTimeFormatterThreadTest().exec(count);
    }
}
*/



/*
// sdfはスレッドセーフでない
import java.util.Calendar;
import java.util.stream.IntStream;
import java.text.SimpleDateFormat;

public class tmp {
  class SimpleDateFormatThreadTest {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      
      public void exec(int count) {
          IntStream.range(0, count)
          .mapToObj(i -> {
              Calendar cal = Calendar.getInstance();
              cal.add(Calendar.YEAR, i);
              cal.add(Calendar.MONTH, i);
              cal.add(Calendar.DATE, i);
              cal.add(Calendar.HOUR_OF_DAY, i);
              cal.add(Calendar.MINUTE, i);
              cal.add(Calendar.SECOND, i);
              return cal.getTime();
          })
          .map(d -> d + " : " + sdf.format(d))
          .parallel()
          .forEach(System.out::println);
      }
  }

  public static void main(String[] args) {
      new tmp().go();
  }

  public void go() {
      int count = 20;
      new SimpleDateFormatThreadTest().exec(count);
  }


}
*/



/*
// nullという文字列
public class tmp {public static void main(String args[]) {
  String aaa = null;
  aaa += "asdf";
  System.out.println(aaa); 
}}
*/



/*
// joinでTSV
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
public class tmp {public static void main(String args[]) {
  List<String> ltsv = new ArrayList<String>();
  ltsv.add("aaa");
  ltsv.add("bbb");
  System.out.println( StringUtils.join(ltsv, "\t") );
  
  String[] obj = {
    "asdf",
    "sdfd",
    "kijij"
  };
  
  System.out.println( StringUtils.join(obj, "\t") );
  String[] aa ={"2323","e","sadf"};
  System.out.println( StringUtils.join(aa, "\t") );
}}
*/

/*
// UnsupportedEncodingExceptionを駆逐
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;

public class tmp {public static void main(String args[]) {

  String hashKey = "anokutara";
  // String algorithm = "MD5";
  // String algorithm = "SHA-256";
  String algorithm = "naiyon";
  String hash = null;
  
    // ハッシュ値生成
    MessageDigest md = MessageDigest.getInstance(algorithm);
    byte[] hashBytes = md.digest(hashKey.getBytes(StandardCharsets.UTF_8));
    //byte[] hashBytes = md.digest(hashKey.getBytes("UTF-8"));
    
    // ハッシュ値を16進文字列に変換
    StringBuilder str = new StringBuilder("");
    for (byte hashByte : hashBytes)
    {
      str.append(Integer.toHexString(0xFF & hashByte).toUpperCase());
    }
    
    // hash = str.substring(5, 5 + 5);
    hash = str.toString();

  System.out.println( hash );
}}
*/


/*
// heep
public class tmp {public static void main(String args[]) {

System.out.println( "heep" );
System.out.println( "a" + Runtime.getRuntime().totalMemory() );
System.out.println( Runtime.getRuntime().freeMemory() );
System.out.println( Runtime.getRuntime().maxMemory() );

}}
*/


/*
public class tmp {public static void main(String args[]) {
  long start = System.currentTimeMillis();
  long end = System.currentTimeMillis();
  long isb = end - start;
  System.out.println("かかった時間：  " + isb);
}}
*/


/*
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import org.apache.commons.lang.time.DateUtils;
public class tmp {public static void main(String args[]) {

// 最新判定
try {
Calendar lD = Calendar.getInstance();
Calendar sd = Calendar.getInstance();
Date now = DateUtils.truncate(new SimpleDateFormat("yyyyMMdd").parse("20150123"), Calendar.DAY_OF_MONTH);
lD.setTime(now);
sd.setTime(now);

System.out.println( lD.getTime() );

lD.add( Calendar.DAY_OF_MONTH, 14 * -1 );
sd.add( Calendar.DAY_OF_MONTH, 15 * -1 );

System.out.println( lD.getTime() );

System.out.println( lD.getTime().compareTo(sd.getTime()) <= 0 );

}
catch (ParseException e){
}


}}
*/


/*
public class tmp {public static void main(String args[]) {
  String te = "te", st = "st";
  System.out.println("test");
  String username = te + st;
  username.intern();
  //"test".intern();
  //System.out.println(System.identityHashCode(username));
  System.out.println("String object the same is:" + (username == "test"));
  System.out.println("String object the same is:" + (username.equals("test")));
  System.out.println("String object the same is:" + ("test".equals(username)));
}}
*/


/*
// 日付変換分析
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class tmp {public static void main(String args[]) {
  String strNow =new Timestamp(System.currentTimeMillis()).toString();
  int cnt = 0;
while (cnt < 2000000000){cnt++;}
  
  System.out.println( strNow );
  String strDate = strNow.trim();
  System.out.println( strDate );
  Calendar cal = Calendar.getInstance();
  cal.setLenient(false);
  
  int yyyy = Integer.parseInt(strDate.substring(0,4));
  int MM = Integer.parseInt(strDate.substring(5,7));
  int dd = Integer.parseInt(strDate.substring(8,10));
  int HH = cal.get(Calendar.HOUR_OF_DAY);
  int mm = cal.get(Calendar.MINUTE);
  int ss = cal.get(Calendar.SECOND);
  int SSS = cal.get(Calendar.MILLISECOND);
  
  cal.clear();
  cal.set(yyyy,MM-1,dd);
  
  HH = Integer.parseInt(strDate.substring(11,13));
  mm = Integer.parseInt(strDate.substring(14,16));
  ss = Integer.parseInt(strDate.substring(17,19));
  SSS = Integer.parseInt(strDate.substring(20,23));
  cal.set(Calendar.HOUR_OF_DAY,HH);
  cal.set(Calendar.MINUTE,mm);
  cal.set(Calendar.SECOND,ss);
  cal.set(Calendar.MILLISECOND,SSS);
  
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  System.out.println( cal );
  System.out.println( cal.getTime() );
  System.out.println( sdf.format( cal.getTime() ) );
  
}}
*/


/*
public class tmp {public static void main(String args[]) {
  String te = "te", st = "st";
  
  // ここでプールされるとintern時に
  "test".length();
  String username = te + st;
  
  // "test"がある場合文字列が。ない場合は"test"がプールされ参照が返却される。
  username.intern();
  
  // 参照と"test"を比較する場合はtrue。文字列同士を比較するとfalseになる。
  System.out.println("String object the same is:" + (username == "test"));
  System.out.println(System.identityHashCode(username));
  System.out.println(System.identityHashCode("test"));
}}
*/


/*
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang.time.DateUtils;

public class tmp {public static void main(String args[]) {
  try
  {
    Date d = DateUtils.truncate(new SimpleDateFormat("yyyyMMdd").parse("20141218"), Calendar.DAY_OF_MONTH);
    Date t = DateUtils.truncate(new SimpleDateFormat("yyyyMMdd").parse("20141218"), Calendar.DAY_OF_MONTH);
    System.out.println(d.compareTo(t));
    //System.out.println(d.after(t));
    // System.out.println(DateUtils.truncate(new SimpleDateFormat("yyyyMMdd").parse("20141218"), Calendar.DAY_OF_MONTH));
    
  }
  catch (ParseException e)
  {
  }
}}
*/



/*
// RxJava
import rx.Observable;
import rx.functions.Action1;

public class tmp {
  public static void main(String args[]) {
    System.out.println("bon");
    hello("sadf");
    hello("death");
  }

  // java8向け
  public static void hello(String... names) {
    Observable.from(names).subscribe( s ->
      System.out.println("Hello " + s + "!")
    );
  }

  // java7向け
  public static void hello(String... names) {
    Observable.from(names).subscribe(new Action1<String>() {
      @Override
      public void call(String s)
      {
        System.out.println("Hello " + s + "!");
      }
    });
  }
}
*/


/*
// 改行の許容
public class tmp {public static void main(String args[]) {

System.out.println("bon");
System.out.println(
  (1 == 2)
    ? "iti"
    : "no" 
);

}}
*/



/*
// ファイル削除
import java.io.File;
public class tmp {public static void main(String args[]) {
System.out.println("tesa");
new File("death.txt").delete();
}}
*/


/*
// java標準logging
import java.util.logging.*;
public class tmp {public static void main(String args[]) {

Logger l = Logger.getLogger("lll");
l.info("ininin");

FileHandler fh = null;
try{
fh = new FileHandler("log.txt");
}catch(Exception e){}

Formatter format = new XMLFormatter();
fh.setFormatter(format);
l.addHandler(fh);
l.info("ininin");


System.out.println("tesa");

}}
*/


/*
// ランダムな小英数字の限界点(スレッド)
public class tmp {

// ランダムな小英数字を指定文字数返却する
public static String random(Integer i)
{
  java.util.Random rnd =new java.util.Random();
  java.lang.StringBuffer res = new java.lang.StringBuffer();
  String list = "0123456789abcdefghijklmnopqrstuvwxyz";
  
  for (int j = 0; j < i; j++)
  {
    res.append(list.charAt(rnd.nextInt( list.length() )));
  }
  
  return res.toString();
}

public final static java.util.HashSet<String> set = new java.util.HashSet<String>();

public static synchronized void setting() {
  set.add(random(14));
}

public static void main(String args[])  throws Exception{
long start = System.currentTimeMillis();

final int loop = 3000000;

Thread th1 = new Thread(new Runnable()
{
  public void run()
  {
    for(int i = 0; i < loop + ( loop / 3 ); i++)
    {
      setting();
    }
  }
});

Thread th2 = new Thread(new Runnable()
{
  public void run()
  {
    for(int i = 0; i < loop; i++)
    {
      setting();
    }
  }
});

Thread th3 = new Thread(new Runnable()
{
  public void run()
  {
    for(int i = 0; i < loop; i++)
    {
      setting();
    }
  }
});

th1.start();
th2.start();
th3.start();

th1.join();
th2.join();
th3.join();


System.out.println(set.size());
long end = System.currentTimeMillis();
long isb = end - start;
System.out.println(isb);

}}
*/


/*
// ランダムな小英数字の限界点
// →36文字で1000万個は不可能
public class tmp {

// ランダムな小英数字を指定文字数返却する
public static String random(Integer i)
{
  java.util.Random rnd =new java.util.Random();
  //java.security.SecureRandom rnd =new java.security.SecureRandom();
  java.lang.StringBuilder res = new java.lang.StringBuilder();
  String list = "0123456789abcdefghijklmnopqrstuvwxyz";
  //String list = "0";
  
  for (int j = 0; j < i; j++)
  {
    res.append(list.charAt(rnd.nextInt( list.length() )));
  }
  
  return res.toString();
}

public static void main(String args[]) {
long start = System.currentTimeMillis();
java.util.HashSet<String> set = new java.util.HashSet<String>();
//java.util.LinkedList<String> set = new java.util.LinkedList<String>();

for(int i = 0; i < 14000000; i++)
//for(int i = 0; i < 100; i++)
{
  set.add(random(20));
}

System.out.println(set.size());
long end = System.currentTimeMillis();
long isb = end - start;
System.out.println(isb);
}}
*/



/*
import static spark.Spark.*;
public class tmp {public static void main(String args[]) {
  get("/hello", (req, res) -> "Hell World");
}}
*/


/*
// DynamoDbLocal
import java.util.ArrayList;
import java.util.List;
import com.amazonaws.auth.*;
import com.amazonaws.services.dynamodbv2.*;
import com.amazonaws.services.dynamodbv2.model.*;
import com.amazonaws.services.dynamodbv2.datamodeling.*;

public class tmp {public static void main(String args[]) {
  String accessKey = "AccessKey";
  String secretAccessKey = "SecretKey";
  AWSCredentials cre = new BasicAWSCredentials(accessKey, secretAccessKey);
  AmazonDynamoDBClient client = new AmazonDynamoDBClient(cre);
  client.setEndpoint("http://localhost");
  
  // テーブル一覧
  //System.out.println(client.listTables());
  
  // テーブル作成
  List<KeySchemaElement> keySchema = new ArrayList<KeySchemaElement>();
  keySchema.add( new KeySchemaElement().withAttributeName("HogeId").withKeyType(KeyType.HASH) );
  AttributeDefinition attrDef = new AttributeDefinition().withAttributeName("HogeId").withAttributeType(ScalarAttributeType.S);
  ProvisionedThroughput pt = new ProvisionedThroughput().withReadCapacityUnits(10L).withWriteCapacityUnits(5L);
  
  String tableName = "DynamoTest";
  System.out.println( client.createTable(new CreateTableRequest(tableName, keySchema).withAttributeDefinitions(attrDef).withProvisionedThroughput(pt)) );
  
  // アイテム追加
//  Map<String, AttributeValue> item = new HashMap<String, AttributeValue>();
//  item.put("HogeId", new AttributeValue("AAAA"));
//  item.put("foo", new AttributeValue("valueA"));
//  item.put("bar", new AttributeValue().withSS(Arrays.asList("valueB", "valueC")));
//  System.out.println(client.putItem(new PutItemRequest(tableName, item)));
  
  // アイテム取得
//  Map<String, AttributeValue> key = new HashMap<String, AttributeValue>();
//  key.put("HogeId", new AttributeValue("AAAA"));
//  System.out.println(client.getItem(new GetItemRequest(tableName, key)));
  
  // アイテム更新
//  Map<String, AttributeValueUpdate> attributes = new HashMap<String, AttributeValueUpdate>();
//  attributes.put("bar", new AttributeValueUpdate(new AttributeValue().withS("valueD"), AttributeAction.PUT));
//  System.out.println(client.updateItem(new UpdateItemRequest(tableName, key, attributes)));
  
  // スキャン
//  System.out.println(client.scan(new ScanRequest(tableName)));
  
  // アイテム削除
//  System.out.println(client.deleteItem(new DeleteItemRequest(tableName, key)));
  
  // テーブル削除
//  System.out.println(client.deleteTable(new DeleteTableRequest(tableName)));

}}
*/


/*
class stasta {
  static int ci = 1;
  int si = 5;
  
  public void add(){
    ci++;
    si++;
  }
}

public class tmp {public static void main(String args[]) {
  stasta aa = new stasta();
  System.out.println(aa.ci);
  System.out.println(aa.si);
  
  aa.add();
  System.out.println(aa.ci);
  System.out.println(aa.si);
  
  stasta bb = new stasta();
  System.out.println(bb.ci);
  System.out.println(bb.si);
  
  bb.add();
  System.out.println(bb.ci);
  System.out.println(bb.si);

  aa.add();
  System.out.println(aa.ci);
  System.out.println(aa.si);
  System.out.println(bb.ci);
  System.out.println(bb.si);

}}
*/


/*
// 64bitでは止まらない
import java.util.concurrent.TimeUnit;
public class tmp
{
  private static boolean stopRequested;
  
  // stopRequestedに設定する。
  private static synchronized void requestStop()
  {
    stopRequested =  true;
  }
  
  // stopRequestedを取得する。
  private static synchronized boolean stopRequested()
  {
    return stopRequested;
  }
  
  public static void main(String[] args) throws InterruptedException
  {
    Thread backgroundThread = new Thread(new Runnable()
    {
      public void run()
      {
        int i = 0;
        System.out.println(i);
        while (!stopRequested())
        {
          i++;
        }
        System.out.println(i);
      }
    });
    
    backgroundThread.start();
    TimeUnit.SECONDS.sleep(1);
    //stopRequested = true;
    requestStop();
  }
}
*/


/*
// Initialize on demand holder idiom
final class Singleton {
  public String atai = "asdf";
  
  public String henkou()
  {
    atai = atai + "bn";
    return atai;
  }
  
  private Singleton(){
    System.out.println("const");
    System.out.println(atai);
  }
  
  private static class SingletonHolder {
    private static final Singleton instance = new Singleton();
  }
  
  public static Singleton getInstance() {
    return SingletonHolder.instance;
  }
}

public class tmp {public static void main(String args[]) {
  Singleton s = Singleton.getInstance();
  System.out.println(s.henkou());
  
  Singleton i = Singleton.getInstance();
  System.out.println(i.henkou());

  Singleton n = Singleton.getInstance();
  System.out.println(n.henkou());

  System.out.println(s.atai);
  System.out.println(i.atai);
  System.out.println(n.atai);
}}
*/



/*
// インクリメントの場合Atomicメソッドでスレッドセーフ
import java.util.concurrent.atomic.*;
public class tmp
{
  private volatile static int intValue = 0;
  //private volatile static AtomicInteger intValue = new AtomicInteger(0);
  
  //private static long longValue = 0;
  //private volatile static long longValue = 0;
  //private static AtomicLong longValue = new AtomicLong(0);
  
  public static void increment() {
    intValue++;
    //intValue.incrementAndGet();
  }
  
  public static void main(String[] args) throws Exception
  {
    final int LOOP = 1000 * 1000 * 1000;
    //final int LOOP = 1000;
    
    Thread th1 = new Thread(new Runnable()
    {
      public void run()
      {
        for (int i = 0; i < LOOP; i++)
        {
          increment();
        }
      }
    });
    
    Thread th2 = new Thread(new Runnable()
    {
      public void run()
      {
        for (int i = 0; i < LOOP; i++)
        {
          increment();
        }
      }
    });
    
    Thread th3 = new Thread(new Runnable()
    {
      public void run()
      {
        for (int i = 0; i < LOOP; i++)
        {
          increment();
        }
      }
    });
    
    th1.start();
    th2.start();
    th3.start();
    
    th1.join();
    th2.join();
    th3.join();
    
    System.out.println(intValue);
    System.out.println("Finished");
  }
  
}
*/


/*
// 32bitのOSでのアウトオブオーダー問題
import java.util.concurrent.atomic.*;

public class tmp
{
  private static long longValue = 0;
  //private volatile static long longValue = 0;
  //private static AtomicLong longValue = new AtomicLong(0);
  
  public static void main(String[] args) throws Exception
  {
    final int LOOP = 1000 * 1000 * 1000;
    //final int LOOP = 1000;
    
    Thread th1 = new Thread(new Runnable()
    {
      public void run()
      {
        for (int i = 0; i < LOOP; i++)
        {
          longValue = 1;
          //longValue.set(1);
          check(longValue);
          //check(longValue.longValue());
        }
      }
    });
    
    Thread th2 = new Thread(new Runnable()
    {
      public void run()
      {
        for (int i = 0; i < LOOP; i++)
        {
          longValue = -1;
          //longValue.set(-1);
          check(longValue);
          //check(longValue.longValue());
        }
      }
    });
    
    th1.start();
    th2.start();
    
    th1.join();
    th2.join();
    
    System.out.println("Finished");
  }
  
  // 1と-1以外になった場合には例外を発生させる
  private static void check(long value)
  {
    if (value != 1 && value != -1)
    {
      throw new RuntimeException(String.valueOf(value));
    }
  }
}
*/





/*
// javapテスト
public class tmp {public static void main(String args[]) {
  System.out.println("javap");
}}
*/

/*
// redisの実装
import redis.clients.jedis.*;
import org.redisson.*;
import com.lambdaworks.codec.*;
import com.lambdaworks.redis.*;
//import org.apache.log4j.*;
public class tmp {public static void main(String args[]) {

// jedis
Jedis jedis = new Jedis("localhost");
jedis.set("key", "value");
System.out.println(jedis.get("key"));

// redisson動かない
//Redisson redisson = Redisson.create();


}}
*/


/*
// いけてないMD5の調査
import java.io.*;
import java.text.*;
import java.security.MessageDigest;

public class tmp {
  public static void main(String args[])
  {
    //System.out.println("aaaa");
    System.out.println(getHashCode("aaaa"));
    //System.out.println(String2MD5("aaaa"));
    //System.out.println("0" + Integer.toHexString(0xFF & 0xe5) );
    //"0" + Integer.toHexString((0xFF & hash[i])
  }
  
  public static String getHashCode(String text)
  {
    //ダイジェストにデータを追加
    byte[] hash = null;
    MessageDigest md = null;
    try
    {
      md = MessageDigest.getInstance("MD5");
      md.update(text.getBytes());
      hash = md.digest();
    }
    catch (Exception e){}
    
    //バイト文字列をStringBufferに追加して文字列を生成
    StringBuffer stb = new StringBuffer();
    for (int i = 0; i < hash.length; i++)
    {
      //int in = Math.abs((int)hash[i]);
      //stb.append(Integer.toString(in, 16));
      // 正しくはこう書く
      stb.append( ((0xff & (int)hash[i]) < 0x10 ) ? "0" : "" );
      stb.append(Integer.toHexString(0xff & (int)hash[i]));
      //System.out.println(Integer.toHexString(0xff & (int)hash[i]));
      
      //System.out.println(Integer.toString(in, 16));
      //System.out.println(Integer.toString((int)hash[i], 16));
    }
    
    return stb.toString();
  }

  public static String String2MD5(String key)
  {
    byte[] hash = null;
    MessageDigest md;
    try
    {
      md = MessageDigest.getInstance("MD5");
      md.update(key.getBytes());
      hash = md.digest();
    } catch (Exception e) {}
      
    return hashByte2MD5(hash);
  }
  
  public static String hashByte2MD5(byte []hash)
  {
    StringBuffer hexString = new StringBuffer();
    for (int i = 0; i < hash.length; i++)
    {
      // 16未満のときは0を付与する
      if ((0xff & hash[i]) < 0x10)
      {
        hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
      }
      else
      {
        hexString.append(Integer.toHexString(0xFF & hash[i]));
      }
    }
    return hexString.toString();
  }
}
*/



/*
// インターフェース
class One{ 
  public void to(An d) {
    d.s();
  }
}

interface An{
  public void s();
}

class Da implements An{
  public void s(){System.out.println("aaaa");}
}

class Du implements An{
  public void s(){System.out.println("uuuuuu");}
}



public class tmp {public static void main(String args[]) {
  One o = new One();
  Da a = new Da();
  Du u = new Du();
  
  o.to(a);
  o.to(u);
  
  System.out.println("asdf");
}}
*/

/*
public class tmp {public static void main(String args[]) {
  Integer i = 3;
  System.out.println(i.hashCode());
}}
*/


/*
// 空文字が通る事象があった
public class tmp {public static void main(String args[]) {

String ValId1 = "";

String[] Val1 = ValId1.split(",");

for (int i = 0; i < Val1.length; i++)
{
  if (Val1[i] != "")
  {
    System.out.println("ttt");
    System.out.println( Val1[i] );
  }
  else
  {
    System.out.println("false");
  }
}

}}
*/


/*
import java.sql.*;
import java.util.*;
import com.jenkov.db.PersistenceManager;
import com.jenkov.db.itf.IDaos;

public class tmp {public static void main(String args[]) throws Exception {
// Butterfly Persistance
try{
  Class.forName("org.mariadb.jdbc.Driver");
  //Class.forName("com.mysql.jdbc.Driver");
  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmp?user=root&password=12121212");
  
  //Statement  st = con.createStatement();
  PersistenceManager manager = new PersistenceManager();
  IDaos daos = manager.createDaos(con);
  List list = daos.getMapDao().readMapList("select * from btf");
  //System.out.println(list);
  for(Object s : list){
    //System.out.println( s );
  }
  
  btf btfi = new btf();
  //挿入
  daos.getObjectDao().insert(btfi);
  //検索
  List<btf> btfis = daos.getObjectDao().readList(btf.class, "select * from btf where id = ?", 1);
  for(btf u : btfis){
    System.out.println(u.getId() + ":" + u.getName());
  }
  btfi = btfis.get(0);
  //更新
  //daos.getObjectDao().update(btfi);
  //削除
  //daos.getObjectDao().delete(btfi);  
} catch  (SQLException ex) {
  System.out.println("SQLException: " + ex.getMessage());
  System.out.println("SQLState: " + ex.getSQLState());
  System.out.println("VendorError: " + ex.getErrorCode());
} catch(ClassNotFoundException e) {
  System.out.println(e);
} catch(Exception e) {
  System.out.println(e);
}

}}
*/



/*
public class tmp {public static void main(String args[]) {
// nullという文字が出力されるその2
System.out.println( "asdf" + null );

StringBuilder sb = new StringBuilder();
sb.append("asdf");
sb.append("asdf");
sb.append((String)null); // Stringをキャストすれば入る
System.out.println( sb );
}}
*/


/*
public class tmp {public static void main(String args[]) {
// try-with-resources Statement
try (java.io.BufferedReader br =  new java.io.BufferedReader(new java.io.FileReader("./test.xml"))) 
{
  String str;
  while((str = br.readLine()) != null)
  {
    System.out.println( str );
  }
}
catch(Exception e)
{
  System.out.println(e);
}
}}
*/



/*
public class tmp {public static void main(String args[]) {
// nullという文字が出力される
String aa = "asdf{0}";
java.text.MessageFormat f = new java.text.MessageFormat(aa);
String bb = f.format(new String[]{null} );

System.out.println( bb );
}}
*/


/*
public class tmp {public static void main(String args[]) {
// n個までのイテレーションはforeachではダメか・・・
java.util.ArrayList<String> l = new java.util.ArrayList<String>();
l.add("adsf");
l.add("cccc");
l.add("eeeree");

//Iterator<String> i = l.iterator();
//for(int x = 0; i.hasNext() && x < 2; x++){
//  System.out.println( i.next() );
//}

for(String s : l.subList(0,3)){
  System.out.println( s );
}
}}
*/


/*
public class tmp {public static void main(String args[]) {
// Unicode半角カタカナのコード範囲か？
String test = "ｲest";
Character oo = test.charAt(0);
boolean a = (oo instanceof Character);
System.out.println( oo.compareTo(new Character((char)0xff66)) );
}}
*/




/*
public class tmp {
enum Operator { Plus, Minus, Multiplication, Division ;}

public static int Matchstick(int i){
  switch (i)
  {
    case 0:
      return 6;
    case 1:
      return 2;
    case 2:
      return 5;
    case 3:
      return 5;
    case 4:
      return 4;
    case 5:
      return 5;
    case 6:
      return 6;
    case 7:
      return 4;
    case 8:
      return 7;
    case 9:
      return 6;
    default:
      return 0;
  }
}

// 計算機
public static int kalk(int x, int y, Operator operator) {
  x = Matchstick(x);
  y = Matchstick(y);
  
  switch (operator)
  {
    case Plus:
      return Math.abs(x + y);
    case Minus:
      return Math.abs(x - y);
    case Multiplication:
      return Math.abs(x * y);
    case Division:
      return Math.abs(x / y);
  }
  return 0;
}

public static void main(String args[]) {
  System.out.println(kalk(2, 4, Operator.Plus));
}}
*/


/*
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import javax.xml.xpath.*;

public class tmp {public static void main(String args[]) {

// xmlパーステスト
String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><rss xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\" xmlns:taxo=\"http://purl.org/rss/1.0/modules/taxonomy/\" version=\"2.0\">tetete</rss>";
try
{
  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
  DocumentBuilder db = dbf.newDocumentBuilder();
  InputSource is = new InputSource(new StringReader(xml));
  Document doc = db.parse(is);
  
  XPathFactory factory = XPathFactory.newInstance();
  XPath xpath = factory.newXPath();
  XPathExpression expr = xpath.compile("//rss/text()");
  Object result = expr.evaluate(doc, XPathConstants.STRING);
  
  System.out.println(result);
}
catch(Exception ex){}
}}
*/


/*
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class tmp {public static void main(String args[]) {

try
{
  DocumentBuilderFactory factory  = DocumentBuilderFactory.newInstance();
  DocumentBuilder builder = factory.newDocumentBuilder();

  File f = new File( "test.xml" );
  Document doc = builder.parse( f );
  Element root = doc.getDocumentElement();
  NodeList children = root.getChildNodes();

  for( int i=0; i<children.getLength(); i++ )
  {
    Node child = children.item(i);
    System.out.println( child );
    
    if( child instanceof Element )
    {
       Element childElement = (Element) child;
       System.out.println( childElement.getTagName() );
    }
  }
}
catch( ParserConfigurationException e ) {}
catch( SAXException e ) {}
catch( IOException e ) {}
}}
*/


/*
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
public class tmp {public static void main(String args[]) {

// dom4j
Document document = DocumentHelper.createDocument();
Element root = document.addElement( "messages" );
Element me = root.addElement( "message" ).addAttribute( "attr", "A message" ).addText( "message" );
System.out.println(root);
}}
*/


/*
import java.io.*;
import org.jdom2.Element;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

public class tmp {public static void main(String args[]) {
// xmlパース(jdom2)
try
{
  Document doc = new SAXBuilder().build( new File("test.xml") );
  Element root = doc.getRootElement();
  BufferedWriter bout = new BufferedWriter(new OutputStreamWriter(System.out));
  XMLOutputter out = new XMLOutputter();
  out.output(doc, bout);
}
catch (Exception e)
{
  System.out.println(e);
}
}}
*/


/*
import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class tmp extends DefaultHandler {
public void characters(char[] ch, int offset, int length)
{
  System.out.println("テキストデータ：" + new String(ch, offset, length));
}

public static void main(String args[]) {
// 割と面倒め
// xmlパース(sax)
try
{
  SAXParserFactory spfactory = SAXParserFactory.newInstance();
  SAXParser parser = spfactory.newSAXParser();
  // XMLファイルを指定されたデフォルトハンドラーで処理します
  parser.parse(new File("test.xml"), new tmp());
}
catch (Exception e)
{
  e.printStackTrace();
}
}}
*/


/*
// xmlパース(dom)
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class tmp {public static void main(String args[]) {

try
{
  DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
  DocumentBuilder builder = dbfactory.newDocumentBuilder();
  Document doc = builder.parse(new File("test.xml"));
  Element root = doc.getDocumentElement();
  System.out.println(root.getFirstChild().getNodeValue());
}
catch(Exception e)
{
  e.printStackTrace();
}
}}
*/



/*
public class tmp {public static void main(String args[]) {
// sbと+の速度の比較で多いほう

// +の場合
long start = System.currentTimeMillis();
int cnt = 0;
while (cnt < 100000)
{
String sql = "";
sql += " SELECT ";
sql += " TSV_ID, ";
sql += " COORDINAT_ID, ";
sql += " MAIL_ADDRESS_TO, ";
sql += " MAIL_ADDRESS_CC, ";
sql += " MAIL_ADDRESS_BCC, ";
sql += " LPAD(DELIVERY_TIME,6,0) DELIVERY_TIME, ";
sql += " MAIL_ADDRESS_FROM, ";
sql += " SUBJECT, ";
sql += " HEADER, ";
sql += " TEXT, ";
sql += " FOOTER ";
sql += " FROM ";
sql += " SEND_RANKING_MAIL_MANAGE ";
sql += " WHERE ";
sql += "  LPAD(DELIVERY_TIME,6,0) <=  ";
sql += " ORDER BY ";
sql += " TSV_ID ";
cnt++;
}
long end = System.currentTimeMillis();
long i = end - start;



// sbの場合
long startsb = System.currentTimeMillis();
int cntsb = 0;
while (cntsb < 100000)
{
StringBuilder sbl = new StringBuilder();
sbl.append(" SELECT ")
.append( " TSV_ID, ")
.append( " COORDINAT_ID, ")
.append( " MAIL_ADDRESS_TO, ")
.append( " MAIL_ADDRESS_CC, ")
.append( " MAIL_ADDRESS_BCC, ")
.append( " LPAD(DELIVERY_TIME,6,0) DELIVERY_TIME, ")
.append( " MAIL_ADDRESS_FROM, ")
.append( " SUBJECT, ")
.append( " HEADER, ")
.append( " TEXT, ")
.append( " FOOTER ")
.append(" FROM ")
.append( " SEND_RANKING_MAIL_MANAGE ")
.append(" WHERE ")
.append("  LPAD(DELIVERY_TIME,6,0) <=  ")
.append(" ORDER BY ")
.append( " TSV_ID ");
cntsb++;
}
long endsb = System.currentTimeMillis();
long isb = endsb - startsb;


System.out.println(i);
System.out.println(isb);
}}
*/


/*
public class tmp {
// junit4の試し書き
String yon(String aa){
  return aa;
}

public static void main(String args[]) {
}}
*/



/*
// java8記念 lambda式の試し書き
import java.util.function.Function;

public class tmp {public static void main(String args[]) {

Function<String, Integer> func = x -> 2;
System.out.println( func.apply("aa") );
}}
*/


/*
public class tmp {public static void main(String args[]) {
// replaceは非破壊メソッドだったという初歩的ミス
String reprep = "abcde";

reprep.replace("c","z");
System.out.println( reprep );
System.out.println( reprep.replace("c","z") );
}}
*/


/*
// 特定の文字に挟まれた文字を抽出する
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class tmp {public static void main(String args[]) {

String target = "jibsgoalbsjijibsmorebsij";

Pattern p =Pattern.compile("bs(.+?)bs");
Matcher m =p.matcher(target);

while(m.find()){
  System.out.println( m.group(1) );
}
}}
*/



/*
// gsonの確認
import java.io.*;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.stream.*;

public class tmp {
static class BagOfPrimitives {
  private int value1 = 1;
  private String value2 = "abc";
  private transient int value3 = 3;
  BagOfPrimitives() {
  }
}

public static void main(String args[]) {
Gson gson = new Gson();
BagOfPrimitives obj = new BagOfPrimitives();
System.out.println(gson.toJson( obj ));
}}
*/


/*
public class tmp {public static void main(String args[]) {
// 数字4文字10000回生成
java.util.HashSet<String> set = new java.util.HashSet<String>();

int random1 = 0;
int random2 = 0;
int random3 = 0;
int random4 = 0;
java.util.Random r = new java.util.Random();

int cnt = 0;
while (cnt < 10000)
{
  //System.out.println(cnt);
  random1 = r.nextInt(10);
  random2 = r.nextInt(10);
  random3 = r.nextInt(10);
  random4 = r.nextInt(10);
  set.add(String.valueOf(random1) + String.valueOf(random2) + String.valueOf(random3) + String.valueOf(random4));
  
  cnt++;
}

System.out.println(set.size());
}}
*/



/*
public class tmp {public static void main(String args[]) {
// 二ヶ月前を取得
java.util.Calendar now = java.util.Calendar.getInstance();
System.out.println(now);
now.add(java.util.Calendar.MONTH, -2);
System.out.println(now);
java.sql.Timestamp date = new java.sql.Timestamp(now.getTimeInMillis());
System.out.println(date);
}}
*/


/*
// Javaにおけるクロージャの例
import java.util.*;

interface Fn<A,B>
{
  B apply(A arg);
}

public class tmp {public static void main(String args[]) {
final int y = 2;
List<Integer> result = new Fn<Integer, Fn<Integer, List<Integer>>>()
{
  public Fn<Integer, List<Integer>> apply(final Integer y)
  {
    return new Fn<Integer, List<Integer>>()
    {
      public List<Integer> apply(final Integer x) { return Arrays.asList(x, y); }
    };
  }
}.apply(1).apply(0);

System.out.println(result); // => [0, 1]
}}
*/

/*
public class tmp {public static void main(String args[]) {
// 前置のインクリメントと後置のインクリメント
int i = 0;
i = i++ + ++i;
System.out.println(i);
}}
*/

/*
public class tmp {public static void main(String args[]) {
// java6以下ではエラーになる
String ext = "one";

final String one = "one";
final String two = "two";

switch (ext)
{
  case one:
      System.out.println("one");
  break;
  case two:
      System.out.println("two");
  break;
  default:
      System.out.println("default");
  break;
}
}}
*/

/*
public class tmp {public static void main(String args[]) {
// プリミティブ型でない参照型のShortではfinalをつけても定数にならないのでエラー
short ext = 1;

final Short one = 1;
final Short two = 2;

switch (ext)
{
  case one:
      System.out.println("one");
  break;
  case two:
      System.out.println("two");
  break;
}
}}
*/

/*
public class tmp {
// 参照型の確認
String plusplus(String str)
{
    String ret = str + "plus";
    return ret;
}

public static void main(String args[]) {
tmp teststr = new tmp();
System.out.println(teststr.plusplus("oomoto"));

}}
*/


/*
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class tmp {public static void main(String args[]) {

// logback
Logger logtest = LoggerFactory.getLogger("tmpp");
logtest.debug("Hello Logger");

//logtest.fatal("本当にやばいログ　　");
logtest.error("普通にやばいログ　　");
logtest.warn( "ちょっとやばいログ　");
logtest.info( "運用時に必要なログ　");
logtest.debug("開発時に必要なログ　");
logtest.trace("デスマ時に必要なログ");
}}
*/


/*
import org.apache.log4j.*;
// C:\github\jt\log4j-1.2.17.jar
public class tmp {public static void main(String args[]) {

// log4jからlogbackへ
org.apache.log4j.Logger logtest = org.apache.log4j.Logger.getLogger(tmp.class);
org.apache.log4j.BasicConfigurator.configure();
}}
*/


/*
public class tmp {public static void main(String args[]) {
// 配列
String[] strarr = null;
//strarr.add("anoano");

// 参照型の確認
StringBuilder sb = new StringBuilder().append("anokutara");
StringBuilder ref = new StringBuilder();
ref = sb;

System.out.println(sb);
System.out.println(ref);

ref.append("tuika");
ref.append("desudesu");
System.out.println(sb);
System.out.println(ref);

}}
*/

/*
public class tmp {public static void main(String args[]) {

// StringBufferとStringBuilder
StringBuilder sb = new StringBuilder();
sb.append("anokutara");
sb.append("sanmyaku");
System.out.println(sb);

StringBuffer sbuf = new StringBuffer();
sbuf.append("sanbodai");
sbuf.append("noumaku");
System.out.println(sbuf.toString());
}}
*/

/*
public class tmp {public static void main(String args[]) {

// primitive? or reference? 2
String stst = new String("asfdsdf");
String atoato = new String();
atoato = stst;
atoato = "henkou!";
System.out.println(stst);
System.out.println(atoato);
}}
*/

/*
public class tmp {public static void main(String args[]) {
// primitive? or reference?
String stst = "asfdsdf";
String atoato = stst;
atoato = "henkou!";
System.out.println(stst);
System.out.println(atoato);
}}
*/



/*
public class tmp {public static void main(String args[]) {
// コメントアウトテスト
System.out.println("testest"+ "arar");
}}
*/

