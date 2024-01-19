package com.example.demo.configuration;

import com.gitee.sop.servercommon.bean.ServiceConfig;
import com.gitee.sop.servercommon.configuration.AlipayServiceConfiguration;
import com.gitee.sop.servercommon.configuration.BaseServiceConfiguration;
import com.gitee.sop.servercommon.configuration.ServiceConfiguration;

/**
 * 功能描述
 *
 * @author tonghao
 * @date 2024/1/19 9:16
 */
public class openConfiguration extends AlipayServiceConfiguration {
    static{
        ServiceConfig.getInstance().getI18nModules().add("");
    }
}
