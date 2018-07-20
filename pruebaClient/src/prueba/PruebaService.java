/**
 * PruebaService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package prueba;

public interface PruebaService extends javax.xml.rpc.Service {
    public java.lang.String getPruebaAddress();

    public prueba.Prueba getPrueba() throws javax.xml.rpc.ServiceException;

    public prueba.Prueba getPrueba(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
