package com.hin.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hin.entity.ServiceResourceInfo;
import com.hin.service.ResourceInfoService;

@Controller
@RequestMapping("/resource")
public class ResourceInfoController {
	@Resource
	private ResourceInfoService resourceInfoService;
	
	@RequestMapping(value = "/addServiceResource", method = RequestMethod.POST)
    public @ResponseBody void addServiceResource(
    		 @RequestBody Map<String,Object>  params) throws Exception{
		resourceInfoService.addServiceResource(params);
	}
	
	@RequestMapping(value = "/getServiceResource/{resourceName}/{userID}", method = RequestMethod.GET)
    public @ResponseBody ServiceResourceInfo getServiceResource(
    		@PathVariable String resourceName, @PathVariable Integer userID) throws Exception{
		return resourceInfoService.getServiceResource(resourceName, userID);
	}
	
	@RequestMapping(value = "/getServiceResourceByName/{resourceName}", method = RequestMethod.GET)
    public @ResponseBody List<ServiceResourceInfo> getServiceResourceByName(
    		@PathVariable String resourceName) throws Exception{
		return resourceInfoService.getServiceResourceByName(resourceName);
	}
}
