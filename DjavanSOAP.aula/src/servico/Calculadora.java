package servico;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import entidades.RetornoSoap;

@WebService
@SOAPBinding(style = Style.RPC)
public interface Calculadora {
	@WebMethod
	public RetornoSoap somar(double valor1, double valor2);
	@WebMethod
	public RetornoSoap subtrair(double valor1, double valor2);
	@WebMethod
	public RetornoSoap multiplicar(double valor1, double valor2);
	@WebMethod
	public RetornoSoap dividir(double valor1, double valor2);
}
