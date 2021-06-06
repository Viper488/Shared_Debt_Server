package com.company.rest;

import com.company.dto.*;
import com.company.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/ud-server/")
public class Controller {
    private static final Logger LOGGER  = LoggerFactory.getLogger(Controller.class);

    @Autowired
    UserService userService;

    @CrossOrigin
    @GetMapping(value = "/start")
    public ResponseEntity workingHttp(){
        return new ResponseEntity("dzialam", HttpStatus.OK);
    }
    @GetMapping(value = "/users")
    public ResponseEntity getUsersJson(){
        return ResponseEntity.ok(userService.getUsers());
    }
    @GetMapping(value = "/meetings")
    public ResponseEntity getMeetingsJson(){
        return ResponseEntity.ok(userService.getMeetings());
    }
    @GetMapping(value = "/meeting_details/{id_meeting}")
    public ResponseEntity getPeopleMeetingJson(@PathVariable Integer id_meeting){
        return ResponseEntity.ok(userService.getPersonMeetingListDto(id_meeting));
    }
    @GetMapping(value = "/meeting_details_code")
    public ResponseEntity getPeopleMeetingJson(@RequestParam String code){
        return ResponseEntity.ok(userService.getMeetingDetailsCode(code));
    }
    @CrossOrigin
    @PostMapping(value = "/login")
    public ResponseEntity loginUserJson(@RequestBody LoginDto loginDto){
        if(userService.logIn(loginDto)){
            LOGGER.info("---- Logged user: " + userService.getLoggedUser().getName() + " " + userService.getLoggedUser().getSurname()+" ----");
            return ResponseEntity.ok().body(new LoggedUser(userService.getLoggedUser().getId_person(),userService.getLoggedUser().getNick(),userService.getLoggedUser().getName(),userService.getLoggedUser().getSurname()));
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin
    @PostMapping(value = "/register")
    public ResponseEntity registerUserJson(@RequestBody RegisterDto registerDto){
        boolean check  = userService.registerUser(registerDto);
        System.out.println(check);
        if(check){
            LOGGER.info("---- Registered user: " + registerDto.getEmail() +" ----");
            return ResponseEntity.ok().build();
        }
        else{
            LOGGER.info("---- User with email: " + registerDto.getEmail() + " already exists in database ----");
            return ResponseEntity.badRequest().build();
        }
    }
    @CrossOrigin
    @PostMapping(value = "/create_meeting")
    public ResponseEntity createMeeting(@RequestParam String name, @RequestParam String password){
        Optional<String> newMeetingCode = userService.createMeeting(name, password);
        if(newMeetingCode.isPresent()){
            LOGGER.info("---- Meeting created successfully ----");
            return ResponseEntity.ok().body(newMeetingCode.get());
        }
        LOGGER.info("---- Error occurred ----");
        return ResponseEntity.badRequest().body("Error occurred");
    }
    @PostMapping(value = "/join_meeting")
    public ResponseEntity joinMeeting(@RequestParam String code, @RequestParam String password){
        if(userService.joinThruCode(code,password,"member")){
            LOGGER.info("---- User: " + userService.getLoggedUser().getNick() + " joined meeting ----");
            return ResponseEntity.ok().body("---- User: " + userService.getLoggedUser().getNick() + " joined meeting ----");
        }
        else{
            LOGGER.info("---- There is no meeting with code: "+ code +" ----");
            return ResponseEntity.badRequest().body("---- There is no meeting with code: "+ code +", or password is wrong ----");
        }
    }
    @CrossOrigin
    @PostMapping(value = "/payment")
    public ResponseEntity insertPayment(@RequestBody PaymentDto paymentDto){
        if(userService.insertPayment(paymentDto)){
            LOGGER.info("---- Payment registered successfully ----");
            return ResponseEntity.ok().body("Payment registered successfully");
        }
        else{
            LOGGER.info("---- Error occurred ----");
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }
    @GetMapping(value = "/payments_meeting/{id_meeting}")
    public ResponseEntity getPaymentByMeeting(@PathVariable Integer id_meeting){
        return ResponseEntity.ok(userService.getPayments(id_meeting,null,"Meeting"));
    }
    @GetMapping(value = "/payments_person/{id_person}")
    public ResponseEntity getPaymentByPerson(@PathVariable Integer id_person){
        return ResponseEntity.ok(userService.getPayments(null,id_person,"Person"));
    }
    @GetMapping(value = "/payments_sum_meeting/{id_meeting}")
    public ResponseEntity getPaymentSumMeeting(@PathVariable Integer id_meeting){
        return ResponseEntity.ok(userService.getSumPayments(id_meeting,null,"Meeting"));
    }
    @GetMapping(value = "/payments_sum_person/{id_person}")
    public ResponseEntity getPaymentSumPerson(@PathVariable Integer id_person){
        return ResponseEntity.ok(userService.getSumPayments(null,id_person,"Person"));
    }
    @GetMapping(value = "/person_meetings")
    public ResponseEntity getPersonMeetings(@RequestParam Integer id_person){
        return ResponseEntity.ok(userService.getPersonMeetings(id_person));
    }
    @GetMapping(value = "/products")
    public ResponseEntity getProducts(@RequestParam Integer id_meeting){
        return ResponseEntity.ok(userService.getProducts(id_meeting));
    }
    @PostMapping(value = "/product")
    public ResponseEntity insertProduct(@RequestParam String name, @RequestParam Double price, @RequestParam Integer id_person, @RequestParam Integer id_meeting){
        if(userService.insertProduct(name, price, id_person, id_meeting)){
            LOGGER.info("---- Product inserted successfully ----");
            return ResponseEntity.ok().body("Product inserted successfully");
        }
        else{
            LOGGER.info("---- Error occurred ----");
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }

    @PostMapping(value = "/delete_product")
    public ResponseEntity deleteProduct(@RequestParam Integer id_product){
        if(userService.deleteProduct(id_product)){
            LOGGER.info("---- Product deleted successfully ----");
            return ResponseEntity.ok().body("Product deleted successfully");
        }
        else{
            LOGGER.info("---- Error occurred ----");
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }
    @PostMapping(value = "/add_person")
    public ResponseEntity addToMeeting(@RequestParam Integer id_meeting, String nick){
        if(userService.addToMeeting(id_meeting,nick)){
            LOGGER.info("---- Person added successfully ----");
            return ResponseEntity.ok().body("Person added successfully");
        }
        else{
            LOGGER.info("---- Error occurred ----");
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }
}
