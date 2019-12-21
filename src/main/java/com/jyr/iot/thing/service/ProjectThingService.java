package com.jyr.iot.thing.service;

import com.jyr.iot.platform.mapper.DeviceMapper;
import com.jyr.iot.platform.mapper.ProjectMapper;
import com.jyr.iot.platform.pojo.Device;
import com.jyr.iot.platform.pojo.DeviceExample;
import com.jyr.iot.platform.pojo.Project;
import com.jyr.iot.thing.pojogroup.ProjectThing;
import com.jyr.iot.thing.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class ProjectThingService {
    @Autowired
    private RedisService redisService;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private DeviceMapper deviceMapper;
    //根据项目ID获取ProjectThing
    public ProjectThing getProjectThingByProjectId(Integer projectId){
        ProjectThing projectThingFromRedis = redisService.getProjectThing(projectId);
        if (projectThingFromRedis!=null){//redis有
//            log.info("从redis中取");
            return projectThingFromRedis;
        }else {
            Project project = projectMapper.selectByPrimaryKey(projectId);
            DeviceExample deviceExample = new DeviceExample();
            DeviceExample.Criteria deviceExampleCriteria = deviceExample.createCriteria();
            deviceExampleCriteria.andDeviceProjectIdEqualTo(projectId);
            List<Device> devices = deviceMapper.selectByExample(deviceExample);
            ProjectThing projectThing = new ProjectThing(project,devices);
            redisService.setProjectThing(projectThing);
            return projectThing;
        }

    }
}
