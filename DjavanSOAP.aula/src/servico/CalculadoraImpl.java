package servico;

import javax.jws.WebService;

import entidades.RetornoSoap;

@WebService(endpointInterface = "servico.Calculadora")
public class CalculadoraImpl implements Calculadora{

	@Override
	public RetornoSoap somar(double valor1, double valor2) {
		RetornoSoap retorno = new RetornoSoap();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemRetorno("SUCESSO!!!");
		retorno.setValorRetorno(valor1 + valor2);
		return retorno;
	}

	@Override
	public RetornoSoap subtrair(double valor1, double valor2) {
		RetornoSoap retorno = new RetornoSoap();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemRetorno("SUCESSO!!!");
		retorno.setValorRetorno(valor1 - valor2);
		return retorno;
	}

	@Override
	public RetornoSoap multiplicar(double valor1, double valor2) {
		RetornoSoap retorno = new RetornoSoap();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemRetorno("SUCESSO!!!");
		retorno.setValorRetorno(valor1 * valor2);
		return retorno;
	}

	@Override
	public RetornoSoap dividir(double valor1, double valor2) {
		RetornoSoap retorno = new RetornoSoap();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemRetorno("SUCESSO!!!");
		
		if(valor2 == 0) {
			retorno.setCodigoRetorno(1);
			retorno.setMensagemRetorno("FALHA: Divisor não pode ser Zero!");
		}else {
			retorno.setValorRetorno(valor1 / valor2);
		}
		
		return retorno;
	}

	
	
}
