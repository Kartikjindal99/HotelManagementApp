package com.example.HotelManagement.Service;

import com.example.HotelManagement.DTO.HotelDTO;
import com.example.HotelManagement.DTO.UpdateHotelAddressDTO;
import com.example.HotelManagement.Entity.Hotel;
import com.example.HotelManagement.Repository.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class HotelService {

    @Autowired
    HotelRepo hotelRepo;

    public Hotel saveHotel(HotelDTO hotelDTO) {
        Hotel hotel=new Hotel();
        hotel.setName(hotelDTO.getName());
        hotel.setAddress(hotelDTO.getAddress());
        hotel.setCity(hotelDTO.getCity());
        hotel.setPostalCode(hotelDTO.getPostalCode());
        hotel.setRating(hotelDTO.getRating());
        hotel.setAvailable(hotelDTO.isAvailable());

        hotelRepo.save(hotel);
        return hotel;
    }

    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }


    public Hotel getHotelById(Long id) {
        Optional<Hotel>hotelBox= hotelRepo.findById(id);
        if(hotelBox.isPresent()){
           return  hotelBox.get();
        }else{
            return null;
        }
    }


    public Hotel updateHotel(HotelDTO hotelDTO, Long id) {
        Hotel hotel=getHotelById(id);

        if(hotel!=null){
            hotel.setName(hotelDTO.getName());
            hotel.setAddress(hotelDTO.getAddress());
            hotel.setCity(hotelDTO.getCity());
            hotel.setPostalCode(hotelDTO.getPostalCode());
            hotel.setRating(hotelDTO.getRating());
            hotel.setAvailable(hotelDTO.isAvailable());

            return hotelRepo.save(hotel);
        }
        else return hotel;
    }


    public void deleteHotel(Long id) {
        Hotel hotel=getHotelById(id);
        if(hotel!=null){
            hotelRepo.deleteById(id);
        }
    }


    public Hotel updateHotelAddress(UpdateHotelAddressDTO updateHotelAddressDTO, Long id) {
        Hotel hotel=getHotelById(id);
        if(hotel!=null){
            hotel.setAddress(updateHotelAddressDTO.getAddress());
            hotel.setCity(updateHotelAddressDTO.getCity());
            hotel.setPostalCode(updateHotelAddressDTO.getPostalCode());

            hotelRepo.save(hotel);
            return hotel;
        }else{
            return hotel;
        }
    }

    public void deleteAllHotels() {
        hotelRepo.deleteAll();
    }
}
