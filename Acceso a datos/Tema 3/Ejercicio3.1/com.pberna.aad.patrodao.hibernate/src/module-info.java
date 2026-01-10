/**
 * 
 */
/**
 * 
 */
module com.pberna.aad.patrodao.hibernate {
	requires org.hibernate.orm.core;
	requires jakarta.persistence;	
	
	opens com.pberna.aad.patrodao.hibernate.data.model to
	    org.hibernate.orm.core;
}