package model;

import entity.PhoneInfor;
import model.connectorhepper.ConnectorHandel;
import util.SQLQueryString;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PhoneModel {
    public ArrayList<PhoneInfor> findAll(){
        try {
            PreparedStatement preparedStatement = ConnectorHandel.getConnection().prepareStatement(SQLQueryString.PHONE_SELECT_ALL);
            ArrayList<PhoneInfor> phoneInfors = new ArrayList<PhoneInfor>();
            ResultSet resultSet =  preparedStatement.executeQuery();
            while (resultSet.next()){
                PhoneInfor phoneInfor = new PhoneInfor();
                phoneInfor.setName(resultSet.getString(2));
                phoneInfor.setBrand(resultSet.getString(3));
                phoneInfor.setPrice(resultSet.getDouble(4));
                phoneInfor.setDescription(resultSet.getString(5));
                phoneInfors.add(phoneInfor);
            }
            return phoneInfors;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public PhoneInfor findById(String id){
        try {
            PreparedStatement preparedStatement = ConnectorHandel.getConnection().prepareStatement(SQLQueryString.PHONE_SELECT_BY_ID);
            preparedStatement.setString(1,id);
            PhoneInfor phoneInfor = new PhoneInfor();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                phoneInfor.setName(resultSet.getString(2));
                phoneInfor.setBrand(resultSet.getString(3));
                phoneInfor.setPrice(resultSet.getDouble(4));
                phoneInfor.setDescription(resultSet.getString(5));

            }
            return phoneInfor;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean save(PhoneInfor phoneInfor){
        try {
            PreparedStatement preparedStatement = ConnectorHandel.getConnection().prepareStatement(SQLQueryString.PHONE_INSERT_NEW);
            preparedStatement.setString(1,phoneInfor.getName());
            preparedStatement.setString(2,phoneInfor.getBrand());
            preparedStatement.setDouble(3,phoneInfor.getPrice());
            preparedStatement.setString(4,phoneInfor.getDescription());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean update(PhoneInfor phoneInfor){
        try {
            PreparedStatement preparedStatement = ConnectorHandel.getConnection().prepareStatement(SQLQueryString.PHONE_UPDATE);
            preparedStatement.setString(1,phoneInfor.getName());
            preparedStatement.setString(2,phoneInfor.getBrand());
            preparedStatement.setDouble(3,phoneInfor.getPrice());
            preparedStatement.setString(4,phoneInfor.getDescription());
            preparedStatement.setLong(5,phoneInfor.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
