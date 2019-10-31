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

import com.onps.model.Voter;

import com.onps.util.CommonConstants;
import com.onps.util.CommonUtil;
import com.onps.util.DBConnectionUtil;
import com.onps.util.QueryUtil;

/**
 * This is the Voter Service Implementation Class
 */
public class VoterServiceImpl implements IVoterService {
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(VoterServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static {
		//create table or drop if exist
		
		//createVoterTable();
	}

	private PreparedStatement preparedStatement;

	/**
	 * This method initially drop existing Voter table in the database and recreate table structure to insert voter entries
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
	public static void createVoterTable() {
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			statement = connection.createStatement();
			
			// Drop table if already exists and as per SQL query available in VoteQuery.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE_VOTER));
			
			// Create new voter table as per SQL query available in VoteQuery.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE_VOTER));
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
	 * Add set of voters for as a batch from the selected voter List
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
	public void addVoter(Voter voter) {
		String id = CommonUtil.generateIDs(getVoterIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			/*
			 * Query is available in VoteQuery.xml file and use insert_voter key to extract value of it
			 */
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_VOTERS));
			
			connection.setAutoCommit(false);
			
			//Generate voter IDs
			voter.setId(id);
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, voter.getId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, voter.getUsername());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, voter.getNic());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, voter.getPassword());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, voter.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, voter.getUserType());
			preparedStatement.setBoolean(CommonConstants.COLUMN_INDEX_SEVEN, voter.isVoted());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, voter.getFname());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, voter.getLname());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, voter.getAddress());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ELEVEN, voter.getDistrict());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWELVE, voter.getProvince());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THIRTEEN, voter.getGender());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOURTEEN, voter.getDoB());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIFTEEN, voter.getPhoneNo());
			
			// Add voter
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
	 * Voter details can be retrieved based on the provided id
	 * 
	 * @param id
	 * 		   - Voter details are filtered based on the ID
	 * 
	 * @see #actionOnVoter()
	 */
	@Override
	public Voter getVoterByID(String id) {
		return actionOnVoter(id).get(0);
	}
	
	/**
	 * Get list of all voters
	 * 
	 * @return ArrayList<Voter> 
	 * 			   - Array of voter list will be returned
	 * 				
	 * @see #actionOnVoter()
	 */				
	@Override		
	public ArrayList<Voter> getVoters() {		
		return actionOnVoter(null);
	}				
					
	/**				
	 * This method delete an voter based on the provided ID
	 * 				
	 * @param id
	 *             - Delete voter according to the filtered voter details
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
	public void removeVoter(String id) {
		// Before deleting check whether id is available
		if (id != null && !id.isEmpty()) {
			/*
			 * Remove voter query will be retrieved from VoteQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_VOTER));
				
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
	 * This performs get voter by id and display all voters
	 * 
	 * @param id
	 *            - ID of the voter to remove or select from the list

	 * @return ArrayList<Voter> Array of voter list will be return
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
	 * @see #getVoters()
	 * @see #getVoterByID(String)
	 */
	private ArrayList<Voter> actionOnVoter(String id) {

		ArrayList<Voter> voterList = new ArrayList<Voter>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching voter it checks whether id is available
			 */
			if (id != null && !id.isEmpty()) {
				/*
				 * Get voter by ID query will be retrieved from VoteQuery.xml
				 */
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_VOTER));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, id);
			}
			
			/*
			 * If id is not provided for get voter option it display all voters
			 */
			else {
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_VOTERS));
			}
			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Voter voter = new Voter();
				
				voter.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				voter.setUsername(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				voter.setNic(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				voter.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				voter.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				voter.setUserType(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				voter.setVoted(resultSet.getBoolean(CommonConstants.COLUMN_INDEX_SEVEN));
				voter.setFname(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				voter.setLname(resultSet.getString(CommonConstants.COLUMN_INDEX_NINE));
				voter.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_TEN));
				voter.setDistrict(resultSet.getString(CommonConstants.COLUMN_INDEX_ELEVEN));
				voter.setProvince(resultSet.getString(CommonConstants.COLUMN_INDEX_TWELVE));
				voter.setGender(resultSet.getString(CommonConstants.COLUMN_INDEX_THIRTEEN));
				voter.setDoB(resultSet.getString(CommonConstants.COLUMN_INDEX_FOURTEEN));
				voter.setPhoneNo(resultSet.getString(CommonConstants.COLUMN_INDEX_FIFTEEN));
				
				voterList.add(voter);
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
		
		return voterList;
	}

	/**
	 * Get the updated voter
	 * 
	 * @param id
	 *            ID of the voter to remove or select from the list
	 * 
	 * @return return the Voter object
	 * 
	 */
	@Override
	public Voter updateVoter(String id, Voter voter) {
		/*
		 * Before fetching voter it checks whether id is available
		 */
		if(id != null && !id.isEmpty()) {			
			/*
			 * Update voter query will be retrieved from VoteQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_VOTER));
							
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, voter.getUsername());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, voter.getNic());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, voter.getPassword());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, voter.getEmail());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, voter.getUserType());
				preparedStatement.setBoolean(CommonConstants.COLUMN_INDEX_SIX, voter.isVoted());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, voter.getFname());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, voter.getLname());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, voter.getAddress());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, voter.getDistrict());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ELEVEN, voter.getProvince());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWELVE, voter.getGender());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THIRTEEN, voter.getDoB());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOURTEEN, voter.getPhoneNo());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIFTEEN, voter.getId());
				
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
		
		// Get the updated voter
		return getVoterByID(id);
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
	private ArrayList<String> getVoterIDs() {		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		/*
		 * List of IDs will be retrieved from VoteQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_VOTER_IDS));
			
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
