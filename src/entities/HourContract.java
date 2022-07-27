package entities;

import java.util.Date;

public class HourContract {
	private Date date;
	private Double valHou;
	private Integer hou;
	
	public HourContract(Date date, Double valHou, Integer hou) {
		this.date = date;
		this.valHou = valHou;
		this.hou = hou;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getValHou() {
		return valHou;
	}
	public void setValHou(Double valHou) {
		this.valHou = valHou;
	}
	public Integer getHou() {
		return hou;
	}
	public void setHou(Integer hou) {
		this.hou = hou;
	}
	
	public double totVal() {
		return valHou * hou;
	}
	
}
