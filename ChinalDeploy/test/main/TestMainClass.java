package main;

import com.chinal.db.ChinalMySqlDialet;

public class TestMainClass {

	public static void main(String[] args){
		ChinalMySqlDialet chinalMySqlDialet = new ChinalMySqlDialet();
		System.out.println(chinalMySqlDialet.getTableTypeString());
	}
}
