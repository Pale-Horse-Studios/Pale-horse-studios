package com.palehorsestudios.alone;

import com.palehorsestudios.alone.activity.*;
import com.palehorsestudios.alone.gui.GameApp;
import com.palehorsestudios.alone.player.Player;
import javafx.application.Application;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {
  public static void main(String[] args) {
    Application.launch(GameApp.class, args);
  }

  public static Choice parseChoice(String input, Player player) {
    Choice choice;

    Map<String, String> choiceKeywordMap = new HashMap<>(){{
      put("eat moose", "eat");
      put("eat fish", "eat");
      put("eat squirrel", "eat");
      put("eat rabbit", "eat");
      put("eat porcupine", "eat");
      put("eat bug", "eat");
      put("eat bugs", "eat");
      put("eat mushroom", "eat");
      put("eat mushrooms", "eat");
      put("eat berry", "eat");
      put("eat berries", "eat");
      put("eat bear", "eat");
      put("go hunt", "hunt");
      put("go hunting", "hunt");
      put("hunt", "hunt");
      put("hunt moose", "hunt");
      put("hunt squirrel", "hunt");
      put("hunt rabbit", "hunt");
      put("hunt porcupine", "hunt");
      put("forage", "forage");
      put("go forage", "forage");
      put("go foraging", "forage");
      put("hunt bug", "forage");
      put("hunt mushrooms", "forage");
      put("hunt berry", "forage");
      put("hunt bugs", "forage");
      put("hunt mushroom", "forage");
      put("hunt berries", "forage");
      put("get moose", "hunt");
      put("get squirrel", "hunt");
      put("get rabbit", "hunt");
      put("get porcupine", "hunt");
      put("get bug", "forage");
      put("get mushrooms", "forage");
      put("get berry", "forage");
      put("get bugs", "forage");
      put("get mushroom", "forage");
      put("get berries", "forage");
      put("kill moose", "hunt");
      put("kill squirrel", "hunt");
      put("kill rabbit", "hunt");
      put("kill porcupine", "hunt");
      put("kill bug", "forage");
      put("kill mushrooms", "forage");
      put("kill berry", "forage");
      put("kill bugs", "forage");
      put("kill mushroom", "forage");
      put("kill berries", "forage");
      put("trap squirrel", "trap");
      put("trap moose", "trap");
      put("trap rabbit", "trap");
      put("trap porcupine", "trap");
      put("trap", "trap");
      put("trapping", "trap");
      put("go trap", "trap");
      put("go trapping", "trap");
      put("fish", "fish");
      put("fishing", "fish");
      put("go fish", "fish");
      put("go fishing", "fish");
      put("get fishing line", "get");
      put("get fishing lines", "get");
      put("get fishing hooks", "get");
      put("get fishing hook", "get");
      put("get fishing lure", "get");
      put("get fishing lures", "get");
      put("get knife", "get");
      put("get flint and steel", "get");
      put("get bow", "get");
      put("get arrow", "get");
      put("get arrows", "get");
      put("get family photo", "get");
      put("get photo", "get");
      put("get photograph", "get");
      put("get rope", "get");
      put("get parachute chord", "get");
      put("get cordage", "get");
      put("get flare", "get");
      put("get flares", "get");
      put("get extra boots", "get");
      put("get extra boot", "get");
      put("get boots", "get");
      put("get boot", "get");
      put("get extra pants", "get");
      put("get pants", "get");
      put("get sleeping gear", "get");
      put("get sleeping bag", "get");
      put("get cold weather gear", "get");
      put("get cold gear", "get");
      put("get tarp", "get");
      put("get matches", "get");
      put("get match", "get");
      put("get first aid", "get");
      put("get first aid kit", "get");
      put("get flashlight", "get");
      put("get light", "get");
      put("get batteries", "get");
      put("get battery", "get");
      put("get wire", "get");
      put("get 18 gauge wire", "get");
      put("get wires", "get");
      put("get 18 gauge wires", "get");
      put("get snare", "get");
      put("get pot", "get");
      put("get cooking pot", "get");
      put("get axe", "get");
      put("get hatchet", "get");
      put("get iodine tablets", "get");
      put("get iodine", "get");
      put("get tablets", "get");
      put("get pistol", "get");
      put("get gun", "get");
      put("get ammunition", "get");
      put("get cartridges", "get");
      put("get ammo", "get");
      put("get rounds", "get");
      put("get shovel", "get");
      put("get harmonica", "get");
      put("get lighter", "get");
      put("get survival manual", "get");
      put("get manual", "get");
      put("get journal and pen", "get");
      put("get journal", "get");
      put("put fishing line", "put");
      put("put fishing lines", "put");
      put("put fishing hooks", "put");
      put("put fishing hook", "put");
      put("put fishing lure", "put");
      put("put fishing lures", "put");
      put("put knife", "put");
      put("put flint and steel", "put");
      put("put bow", "put");
      put("put arrow", "put");
      put("put arrows", "put");
      put("put family photo", "put");
      put("put photo", "put");
      put("put photograph", "put");
      put("put rope", "put");
      put("put parachute chord", "put");
      put("put cordage", "put");
      put("put flare", "put");
      put("put flares", "put");
      put("put extra boots", "put");
      put("put extra boot", "put");
      put("put boots", "put");
      put("put boot", "put");
      put("put extra pants", "put");
      put("put pants", "put");
      put("put sleeping gear", "put");
      put("put sleeping bag", "put");
      put("put cold weather gear", "put");
      put("put cold gear", "put");
      put("put tarp", "put");
      put("put matches", "put");
      put("put match", "put");
      put("put first aid", "put");
      put("put first aid kit", "put");
      put("put flashlight", "put");
      put("put light", "put");
      put("put batteries", "put");
      put("put battery", "put");
      put("put wire", "put");
      put("put 18 gauge wire", "put");
      put("put wires", "put");
      put("put 18 gauge wires", "put");
      put("put snare", "put");
      put("put pot", "put");
      put("put cooking pot", "put");
      put("put axe", "put");
      put("put hatchet", "put");
      put("put iodine tablets", "put");
      put("put iodine", "put");
      put("put tablets", "put");
      put("put pistol", "put");
      put("put gun", "put");
      put("put ammunition", "put");
      put("put ammo", "put");
      put("put cartridges", "put");
      put("put rounds", "put");
      put("put shovel", "put");
      put("put harmonica", "put");
      put("put lighter", "put");
      put("put survival manual", "put");
      put("put manual", "put");
      put("put journal and pen", "put");
      put("put journal", "put");
      put("build shelter", "improve");
      put("make camp", "improve");
      put("work on camp", "improve");
      put("work on shelter", "improve");
      put("improve shelter", "improve");
      put("improve camp", "improve");
      put("build camp", "improve");
      put("drink", "drink");
      put("drink water", "drink");
      put("get drink", "drink");
      put("take drink", "drink");
      put("get a drink", "drink");
      put("take a drink", "drink");
      put("gather", "gather");
      put("gather firewood", "gather");
      put("get firewood", "gather");
      put("collect firewood", "gather");
      put("cut firewood", "gather");
      put("gather wood", "gather");
      put("get wood", "gather");
      put("collect wood", "gather");
      put("cut wood", "gather");
      put("fire", "fire");
      put("build fire", "fire");
      put("light fire", "fire");
      put("start fire", "fire");
      put("make fire", "fire");
      put("build a fire", "fire");
      put("light a fire", "fire");
      put("start a fire", "fire");
      put("make a fire", "fire");
      put("water", "water");
      put("get water", "water");
      put("fetch water", "water");
      put("collect water", "water");
      put("morale", "morale");
      put("improve morale", "morale");
      put("boost morale", "morale");
      put("photo", "morale");
      put("look at photo", "morale");
      put("look at family photo", "morale");
      put("harmonica", "morale");
      put("play harmonica", "morale");
      put("journal", "morale");
      put("write in journal", "morale");
      put("rest", "rest");
      put("break", "rest");
      put("take rest", "rest");
      put("take break", "rest");
      put("take a rest", "rest");
      put("take a break", "rest");
      put("relax", "rest");
      put("nap", "rest");
      put("take nap", "rest");
      put("take a nap", "rest");
    }};
    Map<String, Food> choiceFoodMap = new HashMap<>(){{
      put("eat moose", Food.MOOSE);
      put("eat fish", Food.FISH);
      put("eat bear", Food.BEAR);
      put("eat squirrel", Food.SQUIRREL);
      put("eat rabbit", Food.RABBIT);
      put("eat porcupine", Food.PORCUPINE);
      put("eat bug", Food.BUG);
      put("eat bugs", Food.BUG);
      put("eat mushroom", Food.MUSHROOM);
      put("eat mushrooms", Food.MUSHROOM);
      put("eat berry", Food.BERRIES);
      put("eat berries", Food.BERRIES);
    }};
    Map<String, Item> choiceItemMap = new HashMap<>(){{
      put("get fishing line", Item.FISHING_LINE);
      put("get fishing lines", Item.FISHING_LINE);
      put("get fishing hooks", Item.FISHING_HOOKS);
      put("get fishing hook", Item.FISHING_HOOKS);
      put("get fishing lure", Item.FISHING_LURES);
      put("get fishing lures", Item.FISHING_LURES);
      put("get knife", Item.KNIFE);
      put("get flint and steel", Item.FLINT_AND_STEEL);
      put("get bow", Item.BOW);
      put("get arrow", Item.ARROWS);
      put("get arrows", Item.ARROWS);
      put("get family photo", Item.FAMILY_PHOTO);
      put("get photo", Item.FAMILY_PHOTO);
      put("get photograph", Item.FAMILY_PHOTO);
      put("get rope", Item.PARACHUTE_CHORD);
      put("get parachute chord", Item.PARACHUTE_CHORD);
      put("get cordage", Item.PARACHUTE_CHORD);
      put("get flare", Item.FLARE);
      put("get flares", Item.FLARE);
      put("get extra boots", Item.EXTRA_BOOTS);
      put("get extra boot", Item.EXTRA_BOOTS);
      put("get boots", Item.EXTRA_BOOTS);
      put("get boot", Item.EXTRA_BOOTS);
      put("get extra pants", Item.EXTRA_PANTS);
      put("get pants", Item.EXTRA_PANTS);
      put("get sleeping gear", Item.SLEEPING_GEAR);
      put("get sleeping bag", Item.SLEEPING_GEAR);
      put("get cold weather gear", Item.COLD_WEATHER_GEAR);
      put("get cold gear", Item.COLD_WEATHER_GEAR);
      put("get tarp", Item.TARP);
      put("get matches", Item.MATCHES);
      put("get match", Item.MATCHES);
      put("get first aid", Item.FIRST_AID_KIT);
      put("get first aid kit", Item.FIRST_AID_KIT);
      put("get flashlight", Item.FLASHLIGHT);
      put("get light", Item.FLASHLIGHT);
      put("get batteries", Item.BATTERIES);
      put("get battery", Item.BATTERIES);
      put("get wire", Item.WIRE);
      put("get 18 gauge wire", Item.WIRE);
      put("get wires", Item.WIRE);
      put("get 18 gauge wires", Item.WIRE);
      put("get snare", Item.WIRE);
      put("get pot", Item.POT);
      put("get cooking pot", Item.POT);
      put("get axe", Item.AXE);
      put("get hatchet", Item.HATCHET);
      put("get iodine tablets", Item.IODINE_TABLETS);
      put("get iodine", Item.IODINE_TABLETS);
      put("get tablets", Item.IODINE_TABLETS);
      put("get pistol", Item.PISTOL);
      put("get gun", Item.PISTOL);
      put("get ammunition", Item.PISTOL_CARTRIDGES);
      put("get cartridges", Item.PISTOL_CARTRIDGES);
      put("get ammo", Item.PISTOL_CARTRIDGES);
      put("get rounds", Item.PISTOL_CARTRIDGES);
      put("get pistol ammo", Item.PISTOL_CARTRIDGES);
      put("get pistol ammunition", Item.PISTOL_CARTRIDGES);
      put("get pistol rounds", Item.PISTOL_CARTRIDGES);
      put("get pistol cartridges", Item.PISTOL_CARTRIDGES);
      put("get shovel", Item.SHOVEL);
      put("get harmonica", Item.HARMONICA);
      put("get lighter", Item.LIGHTER);
      put("get survival manual", Item.SURVIVAL_MANUAL);
      put("get manual", Item.SURVIVAL_MANUAL);
      put("get journal and pen", Item.JOURNAL);
      put("get journal", Item.JOURNAL);
      put("put fishing line", Item.FISHING_LINE);
      put("put fishing lines", Item.FISHING_LINE);
      put("put fishing hooks", Item.FISHING_HOOKS);
      put("put fishing hook", Item.FISHING_HOOKS);
      put("put fishing lure", Item.FISHING_LURES);
      put("put fishing lures", Item.FISHING_LURES);
      put("put knife", Item.KNIFE);
      put("put flint and steel", Item.FLINT_AND_STEEL);
      put("put bow", Item.BOW);
      put("put arrow", Item.ARROWS);
      put("put arrows", Item.ARROWS);
      put("put family photo", Item.FAMILY_PHOTO);
      put("put photo", Item.FAMILY_PHOTO);
      put("put photograph", Item.FAMILY_PHOTO);
      put("put rope", Item.PARACHUTE_CHORD);
      put("put parachute chord", Item.PARACHUTE_CHORD);
      put("put cordage", Item.PARACHUTE_CHORD);
      put("put flare", Item.FLARE);
      put("put flares", Item.FLARE);
      put("put extra boots", Item.EXTRA_BOOTS);
      put("put extra boot", Item.EXTRA_BOOTS);
      put("put boots", Item.EXTRA_BOOTS);
      put("put boot", Item.EXTRA_BOOTS);
      put("put extra pants", Item.EXTRA_PANTS);
      put("put pants", Item.EXTRA_PANTS);
      put("put sleeping gear", Item.SLEEPING_GEAR);
      put("put sleeping bag", Item.SLEEPING_GEAR);
      put("put cold weather gear", Item.COLD_WEATHER_GEAR);
      put("put cold gear", Item.COLD_WEATHER_GEAR);
      put("put tarp", Item.TARP);
      put("put matches", Item.MATCHES);
      put("put match", Item.MATCHES);
      put("put first aid", Item.FIRST_AID_KIT);
      put("put first aid kit", Item.FIRST_AID_KIT);
      put("put flashlight", Item.FLASHLIGHT);
      put("put light", Item.FLASHLIGHT);
      put("put batteries", Item.BATTERIES);
      put("put battery", Item.BATTERIES);
      put("put wire", Item.WIRE);
      put("put 18 gauge wire", Item.WIRE);
      put("put wires", Item.WIRE);
      put("put 18 gauge wires", Item.WIRE);
      put("put snare", Item.WIRE);
      put("put pot", Item.POT);
      put("put cooking pot", Item.POT);
      put("put axe", Item.AXE);
      put("put hatchet", Item.HATCHET);
      put("put iodine tablets", Item.IODINE_TABLETS);
      put("put iodine", Item.IODINE_TABLETS);
      put("put tablets", Item.IODINE_TABLETS);
      put("put pistol", Item.PISTOL);
      put("put gun", Item.PISTOL);
      put("put ammunition", Item.PISTOL_CARTRIDGES);
      put("put ammo", Item.PISTOL_CARTRIDGES);
      put("put pistol ammo", Item.PISTOL_CARTRIDGES);
      put("put pistol ammunition", Item.PISTOL_CARTRIDGES);
      put("put pistol rounds", Item.PISTOL_CARTRIDGES);
      put("put pistol cartridges", Item.PISTOL_CARTRIDGES);
      put("put cartridges", Item.PISTOL_CARTRIDGES);
      put("put rounds", Item.PISTOL_CARTRIDGES);
      put("put shovel", Item.SHOVEL);
      put("put harmonica", Item.HARMONICA);
      put("put lighter", Item.LIGHTER);
      put("put survival manual", Item.SURVIVAL_MANUAL);
      put("put manual", Item.SURVIVAL_MANUAL);
      put("put journal and pen", Item.JOURNAL);
      put("put journal", Item.JOURNAL);
    }};

    // uses input to build a choice by looking up keywords in a choice map
    // split up input into array of words
    String keyword;
    Food food;
    Item item;
    if (Optional.ofNullable(choiceKeywordMap.get(input.toLowerCase())).isPresent()) {
      keyword = Optional.ofNullable(choiceKeywordMap.get(input.toLowerCase())).get();
      if (keyword.equals("eat")) {
        if (Optional.ofNullable(choiceFoodMap.get(input.toLowerCase())).isPresent()) {
          food = Optional.ofNullable(choiceFoodMap.get(input.toLowerCase())).get();
          choice = new Choice(keyword, player, food);
        } else {
          choice = new Choice(keyword, player);
        }
      } else if (keyword.equals("get") || keyword.equals("put")) {
        if (Optional.ofNullable(choiceItemMap.get(input.toLowerCase())).isPresent()) {
          item = Optional.ofNullable(choiceItemMap.get(input.toLowerCase())).get();
          choice = new Choice(keyword, player, item);
        } else {
          choice = null;
        }
      } else {
        choice = new Choice(keyword, player);
      }
    } else {
      choice = null;
    }
    return choice;
  }

  public static Activity parseActivityChoice(Choice choice) {
    Activity activity;
    if (choice == null) {
      // display help menu
      activity = null;
    } else {
      if (choice.getKeyword().equals("get")) {
        activity = GetItemActivity.getInstance();
      } else if (choice.getKeyword().equals("put")) {
        activity = PutItemActivity.getInstance();
      } else if (choice.getKeyword().equals("eat")) {
        activity = EatActivity.getInstance();
      } else if (choice.getKeyword().equals("drink")) {
        activity = DrinkWaterActivity.getInstance();
      } else if (choice.getKeyword().equals("fish")) {
        activity = FishActivity.getInstance();
      } else if (choice.getKeyword().equals("hunt")) {
        activity = HuntActivity.getInstance();
      } else if (choice.getKeyword().equals("trap")) {
        activity = TrapActivity.getInstance();
      } else if (choice.getKeyword().equals("forage")) {
        activity = ForageActivity.getInstance();
      } else if (choice.getKeyword().equals("improve")) {
        activity = ImproveShelterActivity.getInstance();
      } else if (choice.getKeyword().equals("gather")) {
        activity = GatherFirewoodActivity.getInstance();
      } else if (choice.getKeyword().equals("fire")) {
        activity = BuildFireActivity.getInstance();
      } else if (choice.getKeyword().equals("water")) {
        activity = GetWaterActivity.getInstance();
      } else if (choice.getKeyword().equals("morale")) {
        activity = BoostMoraleActivity.getInstance();
      } else {
        activity = RestActivity.getInstance();
      }
    }
    return activity;
  }

}
