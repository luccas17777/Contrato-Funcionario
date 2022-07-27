package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;
	private double basSal;
	
	private Department depart; //associação de um trabalhador para um departamento.
	private List<HourContract> contracts = new ArrayList<>(); /*associação de um trabalhador para vários contratos. 
	Quando tivermos uma associacao para varios se representa com uma lista (list) */
	
	public Worker(String name, WorkerLevel level, double basSal, Department depart) {
		this.name = name;
		this.level = level;
		this.basSal = basSal;
		this.depart = depart;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public double getBasSal() {
		return basSal;
	}

	public void setBasSal(double basSal) {
		this.basSal = basSal;
	}

	public Department getDepart() {
		return depart;
	}

	public void setDepart(Department depart) {
		this.depart = depart;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}
	
	public void addContr(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removContr(HourContract contract) {
		contracts.remove(contract);
	}
	
	public double income(int year, int month) {
		double sum = basSal;
		Calendar cal = Calendar.getInstance();
		for(HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1+ cal.get(Calendar.MONTH);
			if( year == c_year && month == c_month) {
				sum += c.totVal();
			}
		}
		return sum;
	}
	
	
	
}
