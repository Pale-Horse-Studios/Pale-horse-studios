package com.palehorsestudios.alone.player;

import com.palehorsestudios.alone.Food;
import com.palehorsestudios.alone.Item;
import org.junit.Before;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class PlayerTest {

  static final double LOW_ACTIVITY_LOW_SUCCESS_PLAYER_WEIGHT = 179.9;
  static final double LOW_ACTIVITY_MED_SUCCESS_PLAYER_WEIGHT = 179.7;
  static final double LOW_ACTIVITY_HIGH_SUCCESS_PLAYER_WEIGHT = 179.5;
  static final double MED_ACTIVITY_LOW_SUCCESS_PLAYER_WEIGHT = 179.7;
  static final double MED_ACTIVITY_MED_SUCCESS_PLAYER_WEIGHT = 179.5;
  static final double MED_ACTIVITY_HIGH_SUCCESS_PLAYER_WEIGHT = 178.9;
  static final double HIGH_ACTIVITY_LOW_SUCCESS_PLAYER_WEIGHT = 178.8;
  static final double HIGH_ACTIVITY_MED_SUCCESS_PLAYER_WEIGHT = 177.5;
  static final double HIGH_ACTIVITY_HIGH_SUCCESS_PLAYER_WEIGHT = 175.4;

  Player player;
  Logger logger = Logger.getLogger(PlayerTest.class.getName());

  @Before
  public void setUp() {
    Set<Item> items =
        new HashSet<>(
            Arrays.asList(
                Item.AXE,
                Item.KNIFE,
                Item.FISHING_LINE,
                Item.FISHING_HOOKS,
                Item.WIRE,
                Item.HARMONICA,
                Item.FLINT_AND_STEEL,
                Item.POT,
                Item.FIRST_AID_KIT,
                Item.COLD_WEATHER_GEAR));
    player = new Player(items);
    player.getShelter().addFoodToCache(Food.FISH, 1000);
    player.getShelter().addFoodToCache(Food.SQUIRREL, 1000);
    player.getShelter().addFoodToCache(Food.RABBIT, 1000);
    player.getShelter().addFoodToCache(Food.PORCUPINE, 1000);
    player.getShelter().addFoodToCache(Food.MOOSE, 1000);
  }

//  @Test
//  public void testOvernightStatusUpdateHigh() {
//    assertEquals("It was a long cold night. I have to light a fire tonight!", GameApp.overnightStatusUpdate());
//    assertEquals(MED_ACTIVITY_HIGH_SUCCESS_PLAYER_WEIGHT, player.getWeight(), 0.001);
//    assertEquals(2, player.getMorale());
//    assertEquals(2, player.getHydration());
//  }
//
//  @Test
//  public void testOvernightStatusUpdateMedium() {
//    while(player.getShelter().getFirewood() <= 0) {
//      player.gatherFirewood();
//    }
//    player.getItemFromShelter(Item.FLINT_AND_STEEL);
//    while(!player.getShelter().hasFire()) {
//      player.buildFire();
//    }
//    while(player.getShelter().getWaterTank() < 5) {
//      player.getWater();
//    }
//    while(player.getHydration() < 5) {
//      player.drinkWater();
//    }
//    while(player.getMorale() > 8) {
//      player.boostMorale();
//    }
//    double previousWeight = player.getWeight();
//    int previousHydration = player.getHydration();
//    int previousMorale = player.getMorale();
//    assertEquals("It was sure nice to have a fire last night, but this shelter doesn't provide much protection from the elements.", GameApp.overnightStatusUpdate());
//    double weightChange = player.getWeight() - previousWeight;
//    int hydrationChange = player.getHydration() - previousHydration;
//    int moraleChange = player.getMorale() - previousMorale;
//    assertEquals(-(ActivityLevel.MEDIUM.getCaloriesBurned(SuccessRate.MEDIUM) / 285.7), weightChange, 0.05);
//    assertEquals(-ActivityLevel.MEDIUM.getHydrationCost(SuccessRate.MEDIUM), hydrationChange);
//    assertEquals(1, moraleChange);
//  }
//
//  @Test
//  public void testOvernightStatusUpdateLow() {
//    while(player.getShelter().getFirewood() <= 0) {
//      player.gatherFirewood();
//    }
//    player.getItemFromShelter(Item.FLINT_AND_STEEL);
//    while(!player.getShelter().hasFire()) {
//      player.buildFire();
//    }
//    while(player.getShelter().getIntegrity() < 7) {
//      player.improveShelter();
//    }
//    while(player.getShelter().getWaterTank() < 5) {
//      player.getWater();
//    }
//    while(player.getHydration() < 5) {
//      player.drinkWater();
//    }
//    while(player.getMorale() > 7) {
//      player.boostMorale();
//    }
//    double previousWeight = player.getWeight();
//    int previousHydration = player.getHydration();
//    int previousMorale = player.getMorale();
//    assertEquals("Last night was great! I feel refreshed and ready to take on whatever comes my way today.", GameApp.overnightStatusUpdate());
//    double weightChange = player.getWeight() - previousWeight;
//    int hydrationChange = player.getHydration() - previousHydration;
//    int moraleChange = player.getMorale() - previousMorale;
//    assertEquals(-(ActivityLevel.MEDIUM.getCaloriesBurned(SuccessRate.LOW) / 285.7), weightChange, 0.05);
//    assertEquals(-ActivityLevel.MEDIUM.getHydrationCost(SuccessRate.LOW), hydrationChange);
//    assertEquals(2, moraleChange);
//  }
}
