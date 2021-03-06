package database;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import data.management.DBManager;
import data.members.ParkingSlot;
import data.members.StickersColor;
import data.members.ParkingSlotStatus;
import data.members.MapLocation;
import data.members.ParkingArea;

public class parkingSlotTest {

	@Test
	public void test0() {
		DBManager.initialize();

		// Create a new parking slot in the DB
		// Please note that EVERY activation of this test will result in a new
		// testSlot row in the DB
		try {
			final ParkingSlot p = new ParkingSlot("testSlotA", ParkingSlotStatus.FREE, StickersColor.RED, StickersColor.RED,
					new MapLocation(32.778153, 35.021855), new Date());
			assert p != null;
			p.removeParkingSlotFromDB();
		} catch (final Exception ¢) {
			¢.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void testGetContainingArea() {
		DBManager.initialize();
		try {
			final ParkingSlot slot1 = new ParkingSlot("testS", ParkingSlotStatus.FREE, StickersColor.RED, StickersColor.RED,
					new MapLocation(0, 0), new Date());
			final Set<ParkingSlot> slots = new HashSet<ParkingSlot>();
			slots.add(slot1);
			final ParkingArea area = new ParkingArea(0, "t1", new MapLocation(0, 0), slots, StickersColor.RED);
			Assert.assertEquals(area.getName(), slot1.findContainingParkingArea());

			area.deleteParseObject();
			slot1.deleteParseObject();

		} catch (final Exception ¢) {
			¢.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void testRemoveSlotFromArea() {
		DBManager.initialize();
		try {
			// Arrange
			final ParkingSlot slot1 = new ParkingSlot("testS1", ParkingSlotStatus.FREE, StickersColor.RED, StickersColor.RED,
					new MapLocation(0, 0), new Date());
			final Set<ParkingSlot> slots = new HashSet<ParkingSlot>();
			slots.add(slot1);
			final ParkingArea area = new ParkingArea(12, "t1", new MapLocation(0, 0), slots, StickersColor.RED);

			// Act + assert
			slot1.removeParkingSlotFromAreaAndDB();

			area.deleteParseObject();
		} catch (final Exception ¢) {
			¢.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void getSlotByName() {
		DBManager.initialize();
		try {
			// Arrange
			final ParkingSlot slot1 = new ParkingSlot("testS1", ParkingSlotStatus.FREE, StickersColor.RED, StickersColor.RED,
					new MapLocation(0, 0), new Date());

			// Assert
			Assert.assertEquals(slot1.getObjectId(), new ParkingSlot("testS1").getObjectId());

			// Cleanup
			slot1.deleteParseObject();

		} catch (final Exception ¢) {
			¢.printStackTrace();
			Assert.fail();
		}
	}
}