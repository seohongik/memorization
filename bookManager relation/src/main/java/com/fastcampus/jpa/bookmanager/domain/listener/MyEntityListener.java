package com.fastcampus.jpa.bookmanager.domain.listener;

import com.fastcampus.jpa.bookmanager.domain.listener.Auditable;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class MyEntityListener {

    //@PrePersist
    @PostPersist
    public void prePersist(Object obj){

        if(obj instanceof Auditable){

            ((Auditable) obj).setCreatedAt(LocalDateTime.now());
            ((Auditable) obj).setUpdatedAt(LocalDateTime.now());
        }

    }

    //@PreUpdate
    @PostUpdate
    public void preUpdate(Object obj){

        if(obj instanceof Auditable){

            ((Auditable) obj).setUpdatedAt(LocalDateTime.now());
        }

    }

}
