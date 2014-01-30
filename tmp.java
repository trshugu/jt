/*
public class tmp {public static void main(String args[]) {
}}
*/



/*
*/
public class tmp {public static void main(String args[]) {
  Integer i = 3;
  System.out.println(i.hashCode());
}}


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
java.util.HashSet set = new java.util.HashSet();

int random1 = 0;
int random2 = 0;
int random3 = 0;
int random4 = 0;
java.util.Random r = new java.util.Random();

int cnt = 0;
while (cnt < 10000)
{
  System.out.println(cnt);
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

