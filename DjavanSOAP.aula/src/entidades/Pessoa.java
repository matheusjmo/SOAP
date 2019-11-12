package entidades;

public class Pessoa {

	private String nome;
	private String cpf;
	private String sexo;
	private int idade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
	@Override
	public boolean equals(Object obj) {
	
		Pessoa pessoaEntrada = (Pessoa)obj;
		
		if(	 pessoaEntrada != null 
		  && pessoaEntrada.getCpf() != null 
		  && !pessoaEntrada.getCpf().isEmpty()) {
			
			if(pessoaEntrada.getCpf()
					.equals(this.cpf) == true) {
				return true;
			}else {
				return false;
			}
//return pessoaEntrada.getCpf().equals(this.cpf) == true ? true : false;
		}else {
			return false;
		}
	}
	
}
