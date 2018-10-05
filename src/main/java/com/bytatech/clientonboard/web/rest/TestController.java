package com.bytatech.clientonboard.web.rest;

import java.util.ArrayList;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bytatech.clientonboard.client.dms.api.NodesApi;
import com.bytatech.clientonboard.client.dms.api.SitesApi;
import com.bytatech.clientonboard.client.dms.model.SiteBodyCreate;

@RestController
public class TestController {
	@Autowired
	SitesApi sitesApi;
	@Autowired
	NodesApi nodesApi;
	
	
	@PostMapping("/createNode/{nodeId}")
	public String createNode(@PathVariable String nodeId,@RequestParam("filedata") MultipartFile filedata) {
		System.out.println("+++++++++++++success++++++++++");
		
		nodesApi.createNode(nodeId,filedata);
		
		return "succes";
		
	}
	@PostMapping("/createSite")
	public String createSite(@RequestBody SiteBodyCreate siteBodyCreate) {
		System.out.println("+++++++++++++success++++++++++");
		sitesApi.createSite(siteBodyCreate, true, false, new ArrayList());
		return "succes";
		
	}
	

}
