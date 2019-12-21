package com.jyr.iot.thing.controller;

import com.jyr.iot.thing.pojogroup.ProjectThing;
import com.jyr.iot.thing.service.ProjectThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@CrossOrigin
@Controller
public class ProjectThingController {
    @Autowired
    private ProjectThingService projectThingService;
    @RequestMapping("getha")
    @ResponseBody
    public String getha(){
        return "getha";
    }

    @RequestMapping("getProjectThingByProjectId/{projectId}")
    @ResponseBody
    public ProjectThing getProjectThingByProjectId(@PathVariable("projectId") Integer projectId){
        return projectThingService.getProjectThingByProjectId(projectId);
    }
}
