package persistence.config;

import java.io.Serializable;
import java.sql.Connection;

public interface DbConnector extends Serializable{

Connection startConnection() throws Exception;

void closeConnection() throws Exception;

void rollbackTransaction() throws Exception;

void commit() throws Exception;
}