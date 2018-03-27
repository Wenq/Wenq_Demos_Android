package com.wenq.model;

public class EmployeeModel {

	public String name;
	public int age;

	private static int Leng = 8; // name属性值保留8个byte

	public EmployeeModel(String name, int age) {
		if (name.length() > Leng) {
			name = name.substring(0, Leng);
		} else if (name.length() < Leng) {

			while (name.length() < Leng)
				name = name + "\u0000"; // \u0000代表的应该是NULL,输出控制台是一个空格
		}

		this.name = name;
		this.age = age;
	}

}
