package com.vitamin.service;

import com.vitamin.dto.OoviResponse;
import com.vitamin.entity.AdminDetails;

public interface AdminService {

	OoviResponse addAdmin(AdminDetails adminDetails);

	OoviResponse loginUser(AdminDetails adminDetails);

}
