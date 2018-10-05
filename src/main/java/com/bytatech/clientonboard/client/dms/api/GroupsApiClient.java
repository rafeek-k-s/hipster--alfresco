package com.bytatech.clientonboard.client.dms.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.bytatech.clientonboard.client.dms.ClientConfiguration;

@FeignClient(name="${DMS.name:DMS}", url="${DMS.url:http://localhost/alfresco/api/-default-/public/alfresco/versions/1}", configuration = ClientConfiguration.class)
public interface GroupsApiClient extends GroupsApi {
}