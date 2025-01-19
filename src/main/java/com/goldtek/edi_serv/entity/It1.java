package com.goldtek.edi_serv.entity;

public class It1 {
	private String IT101;// Purchase Order Line number
	private String IT102;// Number of units invoiced
	private String IT103;// Code specifying the units
	private String IT104;// Price
	private String IT105;// "PE" - Price per Each
	private String IT106;// "BP" - Buyer's Part Number
	private String IT107;// Buyer's Part Number
	private String IT108;// "VP" - Vendor's (Seller's) Part Number
	private String IT109;// Vendor's Part Number

	public String getIT101() {
		return IT101;
	}

	public void setIT101(String iT101) {
		IT101 = iT101;
	}

	public String getIT102() {
		return IT102;
	}

	public void setIT102(String iT102) {
		IT102 = iT102;
	}

	public String getIT103() {
		return IT103;
	}

	public void setIT103(String iT103) {
		IT103 = iT103;
	}

	public String getIT104() {
		return IT104;
	}

	public void setIT104(String iT104) {
		IT104 = iT104;
	}

	public String getIT105() {
		return IT105;
	}

	public void setIT105(String iT105) {
		IT105 = iT105;
	}

	public String getIT106() {
		return IT106;
	}

	public void setIT106(String iT106) {
		IT106 = iT106;
	}

	public String getIT107() {
		return IT107;
	}

	public void setIT107(String iT107) {
		IT107 = iT107;
	}

	public String getIT108() {
		return IT108;
	}

	public void setIT108(String iT108) {
		IT108 = iT108;
	}

	public String getIT109() {
		return IT109;
	}

	public void setIT109(String iT109) {
		IT109 = iT109;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("IT1*");

		if (IT101 != null)
			sb.append(IT101).append("*");
		if (IT102 != null)
			sb.append(IT102).append("*");
		if (IT103 != null)
			sb.append(IT103).append("*");

		if (IT104 != null)
			sb.append(IT104).append("*");

		if (IT105 != null)
			sb.append(IT105).append("*");

		if (IT106 != null)
			sb.append(IT106).append("*");

		if (IT107 != null)
			sb.append(IT107).append("*");

		if (IT108 != null)
			sb.append(IT108).append("*");

		if (IT109 != null)
			sb.append(IT109).append("*");

		sb.append("~");
		return sb.toString();
	}

}
