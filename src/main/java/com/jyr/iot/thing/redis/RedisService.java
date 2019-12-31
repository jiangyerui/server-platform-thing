package com.jyr.iot.thing.redis;

import com.jyr.iot.thing.pojogroup.ProjectThing;
import com.jyr.iot.thing.pojogroup.ZhydData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


/**
 * redis工具
 */
@Slf4j
@Service
public class RedisService {

    @Autowired
    private RedisTemplate<Object, ProjectThing> projectThingRedisTemplate;
    @Autowired
    private RedisTemplate<Object, ZhydData> zhydDataRedisTemplate;

    //    存DeviceProject，用于3D显示
    public void setProjectThing(ProjectThing projectThing){
        projectThingRedisTemplate.opsForValue().set("projectthing/"+projectThing.getProject().getProjectId(),projectThing);
    }
//    取项目中的设备状态，用于3D显示
    public ProjectThing getProjectThing(Integer projectId){
        String projectKey = "projectthing/"+projectId;
        return projectThingRedisTemplate.opsForValue().get(projectKey);
    }
    //    根据MAC取一组智慧用电数据
    public ZhydData getZhyd(String mac){
        return zhydDataRedisTemplate.opsForValue().get(mac);
    }
}
