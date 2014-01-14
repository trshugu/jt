// junit-4.10.jar
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.Serializable;
import java.sql.Timestamp;
import jp..cmt.service.*;
import jp..cmt.entity.*;

// ムリだった
public class tmptest {

@Test public void legacyservi() {
  DWishlistIdTypeService cc = new DWishlistIdTypeService();
  assertNull( cc.registDate );
  assertTrue(true);
}

@Test public void legacytest() {
  CmtFixedPatternSchedule aa = new CmtFixedPatternSchedule();
  assertNull( aa.registDate );
  assertTrue(true);
}

@Test public void legacytest2() {
  CmtVShotChargeMsr bb = new CmtVShotChargeMsr();
  assertNull( bb.recochokuId );
  assertTrue(true);
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
