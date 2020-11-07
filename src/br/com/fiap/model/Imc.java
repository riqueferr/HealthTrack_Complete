package br.com.fiap.model;

import java.text.DecimalFormat;
import java.util.Calendar;

public class Imc {
	
    private static Integer s = 0;
	private Integer idImc;
	private Double valor;
	private Calendar dtCadastro;
	private Double peso;
	private Double altura;
	private Integer idUsuario;




    

    public Imc() {
    }

    public Imc(Integer idImc, Double valor, Calendar dtCadastro, Double peso, Double altura, Integer idUsuario) {
	super();
	this.idImc = idImc;
	this.valor = valor;
	this.dtCadastro = dtCadastro;
	this.peso = peso;
	this.altura = altura;
	this.idUsuario = idUsuario;
}

	public static Integer getS() {
        return s;
    }

    public static void setS(Integer s) {
        Imc.s = s;
    }
    
    public Integer getIdImc() {
		return idImc;
	}

	public void setIdImc(Integer idImc) {
		this.idImc = idImc;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Calendar getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Calendar dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void calcular() {
        double imc = this.peso / (this.altura * this.altura);
        System.out.printf("IMC: %.2f \n", imc);
        if(imc > 18.5 && imc < 25) {
            System.out.println("Legal, seu peso está NORMAL!!!");
        }else if(imc >= 25 && imc < 30) {
            System.out.println("Opa, você está com SOBREPESO!!!");
        }else if(imc >= 30 && imc < 35) {
            System.out.println("Amigão, e aí? OBESIDADE GRAU I!!!");
        }else if(imc >= 35 && imc < 40) {
            System.out.println("As coisas estão complicadas, você está com OBESIDADE GRAU II!!!");
        }else if(imc >= 40) {
            System.out.println("Pô, OBESIDADE GRAU III? Agora complicou muito :(");
        }else{
            System.out.println("Vamos se alimentar corretamente! Você está ABAIXO DO PESO");
        }
    }

    public Integer contador() {
        this.idImc =+ s++;
        return this.getIdImc();
    }

    public String toString() {
        DecimalFormat imc = new DecimalFormat("#,###.00");
        return "Objeto " + this.contador() + " - Altura: " + this.altura + " - Peso: " +
                this.peso + ". O IMC é " +
                imc.format(this.peso / (this.altura * this.altura));
    }
}
