package com.api.model.master;

import java.io.Serializable;


public class MasterOutputObject 
	
	implements Serializable {

		/**
	 * 
	 */
	private static final long serialVersionUID = -5323087765699333919L;
		private ResponseObject response;

		public ResponseObject getResponse() {
			return response;
		}

		public void setResponse(ResponseObject response) {
			this.response = response;
		}
	}



