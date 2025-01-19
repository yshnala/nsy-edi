package com.goldtek.edi_serv.entity;

public class Gs {
	private String GS01;//功能標識符
	private String GS02;//發送方的唯一標識，通常與 ISA06 對應，但不一定相同。
	private String GS03;//接收方的唯一標識，通常與 ISA08 對應，但不一定相同。
	private String GS04;//功能群組的日期，格式為 YYYYMMDD。
	private String GS05;//功能群組的時間，格式為 HHMM。
	private String GS06;//功能群組的唯一控制編號，接收方用於驗證數據順序。
	private String GS07;//指示標準機構：
	private String GS08;//指定使用的 ANSI X12 版本，例如：
	public String getGS01() {
		return GS01;
	}
	public void setGS01(String gS01) {
		GS01 = gS01;
	}
	public String getGS02() {
		return GS02;
	}
	public void setGS02(String gS02) {
		GS02 = gS02;
	}
	public String getGS03() {
		return GS03;
	}
	public void setGS03(String gS03) {
		GS03 = gS03;
	}
	public String getGS04() {
		return GS04;
	}
	public void setGS04(String gS04) {
		GS04 = gS04;
	}
	public String getGS05() {
		return GS05;
	}
	public void setGS05(String gS05) {
		GS05 = gS05;
	}
	public String getGS06() {
		return GS06;
	}
	public void setGS06(String gS06) {
		GS06 = gS06;
	}
	public String getGS07() {
		return GS07;
	}
	public void setGS07(String gS07) {
		GS07 = gS07;
	}
	public String getGS08() {
		return GS08;
	}
	public void setGS08(String gS08) {
		GS08 = gS08;
	}
	
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder("GS*");

	    if (GS01 != null) sb.append(GS01).append("*");
	    if (GS02 != null) sb.append(GS02).append("*");
	    if (GS03 != null) sb.append(GS03).append("*");
	    if (GS04 != null) sb.append(GS04).append("*");
	    if (GS05 != null) sb.append(GS05).append("*");
	    if (GS06 != null) sb.append(GS06).append("*");
	    if (GS07 != null) sb.append(GS07).append("*");
	    if (GS08 != null) sb.append(GS08);

	    sb.append("~");
	    return sb.toString();
	}

}
