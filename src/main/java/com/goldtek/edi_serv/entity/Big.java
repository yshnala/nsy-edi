package com.goldtek.edi_serv.entity;

public class Big {
	private String BIG01;//發票日期（20250108，2025 年 1 月 8 日）
	private String BIG02;//發票號碼（INV001）
	private String BIG03;//
	private String BIG04;//
	public String getBIG01() {
		return BIG01;
	}
	public void setBIG01(String bIG01) {
		BIG01 = bIG01;
	}
	public String getBIG02() {
		return BIG02;
	}
	public void setBIG02(String bIG02) {
		BIG02 = bIG02;
	}
	

	public String getBIG03() {
		return BIG03;
	}
	public void setBIG03(String bIG03) {
		BIG03 = bIG03;
	}
	public String getBIG04() {
		return BIG04;
	}
	public void setBIG04(String bIG04) {
		BIG04 = bIG04;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("BIG*");

		if (BIG01 != null)
			sb.append(BIG01).append("*");
		if (BIG02 != null)
			sb.append(BIG02).append("*");
		if (BIG03 != null)
			sb.append(BIG03).append("*");
		if (BIG04 != null)
			sb.append(BIG04).append("*");

		
		sb.append("~");
		return sb.toString();
	}
}
