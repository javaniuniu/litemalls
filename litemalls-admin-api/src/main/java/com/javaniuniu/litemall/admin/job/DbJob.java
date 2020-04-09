package com.javaniuniu.litemall.admin.job;

import com.javaniuniu.litemall.db.util.DbUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

/**
 * 数据库定时备份任务
 * 在backup文件夹中备份最近七日的数据库文件
 *
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/javaniuniu
 * @Date: 2020/4/9 5:27 PM
 */
@Component
public class DbJob {
    private final Log logger = LogFactory.getLog(DbJob.class);

    @Autowired
    private Environment environment;

    /*
     * 定时时间是每天凌晨5点。
     */
    @Scheduled(cron = "0 0 5 * * ?")
    public void backup() throws IOException {
        logger.info("系统开启定时任务数据库备份");

        String user = environment.getProperty("spring.datasource.druid.username");
        String password = environment.getProperty("spring.datasource.druid.password");
        String url = environment.getProperty("spring.datasource.druid.url");
        int index1 = url.indexOf("3306/");
        int index2 = url.indexOf("?");
        String db = url.substring(index1 + 5, index2);

        LocalDate localDate = LocalDate.now();
        String fileName = localDate.toString();
        File file = new File("backup", fileName);
        file.getParentFile().mkdirs();
        file.createNewFile();

        // 备份今天数据库
        DbUtil.backup(file, user, password, db);
        // 删除七天前数据库备份文件
        LocalDate before = localDate.minusDays(7);
        File fileBefore = new File("backup", fileName);
        fileBefore.deleteOnExit();

        logger.info("系统结束定时任务数据库备份");
    }

}
