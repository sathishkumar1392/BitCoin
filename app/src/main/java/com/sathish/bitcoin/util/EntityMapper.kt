package com.sathish.bitcoin.util

interface EntityMapper <Entity, DomainModel>{
     fun mapFromEntity(entity: Entity):DomainModel
}