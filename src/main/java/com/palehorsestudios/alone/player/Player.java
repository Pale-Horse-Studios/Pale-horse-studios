package com.palehorsestudios.alone.player;

import com.google.common.collect.ImmutableSet;
import com.palehorsestudios.alone.Food;
import com.palehorsestudios.alone.Item;
import com.palehorsestudios.alone.Result;
import com.palehorsestudios.alone.Shelter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class Player {
  // static constants
  private static final int MIN_HYDRATION = 0;
  private static final int MAX_HYDRATION = 10;
  private static final int MIN_WEIGHT = 0;
  private static final int MIN_MORALE = 0;
  private static final int MAX_MORALE = 10;
  private static final int SERVING_SIZE = 227;
  private static final int FIREWOOD_BUNDLE = 1;
  private static final double CALORIES_PER_POUND = 285.7;
  private static final Logger logger = LoggerFactory.getLogger("Player logger");
  private final Set<Item> items;
  private final Shelter shelter;
  // instance vars
  private int hydration;
  private double weight;
  private int morale;

  /** Public constructor for Player. */
  public Player(Set<Item> items) {
    this.hydration = 10;
    this.weight = 180;
    this.morale = 5;
    this.items = new HashSet<>(items);
    this.shelter = new Shelter();
  }

  // getters

  /**
   * Getter for Player hydration.
   *
   * @return Player hydration.
   */
  public int getHydration() {
    return hydration;
  }

  /**
   * Setter for Player hydration.
   *
   * @param hydration value for Player hydration.
   */
  public void setHydration(int hydration) {
    hydration < MIN_HYDRATION ? MIN_HYDRATION : Math.min(hydration, MAX_HYDRATION);
    if (hydration < MIN_HYDRATION) {
      this.hydration = MIN_HYDRATION;
    } else if(hydration > MAX_HYDRATION) {
      this.hydration = MAX_HYDRATION;
    } else {
      this.hydration = hydration;
    }
  }

  /**
   * Getter for Player weight.
   *
   * @return Player weight.
   */
  public double getWeight() {
    return weight;
  }

  /**
   * Setter for Player weight.
   *
   * @param weight value for Player weight.
   */
  public void setWeight(double weight) {
    this.weight = Math.max(MIN_WEIGHT, weight);
  }

  /**
   * Getter for Player morale.
   *
   * @return Player morale.
   */
  public int getMorale() {
    return morale;
  }

  // setters
  /**
   * Getter for items Player is currently carrying.
   *
   * @return ImmutableSet of Player items.
   */
  public ImmutableSet<Item> getItems() {
    return ImmutableSet.copyOf(this.items);
  }

  /**
   * Getter for Player's shelter.
   *
   * @return Player's shelter.
   */
  public Shelter getShelter() {
    return this.shelter;
  }

  /**
   * Setter for Player morale.
   *
   * @param morale value for Player morale.
   * @throws IllegalMoraleArgumentException if {@value Player#MAX_MORALE} < morale < {@value
   *     Player#MIN_MORALE}
   */
  public void updateMorale(int morale) {
    this.morale += morale;
    if (morale < MIN_MORALE) {
      this.morale = MIN_MORALE;
      // Should we create a scenario that the player dies if morale is 0?
    } else if (morale > MAX_MORALE) {
      this.morale = MAX_MORALE;
    }
  }

  // business methods

  /**
   * Method for transferring item from the shelter to the player.
   *
   * @param item Item to be transferred from the shelter to the player.
   * @return Result of the transfer.
   */
  public Result getItemFromShelter(Item item) {
    Result removalResult = this.shelter.removeEquipment(item, 1);
    if (removalResult.getItemCount() > 0) {
      this.items.add(item);
    }
    return removalResult;
  }

  /**
   * Method for transferring item from the player to the shelter.
   *
   * @param item Item to be transferred from the player to the shelter.
   * @return Result of the transfer.
   */
  public Result putItemInShelter(Item item) {
    Result.Builder resultBuilder = new Result.Builder();
    resultBuilder.item(item);
    if (this.items.remove(item)) {
      this.shelter.addEquipment(item, 1);
      resultBuilder.itemCount(1).message("One " + item + " moved to your shelter.");
    } else {
      resultBuilder.itemCount(0).message("You do not have a(n) " + item + " on you.");
    }
    return resultBuilder.build();
  }

  /**
   * Activity method for the player to eat food.
   *
   * @param food Food player trying to eat.
   * @return Result of player trying to eat food.
   */
  public Result eat(Food food) {
    Result.Builder resultBuilder = new Result.Builder();
    Result removalResult = this.shelter.removeFoodFromCache(food, SERVING_SIZE);
    resultBuilder.food(food);

    if (removalResult.getFoodCount() > 0.0) {
      // update player weight
      this.updateWeight(food.getCaloriesPerGram() * removalResult.getFoodCount());

      // load the result builder
      resultBuilder
          .food(food)
          .foodCount(removalResult.getFoodCount())
          .message(
              "You had a hearty meal of " + removalResult.getFoodCount() + " grams of " + food);
    } else {
      resultBuilder.foodCount(removalResult.getFoodCount()).message(removalResult.getMessage());
    }

    return resultBuilder.build();
  }

  public Result goFishing() {
    Result.Builder resultBuilder = new Result.Builder();

    return resultBuilder.build();
  }

  public Result goHunting() {
    return null;
  }

  public Result goTrapping() {
    return null;
  }

  public Result goForaging() {
    return null;
  }

  public Result improveShelter() {
    return null;
  }

  public Result gatherFirewood() {
    Result.Builder resultBuilder = new Result.Builder();
    Random rand = new Random();
    ActivityLevel activityLevel = ActivityLevel.MEDIAN;
    int successRate = rand.nextInt(3) + 1;
    double caloriesBurned = activityLevel.getCaloriesBurned(successRate);
    int firewoodAmount = successRate * FIREWOOD_BUNDLE;
    int morale = successRate;
    updateWeight(-caloriesBurned);
    updateMorale(morale);
    return resultBuilder
            .firewood(firewoodAmount)
            .message("Good Job! You just gathered " + firewoodAmount + " buddles of firewood.")
            .morale(morale)
            .build();
  }
  public Result getWater() {
    return null;
  }

  public Result boostMorale() {
    return null;
  }

  public Result rest() {
    return null;
  }

  // private helper methods
  private void updateWeight(double calorie) {
    this.weight += ((calorie / CALORIES_PER_POUND) * 10) / 10.0;
  }

  @Override
  public String toString() {
    return "Player{"
        + "hydration="
        + hydration
        + ", weight="
        + weight
        + ", morale="
        + morale
        + ", items="
        + items
        + ", shelter="
        + shelter
        + '}';
  }
}
