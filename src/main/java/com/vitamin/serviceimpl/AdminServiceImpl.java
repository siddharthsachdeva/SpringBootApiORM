package com.vitamin.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.vitamin.dto.LoginResponseDTO;
import com.vitamin.dto.OoviResponse;
import com.vitamin.dto.OoviResultResponse;
import com.vitamin.entity.AdminDetails;
import com.vitamin.exception.ServiceException;
import com.vitamin.repository.AdminRepository;
import com.vitamin.security.JwtGenerator;
import com.vitamin.security.JwtUser;
import com.vitamin.service.AdminService;
import com.vitamin.util.CommonUtility;
import com.vitamin.util.Constant;
import com.vitamin.util.Message;

@Component
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private JwtGenerator jwtGenerator;

	@Autowired
	private AdminRepository repository;

	@Override
	public OoviResponse addAdmin(AdminDetails adminDetails) {
		OoviResponse response = new OoviResponse();
		try {

			validateAdmin(adminDetails);

			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

			adminDetails.setPassword(passwordEncoder.encode(adminDetails.getPassword()));

			repository.save(adminDetails);
			response.setStatusCode(Constant.SUCCESS_STATUS_CODE);
			response.setMessage(Message.ADMIN_ADDED);

		} catch (ServiceException se) {
			response.setStatusCode(se.getStatusCode());
			response.setMessage(se.getMessage());
		} catch (Exception e) {
			response.setStatusCode(Constant.ERROR_STATUS_CODE);
			response.setMessage(Message.SOMETHING_WENT_WONG);
		}

		return response;
	}


	private void validateAdmin(AdminDetails adminDetails) throws ServiceException {
		if (repository.isAdminExists(adminDetails.getEmailId(), adminDetails.getUsername())) {
			throw new ServiceException(1, Message.ADMIN_ALREADY_EXISTS);
		}

		String emailId = adminDetails.getEmailId();
		String username = adminDetails.getUsername();
		String role = adminDetails.getRole();
		String password = adminDetails.getPassword();

		if (emailId == null || emailId.isEmpty() || username == null || username.isEmpty() || password == null
				|| password.isEmpty() || role == null || role.isEmpty()) {
			
			throw new ServiceException(1, Message.EMAILID_USERNAME_PASS_ROLE_MANDATORY);
			
		}
	}
	
	@Override
	public OoviResponse loginUser(AdminDetails admin) {
		OoviResponse response = null;
		try {
			AdminDetails adminFromDB = repository.findAdminByUsername(admin.getUsername());
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

			if (adminFromDB == null || !passwordEncoder.matches(admin.getPassword(), adminFromDB.getPassword())) {
				throw new ServiceException(Constant.ERROR_STATUS_CODE, Message.INVALID_USERNAME_OR_PASS);
			}

			JwtUser jwtUser = new JwtUser(adminFromDB.getId(), adminFromDB.getUsername(), adminFromDB.getRole());

			LoginResponseDTO token = new LoginResponseDTO();
			token.setToken(jwtGenerator.generate(jwtUser));
			response = new OoviResultResponse();
			((OoviResultResponse) response).setResult(token);
			response.setStatusCode(Constant.SUCCESS_STATUS_CODE);
			response.setMessage(Message.ADMIN_LOGGED_IN);
			
		} catch (ServiceException se) {
			response = CommonUtility.getServiceExceptionResponse(se);
			se.printStackTrace();
		} catch (Exception e) {
			response = CommonUtility.getExceptionResponse();
			e.printStackTrace();
		}

		return response;
	}

}
