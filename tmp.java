public class tmp {

public static void main(String args[]){
/*
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

