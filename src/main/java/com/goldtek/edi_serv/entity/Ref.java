package com.goldtek.edi_serv.entity;

public class Ref {
	private String REF01;//參考標識類型（IT，付款條件）
	private String REF02;//參考值（NET30，30 天付款條件）

	public String getREF01() {
		return REF01;
	}

	public void setREF01(String rEF01) {
		REF01 = rEF01;
	}

	public String getREF02() {
		return REF02;
	}

	public void setREF02(String rEF02) {
		REF02 = rEF02;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("REF*");

		if (REF01 != null)
			sb.append(REF01).append("*");
		if (REF02 != null)
			sb.append(REF02).append("*");

		sb.append("~");
		return sb.toString();
	}
}
