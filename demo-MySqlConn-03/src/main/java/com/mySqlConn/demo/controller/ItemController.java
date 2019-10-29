package com.mySqlConn.demo.controller;

import java.util.List;
import com.mySqlConn.demo.model.Item;
import com.mySqlConn.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {
	
	@Autowired
    ItemRepository itemRepo;
	
    // updateItem
    @RequestMapping("/updateItem")
    @ResponseBody
    public String updateItem(@RequestParam("id") int id,@RequestParam("name") String name,
                              @RequestParam("category") String category, @RequestParam("id1") int id1){
        if(itemRepo.updateItem(id,name,category,id1) >= 1){
            return "Item updated Successfully";
        }else{
            return "Something went wrong with update !";
        }
    }

    @RequestMapping("/getAllItems")
    @ResponseBody
    public List<Item> getAllItems(){
        return itemRepo.getAllItems();
    }

    @RequestMapping("/getItem")
    @ResponseBody
    public Item getItem(@RequestParam("itemId") int itemId){
        return itemRepo.getItem(itemId);
    }

    @RequestMapping("/addItem")
    @ResponseBody
    public String addItem(@RequestParam("id") int id,@RequestParam("name") String name,
                              @RequestParam("category") String category){
        if(itemRepo.addItem(id,name,category) >= 1){
            return "Item Added Successfully";
        }else{
            return "Something went wrong !";
        }
    }
    @RequestMapping("/deteteItem")
    @ResponseBody
    public String deteteItem(@RequestParam("itemId") int itemId){
        if(itemRepo.deleteItem(itemId) >= 1){
            return "Item Deleted Successfully";
        }else{
            return "Something went wrong !";
        }
    }

}
