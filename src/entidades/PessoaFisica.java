package entidades;

public class PessoaFisica extends Pessoa {
	private Double gastosComSaude;
	
	public PessoaFisica () {
		super ();
	}
	
	public PessoaFisica(String nome, Double rendaAnual, Double gastosComSaude) {
		super(nome, rendaAnual);
		this.gastosComSaude = gastosComSaude;
	}
	
	public Double getGastosComSaude() {
		return gastosComSaude;
	}

	public void setGastosComSaude(Double gastosComSaude) {
		this.gastosComSaude = gastosComSaude;
	}

	@Override
	public double imposto() {
		double soma = 0.0;
		if (getRendaAnual() < 20000.0) {
			soma = getRendaAnual() * 15 / 100.0;
		} else {
			soma = getRendaAnual() * 25 / 100.0;
		}
		
		soma = soma - (getGastosComSaude() * 50 / 100.0);
		
		if (soma == 0.0) {
			return 0.0;
		} else {
			return soma;
		}
	}
}
