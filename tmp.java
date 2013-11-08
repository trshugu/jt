//import org.apache.commons.beanutils.BeanMap;
import java.util.*;
import org.apache.commons.lang3.tuple.*;
import org.seasar.framework.beans.util.BeanMap;
import org.seasar.framework.beans.util.BeanUtil;

public class tmp {
public static void main(String args[]) {
/*
*/






/*
// import org.apache.commons.beanutils.BeanMap;と
// import org.seasar.framework.beans.util.BeanMap;は
// 挙動が違う(putがつかえん)
//List<BeanMap> checkList = new ArrayList<BeanMap>();
//HashMap<String, Object> excelmap = null;

//BeanMap bm = Beans.createAndCopy(BeanMap.class, "aaa").execute();

BeanMap setMap = new BeanMap();
setMap.put("test", "asdf");
//Beans a = new Beans("test");
//setMap.setBean(a);
//Beans b = new Beans();
//b.set("test", "objext");
//checkList.add(setMap);

//for (BeanMap bp : checkList){
  //System.out.println( setMap.get("test") );
  System.out.println( setMap.keySet() );
//}

System.out.println( setMap.size() );


//excelmap = new HashMap<String, Object>();
//excelmap.put("checkList", checkList);
//for (Map.Entry<String, Object> e : excelmap.entrySet()) {
//  //System.out.println( "key=" + e.getKey() + ", value=" + e.getValue() );
//}
*/


/*
// nullという文字が出力されるその2
System.out.println( "asdf" + null );

StringBuilder sb = new StringBuilder();
sb.append("asdf");
sb.append("asdf");
sb.append((String)null); // Stringをキャストすれば入る
System.out.println( sb );
*/


/*
// try-with-resources Statement
try (BufferedReader br =  new BufferedReader(new FileReader("./test.xml"))) 
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
*/

/*
// nullという文字が出力される
String aa = "asdf{0}";
MessageFormat f = new MessageFormat(aa);
String bb = f.format(new String[]{null} );

System.out.println( bb );
*/

/*
// n個までのイテレーションはforeachではダメか・・・
ArrayList<String> l = new ArrayList<String>();
l.add("adsf");
l.add("cccc");
l.add("eeeree");

//Iterator<String> i = l.iterator();
//for(int x = 0; i.hasNext() && x < 2; x++){
//  System.out.println( i.next() );
//}

for(String s : l.subList(0,6)){
  System.out.println( s );
}
*/



/*
// Unicode半角カタカナのコード範囲か？
String test = "ｲest";
Character oo = test.charAt(0);
boolean a = (oo instanceof Character);
System.out.println( oo.compareTo(new Character((char)0xff66)) );
*/


/*
// 計算機
enum Operator { Plus, Minus, Multiplication, Division ;}

public int Matchstick(int i){
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

public int kalk(int x, int y, Operator operator) {
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

*/




/*
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import javax.xml.xpath.*;

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
*/


/*
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

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
*/




/*
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

// dom4j
Document document = DocumentHelper.createDocument();
Element root = document.addElement( "messages" );
Element me = root.addElement( "message" ).addAttribute( "attr", "A message" ).addText( "message" );
System.out.println(root);
*/

/*
import java.io.*;
import org.jdom.Element;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

// xmlパース(json)ない
try
{
  Document doc = new SAXBuilder().build( new File("test.xml") );
  Element root = doc.getRootElement();
}
catch (JDOMException e)
{
  System.out.println(e);
}
*/


/*
import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
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

public void characters(char[] ch, int offset, int length)
{
  System.out.println("テキストデータ：" + new String(ch, offset, length));
}
*/

/*
// xmlパース(dom)
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
*/

/*
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
*/

/*
// junit4の試し書き
String yon(String aa){
  return aa;
}
*/

/*
// java8記念 lambda式の試し書き
import java.util.function.Function;

Function<String, Integer> func = x -> 2;
System.out.println( func.apply("aa") );
*/


/*
// replaceは非破壊メソッドだったという初歩的ミス
String reprep = "abcde";

reprep.replace("c","z");
System.out.println( reprep );
System.out.println( reprep.replace("c","z") );
*/

/*
// 特定の文字に挟まれた文字を抽出する
import java.util.regex.Pattern;
import java.util.regex.Matcher;

String target = "jibsgoalbsjijibsmorebsij";

Pattern p =Pattern.compile("bs(.+?)bs");
Matcher m =p.matcher(target);

while(m.find()){
  System.out.println( m.group(1) );
}
*/

/*
// gsonの確認
import java.io.*;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.stream.*;

static class BagOfPrimitives {
  private int value1 = 1;
  private String value2 = "abc";
  private transient int value3 = 3;
  BagOfPrimitives() {
  }
}

Gson gson = new Gson();
BagOfPrimitives obj = new BagOfPrimitives();
System.out.println(gson.toJson( obj ));
*/


/*
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
*/


/*
// 二ヶ月前を取得
java.util.Calendar now = java.util.Calendar.getInstance();
System.out.println(now);
now.add(java.util.Calendar.MONTH, -2);
System.out.println(now);
java.sql.Timestamp date = new java.sql.Timestamp(now.getTimeInMillis());
System.out.println(date);
*/

/*
import java.util.*;

interface Fn<A,B>
{
	B apply(A arg);
}

// Javaにおけるクロージャの例
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
*/


/*
// 前置のインクリメントと後置のインクリメント
int i = 0;
i = i++ + ++i;
System.out.println(i);
*/

/*
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
*/

/*
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
*/


/* 
// 参照型の確認

String plusplus(String str)
{
		String ret = str + "plus";
		return ret;
}

tmp teststr = new tmp();
System.out.println(teststr.plusplus("oomoto"));
*/


/*
// logback
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

Logger logtest = LoggerFactory.getLogger("tmpp");
logtest.debug("Hello Logger");

//logtest.fatal("本当にやばいログ　　");
logtest.error("普通にやばいログ　　");
logtest.warn( "ちょっとやばいログ　");
logtest.info( "運用時に必要なログ　");
logtest.debug("開発時に必要なログ　");
logtest.trace("デスマ時に必要なログ");
*/


/* 
// log4jからlogbackへ
import org.apache.log4j.*;
// C:\github\jt\log4j-1.2.17.jar
org.apache.log4j.Logger logtest = org.apache.log4j.Logger.getLogger(tmp.class);
org.apache.log4j.BasicConfigurator.configure();
*/


/* 
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
*/


/* 
// StringBufferとStringBuilder
StringBuilder sb = new StringBuilder();
sb.append("anokutara");
sb.append("sanmyaku");
System.out.println(sb);

StringBuffer sbuf = new StringBuffer();
sbuf.append("sanbodai");
sbuf.append("noumaku");
System.out.println(sbuf.toString());
*/


/* 
// primitive? or reference? 2
String stst = new String("asfdsdf");
String atoato = new String();
atoato = stst;
atoato = "henkou!";
System.out.println(stst);
System.out.println(atoato);
*/


/* 
// primitive? or reference?
String stst = "asfdsdf";
String atoato = stst;
atoato = "henkou!";
System.out.println(stst);
System.out.println(atoato);
*/

/* 
// コメントアウトテスト
System.out.println("testest"+ "arar");
*/
}


}

