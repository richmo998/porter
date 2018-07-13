/*
 * Copyright ©2018 vbill.cn.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package cn.vbill.middleware.porter.common.cluster.command;

import cn.vbill.middleware.porter.common.config.LogConfig;
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

/**
 * 推送日志配置 （日志等级推送）
 * 
 * @author: zhangkewei[zhang_kw@suixingpay.com]
 * @date: 2018年02月23日 16:42
 * @version: V1.0
 * @review: zhangkewei[zhang_kw@suixingpay.com]/2018年02月23日 16:42
 */
public class LogConfigPushCommand extends ConfigPushCommand {

    public LogConfigPushCommand() {
        setType(ConfigPushType.LOG);
    }

    public LogConfigPushCommand(LogConfig config) {
        this.config = config;
        setType(ConfigPushType.LOG);
    }

    @Getter
    @Setter
    private LogConfig config;

    @Override
    public String render() {
        return JSONObject.toJSONString(config);
    }
}
