import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {
	public static void main(String[] args) throws ParseException {
		Scanner in = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Entre com o nome do Departamento: ");
		String depName = in.next();
		System.out.println("Entre com os dados do trabalhador: ");
		System.out.println("Name: ");
		String workName = in.next();
		System.out.println("Level: ");
		String workLev = in.next();
		System.out.println("Salario Base: ");
		double basSal = in.nextDouble();
		Worker worker = new Worker(workName, WorkerLevel.valueOf(workLev), basSal, new Department(depName));
		
		System.out.println("Quantos contratos: ");
		int n  = in.nextInt();
		
		for(int i = 0; i<n; i++) {
			System.out.println("Entre com a data do contrato #"+ i + ": ");
			System.out.println("Data (DD/MM/AAAA):");
			Date contractDate = sdf.parse(in.next());
			System.out.println("Valor por hora: ");
			double valHou = in.nextDouble();
			System.out.println("Duration (hours): ");
			int hou = in.nextInt();
			HourContract contr = new HourContract(contractDate, valHou, hou);
			worker.addContr(contr);
			
		}
		System.out.println("");
		System.out.println("Entre com o mes e ano para calcular a renda: (MM/AAAA)");
		String monthAndYear = in.next();
		int mon = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Nome: "+ worker.getName());
		System.out.println("Departamento: "+ worker.getDepart().getName());
		System.out.println("Renda para "+ monthAndYear+ ": " + worker.income(year, mon));
	}
}
