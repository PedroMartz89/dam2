/**
 * 
 */
/**
 * 
 */
module com.pberna.aad.exameneva2 {
	requires org.hibernate.orm.core;
	requires jakarta.persistence;
	opens com.pberna.aad.exameneva2.data.pojos to org.hibernate.orm.core;
	requires org.mongodb.driver.sync.client;
	requires org.mongodb.bson;
	requires org.mongodb.driver.core;
}