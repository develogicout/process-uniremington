package com.uniremington.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseWhatsapp implements Serializable {

	@SerializedName("success")
	@Expose
	private Boolean success;
	@SerializedName("data")
	@Expose
	private List<String> data = new ArrayList<String>();
	@SerializedName("result_code")
	@Expose
	private String resultCode;
	@SerializedName("result_message")
	@Expose
	private String resultMessage;
	@SerializedName("error_msg")
	@Expose
	private String errorMsg;
	private static final long serialVersionUID = 8948559031418438397L;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public ResponseWhatsapp() {
	}

	/**
	 *
	 * @param data
	 * @param success
	 * @param resultCode
	 * @param resultMessage
	 * @param errorMsg
	 */
	public ResponseWhatsapp(Boolean success, List<String> data, String resultCode, String resultMessage,
			String errorMsg) {
		super();
		this.success = success;
		this.data = new ArrayList<>(data);
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
		this.errorMsg = errorMsg;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		return "ResponseWhatsapp [success=" + success + ", data=" + data + ", resultCode=" + resultCode
				+ ", resultMessage=" + resultMessage + ", errorMsg=" + errorMsg + "]";
	}


}
