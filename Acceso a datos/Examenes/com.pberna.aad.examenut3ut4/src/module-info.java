/**
 * 
 */
/**
 * 
 */
module com.pberna.aad.examenut3ut4 {
	requires org.hibernate.orm.core;
	requires jakarta.persistence;
	opens com.pberna.aad.examenut3ut4.data.model to org.hibernate.orm.core;
	requires org.mongodb.driver.sync.client;
	requires org.mongodb.bson;
	requires org.mongodb.driver.core;
}