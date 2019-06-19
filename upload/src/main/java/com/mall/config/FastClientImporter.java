package com.mall.config;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/19 23:16
 * @ Description：${description}
 * @ Modified By：
 */
@Configuration
@Import(FdfsClientConfig.class)
/**
 * @author li
 * 解决jmx重复注册bean的问题
 */
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class FastClientImporter {
}
