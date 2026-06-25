package com.cib.notification.service;

import com.cib.notification.dto.NotificationRequest;

import com.cib.notification.dto.NotificationResponse;

import com.cib.notification.entity.Notification;

import com.cib.notification.repository.NotificationRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class NotificationService {

    @Autowired

    private NotificationRepository repository;


    public NotificationResponse sendNotification(

            NotificationRequest request){

        Notification notification =

                new Notification();

        notification.setCustomerId(

                request.getCustomerId());

        notification.setType(

                request.getType());

        notification.setMessage(

                request.getMessage());

        notification.setStatus(

                "SENT");

        repository.save(notification);

        return new NotificationResponse(

                "Notification Sent Successfully",

                "SUCCESS");

    }


    public List<Notification> getAllNotifications(){

        return repository.findAll();

    }


    public Notification getNotification(

            Long id){

        return repository.findById(id)

                .orElseThrow(

                        () -> new RuntimeException(

                                "Notification Not Found"));

    }

}