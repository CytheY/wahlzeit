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

import java.util.*;
import java.util.logging.Logger;

public class MotorcyclePhotoManager extends PhotoManager {

    /**
     *
     */
    protected static final MotorcyclePhotoManager instance = new MotorcyclePhotoManager();

    private static final Logger log = Logger.getLogger(PhotoManager.class.getName());

    /**
     *
     */
    public MotorcyclePhotoManager() {
        photoTagCollector = PhotoFactory.getInstance().createPhotoTagCollector();
    }

    public static MotorcyclePhotoManager getInstance() {
        return instance;
    }
    /**
     *
     */
    public Set<MotorcyclePhoto> findPhotosByType(MotorcyclePhoto.Type type) {
        Set<MotorcyclePhoto> result = new HashSet<>();
        readObjects(result, MotorcyclePhoto.class, "Type", type);

        for (Iterator<MotorcyclePhoto> i = result.iterator(); i.hasNext(); ) {
            doAddPhoto(i.next());
        }

        return result;
    }

}
