/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.MyConnection;
import dto.Prop;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Long
 */
public class PropDAO implements Serializable {
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;
    
    private void closeConnection() throws Exception {
        if (rs != null)
            rs.close();
        if (preStm != null)
            preStm.close();
        if (conn != null)
            conn.close();
    }
    
    public boolean insertProp(Prop prop) throws Exception {
        boolean check = false;
        try {
            String query = "Insert into Prop(ID, Name, Description, Image, Amount, Status) values (?,?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, prop.getId());
            preStm.setString(2, prop.getName());
            preStm.setString(3, prop.getDescription());
            preStm.setString(4, prop.getImage());
            preStm.setInt(5, prop.getAmount());
            preStm.setString(6, prop.getStatus());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public List<Prop> findPropsByLikeName(String search) throws Exception {
        List<Prop> list = new ArrayList<>();
        String id = null;
        String name = null;
        String description = null;
        String image = null;
        int amount;
        String status = null;
        String role = "actor";
        try {
            String query = "Select ID, Name, Description, Image, Amount, Status from Prop where Name LIKE ? ORDER BY Status";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                id = rs.getString("ID");
                name = rs.getString("Name");
                description = rs.getString("Description");
                image = rs.getString("Image");
                amount = rs.getInt("Amount");
                status = rs.getString("Status");
                Prop prop = new Prop(id, name, description, image, amount, status);
                list.add(prop);
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean updateProp(Prop prop) throws Exception {
        boolean check = false;
        try {
            String query = "Update Prop set Name = ?, Description = ?, Image = ?, Amount = ?, Status = ? Where ID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, prop.getName());
            preStm.setString(2, prop.getDescription());
            preStm.setString(3, prop.getImage());
            preStm.setInt(4, prop.getAmount());
            preStm.setString(5, prop.getStatus());
            preStm.setString(6, prop.getId());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean deleteProp(String id) throws Exception {
        boolean check = false;
        try {
            String query = "Delete from Prop where ID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public Prop findPropById(String id) throws Exception {
        Prop prop = null;
        try {
            String query = "Select Name, Description, Image, Amount, Status from Prop where ID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(query);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String name = rs.getString("Name");
                String description = rs.getString("Description");
                String image = rs.getString("Image");
                int amount = rs.getInt("Amount");
                String status = rs.getString("Status");
                prop = new Prop(id, name, description, image, amount, status);
            }
        } finally {
            closeConnection();
        }
        return prop;
    }    
}
