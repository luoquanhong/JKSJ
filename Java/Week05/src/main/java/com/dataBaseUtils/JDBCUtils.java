package com.dataBaseUtils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Component
public class JDBCUtils {

    public String queryDataDeleteSomeFormat(Connection connection, String sql){
        String tmp = queryDataToList(connection, sql).toString();
        if (tmp.contains("\\")) {
            tmp = StringEscapeUtils.unescapeEcmaScript(tmp);
        }
        return tmp;
    }

    public List<JSONObject> queryDataToList(Connection connection, String sql) {
        List<JSONObject> dataResult = new LinkedList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                JSONObject data = new JSONObject();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    Object columnData = resultSet.getObject(columnName);
                    data.put(columnName, columnData);
                }
                dataResult.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataResult;
    }

}
