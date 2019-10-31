package com.onps.util;

/**
 * This is the common constants file for Java Web project
 */
public class CommonConstants {
	/** Constant for config.properties key for query file path */
	public static final String QUERY_XML = "queryFilePath";

	/** Constant for file path of config.properties */
	public static final String PROPERTY_FILE = "config.properties";

	/** Constant for url key of MySQL database in config.properties */
	public static final String URL = "url";

	/** Constant for user name key of MySQL database in config.properties */
	public static final String USERNAME = "username";

	/** Constant for password key of MySQL database in config.properties */
	public static final String PASSWORD = "password";

	/** Constant for driver name key of MySQL database in config.properties */
	public static final String DRIVER_NAME = "driverName";
	
	/** Constant for query tag in VoterQuery.xml */
	public static final String TAG_NAME = "query";

	/** Constant for query id in VoterQuery.xml */
	public static final String ATTRIB_ID = "id";
	
	/** Constant for query id of selecting a particular voter by username, NIC and password in VoteQuery.xml */
	public static final String QUERY_ID_SELECT_VOTER = "voter_by_username_nic_password";
	
	/** Constant for query id of selecting a particular admin by username, NIC and password in VoteQuery.xml */
	public static final String QUERY_ID_SELECT_ADMIN = "admin_by_username_nic_password";
	
	/** Constant for query id of selecting a particular candidate by username, NIC and password in VoteQuery.xml */
	public static final String QUERY_ID_SELECT_CANDIDATE = "candidate_by_username_nic_password";
	
	/** Constant for query id of updating the password by particular email in VoteQuery.xml */
	public static final String QUERY_ID_UPDATE_PASSWORD_VOTER = "update_password_voter";
	
	/** Constant for query id of updating the password by particular email in VoteQuery.xml */
	public static final String QUERY_ID_UPDATE_PASSWORD_CANDIDATE = "update_password_candidate";
	
	/** Constant for query id of updating the password by particular email in VoteQuery.xml */
	public static final String QUERY_ID_UPDATE_PASSWORD_ADMIN = "update_password_admin";
	
	/** Constant for query id of selecting the voter id by a particular NIC in VoteQuery.xml */
	public static final String QUERY_ID_SELECT_VOTER_ID = "select_voter_id";
	
	/** Constant for query id of selecting the admin id by a particular NIC in VoteQuery.xml */
	public static final String QUERY_ID_SELECT_ADMIN_ID = "select_admin_id";
	
	/** Constant for query id of selecting the candidate id by a particular NIC in VoteQuery.xml */
	public static final String QUERY_ID_SELECT_CANDIDATE_ID = "select_candidate_id";
	
	/** Constant for query id of selecting the user type by a particular nic in VoteQuery.xml */
	public static final String QUERY_ID_SELECT_TYPE_VOTER = "select_type_voter";
	
	/** Constant for query id of selecting the user type by a particular nic in VoteQuery.xml */
	public static final String QUERY_ID_SELECT_TYPE_CANDIDATE = "select_type_candidate";
	
	/** Constant for query id of selecting the user type by a particular nic in VoteQuery.xml */
	public static final String QUERY_ID_SELECT_TYPE_ADMIN = "select_type_admin";
	
	/** Constant for query id of drop_table in VoteQuery.xml */
	public static final String QUERY_ID_DROP_TABLE_VOTER = "drop_table_voter";

	/** Constant for query id of create_table in VoteQuery.xml */
	public static final String QUERY_ID_CREATE_TABLE_VOTER = "create_voter_table";
	
	/** Constant for query id of drop_table in VoteQuery.xml */
	public static final String QUERY_ID_DROP_TABLE_ADMIN = "drop_table_admin";

	/** Constant for query id of create_table in VoteQuery.xml */
	public static final String QUERY_ID_CREATE_TABLE_ADMIN = "create_admin_table";
	
	/** Constant for query id of drop_table in VoteQuery.xml */
	public static final String QUERY_ID_DROP_TABLE_CANDIDATE = "drop_table_candidate";

	/** Constant for query id of create_table in VoteQuery.xml */
	public static final String QUERY_ID_CREATE_TABLE_CANDIDATE = "create_candidate_table";

	/** Constant for query id of insert voters in VoteQuery.xml */
	public static final String QUERY_ID_INSERT_VOTERS = "insert_voter";
	
	/** Constant for query id of insert admins in VoteQuery.xml */
	public static final String QUERY_ID_INSERT_ADMINS = "insert_admin";
	
	/** Constant for query id of insert candidates in VoteQuery.xml */
	public static final String QUERY_ID_INSERT_CANDIDATES = "insert_candidate";
	
	/** Constant for query id of insert candidates in VoteQuery.xml */
	public static final String QUERY_ID_INSERT_CANDIDATE = "insert_candidates";

	/** Constant for query id of get a voter in VoteQuery.xml */
	public static final String QUERY_ID_GET_VOTER = "voter_by_id";
	
	/** Constant for query id of get a voter in VoteQuery.xml */
	public static final String QUERY_ID_GET_CANDIDATE = "candidate_by_id";
	
	/** Constant for query id of get a voter in VoteQuery.xml */
	public static final String QUERY_ID_GET_ADMIN = "admin_by_id";

	/** Constant for query id of get all voters in VoteQuery.xml */
	public static final String QUERY_ID_ALL_VOTERS = "all_voters";
	
	/** Constant for query id of get all voters in VoteQuery.xml */
	public static final String QUERY_ID_ALL_CANDIDATES = "all_candidates";
	
	/** Constant for query id of get all voters in VoteQuery.xml */
	public static final String QUERY_ID_ALL_ADMINS = "all_admins";

	/** Constant for query id of remove a voter in VoteQuery.xml */
	public static final String QUERY_ID_REMOVE_VOTER = "remove_voter";
	
	/** Constant for query id of remove a admin in VoteQuery.xml */
	public static final String QUERY_ID_REMOVE_ADMIN = "remove_admin";
	
	/** Constant for query id of remove a candidate in VoteQuery.xml */
	public static final String QUERY_ID_REMOVE_CANDIDATE = "remove_candidate";

	/** Constant for query id of update a voter in VoteQuery.xml */
	public static final String QUERY_ID_UPDATE_VOTER = "update_voter";
	
	/** Constant for query id of update a admin in VoteQuery.xml */
	public static final String QUERY_ID_UPDATE_ADMIN = "update_admin";
	
	/** Constant for query id of update a candidate in VoteQuery.xml */
	public static final String QUERY_ID_UPDATE_CANDIDATE = "update_candidate";

	/** Constant for query id of get all voter IDs in VoteQuery.xml */
	public static final String QUERY_ID_GET_VOTER_IDS = "voter_ids";
	
	/** Constant for query id of get all candidate IDs in VoteQuery.xml */
	public static final String QUERY_ID_GET_CANDIDATE_IDS = "candidate_ids";
	
	/** Constant for query id of get all admin IDs in VoteQuery.xml */
	public static final String QUERY_ID_GET_ADMIN_IDS = "admin_ids";
	
	/** Constant for length of the generated password */
	public static final int LENGTH = 8;
	
	/** Constant for voter id prefix */
	public static final String VOTER_ID_PREFIX = "USER";
	
	/** Constant for Column index one */
	public static final int COLUMN_INDEX_ONE = 1;
	
	/** Constant for Column index two */
	public static final int COLUMN_INDEX_TWO = 2;
	
	/** Constant for Column index three */
	public static final int COLUMN_INDEX_THREE = 3;
	
	/** Constant for Column index four */
	public static final int COLUMN_INDEX_FOUR = 4;
	
	/** Constant for Column index five */
	public static final int COLUMN_INDEX_FIVE = 5;
	
	/** Constant for Column index six */
	public static final int COLUMN_INDEX_SIX = 6;
	
	/** Constant for Column index seven */
	public static final int COLUMN_INDEX_SEVEN = 7;
	
	/** Constant for Column index eight */
	public static final int COLUMN_INDEX_EIGHT = 8;
	
	/** Constant for Column index nine */
	public static final int COLUMN_INDEX_NINE = 9;
	
	/** Constant for Column index ten */
	public static final int COLUMN_INDEX_TEN = 10;
	
	/** Constant for Column index eleven */
	public static final int COLUMN_INDEX_ELEVEN = 11;
	
	/** Constant for Column index twelve */
	public static final int COLUMN_INDEX_TWELVE = 12;
	
	/** Constant for Column index thirteen */
	public static final int COLUMN_INDEX_THIRTEEN = 13;
	
	/** Constant for Column index fourteen */
	public static final int COLUMN_INDEX_FOURTEEN = 14;
	
	/** Constant for Column index fifteen */
	public static final int COLUMN_INDEX_FIFTEEN = 15;
}
