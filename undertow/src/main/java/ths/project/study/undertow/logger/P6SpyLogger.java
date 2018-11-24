package ths.project.study.undertow.logger;

import com.alibaba.druid.sql.SQLUtils;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * @author: wangrd
 * @since: 2018年11月18日 17:00:10
 * @Desc:
 */
public class P6SpyLogger implements MessageFormattingStrategy {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 注释copy from method {@link MessageFormattingStrategy#formatMessage(int, String, long, String, String, String, String)}
     * Formats a log message for the logging module
     *
     * @param connectionId the id of the connection
     * @param now          the current ime expressing in milliseconds
     * @param elapsed      the time in milliseconds that the operation took to complete
     * @param category     the category of the operation
     * @param prepared     the SQL statement with all bind variables replaced with actual values
     * @param sql          the sql statement executed
     * @param url          the database url where the sql statement executed
     * @return the formatted log message
     */
    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        String sqlInfo = null;
        if (StringUtils.isNotBlank(sql)) {
            sqlInfo = "\n----------# " + LocalDateTime.now() + " | took " + elapsed + "ms | category " + category + " | connection " + connectionId
                    + "\n" + SQLUtils.formatMySql(sql) + ";";
        }
        System.out.println(sqlInfo);
        return sqlInfo;
    }
}
