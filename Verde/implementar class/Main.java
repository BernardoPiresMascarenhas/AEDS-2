import java.util.Scanner;

class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();

		Jogadores jogadores[] = new Jogadores[14];
		int k = 0;

		while(!line.equals("FIM")){
			Jogadores j = new Jogadores();

			j.ler(line);
			jogadores[k++] = j;	
			
			line = sc.nextLine();
		}
		insertion(jogadores, k);


		for (int i = 0; i < k; i++) {
			jogadores[i].imprimir();
		}

		sc.close();
	}

	public static void insertion(Jogadores[] array, int n) {
		for (int i = 1; i < n; i++) {
			Jogadores pivo = array[i];
			int j = i-1;

			while (j >= 0 && array[j].id > pivo.id) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = pivo;
		}
	}
}

class Date {
	String dia;
	String mes;
	String ano;
}

class Jogadores {
	public String nome;
	public String foto;
	public Date nascimento;
	public int id;
	public int[] times;

	public void imprimir() {
		System.out.print(this.id + " " + this.nome + " " + this.nascimento.dia + "/" + this.nascimento.mes + "/"
				+ this.nascimento.ano + " " + this.foto + " " + "(");
		for (int i = 0; i < times.length - 1; i++) {
			System.out.print(times[i] + ", ");
		}
		System.out.println(times[times.length - 1] + ")");
	}

	public void ler(String input) {
		int i = 0;
		String index = separar(input, i, ',');
		i += index.length() + 1;
		this.nome = separar(input, i, ',');
		i += nome.length() + 1;
		this.foto = separar(input, i, ',');
		i += foto.length() + 1;
		this.nascimento = new Date();
		this.nascimento.dia = separar(input, i, '/');
		i += nascimento.dia.length() + 1;
		this.nascimento.mes = separar(input, i, '/');
		i += nascimento.mes.length() + 1;
		this.nascimento.ano = separar(input, i, ',');
		i += nascimento.ano.length() + 1;
		index = separar(input, i, ',');
		i += index.length() + 1;
		String idString = separar(input, i, ',');
		this.id = Integer.parseInt(idString);
		i += idString.length() + 1;
		int n = contarTimes(input, i);
		if (input.charAt(i) == '"')
			i += 2;
		else
			i++;
		this.times = new int[n];
		for (int j = 0; j < n - 1; j++) {
			String timeString = separar(input, i, ',');
			this.times[j] = Integer.parseInt(timeString);
			i += timeString.length() + 2;
		}
		String timeString = separar(input, i, ']');
		this.times[n - 1] = Integer.parseInt(timeString);
	}

	public String separar(String input, int i, char delimiter) {
		String stringer = "";
		while (input.charAt(i) != delimiter) {
			stringer += input.charAt(i);
			i++;
		}
		return stringer;
	}

	public int contarTimes(String input, int i) {
		int times = 1;
		while (input.charAt(i) != ']') {
			if (input.charAt(i) == ',') {
				times++;
			}
			i++;
		}
		return times;
	}
}