package ch.cyberduck.core;

/*
 *  Copyright (c) 2005 David Kocher. All rights reserved.
 *  http://cyberduck.ch/
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  Bug fixes, suggestions and comments should be sent to:
 *  dkocher@cyberduck.ch
 */

import org.apache.log4j.Logger;

import java.util.regex.Pattern;

/**
 * @version $Id$
 */
public class HiddenFilesPathFilter<E extends AbstractPath> implements PathFilter<E> {
    private static Logger log = Logger.getLogger(HiddenFilesPathFilter.class);

    private Pattern pattern = Pattern.compile(
            Preferences.instance().getProperty("browser.hidden.regex"));

    public boolean accept(E file) {
        if(null == pattern) {
            return true;
        }
        if(pattern.matcher(file.getName()).matches()) {
            return false;
        }
        if(file.attributes().isDuplicate()) {
            return false;
        }
        return true;
    }
}
