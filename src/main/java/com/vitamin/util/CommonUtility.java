package com.vitamin.util;

import com.vitamin.dto.OoviResponse;
import com.vitamin.exception.ServiceException;

public class CommonUtility {
	
	private CommonUtility() {
		super();
	}

	public static OoviResponse getExceptionResponse() {
		OoviResponse response;
		response = new OoviResponse();
		response.setStatusCode(Constant.ERROR_STATUS_CODE);
		response.setMessage(Message.SOMETHING_WENT_WONG);
		return response;
	}

	public static OoviResponse getServiceExceptionResponse(ServiceException se) {
		OoviResponse response;
		response = new OoviResponse();
		response.setStatusCode(se.getStatusCode());
		response.setMessage(se.getMessage());
		return response;
	}

}
