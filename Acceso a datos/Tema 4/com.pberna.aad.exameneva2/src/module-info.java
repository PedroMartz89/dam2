/**
 * 
 */
/**
 * 
 */
module com.pberna.aad.exameneva {
	requires org.hibernate.orm.core;
	requires jakarta.persistence;
	requires java.naming;
    requires java.sql;
	opens com.pberna.aad.exameneva2.data.pojos to org.hibernate.orm.core;
	requires org.mongodb.driver.sync.client;
	requires org.mongodb.bson;
	requires org.mongodb.driver.core;
}