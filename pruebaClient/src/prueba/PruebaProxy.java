package prueba;

public class PruebaProxy implements prueba.Prueba {
  private String _endpoint = null;
  private prueba.Prueba prueba = null;
  
  public PruebaProxy() {
    _initPruebaProxy();
  }
  
  public PruebaProxy(String endpoint) {
    _endpoint = endpoint;
    _initPruebaProxy();
  }
  
  private void _initPruebaProxy() {
    try {
      prueba = (new prueba.PruebaServiceLocator()).getPrueba();
      if (prueba != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)prueba)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)prueba)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (prueba != null)
      ((javax.xml.rpc.Stub)prueba)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public prueba.Prueba getPrueba() {
    if (prueba == null)
      _initPruebaProxy();
    return prueba;
  }
  
  public java.lang.String hola(java.lang.String nombre) throws java.rmi.RemoteException{
    if (prueba == null)
      _initPruebaProxy();
    return prueba.hola(nombre);
  }
  
  
}