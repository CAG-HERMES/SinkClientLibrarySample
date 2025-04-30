package com.solace.psg;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TestGetRTSPDescribeInfo {

    @Autowired
    private TestSinkClient TestSinkClient;

    @Value("${cameraInfo.cameraId}")
    public String cameraId;

    @PostConstruct
    public void testDescribeInfo(){
        System.out.println(">>>>>>>>>> Get describe info:\n" + TestSinkClient.getRTSPDescribeInfo(cameraId));
    }
}
