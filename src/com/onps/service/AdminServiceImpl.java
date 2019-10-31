package com.onps.service;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.onps.model.Admin;

import com.onps.util.CommonConstants;
import com.onps.util.CommonUtil;
import com.onps.util.DBConnectionUtil;
import com.onps.util.QueryUtil;

/**
 * This is the Admin Service Implementation Class
 */
public class AdminServiceImpl implements IAdminService {
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(AdminServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static {
		//create table or drop if exist
		
		//createAdminTable();
	}

	private PreparedStatement preparedStatement;

	/**
	 * This method initially drop existing Admin table in the database and recreate table structure to insert admin entries
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error
	 * @throws NullPointerException
	 *             - Service is not available
	 * 
	 */
	public static void createAdminTable() {
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			statement = connection.createStatement();
			
			// Drop table if already exists and as per SQL query available in VoteQuery.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE_ADMIN));
			
			// Create new admin table as per SQL query available in VoteQuery.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE_ADMIN));
		}		
		catch(ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		catch(SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		catch(SAXException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		catch(IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		catch(ParserConfigurationException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		catch(Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add set of admins for as a batch from the selected admin List
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is called on a closed connection
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * 
	 */
	@Override
	public void addAdmin(Admin admin) {
		String id = CommonUtil.generateIDs(getAdminIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			/*
			 * Query is available in VoteQuery.xml file and use insert_admin key to extract value of it
			 */
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_ADMINS));
			
			connection.setAutoCommit(false);
			
			//Generate admin IDs
			admin.setId(id);
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, admin.getId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, admin.getUsername());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, admin.getNic());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, admin.getPassword());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, admin.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, admin.getUserType());
			preparedStatement.setBoolean(CommonConstants.COLUMN_INDEX_SEVEN, admin.isVoted());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, admin.getFname());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, admin.getLname());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, admin.getAddress());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ELEVEN, admin.getDistrict());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWELVE, admin.getProvince());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THIRTEEN, admin.getGender());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOURTEEN, admin.getDoB());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIFTEEN, admin.getPhoneNo());
			
			// Add admin
			preparedStatement.execute();
			connection.commit();
		} 
		catch(ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		catch(SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		catch(SAXException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		catch(IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		catch(ParserConfigurationException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		catch(Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				
				if(connection != null) {
					connection.close();
				}
			} 
			catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
			catch (Exception e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	/**
	 * Admin details can be retrieved based on the provided id
	 * 
	 * @param id
	 * 		   - Admin details are filtered based on the ID
	 * 
	 * @see #actionOnAdmin()
	 */
	@Override
	public Admin getAdminByID(String id) {
		return actionOnAdmin(id).get(0);
	}
	
	/**
	 * Get list of all admins
	 * 
	 * @return ArrayList<Admin> 
	 * 			   - Array of admin list will be returned
	 * 				
	 * @see #actionOnAdmin()
	 */				
	@Override		
	public ArrayList<Admin> getAdmins() {		
		return actionOnAdmin(null);
	}				
					
	/**				
	 * This method delete an admin based on the provided ID
	 * 				
	 * @param id
	 *             - Delete admin according to the filtered admin details
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * @throws NullPointerException
	 *             - Service is not available
	 */
	@Override
	public void removeAdmin(String id) {
		// Before deleting check whether id is available
		if (id != null && !id.isEmpty()) {
			/*
			 * Remove admin query will be retrieved from VoteQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_ADMIN));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, id);
				
				preparedStatement.executeUpdate();
			} 
			catch(ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
			catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
			catch(SAXException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
			catch(IOException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
			catch(ParserConfigurationException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
			catch(Exception e) {
				log.log(Level.SEVERE, e.getMessage());
			}
			finally {
				/*
				 * Close prepared statement and database connectivity at the end of transaction
				 */
				try {
					if(preparedStatement != null) {
						preparedStatement.close();
					}
					
					if(connection != null) {
						connection.close();
					}
				} 
				catch(SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
				catch(Exception e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}

	/**
	 * This performs get admin by id and display all admins
	 * 
	 * @param id
	 *            - ID of the admin to remove or select from the list

	 * @return ArrayList<Admin> Array of admin list will be return
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * @throws NullPointerException
	 *             - Service is not available
	 * 
	 * @see #getAdmins()
	 * @see #getAdminByID(String)
	 */
	private ArrayList<Admin> actionOnAdmin(String id) {

		ArrayList<Admin> adminList = new ArrayList<Admin>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching admin it checks whether id is available
			 */
			if (id != null && !id.isEmpty()) {
				/*
				 * Get admin by ID query will be retrieved from VoteQuery.xml
				 */
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ADMIN));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, id);
			}
			
			/*
			 * If id is not provided for get admin option it display all admins
			 */
			else {
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_ADMINS));
			}
			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Admin admin = new Admin();
				
				admin.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				admin.setUsername(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				admin.setNic(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				admin.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				admin.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				admin.setUserType(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				admin.setVoted(resultSet.getBoolean(CommonConstants.COLUMN_INDEX_SEVEN));
				admin.setFname(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				admin.setLname(resultSet.getString(CommonConstants.COLUMN_INDEX_NINE));
				admin.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_TEN));
				admin.setDistrict(resultSet.getString(CommonConstants.COLUMN_INDEX_ELEVEN));
				admin.setProvince(resultSet.getString(CommonConstants.COLUMN_INDEX_TWELVE));
				admin.setGender(resultSet.getString(CommonConstants.COLUMN_INDEX_THIRTEEN));
				admin.setDoB(resultSet.getString(CommonConstants.COLUMN_INDEX_FOURTEEN));
				admin.setPhoneNo(resultSet.getString(CommonConstants.COLUMN_INDEX_FIFTEEN));
				
				adminList.add(admin);
			}
		} 
		catch(ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		catch(SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		catch(SAXException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		catch(IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		catch(ParserConfigurationException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		catch(Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				
				if(connection != null) {
					connection.close();
				}
			} 
			catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
			catch(Exception e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return adminList;
	}

	/**
	 * Get the updated admin
	 * 
	 * @param id
	 *            ID of the admin to remove or select from the list
	 * 
	 * @return return the Admin object
	 * 
	 */
	@Override
	public Admin updateAdmin(String id, Admin admin) {
		/*
		 * Before fetching admin it checks whether id is available
		 */
		if(id != null && !id.isEmpty()) {			
			/*
			 * Update admin query will be retrieved from VoteQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_ADMIN));
							
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, admin.getUsername());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, admin.getNic());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, admin.getPassword());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, admin.getEmail());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, admin.getUserType());
				preparedStatement.setBoolean(CommonConstants.COLUMN_INDEX_SIX, admin.isVoted());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, admin.getFname());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, admin.getLname());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, admin.getAddress());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, admin.getDistrict());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ELEVEN, admin.getProvince());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWELVE, admin.getGender());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THIRTEEN, admin.getDoB());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOURTEEN, admin.getPhoneNo());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIFTEEN, admin.getId());
				
				preparedStatement.executeUpdate();
			} 
			catch(ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
			catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
			catch(SAXException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
			catch(IOException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
			catch(ParserConfigurationException e) {
				log.log(Level.SEVERE, e.getMessage());
			} 
			catch(Exception e) {
				log.log(Level.SEVERE, e.getMessage());
			}
			finally {
				/*
				 * Close prepared statement and database connectivity at the end of transaction
				 */
				try {
					if(preparedStatement != null) {
						preparedStatement.close();
					}
					
					if(connection != null) {
						connection.close();
					}
				} 
				catch(SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
				catch(Exception e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		
		// Get the updated admin
		return getAdminByID(id);
	}
	
	/**
	 *
	 * @return ArrayList<String> Array of id list will be return
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * @throws NullPointerException
	 *             - Service is not available
	 */
	private ArrayList<String> getAdminIDs() {		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		/*
		 * List of IDs will be retrieved from VoteQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ADMIN_IDS));
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} 
		catch(ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		catch(SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		catch(SAXException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		catch(IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		catch(ParserConfigurationException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		catch(Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				
				if(connection != null) {
					connection.close();
				}
			} 
			catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
			catch(Exception e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return arrayList;
	}
}
