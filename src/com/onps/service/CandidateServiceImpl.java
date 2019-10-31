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

import com.onps.model.Candidate;

import com.onps.util.CommonConstants;
import com.onps.util.CommonUtil;
import com.onps.util.DBConnectionUtil;
import com.onps.util.QueryUtil;

/**
 * This is the Candidate Service Implementation Class
 */
public class CandidateServiceImpl implements ICandidateService {
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(CandidateServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static {
		//create table or drop if exist
		
		//createCandidateTable();
	}

	private PreparedStatement preparedStatement;

	/**
	 * This method initially drop existing Candidate table in the database and recreate table structure to insert candidate entries
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
	public static void createCandidateTable() {
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			statement = connection.createStatement();
			
			// Drop table if already exists and as per SQL query available in VoteQuery.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE_CANDIDATE));
			
			// Create new candidate table as per SQL query available in VoteQuery.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE_CANDIDATE));
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
	 * Add set of candidates for as a batch from the selected candidate List
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
	public void addCandidate(Candidate candidate) {
		String id = CommonUtil.generateIDs(getCandidateIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			/*
			 * Query is available in VoteQuery.xml file and use insert_candidate key to extract value of it
			 */
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_CANDIDATES));
			
			connection.setAutoCommit(false);
			
			//Generate candidate IDs
			candidate.setId(id);
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, candidate.getId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, candidate.getUsername());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, candidate.getNic());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, candidate.getPassword());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, candidate.getEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, candidate.getUserType());
			preparedStatement.setBoolean(CommonConstants.COLUMN_INDEX_SEVEN, candidate.isVoted());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, candidate.getFname());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, candidate.getLname());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, candidate.getAddress());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ELEVEN, candidate.getDistrict());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWELVE, candidate.getProvince());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THIRTEEN, candidate.getGender());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOURTEEN, candidate.getDoB());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIFTEEN, candidate.getPhoneNo());
			
			// Add candidate
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
	 * Candidate details can be retrieved based on the provided id
	 * 
	 * @param id
	 * 		   - Candidate details are filtered based on the ID
	 * 
	 * @see #actionOnCandidate()
	 */
	@Override
	public Candidate getCandidateByID(String id) {
		return actionOnCandidate(id).get(0);
	}
	
	/**
	 * Get list of all candidates
	 * 
	 * @return ArrayList<Candidate> 
	 * 			   - Array of candidate list will be returned
	 * 				
	 * @see #actionOnCandidate()
	 */				
	@Override		
	public ArrayList<Candidate> getCandidates() {		
		return actionOnCandidate(null);
	}				
					
	/**				
	 * This method delete an candidate based on the provided ID
	 * 				
	 * @param id
	 *             - Delete candidate according to the filtered candidate details
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
	public void removeCandidate(String id) {
		// Before deleting check whether id is available
		if (id != null && !id.isEmpty()) {
			/*
			 * Remove candidate query will be retrieved from VoteQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_CANDIDATE));
				
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
	 * This performs get candidate by id and display all candidates
	 * 
	 * @param id
	 *            - ID of the candidate to remove or select from the list

	 * @return ArrayList<Candidate> Array of candidate list will be return
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
	 * @see #getCandidates()
	 * @see #getCandidateByID(String)
	 */
	private ArrayList<Candidate> actionOnCandidate(String id) {

		ArrayList<Candidate> candidateList = new ArrayList<Candidate>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching candidate it checks whether id is available
			 */
			if (id != null && !id.isEmpty()) {
				/*
				 * Get candidate by ID query will be retrieved from VoteQuery.xml
				 */
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CANDIDATE));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, id);
			}
			
			/*
			 * If id is not provided for get candidate option it display all candidates
			 */
			else {
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_CANDIDATES));
			}
			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Candidate candidate = new Candidate();
				
				candidate.setId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				candidate.setUsername(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				candidate.setNic(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				candidate.setPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				candidate.setEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				candidate.setUserType(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				candidate.setVoted(resultSet.getBoolean(CommonConstants.COLUMN_INDEX_SEVEN));
				candidate.setFname(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				candidate.setLname(resultSet.getString(CommonConstants.COLUMN_INDEX_NINE));
				candidate.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_TEN));
				candidate.setDistrict(resultSet.getString(CommonConstants.COLUMN_INDEX_ELEVEN));
				candidate.setProvince(resultSet.getString(CommonConstants.COLUMN_INDEX_TWELVE));
				candidate.setGender(resultSet.getString(CommonConstants.COLUMN_INDEX_THIRTEEN));
				candidate.setDoB(resultSet.getString(CommonConstants.COLUMN_INDEX_FOURTEEN));
				candidate.setPhoneNo(resultSet.getString(CommonConstants.COLUMN_INDEX_FIFTEEN));
				
				candidateList.add(candidate);
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
		
		return candidateList;
	}

	/**
	 * Get the updated candidate
	 * 
	 * @param id
	 *            ID of the candidate to remove or select from the list
	 * 
	 * @return return the Candidate object
	 * 
	 */
	@Override
	public Candidate updateCandidate(String id, Candidate candidate) {
		/*
		 * Before fetching candidate it checks whether id is available
		 */
		if(id != null && !id.isEmpty()) {			
			/*
			 * Update candidate query will be retrieved from VoteQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_CANDIDATE));
							
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, candidate.getUsername());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, candidate.getNic());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, candidate.getPassword());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, candidate.getEmail());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, candidate.getUserType());
				preparedStatement.setBoolean(CommonConstants.COLUMN_INDEX_SIX, candidate.isVoted());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, candidate.getFname());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, candidate.getLname());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, candidate.getAddress());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, candidate.getDistrict());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ELEVEN, candidate.getProvince());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWELVE, candidate.getGender());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THIRTEEN, candidate.getDoB());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOURTEEN, candidate.getPhoneNo());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIFTEEN, candidate.getId());
				
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
		
		// Get the updated candidate
		return getCandidateByID(id);
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
	private ArrayList<String> getCandidateIDs() {		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		/*
		 * List of IDs will be retrieved from VoteQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CANDIDATE_IDS));
			
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
