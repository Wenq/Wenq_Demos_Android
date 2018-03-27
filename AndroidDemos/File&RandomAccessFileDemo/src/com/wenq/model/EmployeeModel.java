package com.wenq.model;

public class EmployeeModel {

	public String name;
	public int age;

	private static int Leng = 8; // name����ֵ����8��byte

	public EmployeeModel(String name, int age) {
		if (name.length() > Leng) {
			name = name.substring(0, Leng);
		} else if (name.length() < Leng) {

			while (name.length() < Leng)
				name = name + "\u0000"; // \u0000�����Ӧ����NULL,�������̨��һ���ո�
		}

		this.name = name;
		this.age = age;
	}

}
