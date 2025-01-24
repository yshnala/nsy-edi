package com.goldtek.edi_serv.entity.edi;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "OrderMapping")
public class OrderMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // 主鍵
	@Column(name = "po_number", nullable = false, length = 15)
	private String poNumber; // PO 單號
	@Column(name = "isa_control_number", nullable = false, length = 15)
	private String isaControlNumber; // ISA 控制編號
	@Column(name = "gs_control_number", nullable = false, length = 15)
	private String gsControlNumber; // GS 控制編號
	@Column(name = "st_control_number", nullable = false, length = 15)
	private String stControlNumber; // ST 控制編號
	@Column(name = "file_type", nullable = false, length = 15)
	private String fileType; // 文件類型 (例如 "850")
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt; // 創建時間

	// Constructors
	public OrderMapping() {
		this.createdAt = LocalDateTime.now();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public String getIsaControlNumber() {
		return isaControlNumber;
	}

	public void setIsaControlNumber(String isaControlNumber) {
		this.isaControlNumber = isaControlNumber;
	}

	public String getGsControlNumber() {
		return gsControlNumber;
	}

	public void setGsControlNumber(String gsControlNumber) {
		this.gsControlNumber = gsControlNumber;
	}

	public String getStControlNumber() {
		return stControlNumber;
	}

	public void setStControlNumber(String stControlNumber) {
		this.stControlNumber = stControlNumber;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "OrderMapping [id=" + id + ", poNumber=" + poNumber + ", isaControlNumber=" + isaControlNumber
				+ ", gsControlNumber=" + gsControlNumber + ", stControlNumber=" + stControlNumber + ", fileType="
				+ fileType + ", createdAt=" + createdAt + "]";
	}

}
