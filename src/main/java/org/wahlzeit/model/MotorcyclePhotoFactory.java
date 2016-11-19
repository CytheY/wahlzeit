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

import org.wahlzeit.services.LogBuilder;

import java.util.logging.Logger;

public class MotorcyclePhotoFactory extends PhotoFactory {

    private static final Logger log = Logger.getLogger(MotorcyclePhotoFactory.class.getName());
    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    private static MotorcyclePhotoFactory instance = null;

    /**
     *
     */
    protected MotorcyclePhotoFactory() {
        super();
    }


    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    public static void initialize() {
        getInstance(); // drops result due to getInstance() side-effects
    }

    /**
     * Public singleton access method.
     */
    public static synchronized MotorcyclePhotoFactory getInstance() {
        if (instance == null) {
            log.config(LogBuilder.createSystemMessage().addAction("setting generic PhotoFactory").toString());
            setInstance(new MotorcyclePhotoFactory());
        }

        return instance;
    }

    /**
     * Method to set the singleton instance of PhotoFactory.
     */
    protected static synchronized void setInstance(MotorcyclePhotoFactory photoFactory) {
        if (instance != null) {
            throw new IllegalStateException("attempt to initalize PhotoFactory twice");
        }

        instance = photoFactory;
    }

    /**
     * @methodtype factory
     */
    public MotorcyclePhoto createPhoto() {
        return new MotorcyclePhoto();
    }

    /**
     * @methodtype factory
     * Creates a new photo with the specified id
     */
    public MotorcyclePhoto createPhoto(PhotoId id) {
        return new MotorcyclePhoto(id);
    }

    /**
     * @methodtype factory
     */
    public MotorcyclePhoto createPhoto(PhotoId id, String brand, String model, int buildYear, MotorcyclePhoto.Type type){
        return new MotorcyclePhoto(id, brand, model, buildYear, type);
    }

}
