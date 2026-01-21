package com.pberna.aad.ut4.classic;

public class TestEmpresaBD {
	 public static void main(String[] args) {
	        EmpresaBD empresaBD = new EmpresaBD();
	        
	        //CREATE
	        //empresaBD.insertarEmpleado();	
	        
	        //Info de la colección
	        //empresaBD.informacionColeccion("Empleados");	       
	        
	        //READ
	        //empresaBD.datosColeccion("Empleados");
	        //empresaBD.datosColeccionFiltrada("Empleados", "{departamento:20}");
	        //empresaBD.datosColeccionFiltrada("Empleados", "{categoria: { $exists: 1}}");
	        
	        
	        //UPDATE
	        //empresaBD.agregaCampoEmpleado();
	        //empresaBD.datosColeccion("Empleados");
	        
	        //DELETE
	        //empresaBD.borrarEmpleado();	
	        //empresaBD.datosColeccion("Empleados");
	        
	        //BUSCAR POR ID
	        //empresaBD.buscarEmpleadoPorId();
	        
	        
	        //CERRAR CONEXION
	        empresaBD.cerrarConexion();
	    }
}
