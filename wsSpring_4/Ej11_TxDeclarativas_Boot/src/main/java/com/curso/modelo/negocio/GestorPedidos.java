package com.curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.DetallePedido;
import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.persistencia.ClienteDAO;
import com.curso.modelo.persistencia.PedidoDAO;

@Service
public class GestorPedidos {
	
	
	@Autowired private ClienteDAO clienteDAO;
	@Autowired private PedidoDAO  pedidoDAO;

	@Autowired private GestorBancos      gestorBancos;
	@Autowired private GestorAlmacen     gestorAlmacen;
	@Autowired private GestorTransportes gestorTransportes;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void aceptar(Pedido pedido) throws Exception{
		
		//
		pedido = pedidoDAO.buscar(pedido.getId());		
		
		Cliente c = clienteDAO.buscar(pedido.getCliente().getId());
		gestorBancos.comprobarTarjetaCredito(c.getNumeroTC());
		
		for(DetallePedido dp:pedido.getDetalles()){
			gestorAlmacen.comprobarExistencias(dp.getProducto(), dp.getCantidad());
			gestorAlmacen.reducirExistencias(dp.getProducto(), dp.getCantidad());
		}
		
		String camion = gestorTransportes.reservarCamion(true);
		pedido.setCamion(camion);
		pedido.setEstado("Aceptado");
		pedidoDAO.modificar(pedido);
		
	}
	
}

/*
class TXAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		
		try{
			Object retorno = mi.proceed();
			
			if(isRollbackOnly()){
				tx.rollback();
			} else {
				tx.commit();
			}
		} catch(Exception e){		
			//tx.rollback();
		}
		return retorno;
	}

}
*/























































