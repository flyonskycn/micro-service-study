package com.flyonsky.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class AccessFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		if(!request.getParameterMap().containsKey("accessToken")
				|| StringUtils.isBlank(request.getParameter("accessToken"))) {
			RequestContext.getCurrentContext().setResponseStatusCode(401);
			RequestContext.getCurrentContext().setSendZuulResponse(false);
		}
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}