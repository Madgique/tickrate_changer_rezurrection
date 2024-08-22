package com.lmagickl.tickratechangerrezurrection;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dev.architectury.platform.Platform;

public class TickrateChangerRezurrectionConfig {
  public static void save() {
    File file = new File(Platform.getConfigFolder() + File.separator + TickrateChangerRezurrectionMod.MOD_ID + ".json");
    if (!file.exists()) {
      create(file);
    }
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    try {
      FileReader reader = new FileReader(file);
      TickrateChangerRezurrectionMod.CONFIG = gson.fromJson(reader, TickrateChangerRezurrectionConfig.class);
      reader.close();
    } catch (Exception e) {
      e.printStackTrace();
      create(file);
    }
  }

  private static void create(File file) {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    try {
      FileWriter fileWriter = new FileWriter(file);
      gson.toJson(TickrateChangerRezurrectionMod.CONFIG, fileWriter);
      fileWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
