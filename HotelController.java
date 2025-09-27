package com.example.HotelManagement.Controller;

import com.example.HotelManagement.DTO.HotelDTO;
import com.example.HotelManagement.DTO.UpdateHotelAddressDTO;
import com.example.HotelManagement.Entity.Hotel;
import com.example.HotelManagement.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;


    @PostMapping("/create")
    public Hotel createHotel(@RequestBody HotelDTO hotelDTO){
        return hotelService.saveHotel(hotelDTO);
    }


    @GetMapping("/getallhotels")
    public List<Hotel> getAllHotel(){
        return hotelService.getAllHotels();
    }


    @GetMapping("/gethotelbyid/{id}")
    public Hotel getHotelById(@PathVariable Long id){
       return  hotelService.getHotelById(id);
    }

    @PutMapping("/updatehotel/{id}")
    public Hotel updateHotel(@RequestBody HotelDTO hotelDTO,@PathVariable Long id){
        return hotelService.updateHotel(hotelDTO,id);
    }


    @DeleteMapping("/deletehotel/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable Long id){
        hotelService.deleteHotel(id);
        return ResponseEntity.ok("Hotel with ID " + id + " deleted successfully.");
    }


    @PutMapping("/updatehoteladdress/{id}")
    public Hotel UpdateHotelAddress(@RequestBody UpdateHotelAddressDTO updateHotelAddressDTO,@PathVariable Long id){
        return hotelService.updateHotelAddress(updateHotelAddressDTO,id);
    }

    @DeleteMapping("/deleteallhotels")
    public ResponseEntity<String> deleteAllHotels(){
        hotelService.deleteAllHotels();
        return ResponseEntity.ok("All hotels deleted successfully.");
    }




}
