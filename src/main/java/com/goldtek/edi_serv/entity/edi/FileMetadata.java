package com.goldtek.edi_serv.entity.edi;



import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "FileMetadata", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"isa_control_number", "gs_control_number", "st_control_number", "file_type"})
})
public class FileMetadata {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isa_control_number", nullable = false, length = 15)
    private String isaControlNumber;

    @Column(name = "gs_control_number", nullable = false, length = 10)
    private String gsControlNumber;

    @Column(name = "st_control_number", nullable = false, length = 10)
    private String stControlNumber;

    @Column(name = "file_type", nullable = false, length = 10)
    private String fileType;

    @Column(name = "received_time", nullable = false)
    private LocalDateTime receivedTime;

    @Column(name = "sender_id", nullable = false, length = 20)
    private String senderId;

    @Column(name = "receiver_id", nullable = false, length = 20)
    private String receiverId;

    @Column(name = "document_date")
    private LocalDate documentDate;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "error_message", columnDefinition = "TEXT")
    private String errorMessage;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // Constructors
    public FileMetadata() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getReceivedTime() {
        return receivedTime;
    }

    public void setReceivedTime(LocalDateTime receivedTime) {
        this.receivedTime = receivedTime;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public LocalDate getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(LocalDate documentDate) {
        this.documentDate = documentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // Pre-update callback
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

	@Override
	public String toString() {
		return "FileMetadata [id=" + id + ", isaControlNumber=" + isaControlNumber + ", gsControlNumber="
				+ gsControlNumber + ", stControlNumber=" + stControlNumber + ", fileType=" + fileType
				+ ", receivedTime=" + receivedTime + ", senderId=" + senderId + ", receiverId=" + receiverId
				+ ", documentDate=" + documentDate + ", status=" + status + ", errorMessage=" + errorMessage
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
    
    
}