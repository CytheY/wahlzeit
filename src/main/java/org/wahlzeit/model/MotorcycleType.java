package org.wahlzeit.model;
/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Serialize;
import org.wahlzeit.services.DataObject;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MotorcycleType extends DataObject {
    public enum Type {
        SUPERBIKE,
        ENDURO,
        NAKED,
        SCRAMBLER,
        CHOPPER,
        TOURER,
        CROSS,
        STREETFIGHTER,
        OTHER
    }

    private Type type;

    @Serialize
    private MotorcycleType superType;
    @Serialize
    private Set<MotorcycleType> subTypes = new HashSet<>();

    public MotorcycleType(Type type){
        this(type, null);
    }

    public MotorcycleType(Type type, MotorcycleType superType){
        this.type = type;
        this.superType = superType;
    }

    public Motorcycle createInstance(String brand, String model, int buildYear) {
        return new Motorcycle(this, brand, model, buildYear);
    }

    public MotorcycleType getSuperType() {
        return superType;
    }

    public Iterator<MotorcycleType> getSubTypeIterator() {
        return subTypes.iterator();
    }

    public void addSubType(MotorcycleType mt) {
        assert (mt != null) : "tried to set null sub-type";
        mt.setSuperType(this);
        subTypes.add(mt);
    }

    private void setSuperType(MotorcycleType motorcycleType) {
        this.superType = motorcycleType;
    }

    public boolean hasInstance(Motorcycle motorcylce) {
        assert (motorcylce != null) : "asked about null object";
        if (motorcylce.getMotorcycleType() == this) {
            return true;
        }
        for (MotorcycleType type : subTypes) {
            if (type.hasInstance(motorcylce)) {
                return true;
            }
        }
        return false;
    }


}
