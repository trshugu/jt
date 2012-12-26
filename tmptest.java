// junit-4.10.jar
import junit.framework.*;

public class tmptest extends TestCase {

public tmptest(String str) {
	super(str);
}

/* 
// jUnit導入
*/

public void test_わかりやすい名前() {
  String strin = "ano";
  String strout = "anoplus";
  tmp testsst = new tmp();
  
  String test1 = testsst.plusplus(strin);
  assertEquals("ダメ", strout, test1);
}

public void test_わかりやすい名前弐() {
  String strin = "";
  String strout = "plus";
  tmp testsst = new tmp();
  
  String test1 = testsst.plusplus(strin);
  assertEquals(strout, test1);
}

public void test_aaa() {
  String strin = "";
  String strout = "plus";
  tmp testsst = new tmp();
  
  String test1 = testsst.plusplus(strin);
  assertEquals("ダメ", strout, test1);
}

}
