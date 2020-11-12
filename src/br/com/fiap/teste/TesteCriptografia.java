package br.com.fiap.teste;

import br.com.fiap.util.CriptografiaUtils;

public class TesteCriptografia {

	public static void main(String[] args) {

		try {
			System.out.println(CriptografiaUtils.criptografar("henrique"));
			System.out.println(CriptografiaUtils.criptografar("123456"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
