package com.lmagickl.tickratechangerrezurrection.config.forge;

import me.shedaniel.clothconfig2.api.ConfigBuilder;

public class ForgeTickrateChangerRezurrectionConfig {
  public static void init() {
    ConfigBuilder builder = ConfigBuilder.create()
        .setSavingRunnable(() -> {
          // Serialise the config into the config file. This will be called last after all
          // variables are updated.
        });
  }
}
