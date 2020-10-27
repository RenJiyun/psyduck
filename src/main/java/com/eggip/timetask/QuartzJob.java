package com.eggip.timetask;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 服务名称/类名称/类基本概念/类职责Quartz定时任务
 *
 * @author 陈庆宁
 * @date 2020-09-24 16:19
 */
public class QuartzJob  implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
         System.out.println("Quartz定时任务");
    }
}
