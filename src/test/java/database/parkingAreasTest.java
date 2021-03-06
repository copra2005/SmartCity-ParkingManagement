package database;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.parse4j.ParseException;
import org.parse4j.ParseObject;
import org.parse4j.ParseQuery;

import data.management.DBManager;
import data.members.MapLocation;
import data.members.ParkingArea;
import data.members.ParkingAreas;
import data.members.ParkingSlot;
import data.members.ParkingSlotStatus;
import data.members.StickersColor;

/**
 * @Author Inbal Matityahu
 */

public class parkingAreasTest {
	@Test
	public void test() {
		DBManager.initialize();
		Assert.assertEquals(4, new ParkingAreas().getParkingAreas().size());
	}

	@Test
	public void test2() throws ParseException {
		DBManager.initialize();
		try {
			// insert new ParkingArea and ParkingSlots
			final ParkingSlot slot1 = new ParkingSlot("parkingAreasTest1", ParkingSlotStatus.TAKEN, StickersColor.GREEN,
					StickersColor.GREEN, new MapLocation(32.123, 32.123), new Date());
			final Set<ParkingSlot> slots = new HashSet<ParkingSlot>();
			slots.add(slot1);
			slots.add(new ParkingSlot("parkingAreasTest2", ParkingSlotStatus.TAKEN, StickersColor.GREEN,
					StickersColor.GREEN, new MapLocation(0, 0), new Date()));
			assert new ParkingArea(20, "t1", new MapLocation(0, 0), slots, StickersColor.GREEN) != null;

			// test function

			final ParseQuery<ParseObject> query = ParseQuery.getQuery("ParkingArea");
			query.whereEqualTo("areaId", 20);

			final List<ParseObject> areaList = query.find();
			if (areaList == null || areaList.isEmpty())
				throw new RuntimeException("There should be an area with areaId=" + 0);
			Assert.assertEquals(0, new ParkingAreas().getNumOfFreeByArea(new ParkingArea(areaList.get(0))));

			// remove new ParkingArea and ParkingSlots
			final ParseQuery<ParseObject> queryArea = ParseQuery.getQuery("ParkingArea");
			queryArea.whereEqualTo("areaId", 20);
			final List<ParseObject> areaList2 = queryArea.find();
			if (areaList2 == null || areaList2.isEmpty())
				throw new RuntimeException("There was a problem - ParkingSlot table doesnt found");
			new ParkingArea(areaList2.get(0)).deleteParseObject();

			final ParseQuery<ParseObject> query2 = ParseQuery.getQuery("ParkingSlot");
			query2.whereEqualTo("name", "parkingAreasTest1");
			final List<ParseObject> slotList = query2.find();
			if (slotList == null || slotList.isEmpty())
				throw new RuntimeException("There was a problem - ParkingSlot table doesnt found");
			new ParkingSlot(slotList.get(0)).deleteParseObject();

			final ParseQuery<ParseObject> query3 = ParseQuery.getQuery("ParkingSlot");
			query3.whereEqualTo("name", "parkingAreasTest2");
			final List<ParseObject> slotList2 = query3.find();
			if (slotList2 == null || slotList2.isEmpty())
				throw new RuntimeException("There was a problem - ParkingSlot table doesnt found");
			new ParkingSlot(slotList2.get(0)).deleteParseObject();

		} catch (final ParseException e) {
			fail();
		}
	}

	@Test
	public void test3() throws ParseException {
		DBManager.initialize();
		try {
			// insert new ParkingArea and ParkingSlots
			final ParkingSlot slot1 = new ParkingSlot("parkingAreasTest1", ParkingSlotStatus.FREE, StickersColor.GREEN,
					StickersColor.GREEN, new MapLocation(32.123, 32.123), new Date());
			final Set<ParkingSlot> slots = new HashSet<ParkingSlot>();
			slots.add(slot1);
			slots.add(new ParkingSlot("parkingAreasTest2", ParkingSlotStatus.TAKEN, StickersColor.GREEN,
					StickersColor.GREEN, new MapLocation(0, 0), new Date()));
			assert new ParkingArea(20, "t1", new MapLocation(0, 0), slots, StickersColor.GREEN) != null;

			// test function

			final ParseQuery<ParseObject> query = ParseQuery.getQuery("ParkingArea");
			query.whereEqualTo("areaId", 20);

			final List<ParseObject> areaList = query.find();
			if (areaList == null || areaList.isEmpty())
				throw new RuntimeException("There should be an area with areaId=" + 0);
			Assert.assertEquals(1, new ParkingAreas().getNumOfFreeByArea(new ParkingArea(areaList.get(0))));

			// remove new ParkingArea and ParkingSlots
			final ParseQuery<ParseObject> queryArea = ParseQuery.getQuery("ParkingArea");
			queryArea.whereEqualTo("areaId", 20);
			final List<ParseObject> areaList2 = queryArea.find();
			if (areaList2 == null || areaList2.isEmpty())
				throw new RuntimeException("There was a problem - ParkingSlot table doesnt found");
			new ParkingArea(areaList2.get(0)).deleteParseObject();

			final ParseQuery<ParseObject> query2 = ParseQuery.getQuery("ParkingSlot");
			query2.whereEqualTo("name", "parkingAreasTest1");
			final List<ParseObject> slotList = query2.find();
			if (slotList == null || slotList.isEmpty())
				throw new RuntimeException("There was a problem - ParkingSlot table doesnt found");
			new ParkingSlot(slotList.get(0)).deleteParseObject();

			final ParseQuery<ParseObject> query3 = ParseQuery.getQuery("ParkingSlot");
			query3.whereEqualTo("name", "parkingAreasTest2");
			final List<ParseObject> slotList2 = query3.find();
			if (slotList2 == null || slotList2.isEmpty())
				throw new RuntimeException("There was a problem - ParkingSlot table doesnt found");
			new ParkingSlot(slotList2.get(0)).deleteParseObject();

		} catch (final ParseException e) {
			fail();
		}
	}

	@Test
	public void test4() throws ParseException {
		DBManager.initialize();
		try {
			// insert new ParkingArea and ParkingSlots
			final ParkingSlot slot1 = new ParkingSlot("parkingAreasTest1", ParkingSlotStatus.FREE, StickersColor.GREEN,
					StickersColor.GREEN, new MapLocation(32.123, 32.123), new Date());
			final Set<ParkingSlot> slots = new HashSet<ParkingSlot>();
			slots.add(slot1);
			slots.add(new ParkingSlot("parkingAreasTest2", ParkingSlotStatus.TAKEN, StickersColor.GREEN,
					StickersColor.GREEN, new MapLocation(0, 0), new Date()));
			assert new ParkingArea(20, "t1", new MapLocation(0, 0), slots, StickersColor.GREEN) != null;

			// test function

			final ParseQuery<ParseObject> query = ParseQuery.getQuery("ParkingArea");
			query.whereEqualTo("areaId", 20);

			final List<ParseObject> areaList = query.find();
			if (areaList == null || areaList.isEmpty())
				throw new RuntimeException("There should be an area with areaId=" + 0);
			Assert.assertEquals(1, new ParkingAreas().getNumOfTakenByArea(new ParkingArea(areaList.get(0))));

			// remove new ParkingArea and ParkingSlots
			final ParseQuery<ParseObject> queryArea = ParseQuery.getQuery("ParkingArea");
			queryArea.whereEqualTo("areaId", 20);
			final List<ParseObject> areaList2 = queryArea.find();
			if (areaList2 == null || areaList2.isEmpty())
				throw new RuntimeException("There was a problem - ParkingSlot table doesnt found");
			new ParkingArea(areaList2.get(0)).deleteParseObject();

			final ParseQuery<ParseObject> query2 = ParseQuery.getQuery("ParkingSlot");
			query2.whereEqualTo("name", "parkingAreasTest1");
			final List<ParseObject> slotList = query2.find();
			if (slotList == null || slotList.isEmpty())
				throw new RuntimeException("There was a problem - ParkingSlot table doesnt found");
			new ParkingSlot(slotList.get(0)).deleteParseObject();

			final ParseQuery<ParseObject> query3 = ParseQuery.getQuery("ParkingSlot");
			query3.whereEqualTo("name", "parkingAreasTest2");
			final List<ParseObject> slotList2 = query3.find();
			if (slotList2 == null || slotList2.isEmpty())
				throw new RuntimeException("There was a problem - ParkingSlot table doesnt found");
			new ParkingSlot(slotList2.get(0)).deleteParseObject();

		} catch (final ParseException e) {
			fail();
		}
	}

	@Test
	public void test5() throws ParseException {
		DBManager.initialize();
		try {
			// insert new ParkingArea and ParkingSlots
			final ParkingSlot slot1 = new ParkingSlot("parkingAreasTest1", ParkingSlotStatus.FREE, StickersColor.GREEN,
					StickersColor.GREEN, new MapLocation(32.123, 32.123), new Date());
			final Set<ParkingSlot> slots = new HashSet<ParkingSlot>();
			slots.add(slot1);
			slots.add(new ParkingSlot("parkingAreasTest2", ParkingSlotStatus.FREE, StickersColor.GREEN,
					StickersColor.GREEN, new MapLocation(0, 0), new Date()));
			assert new ParkingArea(20, "t1", new MapLocation(0, 0), slots, StickersColor.GREEN) != null;

			// test function

			final ParseQuery<ParseObject> query = ParseQuery.getQuery("ParkingArea");
			query.whereEqualTo("areaId", 20);

			final List<ParseObject> areaList = query.find();
			if (areaList == null || areaList.isEmpty())
				throw new RuntimeException("There should be an area with areaId=" + 0);
			Assert.assertEquals(0, new ParkingAreas().getNumOfTakenByArea(new ParkingArea(areaList.get(0))));

			// remove new ParkingArea and ParkingSlots
			// delete objects
			final ParseQuery<ParseObject> queryArea = ParseQuery.getQuery("ParkingArea");
			queryArea.whereEqualTo("areaId", 20);
			final List<ParseObject> areaList2 = queryArea.find();
			if (areaList2 == null || areaList2.isEmpty())
				throw new RuntimeException("There was a problem - ParkingSlot table doesnt found");
			new ParkingArea(areaList2.get(0)).deleteParseObject();

			final ParseQuery<ParseObject> query2 = ParseQuery.getQuery("ParkingSlot");
			query2.whereEqualTo("name", "parkingAreasTest1");
			final List<ParseObject> slotList = query2.find();
			if (slotList == null || slotList.isEmpty())
				throw new RuntimeException("There was a problem - ParkingSlot table doesnt found");
			new ParkingSlot(slotList.get(0)).deleteParseObject();

			final ParseQuery<ParseObject> query3 = ParseQuery.getQuery("ParkingSlot");
			query3.whereEqualTo("name", "parkingAreasTest2");
			final List<ParseObject> slotList2 = query3.find();
			if (slotList2 == null || slotList2.isEmpty())
				throw new RuntimeException("There was a problem - ParkingSlot table doesnt found");
			new ParkingSlot(slotList2.get(0)).deleteParseObject();

		} catch (final ParseException e) {
			fail();
		}
	}

	@Test
	public void test6() throws ParseException {
		// Arrange
		DBManager.initialize();
		final ParkingSlot slot1 = new ParkingSlot("testS1", ParkingSlotStatus.FREE, StickersColor.RED, StickersColor.RED,
				new MapLocation(0, 0), new Date()),
				slot2 = new ParkingSlot("testS2", ParkingSlotStatus.FREE, StickersColor.RED, StickersColor.RED,
						new MapLocation(0, 0), new Date());
		final Set<ParkingSlot> slots = new HashSet<ParkingSlot>();
		slots.add(slot1);
		slots.add(slot2);

		final MapLocation loc = new MapLocation(0, 0);
		final ParkingArea area1 = new ParkingArea(0, "t1", loc, slots, StickersColor.RED),
				area2 = new ParkingArea(0, "t2", loc, slots, StickersColor.RED);
		final Set<ParkingArea> a = new HashSet<ParkingArea>();
		a.add(area1);
		a.add(area2);
		final ParkingAreas areas = new ParkingAreas(a);

		final int taken = areas.getNumOfTakenSlots();
		// Assert
		Assert.assertEquals(4, areas.getNumOfFreeSlots());
		Assert.assertEquals(0, taken);

		// Cleanup
		areas.deleteParseObject();
		area1.deleteParseObject();
		area2.deleteParseObject();
		slot1.deleteParseObject();
		slot2.deleteParseObject();
	}

	@Test
	public void test7() {
		DBManager.initialize();
		try {
			// insert new ParkingArea and ParkingSlots
			final ParkingSlot slot1 = new ParkingSlot("parkingAreasTest1", ParkingSlotStatus.FREE, StickersColor.GREEN,
					StickersColor.GREEN, new MapLocation(32.123, 32.123), new Date());
			final Set<ParkingSlot> slots = new HashSet<ParkingSlot>();
			slots.add(slot1);
			slots.add(new ParkingSlot("parkingAreasTest2", ParkingSlotStatus.FREE, StickersColor.GREEN,
					StickersColor.GREEN, new MapLocation(0, 0), new Date()));
			assert new ParkingArea(20, "t1", new MapLocation(0, 0), slots, StickersColor.GREEN) != null;

			// test function

			final ParseQuery<ParseObject> query = ParseQuery.getQuery("ParkingArea");
			query.whereEqualTo("areaId", 20);

			final List<ParseObject> areaList = query.find();
			if (areaList == null || areaList.isEmpty())
				throw new RuntimeException("There should be an area with areaId=" + 0);
			Assert.assertEquals(2, new ParkingAreas().getNumOfSlotsByArea(new ParkingArea(areaList.get(0))));

			// remove new ParkingArea and ParkingSlots
			final ParseQuery<ParseObject> queryArea = ParseQuery.getQuery("ParkingArea");
			queryArea.whereEqualTo("areaId", 20);
			final List<ParseObject> areaList2 = queryArea.find();
			if (areaList2 == null || areaList2.isEmpty())
				throw new RuntimeException("There was a problem - ParkingSlot table doesnt found");
			new ParkingArea(areaList2.get(0)).deleteParseObject();

			final ParseQuery<ParseObject> query2 = ParseQuery.getQuery("ParkingSlot");
			query2.whereEqualTo("name", "parkingAreasTest1");
			final List<ParseObject> slotList = query2.find();
			if (slotList == null || slotList.isEmpty())
				throw new RuntimeException("There was a problem - ParkingSlot table doesnt found");
			new ParkingSlot(slotList.get(0)).deleteParseObject();

			final ParseQuery<ParseObject> query3 = ParseQuery.getQuery("ParkingSlot");
			query3.whereEqualTo("name", "parkingAreasTest2");
			final List<ParseObject> slotList2 = query3.find();
			if (slotList2 == null || slotList2.isEmpty())
				throw new RuntimeException("There was a problem - ParkingSlot table doesnt found");
			new ParkingSlot(slotList2.get(0)).deleteParseObject();

		} catch (final ParseException e) {
			fail();
		}
	}

	@Test
	public void test8() {
		DBManager.initialize();
		try {
			// insert new ParkingArea and ParkingSlots
			final ParkingSlot slot1 = new ParkingSlot("parkingAreasTest1", ParkingSlotStatus.FREE, StickersColor.GREEN,
					StickersColor.GREEN, new MapLocation(32.123, 32.123), new Date());
			final Set<ParkingSlot> slots = new HashSet<ParkingSlot>();
			slots.add(slot1);
			slots.add(new ParkingSlot("parkingAreasTest2", ParkingSlotStatus.FREE, StickersColor.GREEN,
					StickersColor.GREEN, new MapLocation(0, 0), new Date()));
			assert new ParkingArea(20, "t1", new MapLocation(0, 0), slots, StickersColor.GREEN) != null;

			// test function

			final ParseQuery<ParseObject> query = ParseQuery.getQuery("ParkingArea");
			query.whereEqualTo("areaId", 20);

			final List<ParseObject> areaList = query.find();
			if (areaList == null || areaList.isEmpty())
				throw new RuntimeException("There should be an area with areaId=" + 0);
			if (!"parkingAreasTest1".equalsIgnoreCase(
					new ParkingAreas().getParkingslotByArea(new ParkingArea(areaList.get(0))).getName())
					&& !"parkingAreasTest1".equalsIgnoreCase(
							new ParkingAreas().getParkingslotByArea(new ParkingArea(areaList.get(0))).getName())
					&& !"parkingAreasTest2".equalsIgnoreCase(
							new ParkingAreas().getParkingslotByArea(new ParkingArea(areaList.get(0))).getName()))
				Assert.fail();
			// remove new ParkingArea and ParkingSlots
			final ParseQuery<ParseObject> queryArea = ParseQuery.getQuery("ParkingArea");
			queryArea.whereEqualTo("areaId", 20);
			final List<ParseObject> areaList2 = queryArea.find();
			if (areaList2 == null || areaList2.isEmpty())
				throw new RuntimeException("There was a problem - ParkingSlot table doesnt found");
			new ParkingArea(areaList2.get(0)).deleteParseObject();

			final ParseQuery<ParseObject> query2 = ParseQuery.getQuery("ParkingSlot");
			query2.whereEqualTo("name", "parkingAreasTest1");
			final List<ParseObject> slotList = query2.find();
			if (slotList == null || slotList.isEmpty())
				throw new RuntimeException("There was a problem - ParkingSlot table doesnt found");
			new ParkingSlot(slotList.get(0)).deleteParseObject();

			final ParseQuery<ParseObject> query3 = ParseQuery.getQuery("ParkingSlot");
			query3.whereEqualTo("name", "parkingAreasTest2");
			final List<ParseObject> slotList2 = query3.find();
			if (slotList2 == null || slotList2.isEmpty())
				throw new RuntimeException("There was a problem - ParkingSlot table doesnt found");
			new ParkingSlot(slotList2.get(0)).deleteParseObject();

		} catch (final ParseException e) {
			fail();
		}

	}

	@Test
	public void test9() throws ParseException {
		// Arrange
		DBManager.initialize();

		final Set<ParkingSlot> slots = new HashSet<ParkingSlot>();
		final MapLocation loc = new MapLocation(0, 0);
		final ParkingArea area1 = new ParkingArea(0, "t1", loc, slots, StickersColor.RED),
				area2 = new ParkingArea(0, "t2", loc, slots, StickersColor.RED),
				area3 = new ParkingArea(0, "t3", loc, slots, StickersColor.RED);
		final Set<ParkingArea> a = new HashSet<ParkingArea>();
		a.add(area1);
		a.add(area2);
		a.add(area3);

		// Act
		final ParkingAreas areas = new ParkingAreas(a);
		final List<String> names = areas.getParkingAreasNames();

		// Assert
		Assert.assertEquals(3, names.size());
		assert names.contains("t1");
		assert names.contains("t2");
		assert names.contains("t3");

		// Cleanup
		areas.deleteParseObject();
		area1.deleteParseObject();
		area2.deleteParseObject();
		area3.deleteParseObject();
	}

	@Test
	public void test10() throws ParseException {
		// Arrange
		DBManager.initialize();
		final ParkingSlot slot1 = new ParkingSlot("testS1", ParkingSlotStatus.FREE, StickersColor.RED, StickersColor.RED,
				new MapLocation(0, 0), new Date()),
				slot2 = new ParkingSlot("testS2", ParkingSlotStatus.FREE, StickersColor.RED, StickersColor.RED,
						new MapLocation(0, 0), new Date());
		final Set<ParkingSlot> slots = new HashSet<ParkingSlot>();
		slots.add(slot1);
		slots.add(slot2);

		final MapLocation loc = new MapLocation(0, 0);
		final ParkingArea area = new ParkingArea(0, "t1", loc, slots, StickersColor.RED);

		final Set<ParkingArea> a = new HashSet<ParkingArea>();
		a.add(area);
		final ParkingAreas areas = new ParkingAreas(a);

		// Act
		final HashMap<String, StickersColor> colors = areas.getParkingAreasColor();
		final HashMap<String, MapLocation> locations = areas.getParkingAreasLocation();

		// Assert
		Assert.assertEquals(1, colors.size());
		Assert.assertEquals(1, locations.size());
		Assert.assertEquals(StickersColor.RED, colors.get("t1"));
		Assert.assertEquals(loc, locations.get("t1"));

		// Cleanup
		areas.deleteParseObject();
		area.deleteParseObject();
		slot1.deleteParseObject();
		slot2.deleteParseObject();
	}

}
