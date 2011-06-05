package org.bifrost.tests

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

@RunWith(classOf[JUnitRunner]) 
class SimpleTest extends Spec with ShouldMatchers { 
  import org.bifrost.Data
  val helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig);
  helper.setUp

  it("datastore") { 
    Data.writeExample
    Data.readExample should equal(1)
  }
}
