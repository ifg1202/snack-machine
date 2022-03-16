package com.qacg.snackmachine.application.domain

abstract class Entity {

    UUID id

    @Override
    boolean equals(Object obj) {
        if(obj == this)
            return true
        if(obj == null || !(obj instanceof Entity))
            return false
        return id == ((Entity) obj).id
    }

}
