package com.product.ProductManagementServices;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {
    Connection conn = null;
    String url = "jdbc:postgresql://localhost:5432/sandesh";
    String username = "postgres";
    String password = "Sandesh@03";

    public ProductDB(){
        try{
            conn = DriverManager.getConnection(url, username, password);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public void save(Product p){
        String sql = "insert into products values(?,?,?,?,?)";

        try{
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, p.getId());
            st.setString(2, p.getName());
            st.setString(3, p.getType());
            st.setString(4, p.getPlace());
            st.setInt(5, p.getWarranty());
            st.execute();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String sql = "select * from products";

        try{
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                Product p = new Product();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setType(rs.getString(3));
                p.setPlace(rs.getString(4));
                p.setWarranty(rs.getInt(5));

                products.add(p);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

        return products;
    }
}
