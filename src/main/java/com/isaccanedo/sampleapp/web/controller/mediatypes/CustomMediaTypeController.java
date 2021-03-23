package com.isaccanedo.sampleapp.web.controller.mediatypes;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.isaccanedo.sampleapp.web.dto.isaccanedoItem;
import com.isaccanedo.sampleapp.web.dto.isaccanedoItemV2;

@RestController
@RequestMapping(value = "/", produces = "application/vnd.isaccanedo.api.v1+json")
public class CustomMediaTypeController {

    @RequestMapping(method = RequestMethod.GET, value = "/public/api/items/{id}", produces = "application/vnd.isaccanedo.api.v1+json")
    public @ResponseBody isaccanedoItem getItem(@PathVariable("id") String id) {
        return new isaccanedoItem("itemId1");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/public/api/items/{id}", produces = "application/vnd.isaccanedo.api.v2+json")
    public @ResponseBody isaccanedoItemV2 getItemSecondAPIVersion(@PathVariable("id") String id) {
        return new isaccanedoItemV2("itemName");
    }
}
