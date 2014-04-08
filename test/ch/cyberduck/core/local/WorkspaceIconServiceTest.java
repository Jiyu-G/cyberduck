package ch.cyberduck.core.local;

import ch.cyberduck.core.AbstractTestCase;
import ch.cyberduck.core.Local;
import ch.cyberduck.core.NullLocal;
import ch.cyberduck.core.Preferences;
import ch.cyberduck.ui.cocoa.application.NSImage;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @version $Id$
 */
public class WorkspaceIconServiceTest extends AbstractTestCase {

    @BeforeClass
    public static void register() {
        WorkspaceIconService.register();
    }

    @Test
    public void testSetProgressNoFile() throws Exception {
        final WorkspaceIconService s = (WorkspaceIconService) IconServiceFactory.get();
        final Local file = new FinderLocal(Preferences.instance().getProperty("tmp.dir"),
                UUID.randomUUID().toString());
        assertFalse(s.update(file, NSImage.imageWithContentsOfFile("img/download0.icns")));
    }

    @Test
    public void testSetProgress() throws Exception {
        final WorkspaceIconService s = (WorkspaceIconService) IconServiceFactory.get();
        final Local file = new FinderLocal(Preferences.instance().getProperty("tmp.dir"),
                UUID.randomUUID().toString());
        LocalTouchFactory.get().touch(file);
        assertTrue(s.update(file, NSImage.imageWithContentsOfFile("img/download0.icns")));
        file.delete();
    }

    @Test
    public void testRemove() throws Exception {
        final WorkspaceIconService s = (WorkspaceIconService) IconServiceFactory.get();
        final Local file = new FinderLocal(Preferences.instance().getProperty("tmp.dir"),
                UUID.randomUUID().toString());
        assertFalse(s.remove(file));
        LocalTouchFactory.get().touch(file);
        assertFalse(s.remove(file));
        assertTrue(s.update(file, NSImage.imageWithContentsOfFile("img/download0.icns")));
        assertTrue(s.remove(file));
        file.delete();
    }
}