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
@RequestMapping("/sd-server/")
public class Controller {
    private static final Logger LOGGER  = LoggerFactory.getLogger(Controller.class);

    final UserService userService;

    public Controller(UserService userService) {
        this.userService = userService;
    }

    /**
     * HTTP
     * GET
     * @return list of users
     */
    @GetMapping(value = "/users")
    public ResponseEntity getUsersJson(){
        return ResponseEntity.ok(userService.getUsers());
    }

    /**
     * HTTP
     * GET
     * @return list of meetings
     */
    @GetMapping(value = "/meetings")
    public ResponseEntity getMeetingsJson(){
        return ResponseEntity.ok(userService.getMeetings());
    }

    /**
     * HTTP
     * GET
     * Get list of users in meeting with given id
     * @param id_meeting
     * @return meeting details
     */
    @GetMapping(value = "/meeting_details/{id_meeting}")
    public ResponseEntity getPeopleMeetingJson(@PathVariable Integer id_meeting){
        return ResponseEntity.ok(userService.getPersonMeetingListDto(id_meeting));
    }

    /**
     * HTTP
     * GET
     * Get list of users in meeting with given code
     * @param code
     * @return meeting details
     */
    @GetMapping(value = "/meeting_details_code")
    public ResponseEntity getPeopleMeetingJson(@RequestParam String code){
        return ResponseEntity.ok(userService.getMeetingDetailsCode(code));
    }

    /**
     * HTTP
     * POST
     * Login user with his email and password
     * @param loginDto
     * @return user object or not found if user doesn't exist
     */
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

    /**
     * HTTP
     * POST
     * Register user
     * @param registerDto
     * @return ok or bad request
     */
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

    /**
     * HTTP
     * POST
     * Create new meeting with given name and password
     * @param name
     * @param password
     * @return ok with new meeting code, or bad request
     */
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

    /**
     * HTTP
     * POST
     * Join meeting with given code and password
     * @param code
     * @param password
     * @return ok or bad request
     */
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

    /**
     * HTTP
     * POST
     * Insert payment
     * @param paymentDto
     * @return ok or bad request
     */
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

    /**
     * HTTP
     * GET
     * Get payments in meeting with given id
     * @param id_meeting
     * @return list of payments
     */
    @GetMapping(value = "/payments_meeting/{id_meeting}")
    public ResponseEntity getPaymentByMeeting(@PathVariable Integer id_meeting){
        return ResponseEntity.ok(userService.getPayments(id_meeting,null,"Meeting"));
    }

    /**
     * HTTP
     * GET
     * Get list of payments by person with given id
     * @param id_person
     * @return list of payments
     */
    @GetMapping(value = "/payments_person/{id_person}")
    public ResponseEntity getPaymentByPerson(@PathVariable Integer id_person){
        return ResponseEntity.ok(userService.getPayments(null,id_person,"Person"));
    }

    /**
     * HTTP
     * GET
     * Get sum of payments in meeting with given id
     * @param id_meeting
     * @return sum of payments
     */
    @GetMapping(value = "/payments_sum_meeting/{id_meeting}")
    public ResponseEntity getPaymentSumMeeting(@PathVariable Integer id_meeting){
        return ResponseEntity.ok(userService.getSumPayments(id_meeting,null,"Meeting"));
    }

    /**
     * HTTP
     * GET
     * Get sum of payments by person with given id
     * @param id_person
     * @return sum of payments
     */
    @GetMapping(value = "/payments_sum_person/{id_person}")
    public ResponseEntity getPaymentSumPerson(@PathVariable Integer id_person){
        return ResponseEntity.ok(userService.getSumPayments(null,id_person,"Person"));
    }

    /**
     * HTTP
     * GET
     * Get meetings that person with given id is a part of
     * @param id_person
     * @return list of meetings
     */
    @GetMapping(value = "/person_meetings")
    public ResponseEntity getPersonMeetings(@RequestParam Integer id_person){
        return ResponseEntity.ok(userService.getPersonMeetings(id_person));
    }

    /**
     * HTTP
     * GET
     * Get list of products added to meeting with given id
     * @param id_meeting
     * @return list of products
     */
    @GetMapping(value = "/products")
    public ResponseEntity getProducts(@RequestParam Integer id_meeting){
        return ResponseEntity.ok(userService.getProducts(id_meeting));
    }

    /**
     * HTTP
     * POST
     * Add product to meeting
     * @param name
     * @param price
     * @param id_person
     * @param id_meeting
     * @return ok or bad request
     */
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

    /**
     * HTTP
     * POST
     * Delete product with given id from meeting
     * @param id_product
     * @return ok or bad request
     */
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

    /**
     * HTTP
     * POST
     * Add person with given nick to meeting with given id
     * @param id_meeting
     * @param nick
     * @return ok or bad request
     */
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
