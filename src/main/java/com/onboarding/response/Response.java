package com.onboarding.response;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class Response {
	
		@SuppressWarnings("unused")
		private String email;
		private Date timestamp;
		private String message;
		private HttpStatus status;
		@SuppressWarnings("unused")
		private String refid;
		public Response(String refid, Date timestamp, String message, HttpStatus status) {
			this.refid = refid;
			this.timestamp = timestamp;
			this.message = message;
			this.status = status;
		}
		

		public Response(Date timestamp, String message, HttpStatus status) {
			super();
			this.timestamp = timestamp;
			this.message = message;
			this.status = status;
		}


		
		public Date getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public HttpStatus getStatus() {
			return status;
		}
		public void setStatus(HttpStatus status) {
			this.status = status;
		}
	}




