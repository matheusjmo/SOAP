package servico;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import entidades.Pessoa;
import entidades.RetornoPessoa;

@WebService
@SOAPBinding(style = Style.RPC)
public interface CadastroPessoa {
	@WebMethod
	public RetornoPessoa inserirPessoa(Pessoa pessoa);
	@WebMethod
	public RetornoPessoa alterarPessoa(Pessoa pessoa);
	@WebMethod
	public RetornoPessoa removerPessoa(Pessoa pessoa);
	@WebMethod
	public RetornoPessoa pesquisarPessoa(Pessoa pessoa);
	@WebMethod
	public RetornoPessoa recuperarTodos();
}
