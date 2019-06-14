package util;

public class SQLQueryString {
    public static final String PHONE_SELECT_ALL = "SELECT * FROM phone";
    public static final String PHONE_SELECT_BY_ID = "SELECT * FROM phone WHERE ID = ?";
    public static final String PHONE_INSERT_NEW = "INSERT INTO phone(Name,Brand,Price,Description) VALUES (?,?,?,?)";
    public static final String PHONE_DELETE = "UPDATE phone SET Name=?,Brand=?,Price=?,Description=? WHERE Id=?";
    public static final String PHONE_UPDATE = "UPDATE phone SET Name=?,Brand=?,Price=?,Description=? WHERE Id=?";

}
