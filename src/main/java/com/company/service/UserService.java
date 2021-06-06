package com.company.service;

import com.company.dto.*;

public interface UserService {
    UserListDto getUsers();
    MeetingListDto getMeetings();
    boolean logIn(LoginDto loginDto);
    UserDto getLoggedUser();
    boolean registerUser(RegisterDto registerDto);
    MeetingDetailsDto getPersonMeetingListDto(Integer id_meeting);
    boolean joinThruCode(String code, String password, String memberType);
    MeetingDetailsDto getMeetingDetailsCode(String code);
    boolean insertPayment(PaymentDto paymentDto);
    PaymentListDto getPayments(Integer idTable, Integer idPerson, String which);
    boolean createMeeting(String name, String password);
    MeetingListDto getPersonMeetings(Integer id_person);
    ProductListDto getProducts(Integer id_meeting);
    boolean insertProduct(String name, Double price, Integer id_person, Integer id_meeting);
    boolean deleteProduct(Integer id_product);
    boolean addToMeeting(Integer id_meeting, String nick);
    Double getSumPayments(Integer idTable, Integer idPerson, String which);
}
