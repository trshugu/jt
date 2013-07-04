// junit-4.10.jar
import org.junit.Test;
import static org.junit.Assert.*;

public class tmptest {
/*
*/

// junit4系の書き方に修正
@Test public void newtest() {
  System.out.println( "newew" );
  tmp testsst = new tmp();
  assertEquals(1,1);
  assertEquals(testsst.yon("aa"),"aa");
}

@Test public void test_old() {
  System.out.println( "olodd" );
  tmp testsst = new tmp();
  assertEquals(1,1);
  assertEquals(testsst.yon("aa"),"aa");
}

/* 
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
*/

}
