package com.bytatech.clientonboard.web.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bytatech.clientonboard.client.dms.api.NodesApi;
import com.bytatech.clientonboard.client.dms.api.PeopleApi;
import com.bytatech.clientonboard.client.dms.api.SharedLinksApi;
import com.bytatech.clientonboard.client.dms.api.SitesApi;
import com.bytatech.clientonboard.client.dms.model.NodeBodyCreate;
import com.bytatech.clientonboard.client.dms.model.NodeBodyUpdate;
import com.bytatech.clientonboard.client.dms.model.NodeEntry;
import com.bytatech.clientonboard.client.dms.model.PersonBodyCreate;
import com.bytatech.clientonboard.client.dms.model.SharedLinkBodyCreate;
import com.bytatech.clientonboard.client.dms.model.SharedLinkEntry;
import com.bytatech.clientonboard.client.dms.model.SiteBodyCreate;
import com.bytatech.clientonboard.client.dms.model.SiteBodyCreate.VisibilityEnum;
import com.bytatech.clientonboard.client.dms.model.SiteEntry;
import com.bytatech.clientonboard.client.dms.model.SiteMembershipBodyCreate;
import com.bytatech.clientonboard.domain.Document;

@RestController
public class TestController {
	@Autowired
	SitesApi sitesApi;
	@Autowired
	NodesApi nodesApi;
	@Autowired
	SharedLinksApi sharedLinksApi;

	@Autowired
	PeopleApi peopleApi;
	String id = null;

	/*
	 * AlfrescoClient client = new
	 * AlfrescoClient.Builder().connect("http://35.196.208.144:8902/alfresco",
	 * "admin", "admin").build(); NodesAPI nodesAPI = client.getNodesAPI();
	 */
	/*
	 * @PostMapping("/createNode/{nodeId}") public String createNode(@PathVariable
	 * String nodeId,@RequestBody NodeBodyCreate nodeBodyCreate ) {
	 * System.out.println("+++++++++++++success++++++++++");
	 * 
	 * nodesApi.createNode(nodeId, nodeBodyCreate, false, null, null);
	 * 
	 * return "succes";
	 * 
	 * }
	 */
	/*@PostMapping("/createSite")
	public String createSite(@RequestBody SiteBodyCreate siteBodyCreate) {
		System.out.println("+++++++++++++success++++++++++");
		System.out.println(sitesApi.createSite(siteBodyCreate, false, false, new ArrayList()).getBody());
		// SiteEntry s= sitesApi.createSite(siteBodyCreate, true, false,
		// null).getBody();

		return "succes";

	}

	@PostMapping("/createContent/{nodeId}")
	public String createContent(@PathVariable String nodeId, @RequestBody Resource body) {
		System.out.println("+++++++++++++success++++++++++" + body);
		nodesApi.updateNodeContent(nodeId, body, true, null, null, null, null);
		// nodesApi.updateNode(nodeId, nodeBodyUpdate, null, null);
		return "succes";

	}

	@PostMapping("/setNode/{nodeId}")
	public String createNodeAndData(@PathVariable String nodeId, @RequestBody Resource body) {
		SiteBodyCreate siteBodyCreate = new SiteBodyCreate();
		siteBodyCreate.setId("bytatechSite");
		siteBodyCreate.setTitle("bytatechsite");
		siteBodyCreate.setDescription("hello bytatatech");
		siteBodyCreate.setVisibility(VisibilityEnum.PUBLIC);
		SiteEntry s = sitesApi.createSite(siteBodyCreate, true, false, null).getBody();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + s);

		SiteMembershipBodyCreate siteMembershipBodyCreate = new SiteMembershipBodyCreate();
		siteMembershipBodyCreate.setId("adminUser");
		// siteMembershipBodyCreate.setRole();
		// sitesApi.createSiteMembership("bytatechSite", siteMembershipBodyCreate,
		// fields);
		// sitesApi.createSiteMembershipRequestForPerson(personId,
		// siteMembershipRequestBodyCreate, fields)

		System.out.println("+++++++++++++success++++++++++" + body);
		NodeBodyCreate nodeBodyCreate = new NodeBodyCreate();
		nodeBodyCreate.setName("secondFile.txt");
		nodeBodyCreate.setNodeType("cm:content");

		nodeBodyCreate.setRelativePath("Sites/firstSite");

		
		 * //NodeEntry nodeEntry= nodesApi.createNode(nodeId, nodeBodyCreate,
		 * false).getBody(); String id=nodeEntry.getEntry().getId();
		 * System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+nodeEntry.getEntry().getId(
		 * ));
		 * 
		 * nodesApi.updateNodeContent(id, body, true, null, null, null, null);
		 * //nodesApi.updateNode(nodeId, nodeBodyUpdate, null, null);
		 
		return "succes";

	}*/
/*
	@PostMapping("/createPeople")
	public String createPeople(@RequestBody PersonBodyCreate personBodyCreate) {
		System.out.println("+++++++++++++success++++++++++");

		System.out.println(peopleApi.createPerson(personBodyCreate, null));

		return "succes";

	}*/

	/*
	 * @PostMapping("/sharedLink") public String createSharedLink(@RequestBody
	 * Resource body) { System.out.println("+++++++++++++success++++++++++");
	 * NodeBodyCreate nodeBodyCreate = new NodeBodyCreate();
	 * nodeBodyCreate.setName("fifthFile.txt");
	 * nodeBodyCreate.setNodeType("cm:content");
	 * nodeBodyCreate.setRelativePath("Sites/bytatechSite/documentLibrary");
	 * 
	 * // NodeEntry nodeEntry= nodesApi.createNode("-my-", nodeBodyCreate,
	 * false).getBody();
	 * 
	 * 
	 * id=nodeEntry.getEntry().getId();
	 * System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+nodeEntry.getEntry().getId(
	 * ));
	 * 
	 * nodesApi.updateNodeContent(id, body, true, null, null, null, null);
	 * 
	 * 
	 * SharedLinkBodyCreate sharedLinkBodyCreate = new SharedLinkBodyCreate();
	 * 
	 * sharedLinkBodyCreate.setNodeId(id);
	 * 
	 * 
	 * System.out.println( sharedLinksApi.createSharedLink(sharedLinkBodyCreate,
	 * null, null)); //System.out.println(peopleApi.createPerson(personBodyCreate,
	 * null));
	 * 
	 * return "succes";
	 * 
	 * }
	 */
/*	@PostMapping("/createLink")
	public void createLink() {
		SharedLinkBodyCreate sharedLinkBodyCreate = new SharedLinkBodyCreate();

		sharedLinkBodyCreate.setNodeId(id);

		SharedLinkEntry sharedLinkEntry = sharedLinksApi.createSharedLink(sharedLinkBodyCreate, null, null).getBody();

		System.out.println(sharedLinkEntry.getEntry().getId());
	}

	@GetMapping("/linkContent")
	public Resource linkContent() {
		return sharedLinksApi.getSharedLinkContent("WJujRkfGSkKt-Pw89YsZmg", true, null, "false").getBody();
	}*/

	/*
	 * public Document postContent(@RequestBody List<Resource> content ) { Document
	 * document = new Document(); for(Resource contentList:content) {
	 * createContent(contentList,"pan",document); } return document; }
	 */

	@PostMapping("/createPanContent")
	public Document createPanContent(@RequestBody Resource body/* ,String name ,Document document */) {
		Document document = new Document();
		String name = "pan";
		NodeBodyCreate nodeBodyCreate = new NodeBodyCreate();
		nodeBodyCreate.setName(name);
		nodeBodyCreate.setNodeType("cm:content");
		nodeBodyCreate.setRelativePath("Sites/rmsrm/documentLibrary/KYC/PAN");

		NodeEntry nodeEntry = nodesApi.createNode("-my-", nodeBodyCreate, true, null, null).getBody();

		SharedLinkBodyCreate sharedLinkBodyCreate = new SharedLinkBodyCreate();
		nodesApi.updateNodeContent(nodeEntry.getEntry().getId(), body, true, null, null, null, null);
		sharedLinkBodyCreate.setNodeId(nodeEntry.getEntry().getId());

		SharedLinkEntry sharedLinkEntry = sharedLinksApi.createSharedLink(sharedLinkBodyCreate, null, null).getBody();

		document.panLink = sharedLinkEntry.getEntry().getId();
		return document;
	}

	@PostMapping("/createAadharContent")
	public Document createAadharContent(@RequestBody Resource body/* ,String name ,Document document */) {
		Document document = new Document();
		String name = "Aahar";
		NodeBodyCreate nodeBodyCreate = new NodeBodyCreate();
		nodeBodyCreate.setName(name);
		nodeBodyCreate.setNodeType("cm:content");
		nodeBodyCreate.setRelativePath("Sites/rmsrm/documentLibrary/KYC/AADHAR");

		NodeEntry nodeEntry = nodesApi.createNode("-my-", nodeBodyCreate, true, null, null).getBody();
		nodesApi.updateNodeContent(nodeEntry.getEntry().getId(), body, true, null, null, null, null);
		SharedLinkBodyCreate sharedLinkBodyCreate = new SharedLinkBodyCreate();

		sharedLinkBodyCreate.setNodeId(nodeEntry.getEntry().getId());

		SharedLinkEntry sharedLinkEntry = sharedLinksApi.createSharedLink(sharedLinkBodyCreate, null, null).getBody();

		document.aadharLink = sharedLinkEntry.getEntry().getId();
		return document;
	}

	@PostMapping("/createApplicationContent")
	public Document createApplicationContent(@RequestBody Resource body/* ,String name ,Document document */) {
		String name = "application";
		Document document = new Document();
		NodeBodyCreate nodeBodyCreate = new NodeBodyCreate();
		nodeBodyCreate.setName(name);
		nodeBodyCreate.setNodeType("cm:content");
		nodeBodyCreate.setRelativePath("Sites/rmsrm/documentLibrary/BANK/APPLICATION");

		NodeEntry nodeEntry = nodesApi.createNode("-my-", nodeBodyCreate, true, null, null).getBody();
		nodesApi.updateNodeContent(nodeEntry.getEntry().getId(), body, true, null, null, null, null);
		SharedLinkBodyCreate sharedLinkBodyCreate = new SharedLinkBodyCreate();

		sharedLinkBodyCreate.setNodeId(nodeEntry.getEntry().getId());

		SharedLinkEntry sharedLinkEntry = sharedLinksApi.createSharedLink(sharedLinkBodyCreate, null, null).getBody();

		document.applicationLink = sharedLinkEntry.getEntry().getId();
		return document;
	}

}
