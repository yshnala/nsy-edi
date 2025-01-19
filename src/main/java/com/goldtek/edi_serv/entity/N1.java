package com.goldtek.edi_serv.entity;

public class N1 {
	private String N101;//標識業務實體的類型
	private String N102;//業務實體的名稱，例如公司名稱或機構名稱。	
	private String N103;//指示標識碼的類型
	private String N104;//用於唯一標識業務實體的代碼
	public String getN101() {
		return N101;
	}
	public void setN101(String n101) {
		N101 = n101;
	}
	public String getN102() {
		return N102;
	}
	public void setN102(String n102) {
		N102 = n102;
	}
	public String getN103() {
		return N103;
	}
	public void setN103(String n103) {
		N103 = n103;
	}
	public String getN104() {
		return N104;
	}
	public void setN104(String n104) {
		N104 = n104;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("N1*");

		if (N101 != null)
			sb.append(N101).append("*");
		if (N102 != null)
			sb.append(N102).append("*");
		if (N103 != null)
			sb.append(N103).append("*");
		if (N104 != null)
			sb.append(N104).append("*");

		sb.append("~");
		return sb.toString();
	}

}
