package servico;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import entidades.Pessoa;
import entidades.RetornoPessoa;

@WebService(endpointInterface = "servico.CadastroPessoa")
public class CadastroPessoaImpl implements CadastroPessoa {

	private List<Pessoa> listaPessoas = new ArrayList<Pessoa>();

	/**
	 * Metodo utilizado para varrer uma lista e recuperar a pessoa com o mesmo cpf
	 * preenchido internamente
	 * 
	 * @param pessoa
	 * @return Pessoa
	 *
	 */
	private String preencher(Pessoa pessoa) {
		String preenchido = null;
		if (pessoa.getCpf() != null) {
			preenchido = "C";
			if (pessoa.getNome() != null) {
				preenchido = "N";
				if (pessoa.getIdade() != 0) {
					preenchido = "NI";
					if (pessoa.getSexo() != null) {
						preenchido = "NIS";
					}
				}
				if (pessoa.getSexo() != null) {
					preenchido = "NS";
				}
			} else if (pessoa.getIdade() != 0) {
				preenchido = "I";
				if (pessoa.getSexo() != null) {
					preenchido = "IS";
				}
			}
		}
		return preenchido;
	}

	private Pessoa buscarPessoa(Pessoa pessoa) {

		int index = this.listaPessoas.indexOf(pessoa);

		if (index != -1) {
			return this.listaPessoas.get(index);
		} else {
			return null;
		}
	}

	@Override
	public RetornoPessoa inserirPessoa(Pessoa pessoa) {
		RetornoPessoa retorno = new RetornoPessoa();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemRetorno("SUCESSO!!");

		if (buscarPessoa(pessoa) == null) {
			this.listaPessoas.add(pessoa);
		} else {
			retorno.setCodigoRetorno(1);
			retorno.setMensagemRetorno("FALHA: Pessoa já existe!!");
		}

		return retorno;
	}

	@Override
	public RetornoPessoa alterarPessoa(Pessoa pessoa) {
		RetornoPessoa retorno = new RetornoPessoa();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemRetorno("SUCESSO!!");

		Pessoa pessoaExiste = buscarPessoa(pessoa);

		if (pessoaExiste != null) {
			pessoaExiste.setNome(pessoa.getNome());
			pessoaExiste.setIdade(pessoa.getIdade());
			pessoaExiste.setSexo(pessoa.getSexo());
		} else {
			retorno.setCodigoRetorno(1);
			retorno.setMensagemRetorno("FALHA: Pessoa não existe!!!");
		}

		return retorno;
	}

	@Override
	public RetornoPessoa removerPessoa(Pessoa pessoa) {
		RetornoPessoa retorno = new RetornoPessoa();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemRetorno("SUCESSO!!");

		Pessoa pessoaExiste = buscarPessoa(pessoa);

		if (pessoaExiste != null) {
			listaPessoas.remove(pessoaExiste);
		} else {
			retorno.setCodigoRetorno(1);
			retorno.setMensagemRetorno("FALHA: Pessoa não existe!!!");
		}

		return retorno;
	}

	@Override
	public RetornoPessoa pesquisarPessoa(Pessoa pessoa) {
		RetornoPessoa retorno = new RetornoPessoa();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemRetorno("SUCESSO!!");

		String pessoaBuscar = preencher(pessoa);

		if (pessoaBuscar != null) {
			for (Pessoa pessoaLista : listaPessoas) {
				if (pessoaBuscar.equals("N")) {
					if (pessoa.getNome().toUpperCase().contains(pessoaLista.getNome())) {
						retorno.getListaPessoas().add(pessoa);
					}
				}
				if (pessoaBuscar.equals("I")) {
					if (pessoa.getIdade() <= pessoaLista.getIdade()) {
						retorno.getListaPessoas().add(pessoa);
					}
				}
				if (pessoaBuscar.equals("S")) {
					if (pessoa.getSexo().toUpperCase().contains(pessoaLista.getNome())) {
						retorno.getListaPessoas().add(pessoa);
					}
				}
				if (pessoaBuscar.equals("NI")) {
					if (pessoa.getIdade() <= pessoaLista.getIdade()
							&& pessoa.getNome().toUpperCase().contains(pessoaLista.getNome())) {
						retorno.getListaPessoas().add(pessoa);
					}
				}
				if (pessoaBuscar.equals("NS")) {
					if (pessoa.getSexo().toUpperCase().contains(pessoaLista.getNome())
							&& pessoa.getNome().toUpperCase().contains(pessoaLista.getNome())) {
						retorno.getListaPessoas().add(pessoa);
					}
				}
				if (pessoaBuscar.equals("IS")) {
					if (pessoa.getIdade() <= pessoaLista.getIdade()
							&& pessoa.getSexo().toUpperCase().contains(pessoaLista.getNome())) {
						retorno.getListaPessoas().add(pessoa);
					}
				}
				if (pessoaBuscar.equals("NIS")) {
					if (pessoa.getIdade() <= pessoaLista.getIdade()
							&& pessoa.getNome().toUpperCase().contains(pessoaLista.getNome())
							&& pessoa.getSexo().toUpperCase().contains(pessoaLista.getNome())) {
						retorno.getListaPessoas().add(pessoa);
					}
				}
			}
		}
		return retorno;
	}

	@Override
	public RetornoPessoa recuperarTodos() {
		RetornoPessoa retorno = new RetornoPessoa();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemRetorno("SUCESSO!!");
		retorno.setListaPessoas(listaPessoas);

		return retorno;
	}
}
