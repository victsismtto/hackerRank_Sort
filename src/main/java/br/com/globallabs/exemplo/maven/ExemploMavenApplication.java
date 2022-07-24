package br.com.globallabs.exemplo.maven;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class ExemploMavenApplication {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String size_list = in.nextLine();
		Integer size_number = Integer.parseInt(size_list);
		Integer[] id_array = new Integer[size_number];
		String[] name_array = new String[size_number];
		Double[] grade_array = new Double[size_number];
		String[] name = new String[size_number];
		Integer contador = 0;
		Double maior = 0.0;
		Integer contador_primeiro = 0;
		Integer position = 0;
		String nome = null;

		while (contador < size_number) {
			String student = in.nextLine();
			String[] numbers_string = student.split(" ");
			id_array[contador] = Integer.parseInt(numbers_string[0]);
			name_array[contador] = numbers_string[1];
			grade_array[contador] = Double.parseDouble(numbers_string[2]);
			Integer contador_repitido = 0;
			contador++;
		}

		contador = 0;
		while (contador < id_array.length) {
			contador_primeiro = 0;
			for (int i  = 0; i < id_array.length; i++) {
				if (grade_array[i] != null) {
					if ( contador_primeiro == 0) {
						maior = grade_array[i];
						nome = name_array[i];
						position = i;
						contador_primeiro++;
					} else {
						if (Double.compare(grade_array[i], maior) == 0) {
							String[] ordem = new String[2];
							ordem[0] = nome;
							ordem[1] = name_array[i];
							Integer position_novo = i;
							Arrays.sort(ordem);
							if (ordem[0].equals(name_array[i])) {
								nome = ordem[0];
								position = position_novo;
								maior = grade_array[i];
							}
						} else {
							if (Double.compare(grade_array[i], maior) > 0) {
								nome = name_array[i];
								maior = grade_array[i];
								position = i;
							}
						}
					}
				}
			}
			name[contador] = nome;
			grade_array[position] = null;
			contador++;
		}

		for (int i  = 0; i < name.length; i++) {
			System.out.println(name[i]);
		}

	}
}
