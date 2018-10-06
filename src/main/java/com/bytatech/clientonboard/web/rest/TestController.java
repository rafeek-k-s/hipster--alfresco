package com.bytatech.clientonboard.web.rest;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.bytatech.clientonboard.client.dms.api.NodesApi;
import com.bytatech.clientonboard.client.dms.api.SitesApi;
import com.bytatech.clientonboard.client.dms.model.NodeBodyCreate;
import com.bytatech.clientonboard.client.dms.model.NodeBodyUpdate;
import com.bytatech.clientonboard.client.dms.model.NodeEntry;
import com.bytatech.clientonboard.client.dms.model.SiteBodyCreate;
import com.bytatech.clientonboard.client.dms.model.SiteBodyCreate.VisibilityEnum;
import com.bytatech.clientonboard.client.dms.model.SiteEntry;


@RestController
public class TestController {
	@Autowired
	SitesApi sitesApi;
	@Autowired
	NodesApi nodesApi;
	/*AlfrescoClient client = new AlfrescoClient.Builder().connect("http://35.196.208.144:8902/alfresco", "admin", "admin").build();
	NodesAPI nodesAPI = client.getNodesAPI();*/
	@PostMapping("/createNode/{nodeId}")
	public String createNode(@PathVariable String nodeId,@RequestBody NodeBodyCreate nodeBodyCreate ) {
		System.out.println("+++++++++++++success++++++++++");
    
	nodesApi.createNode(nodeId, nodeBodyCreate, false/*, null, null*/);
		
		return "succes";
		
	}
	@PostMapping("/createSite")
	public String createSite(@RequestBody SiteBodyCreate siteBodyCreate) {
		System.out.println("+++++++++++++success++++++++++");
		System.out.println(sitesApi.createSite(siteBodyCreate, false, false, new ArrayList()).getBody());
		//SiteEntry s=	sitesApi.createSite(siteBodyCreate, true, false, null).getBody();
		
		return "succes";
		
	
		
	}
	
	@PostMapping("/createContent/{nodeId}")
	public String createContent(@PathVariable String nodeId,@RequestBody Resource body ) {
		System.out.println("+++++++++++++success++++++++++"+body);
		nodesApi.updateNodeContent(nodeId, body, true, null, null, null, null);
		//nodesApi.updateNode(nodeId, nodeBodyUpdate, null, null);
		return "succes";
		
	
		
	}
	
	@PostMapping("/setNode/{nodeId}")
	public String createNodeAndData(@PathVariable String nodeId,@RequestBody Resource body ) {
		SiteBodyCreate siteBodyCreate =new SiteBodyCreate();
		siteBodyCreate.setId("bytatechSite");
		siteBodyCreate.setTitle("bytatechsite");
		siteBodyCreate.setDescription("hello bytatatech");
		siteBodyCreate.setVisibility(VisibilityEnum.PUBLIC);
SiteEntry s=	sitesApi.createSite(siteBodyCreate, true, false, null).getBody();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+s);
	/*	System.out.println("+++++++++++++success++++++++++"+body);
		NodeBodyCreate nodeBodyCreate = new NodeBodyCreate();
		nodeBodyCreate.setName("secondFile.txt");
		nodeBodyCreate.setNodeType("cm:content");
		
		nodeBodyCreate.setRelativePath("Sites/firstSite");
		
	NodeEntry nodeEntry=	nodesApi.createNode(nodeId, nodeBodyCreate, false, null, null).getBody();
		String id=nodeEntry.getEntry().getId();
	System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+nodeEntry.getEntry().getId());
	
	nodesApi.updateNodeContent(id, body, true, null, null, null, null);
		//nodesApi.updateNode(nodeId, nodeBodyUpdate, null, null);
*/		return "succes";
		
	
		
	}
}
