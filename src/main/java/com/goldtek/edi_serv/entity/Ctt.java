package com.goldtek.edi_serv.entity;

public class Ctt {
	private String CTT01;//IT1 段的總行數。

	public String getCTT01() {
		return CTT01;
	}

	public void setCTT01(String cTT01) {
		CTT01 = cTT01;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("CTT*");

		if (CTT01 != null)
			sb.append(CTT01);
		
		sb.append("~");
		return sb.toString();
	}
}
