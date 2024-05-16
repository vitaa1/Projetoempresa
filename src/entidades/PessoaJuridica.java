package entidades;

public class PessoaJuridica extends Pessoa {

	private Integer numeroDeFuncionarios;
	
	public PessoaJuridica () {
		super ();
	}
	
	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroDeFuncionarios) {
		super(nome, rendaAnual);
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	public Integer getNumeroDeFuncionarios() {
		return numeroDeFuncionarios;
	}

	public void setNumeroDeFuncionarios(Integer numeroDeFuncionarios) {
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	@Override
	public double imposto() {
		double soma1 = 0.0;
		if (getNumeroDeFuncionarios() > 10) {
			soma1 = getRendaAnual() * 14 / 100.0;
		} else {
			soma1 = getRendaAnual() * 16 / 100.0;
		}
		return soma1;
	}
	
}
