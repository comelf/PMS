package com.pms.web.interceptor;

import com.pms.web.R;
import com.pms.web.entity.Account;
import com.pms.web.entity.academy.AcademyAccountMapping;
import com.pms.web.model.UserDetail;
import com.pms.web.repository.AcademyAccountMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AcademyInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	AcademyAccountMappingRepository aamRepo;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute(R.ACADEMY_ACCOUNT_MAPPING) == null) {
			UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getDetails();
			Account account = userDetails.getAccount();
			AcademyAccountMapping aam = aamRepo.findOneByAccount(account);
			if (aam == null) {
				throw new BadAcademyAccessExection();
			}
			session.setAttribute(R.CURRENT_ACADEMY_BRANCH, aam.getAcademyBranch());
			session.setAttribute(R.ACADEMY_ACCOUNT_MAPPING, aam);
		}
		return true;
	}
}
