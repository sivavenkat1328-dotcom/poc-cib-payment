package com.cib.notification.controller;

import com.cib.notification.dto.NotificationRequest;

import com.cib.notification.dto.NotificationResponse;

import com.cib.notification.entity.Notification;

import com.cib.notification.service.NotificationService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/notifications")

public class NotificationController {

    @Autowired

    private NotificationService service;


    @PostMapping("/send")

    public NotificationResponse send(

            @RequestBody

            NotificationRequest request){

        return service.sendNotification(

                request);

    }


    @GetMapping

    public List<Notification> getAll(){

        return service.getAllNotifications();

    }


    @GetMapping("/{id}")

    public Notification get(

            @PathVariable Long id){

        return service.getNotification(id);

    }

}