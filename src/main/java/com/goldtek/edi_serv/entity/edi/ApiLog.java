package com.goldtek.edi_serv.entity.edi;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "api_log") // 如果有 schema，記得替換成你的實際 schema 名稱
public class ApiLog {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // 對應 BIGINT(19)

    @Column(name = "create_time", nullable = false)
    private Date createTime; // 對應 DATETIME

    @Column(name = "api_name", length = 50)
    private String apiName; // 對應 VARCHAR(50)

    @Column(name = "request", length = 5000)
    private String request; // 對應 VARCHAR(5000)

    @Column(name = "response", length = 5000)
    private String response; // 對應 VARCHAR(5000)

    @Column(name = "error_msg", length = 5000)
    private String errorMsg; // 對應 VARCHAR(5000)

    @Column(name = "code", nullable = true)
    private int code; // 對應 INT(10)

    // Constructors
    public ApiLog() {}

    public ApiLog(long id,Date createTime, String apiName, String request, String response, String errorMsg, int code) {
        this.id = id;
        this.createTime = createTime;
        this.apiName = apiName;
        this.request = request;
        this.response = response;
        this.errorMsg = errorMsg;
        this.code = code;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

  
    public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    // toString() for debugging
    @Override
    public String toString() {
        return "ApiLog{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", apiName='" + apiName + '\'' +
                ", request='" + request + '\'' +
                ", response='" + response + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", code=" + code +
                '}';
    }


	

}
