package com.solace.psg;

import com.solace.messaging.receiver.InboundMessage;
import com.solace.psg.rtsp.cascade.common.SinkCascadeConfig;
import com.solace.psg.rtsp.cascade.common.SinkCascadeInfo;
import com.solace.psg.rtsp.cascade.common.SolaceConfig;
import com.solace.psg.rtsp.cascade.solace.MessagingSvcFactory;
import com.solace.psg.rtsp.cascade.solace.SolaceMessageListener;
import com.solace.psg.rtsp.cascade.solace.VideoChannelInfoRequestor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestSinkClient {

    @Autowired
    private MessagingSvcFactory messagingSvcFactory;

    @Autowired
    SolaceConfig solaceConfig;

    @Autowired
    private SinkCascadeConfig sinkCascadeConf;

    @SolaceMessageListener
    public void sinkCascadeOnReceive(InboundMessage message){
        //Handle video data here...
        //message.getAttachmentByteBuffer().array();
        System.out.println("getSenderTimestamp:" +message.getSenderTimestamp());
        System.out.println("Receiving video data length:" +message.getPayloadAsBytes().length);
    }

    public String getRTSPDescribeInfo(String cameraId) {
        VideoChannelInfoRequestor requestor = new VideoChannelInfoRequestor();
        SinkCascadeInfo sinkCascadeInfo = new SinkCascadeInfo(sinkCascadeConf, cameraId);
        String result = requestor.requestChannelInfo(messagingSvcFactory.getSingletonMessagingSvc(), solaceConfig, cameraId, sinkCascadeInfo.getVideoChannelInfoRequestTopic());
        return result;
    }
}