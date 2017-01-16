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

import java.util.HashMap;
import java.util.Map;

public class MotorcycleManager {

    private static final MotorcycleManager instance = new MotorcycleManager();

    private Map<String, Motorcycle> motorcycles = new HashMap<>();
    private Map<MotorcycleType.Type, MotorcycleType> motorcycleTypes = new HashMap<>();


    public static MotorcycleManager getInstance() {
        return instance;
    }

    public Motorcycle createMotorcycle(MotorcycleType.Type typeName, String brand, String model, int buildYear) {
        addMotorcycleType(typeName);

        MotorcycleType mt = getMotorcycleType(typeName);
        Motorcycle result = mt.createInstance( brand, model, buildYear);
        motorcycles.put(result.getName(), result);
        return result;
    }

    public void addMotorcycleType(MotorcycleType.Type type){
        synchronized (motorcycleTypes){
            if(!motorcycleTypes.containsKey(type)) {
                MotorcycleType tmp = new MotorcycleType(type);
                motorcycleTypes.put(type, tmp);
            }
        }
    }

    public MotorcycleType getMotorcycleType(MotorcycleType.Type typeName) {
        return motorcycleTypes.get(typeName);
    }

    public Motorcycle getMotorcycle(String name){
        if(motorcycles.containsKey(name)) {
            return motorcycles.get(name);
        }

        return null;
    }


}
