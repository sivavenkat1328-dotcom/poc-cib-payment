package com.cib.notification.repository;

import com.cib.notification.entity.Notification;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository

        extends JpaRepository<Notification,Long> {

}