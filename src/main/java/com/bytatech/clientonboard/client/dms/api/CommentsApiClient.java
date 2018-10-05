package com.bytatech.clientonboard.client.dms.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.bytatech.clientonboard.client.dms.ClientConfiguration;

@FeignClient(name="${DMS.name:DMS}", url="${DMS.url:http://35.196.208.144:8902/alfresco/api/-default-/public/alfresco/versions/1}", configuration = ClientConfiguration.class)
public interface CommentsApiClient extends CommentsApi {
}