package org.bifrost 

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Query;
import scala.collection.JavaConversions._

object Data { 
  def writeExample() {
    val dss = DatastoreServiceFactory.getDatastoreService
    val test = new Entity("TestEntity")
    test.setProperty("type", "test")
    dss.put(test)
  }

  def readExample = { 
    val dss = DatastoreServiceFactory.getDatastoreService
    val q = dss.prepare(new Query("TestEntity"))
    q.asIterator.size
  }
}
