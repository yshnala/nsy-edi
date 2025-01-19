package com.goldtek.edi_serv.entity;

public class St {
	private String ST01;//交易集代碼（810 表示發票）
	private String ST02;//交易集控制號（0001，唯一標識）

	public String getST01() {
		return ST01;
	}

	public void setST01(String sT01) {
		ST01 = sT01;
	}

	public String getST02() {
		return ST02;
	}

	public void setST02(String sT02) {
		ST02 = sT02;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("ST*");

		if (ST01 != null)
			sb.append(ST01).append("*");
		if (ST02 != null)
			sb.append(ST02).append("*");

		sb.append("~");
		return sb.toString();
	}

}
