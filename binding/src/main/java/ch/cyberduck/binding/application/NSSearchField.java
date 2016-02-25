package ch.cyberduck.binding.application;

/*
 * Copyright (c) 2002-2016 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import org.rococoa.ObjCClass;

public abstract class NSSearchField extends NSTextField {
    private static final _Class CLASS = org.rococoa.Rococoa.createClass("NSSearchField", _Class.class);

    public static NSSearchField searchField() {
        return CLASS.alloc().init();
    }

    public interface _Class extends ObjCClass {
        NSSearchField alloc();
    }

    public abstract NSSearchField init();

    public abstract void setSendsSearchStringImmediately(boolean flag);

    public abstract boolean sendsSearchStringImmediately();

    public abstract void setSendsWholeSearchString(final boolean sendsWholeSearchString);

    public abstract boolean sendsWholeSearchString();
}
