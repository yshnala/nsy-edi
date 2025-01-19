package com.goldtek.edi_serv.entity;

public class Tds {
	private String TDS01;//總金額

	public String getTDS01() {
		return TDS01;
	}

	public void setTDS01(String tDS01) {
		TDS01 = tDS01;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("TDS*");

		if (TDS01 != null)
			sb.append(TDS01).append("*");
	
		sb.append("~");
		return sb.toString();
	}
}
