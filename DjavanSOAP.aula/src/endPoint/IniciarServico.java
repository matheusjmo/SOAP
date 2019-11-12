package endPoint;

import javax.xml.ws.Endpoint;

import servico.CadastroPessoaImpl;

public class IniciarServico {

	public static void main(String[] args) {
		
//		Endpoint.publish(
//				"http://localhost:8085/DjavanSOAP/Calculadora", 
//		new CalculadoraImpl());
		
		Endpoint.publish(
				"http://localhost:8085/DjavanSOAP/CadastroPessoa", 
		new CadastroPessoaImpl());
		
		System.out.println("Serviço publicado com sucesso");
	}

}
