package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtility {
	static ResultSet resultSet;
	static ResultSetMetaData resultSetMetaData;
	
	public static ResultSet getResultSet(String query){
		Connection conn = null;
		Statement statement = null;
		ConfigReader.loadProperty(Constants.CONFIGURATION_FILE_PATH);
		try{
			conn = DriverManager.getConnection(
					ConfigReader.getPropertyValue.apply("dbUrl"),
					ConfigReader.getPropertyValue.apply("dbUsername"),
					ConfigReader.getPropertyValue.apply("dbPassword")
			);
			statement = conn.createStatement();
			resultSet = statement.executeQuery(query);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return resultSet;
	}
	
	/**
	 *
	 * @return ResultSetMetaData
	 */
	public static ResultSetMetaData getResultSetMetaData(String query){
		resultSetMetaData = null;
		resultSet = getResultSet(query);
		try{
			resultSetMetaData = resultSet.getMetaData();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return resultSetMetaData;
	}
	public static List<Map<String,String>> getListOfMapsFromResultSet(String query){
		resultSetMetaData = getResultSetMetaData(query);
		List<Map<String, String>> listFromRset = new ArrayList<>();
		Map<String, String> mapData;
		
		try {
			while (resultSet.next()) {
				mapData = new LinkedHashMap<>();
				
				for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
					String key = resultSetMetaData.getColumnName(i);
					String value = resultSet.getString(key);
					mapData.put(key, value);
				}
				listFromRset.add(mapData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listFromRset;
	}
	
	
	
}
