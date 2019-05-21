package com.os.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.os.model.Usuario;



public class LogginFilter implements Filter {

	private String timeoutPage = "login.xhtml";

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		if ((request instanceof HttpServletRequest) && (response instanceof HttpServletResponse)) {
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			HttpSession session = ((HttpServletRequest) request).getSession();
			
			Usuario logBean = (Usuario) session.getAttribute("user");
			
			// is session expire control required for this request?

			if (isSessionControlRequiredForThisResource(httpServletRequest)) {
				// is session invalid?
				if (isSessionInvalid(httpServletRequest)) {
					String timeoutUrl = httpServletRequest.getContextPath() + "/" + getTimeoutPage();
					session.getAttributeNames();
					session.setAttribute("msg", "Sua sess�o expirou, favor logar novamente.");
					session.getAttribute("msg");

					if (isAjax(httpServletRequest) && !httpServletRequest.isRequestedSessionIdValid()) {
						httpServletResponse.getWriter()
								.print(xmlPartialRedirectToPage(httpServletRequest, "/login?session_expired=1"));
						httpServletResponse.flushBuffer();
					} else {
						httpServletResponse.sendRedirect(timeoutUrl);
					}

					return;
				}
			}

			if ((logBean == null) ||  (logBean.getUsuId() == null)) {
				String timeoutUrl = httpServletRequest.getContextPath() + "/" + getTimeoutPage();
				session.getAttributeNames();
				session.setAttribute("msg", "Sua sess�o expirou, favor logar novamente.");
				session.getAttribute("msg");

				if (isAjax(httpServletRequest) && !httpServletRequest.isRequestedSessionIdValid()) {
					httpServletResponse.getWriter()
							.print(xmlPartialRedirectToPage(httpServletRequest, "/login?session_expired=1"));
					httpServletResponse.flushBuffer();
				} else {
					httpServletResponse.sendRedirect(timeoutUrl);
				}

				return;
			}

		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	private boolean isSessionControlRequiredForThisResource(HttpServletRequest httpServletRequest) {
		String requestPath = httpServletRequest.getRequestURI();
		boolean controlRequired = !org.apache.commons.lang3.StringUtils.contains(requestPath, getTimeoutPage());
				

		return controlRequired;
	}

	public String getTimeoutPage() {
		return timeoutPage;
	}

	public void setTimeoutPage(String timeoutPage) {
		this.timeoutPage = timeoutPage;
	}

	private boolean isSessionInvalid(HttpServletRequest httpServletRequest) {
		boolean sessionInValid = (httpServletRequest.getRequestedSessionId() != null)
				&& !httpServletRequest.isRequestedSessionIdValid();
		return sessionInValid;

	}

	private boolean isAjax(HttpServletRequest request) {
		return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
	}

	private String xmlPartialRedirectToPage(HttpServletRequest request, String page) {
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version='1.0' encoding='UTF-8'?>");
		sb.append("<partial-response><redirect url=\"").append(request.getContextPath())
				.append(request.getServletPath()).append(page).append("\"/></partial-response>");
		return sb.toString();
	}
}
