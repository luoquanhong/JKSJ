package com.dataBaseUtils;

import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.jdbc.MysqlSavepoint;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Component
public class JDBCUtils {

    public String queryDataDeleteSomeFormat(Connection connection, String sql) {
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
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dataResult;
    }

    public int executeSql(Connection connection, String sql) throws SQLException {
        int flag;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        flag = preparedStatement.executeUpdate();
        return flag;
    }

    public int[] executeSqlWithBatch(Connection connection, List<String> sqlList) throws SQLException {
        int[] flag = new int[sqlList.size()];
        try{
            Statement statement = connection.createStatement();
            sqlList.forEach(sql -> {
                try {
                    statement.addBatch(sql);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            flag = statement.executeBatch();
            connection.commit();
            connection.close();
        }catch (Exception e){
            connection.rollback();
        }
        return flag;
    }

    public int executeSqlWithCommitTransaction(Connection connection, String sql) {
        int flag = 0;
        try {
            flag =  executeSql(connection, sql);
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return flag;
    }

}
