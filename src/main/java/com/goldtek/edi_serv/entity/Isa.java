package com.goldtek.edi_serv.entity;

public class Isa {
	String ISA01;// 授權信息限定符，用於指示是否包含授權信息。00 表示無授權信息，03 表示有授權碼（很少使用其他值）。
	String ISA02;// 授權信息內容，如果 ISA01 為 03，此處填入授權碼；若為 00，則此字段為 10 個空格。
	String ISA03;// 安全信息限定符，用於指示是否包含安全信息。00 表示無安全信息，01 表示有安全碼。
	String ISA04;// 安全信息內容，如果 ISA03 為 01，此處填入安全碼；若為 00，則此字段為 10 個空格
	String ISA05;// 發送方標識符限定符，表示發送方的標識符類型。常見值包括：- ZZ：測試或互定標識符- 01：DUNS 編碼- 08：美國 EAN/UCC 編碼。
	String ISA06;// 發送方標識符，具體標識發送者的代碼，通常由接收方和發送方協議決定（最多 15 字元，空格補齊）。
	String ISA07;// 接收方標識符限定符，表示接收方的標識符類型，值同 ISA05（例如 ZZ 表示測試標識）。
	String ISA08;// 接收方標識符，具體標識接收者的代碼，最多 15 字元，空格補齊。
	String ISA09;// 日期，發送交換的日期，格式為 YYYYMMDD（例如，20250108 表示 2025 年 1 月 8 日）。
	String ISA10;// 時間，發送交換的時間，格式為 HHMM（例如，1234 表示 12:34）。
	String ISA11;// 控制標識符，用於定義 EDI 標準類型：- U：表示 ANSI X12 標準 - I：表示國際標準（EDIFACT）。
	String ISA12;// 標準版本號，表示交換使用的 ANSI X12 版本，例如：- 00401：版本 4010- 00501：版本 5010。
	String ISA13;// 交換控制號，唯一標識交換的一個 9 位數字，用於跟蹤交換，接收方通常用它來驗證數據的唯一性和順序。
	String ISA14;// 回應請求指標，指示是否需要回應：- 0：不需要功能確認（997）- 1：需要功能確認。
	String ISA15;// 用途指標，指示交換數據的用途：- P：生產/運營數據 - T：測試數據。
	String ISA16;// 元素分隔符，定義段字段中的元素分隔符，用於分隔段內的每個字段值（例如，> 或 *）。

	public String getISA01() {
		return ISA01;
	}

	public void setISA01(String iSA01) {
		ISA01 = iSA01;
	}

	public String getISA02() {
		return ISA02;
	}

	public void setISA02(String iSA02) {
		ISA02 = iSA02;
	}

	public String getISA03() {
		return ISA03;
	}

	public void setISA03(String iSA03) {
		ISA03 = iSA03;
	}

	public String getISA04() {
		return ISA04;
	}

	public void setISA04(String iSA04) {
		ISA04 = iSA04;
	}

	public String getISA05() {
		return ISA05;
	}

	public void setISA05(String iSA05) {
		ISA05 = iSA05;
	}

	public String getISA06() {
		return ISA06;
	}

	public void setISA06(String iSA06) {
		ISA06 = iSA06;
	}

	public String getISA07() {
		return ISA07;
	}

	public void setISA07(String iSA07) {
		ISA07 = iSA07;
	}

	public String getISA08() {
		return ISA08;
	}

	public void setISA08(String iSA08) {
		ISA08 = iSA08;
	}

	public String getISA09() {
		return ISA09;
	}

	public void setISA09(String iSA09) {
		ISA09 = iSA09;
	}

	public String getISA10() {
		return ISA10;
	}

	public void setISA10(String iSA10) {
		ISA10 = iSA10;
	}

	public String getISA11() {
		return ISA11;
	}

	public void setISA11(String iSA11) {
		ISA11 = iSA11;
	}

	public String getISA12() {
		return ISA12;
	}

	public void setISA12(String iSA12) {
		ISA12 = iSA12;
	}

	public String getISA13() {
		return ISA13;
	}

	public void setISA13(String iSA13) {
		ISA13 = iSA13;
	}

	public String getISA14() {
		return ISA14;
	}

	public void setISA14(String iSA14) {
		ISA14 = iSA14;
	}

	public String getISA15() {
		return ISA15;
	}

	public void setISA15(String iSA15) {
		ISA15 = iSA15;
	}

	public String getISA16() {
		return ISA16;
	}

	public void setISA16(String iSA16) {
		ISA16 = iSA16;
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder("ISA*");

	    if (ISA01 != null) sb.append(ISA01).append("*");
	    if (ISA02 != null) sb.append(ISA02).append("*");
	    if (ISA03 != null) sb.append(ISA03).append("*");
	    if (ISA04 != null) sb.append(ISA04).append("*");
	    if (ISA05 != null) sb.append(ISA05).append("*");
	    if (ISA06 != null) sb.append(ISA06).append("*");
	    if (ISA07 != null) sb.append(ISA07).append("*");
	    if (ISA08 != null) sb.append(ISA08).append("*");
	    if (ISA09 != null) sb.append(ISA09).append("*");
	    if (ISA10 != null) sb.append(ISA10).append("*");
	    if (ISA11 != null) sb.append(ISA11).append("*");
	    if (ISA12 != null) sb.append(ISA12).append("*");
	    if (ISA13 != null) sb.append(ISA13).append("*");
	    if (ISA14 != null) sb.append(ISA14).append("*");
	    if (ISA15 != null) sb.append(ISA15).append("*");
	    if (ISA16 != null) sb.append(">");
	    // 移除最後多餘的 ", "（如果有的話）
//	    if (sb.length() > 7) {
//	        sb.setLength(sb.length() - 2); // 移除最後的 ", "
//	    }

	    sb.append("~");
	    return sb.toString();
	}
}
