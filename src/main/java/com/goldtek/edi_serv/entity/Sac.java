package com.goldtek.edi_serv.entity;
/**
 * 用於表達與商品或服務相關的附加成本或減免。
 */

public class Sac {
	private String SAC01;
	private String SAC02;
	private String SAC05;

	public String getSAC01() {
		return SAC01;
	}

	public void setSAC01(String sAC01) {
		SAC01 = sAC01;
	}

	public String getSAC02() {
		return SAC02;
	}

	public void setSAC02(String sAC02) {
		SAC02 = sAC02;
	}

	public String getSAC05() {
		return SAC05;
	}

	public void setSAC05(String sAC05) {
		SAC05 = sAC05;
	}


	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder("SAC*");

	    if (SAC01 != null) sb.append(SAC01).append("*");
	    if (SAC02 != null) sb.append(SAC02).append("*");
	    if (SAC05 != null) sb.append(SAC05).append("*");


	    sb.append("~");
	    return sb.toString();
	}
	
}
