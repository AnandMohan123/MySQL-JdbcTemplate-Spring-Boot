package com.mySqlConn.demo.repository;

import com.mySqlConn.demo.model.Item;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class ItemRepository {
	
	@Autowired
    JdbcTemplate template;
	
	
    public List<Item> getAllItems(){
        List<Item> items = template.query("select id, name,category from item",(result,rowNum)->new Item(result.getInt("id"),
                result.getString("name"),result.getString("category")));
        return items;
    }

    public Item getItem(int itemId){
        String query = "SELECT * FROM ITEM WHERE ID=?";
        Item item = template.queryForObject(query,new Object[]{itemId},new BeanPropertyRowMapper<>(Item.class));

        return item;
    }

    public int addItem(int id,String name,String category){
        String query = "INSERT INTO ITEM VALUES(?,?,?)";
        return template.update(query,id,name,category);
    }
    // Corrected update query
    public int updateItem(String name,String category, int id){
        String query = "UPDATE ITEM SET name =?, category =? WHERE ID =?";
        return template.update(query,name,category,id);
    }

    public int deleteItem(int id){
        String query = "DELETE FROM ITEM WHERE ID =?";
        return template.update(query,id);
    }
}
